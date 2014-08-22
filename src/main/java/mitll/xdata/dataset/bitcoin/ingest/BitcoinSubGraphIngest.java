/**
 * 
 */
package mitll.xdata.dataset.bitcoin.ingest;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;
import java.util.regex.Pattern;

import mitll.xdata.dataset.bitcoin.binding.BitcoinBinding;
import mitll.xdata.db.DBConnection;
import mitll.xdata.db.H2Connection;

import org.apache.commons.math3.stat.descriptive.DescriptiveStatistics;
import org.apache.log4j.Logger;

import uiuc.topksubgraph.Graph;
import uiuc.topksubgraph.MultipleIndexConstructor;
import uiuc.topksubgraph.QueryExecutor;

import org.apache.commons.lang.StringUtils;

/**
 * Re-creating func
 * 
 * @author ca22119
 * 
 */



public class BitcoinSubGraphIngest {
	
	private static final Logger logger = Logger.getLogger(BitcoinSubGraphIngest.class);
	
	private static final int MIN_TRANSACTIONS = 10;
	private static final int BITCOIN_OUTLIER = 25;
	private static final String TABLE_NAME = "transactions";
	private static final String GRAPH_TABLE = "MARGINAL_GRAPH";
	
	private static final String USERS = "users";
	private static final String TYPE_COLUMN = "type";
	private static final String USERID_COLUMN = "user";
	
	
	private static PreparedStatement queryStatement;
	
	/**
	 * @param args
	 */
	public static void main(String[] args) throws Throwable {
		

		
		/*
		 * All this should be wrapped in methods, and then put into BitcoinIngest
		 */
		
		/*
		 * This stuff is pre-processing the graph to prepare it for topk-subgraph ingest/indexing 
		 */
		//String bitcoinDirectory = "src/main/resources/bitcoin_small_feats_tsv/";
	    String bitcoinDirectory = "src/main/resources" + BitcoinBinding.BITCOIN_FEATS_TSV;
		
		DBConnection dbConnection = new H2Connection(bitcoinDirectory,"bitcoin");
	    
		// Filter-out non-active nodes, self-transitions, heavy-hitters
		filterForActivity(dbConnection);
		
		// Create marginalized graph data and various stats
		extractUndirectedGraph(dbConnection);
		
		/*
		 * Do the indexing for the topk-subgraph algorithm
		 */
		computeIndices(bitcoinDirectory, dbConnection);
		
		/*
		 * Do some querying based on some input graph
		 */
		executeQuery(bitcoinDirectory,dbConnection);
		
		
		
	}


	/**
	 * @param dbConnection
	 * @param tableName
	 */
	private static boolean existsTable(DBConnection dbConnection, String tableName) {
		try {
			ResultSet rs = doSQLQuery(dbConnection, "select 1 from "+tableName+" limit 1;");
			rs.close();
			return true;
		} catch (SQLException e) {
			return false;
		}
	}

	
	/**
	 * @throws FileNotFoundException
	 * @throws IOException
	 * @throws Throwable
	 * @throws NumberFormatException
	 */
	public static void executeQuery(String outDir, DBConnection connection) throws FileNotFoundException,
			IOException, Throwable, NumberFormatException {

	    /*
	     * Setup QueryExecutor object
	     */
		QueryExecutor executor = new QueryExecutor();
		
		QueryExecutor.datasetId = BitcoinBinding.DATASET_ID;
		executor.g = MultipleIndexConstructor.getGraph(); //this is assuming graph has already been loaded..
		QueryExecutor.baseDir=outDir;
		QueryExecutor.k0 = 2;
		QueryExecutor.topK=1000;

		QueryExecutor.spathFile=QueryExecutor.datasetId+"."+QueryExecutor.k0+".spath";
		QueryExecutor.topologyFile=QueryExecutor.datasetId+"."+QueryExecutor.k0+".topology"; ////////////////////
		QueryExecutor.spdFile=QueryExecutor.datasetId+"."+QueryExecutor.k0+".spd";
		QueryExecutor.resultDir="results";

		windowsPathnamePortabilityCheck();
		
		//String pattern = Pattern.quote(System.getProperty("file.separator"));
		String pattern = "/";
		String[] splitGraphFile = QueryExecutor.graphFile.split(pattern);
		QueryExecutor.graphFileBasename = splitGraphFile[splitGraphFile.length-1];
		
		
		/**
		 * Load-in types, and count how many there are
		 */
		executor.loadTypesFromDatabase(connection,USERS,USERID_COLUMN,TYPE_COLUMN);
	    logger.info("Loaded-in types...");
	    
		executor.loadGraphNodesType();		//compute ordering
		executor.loadGraphSignatures();		//topology
		executor.loadEdgeLists();			//sorted edge lists
		executor.loadSPDIndex();			//spd index
				
		//Make resultDir if necessary
		File directory = new File(QueryExecutor.baseDir+QueryExecutor.resultDir);
		if (!directory.exists() && !directory.mkdirs()) 
			throw new IOException("Could not create directory: " + QueryExecutor.baseDir+QueryExecutor.resultDir);
		


		
		/*
		 * Execute queries
		 */
		String[] queries = new String[]{"FanOut" , "FOFI"};
		for (int i=0; i<queries.length; i++) {
			
			/*
			 * Setup and read-in query
			 */
			QueryExecutor.queryFile="queries/queryGraph."+queries[i]+".txt";
			QueryExecutor.queryTypesFile="queries/queryTypes."+queries[i]+".txt";
			
			//set system out to out-file...
			System.setOut(new PrintStream(new File(QueryExecutor.baseDir+QueryExecutor.resultDir+
					"/QueryExecutor.topK="+QueryExecutor.topK+
					"_K0="+QueryExecutor.k0+
					"_"+QueryExecutor.datasetId+
					"_"+QueryExecutor.queryFile.split("/")[1])));
			
			
			int isClique = executor.loadQuery();

			/**
			 * Get query signatures
			 */
			executor.getQuerySignatures(); //fills in querySign

			/**
			 * NS Containment Check and Candidate Generation
			 */
			long time1=new Date().getTime();

			int prunedCandidateFiltering = executor.generateCandidates();
			if (prunedCandidateFiltering < 0) {
				return;
			}

			long timeA = new Date().getTime();
			System.out.println("Candidate Generation Time: " + (timeA - time1));


			/**
			 * Populate all required HashMaps relating edges to edge-types 
			 */
			// compute edge types for all edges in query
			HashSet<String> queryEdgeTypes = executor.computeQueryEdgeTypes();

			//compute queryEdgetoIndex
			executor.computeQueryEdge2Index();

			//compute queryEdgeType2Edges
			HashMap<String, ArrayList<String>> queryEdgeType2Edges = executor.computeQueryEdgeType2Edges();


			//Maintain pointers and topk heap
			executor.computePointers(queryEdgeTypes, queryEdgeType2Edges);

			/**
			 * The secret sauce... Execute the query...
			 */
			executor.executeQuery(queryEdgeType2Edges, isClique, prunedCandidateFiltering);

			long time2=new Date().getTime();
			System.out.println("Overall Time: "+(time2-time1));


			//FibonacciHeap<ArrayList<String>> queryResults = executor.getHeap();
			executor.printHeap();
		}
	}

	/**
	 * @param bitcoinDirectory
	 * @param dbConnection
	 * @throws Throwable
	 * @throws Exception
	 * @throws IOException
	 */
	private static void computeIndices(String bitcoinDirectory,
			DBConnection dbConnection) throws Throwable, Exception, IOException {
		/*
		 * This is stuff is doing the actual topk-subgraph indexing
		 */
		MultipleIndexConstructor.outDir=bitcoinDirectory;
	    MultipleIndexConstructor.D = BitcoinBinding.SHORTLISTING_D;
	   
		// Load graph into topk-subgraph Graph object
		Graph g = new Graph();
		g.loadGraph(dbConnection, "MARGINAL_GRAPH", "NUM_TRANS");
		MultipleIndexConstructor.setGraph(g);
	    logger.info("Loaded graph file...");
		
//	    //iterate through hashmap test
//	    int c=0;
//	    int max_val = 0;
//	    for (Integer key : g.node2NodeIdMap.keySet()) {
//	        if (g.node2NodeIdMap.get(key) > max_val) {
//	        	max_val = g.node2NodeIdMap.get(key);
//	        }
//	        c++;
//	    }
//	    logger.info("There are: "+c+" unique nodes in the graph...");
//	    logger.info("max internal-id val is..."+max_val);
	    
//		//Insert default type into users table... (this is actually now done in BitcoinFeatures)
//		String sqlInsertType = "alter table "+USERS+" drop if exists "+TYPE_COLUMN+";"+
//								" alter table "+USERS+" add "+TYPE_COLUMN+" int not null default(1);";
//		doSQLUpdate(dbConnection, sqlInsertType);
		
		
		// Load types into topk-subgraph object...
		MultipleIndexConstructor.loadTypesFromDatabase(dbConnection,USERS,USERID_COLUMN,TYPE_COLUMN);
	    logger.info("Loaded types file...");
	    logger.debug("Number of types: "+MultipleIndexConstructor.totalTypes);	
		
		// Create Typed Edges
		MultipleIndexConstructor.createTypedEdges();
		
		// Load and Sort Edges from Graph
		//MultipleIndexConstructor.loadAndSortEdges();
		MultipleIndexConstructor.populateSortedEdgeLists();
		
		//save the sorted edge lists
		MultipleIndexConstructor.saveSortedEdgeList();
		
		//hash map for all possible "edge-type" paths: i.e. doubles,triples,...D-tuples
		//this gets you the "official" ordering
		logger.info("Computing Edge-Type Path Ordering...");
		MultipleIndexConstructor.computeEdgeTypePathOrdering();
		
		logger.info("Computing SPD, Topology and SPath Indices...");
		MultipleIndexConstructor.computeIndices();
	}

	
	/**
	 * Find all unique edges and gather statistics about the activity between them.
	 * 
	 * The primary key in this table is the tuple "sorted_pair" which is a guid for each edge 
	 * where the accounts involved in a transaction are listed in numerical order; 
	 * e.g. (a,b) for all transactions between a and b, given a < b. 
	 * 
	 * The column "TOT_USD" sums the total amount transacted between a and b
	 * The column "NUM_TRANS" count the total number of transactions between a and b
	 * The column "TOT_OUT" sums the value of transactions from a->b
	 * The column "TOT_IN" sums the value of transactions from b->a 
	 * 
	 * @param connection
	 * @return
	 * @throws Exception
	 */
	private static void extractUndirectedGraph(DBConnection connection) throws Exception {
		
		/*
		 * Setup SQL statements
		 */
		String sqlGenerateSortedPairs = "alter table "+TABLE_NAME+" drop column if exists sorted_pair;" +
				 							" alter table "+TABLE_NAME+" add SORTED_PAIR array;" + 
											" update "+TABLE_NAME+ 		
											" set sorted_pair =" +
											" case when (source > target)" +
											" then (target,source) " +
											"else (source,target) end;";
		
		String sqlPopulateMarginalGraph = "drop table if exists "+GRAPH_TABLE+";" +
											" create table "+GRAPH_TABLE+" as " +
											" select sorted_pair, sum(usd) as TOT_USD, count(*) as NUM_TRANS" +
											" from "+TABLE_NAME+" group by sorted_pair;" +
											" alter table "+GRAPH_TABLE+" add TOT_OUT decimal(20,8);" +
											" alter table "+GRAPH_TABLE+" add TOT_IN decimal(20,8);";
		
		String sqlTotOutTemp = "drop table if exists tmp;" +
									" create temporary table tmp as select sorted_pair, sum(usd) as tot_out" +
									" from "+TABLE_NAME +
									" where (source < target)" +
									" group by sorted_pair;";

		String sqlUpdateTotOut = "update "+GRAPH_TABLE+" set tot_out =" +
									" (select tmp.tot_out" +
									" from tmp" +
									" where "+GRAPH_TABLE+".sorted_pair = tmp.sorted_pair);";

		String sqlTotInTemp = "drop table if exists tmp;" +
				" create temporary table tmp as select sorted_pair, sum(usd) as tot_in" +
				" from "+TABLE_NAME+
				" where (source > target)" +
				" group by sorted_pair;";

		String sqlUpdateTotIn = "update "+GRAPH_TABLE+" set tot_in =" +
				" (select tmp.tot_in" +
				" from tmp" +
				" where "+GRAPH_TABLE+".sorted_pair = tmp.sorted_pair);";
		
		String sqlDropTemp = "drop table tmp";
		
		doSQLUpdate(connection, sqlGenerateSortedPairs);
		doSQLUpdate(connection, sqlPopulateMarginalGraph);
		doSQLUpdate(connection, sqlTotOutTemp);
		doSQLUpdate(connection, sqlUpdateTotOut);
		doSQLUpdate(connection, sqlTotInTemp);
		doSQLUpdate(connection, sqlUpdateTotIn);
		doSQLUpdate(connection, sqlDropTemp);
	}

	/**
	 * Filter out accounts involved in fewer than {@link #MIN_TRANSACTIONS} so that
	 * the transactions table has only transactions involving accounts that transact 
	 * "frequently enough." Also creates a table containing all users and their total
	 * number of transactions, "USERS"
	 *
	 * NOTES:
	 * --Filter out self-to-self transactions
	 * --Throw out "supernode" #25
	 * 
	 * @param connection
	 * @return
	 * @throws Exception
	 */
	private static void filterForActivity(DBConnection connection) throws Exception {
		
		/*
		 * Setup SQL queries
		 */
		String sqlRemoveAccount = "delete from "+TABLE_NAME+" where"+
				" (source = "+BITCOIN_OUTLIER+") or"+ 
				" (target  = "+BITCOIN_OUTLIER+");";
		
		String sqlRemoveSelfTrans = "delete from "+TABLE_NAME+" where (source = target);";

		String sqlFindInactive = 
				"drop table if exists inactive;" +
						" create table inactive as" +
						" select uid, sum(cnt) as tot_count from" + 
						" (select source as uid, count(*) as cnt from " + TABLE_NAME +
						" group by source" +
						" union" +
						" select target as uid, count(*) as cnt from " + TABLE_NAME +
						" group by target order by uid) as tbl" +
						" group by uid having tot_count < "+MIN_TRANSACTIONS+";";
		
		String sqlCountInactive = "select count(*) as cnt from inactive;";
		
		String sqlRemoveInactiveAccounts = "delete from "+TABLE_NAME+" where"+
				" (source in (select distinct uid from inactive)) or"+
				" (target in (select distinct uid from inactive));";
		
		String sqlDeleteInactiveUsers = "delete from "+BitcoinBinding.USER_FEATURES_TABLE+
				" where user not in"+
				" (select source from "+TABLE_NAME+" union select target from "+TABLE_NAME+");";
		
		/*
		 * Do some initial clean-up
		 */
		doSQLUpdate(connection, sqlRemoveAccount);
		doSQLUpdate(connection, sqlRemoveSelfTrans);
		
		/*
		 * Find and remove non-active accounts until only active accounts remain in transactions table 
		 */
		int numInactive = 1;
		while (numInactive != 0) {
			//find inactive
			doSQLUpdate(connection, sqlFindInactive); 

			//how many inactive accounts
			ResultSet rs = doSQLQuery(connection, sqlCountInactive); rs.next();
			numInactive = rs.getInt("CNT");
			logger.info("number of inactive acounts in "+TABLE_NAME+": "+numInactive);
			queryStatement.close();			
			
			//remove all inactive accounts
			doSQLUpdate(connection, sqlRemoveInactiveAccounts);
			
		}
		
		//update user feature table to reflect filtering...
		if (existsTable(connection,BitcoinBinding.USER_FEATURES_TABLE)) {
			doSQLUpdate(connection, sqlDeleteInactiveUsers);
		} else {
			logger.info("table "+BitcoinBinding.USER_FEATURES_TABLE+" does not yet exist.");
		}
		
		//cleanup
		doSQLUpdate(connection, "drop table inactive");
		
		
	}	
	
	/**
	 * Do SQL, update something, return nothing
	 * 
	 * @param connection
	 * @param createSQL
	 * @throws SQLException
	 */
	private static void doSQLUpdate(DBConnection connection, String createSQL) throws SQLException {
		Connection connection1 = connection.getConnection();
		PreparedStatement statement = connection1.prepareStatement(createSQL);
		statement.executeUpdate();
		statement.close();
	}

	/**
	 * Do SQL, query something, return that something
	 * 
	 * @param connection
	 * @param createSQL
	 * @return
	 * @throws SQLException
	 */
	private static ResultSet doSQLQuery(DBConnection connection, String createSQL) throws SQLException {
		Connection connection1 = connection.getConnection();
		//PreparedStatement statement = connection1.prepareStatement(createSQL);
		queryStatement = connection1.prepareStatement(createSQL);
		ResultSet rs = queryStatement.executeQuery();
		//statement.close();
		
		return rs;
	}	
	
	/**
	 * If we're on Windows, convert file-separators to "/"
	 * (this should probably be in an utilities package at some point)
	 */
	private static void windowsPathnamePortabilityCheck() {
		String osName = System.getProperty("os.name");

		if (osName.startsWith("Windows")) {
			String separator = Pattern.quote(System.getProperty("file.separator"));

			QueryExecutor.baseDir=QueryExecutor.baseDir.replace(separator, "/");
			QueryExecutor.graphFile=QueryExecutor.graphFile.replace(separator, "/");
			QueryExecutor.typesFile=QueryExecutor.typesFile.replace(separator, "/");
			QueryExecutor.queryFile=QueryExecutor.queryFile.replace(separator, "/");
			QueryExecutor.queryTypesFile=QueryExecutor.queryTypesFile.replace(separator, "/");
			QueryExecutor.spathFile=QueryExecutor.spathFile.replace(separator, "/");
			QueryExecutor.topologyFile=QueryExecutor.topologyFile.replace(separator, "/");
			QueryExecutor.spdFile=QueryExecutor.spdFile.replace(separator, "/");
			QueryExecutor.resultDir=QueryExecutor.resultDir.replace(separator, "/");
		}
	}
	
}

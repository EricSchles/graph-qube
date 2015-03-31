/**
 * Autogenerated by Avro
 * 
 * DO NOT EDIT DIRECTLY
 */
package influent.idl;

@SuppressWarnings("all")
/** * Services for geocoding. */
@org.apache.avro.specific.AvroGenerated
public interface FL_Geocoding {
  public static final org.apache.avro.Protocol PROTOCOL = org.apache.avro.Protocol.parse("{\"protocol\":\"FL_Geocoding\",\"namespace\":\"influent.idl\",\"doc\":\"* Services for geocoding.\",\"types\":[{\"type\":\"enum\",\"name\":\"FL_RequiredPropertyKey\",\"doc\":\"* A list of the required property keys that are reserved by the system and should be included as\\r\\n\\t * the keys in FL_PropertyMatchDescriptors. Keys are case sensitive.\\r\\n\\t *\\r\\n\\t * ADDED IN 2.0\",\"symbols\":[\"NAME\",\"ID\",\"FROM\",\"TO\",\"DATE\",\"AMOUNT\",\"ENTITY\",\"LINKED\",\"TYPE\"]},{\"type\":\"enum\",\"name\":\"FL_ReservedPropertyKey\",\"doc\":\"* A list of case sensitive keys which are reserved keywords in search.\\r\\n\\t *\\r\\n\\t * ADDED IN 2.0\",\"symbols\":[\"TYPE\",\"ORDER\",\"MATCH\",\"SCORE\"]},{\"type\":\"enum\",\"name\":\"FL_PropertyTag\",\"doc\":\"* Tags are defined by the application layer as a taxonomy of user and application concepts,\\r\\n\\t * independent of the data sources. This allows application semantics to be re-used with new\\r\\n\\t * data, with a minimum of new software design and development. Data layer entity types, link\\r\\n\\t * types and properties should be mapped into the list of tags. The application layer must be\\r\\n\\t * able to search by native field name or by tag interchangeably, and properties returned must\\r\\n\\t * contain both native field names as well as tags.\\r\\n\\t *\\r\\n\\t * The list of tags may change as application features evolve, though that will require\\r\\n\\t * collaboration with the data layer providers. Evolving the tag list should not change the\\r\\n\\t * Data Access or Search APIs.\\r\\n\\t *\\r\\n\\t * This is the current list of tags for Properties:\\r\\n\\t *\\r\\n\\t * CHANGED in 1.5:\\r\\n\\t * - CREDIT/DEBIT changed to INFLOWING/OUTFLOWING\\r\\n\\t * - added USD\\r\\n\\t * - added DURATION\\r\\n\\t *\\r\\n\\t * CHANGED in 1.6:\\r\\n\\t * - added ENTITY_TYPE\\r\\n\\t * - added ACCOUNT_OWNER, CLUSTER_SUMMARY, COUNTRY_CODE\\r\\n\\t *\\r\\n\\t * CHANGED in 1.7:\\r\\n\\t * - added CLUSTER\\r\\n\\t *\\r\\n\\t * CHANGED in 1.8:\\r\\n\\t * - added TOPIC\\r\\n\\t *\\r\\n\\t * CHANGED in 1.9:\\r\\n\\t * - added HTML\\r\\n\\t *\\r\\n\\t * CHANGED in 2.0:\\r\\n\\t * - added UNITS\",\"symbols\":[\"ID\",\"TYPE\",\"ENTITY_TYPE\",\"ACCOUNT_OWNER\",\"CLUSTER_SUMMARY\",\"CLUSTER\",\"NAME\",\"LABEL\",\"STAT\",\"TEXT\",\"HTML\",\"TOPIC\",\"STATUS\",\"ANNOTATION\",\"WARNING\",\"LINKED_DATA\",\"GEO\",\"COUNTRY_CODE\",\"DATE\",\"AMOUNT\",\"INFLOWING\",\"OUTFLOWING\",\"COUNT\",\"SERIES\",\"CONSTRUCTED\",\"RAW\",\"UNITS\",\"USD\",\"DURATION\",\"ENTITY\",\"SHARED_IDENTIFIER\"]},{\"type\":\"enum\",\"name\":\"FL_EntityTag\",\"doc\":\"* This is the current list of tags for Entities:\\r\\n\\t *\\r\\n\\t * CHANGED in 1.6:\\r\\n\\t * - added ACCOUNT_OWNER, CLUSTER_SUMMARY\\r\\n\\t *\\r\\n\\t * CHANGED in 1.7:\\r\\n\\t * - added PROMPT_FOR_DETAILS\\r\\n\\t *\\r\\n\\t * CHANGED in 1.8:\\r\\n\\t * - added UNBRANCHABLE\",\"symbols\":[\"ACCOUNT_OWNER\",\"ACCOUNT\",\"GROUP\",\"CLUSTER\",\"CLUSTER_SUMMARY\",\"FILE\",\"ANONYMOUS\",\"UNBRANCHABLE\",\"PROMPT_FOR_DETAILS\",\"OTHER\"]},{\"type\":\"enum\",\"name\":\"FL_PropertyType\",\"doc\":\"* Allowed types for Property values.\\r\\n\\t *\\r\\n\\t * CHANGED in 1.9\",\"symbols\":[\"FLOAT\",\"DOUBLE\",\"INTEGER\",\"LONG\",\"BOOLEAN\",\"STRING\",\"IMAGE\",\"DATE\",\"GEO\"]},{\"type\":\"enum\",\"name\":\"FL_LevelOfDetail\",\"doc\":\"* Amount of detail requested\\r\\n\\t *\\r\\n\\t * ADDED IN 1.6\\r\\n\\t *\\r\\n\\t * CHANGED in 2.0:\\r\\n\\t * - added KEY\",\"symbols\":[\"KEY\",\"SUMMARY\",\"FULL\",\"HIDDEN\"]},{\"type\":\"enum\",\"name\":\"FL_ContinentCode\",\"doc\":\"* Standard two letter continent code\\r\\n\\t *\\r\\n\\t * ADDED IN 1.6\",\"symbols\":[\"AF\",\"AS\",\"EU\",\"NA\",\"SA\",\"OC\",\"AN\"]},{\"type\":\"enum\",\"name\":\"FL_DateInterval\",\"doc\":\"* Temporal resolution of a duration\\r\\n\\t *\\r\\n\\t * CHANGED IN 1.5\",\"symbols\":[\"SECONDS\",\"HOURS\",\"DAYS\",\"WEEKS\",\"MONTHS\",\"QUARTERS\",\"YEARS\"]},{\"type\":\"enum\",\"name\":\"FL_RangeType\",\"doc\":\"* Allowed types for Ranges of values.\\r\\n\\t *\\r\\n\\t * CHANGED IN 1.6\",\"symbols\":[\"SINGLETON\",\"LIST\",\"BOUNDED\",\"DISTRIBUTION\"]},{\"type\":\"enum\",\"name\":\"FL_Constraint\",\"doc\":\"* Property value matching constraints\\r\\n\\t *\\r\\n\\t * ADDED IN 1.5\\r\\n\\t * MOVED IN 2.0\",\"symbols\":[\"REQUIRED_EQUALS\",\"FUZZY_PARTIAL_OPTIONAL\",\"NOT\",\"OPTIONAL_EQUALS\",\"FUZZY_REQUIRED\"]},{\"type\":\"enum\",\"name\":\"FL_SearchableBy\",\"doc\":\"* Used to describe in which contexts a term can (or should) be searched. Free text searches\\r\\n\\t * do not describe properties to which they apply, and are often best restricted to\\r\\n\\t * identity fields like names.\\r\\n\\t *\\r\\n\\t * ADDED IN 1.8\\r\\n\\t * MOVED IN 2.0\",\"symbols\":[\"FREE_TEXT\",\"DESCRIPTOR\",\"NONE\"]},{\"type\":\"enum\",\"name\":\"FL_DirectionFilter\",\"doc\":\"* Direction of desired links\",\"symbols\":[\"SOURCE\",\"DESTINATION\",\"BOTH\"]},{\"type\":\"enum\",\"name\":\"FL_LinkEntityTypeFilter\",\"doc\":\"* Type of entity associated with desired links\\r\\n\\t *\\r\\n\\t * ADDED IN 1.6\",\"symbols\":[\"ACCOUNT_OWNER\",\"ACCOUNT\",\"CLUSTER_SUMMARY\",\"ANY\"]},{\"type\":\"enum\",\"name\":\"FL_PathMatchTag\",\"doc\":\"* In addition to PropertyTags, a PropertyMatchDescriptor might also be one of these.\\r\\n\\t *\\r\\n\\t * ADDED IN 1.5\",\"symbols\":[\"PATH_LENGTH\",\"PATH_TIME\",\"PATH_SOURCES\",\"PATH_DESTS\"]},{\"type\":\"enum\",\"name\":\"FL_PersistenceState\",\"doc\":\"* Persistence save state\",\"symbols\":[\"NEW\",\"MODIFIED\",\"NONE\",\"ERROR\"]},{\"type\":\"record\",\"name\":\"FL_Provenance\",\"doc\":\"* This is a placeholder for future modeling of provenance. It is not a required field in any service calls.\",\"fields\":[{\"name\":\"uri\",\"type\":{\"type\":\"string\",\"avro.java.string\":\"String\"},\"doc\":\"Placeholder for now. Express provenance as a single URI.\"}]},{\"type\":\"record\",\"name\":\"FL_Uncertainty\",\"doc\":\"* This is a placeholder for future modeling of uncertainty. It is not a required field in any service calls.\\r\\n\\t *\\r\\n\\t * CHANGED IN 1.6\",\"fields\":[{\"name\":\"confidence\",\"type\":\"double\",\"doc\":\"Placeholder for now. Express original source confidence as a single number from 0 to 1.\",\"default\":1},{\"name\":\"currency\",\"type\":\"double\",\"doc\":\"Placeholder for now. Express confidence in currency of data as a single number from 0 to 1.\",\"default\":1}]},{\"type\":\"record\",\"name\":\"FL_LinkedData\",\"doc\":\"* A URL and MIME type representing a pointer to text, image or other external resource.\",\"fields\":[{\"name\":\"url\",\"type\":{\"type\":\"string\",\"avro.java.string\":\"String\"},\"doc\":\"URL of the resource\"},{\"name\":\"mimeType\",\"type\":[\"null\",{\"type\":\"string\",\"avro.java.string\":\"String\"}],\"doc\":\"MIME type of the resource\",\"default\":null},{\"name\":\"title\",\"type\":[\"null\",{\"type\":\"string\",\"avro.java.string\":\"String\"}],\"doc\":\"description of the linked resource (suitable for display to the user in an hypertext link)\",\"default\":null}]},{\"type\":\"record\",\"name\":\"FL_GeoData\",\"doc\":\"* Structured representation of geo-spatial data.\",\"fields\":[{\"name\":\"text\",\"type\":[\"null\",{\"type\":\"string\",\"avro.java.string\":\"String\"}],\"doc\":\"an address or other place reference; unstructured text field\",\"default\":null},{\"name\":\"lat\",\"type\":[\"double\",\"null\"],\"doc\":\"latitude\",\"default\":null},{\"name\":\"lon\",\"type\":[\"double\",\"null\"],\"doc\":\"longitude\",\"default\":null},{\"name\":\"cc\",\"type\":[\"null\",{\"type\":\"string\",\"avro.java.string\":\"String\"}],\"doc\":\"ISO 3 digit country code\",\"default\":null}]},{\"type\":\"record\",\"name\":\"FL_Country\",\"doc\":\"* Structured representation of country data, which includes geo-spatial data.\\r\\n\\t *\\r\\n\\t * ADDED IN 1.6\",\"fields\":[{\"name\":\"country\",\"type\":\"FL_GeoData\",\"doc\":\"country geo data, including the name as text\"},{\"name\":\"region\",\"type\":{\"type\":\"string\",\"avro.java.string\":\"String\"},\"doc\":\"the name of the global region to which the country belongs; any common classification here is acceptable\"},{\"name\":\"continent\",\"type\":\"FL_ContinentCode\",\"doc\":\"continent\"}]},{\"type\":\"record\",\"name\":\"FL_Duration\",\"doc\":\"* A temporal duration\\r\\n\\t *\\r\\n\\t * ADDED IN 1.5\",\"fields\":[{\"name\":\"interval\",\"type\":\"FL_DateInterval\",\"doc\":\"time aggregation level, e.g. use monthly data\"},{\"name\":\"numIntervals\",\"type\":\"long\",\"doc\":\"number of intervals, e.g. 12 monthly intervals is a 1 year duration\"}]},{\"type\":\"record\",\"name\":\"FL_DateRange\",\"doc\":\"* Describes a date range at a specific resolution.\\r\\n\\t *\\r\\n\\t * CHANGED IN 1.5\",\"fields\":[{\"name\":\"startDate\",\"type\":\"long\"},{\"name\":\"numBins\",\"type\":\"long\",\"doc\":\"number of bins to return, e.g. 12 monthly bins for 1 year of data\"},{\"name\":\"durationPerBin\",\"type\":\"FL_Duration\",\"doc\":\"number of intervals in a bin, e.g. 2 months/bin in 12 bins for 2 years of data\"}]},{\"type\":\"record\",\"name\":\"FL_SingletonRange\",\"doc\":\"* Single value\\r\\n\\t *\\r\\n\\t * ADDED IN 1.5\",\"fields\":[{\"name\":\"value\",\"type\":[{\"type\":\"string\",\"avro.java.string\":\"String\"},\"int\",\"float\",\"double\",\"long\",\"boolean\",\"FL_GeoData\"]},{\"name\":\"type\",\"type\":\"FL_PropertyType\",\"doc\":\"One of STRING, INTEGER, FLOAT, DOUBLE, LONG, BOOLEAN, DATE, GEO, IMAGE\"}]},{\"type\":\"record\",\"name\":\"FL_ListRange\",\"doc\":\"* List of values\\r\\n\\t *\\r\\n\\t * ADDED IN 1.5\",\"fields\":[{\"name\":\"values\",\"type\":{\"type\":\"array\",\"items\":[{\"type\":\"string\",\"avro.java.string\":\"String\"},\"int\",\"float\",\"double\",\"long\",\"boolean\",\"FL_GeoData\"]}},{\"name\":\"type\",\"type\":\"FL_PropertyType\",\"doc\":\"One of STRING, INTEGER, FLOAT, DOUBLE, LONG, BOOLEAN, DATE, GEO\"}]},{\"type\":\"record\",\"name\":\"FL_BoundedRange\",\"doc\":\"* Bounded or unbounded range values\\r\\n\\t *\\r\\n\\t * ADDED IN 1.5\",\"fields\":[{\"name\":\"start\",\"type\":[{\"type\":\"string\",\"avro.java.string\":\"String\"},\"int\",\"float\",\"double\",\"long\",\"boolean\",\"FL_GeoData\",\"null\"],\"doc\":\"start of range, or null if unbounded start\"},{\"name\":\"end\",\"type\":[{\"type\":\"string\",\"avro.java.string\":\"String\"},\"int\",\"float\",\"double\",\"long\",\"boolean\",\"FL_GeoData\",\"null\"],\"doc\":\"end of range, or null if unbounded start\"},{\"name\":\"inclusive\",\"type\":\"boolean\",\"doc\":\"If true, range includes specified endpoint. If false, range is exclusive.\"},{\"name\":\"type\",\"type\":\"FL_PropertyType\",\"doc\":\"One of STRING, INTEGER, FLOAT, DOUBLE, LONG, BOOLEAN, DATE, GEO\"}]},{\"type\":\"record\",\"name\":\"FL_Frequency\",\"doc\":\"* A frequency or probability element of a distribution.\\r\\n\\t *\\r\\n\\t * ADDED IN 1.6\",\"fields\":[{\"name\":\"range\",\"type\":[{\"type\":\"string\",\"avro.java.string\":\"String\"},\"int\",\"float\",\"double\",\"long\",\"boolean\",\"FL_GeoData\",\"FL_ListRange\",\"FL_BoundedRange\"],\"doc\":\"the value range which occurs with some specified frequency\"},{\"name\":\"frequency\",\"type\":\"double\",\"doc\":\"frequency as a count, or probability as a value from 0-1.\"}]},{\"type\":\"record\",\"name\":\"FL_DistributionRange\",\"doc\":\"* Describes a distribution of values.\\r\\n\\t *\\r\\n\\t * ADDED IN 1.6\",\"fields\":[{\"name\":\"distribution\",\"type\":{\"type\":\"array\",\"items\":\"FL_Frequency\"}},{\"name\":\"rangeType\",\"type\":\"FL_RangeType\",\"doc\":\"Describes how the values in the distribution are summarised\"},{\"name\":\"type\",\"type\":\"FL_PropertyType\",\"doc\":\"The type of value that the distribution describes. One of STRING, INTEGER, FLOAT, DOUBLE, LONG, BOOLEAN, DATE, GEO\"},{\"name\":\"isProbability\",\"type\":\"boolean\",\"doc\":\"True if a probability distribution, false if a frequency distribution\",\"default\":false}]},{\"type\":\"record\",\"name\":\"FL_Property\",\"doc\":\"* Each property on an Entity or Link is a name-value pair, with data type information, as well as optional\\r\\n\\t * provenance. Tags provide a way for the data provider to associate semantic annotations to each property\\r\\n\\t * in terms of the semantics of the application.\\r\\n\\t *\\r\\n\\t * CHANGED IN 1.6\",\"fields\":[{\"name\":\"key\",\"type\":{\"type\":\"string\",\"avro.java.string\":\"String\"},\"doc\":\"the field name in the underlying data source\"},{\"name\":\"friendlyText\",\"type\":[\"null\",{\"type\":\"string\",\"avro.java.string\":\"String\"}],\"doc\":\"user-friendly short-text for key (displayable)\",\"default\":null},{\"name\":\"range\",\"type\":[\"FL_SingletonRange\",\"FL_ListRange\",\"FL_BoundedRange\",\"FL_DistributionRange\"],\"doc\":\"range of values\",\"default\":null},{\"name\":\"provenance\",\"type\":[\"null\",\"FL_Provenance\"],\"default\":null},{\"name\":\"uncertainty\",\"type\":[\"null\",\"FL_Uncertainty\"],\"default\":null},{\"name\":\"tags\",\"type\":{\"type\":\"array\",\"items\":\"FL_PropertyTag\"},\"doc\":\"one or more tags from the Tag list, used to map this source-specific field into the semantics of applications\"},{\"name\":\"isHidden\",\"type\":\"boolean\",\"doc\":\"true if this property is hidden from the client\",\"default\":false}]},{\"type\":\"record\",\"name\":\"FL_Entity\",\"doc\":\"* The nodes in the social, financial, communications or other graphs. May represent concrete individuals or organizations,\\r\\n\\t * specific proxies such as accounts, or the implicit individuals or groups behind those other entities.\",\"fields\":[{\"name\":\"uid\",\"type\":{\"type\":\"string\",\"avro.java.string\":\"String\"},\"doc\":\"This uid must represent either (1) a globally unique identifier that can be used to retrieve data for an\\r\\n\\t\\t\\texplicit entity, or (2) encoded query information that can be used to find a set of associated record\\r\\n\\t\\t\\tnotionally representing an implicit entity (e.g. Loans&FirstName&LastName&Gender). Must not be used for\\r\\n\\t\\t\\tIDs that aren't globally unique.  For example, in Kiva, \\\"Lenders\\\" has a UID (\\\"L12345\\\") while \\\"Borrowers\\\"\\r\\n\\t\\t\\thave an encoded search in the Loans table for uid (\\\"B{loan:23456;name=Daniel}\\\").  The encoded information\\r\\n\\t\\t\\tis data layer-specific, may be different from entity to entity or data set to data set, and should be\\r\\n\\t\\t\\tconsidered opaque to the consumers of the entities.  Entities of type 2 should always have the Entity Tag\\r\\n\\t\\t\\tANONYMOUS to help distinguish them when required.\"},{\"name\":\"type\",\"type\":[{\"type\":\"string\",\"avro.java.string\":\"String\"},\"null\"],\"doc\":\"type\"},{\"name\":\"tags\",\"type\":{\"type\":\"array\",\"items\":\"FL_EntityTag\"},\"doc\":\"Entity Tags (see above, e.g. \\\"ACCOUNT\\\")\"},{\"name\":\"provenance\",\"type\":[\"FL_Provenance\",\"null\"],\"default\":null},{\"name\":\"uncertainty\",\"type\":[\"FL_Uncertainty\",\"null\"],\"default\":null},{\"name\":\"properties\",\"type\":{\"type\":\"array\",\"items\":\"FL_Property\"}}]},{\"type\":\"record\",\"name\":\"FL_Link\",\"doc\":\"* The links in the social, financial, communications or other graphs. May represent communication\\r\\n\\t * events, financial transactions or social connections.\",\"fields\":[{\"name\":\"uid\",\"type\":{\"type\":\"string\",\"avro.java.string\":\"String\"},\"doc\":\"This uid must represent either (1) a globally unique identifier that can be used to retrieve data for an\\r\\n\\t\\t\\texplicit link, or (2) encoded query information that can be used to find a set of associated record\\r\\n\\t\\t\\tnotionally representing an implicit link (e.g. Source&Target&Date&Amount). Must not be used for\\r\\n\\t\\t\\tIDs that aren't globally unique.\"},{\"name\":\"linkTypes\",\"type\":[{\"type\":\"array\",\"items\":{\"type\":\"string\",\"avro.java.string\":\"String\"}},\"null\"],\"doc\":\"link types\",\"default\":null},{\"name\":\"source\",\"type\":[\"null\",{\"type\":\"string\",\"avro.java.string\":\"String\"}],\"doc\":\"source entity uid\",\"default\":null},{\"name\":\"target\",\"type\":[\"null\",{\"type\":\"string\",\"avro.java.string\":\"String\"}],\"doc\":\"target entity uid\",\"default\":null},{\"name\":\"type\",\"type\":[{\"type\":\"string\",\"avro.java.string\":\"String\"},\"null\"],\"doc\":\"type\"},{\"name\":\"directed\",\"type\":\"boolean\",\"doc\":\"true if directed, false if undirected\",\"default\":true},{\"name\":\"provenance\",\"type\":[\"FL_Provenance\",\"null\"],\"default\":null},{\"name\":\"uncertainty\",\"type\":[\"FL_Uncertainty\",\"null\"],\"default\":null},{\"name\":\"properties\",\"type\":{\"type\":\"array\",\"items\":\"FL_Property\"}}]},{\"type\":\"record\",\"name\":\"FL_Cluster\",\"doc\":\"* Cluster of nodes in the social, financial, communications or other graphs.\\r\\n\\t *\\r\\n\\t * CHANGED in 1.7:\\r\\n\\t * \\t- added version\",\"fields\":[{\"name\":\"uid\",\"type\":{\"type\":\"string\",\"avro.java.string\":\"String\"},\"doc\":\"A unique identifier use to retrieve data about this cluster. Should not be used for non-global identifiers.\"},{\"name\":\"tags\",\"type\":{\"type\":\"array\",\"items\":\"FL_EntityTag\"},\"doc\":\"Entity Tags (see DataTypes, e.g. \\\"CLUSTER\\\")\"},{\"name\":\"provenance\",\"type\":[\"FL_Provenance\",\"null\"],\"default\":null},{\"name\":\"uncertainty\",\"type\":[\"FL_Uncertainty\",\"null\"],\"default\":null},{\"name\":\"properties\",\"type\":{\"type\":\"array\",\"items\":\"FL_Property\"}},{\"name\":\"members\",\"type\":{\"type\":\"array\",\"items\":{\"type\":\"string\",\"avro.java.string\":\"String\"}},\"doc\":\"List of id's of the members of this cluster\"},{\"name\":\"subclusters\",\"type\":{\"type\":\"array\",\"items\":{\"type\":\"string\",\"avro.java.string\":\"String\"}},\"doc\":\"List of id's of the subclusters of this cluster - empty if this is a leaf cluster in cluster hierarchy\"},{\"name\":\"parent\",\"type\":[\"null\",{\"type\":\"string\",\"avro.java.string\":\"String\"}],\"doc\":\"The id of the parent cluster if this is a cluster in a hierarchy - Can be null if this is a root cluster *\",\"default\":null},{\"name\":\"root\",\"type\":[\"null\",{\"type\":\"string\",\"avro.java.string\":\"String\"}],\"doc\":\"The id of the root cluster (top level cluster) if this is a cluster in a hierarchy - Can be null if this is a root cluster *\",\"default\":null},{\"name\":\"level\",\"type\":\"int\",\"doc\":\"The degree from the root this cluster is in the hierarchy - level = 0 if this is a root cluster *\",\"default\":0},{\"name\":\"version\",\"type\":\"int\",\"doc\":\"The version number of the cluster - each time the cluster contents is modified the version should be incremented *\",\"default\":1}]},{\"type\":\"record\",\"name\":\"FL_Future\",\"doc\":\"* Represents the future results of an asynchronous task.\\r\\n\\t * Can be passed into the FutureResults service API\",\"fields\":[{\"name\":\"uid\",\"type\":{\"type\":\"string\",\"avro.java.string\":\"String\"},\"doc\":\"unique id of this task\"},{\"name\":\"label\",\"type\":{\"type\":\"string\",\"avro.java.string\":\"String\"},\"doc\":\"short human-readable description of task for display\"},{\"name\":\"service\",\"type\":[\"null\",{\"type\":\"string\",\"avro.java.string\":\"String\"}],\"doc\":\"uid of the service task is running on\",\"default\":null},{\"name\":\"started\",\"type\":\"long\",\"doc\":\"date/time task was started\"},{\"name\":\"completed\",\"type\":\"long\",\"doc\":\"date/time task was completed (negative if not completed yet)\",\"default\":-1}]},{\"type\":\"record\",\"name\":\"FL_Service\",\"doc\":\"* Selectable services, returned by getServices() in various APIs\",\"fields\":[{\"name\":\"uid\",\"type\":{\"type\":\"string\",\"avro.java.string\":\"String\"},\"doc\":\"unique id of this service\"},{\"name\":\"label\",\"type\":{\"type\":\"string\",\"avro.java.string\":\"String\"},\"doc\":\"short human-readable description of service for display\"}]},{\"type\":\"record\",\"name\":\"FL_OrderBy\",\"doc\":\"* Ordering instructions for records, as specified in search requests.\\r\\n\\t *\\r\\n\\t * ADDED IN 2.0\",\"fields\":[{\"name\":\"propertyKey\",\"type\":{\"type\":\"string\",\"avro.java.string\":\"String\"},\"doc\":\"The key of the property value to order by\"},{\"name\":\"ascending\",\"type\":\"boolean\",\"doc\":\"ascending? (or descending)\",\"default\":false}]},{\"type\":\"record\",\"name\":\"FL_TypeMapping\",\"doc\":\"* Used to describe how an FL_PropertyDescriptor maps to given a type.\\r\\n\\t *\\r\\n\\t * ADDED IN 1.8\",\"fields\":[{\"name\":\"type\",\"type\":{\"type\":\"string\",\"avro.java.string\":\"String\"},\"doc\":\"The type that the mapping applies to *\"},{\"name\":\"memberKey\",\"type\":{\"type\":\"string\",\"avro.java.string\":\"String\"},\"doc\":\"field that the FL_Property maps to in the type *\"}]},{\"type\":\"record\",\"name\":\"FL_DataSummary\",\"doc\":\"* Data summary information\\r\\n\\t *\\r\\n\\t * Added in 1.8\",\"fields\":[{\"name\":\"key\",\"type\":[{\"type\":\"string\",\"avro.java.string\":\"String\"},\"null\"]},{\"name\":\"label\",\"type\":[{\"type\":\"string\",\"avro.java.string\":\"String\"},\"null\"]},{\"name\":\"value\",\"type\":[{\"type\":\"string\",\"avro.java.string\":\"String\"},\"null\"]}]}],\"messages\":{\"geocode\":{\"doc\":\"* Geocodes the specified locations, populating missing properties in place.\\r\\n\\t *\\r\\n\\t * @param locations     the locations to geocode.\",\"request\":[{\"name\":\"locations\",\"type\":{\"type\":\"array\",\"items\":\"FL_GeoData\"}}],\"response\":\"boolean\"},\"getCountries\":{\"doc\":\"* Returns a list of country objects for the previously geolocated locations specified, based\\r\\n\\t * on country code.\\r\\n\\t *\\r\\n\\t * @param locations     the locations to lookup, which must contain a country code.\\r\\n\\t * @return \\t\\t\\t    a list of geocoded countries, in the same order as requested.\",\"request\":[{\"name\":\"locations\",\"type\":{\"type\":\"array\",\"items\":\"FL_GeoData\"}}],\"response\":{\"type\":\"array\",\"items\":\"FL_Country\"}}}}");
  /** * Geocodes the specified locations, populating missing properties in place.
	 *
	 * @param locations     the locations to geocode. */
  boolean geocode(java.util.List<influent.idl.FL_GeoData> locations) throws org.apache.avro.AvroRemoteException;
  /** * Returns a list of country objects for the previously geolocated locations specified, based
	 * on country code.
	 *
	 * @param locations     the locations to lookup, which must contain a country code.
	 * @return 			    a list of geocoded countries, in the same order as requested. */
  java.util.List<influent.idl.FL_Country> getCountries(java.util.List<influent.idl.FL_GeoData> locations) throws org.apache.avro.AvroRemoteException;

  @SuppressWarnings("all")
  /** * Services for geocoding. */
  public interface Callback extends FL_Geocoding {
    public static final org.apache.avro.Protocol PROTOCOL = influent.idl.FL_Geocoding.PROTOCOL;
    /** * Geocodes the specified locations, populating missing properties in place.
	 *
	 * @param locations     the locations to geocode. */
    void geocode(java.util.List<influent.idl.FL_GeoData> locations, org.apache.avro.ipc.Callback<java.lang.Boolean> callback) throws java.io.IOException;
    /** * Returns a list of country objects for the previously geolocated locations specified, based
	 * on country code.
	 *
	 * @param locations     the locations to lookup, which must contain a country code.
	 * @return 			    a list of geocoded countries, in the same order as requested. */
    void getCountries(java.util.List<influent.idl.FL_GeoData> locations, org.apache.avro.ipc.Callback<java.util.List<influent.idl.FL_Country>> callback) throws java.io.IOException;
  }
}
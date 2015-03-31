/**
 * Autogenerated by Avro
 * 
 * DO NOT EDIT DIRECTLY
 */
package influent.idl;  
@SuppressWarnings("all")
/** * The set of results from a single search call. Each item also has a score. */
@org.apache.avro.specific.AvroGenerated
public class FL_PatternSearchResults extends org.apache.avro.specific.SpecificRecordBase implements org.apache.avro.specific.SpecificRecord {
  public static final org.apache.avro.Schema SCHEMA$ = new org.apache.avro.Schema.Parser().parse("{\"type\":\"record\",\"name\":\"FL_PatternSearchResults\",\"namespace\":\"influent.idl\",\"doc\":\"* The set of results from a single search call. Each item also has a score.\",\"fields\":[{\"name\":\"total\",\"type\":\"long\",\"doc\":\"total number of results found\",\"default\":-1},{\"name\":\"results\",\"type\":{\"type\":\"array\",\"items\":{\"type\":\"record\",\"name\":\"FL_PatternSearchResult\",\"doc\":\"* A single search result is some annotated subgraph\",\"fields\":[{\"name\":\"score\",\"type\":\"double\",\"doc\":\"search score\",\"default\":0},{\"name\":\"entities\",\"type\":{\"type\":\"array\",\"items\":{\"type\":\"record\",\"name\":\"FL_EntityMatchResult\",\"doc\":\"* An entity that returns from pattern matching as part of a subgraph.\",\"fields\":[{\"name\":\"score\",\"type\":\"double\",\"doc\":\"search score\",\"default\":0},{\"name\":\"uid\",\"type\":{\"type\":\"string\",\"avro.java.string\":\"String\"},\"doc\":\"UID of the matched FL_EntityMatchDescriptor in the matched pattern\",\"default\":null},{\"name\":\"role\",\"type\":[\"null\",{\"type\":\"string\",\"avro.java.string\":\"String\"}],\"doc\":\"role name of the matched FL_EntityMatchDescriptor in the matched pattern\",\"default\":null},{\"name\":\"entity\",\"type\":{\"type\":\"record\",\"name\":\"FL_Entity\",\"doc\":\"* The nodes in the social, financial, communications or other graphs. May represent concrete individuals or organizations,\\r\\n\\t * specific proxies such as accounts, or the implicit individuals or groups behind those other entities.\",\"fields\":[{\"name\":\"uid\",\"type\":{\"type\":\"string\",\"avro.java.string\":\"String\"},\"doc\":\"This uid must represent either (1) a globally unique identifier that can be used to retrieve data for an\\r\\n\\t\\t\\texplicit entity, or (2) encoded query information that can be used to find a set of associated record\\r\\n\\t\\t\\tnotionally representing an implicit entity (e.g. Loans&FirstName&LastName&Gender). Must not be used for\\r\\n\\t\\t\\tIDs that aren't globally unique.  For example, in Kiva, \\\"Lenders\\\" has a UID (\\\"L12345\\\") while \\\"Borrowers\\\"\\r\\n\\t\\t\\thave an encoded search in the Loans table for uid (\\\"B{loan:23456;name=Daniel}\\\").  The encoded information\\r\\n\\t\\t\\tis data layer-specific, may be different from entity to entity or data set to data set, and should be\\r\\n\\t\\t\\tconsidered opaque to the consumers of the entities.  Entities of type 2 should always have the Entity Tag\\r\\n\\t\\t\\tANONYMOUS to help distinguish them when required.\"},{\"name\":\"type\",\"type\":[{\"type\":\"string\",\"avro.java.string\":\"String\"},\"null\"],\"doc\":\"type\"},{\"name\":\"tags\",\"type\":{\"type\":\"array\",\"items\":{\"type\":\"enum\",\"name\":\"FL_EntityTag\",\"doc\":\"* This is the current list of tags for Entities:\\r\\n\\t *\\r\\n\\t * CHANGED in 1.6:\\r\\n\\t * - added ACCOUNT_OWNER, CLUSTER_SUMMARY\\r\\n\\t *\\r\\n\\t * CHANGED in 1.7:\\r\\n\\t * - added PROMPT_FOR_DETAILS\\r\\n\\t *\\r\\n\\t * CHANGED in 1.8:\\r\\n\\t * - added UNBRANCHABLE\",\"symbols\":[\"ACCOUNT_OWNER\",\"ACCOUNT\",\"GROUP\",\"CLUSTER\",\"CLUSTER_SUMMARY\",\"FILE\",\"ANONYMOUS\",\"UNBRANCHABLE\",\"PROMPT_FOR_DETAILS\",\"OTHER\"]}},\"doc\":\"Entity Tags (see above, e.g. \\\"ACCOUNT\\\")\"},{\"name\":\"provenance\",\"type\":[{\"type\":\"record\",\"name\":\"FL_Provenance\",\"doc\":\"* This is a placeholder for future modeling of provenance. It is not a required field in any service calls.\",\"fields\":[{\"name\":\"uri\",\"type\":{\"type\":\"string\",\"avro.java.string\":\"String\"},\"doc\":\"Placeholder for now. Express provenance as a single URI.\"}]},\"null\"],\"default\":null},{\"name\":\"uncertainty\",\"type\":[{\"type\":\"record\",\"name\":\"FL_Uncertainty\",\"doc\":\"* This is a placeholder for future modeling of uncertainty. It is not a required field in any service calls.\\r\\n\\t *\\r\\n\\t * CHANGED IN 1.6\",\"fields\":[{\"name\":\"confidence\",\"type\":\"double\",\"doc\":\"Placeholder for now. Express original source confidence as a single number from 0 to 1.\",\"default\":1},{\"name\":\"currency\",\"type\":\"double\",\"doc\":\"Placeholder for now. Express confidence in currency of data as a single number from 0 to 1.\",\"default\":1}]},\"null\"],\"default\":null},{\"name\":\"properties\",\"type\":{\"type\":\"array\",\"items\":{\"type\":\"record\",\"name\":\"FL_Property\",\"doc\":\"* Each property on an Entity or Link is a name-value pair, with data type information, as well as optional\\r\\n\\t * provenance. Tags provide a way for the data provider to associate semantic annotations to each property\\r\\n\\t * in terms of the semantics of the application.\\r\\n\\t *\\r\\n\\t * CHANGED IN 1.6\",\"fields\":[{\"name\":\"key\",\"type\":{\"type\":\"string\",\"avro.java.string\":\"String\"},\"doc\":\"the field name in the underlying data source\"},{\"name\":\"friendlyText\",\"type\":[\"null\",{\"type\":\"string\",\"avro.java.string\":\"String\"}],\"doc\":\"user-friendly short-text for key (displayable)\",\"default\":null},{\"name\":\"range\",\"type\":[{\"type\":\"record\",\"name\":\"FL_SingletonRange\",\"doc\":\"* Single value\\r\\n\\t *\\r\\n\\t * ADDED IN 1.5\",\"fields\":[{\"name\":\"value\",\"type\":[{\"type\":\"string\",\"avro.java.string\":\"String\"},\"int\",\"float\",\"double\",\"long\",\"boolean\",{\"type\":\"record\",\"name\":\"FL_GeoData\",\"doc\":\"* Structured representation of geo-spatial data.\",\"fields\":[{\"name\":\"text\",\"type\":[\"null\",{\"type\":\"string\",\"avro.java.string\":\"String\"}],\"doc\":\"an address or other place reference; unstructured text field\",\"default\":null},{\"name\":\"lat\",\"type\":[\"double\",\"null\"],\"doc\":\"latitude\",\"default\":null},{\"name\":\"lon\",\"type\":[\"double\",\"null\"],\"doc\":\"longitude\",\"default\":null},{\"name\":\"cc\",\"type\":[\"null\",{\"type\":\"string\",\"avro.java.string\":\"String\"}],\"doc\":\"ISO 3 digit country code\",\"default\":null}]}]},{\"name\":\"type\",\"type\":{\"type\":\"enum\",\"name\":\"FL_PropertyType\",\"doc\":\"* Allowed types for Property values.\\r\\n\\t *\\r\\n\\t * CHANGED in 1.9\",\"symbols\":[\"FLOAT\",\"DOUBLE\",\"INTEGER\",\"LONG\",\"BOOLEAN\",\"STRING\",\"IMAGE\",\"DATE\",\"GEO\"]},\"doc\":\"One of STRING, INTEGER, FLOAT, DOUBLE, LONG, BOOLEAN, DATE, GEO, IMAGE\"}]},{\"type\":\"record\",\"name\":\"FL_ListRange\",\"doc\":\"* List of values\\r\\n\\t *\\r\\n\\t * ADDED IN 1.5\",\"fields\":[{\"name\":\"values\",\"type\":{\"type\":\"array\",\"items\":[{\"type\":\"string\",\"avro.java.string\":\"String\"},\"int\",\"float\",\"double\",\"long\",\"boolean\",\"FL_GeoData\"]}},{\"name\":\"type\",\"type\":\"FL_PropertyType\",\"doc\":\"One of STRING, INTEGER, FLOAT, DOUBLE, LONG, BOOLEAN, DATE, GEO\"}]},{\"type\":\"record\",\"name\":\"FL_BoundedRange\",\"doc\":\"* Bounded or unbounded range values\\r\\n\\t *\\r\\n\\t * ADDED IN 1.5\",\"fields\":[{\"name\":\"start\",\"type\":[{\"type\":\"string\",\"avro.java.string\":\"String\"},\"int\",\"float\",\"double\",\"long\",\"boolean\",\"FL_GeoData\",\"null\"],\"doc\":\"start of range, or null if unbounded start\"},{\"name\":\"end\",\"type\":[{\"type\":\"string\",\"avro.java.string\":\"String\"},\"int\",\"float\",\"double\",\"long\",\"boolean\",\"FL_GeoData\",\"null\"],\"doc\":\"end of range, or null if unbounded start\"},{\"name\":\"inclusive\",\"type\":\"boolean\",\"doc\":\"If true, range includes specified endpoint. If false, range is exclusive.\"},{\"name\":\"type\",\"type\":\"FL_PropertyType\",\"doc\":\"One of STRING, INTEGER, FLOAT, DOUBLE, LONG, BOOLEAN, DATE, GEO\"}]},{\"type\":\"record\",\"name\":\"FL_DistributionRange\",\"doc\":\"* Describes a distribution of values.\\r\\n\\t *\\r\\n\\t * ADDED IN 1.6\",\"fields\":[{\"name\":\"distribution\",\"type\":{\"type\":\"array\",\"items\":{\"type\":\"record\",\"name\":\"FL_Frequency\",\"doc\":\"* A frequency or probability element of a distribution.\\r\\n\\t *\\r\\n\\t * ADDED IN 1.6\",\"fields\":[{\"name\":\"range\",\"type\":[{\"type\":\"string\",\"avro.java.string\":\"String\"},\"int\",\"float\",\"double\",\"long\",\"boolean\",\"FL_GeoData\",\"FL_ListRange\",\"FL_BoundedRange\"],\"doc\":\"the value range which occurs with some specified frequency\"},{\"name\":\"frequency\",\"type\":\"double\",\"doc\":\"frequency as a count, or probability as a value from 0-1.\"}]}}},{\"name\":\"rangeType\",\"type\":{\"type\":\"enum\",\"name\":\"FL_RangeType\",\"doc\":\"* Allowed types for Ranges of values.\\r\\n\\t *\\r\\n\\t * CHANGED IN 1.6\",\"symbols\":[\"SINGLETON\",\"LIST\",\"BOUNDED\",\"DISTRIBUTION\"]},\"doc\":\"Describes how the values in the distribution are summarised\"},{\"name\":\"type\",\"type\":\"FL_PropertyType\",\"doc\":\"The type of value that the distribution describes. One of STRING, INTEGER, FLOAT, DOUBLE, LONG, BOOLEAN, DATE, GEO\"},{\"name\":\"isProbability\",\"type\":\"boolean\",\"doc\":\"True if a probability distribution, false if a frequency distribution\",\"default\":false}]}],\"doc\":\"range of values\",\"default\":null},{\"name\":\"provenance\",\"type\":[\"null\",\"FL_Provenance\"],\"default\":null},{\"name\":\"uncertainty\",\"type\":[\"null\",\"FL_Uncertainty\"],\"default\":null},{\"name\":\"tags\",\"type\":{\"type\":\"array\",\"items\":{\"type\":\"enum\",\"name\":\"FL_PropertyTag\",\"doc\":\"* Tags are defined by the application layer as a taxonomy of user and application concepts,\\r\\n\\t * independent of the data sources. This allows application semantics to be re-used with new\\r\\n\\t * data, with a minimum of new software design and development. Data layer entity types, link\\r\\n\\t * types and properties should be mapped into the list of tags. The application layer must be\\r\\n\\t * able to search by native field name or by tag interchangeably, and properties returned must\\r\\n\\t * contain both native field names as well as tags.\\r\\n\\t *\\r\\n\\t * The list of tags may change as application features evolve, though that will require\\r\\n\\t * collaboration with the data layer providers. Evolving the tag list should not change the\\r\\n\\t * Data Access or Search APIs.\\r\\n\\t *\\r\\n\\t * This is the current list of tags for Properties:\\r\\n\\t *\\r\\n\\t * CHANGED in 1.5:\\r\\n\\t * - CREDIT/DEBIT changed to INFLOWING/OUTFLOWING\\r\\n\\t * - added USD\\r\\n\\t * - added DURATION\\r\\n\\t *\\r\\n\\t * CHANGED in 1.6:\\r\\n\\t * - added ENTITY_TYPE\\r\\n\\t * - added ACCOUNT_OWNER, CLUSTER_SUMMARY, COUNTRY_CODE\\r\\n\\t *\\r\\n\\t * CHANGED in 1.7:\\r\\n\\t * - added CLUSTER\\r\\n\\t *\\r\\n\\t * CHANGED in 1.8:\\r\\n\\t * - added TOPIC\\r\\n\\t *\\r\\n\\t * CHANGED in 1.9:\\r\\n\\t * - added HTML\\r\\n\\t *\\r\\n\\t * CHANGED in 2.0:\\r\\n\\t * - added UNITS\",\"symbols\":[\"ID\",\"TYPE\",\"ENTITY_TYPE\",\"ACCOUNT_OWNER\",\"CLUSTER_SUMMARY\",\"CLUSTER\",\"NAME\",\"LABEL\",\"STAT\",\"TEXT\",\"HTML\",\"TOPIC\",\"STATUS\",\"ANNOTATION\",\"WARNING\",\"LINKED_DATA\",\"GEO\",\"COUNTRY_CODE\",\"DATE\",\"AMOUNT\",\"INFLOWING\",\"OUTFLOWING\",\"COUNT\",\"SERIES\",\"CONSTRUCTED\",\"RAW\",\"UNITS\",\"USD\",\"DURATION\",\"ENTITY\",\"SHARED_IDENTIFIER\"]}},\"doc\":\"one or more tags from the Tag list, used to map this source-specific field into the semantics of applications\"},{\"name\":\"isHidden\",\"type\":\"boolean\",\"doc\":\"true if this property is hidden from the client\",\"default\":false}]}}}]},\"doc\":\"the entity\"}]}},\"doc\":\"entity results \\r\\n\\t\\t * There needs to be at least one entity in the result\"},{\"name\":\"links\",\"type\":[{\"type\":\"array\",\"items\":{\"type\":\"record\",\"name\":\"FL_LinkMatchResult\",\"doc\":\"* A link that returns from pattern matching as part of a subgraph.\",\"fields\":[{\"name\":\"score\",\"type\":\"double\",\"doc\":\"search score\",\"default\":0},{\"name\":\"uid\",\"type\":{\"type\":\"string\",\"avro.java.string\":\"String\"},\"doc\":\"UID of the matched FL_LinkMatchDescriptor in the matched pattern\",\"default\":null},{\"name\":\"role\",\"type\":[\"null\",{\"type\":\"string\",\"avro.java.string\":\"String\"}],\"doc\":\"role name of the matched FL_LinkMatchDescriptor in the matched pattern\",\"default\":null},{\"name\":\"link\",\"type\":{\"type\":\"record\",\"name\":\"FL_Link\",\"doc\":\"* The links in the social, financial, communications or other graphs. May represent communication\\r\\n\\t * events, financial transactions or social connections.\",\"fields\":[{\"name\":\"uid\",\"type\":{\"type\":\"string\",\"avro.java.string\":\"String\"},\"doc\":\"This uid must represent either (1) a globally unique identifier that can be used to retrieve data for an\\r\\n\\t\\t\\texplicit link, or (2) encoded query information that can be used to find a set of associated record\\r\\n\\t\\t\\tnotionally representing an implicit link (e.g. Source&Target&Date&Amount). Must not be used for\\r\\n\\t\\t\\tIDs that aren't globally unique.\"},{\"name\":\"linkTypes\",\"type\":[{\"type\":\"array\",\"items\":{\"type\":\"string\",\"avro.java.string\":\"String\"}},\"null\"],\"doc\":\"link types\",\"default\":null},{\"name\":\"source\",\"type\":[\"null\",{\"type\":\"string\",\"avro.java.string\":\"String\"}],\"doc\":\"source entity uid\",\"default\":null},{\"name\":\"target\",\"type\":[\"null\",{\"type\":\"string\",\"avro.java.string\":\"String\"}],\"doc\":\"target entity uid\",\"default\":null},{\"name\":\"type\",\"type\":[{\"type\":\"string\",\"avro.java.string\":\"String\"},\"null\"],\"doc\":\"type\"},{\"name\":\"directed\",\"type\":\"boolean\",\"doc\":\"true if directed, false if undirected\",\"default\":true},{\"name\":\"provenance\",\"type\":[\"FL_Provenance\",\"null\"],\"default\":null},{\"name\":\"uncertainty\",\"type\":[\"FL_Uncertainty\",\"null\"],\"default\":null},{\"name\":\"properties\",\"type\":{\"type\":\"array\",\"items\":\"FL_Property\"}}]},\"doc\":\"the link\"}]}},\"null\"],\"doc\":\"links between those entities *\"}]}},\"doc\":\"array of Items (Entities or Links) with scores\"}]}");
  public static org.apache.avro.Schema getClassSchema() { return SCHEMA$; }
  /** total number of results found */
   private long total;
  /** array of Items (Entities or Links) with scores */
   private java.util.List<influent.idl.FL_PatternSearchResult> results;

  /**
   * Default constructor.
   */
  public FL_PatternSearchResults() {}

  /**
   * All-args constructor.
   */
  public FL_PatternSearchResults(java.lang.Long total, java.util.List<influent.idl.FL_PatternSearchResult> results) {
    this.total = total;
    this.results = results;
  }

  public org.apache.avro.Schema getSchema() { return SCHEMA$; }
  // Used by DatumWriter.  Applications should not call. 
  public java.lang.Object get(int field$) {
    switch (field$) {
    case 0: return total;
    case 1: return results;
    default: throw new org.apache.avro.AvroRuntimeException("Bad index");
    }
  }
  // Used by DatumReader.  Applications should not call. 
  @SuppressWarnings(value="unchecked")
  public void put(int field$, java.lang.Object value$) {
    switch (field$) {
    case 0: total = (java.lang.Long)value$; break;
    case 1: results = (java.util.List<influent.idl.FL_PatternSearchResult>)value$; break;
    default: throw new org.apache.avro.AvroRuntimeException("Bad index");
    }
  }

  /**
   * Gets the value of the 'total' field.
   * total number of results found   */
  public java.lang.Long getTotal() {
    return total;
  }

  /**
   * Sets the value of the 'total' field.
   * total number of results found   * @param value the value to set.
   */
  public void setTotal(java.lang.Long value) {
    this.total = value;
  }

  /**
   * Gets the value of the 'results' field.
   * array of Items (Entities or Links) with scores   */
  public java.util.List<influent.idl.FL_PatternSearchResult> getResults() {
    return results;
  }

  /**
   * Sets the value of the 'results' field.
   * array of Items (Entities or Links) with scores   * @param value the value to set.
   */
  public void setResults(java.util.List<influent.idl.FL_PatternSearchResult> value) {
    this.results = value;
  }

  /** Creates a new FL_PatternSearchResults RecordBuilder */
  public static influent.idl.FL_PatternSearchResults.Builder newBuilder() {
    return new influent.idl.FL_PatternSearchResults.Builder();
  }
  
  /** Creates a new FL_PatternSearchResults RecordBuilder by copying an existing Builder */
  public static influent.idl.FL_PatternSearchResults.Builder newBuilder(influent.idl.FL_PatternSearchResults.Builder other) {
    return new influent.idl.FL_PatternSearchResults.Builder(other);
  }
  
  /** Creates a new FL_PatternSearchResults RecordBuilder by copying an existing FL_PatternSearchResults instance */
  public static influent.idl.FL_PatternSearchResults.Builder newBuilder(influent.idl.FL_PatternSearchResults other) {
    return new influent.idl.FL_PatternSearchResults.Builder(other);
  }
  
  /**
   * RecordBuilder for FL_PatternSearchResults instances.
   */
  public static class Builder extends org.apache.avro.specific.SpecificRecordBuilderBase<FL_PatternSearchResults>
    implements org.apache.avro.data.RecordBuilder<FL_PatternSearchResults> {

    private long total;
    private java.util.List<influent.idl.FL_PatternSearchResult> results;

    /** Creates a new Builder */
    private Builder() {
      super(influent.idl.FL_PatternSearchResults.SCHEMA$);
    }
    
    /** Creates a Builder by copying an existing Builder */
    private Builder(influent.idl.FL_PatternSearchResults.Builder other) {
      super(other);
    }
    
    /** Creates a Builder by copying an existing FL_PatternSearchResults instance */
    private Builder(influent.idl.FL_PatternSearchResults other) {
            super(influent.idl.FL_PatternSearchResults.SCHEMA$);
      if (isValidValue(fields()[0], other.total)) {
        this.total = data().deepCopy(fields()[0].schema(), other.total);
        fieldSetFlags()[0] = true;
      }
      if (isValidValue(fields()[1], other.results)) {
        this.results = data().deepCopy(fields()[1].schema(), other.results);
        fieldSetFlags()[1] = true;
      }
    }

    /** Gets the value of the 'total' field */
    public java.lang.Long getTotal() {
      return total;
    }
    
    /** Sets the value of the 'total' field */
    public influent.idl.FL_PatternSearchResults.Builder setTotal(long value) {
      validate(fields()[0], value);
      this.total = value;
      fieldSetFlags()[0] = true;
      return this; 
    }
    
    /** Checks whether the 'total' field has been set */
    public boolean hasTotal() {
      return fieldSetFlags()[0];
    }
    
    /** Clears the value of the 'total' field */
    public influent.idl.FL_PatternSearchResults.Builder clearTotal() {
      fieldSetFlags()[0] = false;
      return this;
    }

    /** Gets the value of the 'results' field */
    public java.util.List<influent.idl.FL_PatternSearchResult> getResults() {
      return results;
    }
    
    /** Sets the value of the 'results' field */
    public influent.idl.FL_PatternSearchResults.Builder setResults(java.util.List<influent.idl.FL_PatternSearchResult> value) {
      validate(fields()[1], value);
      this.results = value;
      fieldSetFlags()[1] = true;
      return this; 
    }
    
    /** Checks whether the 'results' field has been set */
    public boolean hasResults() {
      return fieldSetFlags()[1];
    }
    
    /** Clears the value of the 'results' field */
    public influent.idl.FL_PatternSearchResults.Builder clearResults() {
      results = null;
      fieldSetFlags()[1] = false;
      return this;
    }

    @Override
    public FL_PatternSearchResults build() {
      try {
        FL_PatternSearchResults record = new FL_PatternSearchResults();
        record.total = fieldSetFlags()[0] ? this.total : (java.lang.Long) defaultValue(fields()[0]);
        record.results = fieldSetFlags()[1] ? this.results : (java.util.List<influent.idl.FL_PatternSearchResult>) defaultValue(fields()[1]);
        return record;
      } catch (Exception e) {
        throw new org.apache.avro.AvroRuntimeException(e);
      }
    }
  }
}

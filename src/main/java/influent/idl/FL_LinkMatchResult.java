/**
 * Autogenerated by Avro
 * 
 * DO NOT EDIT DIRECTLY
 */
package influent.idl;  
@SuppressWarnings("all")
/** * A link that returns from pattern matching as part of a subgraph. */
@org.apache.avro.specific.AvroGenerated
public class FL_LinkMatchResult extends org.apache.avro.specific.SpecificRecordBase implements org.apache.avro.specific.SpecificRecord {
  public static final org.apache.avro.Schema SCHEMA$ = new org.apache.avro.Schema.Parser().parse("{\"type\":\"record\",\"name\":\"FL_LinkMatchResult\",\"namespace\":\"influent.idl\",\"doc\":\"* A link that returns from pattern matching as part of a subgraph.\",\"fields\":[{\"name\":\"score\",\"type\":\"double\",\"doc\":\"search score\",\"default\":0},{\"name\":\"uid\",\"type\":{\"type\":\"string\",\"avro.java.string\":\"String\"},\"doc\":\"UID of the matched FL_LinkMatchDescriptor in the matched pattern\",\"default\":null},{\"name\":\"role\",\"type\":[\"null\",{\"type\":\"string\",\"avro.java.string\":\"String\"}],\"doc\":\"role name of the matched FL_LinkMatchDescriptor in the matched pattern\",\"default\":null},{\"name\":\"link\",\"type\":{\"type\":\"record\",\"name\":\"FL_Link\",\"doc\":\"* The links in the social, financial, communications or other graphs. May represent communication\\r\\n\\t * events, financial transactions or social connections.\",\"fields\":[{\"name\":\"uid\",\"type\":{\"type\":\"string\",\"avro.java.string\":\"String\"},\"doc\":\"This uid must represent either (1) a globally unique identifier that can be used to retrieve data for an\\r\\n\\t\\t\\texplicit link, or (2) encoded query information that can be used to find a set of associated record\\r\\n\\t\\t\\tnotionally representing an implicit link (e.g. Source&Target&Date&Amount). Must not be used for\\r\\n\\t\\t\\tIDs that aren't globally unique.\"},{\"name\":\"linkTypes\",\"type\":[{\"type\":\"array\",\"items\":{\"type\":\"string\",\"avro.java.string\":\"String\"}},\"null\"],\"doc\":\"link types\",\"default\":null},{\"name\":\"source\",\"type\":[\"null\",{\"type\":\"string\",\"avro.java.string\":\"String\"}],\"doc\":\"source entity uid\",\"default\":null},{\"name\":\"target\",\"type\":[\"null\",{\"type\":\"string\",\"avro.java.string\":\"String\"}],\"doc\":\"target entity uid\",\"default\":null},{\"name\":\"type\",\"type\":[{\"type\":\"string\",\"avro.java.string\":\"String\"},\"null\"],\"doc\":\"type\"},{\"name\":\"directed\",\"type\":\"boolean\",\"doc\":\"true if directed, false if undirected\",\"default\":true},{\"name\":\"provenance\",\"type\":[{\"type\":\"record\",\"name\":\"FL_Provenance\",\"doc\":\"* This is a placeholder for future modeling of provenance. It is not a required field in any service calls.\",\"fields\":[{\"name\":\"uri\",\"type\":{\"type\":\"string\",\"avro.java.string\":\"String\"},\"doc\":\"Placeholder for now. Express provenance as a single URI.\"}]},\"null\"],\"default\":null},{\"name\":\"uncertainty\",\"type\":[{\"type\":\"record\",\"name\":\"FL_Uncertainty\",\"doc\":\"* This is a placeholder for future modeling of uncertainty. It is not a required field in any service calls.\\r\\n\\t *\\r\\n\\t * CHANGED IN 1.6\",\"fields\":[{\"name\":\"confidence\",\"type\":\"double\",\"doc\":\"Placeholder for now. Express original source confidence as a single number from 0 to 1.\",\"default\":1},{\"name\":\"currency\",\"type\":\"double\",\"doc\":\"Placeholder for now. Express confidence in currency of data as a single number from 0 to 1.\",\"default\":1}]},\"null\"],\"default\":null},{\"name\":\"properties\",\"type\":{\"type\":\"array\",\"items\":{\"type\":\"record\",\"name\":\"FL_Property\",\"doc\":\"* Each property on an Entity or Link is a name-value pair, with data type information, as well as optional\\r\\n\\t * provenance. Tags provide a way for the data provider to associate semantic annotations to each property\\r\\n\\t * in terms of the semantics of the application.\\r\\n\\t *\\r\\n\\t * CHANGED IN 1.6\",\"fields\":[{\"name\":\"key\",\"type\":{\"type\":\"string\",\"avro.java.string\":\"String\"},\"doc\":\"the field name in the underlying data source\"},{\"name\":\"friendlyText\",\"type\":[\"null\",{\"type\":\"string\",\"avro.java.string\":\"String\"}],\"doc\":\"user-friendly short-text for key (displayable)\",\"default\":null},{\"name\":\"range\",\"type\":[{\"type\":\"record\",\"name\":\"FL_SingletonRange\",\"doc\":\"* Single value\\r\\n\\t *\\r\\n\\t * ADDED IN 1.5\",\"fields\":[{\"name\":\"value\",\"type\":[{\"type\":\"string\",\"avro.java.string\":\"String\"},\"int\",\"float\",\"double\",\"long\",\"boolean\",{\"type\":\"record\",\"name\":\"FL_GeoData\",\"doc\":\"* Structured representation of geo-spatial data.\",\"fields\":[{\"name\":\"text\",\"type\":[\"null\",{\"type\":\"string\",\"avro.java.string\":\"String\"}],\"doc\":\"an address or other place reference; unstructured text field\",\"default\":null},{\"name\":\"lat\",\"type\":[\"double\",\"null\"],\"doc\":\"latitude\",\"default\":null},{\"name\":\"lon\",\"type\":[\"double\",\"null\"],\"doc\":\"longitude\",\"default\":null},{\"name\":\"cc\",\"type\":[\"null\",{\"type\":\"string\",\"avro.java.string\":\"String\"}],\"doc\":\"ISO 3 digit country code\",\"default\":null}]}]},{\"name\":\"type\",\"type\":{\"type\":\"enum\",\"name\":\"FL_PropertyType\",\"doc\":\"* Allowed types for Property values.\\r\\n\\t *\\r\\n\\t * CHANGED in 1.9\",\"symbols\":[\"FLOAT\",\"DOUBLE\",\"INTEGER\",\"LONG\",\"BOOLEAN\",\"STRING\",\"IMAGE\",\"DATE\",\"GEO\"]},\"doc\":\"One of STRING, INTEGER, FLOAT, DOUBLE, LONG, BOOLEAN, DATE, GEO, IMAGE\"}]},{\"type\":\"record\",\"name\":\"FL_ListRange\",\"doc\":\"* List of values\\r\\n\\t *\\r\\n\\t * ADDED IN 1.5\",\"fields\":[{\"name\":\"values\",\"type\":{\"type\":\"array\",\"items\":[{\"type\":\"string\",\"avro.java.string\":\"String\"},\"int\",\"float\",\"double\",\"long\",\"boolean\",\"FL_GeoData\"]}},{\"name\":\"type\",\"type\":\"FL_PropertyType\",\"doc\":\"One of STRING, INTEGER, FLOAT, DOUBLE, LONG, BOOLEAN, DATE, GEO\"}]},{\"type\":\"record\",\"name\":\"FL_BoundedRange\",\"doc\":\"* Bounded or unbounded range values\\r\\n\\t *\\r\\n\\t * ADDED IN 1.5\",\"fields\":[{\"name\":\"start\",\"type\":[{\"type\":\"string\",\"avro.java.string\":\"String\"},\"int\",\"float\",\"double\",\"long\",\"boolean\",\"FL_GeoData\",\"null\"],\"doc\":\"start of range, or null if unbounded start\"},{\"name\":\"end\",\"type\":[{\"type\":\"string\",\"avro.java.string\":\"String\"},\"int\",\"float\",\"double\",\"long\",\"boolean\",\"FL_GeoData\",\"null\"],\"doc\":\"end of range, or null if unbounded start\"},{\"name\":\"inclusive\",\"type\":\"boolean\",\"doc\":\"If true, range includes specified endpoint. If false, range is exclusive.\"},{\"name\":\"type\",\"type\":\"FL_PropertyType\",\"doc\":\"One of STRING, INTEGER, FLOAT, DOUBLE, LONG, BOOLEAN, DATE, GEO\"}]},{\"type\":\"record\",\"name\":\"FL_DistributionRange\",\"doc\":\"* Describes a distribution of values.\\r\\n\\t *\\r\\n\\t * ADDED IN 1.6\",\"fields\":[{\"name\":\"distribution\",\"type\":{\"type\":\"array\",\"items\":{\"type\":\"record\",\"name\":\"FL_Frequency\",\"doc\":\"* A frequency or probability element of a distribution.\\r\\n\\t *\\r\\n\\t * ADDED IN 1.6\",\"fields\":[{\"name\":\"range\",\"type\":[{\"type\":\"string\",\"avro.java.string\":\"String\"},\"int\",\"float\",\"double\",\"long\",\"boolean\",\"FL_GeoData\",\"FL_ListRange\",\"FL_BoundedRange\"],\"doc\":\"the value range which occurs with some specified frequency\"},{\"name\":\"frequency\",\"type\":\"double\",\"doc\":\"frequency as a count, or probability as a value from 0-1.\"}]}}},{\"name\":\"rangeType\",\"type\":{\"type\":\"enum\",\"name\":\"FL_RangeType\",\"doc\":\"* Allowed types for Ranges of values.\\r\\n\\t *\\r\\n\\t * CHANGED IN 1.6\",\"symbols\":[\"SINGLETON\",\"LIST\",\"BOUNDED\",\"DISTRIBUTION\"]},\"doc\":\"Describes how the values in the distribution are summarised\"},{\"name\":\"type\",\"type\":\"FL_PropertyType\",\"doc\":\"The type of value that the distribution describes. One of STRING, INTEGER, FLOAT, DOUBLE, LONG, BOOLEAN, DATE, GEO\"},{\"name\":\"isProbability\",\"type\":\"boolean\",\"doc\":\"True if a probability distribution, false if a frequency distribution\",\"default\":false}]}],\"doc\":\"range of values\",\"default\":null},{\"name\":\"provenance\",\"type\":[\"null\",\"FL_Provenance\"],\"default\":null},{\"name\":\"uncertainty\",\"type\":[\"null\",\"FL_Uncertainty\"],\"default\":null},{\"name\":\"tags\",\"type\":{\"type\":\"array\",\"items\":{\"type\":\"enum\",\"name\":\"FL_PropertyTag\",\"doc\":\"* Tags are defined by the application layer as a taxonomy of user and application concepts,\\r\\n\\t * independent of the data sources. This allows application semantics to be re-used with new\\r\\n\\t * data, with a minimum of new software design and development. Data layer entity types, link\\r\\n\\t * types and properties should be mapped into the list of tags. The application layer must be\\r\\n\\t * able to search by native field name or by tag interchangeably, and properties returned must\\r\\n\\t * contain both native field names as well as tags.\\r\\n\\t *\\r\\n\\t * The list of tags may change as application features evolve, though that will require\\r\\n\\t * collaboration with the data layer providers. Evolving the tag list should not change the\\r\\n\\t * Data Access or Search APIs.\\r\\n\\t *\\r\\n\\t * This is the current list of tags for Properties:\\r\\n\\t *\\r\\n\\t * CHANGED in 1.5:\\r\\n\\t * - CREDIT/DEBIT changed to INFLOWING/OUTFLOWING\\r\\n\\t * - added USD\\r\\n\\t * - added DURATION\\r\\n\\t *\\r\\n\\t * CHANGED in 1.6:\\r\\n\\t * - added ENTITY_TYPE\\r\\n\\t * - added ACCOUNT_OWNER, CLUSTER_SUMMARY, COUNTRY_CODE\\r\\n\\t *\\r\\n\\t * CHANGED in 1.7:\\r\\n\\t * - added CLUSTER\\r\\n\\t *\\r\\n\\t * CHANGED in 1.8:\\r\\n\\t * - added TOPIC\\r\\n\\t *\\r\\n\\t * CHANGED in 1.9:\\r\\n\\t * - added HTML\\r\\n\\t *\\r\\n\\t * CHANGED in 2.0:\\r\\n\\t * - added UNITS\",\"symbols\":[\"ID\",\"TYPE\",\"ENTITY_TYPE\",\"ACCOUNT_OWNER\",\"CLUSTER_SUMMARY\",\"CLUSTER\",\"NAME\",\"LABEL\",\"STAT\",\"TEXT\",\"HTML\",\"TOPIC\",\"STATUS\",\"ANNOTATION\",\"WARNING\",\"LINKED_DATA\",\"GEO\",\"COUNTRY_CODE\",\"DATE\",\"AMOUNT\",\"INFLOWING\",\"OUTFLOWING\",\"COUNT\",\"SERIES\",\"CONSTRUCTED\",\"RAW\",\"UNITS\",\"USD\",\"DURATION\",\"ENTITY\",\"SHARED_IDENTIFIER\"]}},\"doc\":\"one or more tags from the Tag list, used to map this source-specific field into the semantics of applications\"},{\"name\":\"isHidden\",\"type\":\"boolean\",\"doc\":\"true if this property is hidden from the client\",\"default\":false}]}}}]},\"doc\":\"the link\"}]}");
  public static org.apache.avro.Schema getClassSchema() { return SCHEMA$; }
  /** search score */
   private double score;
  /** UID of the matched FL_LinkMatchDescriptor in the matched pattern */
   private java.lang.String uid;
  /** role name of the matched FL_LinkMatchDescriptor in the matched pattern */
   private java.lang.String role;
  /** the link */
   private influent.idl.FL_Link link;

  /**
   * Default constructor.
   */
  public FL_LinkMatchResult() {}

  /**
   * All-args constructor.
   */
  public FL_LinkMatchResult(java.lang.Double score, java.lang.String uid, java.lang.String role, influent.idl.FL_Link link) {
    this.score = score;
    this.uid = uid;
    this.role = role;
    this.link = link;
  }

  public org.apache.avro.Schema getSchema() { return SCHEMA$; }
  // Used by DatumWriter.  Applications should not call. 
  public java.lang.Object get(int field$) {
    switch (field$) {
    case 0: return score;
    case 1: return uid;
    case 2: return role;
    case 3: return link;
    default: throw new org.apache.avro.AvroRuntimeException("Bad index");
    }
  }
  // Used by DatumReader.  Applications should not call. 
  @SuppressWarnings(value="unchecked")
  public void put(int field$, java.lang.Object value$) {
    switch (field$) {
    case 0: score = (java.lang.Double)value$; break;
    case 1: uid = (java.lang.String)value$; break;
    case 2: role = (java.lang.String)value$; break;
    case 3: link = (influent.idl.FL_Link)value$; break;
    default: throw new org.apache.avro.AvroRuntimeException("Bad index");
    }
  }

  /**
   * Gets the value of the 'score' field.
   * search score   */
  public java.lang.Double getScore() {
    return score;
  }

  /**
   * Sets the value of the 'score' field.
   * search score   * @param value the value to set.
   */
  public void setScore(java.lang.Double value) {
    this.score = value;
  }

  /**
   * Gets the value of the 'uid' field.
   * UID of the matched FL_LinkMatchDescriptor in the matched pattern   */
  public java.lang.String getUid() {
    return uid;
  }

  /**
   * Sets the value of the 'uid' field.
   * UID of the matched FL_LinkMatchDescriptor in the matched pattern   * @param value the value to set.
   */
  public void setUid(java.lang.String value) {
    this.uid = value;
  }

  /**
   * Gets the value of the 'role' field.
   * role name of the matched FL_LinkMatchDescriptor in the matched pattern   */
  public java.lang.String getRole() {
    return role;
  }

  /**
   * Sets the value of the 'role' field.
   * role name of the matched FL_LinkMatchDescriptor in the matched pattern   * @param value the value to set.
   */
  public void setRole(java.lang.String value) {
    this.role = value;
  }

  /**
   * Gets the value of the 'link' field.
   * the link   */
  public influent.idl.FL_Link getLink() {
    return link;
  }

  /**
   * Sets the value of the 'link' field.
   * the link   * @param value the value to set.
   */
  public void setLink(influent.idl.FL_Link value) {
    this.link = value;
  }

  /** Creates a new FL_LinkMatchResult RecordBuilder */
  public static influent.idl.FL_LinkMatchResult.Builder newBuilder() {
    return new influent.idl.FL_LinkMatchResult.Builder();
  }
  
  /** Creates a new FL_LinkMatchResult RecordBuilder by copying an existing Builder */
  public static influent.idl.FL_LinkMatchResult.Builder newBuilder(influent.idl.FL_LinkMatchResult.Builder other) {
    return new influent.idl.FL_LinkMatchResult.Builder(other);
  }
  
  /** Creates a new FL_LinkMatchResult RecordBuilder by copying an existing FL_LinkMatchResult instance */
  public static influent.idl.FL_LinkMatchResult.Builder newBuilder(influent.idl.FL_LinkMatchResult other) {
    return new influent.idl.FL_LinkMatchResult.Builder(other);
  }
  
  /**
   * RecordBuilder for FL_LinkMatchResult instances.
   */
  public static class Builder extends org.apache.avro.specific.SpecificRecordBuilderBase<FL_LinkMatchResult>
    implements org.apache.avro.data.RecordBuilder<FL_LinkMatchResult> {

    private double score;
    private java.lang.String uid;
    private java.lang.String role;
    private influent.idl.FL_Link link;

    /** Creates a new Builder */
    private Builder() {
      super(influent.idl.FL_LinkMatchResult.SCHEMA$);
    }
    
    /** Creates a Builder by copying an existing Builder */
    private Builder(influent.idl.FL_LinkMatchResult.Builder other) {
      super(other);
    }
    
    /** Creates a Builder by copying an existing FL_LinkMatchResult instance */
    private Builder(influent.idl.FL_LinkMatchResult other) {
            super(influent.idl.FL_LinkMatchResult.SCHEMA$);
      if (isValidValue(fields()[0], other.score)) {
        this.score = data().deepCopy(fields()[0].schema(), other.score);
        fieldSetFlags()[0] = true;
      }
      if (isValidValue(fields()[1], other.uid)) {
        this.uid = data().deepCopy(fields()[1].schema(), other.uid);
        fieldSetFlags()[1] = true;
      }
      if (isValidValue(fields()[2], other.role)) {
        this.role = data().deepCopy(fields()[2].schema(), other.role);
        fieldSetFlags()[2] = true;
      }
      if (isValidValue(fields()[3], other.link)) {
        this.link = data().deepCopy(fields()[3].schema(), other.link);
        fieldSetFlags()[3] = true;
      }
    }

    /** Gets the value of the 'score' field */
    public java.lang.Double getScore() {
      return score;
    }
    
    /** Sets the value of the 'score' field */
    public influent.idl.FL_LinkMatchResult.Builder setScore(double value) {
      validate(fields()[0], value);
      this.score = value;
      fieldSetFlags()[0] = true;
      return this; 
    }
    
    /** Checks whether the 'score' field has been set */
    public boolean hasScore() {
      return fieldSetFlags()[0];
    }
    
    /** Clears the value of the 'score' field */
    public influent.idl.FL_LinkMatchResult.Builder clearScore() {
      fieldSetFlags()[0] = false;
      return this;
    }

    /** Gets the value of the 'uid' field */
    public java.lang.String getUid() {
      return uid;
    }
    
    /** Sets the value of the 'uid' field */
    public influent.idl.FL_LinkMatchResult.Builder setUid(java.lang.String value) {
      validate(fields()[1], value);
      this.uid = value;
      fieldSetFlags()[1] = true;
      return this; 
    }
    
    /** Checks whether the 'uid' field has been set */
    public boolean hasUid() {
      return fieldSetFlags()[1];
    }
    
    /** Clears the value of the 'uid' field */
    public influent.idl.FL_LinkMatchResult.Builder clearUid() {
      uid = null;
      fieldSetFlags()[1] = false;
      return this;
    }

    /** Gets the value of the 'role' field */
    public java.lang.String getRole() {
      return role;
    }
    
    /** Sets the value of the 'role' field */
    public influent.idl.FL_LinkMatchResult.Builder setRole(java.lang.String value) {
      validate(fields()[2], value);
      this.role = value;
      fieldSetFlags()[2] = true;
      return this; 
    }
    
    /** Checks whether the 'role' field has been set */
    public boolean hasRole() {
      return fieldSetFlags()[2];
    }
    
    /** Clears the value of the 'role' field */
    public influent.idl.FL_LinkMatchResult.Builder clearRole() {
      role = null;
      fieldSetFlags()[2] = false;
      return this;
    }

    /** Gets the value of the 'link' field */
    public influent.idl.FL_Link getLink() {
      return link;
    }
    
    /** Sets the value of the 'link' field */
    public influent.idl.FL_LinkMatchResult.Builder setLink(influent.idl.FL_Link value) {
      validate(fields()[3], value);
      this.link = value;
      fieldSetFlags()[3] = true;
      return this; 
    }
    
    /** Checks whether the 'link' field has been set */
    public boolean hasLink() {
      return fieldSetFlags()[3];
    }
    
    /** Clears the value of the 'link' field */
    public influent.idl.FL_LinkMatchResult.Builder clearLink() {
      link = null;
      fieldSetFlags()[3] = false;
      return this;
    }

    @Override
    public FL_LinkMatchResult build() {
      try {
        FL_LinkMatchResult record = new FL_LinkMatchResult();
        record.score = fieldSetFlags()[0] ? this.score : (java.lang.Double) defaultValue(fields()[0]);
        record.uid = fieldSetFlags()[1] ? this.uid : (java.lang.String) defaultValue(fields()[1]);
        record.role = fieldSetFlags()[2] ? this.role : (java.lang.String) defaultValue(fields()[2]);
        record.link = fieldSetFlags()[3] ? this.link : (influent.idl.FL_Link) defaultValue(fields()[3]);
        return record;
      } catch (Exception e) {
        throw new org.apache.avro.AvroRuntimeException(e);
      }
    }
  }
}

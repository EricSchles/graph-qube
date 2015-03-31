/**
 * Autogenerated by Avro
 * 
 * DO NOT EDIT DIRECTLY
 */
package influent.idl;  
@SuppressWarnings("all")
/** * A PropertyMatchDescriptor is used to describe a possible property that can be present in an entity or link. It describes
	 * a single property that can be used in a property search. It can optionally include example or suggested values
	 * for searching on.
	 *
	 * CHANGED IN 1.5
	 * */
@org.apache.avro.specific.AvroGenerated
public class FL_PropertyMatchDescriptor extends org.apache.avro.specific.SpecificRecordBase implements org.apache.avro.specific.SpecificRecord {
  public static final org.apache.avro.Schema SCHEMA$ = new org.apache.avro.Schema.Parser().parse("{\"type\":\"record\",\"name\":\"FL_PropertyMatchDescriptor\",\"namespace\":\"influent.idl\",\"doc\":\"* A PropertyMatchDescriptor is used to describe a possible property that can be present in an entity or link. It describes\\r\\n\\t * a single property that can be used in a property search. It can optionally include example or suggested values\\r\\n\\t * for searching on.\\r\\n\\t *\\r\\n\\t * CHANGED IN 1.5\\r\\n\\t *\",\"fields\":[{\"name\":\"key\",\"type\":{\"type\":\"string\",\"avro.java.string\":\"String\"},\"doc\":\"field name or FL_PropertyTag (or FL_PathMatchTag) that could be searched on\"},{\"name\":\"range\",\"type\":[{\"type\":\"record\",\"name\":\"FL_SingletonRange\",\"doc\":\"* Single value\\r\\n\\t *\\r\\n\\t * ADDED IN 1.5\",\"fields\":[{\"name\":\"value\",\"type\":[{\"type\":\"string\",\"avro.java.string\":\"String\"},\"int\",\"float\",\"double\",\"long\",\"boolean\",{\"type\":\"record\",\"name\":\"FL_GeoData\",\"doc\":\"* Structured representation of geo-spatial data.\",\"fields\":[{\"name\":\"text\",\"type\":[\"null\",{\"type\":\"string\",\"avro.java.string\":\"String\"}],\"doc\":\"an address or other place reference; unstructured text field\",\"default\":null},{\"name\":\"lat\",\"type\":[\"double\",\"null\"],\"doc\":\"latitude\",\"default\":null},{\"name\":\"lon\",\"type\":[\"double\",\"null\"],\"doc\":\"longitude\",\"default\":null},{\"name\":\"cc\",\"type\":[\"null\",{\"type\":\"string\",\"avro.java.string\":\"String\"}],\"doc\":\"ISO 3 digit country code\",\"default\":null}]}]},{\"name\":\"type\",\"type\":{\"type\":\"enum\",\"name\":\"FL_PropertyType\",\"doc\":\"* Allowed types for Property values.\\r\\n\\t *\\r\\n\\t * CHANGED in 1.9\",\"symbols\":[\"FLOAT\",\"DOUBLE\",\"INTEGER\",\"LONG\",\"BOOLEAN\",\"STRING\",\"IMAGE\",\"DATE\",\"GEO\"]},\"doc\":\"One of STRING, INTEGER, FLOAT, DOUBLE, LONG, BOOLEAN, DATE, GEO, IMAGE\"}]},{\"type\":\"record\",\"name\":\"FL_ListRange\",\"doc\":\"* List of values\\r\\n\\t *\\r\\n\\t * ADDED IN 1.5\",\"fields\":[{\"name\":\"values\",\"type\":{\"type\":\"array\",\"items\":[{\"type\":\"string\",\"avro.java.string\":\"String\"},\"int\",\"float\",\"double\",\"long\",\"boolean\",\"FL_GeoData\"]}},{\"name\":\"type\",\"type\":\"FL_PropertyType\",\"doc\":\"One of STRING, INTEGER, FLOAT, DOUBLE, LONG, BOOLEAN, DATE, GEO\"}]},{\"type\":\"record\",\"name\":\"FL_BoundedRange\",\"doc\":\"* Bounded or unbounded range values\\r\\n\\t *\\r\\n\\t * ADDED IN 1.5\",\"fields\":[{\"name\":\"start\",\"type\":[{\"type\":\"string\",\"avro.java.string\":\"String\"},\"int\",\"float\",\"double\",\"long\",\"boolean\",\"FL_GeoData\",\"null\"],\"doc\":\"start of range, or null if unbounded start\"},{\"name\":\"end\",\"type\":[{\"type\":\"string\",\"avro.java.string\":\"String\"},\"int\",\"float\",\"double\",\"long\",\"boolean\",\"FL_GeoData\",\"null\"],\"doc\":\"end of range, or null if unbounded start\"},{\"name\":\"inclusive\",\"type\":\"boolean\",\"doc\":\"If true, range includes specified endpoint. If false, range is exclusive.\"},{\"name\":\"type\",\"type\":\"FL_PropertyType\",\"doc\":\"One of STRING, INTEGER, FLOAT, DOUBLE, LONG, BOOLEAN, DATE, GEO\"}]}],\"doc\":\"value of the Property to search on\",\"default\":null},{\"name\":\"variable\",\"type\":[{\"type\":\"string\",\"avro.java.string\":\"String\"},\"null\"],\"doc\":\"If not null/empty, the value is relative to a logical variable specified here (e.g. \\\"X\\\")\\r\\n\\t\\t *  Other parameters using the same logical variable name are relative to this value.\\r\\n\\t\\t *  For instance, for a {key=\\\"amount\\\", value=\\\"0.98\\\", variable=\\\"A\\\"} means that the value\\r\\n\\t\\t *  of amount is 0.98A.  Another amount might be 0.55A, and the property match engine\\r\\n\\t\\t *  (e.g. search engine, database query or pattern match algorithm) should understand\\r\\n\\t\\t *  the relative values.\\r\\n\\t\\t *\\r\\n\\t\\t *  If no variable is specified, then the value is an absolute number. For example,\\r\\n\\t\\t *  {key=\\\"amount\\\", value=\\\"0.98\\\"} refers to an amount of exactly 0.98.\",\"default\":\"\"},{\"name\":\"weight\",\"type\":[\"float\",\"null\"],\"doc\":\"Relative importance of this match criteria, where the default is 1.0.\",\"default\":1.0},{\"name\":\"similarity\",\"type\":[\"float\",\"null\"],\"doc\":\"Require similarity for fuzzy searches, the default is null.\",\"default\":1.0},{\"name\":\"include\",\"type\":\"boolean\",\"doc\":\"If true, INCLUDE all values matching this descriptor. If false, EXCLUDE all values matching this descriptor.\",\"default\":true},{\"name\":\"constraint\",\"type\":[{\"type\":\"enum\",\"name\":\"FL_Constraint\",\"doc\":\"* Property value matching constraints\\r\\n\\t *\\r\\n\\t * ADDED IN 1.5\\r\\n\\t * MOVED IN 2.0\",\"symbols\":[\"REQUIRED_EQUALS\",\"FUZZY_PARTIAL_OPTIONAL\",\"NOT\",\"OPTIONAL_EQUALS\",\"FUZZY_REQUIRED\"]},\"null\"],\"doc\":\"MUST_EQUALS, FUZZY_PARTIAL_OPTIONAL, MUST_NOT\"},{\"name\":\"typeMappings\",\"type\":{\"type\":\"array\",\"items\":{\"type\":\"record\",\"name\":\"FL_TypeMapping\",\"doc\":\"* Used to describe how an FL_PropertyDescriptor maps to given a type.\\r\\n\\t *\\r\\n\\t * ADDED IN 1.8\",\"fields\":[{\"name\":\"type\",\"type\":{\"type\":\"string\",\"avro.java.string\":\"String\"},\"doc\":\"The type that the mapping applies to *\"},{\"name\":\"memberKey\",\"type\":{\"type\":\"string\",\"avro.java.string\":\"String\"},\"doc\":\"field that the FL_Property maps to in the type *\"}]}},\"doc\":\"List of type mappings to match in *\",\"default\":null}]}");
  public static org.apache.avro.Schema getClassSchema() { return SCHEMA$; }
  /** field name or FL_PropertyTag (or FL_PathMatchTag) that could be searched on */
   private java.lang.String key;
  /** value of the Property to search on */
   private java.lang.Object range;
  /** If not null/empty, the value is relative to a logical variable specified here (e.g. "X")
		 *  Other parameters using the same logical variable name are relative to this value.
		 *  For instance, for a {key="amount", value="0.98", variable="A"} means that the value
		 *  of amount is 0.98A.  Another amount might be 0.55A, and the property match engine
		 *  (e.g. search engine, database query or pattern match algorithm) should understand
		 *  the relative values.
		 *
		 *  If no variable is specified, then the value is an absolute number. For example,
		 *  {key="amount", value="0.98"} refers to an amount of exactly 0.98. */
   private java.lang.String variable;
  /** Relative importance of this match criteria, where the default is 1.0. */
   private java.lang.Float weight;
  /** Require similarity for fuzzy searches, the default is null. */
   private java.lang.Float similarity;
  /** If true, INCLUDE all values matching this descriptor. If false, EXCLUDE all values matching this descriptor. */
   private boolean include;
  /** MUST_EQUALS, FUZZY_PARTIAL_OPTIONAL, MUST_NOT */
   private influent.idl.FL_Constraint constraint;
  /** List of type mappings to match in * */
   private java.util.List<influent.idl.FL_TypeMapping> typeMappings;

  /**
   * Default constructor.
   */
  public FL_PropertyMatchDescriptor() {}

  /**
   * All-args constructor.
   */
  public FL_PropertyMatchDescriptor(java.lang.String key, java.lang.Object range, java.lang.String variable, java.lang.Float weight, java.lang.Float similarity, java.lang.Boolean include, influent.idl.FL_Constraint constraint, java.util.List<influent.idl.FL_TypeMapping> typeMappings) {
    this.key = key;
    this.range = range;
    this.variable = variable;
    this.weight = weight;
    this.similarity = similarity;
    this.include = include;
    this.constraint = constraint;
    this.typeMappings = typeMappings;
  }

  public org.apache.avro.Schema getSchema() { return SCHEMA$; }
  // Used by DatumWriter.  Applications should not call. 
  public java.lang.Object get(int field$) {
    switch (field$) {
    case 0: return key;
    case 1: return range;
    case 2: return variable;
    case 3: return weight;
    case 4: return similarity;
    case 5: return include;
    case 6: return constraint;
    case 7: return typeMappings;
    default: throw new org.apache.avro.AvroRuntimeException("Bad index");
    }
  }
  // Used by DatumReader.  Applications should not call. 
  @SuppressWarnings(value="unchecked")
  public void put(int field$, java.lang.Object value$) {
    switch (field$) {
    case 0: key = (java.lang.String)value$; break;
    case 1: range = (java.lang.Object)value$; break;
    case 2: variable = (java.lang.String)value$; break;
    case 3: weight = (java.lang.Float)value$; break;
    case 4: similarity = (java.lang.Float)value$; break;
    case 5: include = (java.lang.Boolean)value$; break;
    case 6: constraint = (influent.idl.FL_Constraint)value$; break;
    case 7: typeMappings = (java.util.List<influent.idl.FL_TypeMapping>)value$; break;
    default: throw new org.apache.avro.AvroRuntimeException("Bad index");
    }
  }

  /**
   * Gets the value of the 'key' field.
   * field name or FL_PropertyTag (or FL_PathMatchTag) that could be searched on   */
  public java.lang.String getKey() {
    return key;
  }

  /**
   * Sets the value of the 'key' field.
   * field name or FL_PropertyTag (or FL_PathMatchTag) that could be searched on   * @param value the value to set.
   */
  public void setKey(java.lang.String value) {
    this.key = value;
  }

  /**
   * Gets the value of the 'range' field.
   * value of the Property to search on   */
  public java.lang.Object getRange() {
    return range;
  }

  /**
   * Sets the value of the 'range' field.
   * value of the Property to search on   * @param value the value to set.
   */
  public void setRange(java.lang.Object value) {
    this.range = value;
  }

  /**
   * Gets the value of the 'variable' field.
   * If not null/empty, the value is relative to a logical variable specified here (e.g. "X")
		 *  Other parameters using the same logical variable name are relative to this value.
		 *  For instance, for a {key="amount", value="0.98", variable="A"} means that the value
		 *  of amount is 0.98A.  Another amount might be 0.55A, and the property match engine
		 *  (e.g. search engine, database query or pattern match algorithm) should understand
		 *  the relative values.
		 *
		 *  If no variable is specified, then the value is an absolute number. For example,
		 *  {key="amount", value="0.98"} refers to an amount of exactly 0.98.   */
  public java.lang.String getVariable() {
    return variable;
  }

  /**
   * Sets the value of the 'variable' field.
   * If not null/empty, the value is relative to a logical variable specified here (e.g. "X")
		 *  Other parameters using the same logical variable name are relative to this value.
		 *  For instance, for a {key="amount", value="0.98", variable="A"} means that the value
		 *  of amount is 0.98A.  Another amount might be 0.55A, and the property match engine
		 *  (e.g. search engine, database query or pattern match algorithm) should understand
		 *  the relative values.
		 *
		 *  If no variable is specified, then the value is an absolute number. For example,
		 *  {key="amount", value="0.98"} refers to an amount of exactly 0.98.   * @param value the value to set.
   */
  public void setVariable(java.lang.String value) {
    this.variable = value;
  }

  /**
   * Gets the value of the 'weight' field.
   * Relative importance of this match criteria, where the default is 1.0.   */
  public java.lang.Float getWeight() {
    return weight;
  }

  /**
   * Sets the value of the 'weight' field.
   * Relative importance of this match criteria, where the default is 1.0.   * @param value the value to set.
   */
  public void setWeight(java.lang.Float value) {
    this.weight = value;
  }

  /**
   * Gets the value of the 'similarity' field.
   * Require similarity for fuzzy searches, the default is null.   */
  public java.lang.Float getSimilarity() {
    return similarity;
  }

  /**
   * Sets the value of the 'similarity' field.
   * Require similarity for fuzzy searches, the default is null.   * @param value the value to set.
   */
  public void setSimilarity(java.lang.Float value) {
    this.similarity = value;
  }

  /**
   * Gets the value of the 'include' field.
   * If true, INCLUDE all values matching this descriptor. If false, EXCLUDE all values matching this descriptor.   */
  public java.lang.Boolean getInclude() {
    return include;
  }

  /**
   * Sets the value of the 'include' field.
   * If true, INCLUDE all values matching this descriptor. If false, EXCLUDE all values matching this descriptor.   * @param value the value to set.
   */
  public void setInclude(java.lang.Boolean value) {
    this.include = value;
  }

  /**
   * Gets the value of the 'constraint' field.
   * MUST_EQUALS, FUZZY_PARTIAL_OPTIONAL, MUST_NOT   */
  public influent.idl.FL_Constraint getConstraint() {
    return constraint;
  }

  /**
   * Sets the value of the 'constraint' field.
   * MUST_EQUALS, FUZZY_PARTIAL_OPTIONAL, MUST_NOT   * @param value the value to set.
   */
  public void setConstraint(influent.idl.FL_Constraint value) {
    this.constraint = value;
  }

  /**
   * Gets the value of the 'typeMappings' field.
   * List of type mappings to match in *   */
  public java.util.List<influent.idl.FL_TypeMapping> getTypeMappings() {
    return typeMappings;
  }

  /**
   * Sets the value of the 'typeMappings' field.
   * List of type mappings to match in *   * @param value the value to set.
   */
  public void setTypeMappings(java.util.List<influent.idl.FL_TypeMapping> value) {
    this.typeMappings = value;
  }

  /** Creates a new FL_PropertyMatchDescriptor RecordBuilder */
  public static influent.idl.FL_PropertyMatchDescriptor.Builder newBuilder() {
    return new influent.idl.FL_PropertyMatchDescriptor.Builder();
  }
  
  /** Creates a new FL_PropertyMatchDescriptor RecordBuilder by copying an existing Builder */
  public static influent.idl.FL_PropertyMatchDescriptor.Builder newBuilder(influent.idl.FL_PropertyMatchDescriptor.Builder other) {
    return new influent.idl.FL_PropertyMatchDescriptor.Builder(other);
  }
  
  /** Creates a new FL_PropertyMatchDescriptor RecordBuilder by copying an existing FL_PropertyMatchDescriptor instance */
  public static influent.idl.FL_PropertyMatchDescriptor.Builder newBuilder(influent.idl.FL_PropertyMatchDescriptor other) {
    return new influent.idl.FL_PropertyMatchDescriptor.Builder(other);
  }
  
  /**
   * RecordBuilder for FL_PropertyMatchDescriptor instances.
   */
  public static class Builder extends org.apache.avro.specific.SpecificRecordBuilderBase<FL_PropertyMatchDescriptor>
    implements org.apache.avro.data.RecordBuilder<FL_PropertyMatchDescriptor> {

    private java.lang.String key;
    private java.lang.Object range;
    private java.lang.String variable;
    private java.lang.Float weight;
    private java.lang.Float similarity;
    private boolean include;
    private influent.idl.FL_Constraint constraint;
    private java.util.List<influent.idl.FL_TypeMapping> typeMappings;

    /** Creates a new Builder */
    private Builder() {
      super(influent.idl.FL_PropertyMatchDescriptor.SCHEMA$);
    }
    
    /** Creates a Builder by copying an existing Builder */
    private Builder(influent.idl.FL_PropertyMatchDescriptor.Builder other) {
      super(other);
    }
    
    /** Creates a Builder by copying an existing FL_PropertyMatchDescriptor instance */
    private Builder(influent.idl.FL_PropertyMatchDescriptor other) {
            super(influent.idl.FL_PropertyMatchDescriptor.SCHEMA$);
      if (isValidValue(fields()[0], other.key)) {
        this.key = data().deepCopy(fields()[0].schema(), other.key);
        fieldSetFlags()[0] = true;
      }
      if (isValidValue(fields()[1], other.range)) {
        this.range = data().deepCopy(fields()[1].schema(), other.range);
        fieldSetFlags()[1] = true;
      }
      if (isValidValue(fields()[2], other.variable)) {
        this.variable = data().deepCopy(fields()[2].schema(), other.variable);
        fieldSetFlags()[2] = true;
      }
      if (isValidValue(fields()[3], other.weight)) {
        this.weight = data().deepCopy(fields()[3].schema(), other.weight);
        fieldSetFlags()[3] = true;
      }
      if (isValidValue(fields()[4], other.similarity)) {
        this.similarity = data().deepCopy(fields()[4].schema(), other.similarity);
        fieldSetFlags()[4] = true;
      }
      if (isValidValue(fields()[5], other.include)) {
        this.include = data().deepCopy(fields()[5].schema(), other.include);
        fieldSetFlags()[5] = true;
      }
      if (isValidValue(fields()[6], other.constraint)) {
        this.constraint = data().deepCopy(fields()[6].schema(), other.constraint);
        fieldSetFlags()[6] = true;
      }
      if (isValidValue(fields()[7], other.typeMappings)) {
        this.typeMappings = data().deepCopy(fields()[7].schema(), other.typeMappings);
        fieldSetFlags()[7] = true;
      }
    }

    /** Gets the value of the 'key' field */
    public java.lang.String getKey() {
      return key;
    }
    
    /** Sets the value of the 'key' field */
    public influent.idl.FL_PropertyMatchDescriptor.Builder setKey(java.lang.String value) {
      validate(fields()[0], value);
      this.key = value;
      fieldSetFlags()[0] = true;
      return this; 
    }
    
    /** Checks whether the 'key' field has been set */
    public boolean hasKey() {
      return fieldSetFlags()[0];
    }
    
    /** Clears the value of the 'key' field */
    public influent.idl.FL_PropertyMatchDescriptor.Builder clearKey() {
      key = null;
      fieldSetFlags()[0] = false;
      return this;
    }

    /** Gets the value of the 'range' field */
    public java.lang.Object getRange() {
      return range;
    }
    
    /** Sets the value of the 'range' field */
    public influent.idl.FL_PropertyMatchDescriptor.Builder setRange(java.lang.Object value) {
      validate(fields()[1], value);
      this.range = value;
      fieldSetFlags()[1] = true;
      return this; 
    }
    
    /** Checks whether the 'range' field has been set */
    public boolean hasRange() {
      return fieldSetFlags()[1];
    }
    
    /** Clears the value of the 'range' field */
    public influent.idl.FL_PropertyMatchDescriptor.Builder clearRange() {
      range = null;
      fieldSetFlags()[1] = false;
      return this;
    }

    /** Gets the value of the 'variable' field */
    public java.lang.String getVariable() {
      return variable;
    }
    
    /** Sets the value of the 'variable' field */
    public influent.idl.FL_PropertyMatchDescriptor.Builder setVariable(java.lang.String value) {
      validate(fields()[2], value);
      this.variable = value;
      fieldSetFlags()[2] = true;
      return this; 
    }
    
    /** Checks whether the 'variable' field has been set */
    public boolean hasVariable() {
      return fieldSetFlags()[2];
    }
    
    /** Clears the value of the 'variable' field */
    public influent.idl.FL_PropertyMatchDescriptor.Builder clearVariable() {
      variable = null;
      fieldSetFlags()[2] = false;
      return this;
    }

    /** Gets the value of the 'weight' field */
    public java.lang.Float getWeight() {
      return weight;
    }
    
    /** Sets the value of the 'weight' field */
    public influent.idl.FL_PropertyMatchDescriptor.Builder setWeight(java.lang.Float value) {
      validate(fields()[3], value);
      this.weight = value;
      fieldSetFlags()[3] = true;
      return this; 
    }
    
    /** Checks whether the 'weight' field has been set */
    public boolean hasWeight() {
      return fieldSetFlags()[3];
    }
    
    /** Clears the value of the 'weight' field */
    public influent.idl.FL_PropertyMatchDescriptor.Builder clearWeight() {
      weight = null;
      fieldSetFlags()[3] = false;
      return this;
    }

    /** Gets the value of the 'similarity' field */
    public java.lang.Float getSimilarity() {
      return similarity;
    }
    
    /** Sets the value of the 'similarity' field */
    public influent.idl.FL_PropertyMatchDescriptor.Builder setSimilarity(java.lang.Float value) {
      validate(fields()[4], value);
      this.similarity = value;
      fieldSetFlags()[4] = true;
      return this; 
    }
    
    /** Checks whether the 'similarity' field has been set */
    public boolean hasSimilarity() {
      return fieldSetFlags()[4];
    }
    
    /** Clears the value of the 'similarity' field */
    public influent.idl.FL_PropertyMatchDescriptor.Builder clearSimilarity() {
      similarity = null;
      fieldSetFlags()[4] = false;
      return this;
    }

    /** Gets the value of the 'include' field */
    public java.lang.Boolean getInclude() {
      return include;
    }
    
    /** Sets the value of the 'include' field */
    public influent.idl.FL_PropertyMatchDescriptor.Builder setInclude(boolean value) {
      validate(fields()[5], value);
      this.include = value;
      fieldSetFlags()[5] = true;
      return this; 
    }
    
    /** Checks whether the 'include' field has been set */
    public boolean hasInclude() {
      return fieldSetFlags()[5];
    }
    
    /** Clears the value of the 'include' field */
    public influent.idl.FL_PropertyMatchDescriptor.Builder clearInclude() {
      fieldSetFlags()[5] = false;
      return this;
    }

    /** Gets the value of the 'constraint' field */
    public influent.idl.FL_Constraint getConstraint() {
      return constraint;
    }
    
    /** Sets the value of the 'constraint' field */
    public influent.idl.FL_PropertyMatchDescriptor.Builder setConstraint(influent.idl.FL_Constraint value) {
      validate(fields()[6], value);
      this.constraint = value;
      fieldSetFlags()[6] = true;
      return this; 
    }
    
    /** Checks whether the 'constraint' field has been set */
    public boolean hasConstraint() {
      return fieldSetFlags()[6];
    }
    
    /** Clears the value of the 'constraint' field */
    public influent.idl.FL_PropertyMatchDescriptor.Builder clearConstraint() {
      constraint = null;
      fieldSetFlags()[6] = false;
      return this;
    }

    /** Gets the value of the 'typeMappings' field */
    public java.util.List<influent.idl.FL_TypeMapping> getTypeMappings() {
      return typeMappings;
    }
    
    /** Sets the value of the 'typeMappings' field */
    public influent.idl.FL_PropertyMatchDescriptor.Builder setTypeMappings(java.util.List<influent.idl.FL_TypeMapping> value) {
      validate(fields()[7], value);
      this.typeMappings = value;
      fieldSetFlags()[7] = true;
      return this; 
    }
    
    /** Checks whether the 'typeMappings' field has been set */
    public boolean hasTypeMappings() {
      return fieldSetFlags()[7];
    }
    
    /** Clears the value of the 'typeMappings' field */
    public influent.idl.FL_PropertyMatchDescriptor.Builder clearTypeMappings() {
      typeMappings = null;
      fieldSetFlags()[7] = false;
      return this;
    }

    @Override
    public FL_PropertyMatchDescriptor build() {
      try {
        FL_PropertyMatchDescriptor record = new FL_PropertyMatchDescriptor();
        record.key = fieldSetFlags()[0] ? this.key : (java.lang.String) defaultValue(fields()[0]);
        record.range = fieldSetFlags()[1] ? this.range : (java.lang.Object) defaultValue(fields()[1]);
        record.variable = fieldSetFlags()[2] ? this.variable : (java.lang.String) defaultValue(fields()[2]);
        record.weight = fieldSetFlags()[3] ? this.weight : (java.lang.Float) defaultValue(fields()[3]);
        record.similarity = fieldSetFlags()[4] ? this.similarity : (java.lang.Float) defaultValue(fields()[4]);
        record.include = fieldSetFlags()[5] ? this.include : (java.lang.Boolean) defaultValue(fields()[5]);
        record.constraint = fieldSetFlags()[6] ? this.constraint : (influent.idl.FL_Constraint) defaultValue(fields()[6]);
        record.typeMappings = fieldSetFlags()[7] ? this.typeMappings : (java.util.List<influent.idl.FL_TypeMapping>) defaultValue(fields()[7]);
        return record;
      } catch (Exception e) {
        throw new org.apache.avro.AvroRuntimeException(e);
      }
    }
  }
}

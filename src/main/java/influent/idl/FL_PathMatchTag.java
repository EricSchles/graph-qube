/**
 * Autogenerated by Avro
 * 
 * DO NOT EDIT DIRECTLY
 */
package influent.idl;  
@SuppressWarnings("all")
/** * In addition to PropertyTags, a PropertyMatchDescriptor might also be one of these.
	 *
	 * ADDED IN 1.5 */
@org.apache.avro.specific.AvroGenerated
public enum FL_PathMatchTag { 
  PATH_LENGTH, PATH_TIME, PATH_SOURCES, PATH_DESTS  ;
  public static final org.apache.avro.Schema SCHEMA$ = new org.apache.avro.Schema.Parser().parse("{\"type\":\"enum\",\"name\":\"FL_PathMatchTag\",\"namespace\":\"influent.idl\",\"doc\":\"* In addition to PropertyTags, a PropertyMatchDescriptor might also be one of these.\\r\\n\\t *\\r\\n\\t * ADDED IN 1.5\",\"symbols\":[\"PATH_LENGTH\",\"PATH_TIME\",\"PATH_SOURCES\",\"PATH_DESTS\"]}");
  public static org.apache.avro.Schema getClassSchema() { return SCHEMA$; }
}

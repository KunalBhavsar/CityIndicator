package co.cityindicator.core;

/**
 * Details of the contact related to particular entity.
 * Created by Kunal Bhavsar on 28/1/16.
 */
public class Contact extends Base {

    /**
     * Types of the contact constants
     */
    public static final String TYPE_MOBILE_NUMBER = "MobileNumber";
    public static final String TYPE_EMAIL_ADDRESS = "EmailAddress";
    public static final String TYPE_RESIDENTIAL_ADDRESS = "ResidentialAddress";

    /**
     * Data types of the contact value constants
     */
    public static final String DATATYPE_INTEGER = "Integer";
    public static final String DATATYPE_LONG = "Long";
    public static final String DATATYPE_STRING = "String";
    public static final String DATATYPE_DOUBLE = "Double";
    public static final String DATATYPE_FLOAT = "Float";

    /**
     * Tyoe of the contact (eg MobileNumber, Email address)
     */
    private String type;
    /**
     * Datatype of the value (eg Integer, String)
     */
    private String datatype;
    /**
     * Actual contact value.
     */
    private String value;
    /**
     * Entity to which the contact belongs.
     */
    private Entity entity;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getDatatype() {
        return datatype;
    }

    public void setDatatype(String datatype) {
        this.datatype = datatype;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public Entity getEntity() {
        return entity;
    }

    public void setEntity(Entity entity) {
        this.entity = entity;
    }
}

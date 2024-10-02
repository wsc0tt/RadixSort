/**
 * @author William Scott
 * Field class created a key-value data type
 */

public class Field {
    public String key;
    public String value;

    // Constructors
    public Field() {
        this(null, null);
    }
    public Field (String key, String value) {
        this.key = key;
        this.value = value;
    }
    // toString method
    public String toString() {
        return key + " : " + value;
    }
}

package exercice4;

public class StringInsteadOfInteger extends Throwable {

    public StringInsteadOfInteger() {
    }

    public StringInsteadOfInteger(String message) {
        super(message);
    }

    public StringInsteadOfInteger(String message, Throwable cause) {
        super(message, cause);
    }
}

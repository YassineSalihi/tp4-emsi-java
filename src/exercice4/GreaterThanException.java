package exercice4;

public class GreaterThanException extends Throwable {

    public GreaterThanException() {
    }

    public GreaterThanException(String message) {
        super(message);
    }

    public GreaterThanException(String message, Throwable cause) {
        super(message, cause);
    }
}

package exercice4;

public class NegativeSidesException extends Throwable {
    public NegativeSidesException(String message) {
        super(message);
    }

    public NegativeSidesException(String message, Throwable cause) {
        super(message, cause);
    }

    public NegativeSidesException() {

    }
}

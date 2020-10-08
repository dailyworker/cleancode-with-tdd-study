package exception;

public class RoundLengthOverflowException extends RuntimeException {
    public RoundLengthOverflowException() {
        super();
    }

    public RoundLengthOverflowException(String message) {
        super(message);
    }
}

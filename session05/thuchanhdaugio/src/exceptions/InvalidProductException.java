package exceptions;

public class InvalidProductException extends RuntimeException {
    private String message;

    public InvalidProductException(String message) {
        super(message);
    }

    @Override
    public String getMessage() {
        return message;
    }
}

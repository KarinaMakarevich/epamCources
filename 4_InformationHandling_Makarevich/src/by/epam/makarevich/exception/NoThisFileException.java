package by.epam.makarevich.exception;

public class NoThisFileException extends Exception {
    public NoThisFileException() {
    }

    public NoThisFileException(String message, Throwable exception) {
        super(message, exception);
    }

    public NoThisFileException(String message) {
        super(message);
    }

    public NoThisFileException(Throwable exception) {
        super(exception);
    }
}

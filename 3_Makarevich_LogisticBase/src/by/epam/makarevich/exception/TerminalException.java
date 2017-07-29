package by.epam.makarevich.exception;

public class TerminalException extends Exception {
    public TerminalException() {
    }

    public TerminalException(String message, Throwable exception) {
        super(message, exception);
    }

    public TerminalException(String message) {
        super(message);
    }

    public TerminalException(Throwable exception) {
        super(exception);
    }
}

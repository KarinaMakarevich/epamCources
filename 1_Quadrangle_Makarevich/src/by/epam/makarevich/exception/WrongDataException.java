package by.epam.makarevich.exception;

import static java.lang.String.*;

public class WrongDataException extends Exception {
    public WrongDataException() {
    }

    public WrongDataException(String message, Throwable exception) {
        super(message, exception);
    }

    public WrongDataException(String message) {
        super(message);
    }

    public WrongDataException(Throwable exception) {
        super(valueOf(exception));
    }
}

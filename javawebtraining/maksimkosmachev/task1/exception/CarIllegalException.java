package by.epam.javawebtraining.maksimkosmachev.task1.exception;

public class CarIllegalException extends Exception {
    public CarIllegalException() {
    }

    public CarIllegalException(String message) {
        super(message);
    }

    public CarIllegalException(String message, Throwable cause) {
        super(message, cause);
    }

    public CarIllegalException(Throwable cause) {
        super(cause);
    }

    public CarIllegalException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}

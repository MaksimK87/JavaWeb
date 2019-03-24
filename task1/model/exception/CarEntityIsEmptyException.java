package by.epam.javawebtraining.maksimkosmachev.task1.model.exception;

public class CarEntityIsEmptyException extends CarException {
    public CarEntityIsEmptyException() {
    }

    public CarEntityIsEmptyException(String message) {
        super(message);
    }
}

package by.epam.javawebtraining.maksimkosmachev.task1.model.exception;

public class TaxiParkIsEmptyException extends TaxiParkException {
    public TaxiParkIsEmptyException() {
    }

    public TaxiParkIsEmptyException(String message) {
        super(message);
    }
}

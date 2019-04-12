/**
 * @author - Maksim Kosmachev
 */
package by.epam.javawebtraining.maksimkosmachev.task06.model.exception;

public class TaxiParkIsEmptyException extends TaxiParkException {
    public TaxiParkIsEmptyException() {
    }

    public TaxiParkIsEmptyException(String message) {
        super(message);
    }
}

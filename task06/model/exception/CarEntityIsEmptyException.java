/**
 * @author - Maksim Kosmachev
 */
package by.epam.javawebtraining.maksimkosmachev.task06.model.exception;

public class CarEntityIsEmptyException extends CarException {
    public CarEntityIsEmptyException() {
    }

    public CarEntityIsEmptyException(String message) {
        super(message);
    }
}

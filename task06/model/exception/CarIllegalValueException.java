/**
 * @author - Maksim Kosmachev
 */
package by.epam.javawebtraining.maksimkosmachev.task06.model.exception;

public class CarIllegalValueException extends CarException {

    public CarIllegalValueException() {
    }

    public CarIllegalValueException(String message) {
        super(message);
    }
}

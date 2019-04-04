/**
 *  @author - Maksim Kosmachev
 */
package by.epam.javawebtraining.maksimkosmachev.task05.model.exception;

public class CarParkNotFoundException extends CarLogicException {

    public CarParkNotFoundException() {
    }

    public CarParkNotFoundException(String message) {

        super(message);
    }
}

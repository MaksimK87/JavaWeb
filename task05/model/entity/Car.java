/**
 * @author - Maksim Kosmachev
 */
package by.epam.javawebtraining.maksimkosmachev.task05.model.entity;

import by.epam.javawebtraining.maksimkosmachev.task05.model.exception.CarParkNotFoundException;

import by.epam.javawebtraining.maksimkosmachev.task05.util.DataConfiguration;
import org.apache.log4j.Logger;

import java.util.Objects;

public class Car extends Thread {

    private static Logger logger = Logger.getLogger(Car.class);

    private final static long WAITING_TIME = DataConfiguration.getProperty("WAITING_TIME");

    private CarPark carPark;


    public Car(CarPark carPark) {
        this.carPark = carPark;
        logger.info("Car number " + "# " + this.getId() + " was created");


    }

    @Override
    public void run() {
        ParkPlace place = null;
        try {
            place = carPark.getParkPlace(WAITING_TIME);
            logger.info("Car # " + this.getId() + " has got place << " + place.getNumber() + " >>");
            place.usePlace();
            logger.info("Car # " + this.getId() + " using parking place number << " + place.getNumber() + " >>");
        } catch (CarParkNotFoundException e) {
            logger.error("Car park is not found");
        } finally {
            if (place != null) {
                logger.info("Car # " + this.getId() + " left parking place number "
                        + "<< " + place.getNumber() + " >>");
                carPark.returnParkPlace(place);
            }

        }


    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Car car = (Car) o;
        return carPark.equals(car.carPark);
    }

    @Override
    public int hashCode() {
        return Objects.hash(carPark);
    }

    @Override
    public String toString() {
        return "Car{" +
                "carPark=" + carPark +
                '}';
    }
}

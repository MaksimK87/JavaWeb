package by.epam.javawebtraining.maksimkosmachev.task1.model.entity;

import by.epam.javawebtraining.maksimkosmachev.task1.model.exception.CarEntityIsEmptyException;
import by.epam.javawebtraining.maksimkosmachev.task1.model.exception.CarException;
import org.apache.log4j.Logger;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class TaxiPark {

    private static Logger logger = Logger.getLogger(TaxiPark.class);
    private List<Car> cars;

    public TaxiPark(List<Car> cars) {
        this.cars = cars;
    }

    public TaxiPark() {
        cars = new ArrayList<>();
    }

    public TaxiPark(TaxiPark taxiPark) {
        this.cars = new ArrayList<>();
        for (Car car: taxiPark.getCars()) {
            this.cars.add(new Car(car));
        }


    }

    public List<Car> getCars() {
        return cars;
    }

    public void setCars(List<Car> cars) throws CarException {
        if (cars != null) {
            this.cars = cars;
        } else {
            logger.error("Collection of cars must be not null", new CarEntityIsEmptyException());
            throw new CarEntityIsEmptyException();
        }
    }

    public void add(Car car) throws CarException {
        if (car != null) {
            cars.add(car);
        } else {
            logger.error("car must be not null", new CarEntityIsEmptyException());
            throw new CarEntityIsEmptyException();
        }

    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof TaxiPark)) {
            return false;
        }
        TaxiPark taxiPark = (TaxiPark) o;
        return Objects.equals(cars, taxiPark.cars);
    }

    @Override
    public int hashCode() {
        return Objects.hash(cars);
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder("TaxiPark: " + "\n");
        for (Car car : cars) {
            builder.append(car).append("\n");
        }
        return builder + "";
    }


}

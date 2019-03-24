package by.epam.javawebtraining.maksimkosmachev.task1.model.entity;

import by.epam.javawebtraining.maksimkosmachev.task1.model.entity.enums.CarManufacturer;
import by.epam.javawebtraining.maksimkosmachev.task1.model.entity.enums.TypeOfFuel;
import by.epam.javawebtraining.maksimkosmachev.task1.model.exception.CarException;
import by.epam.javawebtraining.maksimkosmachev.task1.model.exception.CarIllegalValueException;
import org.apache.log4j.Logger;

import java.util.Objects;


public class Car implements Comparable<Car> {
    private static final Logger logger = Logger.getLogger(Car.class);

    private final static int YEAR_OF_ISSUE_FROM = 1985; // older cars are not used
    private static final double MAX_ENGINE_VALUE = 10.0; // engines can have this value or less
    private CarManufacturer manufacturer;
    private int yearOfIssue;
    private int price;
    private TypeOfFuel fuelType;
    private double consumption;
    private double engineValue;
    private int kilometrage;
    private double fare;

    public Car(CarManufacturer manufacturer, int yearOfIssue, int price, TypeOfFuel fuelType,
               double consumption, double engineValue, int kilometrage, double fare) {
        this.manufacturer = manufacturer;
        this.yearOfIssue = yearOfIssue;
        this.price = price;
        this.fuelType = fuelType;
        this.consumption = consumption;
        this.engineValue = engineValue;
        this.kilometrage = kilometrage;
        this.fare = fare;
    }


    public Car() {

    }

    public Car(Car car) {
        this.manufacturer = car.manufacturer;
        this.yearOfIssue = car.yearOfIssue;
        this.price = car.price;
        this.fuelType = car.fuelType;
        this.consumption = car.consumption;
        this.engineValue = car.engineValue;
        this.kilometrage = car.kilometrage;
        this.fare = car.fare;

    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        if (price > 0) {
            this.price = price;
        } else {
            logger.error("Incorrect value of price", new CarIllegalValueException());
            this.price = -1;     // incorrect value of price
        }


    }


    public double getConsumption() {

        return consumption;
    }

    public void setConsumption(double consumption) {
        if (consumption > 0) {
            this.consumption = consumption;
        } else {
            logger.error("Incorrect value of consumption", new CarIllegalValueException());
            this.consumption = -1;      // incorrect value of consumption
        }
    }


    public int getYearOfIssue() {

        return yearOfIssue;
    }

    public void setYearOfIssue(int yearOfIssue) {
        if (yearOfIssue > YEAR_OF_ISSUE_FROM) {
            this.yearOfIssue = yearOfIssue;
        } else {
            logger.error("Incorrect value car's year of issue", new CarIllegalValueException());
            this.yearOfIssue = -1;       // incorrect value of car's year of issue
        }

    }

    public TypeOfFuel getFuelType() {

        return fuelType;
    }

    public void setFuelType(TypeOfFuel fuelType) {
        this.fuelType = fuelType;
    }


    public int getKilometrage() {

        return kilometrage;
    }

    public void setKilometrage(int kilometrage) {
        if (kilometrage > 0) {
            this.kilometrage = kilometrage;
        } else {
            logger.error("Incorrect value of kilometrage", new CarIllegalValueException());
            this.kilometrage = -1; // incorrect value of kilometrage
        }
    }

    public double getFare() {

        return fare;
    }

    public void setFare(double fare) throws CarException {
        if (fare > 0) {
            this.fare = fare;
        } else {
            this.fare = -1;
            logger.error("Incorrect value of fare", new CarIllegalValueException());
        }
    }

    public double getEngineValue() {
        return engineValue;
    }

    public void setEngineValue(double engineValue) {
        if (engineValue > 0 && engineValue <= MAX_ENGINE_VALUE) {
            this.engineValue = engineValue;
        } else {
            this.engineValue = -1;
            logger.error("Incorrect value of engine", new CarIllegalValueException());
        }
    }

    public CarManufacturer getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(CarManufacturer manufacturer) {
        this.manufacturer = manufacturer;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Car)) {
            return false;
        }
        Car car = (Car) o;
        return yearOfIssue == car.yearOfIssue &&
                price == car.price &&
                Double.compare(car.consumption, consumption) == 0 &&
                Double.compare(car.engineValue, engineValue) == 0 &&
                kilometrage == car.kilometrage &&
                Double.compare(car.fare, fare) == 0 &&
                manufacturer == car.manufacturer &&
                fuelType == car.fuelType;
    }


    @Override
    public int hashCode() {
        return Objects.hash(manufacturer, yearOfIssue, price, fuelType, consumption, engineValue, kilometrage, fare);
    }

    @Override
    public String toString() {
        return "Car{" +
                "manufacturer=" + manufacturer +
                ", yearOfIssue=" + yearOfIssue + "year" +
                ", price=" + price + "$" +
                ", fuelType=" + fuelType.toString() +
                ", consumption=" + consumption + "L/100 km" +
                "," + "\n" + "engineValue=" + engineValue + "L" +
                ", kilometrage=" + kilometrage + "km" +
                ", fare=" + fare + "rub." +
                '}';
    }

    @Override
    public int compareTo(Car o) {
        Double thisCar = new Double(this.getConsumption());
        Double comparedCar = new Double(o.getConsumption());
        return thisCar.compareTo(comparedCar);
    }
}

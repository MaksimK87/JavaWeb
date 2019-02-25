package by.epam.javawebtraining.maksimkosmachev.task1.entity;

import by.epam.javawebtraining.maksimkosmachev.task1.entity.enums.CarManufacturer;
import by.epam.javawebtraining.maksimkosmachev.task1.entity.enums.TypeOfFuel;

import java.util.Objects;

public class Car {
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

    Car(Car car) {
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
        this.price = price;
    }


    public double getConsumption() {
        return consumption;
    }

    public void setConsumption(double consumption) {
        this.consumption = consumption;
    }


    public int getYearOfIssue() {

        return yearOfIssue;
    }

    public void setYearOfIssue(int yearOfIssue) {
        if (yearOfIssue > 1985) {                      // older cars are not used in taxipark
            this.yearOfIssue = yearOfIssue;
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
        }
    }

    public double getFare() {

        return fare;
    }

    public void setFare(double fare) {
        if (fare > 0) {
            this.fare = fare;
        }
    }

    public double getEngineValue() {
        return engineValue;
    }

    public void setEngineValue(double engineValue) {
        if (engineValue > 0 && engineValue < 10) {
            this.engineValue = engineValue;
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
        if (this == o) return true;
        if (!(o instanceof Car)) return false;
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
        return Objects.hash(manufacturer, yearOfIssue, price, fuelType, consumption,
                engineValue, kilometrage, fare);
    }

    @Override
    public String toString() {
        return "Car{" +
                "manufacturer=" + manufacturer +
                ", yearOfIssue=" + yearOfIssue + "year" +
                ", price=" + price + "$" +
                ", fuelType=" + fuelType.toString() +
                ", consumption=" + consumption + "L/100 km" +
                ", engineValue=" + engineValue + "L" +
                ", kilometrage=" + kilometrage + "km" +
                ", fare=" + fare + "rub." +
                '}';
    }
}

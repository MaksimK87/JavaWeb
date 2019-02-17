package by.epam.javawebtraining.maksimkosmachev.task1.entity;

import java.util.Objects;

public class Car {
    private int price;
    private double consumption;
    private int yearOfIssue;
    private String fuelType;
    private int kilometrage;
    private double engineValue;
    private String manufacturer;
    private double fare;

    public Car(int price, double consumption, int yearOfIssue, String fuelType, int kilometrage, double engineValue, String manufacturer, double fare) {
        this.price = price;
        this.consumption = consumption;
        this.yearOfIssue = yearOfIssue;
        this.fuelType = fuelType;
        this.kilometrage = kilometrage;
        this.engineValue = engineValue;
        this.manufacturer = manufacturer;
        this.fare = fare;
    }

    Car() {

    }

    Car (Car car){
       this.price=car.price;
        this.consumption = car.consumption;
        this.yearOfIssue = car.yearOfIssue;
        this.fuelType = car.fuelType;
        this.kilometrage = car.kilometrage;
        this.engineValue = car.engineValue;
        this.manufacturer = car.manufacturer;
        this.fare = car.fare;

    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        if (price > 0) {
            this.price = price;
        }
    }

    public double getConsumption() {
        return consumption;
    }

    public void setConsumption(double consumption) {
        if (consumption > 0) {
            this.consumption = consumption;
        }
    }

    public int getYearOfIssue() {
        return yearOfIssue;
    }

    public void setYearOfIssue(int yearOfIssue) {
        if (yearOfIssue > 0) {
            this.yearOfIssue = yearOfIssue;
        }
    }

    public String getFuelType() {
        return fuelType;
    }

    public void setFuelType(String fuelType) {
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

    public void setEngineValue(int engineValue) {
        this.engineValue = engineValue;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Car car = (Car) o;
        return price == car.price &&
                Double.compare(car.consumption, consumption) == 0 &&
                yearOfIssue == car.yearOfIssue &&
                kilometrage == car.kilometrage &&
                Objects.equals(fuelType, car.fuelType);
    }

    @Override
    public int hashCode() {
        return Objects.hash(price, consumption, yearOfIssue, fuelType, kilometrage);
    }


    @Override
    public String toString() {
        return "Car{" +
                "price=" + price + "$ "+
                ", consumption=" + consumption + " L/100 km"+
                ", yearOfIssue=" + yearOfIssue + "year "+
                ", fuelType='" + fuelType + '\'' +
                ", kilometrage=" + kilometrage +" km "+
                ", engineValue=" + engineValue + "cm 3"+
                ", manufacturer='" + manufacturer + '\'' +
                ", fare=" + fare + "rub."+
                '}';
    }
}

package by.epam.javawebtraining.maksimkosmachev.task1.entity;

import java.util.ArrayList;
import java.util.List;

public class TaxiPark {


    private List<Car> cars;

    public TaxiPark(List<Car> cars) {
        this.cars = cars;
    }

    TaxiPark() {
        cars = new ArrayList<>();
    }

    public TaxiPark(TaxiPark taxiPark) {

        this.cars = taxiPark.cars;
    }

    public List<Car> getCars() {
        return cars;
    }

    public void setCars(List<Car> cars) {
        this.cars = cars;

    }

    public void add(Car car) {
        cars.add(car);
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder("TaxiPark: ");
        for (Car car : cars) {
            builder.append(car).append("\n");
        }
        return builder + "";
    }
}

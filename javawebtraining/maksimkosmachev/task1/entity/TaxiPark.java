package by.epam.javawebtraining.maksimkosmachev.task1.entity;

import by.epam.javawebtraining.maksimkosmachev.task1.exception.CarIllegalException;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class TaxiPark  {


    private List<Car> cars;

    public TaxiPark(List<Car> cars) {
        this.cars = cars;
    }

    public TaxiPark() {
        cars = new ArrayList<>();
    }

    public TaxiPark(TaxiPark taxiPark) {

        this.cars = taxiPark.cars;
    }

    public List<Car> getCars() {
        return cars;
    }

    public void setCars(List<Car> cars) throws CarIllegalException {
        if(cars==null){
            throw new CarIllegalException("Collection of cars must be not null");
        }
        this.cars = cars;

    }

    public void add(Car car) throws CarIllegalException {
        if (car==null){
            throw new CarIllegalException("car must be not null");
        }
        cars.add(car);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof TaxiPark)) return false;
        TaxiPark taxiPark = (TaxiPark) o;
        return Objects.equals(cars, taxiPark.cars);
    }

    @Override
    public int hashCode() {
        return Objects.hash(cars);
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder("TaxiPark: "+"\n");
        for (Car car : cars) {
            builder.append(car).append("\n");
        }
        return builder + "";
    }




}

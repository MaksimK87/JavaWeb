package by.epam.javawebtraining.maksimkosmachev.task1.model;

import by.epam.javawebtraining.maksimkosmachev.task1.entity.Car;
import by.epam.javawebtraining.maksimkosmachev.task1.entity.Lorry;
import by.epam.javawebtraining.maksimkosmachev.task1.entity.PassengerCar;
import by.epam.javawebtraining.maksimkosmachev.task1.entity.TaxiPark;
import by.epam.javawebtraining.maksimkosmachev.task1.exception.CarIllegalException;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SortByParameter {
    public static int findGeneralQuantity(TaxiPark taxiPark) {

        return taxiPark.getCars().size();
    }

    public static TaxiPark findbyYearOfIssue(int yearOfIssueFrom, int yearOfIssueTo, TaxiPark taxiPark) {
        List<Car> foundedCars = new ArrayList<>();
        TaxiPark sortedPark = new TaxiPark(foundedCars);
        for (Car tax : taxiPark.getCars()) {
            if (tax.getYearOfIssue() >= yearOfIssueFrom && tax.getYearOfIssue() <= yearOfIssueTo) {
                foundedCars.add(tax);

            }
        }

        return sortedPark;
    }

    public static TaxiPark orderByConsumption(TaxiPark taxiPark) {
        TaxiPark sortedPark = new TaxiPark(taxiPark);
        Collections.sort(sortedPark.getCars());
        return sortedPark;
    }

    public static Car findTheOldestCar(TaxiPark taxiPark) {
        Car oldestCar;
        oldestCar = taxiPark.getCars().get(0);
        for (int i = 1; i < taxiPark.getCars().size(); i++) {
            if (taxiPark.getCars().get(i).getYearOfIssue() <= oldestCar.getYearOfIssue()) {
                oldestCar = taxiPark.getCars().get(i);
            }
        }
        return oldestCar;
    }

    public static TaxiPark findAllLorry(TaxiPark taxiPark) throws CarIllegalException {
        TaxiPark allLorry = new TaxiPark();
        for (Car car : taxiPark.getCars()) {
            if (car instanceof Lorry) {
                allLorry.add(car);
            }
        }
        if (allLorry.getCars().isEmpty()) {
            System.out.println("Taxi park doesn't have lorries");
        }

        return allLorry;
    }

    public static TaxiPark findAllPassangerCar(TaxiPark taxiPark) throws CarIllegalException {
        TaxiPark allPassCar = new TaxiPark();
        for (Car car : taxiPark.getCars()) {
            if (car instanceof PassengerCar) {
                allPassCar.add(car);
            }
        }
        if (allPassCar.getCars().isEmpty()) {
            System.out.println("Taxi park doesn't have passenger cars");
        }

        return allPassCar;
    }
}

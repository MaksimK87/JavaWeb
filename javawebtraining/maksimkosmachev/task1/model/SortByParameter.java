package by.epam.javawebtraining.maksimkosmachev.task1.model;

import by.epam.javawebtraining.maksimkosmachev.task1.entity.Car;
import by.epam.javawebtraining.maksimkosmachev.task1.entity.TaxiPark;

import java.util.ArrayList;
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
        TaxiPark sortedPark = new TaxiPark(taxiPark.getCars());
        double temp;
        for (int i = sortedPark.getCars().size() - 1; i >= 1; i--) {
            for (int j = 0; j < i; j++) {
                if (sortedPark.getCars().get(j).getConsumption() > sortedPark.getCars().get(j + 1).getConsumption()) {
                    temp = sortedPark.getCars().get(j + 1).getConsumption();
                    sortedPark.getCars().get(j + 1).setConsumption(sortedPark.getCars().get(j).getConsumption());
                    sortedPark.getCars().get(j).setConsumption(temp);
                }
            }
        }

        return sortedPark;
    }

    public static Car theOldestCar(TaxiPark taxiPark) {
        Car oldestCar;
        oldestCar = taxiPark.getCars().get(0);
        for (int i = 1; i < taxiPark.getCars().size(); i++) {
            if (taxiPark.getCars().get(i).getYearOfIssue() <= oldestCar.getYearOfIssue()) {
                oldestCar = taxiPark.getCars().get(i);
            }
        }
        return oldestCar;
    }
}

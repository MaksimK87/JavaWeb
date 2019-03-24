package by.epam.javawebtraining.maksimkosmachev.task1.model.logic;

import by.epam.javawebtraining.maksimkosmachev.task1.model.entity.Car;
import by.epam.javawebtraining.maksimkosmachev.task1.model.entity.Lorry;
import by.epam.javawebtraining.maksimkosmachev.task1.model.entity.PassengerCar;
import by.epam.javawebtraining.maksimkosmachev.task1.model.entity.TaxiPark;
import by.epam.javawebtraining.maksimkosmachev.task1.model.exception.CarException;
import org.apache.log4j.Logger;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SortByParameter {
    private static Logger logger = Logger.getLogger(SortByParameter.class);

    public static int findGeneralQuantity(TaxiPark taxiPark) {
        logger.info("\n General quantity of cars in park: " + taxiPark.getCars().size() +"\n");
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
        logger.info("\n Was founded cars by year of issue :" + sortedPark + "\n");
        return sortedPark;
    }

    public static TaxiPark orderByConsumption(TaxiPark taxiPark) {
        TaxiPark sortedPark = new TaxiPark(taxiPark);
        Collections.sort(sortedPark.getCars());
        logger.info("\n Park ordered by consumption: " + sortedPark+"\n");
        return sortedPark;
    }

    public static Car findTheOldestCar(TaxiPark taxiPark) {
        Car oldestCar;
        oldestCar = taxiPark.getCars().get(0);
        for (int i = 1; i < taxiPark.getCars().size(); i++) {
            if(taxiPark.getCars().get(i)!=null) {
                if (taxiPark.getCars().get(i).getYearOfIssue() <= oldestCar.getYearOfIssue()) {
                    oldestCar = taxiPark.getCars().get(i);
                }
            }
        }
        return oldestCar;
    }

    public static TaxiPark findAllLorry(TaxiPark taxiPark) throws CarException {
        TaxiPark allLorry = new TaxiPark();
        for (Car car : taxiPark.getCars()) {
            if (car instanceof Lorry) {
                allLorry.add(car);
            }
        }
        if (allLorry.getCars().isEmpty()) {
            logger.info("\n Taxi park doesn't have any lorries\n");
        }
        logger.info("\n Taxi park has lorries, such as: " + allLorry+ "\n");
        return allLorry;
    }

    public static TaxiPark findAllPassangerCar(TaxiPark taxiPark) throws CarException {
        TaxiPark allPassCar = new TaxiPark();
        for (Car car : taxiPark.getCars()) {
            if (car instanceof PassengerCar) {
                allPassCar.add(car);
            }
        }
        if (allPassCar.getCars().isEmpty()) {
            logger.info("\n Taxi park doesn't have any passenger cars \n");
        }
        logger.info("\n Taxi park has passenger cars, such as: " + allPassCar +"\n");
        return allPassCar;
    }
}

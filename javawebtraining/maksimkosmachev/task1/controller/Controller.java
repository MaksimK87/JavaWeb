package by.epam.javawebtraining.maksimkosmachev.task1.controller;

import by.epam.javawebtraining.maksimkosmachev.task1.entity.Car;
import by.epam.javawebtraining.maksimkosmachev.task1.entity.TaxiPark;
import by.epam.javawebtraining.maksimkosmachev.task1.model.SortByParameter;
import by.epam.javawebtraining.maksimkosmachev.task1.util.RandomCreator;
import by.epam.javawebtraining.maksimkosmachev.task1.view.Printable;

import java.util.ArrayList;
import java.util.List;

public class Controller {
    public void launch() {
        Printable printer = new Printable();
        List<Car> cars = new ArrayList<>();
        RandomCreator randomCreator = new RandomCreator();
        TaxiPark taxiPark = new TaxiPark(randomCreator.createRandomCars());

        printer.print(taxiPark);
        System.out.println("The oldest car is: " + SortByParameter.theOldestCar(taxiPark).toString());

        System.out.println("Year of issue range:" + SortByParameter.findbyYearOfIssue(1991, 2000,
                taxiPark).toString());
        System.out.println("Quantity of car : " + SortByParameter.findGeneralQuantity(taxiPark));
        System.out.println("Sorted by consumption " + SortByParameter.orderByConsumption(taxiPark));
    }
}


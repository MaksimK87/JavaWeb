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
        TaxiPark taxiPark = null;
        try {
            taxiPark = new TaxiPark(randomCreator.createRandomCars());
            System.out.println("Quantity of car : "+"\n" + SortByParameter.findGeneralQuantity(taxiPark) + "\n");
            printer.print(taxiPark);
            System.out.println("The oldest car is: "+"\n" + SortByParameter.theOldestCar(taxiPark).toString() + "\n");
            System.out.println("Year of issue range:"+"\n" + SortByParameter.findbyYearOfIssue(1991,
                    2018, taxiPark).toString() + "\n");
            System.out.println("Sorted by consumption "+"\n" + SortByParameter.orderByConsumption(taxiPark) + "\n");
        } catch (Exception e) {
            System.err.println(e);
        }
    }
}


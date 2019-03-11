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
           // taxiPark = new TaxiPark(randomCreator.createRandomCars());
            taxiPark=new TaxiPark(randomCreator.createRandomCarsForSimpleCarArray());
            System.out.println("Quantity of car : "+"\n" + SortByParameter.findGeneralQuantity(taxiPark) + "\n");
            printer.print(taxiPark);
            System.out.println("The oldest car is: "+"\n" + SortByParameter.findTheOldestCar(taxiPark) + "\n");
            System.out.println("Year of issue range:"+"\n" + SortByParameter.findbyYearOfIssue(1991,
                    2018, taxiPark) + "\n");
            System.out.println("Sorted by consumption "+"\n" + SortByParameter.orderByConsumption(taxiPark) + "\n");
            System.out.println("All lorries in taxi park: " +SortByParameter.findAllLorry(taxiPark)+"\n");
            System.out.println("All passangers cars in taxi park: " +SortByParameter.findAllPassangerCar(taxiPark));

        } catch (Exception e) {
           e.printStackTrace();
        }
    }
}


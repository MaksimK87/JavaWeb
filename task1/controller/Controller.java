package by.epam.javawebtraining.maksimkosmachev.task1.controller;

import by.epam.javawebtraining.maksimkosmachev.task1.model.entity.Car;
import by.epam.javawebtraining.maksimkosmachev.task1.model.entity.TaxiPark;
import by.epam.javawebtraining.maksimkosmachev.task1.model.logic.SortByParameter;
import by.epam.javawebtraining.maksimkosmachev.task1.util.RandomCreator;
import by.epam.javawebtraining.maksimkosmachev.task1.view.ConsolePrinter;
import by.epam.javawebtraining.maksimkosmachev.task1.view.FilePrinter;

import java.util.ArrayList;
import java.util.List;

public class Controller {
    public void launch() {
        ConsolePrinter consolePrinter = new ConsolePrinter();
        FilePrinter filePrinter = new FilePrinter();
        List<Car> cars = new ArrayList<>();
        RandomCreator randomCreator = new RandomCreator();
        TaxiPark taxiPark = null;
        try {
            taxiPark = new TaxiPark(randomCreator.createRandomCars());
            consolePrinter.print(taxiPark);
            filePrinter.print(taxiPark);
            consolePrinter.print("General quantity: \n",
                    SortByParameter.findGeneralQuantity(taxiPark));
            filePrinter.print("General quantity: \n",
                    SortByParameter.findGeneralQuantity(taxiPark));
            consolePrinter.print("The oldest car: \n",
                    SortByParameter.findTheOldestCar(taxiPark));
            filePrinter.print("The oldest car: \n",
                    SortByParameter.findTheOldestCar(taxiPark));
            consolePrinter.print("Result of searching by year of issue: \n",
                    SortByParameter.findbyYearOfIssue(1999,
                    2018, taxiPark));
            filePrinter.print("Result of searching by year of issue: \n",
                    SortByParameter.findbyYearOfIssue(1999,
                    2018, taxiPark));
            consolePrinter.print("Ordered by consumption: \n",
                    SortByParameter.orderByConsumption(taxiPark));
            filePrinter.print("Ordered by consumption: \n",
                    SortByParameter.orderByConsumption(taxiPark));
            consolePrinter.print("All lorries in the park: \n",
                    SortByParameter.findAllLorry(taxiPark));
            filePrinter.print("All lorries in the park: \n",
                    SortByParameter.findAllLorry(taxiPark));
            consolePrinter.print("All passengers cars in the park: \n",
                    SortByParameter.findAllPassangerCar(taxiPark));
            filePrinter.print("All passengers cars in the park: \n",
                    SortByParameter.findAllPassangerCar(taxiPark));

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}


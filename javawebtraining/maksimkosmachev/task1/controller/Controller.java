package by.epam.javawebtraining.maksimkosmachev.task1.controller;

import by.epam.javawebtraining.maksimkosmachev.task1.entity.Car;
import by.epam.javawebtraining.maksimkosmachev.task1.entity.Lorry;
import by.epam.javawebtraining.maksimkosmachev.task1.entity.PassengerCar;
import by.epam.javawebtraining.maksimkosmachev.task1.entity.TaxiPark;
import by.epam.javawebtraining.maksimkosmachev.task1.model.SortByParameter;
import by.epam.javawebtraining.maksimkosmachev.task1.view.Printable;

import java.util.ArrayList;
import java.util.List;

public class Controller {
    public void launch() {
        Printable printer = new Printable();
        List<Car> cars = new ArrayList<>();
        TaxiPark taxiPark = new TaxiPark(cars);
        PassengerCar passengerCar = new PassengerCar(5000, 10, 1999, "Diesel",
                200123, 3.0,
                "VW", 10, 5, "Sedan");

        Lorry lorry = new Lorry(10000, 23, 2010, "Diesel", 321000,
                4.5, "VOLVO", 120, "Truck", 10);

        PassengerCar minivan = new PassengerCar(6000, 8, 2011, "Gasoline",
                80000, 2,
                "Mersedes", 4, 7, "minivan");

        Lorry lorry1 = new Lorry(14567, 17, 1991, "Diesel", 3321000,
                3, "GAZ", 46, "Truck", 3);
        taxiPark.add(passengerCar);
        taxiPark.add(lorry);
        taxiPark.add(minivan);
        taxiPark.add(lorry);
        taxiPark.add(lorry1);
        printer.print(taxiPark);
        System.out.println("Year of issue range:"+SortByParameter.findbyYearOfIssue(1991,2000,taxiPark).toString());
        System.out.println("Quantity of car : " + SortByParameter.findGeneralQuantity(taxiPark));
        System.out.println("Sorted by consumption " + SortByParameter.orderByConsumption(taxiPark));
    }
}


/**
 * @author - Maksim Kosmachev
 */
package by.epam.javawebtraining.maksimkosmachev.task05.controller;

import by.epam.javawebtraining.maksimkosmachev.task05.model.entity.CarPark;

import by.epam.javawebtraining.maksimkosmachev.task05.util.DataGenerator;


public class Controller {
    public static void main(String[] args) {
        CarPark carPark1 = new CarPark(DataGenerator.generateParkPlace());
//        CarPark carPark2 = new CarPark(DataGenerator.generateParkPlace());
//        CarPark carPark3 = new CarPark(DataGenerator.generateParkPlace());
//        carPark1.setNextCarPark(carPark2);
//        carPark2.setNextCarPark(carPark3);
//        carPark3.setNextCarPark(carPark1);
        DataGenerator.generateCars(carPark1);


    }
}

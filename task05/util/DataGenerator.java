/**
 * @author - Maksim Kosmachev
 */
package by.epam.javawebtraining.maksimkosmachev.task05.util;

import by.epam.javawebtraining.maksimkosmachev.task05.model.entity.ParkPlace;
import by.epam.javawebtraining.maksimkosmachev.task05.model.entity.Car;
import by.epam.javawebtraining.maksimkosmachev.task05.model.entity.CarPark;


import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;


public class DataGenerator {

    private static final int CAR_PLACE_QUANTITY = DataConfiguration.getProperty("CAR_PLACE_QUANTITY");
    private static final int MIN_CAR_PLACE_QUANTITY = 0;
    private static final int CARS_QUANTITY = DataConfiguration.getProperty("CARS_QUANTITY");


    public static Queue<ParkPlace> generateParkPlace() {
        LinkedList<ParkPlace> parkPlace = new LinkedList<>();
        int placeQuantity = new Random().nextInt(CAR_PLACE_QUANTITY)+ MIN_CAR_PLACE_QUANTITY;
        for (int i = 0; i < placeQuantity; i++) {
            parkPlace.add(new ParkPlace());
        }

        return parkPlace;
    }

    public static void generateCars(CarPark carPark) {

        for (int i = 0; i < CARS_QUANTITY; i++) {
            new Car(carPark).start();
        }
    }
}

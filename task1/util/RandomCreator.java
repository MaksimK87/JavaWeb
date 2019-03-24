package by.epam.javawebtraining.maksimkosmachev.task1.util;

import by.epam.javawebtraining.maksimkosmachev.task1.model.entity.Car;
import by.epam.javawebtraining.maksimkosmachev.task1.model.entity.Lorry;
import by.epam.javawebtraining.maksimkosmachev.task1.model.entity.PassengerCar;
import by.epam.javawebtraining.maksimkosmachev.task1.model.entity.enums.CarBodyType;
import by.epam.javawebtraining.maksimkosmachev.task1.model.entity.enums.CarManufacturer;
import by.epam.javawebtraining.maksimkosmachev.task1.model.entity.enums.TypeOfFuel;
import by.epam.javawebtraining.maksimkosmachev.task1.model.entity.enums.TypeOfLorry;
import by.epam.javawebtraining.maksimkosmachev.task1.model.exception.CarException;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class RandomCreator {
    Random random = new Random();
    private static final int ARRAY_BOUNDS = 5;
    private static final int DELTA = 4;
    private static final int RANDOM_CAR = 3;
    private static final int SEATS_QUANTITY = 4;
    private static final int DELTA_SEATS_QUANTITY = 3;
    private static final int WEIGHT = 5000;
    private static final int DELTA_WEIGHT = 5000;
    private static final int MIN_YEAR_OF_ISSUE = 1990;
    private static final int MAX_YEAR_OF_ISSUE = 2019;
    private static final int PRICE = 10000;
    private static final int MIN_PRICE = 2000;
    private static final int CONSUMPTION = 10;
    private static final int DELTA_CONSUMPTION = 5;
    private static final int ENGINE_VALUE = 5;
    private static final double DELTA_ENGINE_VALUE = 1.2;
    private static int KILOMETRAGE = 1000000;
    private static int FARE = 130;
    private static int DELTA_FARE = 5;


    public List<Car> createRandomCars() throws CarException {
        List<Car> cars = new ArrayList<>();
        int bounds = random.nextInt(ARRAY_BOUNDS) + DELTA;
        for (int i = 0; i < bounds; i++) { // Creating list of cars
            cars.add(addRundomCar());
        }
        return cars;
    }


    private Car addRundomCar() throws CarException {

        int carType = random.nextInt(RANDOM_CAR);
        if (carType >= 0 && carType < 2) {  // If car type > 0 and < 1 creates Passanger car, else creates Lorry
            PassengerCar car = new PassengerCar();
            car.setSeatsQuantity(random.nextInt(SEATS_QUANTITY) + DELTA_SEATS_QUANTITY); // set seats quantity
            car.setBodyType(CarBodyType.values()[random.nextInt(CarBodyType.values().length)]);// set body type
            return carPropertiesInit(car);
        } else {
            Lorry car = new Lorry();
            car.setWeight(random.nextInt(WEIGHT) + DELTA_WEIGHT); // set weight of lorry
            car.setTypeOfLorry(TypeOfLorry.values()[random.nextInt(TypeOfLorry.values().length)]); // set type of
            // lorry
            return carPropertiesInit(car);
        }
    }


    private Car carPropertiesInit(Car car) throws CarException {
        int size = (CarManufacturer.values().length);
        car.setManufacturer(CarManufacturer.values()[random.nextInt(size)]);// creating manufacturer
        int diff = MAX_YEAR_OF_ISSUE - MIN_YEAR_OF_ISSUE;
        car.setYearOfIssue(random.nextInt(diff) + MIN_YEAR_OF_ISSUE); // creating date of issue
        car.setPrice(random.nextInt(PRICE) + MIN_PRICE); // creating price;
        car.setFuelType(TypeOfFuel.values()[random.nextInt(TypeOfFuel.values().length)]); // creating type
        // of fuel
        car.setConsumption(random.nextInt(CONSUMPTION) + DELTA_CONSUMPTION); // set consumption
        car.setEngineValue(random.nextInt(ENGINE_VALUE) + DELTA_ENGINE_VALUE); // set engine's value
        car.setKilometrage(random.nextInt(KILOMETRAGE)); // set kilometrage
        car.setFare(random.nextInt(FARE) + DELTA_FARE);
        return car;
    }
}

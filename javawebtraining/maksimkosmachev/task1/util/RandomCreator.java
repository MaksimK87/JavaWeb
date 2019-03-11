package by.epam.javawebtraining.maksimkosmachev.task1.util;

import by.epam.javawebtraining.maksimkosmachev.task1.entity.Car;
import by.epam.javawebtraining.maksimkosmachev.task1.entity.Lorry;
import by.epam.javawebtraining.maksimkosmachev.task1.entity.PassengerCar;
import by.epam.javawebtraining.maksimkosmachev.task1.entity.enums.CarBodyType;
import by.epam.javawebtraining.maksimkosmachev.task1.entity.enums.CarManufacturer;
import by.epam.javawebtraining.maksimkosmachev.task1.entity.enums.TypeOfFuel;
import by.epam.javawebtraining.maksimkosmachev.task1.entity.enums.TypeOfLorry;
import by.epam.javawebtraining.maksimkosmachev.task1.exception.CarIllegalException;
import by.epam.javawebtraining.maksimkosmachev.task1.util.myarraylist.SimpleCarArray;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class RandomCreator {
    Random random = new Random();


    public List<Car> createRandomCars() throws CarIllegalException {
        List<Car> cars = new ArrayList<>();
        int bounds=random.nextInt(5) + 4;
        for (int i = 0; i < bounds; i++) { // Creating list of cars ( from 5 to 25 pieces )
            cars.add(addRundomCar());
        }
        return cars;
    }

    public List<Car> createRandomCarsForSimpleCarArray() throws CarIllegalException {
        List<Car> cars = new ArrayList<Car>(Arrays.asList(new SimpleCarArray().getCarArray()));
        int bounds=random.nextInt(5) + 4;
        for (int i = 0; i < bounds; i++) { // Creating list of cars ( from 5 to 25 pieces )
            cars.add(addRundomCar());
        }
        return cars;
    }


    private Car addRundomCar() throws CarIllegalException {

        int carType = random.nextInt(3);
        if (carType >= 0 && carType < 2) {  // If car type > 0 and < 1 creates Passanger car, else creates Lorry
            PassengerCar car = new PassengerCar();
            car.setSeatsQuantity(random.nextInt(4) + 3); // set seats quantity
            car.setBodyType(CarBodyType.values()[random.nextInt(CarBodyType.values().length)]);// set body
            // type
            return carPropertiesInit(car);
        } else {
            Lorry car = new Lorry();
            car.setWeight(random.nextInt(5000) + 5000); // set weight of lorry
            car.setTypeOfLorry(TypeOfLorry.values()[random.nextInt(TypeOfLorry.values().length)]); // set type of
            // lorry
            return carPropertiesInit(car);
        }
    }


    private Car carPropertiesInit(Car car) throws CarIllegalException {
        int size = (CarManufacturer.values().length);
        car.setManufacturer(CarManufacturer.values()[random.nextInt(size)]);// creating manufacturer
        int minYear = 1990;
        int maxYear = 2019;
        int diff = maxYear - minYear;
        car.setYearOfIssue(random.nextInt(diff) + minYear); // creating date of issue
        int minPrice = 2000;
        car.setPrice(random.nextInt(10000) + 2000); // creating price;
        car.setFuelType(TypeOfFuel.values()[random.nextInt(TypeOfFuel.values().length)]); // creating type
        // of fuel
        car.setConsumption(random.nextInt(10) + 5); // set consumption
        car.setEngineValue(random.nextInt(5) + 1); // set engine's value
        car.setKilometrage(random.nextInt(1000000) + 200); // set kilometrage
        car.setFare(random.nextInt(130) + 10);
        return car;
    }
}

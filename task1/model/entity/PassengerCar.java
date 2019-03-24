package by.epam.javawebtraining.maksimkosmachev.task1.model.entity;

import by.epam.javawebtraining.maksimkosmachev.task1.model.entity.enums.CarBodyType;
import by.epam.javawebtraining.maksimkosmachev.task1.model.entity.enums.CarManufacturer;
import by.epam.javawebtraining.maksimkosmachev.task1.model.entity.enums.TypeOfFuel;
import by.epam.javawebtraining.maksimkosmachev.task1.model.exception.CarIllegalValueException;
import org.apache.log4j.Logger;

public class PassengerCar extends Car {
    private static Logger logger = Logger.getLogger(PassengerCar.class);

    private int seatsQuantity;
    private CarBodyType bodyType;

    public PassengerCar(CarManufacturer manufacturer, int yearOfIssue, int price, TypeOfFuel fuelType,
                        double consumption, double engineValue, int kilometrage, double fare,
                        int seatsQuantity, CarBodyType bodyType) {
        super(manufacturer, yearOfIssue, price, fuelType, consumption, engineValue, kilometrage, fare);
        this.seatsQuantity = seatsQuantity;
        this.bodyType = bodyType;
    }

    public PassengerCar() {
        super();

    }

    PassengerCar(PassengerCar passengerCar) {
        super(passengerCar);
        this.seatsQuantity = passengerCar.seatsQuantity;
        this.bodyType = passengerCar.bodyType;
    }

    public int getSeatsQuantity() {

        return seatsQuantity;
    }

    public void setSeatsQuantity(int seatsQuantity){
        if (seatsQuantity > 0) {
            this.seatsQuantity = seatsQuantity;
        }
        else{
        this.seatsQuantity = -1;
        logger.error("illegal value of seats quantity", new CarIllegalValueException());
        }
    }

    public CarBodyType getBodyType() {
        return bodyType;
    }

    public void setBodyType(CarBodyType carBodyType) {
        this.bodyType = carBodyType;
    }


    @Override
    public String toString() {
        return super.toString() + "PassengerCar{" +
                "seatsQuantity=" + seatsQuantity +
                ", bodyType=" + bodyType.toString() +
                '}';
    }
}

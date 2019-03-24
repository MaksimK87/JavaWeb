package by.epam.javawebtraining.maksimkosmachev.task1.model.entity;

import by.epam.javawebtraining.maksimkosmachev.task1.model.entity.enums.CarManufacturer;
import by.epam.javawebtraining.maksimkosmachev.task1.model.entity.enums.TypeOfFuel;
import by.epam.javawebtraining.maksimkosmachev.task1.model.entity.enums.TypeOfLorry;
import by.epam.javawebtraining.maksimkosmachev.task1.model.exception.CarIllegalValueException;
import org.apache.log4j.Logger;

public class Lorry extends Car {
    private static final Logger logger=Logger.getLogger(Lorry.class);
    private TypeOfLorry typeOfLorry;
    private int weight;

    public Lorry(CarManufacturer manufacturer, int yearOfIssue, int price, TypeOfFuel fuelType,
                 double consumption, double engineValue, int kilometrage, double fare,
                 TypeOfLorry typeOfLorry, int weight) {
        super(manufacturer, yearOfIssue, price, fuelType, consumption, engineValue, kilometrage, fare);
        this.typeOfLorry = typeOfLorry;
        this.weight = weight;
    }

    public Lorry(Lorry lorry) {
        super(lorry);
        this.typeOfLorry = lorry.typeOfLorry;
        this.weight = lorry.weight;
    }

    public Lorry() {

    }

    public TypeOfLorry getTypeOfLorry() {
        return typeOfLorry;
    }

    public void setTypeOfLorry(TypeOfLorry typeOfLorry) {
        this.typeOfLorry = typeOfLorry;
    }


    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight)  {
        if (weight > 0) {
            this.weight = weight;
        }
       else{
            logger.error("Incorrect weight of lorry", new CarIllegalValueException());
            this.weight=-1;
        }
    }

    @Override
    public String toString() {
        return super.toString() + "Lorry{" +
                "typeOfLorry=" + typeOfLorry.toString() +
                ", weight=" + weight + "kg" +
                '}';
    }
}

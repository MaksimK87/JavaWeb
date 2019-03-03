package by.epam.javawebtraining.maksimkosmachev.task1.entity;

import by.epam.javawebtraining.maksimkosmachev.task1.entity.enums.CarManufacturer;
import by.epam.javawebtraining.maksimkosmachev.task1.entity.enums.TypeOfFuel;
import by.epam.javawebtraining.maksimkosmachev.task1.entity.enums.TypeOfLorry;
import by.epam.javawebtraining.maksimkosmachev.task1.exception.CarIllegalException;

public class Lorry extends Car {
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
        super();

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

    public void setWeight(int weight) throws CarIllegalException {
        if (weight <= 0) {
            throw new CarIllegalException("Weight is incorrect");
        }
        this.weight = weight;
    }

    @Override
    public String toString() {
        return super.toString() + "Lorry{" +
                "typeOfLorry=" + typeOfLorry.toString() +
                ", weight=" + weight + "kg" +
                '}';
    }
}

package by.epam.javawebtraining.maksimkosmachev.task1.util.myarraylist;

import by.epam.javawebtraining.maksimkosmachev.task1.entity.Car;
import by.epam.javawebtraining.maksimkosmachev.task1.exception.CarIllegalException;

public class ArrayConteiner implements ICarConteiner {
    private static Car carArray[] = new Car[10];
    private static int index = 0;
    ArrayConteiner(Car car){
        super();

            if (index < carArray.length) {
                carArray[index] = car;
                index++;
            } else {
                carArray = this.resize(carArray);
                carArray[index] = car;
                index++;
            }

    }
    ArrayConteiner(){};
    private static Car[] resize(Car[] carArray) {

        Car resizedArray[] = new Car[carArray.length + 1];// Creating new Array with 10 empty cells;
        for (int i = 0; i < carArray.length; i++) {
            resizedArray[i] = carArray[i];
        }
        return resizedArray;

    }

    @Override
    public void addElement(Car car) throws CarIllegalException {
        if(car==null){
            throw new CarIllegalException("Car must be not null");
        }
        if (index < carArray.length) {
            carArray[index] = car;
            index++;
        } else {
            carArray = ArrayConteiner.resize(carArray);
            carArray[index] = car;
            index++;
        }

    }

    @Override
    public Car[] getElement(int index) {
        return new Car[0];
    }




    @Override
    public void removeElement(Car car) {

    }

    @Override
    public Car[] getAll() {
        return new Car[0];
    }
}

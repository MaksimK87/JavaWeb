package by.epam.javawebtraining.maksimkosmachev.task1.util.myarraylist;

import by.epam.javawebtraining.maksimkosmachev.task1.entity.Car;
import by.epam.javawebtraining.maksimkosmachev.task1.exception.CarIllegalException;

public class SimpleCarArray {
    private static Car carArray[] = new Car[10];
    private static int index = 0;

    public SimpleCarArray(Car car) {
        if (index < carArray.length) {
            carArray[index] = car;
            index++;
        } else {
            carArray = this.resize(carArray);
            carArray[index] = car;
            index++;
        }
    }
    public SimpleCarArray(){

    }

    private static Car[] resize(Car[] carArray) {

        Car resizedArray[] = new Car[carArray.length + 10];// Creating new Array with 10 empty cells;
        for (int i = 0; i < carArray.length; i++) {
            resizedArray[i] = carArray[i];
        }
        return resizedArray;

    }

    public void addElement(Car car) throws CarIllegalException {
        if(car==null){
            throw new CarIllegalException("Car must be not null");
        }
        if (index < carArray.length) {
            carArray[index] = car;
            index++;
        } else {
            carArray = SimpleCarArray.resize(carArray);
            carArray[index] = car;
            index++;
        }
    }
    public Car[] getCarArray() {
        return carArray;
    }

    public void setCarArray(Car[] carArray) throws CarIllegalException {
        if(carArray==null){
            throw new CarIllegalException("Array of cars must be not null");
        }
        SimpleCarArray.carArray = carArray;
    }
    public int getIndex() {
        return index;
    }

    public void setIndex(int index) throws CarIllegalException {
        if(index<0){
            throw new CarIllegalException("Index must be positive or 0");
        }
        SimpleCarArray.index = index;
    }
    public static void printCarArray(SimpleCarArray carArray){
        for(Car car:carArray.getCarArray()){
            System.out.println(car);
        }
    }
}



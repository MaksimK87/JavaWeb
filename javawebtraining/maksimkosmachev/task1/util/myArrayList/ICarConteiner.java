package by.epam.javawebtraining.maksimkosmachev.task1.util.myArrayList;

import by.epam.javawebtraining.maksimkosmachev.task1.entity.Car;
import by.epam.javawebtraining.maksimkosmachev.task1.exception.CarIllegalException;

public interface ICarConteiner {
    void addElement(Car car) throws CarIllegalException;

    Car[] getElement(int index);

    void removeElement(Car car);
    Car[] getAll();

}

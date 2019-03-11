package by.epam.javawebtraining.maksimkosmachev.task1.test;

import by.epam.javawebtraining.maksimkosmachev.task1.entity.Car;
import by.epam.javawebtraining.maksimkosmachev.task1.entity.Lorry;
import by.epam.javawebtraining.maksimkosmachev.task1.entity.PassengerCar;
import by.epam.javawebtraining.maksimkosmachev.task1.entity.enums.CarBodyType;
import by.epam.javawebtraining.maksimkosmachev.task1.entity.enums.CarManufacturer;
import by.epam.javawebtraining.maksimkosmachev.task1.entity.enums.TypeOfFuel;
import by.epam.javawebtraining.maksimkosmachev.task1.entity.enums.TypeOfLorry;
import by.epam.javawebtraining.maksimkosmachev.task1.exception.CarIllegalException;
import by.epam.javawebtraining.maksimkosmachev.task1.util.myArrayList.SimpleCarArray;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class CarArrayTest {

    private Car car,car1,car2,car3,car4;
    private SimpleCarArray carArray;
    @Before
    public void setUP() throws CarIllegalException {
        carArray=new SimpleCarArray();
        carArray.addElement(car);
        carArray.addElement(car1);
        carArray.addElement(car3);
        carArray.addElement(car4);

        car = new PassengerCar(CarManufacturer.MITSUBISHI, 1999, 3200, TypeOfFuel.DIESEL,
                10.0, 2.5, 120000, 40, 5, CarBodyType.SEDAN);

        car1 = new PassengerCar(CarManufacturer.VOLVO, 2005, 10000, TypeOfFuel.GASOLINE,
                17.0, 5, 124567, 550, 7, CarBodyType.MINIVAN);

        car2 = new Lorry(CarManufacturer.DAF, 1994, 17859, TypeOfFuel.DIESEL,
                18.0, 10, 289888, 70, TypeOfLorry.REFRIGERATOR_VAN, 20000);

        car3 = new Lorry(CarManufacturer.MERSEDES, 2018, 10000, TypeOfFuel.DIESEL,
                8.0, 2.2, 289888, 70, TypeOfLorry.SEMITRAILER, 15670);

        car4 = new PassengerCar(CarManufacturer.HYUNDAI, 1991, 6250, TypeOfFuel.GASOLINE,
                12.0, 2.9, 651000, 30, 8, CarBodyType.MINIBUS);
    }


    @Test
    public void resize() {
        Assert.assertEquals(12,carArray.getCarArray().length);

    }

    @Test
    public void getCarArray() {
    }

    @Test
    public void setCarArray() {
    }

    @Test
    public void getIndex() {
    }

    @Test
    public void setIndex() {
    }


}
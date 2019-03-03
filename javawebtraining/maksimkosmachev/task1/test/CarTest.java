package by.epam.javawebtraining.maksimkosmachev.task1.test;

import by.epam.javawebtraining.maksimkosmachev.task1.entity.Car;
import by.epam.javawebtraining.maksimkosmachev.task1.entity.enums.CarManufacturer;
import by.epam.javawebtraining.maksimkosmachev.task1.entity.enums.TypeOfFuel;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class CarTest {

    Car car, car1, car2, car3;


    @Before
    public void setUp() {
        Car car = new Car(CarManufacturer.BMW, 1991, 32000, TypeOfFuel.DIESEL,
                10.0, 2.5, 120000, 40);
        Car car1 = new Car(CarManufacturer.VOLVO, 1999, 10000, TypeOfFuel.DIESEL,
                17.0, 5, 124567, 550);
        Car car2 = new Car(car1);
        Car car3 = new Car(CarManufacturer.VOLVO, 1999, 10000, TypeOfFuel.DIESEL,
                17.0, 5, 124567, 550);
    }

    @Test
    public void getPriceTest() {

        int expected = car.getPrice();
        int actual = 32000;
        Assert.assertEquals(32000, car.getPrice());
    }

    @Test
    public void equalsTest() {
        Assert.assertTrue(car1.equals(car3) && car3.equals(car1));
        Assert.assertTrue(car1.hashCode() == car3.hashCode());
    }

    @Test
    public void getConsumption() {
        Assert.assertEquals(10.0, car.getConsumption(), 0);
    }

    @Test
    public void setConsumption() {
    }

    @Test
    public void getYearOfIssue() {
    }

    @Test
    public void setYearOfIssue() {
    }

    @Test
    public void getFuelType() {
    }

    @Test
    public void setFuelType() {
    }

    @Test
    public void getKilometrage() {
    }

    @Test
    public void setKilometrage() {
    }

    @Test
    public void getFare() {
    }

    @Test
    public void setFare() {
    }

    @Test
    public void getEngineValue() {
    }

    @Test
    public void setEngineValue() {
    }

    @Test
    public void getManufacturer() {
    }

    @Test
    public void setManufacturer() {
    }
}
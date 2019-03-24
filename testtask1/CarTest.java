package by.epam.javawebtraining.maksimkosmachev.testtask1;

import by.epam.javawebtraining.maksimkosmachev.task1.model.entity.Car;
import by.epam.javawebtraining.maksimkosmachev.task1.model.entity.enums.CarManufacturer;
import by.epam.javawebtraining.maksimkosmachev.task1.model.entity.enums.TypeOfFuel;
import by.epam.javawebtraining.maksimkosmachev.task1.model.exception.CarException;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class CarTest {

    private Car car;
    private Car car1;
    private Car car2;
    private Car car3;


    @Before
    public void setUp() {
        car = new Car(CarManufacturer.BMW, 1991, 32000, TypeOfFuel.DIESEL,
                10.0, 2.5, 120000, 40);
        car1 = new Car(CarManufacturer.VOLVO, 1999, 10000, TypeOfFuel.DIESEL,
                17.0, 5, 124567, 550);
        car2 = new Car(car1);
        car3 = new Car(CarManufacturer.VOLVO, 1999, 10000, TypeOfFuel.DIESEL,
                17.0, 5, 124567, 550);
    }

    @Test
    public void getPriceTest() {

        Assert.assertEquals(32000, car.getPrice());
    }

    @Test
    public void setPriceTest() throws CarException {
        car.setPrice(120);
        Assert.assertEquals(120, car.getPrice());

    }

    @Test(expected = CarException.class)
    public void setPriceWrongValueTest() throws CarException {
        car.setPrice(0);
    }

    @Test
    public void equalsTest() {
        Assert.assertTrue(car1.equals(car3) && car3.equals(car1));
    }

    @Test
    public void hashCodeTest() {
        Assert.assertTrue(car1.hashCode() == car3.hashCode());
    }

    @Test
    public void getConsumptionTest() {
        Assert.assertEquals(10.0, car.getConsumption(), 0);
    }

    @Test
    public void setConsumptionTest() throws CarException {
        car3.setConsumption(10);
        Assert.assertEquals(10, car3.getConsumption(), 0);

    }

    @Test(expected = CarException.class)
    public void setConsumptionWrongValueTest() throws CarException {
        car3.setConsumption(0);
    }

    @Test
    public void getYearOfIssueTest() {
        Assert.assertEquals(1999, car3.getYearOfIssue());
    }

    @Test
    public void setYearOfIssueTest() throws CarException {
        car3.setYearOfIssue(2018);
        Assert.assertEquals(2018, car3.getYearOfIssue());
    }

    @Test(expected = CarException.class)
    public void setYearOfIssueWrongValueTest() throws CarException {
        car3.setYearOfIssue(1800);
    }


    @Test
    public void getFuelTypeTest() {
        Assert.assertEquals(TypeOfFuel.DIESEL, car.getFuelType());
    }


    @Test
    public void getKilometrageTest() {
        Assert.assertEquals(120000, car.getKilometrage());
    }

    @Test
    public void setKilometrageTest() throws CarException {
        car.setKilometrage(701);
        Assert.assertEquals(701, car.getKilometrage());
    }

    @Test(expected = CarException.class)
    public void setKilometrageWrongValueTest() throws CarException {
        car.setKilometrage(-80);
    }

    @Test
    public void getFareTest() {
        Assert.assertEquals(550, car3.getFare(), 0);
    }

    @Test
    public void setFareTest() throws CarException {
        car.setFare(10);
        Assert.assertEquals(10, car.getFare(), 0);
    }

    @Test(expected = CarException.class)
    public void setFareWrongValueTest() throws CarException {
        car3.setFare(0);
    }

    @Test
    public void getEngineValueTest() {
        Assert.assertEquals(2.5, car.getEngineValue(), 0);
    }

    @Test
    public void setEngineValueTest() throws CarException {
        car.setEngineValue(1.9);
        Assert.assertEquals(1.9, car.getEngineValue(), 0);
    }

    @Test(expected = CarException.class)
    public void setEngineValueWrongValueTest() throws CarException {
        car.setEngineValue(0);
    }

    @Test
    public void getManufacturer() {
        Assert.assertEquals(CarManufacturer.BMW, car.getManufacturer());
    }

}
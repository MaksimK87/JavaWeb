package by.epam.javawebtraining.maksimkosmachev.task1.test;

import by.epam.javawebtraining.maksimkosmachev.task1.entity.Car;
import by.epam.javawebtraining.maksimkosmachev.task1.entity.enums.CarManufacturer;
import by.epam.javawebtraining.maksimkosmachev.task1.entity.enums.TypeOfFuel;
import by.epam.javawebtraining.maksimkosmachev.task1.exception.CarIllegalException;
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
    public void setPriceTest() throws CarIllegalException {
        car.setPrice(120);
        Assert.assertEquals(120, car.getPrice());

    }

    @Test(expected = CarIllegalException.class)
    public void setPriceWrongValueTest() throws CarIllegalException {
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
    public void setConsumptionTest() throws CarIllegalException {
        car3.setConsumption(10);
        Assert.assertEquals(10, car3.getConsumption(), 0);

    }

    @Test(expected = CarIllegalException.class)
    public void setConsumptionWrongValueTest() throws CarIllegalException {
        car3.setConsumption(0);
    }

    @Test
    public void getYearOfIssueTest() {
        Assert.assertEquals(1999, car3.getYearOfIssue());
    }

    @Test
    public void setYearOfIssueTest() throws CarIllegalException {
        car3.setYearOfIssue(2018);
        Assert.assertEquals(2018, car3.getYearOfIssue());
    }

    @Test(expected = CarIllegalException.class)
    public void setYearOfIssueWrongValueTest() throws CarIllegalException {
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
    public void setKilometrageTest() throws CarIllegalException {
        car.setKilometrage(701);
        Assert.assertEquals(701, car.getKilometrage());
    }

    @Test(expected = CarIllegalException.class)
    public void setKilometrageWrongValueTest() throws CarIllegalException {
        car.setKilometrage(-80);
    }

    @Test
    public void getFareTest() {
        Assert.assertEquals(550, car3.getFare(), 0);
    }

    @Test
    public void setFareTest() throws CarIllegalException {
        car.setFare(10);
        Assert.assertEquals(10, car.getFare(), 0);
    }

    @Test(expected = CarIllegalException.class)
    public void setFareWrongValueTest() throws CarIllegalException {
        car3.setFare(0);
    }

    @Test
    public void getEngineValueTest() {
        Assert.assertEquals(2.5, car.getEngineValue(), 0);
    }

    @Test
    public void setEngineValueTest() throws CarIllegalException {
        car.setEngineValue(1.9);
        Assert.assertEquals(1.9, car.getEngineValue(), 0);
    }

    @Test(expected = CarIllegalException.class)
    public void setEngineValueWrongValueTest() throws CarIllegalException {
        car.setEngineValue(0);
    }

    @Test
    public void getManufacturer() {
        Assert.assertEquals(CarManufacturer.BMW, car.getManufacturer());
    }

}
package by.epam.javawebtraining.maksimkosmachev.task1.test;

import by.epam.javawebtraining.maksimkosmachev.task1.entity.Car;
import by.epam.javawebtraining.maksimkosmachev.task1.entity.Lorry;
import by.epam.javawebtraining.maksimkosmachev.task1.entity.PassengerCar;
import by.epam.javawebtraining.maksimkosmachev.task1.entity.TaxiPark;
import by.epam.javawebtraining.maksimkosmachev.task1.entity.enums.CarBodyType;
import by.epam.javawebtraining.maksimkosmachev.task1.entity.enums.CarManufacturer;
import by.epam.javawebtraining.maksimkosmachev.task1.entity.enums.TypeOfFuel;
import by.epam.javawebtraining.maksimkosmachev.task1.entity.enums.TypeOfLorry;
import by.epam.javawebtraining.maksimkosmachev.task1.exception.CarIllegalException;
import by.epam.javawebtraining.maksimkosmachev.task1.model.SortByParameter;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class SortByParameterTest {
    private TaxiPark taxiPark;
    Car car, car1, car2, car3, car4;


    @Before
    public void setUp() throws Exception {
        taxiPark = new TaxiPark();
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

        taxiPark.add(car);
        taxiPark.add(car1);
        taxiPark.add(car2);
        taxiPark.add(car3);
        taxiPark.add(car4);

    }


    @Test
    public void findGeneralQuantityTest() {
        Assert.assertEquals(5, SortByParameter.findGeneralQuantity(taxiPark));
    }

    @Test
    public void findByYearOfIssueTest() throws CarIllegalException {
        TaxiPark expected = new TaxiPark();
        expected.add(car);
        expected.add(car1);
        TaxiPark actual = SortByParameter.findbyYearOfIssue(1998, 2006, taxiPark);
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void orderByConsumptionTest() throws CarIllegalException {
        TaxiPark expected = new TaxiPark();
        expected.getCars().add(0, car3);
        expected.getCars().add(1, car);
        expected.getCars().add(2, car4);
        expected.getCars().add(3, car1);
        expected.getCars().add(4, car2);
        TaxiPark actual = SortByParameter.orderByConsumption(taxiPark);

        Assert.assertEquals(expected.getCars(), actual.getCars());
    }

    @Test
    public void findTheOldestCarTest() {

        Assert.assertEquals(car4, SortByParameter.findTheOldestCar(taxiPark));
    }

    @Test
    public void findAllLorryTest() throws CarIllegalException {
        TaxiPark expected = new TaxiPark();
        expected.add(car2);
        expected.add(car3);
        Assert.assertEquals(expected, SortByParameter.findAllLorry(taxiPark));
    }

    @Test
    public void findAllPassangerCarTest() throws CarIllegalException {
        TaxiPark expected = new TaxiPark();
        expected.add(car);
        expected.add(car1);
        expected.add(car4);
        Assert.assertEquals(expected, SortByParameter.findAllPassangerCar(taxiPark));
    }


}
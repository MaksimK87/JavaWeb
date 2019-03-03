package by.epam.javawebtraining.maksimkosmachev.task1.view;

import by.epam.javawebtraining.maksimkosmachev.task1.entity.TaxiPark;
import by.epam.javawebtraining.maksimkosmachev.task1.exception.CarIllegalException;


public class Printable {
    public void print(TaxiPark taxiPark) throws CarIllegalException {
        if(taxiPark==null){
            throw new CarIllegalException("Entity taxi park must be not null");
        }
        System.out.println(taxiPark.toString());
    }
}

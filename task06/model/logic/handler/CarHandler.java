/**
 * @author - Maksim Kosmachev
 */
package by.epam.javawebtraining.maksimkosmachev.task06.model.logic.handler;

import by.epam.javawebtraining.maksimkosmachev.task06.model.entity.Car;
import by.epam.javawebtraining.maksimkosmachev.task06.model.entity.Lorry;
import by.epam.javawebtraining.maksimkosmachev.task06.model.entity.PassengerCar;
import by.epam.javawebtraining.maksimkosmachev.task06.model.entity.TaxiPark;
import by.epam.javawebtraining.maksimkosmachev.task06.model.entity.enums.*;
import by.epam.javawebtraining.maksimkosmachev.task06.model.exception.CarException;
import org.apache.log4j.Logger;
import org.xml.sax.Attributes;
import org.xml.sax.helpers.DefaultHandler;

import java.util.EnumSet;

public class CarHandler extends DefaultHandler {

    private static Logger logger = Logger.getLogger(CarHandler.class);

    private TaxiPark taxiPark;
    private CarEnum currentEnum;
    private EnumSet<CarEnum> withText;
    private Car currentCar = null;

    public CarHandler() {
        withText = EnumSet.range(CarEnum.MANUFACTURER, CarEnum.WEIGHT);
        logger.debug("CarHandler is created, taxiPark and withText are initialized");
    }

    public TaxiPark getTaxiPark() {
        return taxiPark;
    }

    public void setTaxiPark(TaxiPark taxiPark) {
        this.taxiPark = taxiPark;
    }


    public void startElement(String uri, String localName, String qName, Attributes attributes) {
        if ("passengerCar".equals(localName)) {
            currentCar = new PassengerCar();
            currentCar.setId(Integer.parseInt(attributes.getValue(0)));
            logger.debug("PassengerCar is created with id :" + Integer.parseInt(attributes.getValue(0)));

        }
        if ("lorry".equals(localName)) {
            currentCar = new Lorry();
            currentCar.setId(Integer.parseInt(attributes.getValue(0)));
            logger.debug("Lorry is created with id :" + Integer.parseInt(attributes.getValue(0)));
        } else {
            CarEnum temp = CarEnum.valueOf(localName.toUpperCase());
            if (withText.contains(temp)) {
                currentEnum = temp;
            }
        }
    }


    public void endElement(String uri, String localName, String qName) {
        if ("passengerCar".equals(localName) || "lorry".equals(localName)) {
            try {
                taxiPark.add(currentCar);
            } catch (CarException e) {
                e.printStackTrace();
            }
        }
    }


    public void characters(char[] ch, int start, int length) {
        String s = new String(ch, start, length).trim();
        if (currentEnum != null) {
            switch (currentEnum) {
                case MANUFACTURER:
                    currentCar.setManufacturer(CarManufacturer.valueOf(s));
                    break;
                case YEAROFISSUE:
                    currentCar.setYearOfIssue(Integer.parseInt(s));
                    break;
                case PRICE:
                    currentCar.setPrice(Integer.parseInt(s));
                    break;
                case FUELTYPE:
                    currentCar.setFuelType(TypeOfFuel.valueOf(s));
                    break;
                case CONSUMPTION:
                    currentCar.setConsumption(Double.parseDouble(s));
                    break;
                case ENGINEVALUE:
                    currentCar.setEngineValue(Double.parseDouble(s));
                    break;
                case KILOMETRAGE:
                    currentCar.setKilometrage(Integer.parseInt(s));
                    break;
                case FARE:
                    try {
                        currentCar.setFare(Double.parseDouble(s));
                    } catch (CarException e) {
                        e.printStackTrace();
                    }
                    break;
                case SEATSQUANTITY:
                    ((PassengerCar) currentCar).setSeatsQuantity(Integer.parseInt(s));
                    break;
                case BODYTYPE:
                    ((PassengerCar) currentCar).setBodyType(CarBodyType.valueOf(s));
                    break;
                case TYPEOFLORRY:
                    ((Lorry) currentCar).setTypeOfLorry(TypeOfLorry.valueOf(s));
                    break;
                case WEIGHT:
                    ((Lorry) currentCar).setWeight(Integer.parseInt(s));
                    break;
                default:
                    throw new EnumConstantNotPresentException(currentEnum.getDeclaringClass(), currentEnum.name());
            }
        }
        currentEnum = null;
    }


}

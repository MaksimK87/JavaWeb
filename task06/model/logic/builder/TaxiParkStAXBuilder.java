/**
 * @author - Maksim Kosmachev
 */
package by.epam.javawebtraining.maksimkosmachev.task06.model.logic.builder;

import by.epam.javawebtraining.maksimkosmachev.task06.model.entity.Car;
import by.epam.javawebtraining.maksimkosmachev.task06.model.entity.Lorry;
import by.epam.javawebtraining.maksimkosmachev.task06.model.entity.PassengerCar;
import by.epam.javawebtraining.maksimkosmachev.task06.model.entity.TaxiPark;
import by.epam.javawebtraining.maksimkosmachev.task06.model.entity.enums.*;
import by.epam.javawebtraining.maksimkosmachev.task06.model.exception.CarException;
import org.apache.log4j.Logger;

import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamConstants;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class TaxiParkStAXBuilder {

    private static TaxiParkStAXBuilder instanceStAX;
    private static Logger logger = Logger.getLogger(TaxiParkStAXBuilder.class);

    private TaxiPark taxiPark;
    private XMLInputFactory inputFactory;

    private TaxiParkStAXBuilder() {
        inputFactory = XMLInputFactory.newInstance();
    }

    public TaxiPark getTaxiPark() {
        return taxiPark;
    }

    public void buildTaxiPark(String fileName) {
        taxiPark= new TaxiPark();
        FileInputStream inputStream = null;
        XMLStreamReader reader = null;
        String name;
        try {
            inputStream = new FileInputStream(new File(fileName));
            reader = inputFactory.createXMLStreamReader(inputStream);
            while (reader.hasNext()) {
                int type = reader.next();
                if (type == XMLStreamConstants.START_ELEMENT) {
                    name = reader.getLocalName();
                    if (CarEnum.valueOf(name.toUpperCase()) == CarEnum.PASSENGERCAR) {
                        Car car = buildPassCar(reader);
                        taxiPark.add(car);
                    }
                    if (CarEnum.valueOf(name.toUpperCase()) == CarEnum.LORRY) {
                        Car car = buildLorryCar(reader);
                        taxiPark.add(car);
                    }
                }
            }
        } catch (XMLStreamException ex) {
            logger.error("StAX parsing error!" + ex.getMessage());
        } catch (FileNotFoundException | CarException ex) {
            logger.error("File " + fileName + " not found! " + ex);
        } finally {
            try {
                if (inputStream != null) {
                    inputStream.close();
                }
            } catch (IOException e) {
                logger.error("Impossible close file " + fileName + " : " + e);
            }
        }
    }

    private Car buildPassCar(XMLStreamReader reader) throws XMLStreamException, CarException {
        Car car = new PassengerCar();
        return buildCar(reader, car);
    }

    private Car buildLorryCar(XMLStreamReader reader) throws XMLStreamException, CarException {
        Car car = new Lorry();
        return buildCar(reader, car);
    }


    private Car buildCar(XMLStreamReader reader, Car car) throws XMLStreamException, CarException {
        car.setId(Integer.parseInt(reader.getAttributeValue(null, CarEnum.ID.getValue())));
        String name;
        while (reader.hasNext()) {
            int type = reader.next();
            switch (type) {
                case XMLStreamConstants.START_ELEMENT:
                    name = reader.getLocalName();
                    switch (CarEnum.valueOf(name.toUpperCase())) {
                        case MANUFACTURER:
                            car.setManufacturer(CarManufacturer.valueOf(getXMLText(reader)));
                            break;
                        case YEAROFISSUE:
                            car.setYearOfIssue(Integer.parseInt(getXMLText(reader)));
                            break;
                        case PRICE:
                            car.setPrice(Integer.parseInt(getXMLText(reader)));
                            break;
                        case FUELTYPE:
                            car.setFuelType(TypeOfFuel.valueOf(getXMLText(reader)));
                            break;
                        case CONSUMPTION:
                            car.setConsumption(Double.parseDouble(getXMLText(reader)));
                            break;
                        case ENGINEVALUE:
                            car.setEngineValue(Double.parseDouble(getXMLText(reader)));
                            break;
                        case KILOMETRAGE:
                            car.setKilometrage(Integer.parseInt(getXMLText(reader)));
                            break;
                        case FARE:
                            car.setFare(Double.parseDouble(getXMLText(reader)));
                            break;
                        case SEATSQUANTITY:
                            ((PassengerCar) car).setSeatsQuantity(Integer.parseInt(getXMLText(reader)));
                            break;
                        case BODYTYPE:
                            ((PassengerCar) car).setBodyType(CarBodyType.valueOf(getXMLText(reader)));
                            break;
                        case TYPEOFLORRY:
                            ((Lorry) car).setTypeOfLorry(TypeOfLorry.valueOf(getXMLText(reader)));
                            break;
                        case WEIGHT:
                            ((Lorry) car).setWeight(Integer.parseInt(getXMLText(reader)));

                    }
                    break;
                case XMLStreamConstants.END_ELEMENT:
                    name = reader.getLocalName();
                    if (CarEnum.valueOf(name.toUpperCase()) ==
                            CarEnum.PASSENGERCAR || CarEnum.valueOf(name.toUpperCase())
                            == CarEnum.LORRY) {
                        return car;
                    }
                    break;
            }
        }
        throw new XMLStreamException("Unknown element in tag Passenger or Lorry car");
    }


    private String getXMLText(XMLStreamReader reader) throws XMLStreamException {
        String text = null;
        if (reader.hasNext()) {
            reader.next();
            text = reader.getText();
        }
        return text;
    }

    public static TaxiParkStAXBuilder getInstanceStAX() {
        if (instanceStAX == null) {
            synchronized (TaxiParkStAXBuilder.class) {
                if (instanceStAX == null) {
                    instanceStAX = new TaxiParkStAXBuilder();
                }

            }
        }
        return instanceStAX;
    }
}

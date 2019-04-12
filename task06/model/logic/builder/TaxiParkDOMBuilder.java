/**
 * @author - Maksim Kosmachev
 */

package by.epam.javawebtraining.maksimkosmachev.task06.model.logic.builder;

import by.epam.javawebtraining.maksimkosmachev.task06.model.entity.Car;
import by.epam.javawebtraining.maksimkosmachev.task06.model.entity.Lorry;
import by.epam.javawebtraining.maksimkosmachev.task06.model.entity.PassengerCar;
import by.epam.javawebtraining.maksimkosmachev.task06.model.entity.TaxiPark;
import by.epam.javawebtraining.maksimkosmachev.task06.model.entity.enums.CarBodyType;
import by.epam.javawebtraining.maksimkosmachev.task06.model.entity.enums.CarManufacturer;
import by.epam.javawebtraining.maksimkosmachev.task06.model.entity.enums.TypeOfFuel;
import by.epam.javawebtraining.maksimkosmachev.task06.model.entity.enums.TypeOfLorry;
import by.epam.javawebtraining.maksimkosmachev.task06.model.exception.CarException;
import org.apache.log4j.Logger;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;

public class TaxiParkDOMBuilder {

    private static Logger logger = Logger.getLogger(TaxiParkDOMBuilder.class);
    private static TaxiParkDOMBuilder instanceDOM;

    private TaxiPark taxiPark;
    private DocumentBuilder docBuilder;


    private TaxiParkDOMBuilder() {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        try {
            docBuilder = factory.newDocumentBuilder();
        } catch (ParserConfigurationException e) {
            logger.error("Error in parser configuration " + e);
        }
    }

    public TaxiPark getTaxiPark() {
        return taxiPark;
    }

    public void buildTaxiPark(String fileName) {
        taxiPark = new TaxiPark();
        Document document = null;
        try {
            document = docBuilder.parse(fileName);
            Element root = document.getDocumentElement();
            NodeList carList = root.getElementsByTagName("passengerCar");

            for (int i = 0; i < carList.getLength(); i++) {
                Element carElement = (Element) carList.item(i);
                Car car = buildCar(carElement);
                taxiPark.add(car);
            }
            carList = root.getElementsByTagName("lorry");
            for (int i = 0; i < carList.getLength(); i++) {
                Element carElement = (Element) carList.item(i);
                Car car = buildCar(carElement);
                taxiPark.add(car);
            }
        } catch (IOException e) {
            logger.error("File error or I/O error: " + e);
        } catch (SAXException e) {
            logger.error("Parsing failure: " + e);
        } catch (CarException e) {
            logger.error(e);
        }
    }

    private Car buildCar(Element carElement) throws CarException {
        Car car;
        if (carElement.getTagName().equals("passengerCar")) {
            car = new PassengerCar();
            carInit(car, carElement);
            ((PassengerCar) car).setSeatsQuantity(Integer.parseInt(getElementTextContent(carElement
                    , "seatsQuantity")));
            ((PassengerCar) car).setBodyType(CarBodyType.valueOf(getElementTextContent(carElement
                    , "bodyType")));
        } else {
            car = new Lorry();
            carInit(car, carElement);
            ((Lorry) car).setTypeOfLorry(TypeOfLorry.valueOf(getElementTextContent(carElement
                    , "typeOfLorry")));
            ((Lorry) car).setWeight(Integer.parseInt(getElementTextContent(carElement
                    , "weight")));
        }

        return car;
    }

    public static Car carInit(Car car, Element carElement) throws CarException {
        car.setId(Integer.parseInt(carElement.getAttribute("id")));
        car.setManufacturer(CarManufacturer.valueOf(getElementTextContent(carElement, "manufacturer")));
        car.setYearOfIssue(Integer.parseInt(getElementTextContent(carElement, "yearOfIssue")));
        car.setPrice(Integer.parseInt(getElementTextContent(carElement, "price")));
        car.setFuelType(TypeOfFuel.valueOf(getElementTextContent(carElement, "fuelType")));
        car.setConsumption(Double.parseDouble(getElementTextContent(carElement, "consumption")));
        car.setEngineValue(Double.parseDouble(getElementTextContent(carElement, "engineValue")));
        car.setKilometrage(Integer.parseInt(getElementTextContent(carElement, "kilometrage")));
        car.setFare(Double.parseDouble(getElementTextContent(carElement, "fare")));
        return car;
    }

    private static String getElementTextContent(Element element, String elementName) {
        NodeList nList = element.getElementsByTagName(elementName);
        Node node = nList.item(0);
        String text = node.getTextContent();
        return text;
    }

    public static TaxiParkDOMBuilder getInstanceDOM() {
        if (instanceDOM == null) {
            synchronized (TaxiParkDOMBuilder.class) {
                if (instanceDOM == null) {
                    instanceDOM = new TaxiParkDOMBuilder();
                }
            }
        }
        return instanceDOM;
    }
}

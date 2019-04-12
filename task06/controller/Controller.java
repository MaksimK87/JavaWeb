/**
 * @author - Maksim Kosmachev
 */
package by.epam.javawebtraining.maksimkosmachev.task06.controller;

import by.epam.javawebtraining.maksimkosmachev.task06.model.entity.TaxiPark;
import by.epam.javawebtraining.maksimkosmachev.task06.model.exception.CarException;
import by.epam.javawebtraining.maksimkosmachev.task06.model.logic.SortByParameter;
import by.epam.javawebtraining.maksimkosmachev.task06.model.logic.builder.TaxiParkDOMBuilder;
import by.epam.javawebtraining.maksimkosmachev.task06.model.logic.builder.TaxiParkSAXBuilder;
import by.epam.javawebtraining.maksimkosmachev.task06.model.logic.builder.TaxiParkStAXBuilder;
import org.apache.log4j.Logger;

public class Controller {
    private static final String XML_FILE_PATH = ".\\src\\TaxiPark.xml";

    private static Logger logger = Logger.getRootLogger();

    public static void main(String[] args) {

        TaxiParkSAXBuilder taxiParkSAXBuilder = TaxiParkSAXBuilder.getInstanceSAX();
        taxiParkSAXBuilder.buildTaxiPark(XML_FILE_PATH);
        TaxiPark taxiPark = taxiParkSAXBuilder.getTaxiPark();
        logger.info("SAX builder's result: " + "\n" + taxiPark.toString());
        SortByParameter.orderByConsumption(taxiPark);


        TaxiParkDOMBuilder domBuilder = TaxiParkDOMBuilder.getInstanceDOM();
        domBuilder.buildTaxiPark(XML_FILE_PATH);
        logger.info("DOM builder's result: " + "\n" + domBuilder.getTaxiPark().getCars());
        try {
            SortByParameter.findAllLorry(taxiPark);
        } catch (CarException e) {
            e.printStackTrace();
        }

        TaxiParkStAXBuilder taxiParkStAXBuilder = TaxiParkStAXBuilder.getInstanceStAX();
        taxiParkStAXBuilder.buildTaxiPark(XML_FILE_PATH);
        logger.info("StAX builder's result: " + "\n" + taxiParkStAXBuilder.getTaxiPark());
        SortByParameter.findTheOldestCar(taxiPark);
    }
}


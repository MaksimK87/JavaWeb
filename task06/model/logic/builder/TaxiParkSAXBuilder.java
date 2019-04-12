/**
 * @author - Maksim Kosmachev
 */
package by.epam.javawebtraining.maksimkosmachev.task06.model.logic.builder;

import by.epam.javawebtraining.maksimkosmachev.task06.model.entity.TaxiPark;
import by.epam.javawebtraining.maksimkosmachev.task06.model.logic.handler.CarHandler;
import org.apache.log4j.Logger;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;

import java.io.IOException;

public class TaxiParkSAXBuilder {

    private static TaxiParkSAXBuilder instanceSAX;
    private static Logger logger = Logger.getLogger(TaxiParkSAXBuilder.class);

    private TaxiPark taxiPark;
    private CarHandler carHandler;
    private XMLReader xmlReader;

    private TaxiParkSAXBuilder() {
        carHandler = new CarHandler();
        try {
            xmlReader = XMLReaderFactory.createXMLReader();
            xmlReader.setContentHandler(carHandler);
        } catch (SAXException e) {
            logger.error("SAX parser's error : " + e);
        }
    }

    public TaxiPark getTaxiPark() {
        return taxiPark;
    }

    public void buildTaxiPark(String filename) {
        carHandler.setTaxiPark(new TaxiPark());    // creates new taxiPark collection in carHandler object when user
                                                    // calls buildTaxiPark method more than one time for singleton
                                                    // TaxiParkSAXBuilder
        try {
            xmlReader.parse(filename);
        } catch (IOException e) {
            logger.error("I/O error " + e);
            e.printStackTrace();
        } catch (SAXException e) {
            logger.error("SAX parser's error :" + e);
            e.printStackTrace();
        }
        taxiPark = carHandler.getTaxiPark();
    }

    public static TaxiParkSAXBuilder getInstanceSAX() {
        if (instanceSAX == null) {
            synchronized (TaxiParkSAXBuilder.class) {
                if (instanceSAX == null) {
                    instanceSAX = new TaxiParkSAXBuilder();
                }
            }
        }
        return instanceSAX;
    }
}

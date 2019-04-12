/**
 * @author - Maksim Kosmachev
 */
package by.epam.javawebtraining.maksimkosmachev.task06.model.validator;

import by.epam.javawebtraining.maksimkosmachev.task06.model.exception.CarErrorHandler;
import org.apache.log4j.Logger;
import org.xml.sax.SAXException;

import javax.xml.XMLConstants;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import java.io.File;
import java.io.IOException;

public class ValidatorSAX {

    private static Logger logger=Logger.getLogger(ValidatorSAX.class);

    public static void main(String[] args)  {
        String fileName = ".\\src\\TaxiPark.xml";
        String schemaName = ".\\src\\TaxiParkSchema.xsd";
        String logName = ".\\src\\Log.txt";
        Schema schema=null;
        String language = XMLConstants.W3C_XML_SCHEMA_NS_URI;
        SchemaFactory factory= SchemaFactory.newInstance(language);
        try {
            schema=factory.newSchema(new File(schemaName));
            SAXParserFactory spf=SAXParserFactory.newInstance();
            spf.setSchema(schema);
            SAXParser parser=spf.newSAXParser();
            parser.parse(fileName,new CarErrorHandler(logName));
            logger.info(fileName + " is valid");
        } catch (SAXException e) {
            logger.error(fileName+" SAX error "+e.getMessage());

        } catch (ParserConfigurationException e) {
            logger.error(fileName+" config error "+e.getMessage());

        } catch (IOException e) {
            logger.error("I/O error "+e.getMessage());
        }


    }
}

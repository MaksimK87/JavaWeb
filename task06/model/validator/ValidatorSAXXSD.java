/**
 * @author - Maksim Kosmachev
 */
package by.epam.javawebtraining.maksimkosmachev.task06.model.validator;

import org.apache.log4j.Logger;
import org.xml.sax.SAXException;

import javax.xml.XMLConstants;
import javax.xml.transform.Source;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import javax.xml.validation.Validator;
import java.io.File;
import java.io.IOException;


public class ValidatorSAXXSD {

    private static Logger logger =Logger.getLogger(ValidatorSAXXSD.class);

    public static void main(String[] args) {
        String language= XMLConstants.W3C_XML_SCHEMA_NS_URI;
        String fileName=".\\src\\TaxiPark.xml";
        String schemaName=".\\src\\TaxiParkSchema.xsd";
        SchemaFactory factory=SchemaFactory.newInstance(language);
        File schemaLocation=new File(schemaName);
        try {
            Schema schema=factory.newSchema(schemaLocation);
            Validator validator=schema.newValidator();
            Source source=new StreamSource(fileName);
            validator.validate(source);
            logger.info(fileName+ " is valid");
        } catch (SAXException e) {
            logger.error("Validation "+fileName + " is not valid because" +e.getMessage());
        } catch (IOException e) {
            logger.error(fileName + "is not valid because " + e.getMessage());
        }


    }
}

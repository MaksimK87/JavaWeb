/**
 * @author - Maksim Kosmachev
 */
package by.epam.javawebtraining.maksimkosmachev.task06.model.exception;

import org.apache.log4j.FileAppender;
import org.apache.log4j.Logger;
import org.apache.log4j.SimpleLayout;
import org.xml.sax.SAXException;
import org.xml.sax.SAXParseException;
import org.xml.sax.helpers.DefaultHandler;

import java.io.IOException;

public class CarErrorHandler extends DefaultHandler {
    private Logger logger=Logger.getRootLogger();

    public CarErrorHandler(String log) throws IOException {
        logger.addAppender(new FileAppender(new SimpleLayout(),log));
    }

    public void warning(SAXParseException e)  {
        logger.warn(getLineAdress(e)+"-" + e.getMessage());
    }


    public void error(SAXParseException e) throws SAXException {
        logger.error(getLineAdress(e)+"-" + e.getMessage());
    }

    public void fatalError(SAXParseException e) throws SAXException {
        logger.fatal(getLineAdress(e)+"-" + e.getMessage());
    }
    private String getLineAdress(SAXParseException e) {
    return e.getLineNumber()+" : "+e.getColumnNumber();
    }
}

/**
 * @author - Maksim Kosmachev
 */
package by.epam.javawebtraining.maksimkosmachev.task04.model.parser;

import by.epam.javawebtraining.maksimkosmachev.task04.model.entity.IUnit;
import by.epam.javawebtraining.maksimkosmachev.task04.model.entity.Paragraf;
import by.epam.javawebtraining.maksimkosmachev.task04.model.reader.TextReader;
import org.apache.log4j.Logger;

import java.util.List;

public class TextParcer extends AbstractParser {
    private static Logger logger = Logger.getLogger(TextParcer.class);

    private String text;
    private static final String PARAGRAF_SPLITTER = "[\t]";

    public String getText() {

        return text;
    }

    public void setText(String text) {

        this.text = text;
    }


    TextParcer(String text) {

        this.text = text;
    }

    TextParcer() {
        this.text = TextReader.readFile();
    }

    public List<IUnit> parse() {
        String[] paragrafs = text.split(PARAGRAF_SPLITTER);
        for (String paragraf : paragrafs) {
            logger.info("\n"+"next paragraf will add to container: " + "\n" + paragraf);
            composites.add(new Paragraf(paragraf));
        }
        if (this.getNextParser() != null) {
            logger.info("moving to the paragraf parser from text parser");
            return getNextParser().parse(composites);
        }
        return composites;
    }

    @Override
    List<IUnit> parse(List<IUnit> composites) {
        return null;
    }
}

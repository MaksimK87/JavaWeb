package by.epam.javawebtraining.maksimkosmachev.task04.model.parser;

import by.epam.javawebtraining.maksimkosmachev.task04.model.entity.Code;
import by.epam.javawebtraining.maksimkosmachev.task04.model.entity.IUnit;
import by.epam.javawebtraining.maksimkosmachev.task04.model.entity.Punctuation;
import by.epam.javawebtraining.maksimkosmachev.task04.model.entity.Word;
import org.apache.log4j.Logger;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class WordParcer extends AbstractParser {
    private static Logger logger = Logger.getLogger(WordParcer.class);
    String wordSplitter = "[,|.|;|:|-]";

    @Override
    List<IUnit> parse() {
        return null;
    }

    @Override
    List<IUnit> parse(List<IUnit> words) {
        List<IUnit> wordElements = new ArrayList<>();
        String[] separateElements;
        Pattern pat = Pattern.compile(wordSplitter);
        Matcher mat;
        for (IUnit element : words) {
            mat = pat.matcher(wordSplitter);
            if (mat.find()) {
                Punctuation punct = new Punctuation(mat.group());
                separateElements = element.getString().split(wordSplitter);
                logger.info("sign of punctuation was found and add to wordsElement container: "
                        + punct.getString());
                for (String separateElement : separateElements) {
                    wordElements.add(new Word(separateElement));
                    logger.info("Word and sign of punctuation were splitted " + separateElement + " " + "-->" + punct);
                    wordElements.add(punct);
                }
            }
            if ((element instanceof Code)) {
                logger.info("Code was skipped while word parsing splitting process:" + element.getString());
                wordElements.add(element);
                continue;
            } else {
                wordElements.add(element);
            }

        }
        if (getNextParser() != null) {
            return getNextParser().parse(words);
        }

        return words;
    }
}

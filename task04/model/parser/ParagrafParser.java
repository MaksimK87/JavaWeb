/**
 * @author - Maksim Kosmachev
 */
package by.epam.javawebtraining.maksimkosmachev.task04.model.parser;

import by.epam.javawebtraining.maksimkosmachev.task04.model.entity.Code;
import by.epam.javawebtraining.maksimkosmachev.task04.model.entity.IUnit;
import by.epam.javawebtraining.maksimkosmachev.task04.model.entity.Sentence;
import org.apache.log4j.Logger;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ParagrafParser extends AbstractParser {
    private static Logger logger = Logger.getLogger(ParagrafParser.class);

    private static final String CODE_SEARCHER = "\\{(?s).*}";
    private static final String SENTENCE_SPLITTER = "[.|!|?]";

    public ParagrafParser() {

    }

    @Override
    List<IUnit> parse(List<IUnit> composites) {
        List<IUnit> sentences = new ArrayList<>();
        String[] setOfSentences;
        Pattern pat = Pattern.compile(CODE_SEARCHER);
        Matcher mat;
        for (IUnit composite : composites) {
            mat = pat.matcher(composite.getString());
            if (mat.find()) {
                Code code = new Code(mat.group());
                logger.info("Code was detected: " + "\n" + code.getString());
                sentences.add(code);
                continue;
            } else {
                setOfSentences = composite.getString().split(SENTENCE_SPLITTER);
                logger.info("paragraf was splitted:" + composite.getString());
                for (String sentence : setOfSentences) {
                    Sentence s = new Sentence(sentence);
                    sentences.add(s);
                    logger.info("sentence was added to container of sentences" + "\n" + s.getString());
                }
            }


        }
        if (getNextParser() != null) {
            return getNextParser().parse(sentences);
        }
        return sentences;
    }

    @Override
    List<IUnit> parse() {
        return null;
    }
}

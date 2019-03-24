package by.epam.javawebtraining.maksimkosmachev.task04.model.parser;

import by.epam.javawebtraining.maksimkosmachev.task04.model.entity.Code;
import by.epam.javawebtraining.maksimkosmachev.task04.model.entity.IUnit;
import by.epam.javawebtraining.maksimkosmachev.task04.model.entity.Word;
import org.apache.log4j.Logger;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SentenceParser extends AbstractParser {
    Logger logger=Logger.getLogger(SentenceParser.class);
    String sentenceSplitter="[\\s]";

    SentenceParser() {

    }

    @Override
    List<IUnit> parse() {
        return null;
    }

    @Override
    List<IUnit> parse(List<IUnit> composites) {
        List<IUnit> words=new ArrayList<>();
        String [] setOfWords;
        Pattern pat = Pattern.compile(sentenceSplitter);
        Matcher mat;
        for (IUnit composite : composites) {
            if((composite instanceof Code)){
                logger.info("Code was skipped while sentence splitting process:" +composite.getString());
                words.add(composite);
                continue;
            }
            setOfWords=composite.getString().split(sentenceSplitter);
                logger.info("sentence was splitted:" + composite.getString());
                for (String word : setOfWords) {
                    Word w = new Word(word);
                    words.add(w);
                    logger.info("word was added to container of words: "  + w.getString());
            }


        }
        if (getNextParser() != null) {
            return getNextParser().parse(words);
        }

        return words;
    }
}

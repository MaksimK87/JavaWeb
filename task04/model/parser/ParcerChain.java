package by.epam.javawebtraining.maksimkosmachev.task04.model.parser;

import by.epam.javawebtraining.maksimkosmachev.task04.ParcerKind;
import by.epam.javawebtraining.maksimkosmachev.task04.model.entity.IUnit;

import java.util.List;

public class ParcerChain {

    public static List<IUnit> setChain(ParcerKind parserKind) {
        TextParcer textParcer = new TextParcer();
        ParagrafParser paragrafParser = new ParagrafParser();
        SentenceParser sentenceParser = new SentenceParser();
        WordParcer wordParcer = new WordParcer();

        switch (parserKind) {
            case PARAGRAF:
                textParcer.setNextParser(paragrafParser);
                break;
            case SENTENCE:
                textParcer.setNextParser(paragrafParser);
                paragrafParser.setNextParser(sentenceParser);
                break;
            case WORD:
                textParcer.setNextParser(paragrafParser);
                paragrafParser.setNextParser(sentenceParser);
                sentenceParser.setNextParser(wordParcer);
        }

    return textParcer.parse();}
}

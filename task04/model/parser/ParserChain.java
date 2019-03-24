package by.epam.javawebtraining.maksimkosmachev.task04.model.parser;

public class ParserChain {

    public static void setChain() {
        TextParcer textParcer = new TextParcer();
        ParagrafParser paragrafParser = new ParagrafParser();
        SentenceParser sentenceParser = new SentenceParser();
//        WordParcer wordParcer=new WordParcer();
        textParcer.setNextParser(paragrafParser);
       // paragrafParser.setNextParser(sentenceParser);
//        sentenceParser.setNextParser(wordParcer);
        textParcer.parse();
    }
}

package by.epam.javawebtraining.maksimkosmachev.task04.model.entity;

public class Word implements IUnit {

    private String word;

    public Word(String element) {
        this.word = element;
    }

    public String getWord() {
        return word;
    }

    public void setWord(String word) {
        this.word = word;
    }

    public Word() {
    }

    @Override
    public String getString() {
        return this.word;
    }
}

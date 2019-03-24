package by.epam.javawebtraining.maksimkosmachev.task04.model.entity;

public class Sentence extends CompositeUnit {

    private String sentence;

    public String getSentence() {
        return sentence;
    }

    public void setSentence(String sentence) {
        this.sentence = sentence;
    }

    public Sentence() {

    }

    public Sentence(String sentence) {
        this.sentence = sentence;
    }

    @Override
    public String getString() {
        return sentence;
    }
}

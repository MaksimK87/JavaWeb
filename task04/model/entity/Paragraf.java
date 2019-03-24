package by.epam.javawebtraining.maksimkosmachev.task04.model.entity;

public class Paragraf extends CompositeUnit {
    public String getParagraf() {
        return paragraf;
    }

    private String paragraf;

    public Paragraf() {
    }

    public Paragraf(String element) {
        this.paragraf = element;
    }

    @Override
    public String getString() {
        return paragraf;
    }
}

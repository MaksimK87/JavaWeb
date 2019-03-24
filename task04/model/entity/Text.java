package by.epam.javawebtraining.maksimkosmachev.task04.model.entity;

public class Text extends CompositeUnit {

    private String text;


    public Text(String text) {
        this.text = text;
    }

    public Text() {

    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}

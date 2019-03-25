package by.epam.javawebtraining.maksimkosmachev.task04.model.entity;

public class Punctuation implements IUnit {
    private String punctSign;

    Punctuation() {

    }

    public Punctuation(String sign) {
        this.punctSign = sign;
    }

    @Override
    public String getString() {
        return punctSign;
    }
}

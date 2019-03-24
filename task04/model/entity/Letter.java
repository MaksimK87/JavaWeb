package by.epam.javawebtraining.maksimkosmachev.task04.model.entity;

import java.util.Objects;

public class Letter implements IUnit {
    private String letter;

    public Letter(){}

    public Letter(String letter) {

        this.letter = letter;
    }

    public boolean equals(Object o) {

        if (this == o) return true;
        if (!(o instanceof Letter)) return false;
        Letter letter1 = (Letter) o;
        return Objects.equals(letter, letter1.letter);
    }

    public int hashCode() {
        return Objects.hash(letter);
    }

    @Override
    public String toString() {
        return "Letter{" +
                "letter='" + letter + '\'' +
                '}';
    }

    @Override
    public String getString() {
        return letter;
    }
}

package by.epam.javawebtraining.maksimkosmachev.task1.entity.enums;

public enum TypeOfFuel {
    DIESEL("diesel"),
    GASOLINE("gasoline");
    private String title;

    TypeOfFuel(String title) {

        this.title=title;
    }

    public String getTitle() {
        return title;
    }

    @Override
    public String toString() {
        return  title+"";
    }
}

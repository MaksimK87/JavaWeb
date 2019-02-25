package by.epam.javawebtraining.maksimkosmachev.task1.entity.enums;

public enum TypeOfLorry {
    SEMITRAILER("Semitrailer"), AUTOMATIC_COUPLER("Automatic coupler"), REFRIGERATOR_VAN("Refrigerator van");
    private String typeOfLorry;
    TypeOfLorry(String typeOfLorry) {
        this.typeOfLorry=typeOfLorry;
    }

    public String getTypeOfLorry() {
        return typeOfLorry;
    }

    @Override
    public String toString() {
        return typeOfLorry + "";
    }
}

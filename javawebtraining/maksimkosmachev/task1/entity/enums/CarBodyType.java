package by.epam.javawebtraining.maksimkosmachev.task1.entity.enums;

public enum CarBodyType {
    SEDAN("Sedan"), HATCHBACK("Hatchback"), UNIVERSAL("Universal"), SUV("Suv"),MINIVAN("Minivan"),
    MINIBUS("Minibus");
    private String carBodyType;

    CarBodyType(String carBodyType) {
        this.carBodyType=carBodyType;
    }

    public String getCarBodyType() {
        return carBodyType;
    }

    @Override
    public String toString() {
        return  carBodyType + "";
    }
}

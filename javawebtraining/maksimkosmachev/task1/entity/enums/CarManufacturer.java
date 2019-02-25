package by.epam.javawebtraining.maksimkosmachev.task1.entity.enums;

public enum CarManufacturer {
    VOLVO("Volvo"), DAF("DAF"), MERSEDES("Mersedes"), FORD("Ford"), VOLKSWAGEN("Volksvagen"), TOYOTA("Toyota"),
    NISSAN("Nissan"), HYUNDAI("Hyundai"), BMW("BMW"), OPEL("Opel"), MAZDA("Mazda"), RENAULT("Renault"),
    HONDA("Honda"), MITSUBISHI("Mitsubishi"), AUDI("Audi");
    private String manufacturer;

    CarManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    @Override
    public String toString() {
        return manufacturer + "";
    }
}

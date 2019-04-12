/**
 * @author - Maksim Kosmachev
 */
package by.epam.javawebtraining.maksimkosmachev.task06.model.entity.enums;

public enum CarEnum {
    ID("id"),
    TAXIPARK("taxiPark"),
    PASSENGERCAR("passengerCar"),
    LORRY("lorry"),
    MANUFACTURER("manufacturer"),
    YEAROFISSUE("yearOfIssue"),
    PRICE("price"),
    FUELTYPE("fuelType"),
    CONSUMPTION("consumption"),
    ENGINEVALUE("engineValue"),
    KILOMETRAGE("kilometrage"),
    FARE("fare"),
    SEATSQUANTITY("seatsQuantity"),
    BODYTYPE("bodyType"),
    TYPEOFLORRY("typeOfLorry"),
    WEIGHT("weight");



    private String value;

    CarEnum(String value){
        this.value=value;
    }
    public String getValue() {
        return value;
    }
}

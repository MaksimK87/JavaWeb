package by.epam.javawebtraining.maksimkosmachev.task1.entity;

public class PassengerCar extends Car {

    private int seatsQuantity;
    private String bodyType;

    public PassengerCar(int price, double consumption, int yearOfIssue, String fuelType, int kilometrage,
                        double engineValue, String manufacturer, double fare, int seatsQuantity, String bodyType) {
        super(price, consumption, yearOfIssue, fuelType, kilometrage, engineValue, manufacturer, fare);
        this.seatsQuantity = seatsQuantity;
        this.bodyType = bodyType;
    }

    public PassengerCar() {

    }

    PassengerCar(PassengerCar passengerCar) {
        super(passengerCar);
        this.seatsQuantity = passengerCar.seatsQuantity;
        this.bodyType = passengerCar.bodyType;
    }

    public int getSeatsQuantity() {
        return seatsQuantity;
    }

    public void setSeatsQuantity(int seatsQuantity) {
        if (seatsQuantity > 0) {
            this.seatsQuantity = seatsQuantity;
        }
    }

    public String getBodyType() {
        return bodyType;
    }

    public void setBodyType(String bodyType) {
        this.bodyType = bodyType;
    }

    @Override
    public String toString() {
        return super.toString() + "PassengerCar{" +
                "seatsQuantity= " + seatsQuantity +
                ", bodyType='" + bodyType + '\'' +
                '}';
    }
}

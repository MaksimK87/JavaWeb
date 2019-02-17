package by.epam.javawebtraining.maksimkosmachev.task1.entity;

public class Lorry extends Car {
    private String typeOfLorry;
    private int weight;

    public Lorry(int price, double consumption, int yearOfIssue, String fuelType, int kilometrage, double engineValue,
                 String manufacturer, double fare, String typeOfLorry, int weight) {
        super(price, consumption, yearOfIssue, fuelType, kilometrage, engineValue, manufacturer, fare);
        this.typeOfLorry = typeOfLorry;
        this.weight = weight;
    }

    public Lorry() {

    }

    Lorry(Lorry lorry) {
        super(lorry);
        this.typeOfLorry = lorry.typeOfLorry;
        this.weight = lorry.weight;
    }

    public String getTypeOfLorry() {
        return typeOfLorry;
    }

    public void setTypeOfLorry(String typeOfLorry) {
        this.typeOfLorry = typeOfLorry;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        if (weight > 0) {
            this.weight = weight;
        }
    }

    @Override
    public String toString() {
        return super.toString() + "Lorry{" +
                "typeOfLorry='" + typeOfLorry + '\'' +
                ", weight=" + weight + " kg"+
                '}';
    }
}

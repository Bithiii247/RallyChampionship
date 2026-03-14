package main;

public class Driver {

    private String name;
    private String country;
    private int totalPoints;
    private RallyCar car;

    public Driver(String name, String country, RallyCar car) {
        this.name = name;
        this.country = country;
        this.car = car;
        this.totalPoints = 0;
    }

    public String getName() {
        return name;
    }

    public String getCountry() {
        return country;
    }

    public int getTotalPoints() {
        return totalPoints;
    }

    public RallyCar getCar() {
        return car;
    }

    public void switchCar(RallyCar newCar) {
        this.car = newCar;
    }

    public void addPoints(int points) {
        totalPoints += points;
    }
}
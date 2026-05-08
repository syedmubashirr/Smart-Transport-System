package models;

public abstract class Vehicle {

    protected String id;
    protected double ratePerKm;

    public Vehicle(String id, double ratePerKm) {
        this.id = id;
        this.ratePerKm = ratePerKm;
    }

    public abstract double calculateFare(double distance);

    public String getId() {
        return id;
    }
}
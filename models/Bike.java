package models;

public class Bike extends Vehicle {

    public Bike(String id) {
        super(id, 10);
    }

    public double calculateFare(double distance) {
        return distance * ratePerKm;
    }
}
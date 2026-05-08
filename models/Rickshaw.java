package models;

public class Rickshaw extends Vehicle {

    public Rickshaw(String id) {
        super(id, 15);
    }

    public double calculateFare(double distance) {
        return (distance * ratePerKm) + 20;
    }
}
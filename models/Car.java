package models;

public class Car extends Vehicle {

    public Car(String id) {
        super(id, 20);
    }

    public double calculateFare(double distance) {
        return (distance * ratePerKm) + 50;
    }
}
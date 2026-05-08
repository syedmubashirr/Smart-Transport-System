package models;

public class Booking {

    private static int counter = 1;

    private int bookingId;
    private Passenger passenger;
    private Driver driver;
    private Vehicle vehicle;
    private double distance;
    private double fare;
    private String status;

    public Booking(Passenger passenger, Driver driver,
         Vehicle vehicle, double distance) throws Exception {

        if (distance <= 0) {
            throw new Exception("Distance must be greater than 0");
            
        }

        this.bookingId = counter++;
        this.passenger = passenger;
        this.driver = driver;
        this.vehicle = vehicle;
        this.distance = distance;

        this.fare = vehicle.calculateFare(distance);

        this.status = "Completed";
         }

    public int getBookingId() {
        return bookingId;
         }

    public double getFare() {
        return fare;
        }

    public String toFileString() {

        return bookingId + "," +
               passenger.getName() + "," +
               driver.getName() + "," +
               vehicle.getId() + "," +
               distance + "," +
               fare + "," +
               status;
        }

    public void display() {

        System.out.println("\n===== BOOKING DETAILS =====");

        System.out.println("Booking ID: " + bookingId);
        System.out.println("Passenger: " + passenger.getName());
        System.out.println("Driver: " + driver.getName());
        System.out.println("Vehicle: " + vehicle.getId());
        System.out.println("Distance: " + distance + " km");
        System.out.println("Fare: " + fare);
        System.out.println("Status: " + status);
    }
}
import java.util.*;
import java.io.*;

import models.*;
import payments.*;


public class Main {

    static Scanner sc = new Scanner(System.in);

    static ArrayList<Booking> bookings = new ArrayList<>();
    static ArrayList<Driver> drivers = new ArrayList<>();

    public static void main(String[] args) {

        addDrivers();

        Admin admin = new Admin("Admin", "0000");

        while (true) {

            System.out.println("\nSMART TRANSPORT SYSTEM      ");


            System.out.println("1. New Booking");
            System.out.println("2. View All Bookings");
            System.out.println("3. Search Booking");
            System.out.println("4. View Drivers");
            System.out.println("5. View Total Revenue");
            System.out.println("6. Save Bookings To File");
            System.out.println("7. Exit");

            System.out.print("Enter Choice: ");

            int choice = sc.nextInt();
            sc.nextLine();

            try {

             switch (choice) {

         case 1:
         Booking b = createBooking();

          if (b != null) {
        bookings.add(b);
        }

         break;

        case 2:
         showBookings();
         break;

        case 3:
         searchBooking();
         break;

         case 4:
         admin.showAdminPanel();
          showDrivers();
        break;

         case 5:
        showRevenue();
         break;
         

        case 6:
                       
     saveToFile();
    break;

        case 7:
         System.out.println("Program Closed");
        return;

                   
         default:
        System.out.println("Invalid Choice");
        }

            } catch (Exception e) {

                System.out.println("Error: " + e.getMessage());
            }
        }
    }

    static void addDrivers() {

        drivers.add(
            new Driver("Mubashir", "03001234567", "LIC101")
        );

        drivers.add(
            new Driver("Fiza", "03111234567", "LIC102")
        );

        drivers.add(
            new Driver("Usman", "03221234567", "LIC103")
        );
    }

    static Driver assignDriver() {

        for (Driver d : drivers) {

            if (d.isAvailable()) {

              d.setAvailable(false);

             return d;
             
             
            }
        }

        return null;
    }

    static Booking createBooking() throws Exception {

        System.out.print("Enter Passenger Name: ");

        String name = sc.nextLine();

        if (name.isEmpty()) {
            throw new Exception("Name cannot be empty");
        }

        System.out.print("Enter Phone Number: ");

        String phone = sc.nextLine();

        if (phone.length() < 11) {
            throw new Exception("Invalid phone number");
        }

        Passenger passenger =
            new Passenger(name, phone);

        Driver driver = assignDriver();

        if (driver == null) {
            throw new Exception("No drivers available");
        }

        System.out.println("\nSelect Vehicle");

        System.out.println("1. Car");
        System.out.println("2. Bike");
        System.out.println("3. Rickshaw");

        int vehicleChoice = sc.nextInt();

        Vehicle vehicle;

        if (vehicleChoice == 1) {

            vehicle = new Car("C1");
        }

        else if (vehicleChoice == 2) {

            vehicle = new Bike("B1");
        }

        else if (vehicleChoice == 3) {

            vehicle = new Rickshaw("R1");
        }

        else {

            throw new Exception("Invalid vehicle choice");
        }

        System.out.print("Enter Distance (km): ");

        double distance = sc.nextDouble();

        Booking booking =
            new Booking(passenger,
                        driver,
                        vehicle,
                        distance);

        booking.display();

        System.out.println("\nSelect Payment Method");

        System.out.println("1. Cash");
        System.out.println("2. Card");

        int paymentChoice = sc.nextInt();

        Payment payment;

        if (paymentChoice == 1) {

            payment = new CashPayment();
        }

        else if (paymentChoice == 2) {

            payment = new CardPayment();
        }

        else {

            throw new Exception("Invalid payment method");
        }

        payment.pay(booking.getFare());

        return booking;
    }

    static void showBookings() {

        if (bookings.isEmpty()) {

            System.out.println("No bookings available");

            return;
        }

        for (Booking b : bookings) {

            b.display();
        }
    }

    static void searchBooking() {

        if (bookings.isEmpty()) {

            System.out.println("No bookings available");

            return;
        }

        System.out.print("Enter Booking ID: ");

        int id = sc.nextInt();

        for (Booking b : bookings) {

            if (b.getBookingId() == id) {

                b.display();

                return;
            }
        }

        System.out.println("Booking not found");
    }

    static void showDrivers() {

        System.out.println("\n      DRIVER LIST     ");

        for (Driver d : drivers) {

            System.out.println("Name: " + d.getName());

            System.out.println(
                "License Number: " +
                d.getLicenseNo()
            );

            System.out.println(
                "Available: " +
                d.isAvailable()
            );

            System.out.println();
        }
    }

    static void showRevenue() {

        double total = 0;

        for (Booking b : bookings) {

            total += b.getFare();
        }

        System.out.println(
            "Total Revenue: " + total
        );
    }

    static void saveToFile() throws IOException {

        FileWriter fw =
            new FileWriter("bookings.txt", true);

        for (Booking b : bookings) {

            fw.write(
                b.toFileString() + "\n"
            );
        }

        fw.close();

        System.out.println("Bookings saved to file");
    
         }
}
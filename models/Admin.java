package models;

public class Admin extends User {

    public Admin(String name, String phone) {
        super(name, phone);
    }

    public void showAdminPanel() {
        System.out.println("Admin Panel Opened");
      }
}
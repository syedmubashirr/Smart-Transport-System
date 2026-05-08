package models;

public class Driver extends User {

    private String licenseNo;
    private boolean available;

    public Driver(String name, String phone, String licenseNo) {
        
        
        super(name, phone);
        this.licenseNo = licenseNo;
        this.available = true;
      }

    public String getLicenseNo() {
        return licenseNo;
      }



    public boolean isAvailable() {
        return available;
     
        
    }

    public void setAvailable(boolean available) {
        this.available = available;
       }
}
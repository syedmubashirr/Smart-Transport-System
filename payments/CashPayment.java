package payments;

public class CashPayment implements Payment {

    public void pay(double amount) {
        System.out.println("Paid " + amount + " using CASH");
    }
}
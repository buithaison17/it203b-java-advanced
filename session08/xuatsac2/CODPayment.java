package xuatsac2;

public class CODPayment implements PaymentMethod {
    @Override
    public void pay(double amount) {
        System.out.println("Thanh toan COD: " + amount);
    }
}

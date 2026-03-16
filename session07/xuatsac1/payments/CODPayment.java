package xuatsac1.payments;

public class CODPayment implements PaymentMethod {
    @Override
    public void pay(double amount) {
        System.out.println("Thanh toán COD: " + amount);
    }
}

package xuatsac1.payments;

public class CreditCard implements PaymentMethod {
    @Override
    public void pay(double amount) {
        System.out.println("Thanh toán CreditCard: " + amount);
    }
}

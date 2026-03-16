package xuatsac1.payments;

public class Momo implements PaymentMethod {

    @Override
    public void pay(double amount) {
        System.out.println("Thanh toán qua Momo: " + amount);
    }
}

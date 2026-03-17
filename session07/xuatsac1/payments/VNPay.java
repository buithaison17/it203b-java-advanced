package xuatsac1.payments;

public class VNPay implements PaymentMethod {
    @Override
    public void pay(double amount) {
        System.out.println("Thanh toán qua VNPay: " + amount);
    }
}

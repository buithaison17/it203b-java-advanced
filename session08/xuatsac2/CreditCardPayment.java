package xuatsac2;

public class CreditCardPayment implements PaymentMethod {

    @Override
    public void pay(double amount) {
        System.out.println("Thanh toan bang the tin dung: " + amount);
    }

}

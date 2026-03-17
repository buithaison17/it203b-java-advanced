package xuatsac2;

public class MomoPayment implements PaymentMethod {

    @Override
    public void pay(double amount) {
        System.out.println("Thanh toan bang MoMo: " + amount);
    }

}

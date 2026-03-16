package gioi1;

public class Gioi1 {
    public static void main(String[] args) {
        PaymentProcessor processor = new PaymentProcessor();

        PaymentMethod cod = new CODPayment();
        processor.processPayment(cod, 5000000);

        PaymentMethod cardPayment = new CreditCardPayment();
        processor.processPayment(cardPayment, 1000000);

        PaymentMethod momo = new MomoPayment();
        processor.processPayment(momo, 750000);

    }
}

package gioi1;

public class PaymentProcessor {
    public void processPayment(PaymentMethod paymentMethod, double amount) {
        if (paymentMethod instanceof CODPayment cod) {
            cod.processCOD(amount);
        }
        if (paymentMethod instanceof CardPayable card) {
            card.processCard(amount);
        }
        if (paymentMethod instanceof EWalletPayable eWallet) {
            eWallet.processEWallet(amount);
        }
    }
}

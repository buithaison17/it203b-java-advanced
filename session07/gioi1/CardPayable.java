package gioi1;

public interface CardPayable extends PaymentMethod {
    void processCard(double amount);
}

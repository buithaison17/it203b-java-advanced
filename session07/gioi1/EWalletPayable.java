package gioi1;

public interface EWalletPayable extends PaymentMethod {
    void processEWallet(double amount);
}

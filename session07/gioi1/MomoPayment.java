package gioi1;

public class MomoPayment implements EWalletPayable {
    @Override
    public void processEWallet(double amount) {
        System.out.printf("Xử lý thanh toán MoMo: %f - Thành công", amount);
    }
}

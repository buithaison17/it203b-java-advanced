package gioi1;

public class CreditCardPayment implements CardPayable {
    @Override
    public void processCard(double amount) {
        System.out.printf("Xử lý thanh toán thẻ tín dụng: %f - Thành công\n", amount);
    }
}

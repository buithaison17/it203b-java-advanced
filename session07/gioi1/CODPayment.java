package gioi1;

public class CODPayment implements CODPayable {
    @Override
    public void processCOD(double amount) {
        System.out.printf("Xử lý thanh toán COD: %f - Thành công\n", amount);
    }
}

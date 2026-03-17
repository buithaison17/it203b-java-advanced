package xuatsac1.invoices;

import xuatsac1.models.Order;

public class InvoiceGenerator {
    public void printInvoice(Order order, double discount) {
        System.out.println("-----HÓA ĐƠN-----");
        System.out.println("Khách: " + order.getCustomer().getFullName());
        order.getItems().forEach(i -> System.out.println(
                i.getProduct().getProductName()
                        + " - Số lượng: " + i.getQuantity()
                        + " - Thành tiền: " + i.getTotal()));
        double total = order.getTotalAmount();
        System.out.println("Tổng tiền: " + total);
        System.out.println("Giảm giá: " + discount);
        System.out.println("Cần thanh toán: " + (total - discount));
    }
}

package kha1;

import java.util.ArrayList;
import java.util.List;

public class CustomerRepository {
    private List<Customer> customers = new ArrayList<>();

    public void addCustomer(Customer customer) {
        customers.add(customer);
        System.out.println("Đã thêm khách hàng");
    }
}

package xuatsac1.models;

public class Customer {
    private String customerId;
    private String fullName;
    private String email;

    public Customer(String customerId, String fullName, String email) {
        this.customerId = customerId;
        this.fullName = fullName;
        this.email = email;
    }

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

}

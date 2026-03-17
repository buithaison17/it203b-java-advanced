package xuatsac2;

public class WebsiteDiscount implements DiscountStrategy {

    @Override
    public double applyDiscount(double amount) {
        return amount * 0.1;
    }

}

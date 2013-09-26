package cashregister;

public class PercentageDiscount implements Discount{
    private final double PERCENT_DISCOUNT = 0.9;
    @Override
    public double returnDiscountedPrice(double price) {
        //Need to validate input
        return price * PERCENT_DISCOUNT;
    }
    
}

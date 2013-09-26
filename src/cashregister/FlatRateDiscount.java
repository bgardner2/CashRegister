package cashregister;

public class FlatRateDiscount implements Discount{
    private final String  INVALID_INPUT = "You entered invalid input into the FlatRateDiscount object";
    @Override
    public double returnDiscountedPrice(double price) {
        if (price < 0) {
            throw new IllegalArgumentException(INVALID_INPUT);
        }
        return price - 2.00;
    }
    
}

package cashregister;

public class NoDiscount implements DiscountStrategy {
    private final String INVALID_INPUT = "You entered invalid input into the NoDiscount object";
    @Override
    public double returnDiscountedPrice(double price) {
        if (price < 0) {
            throw new IllegalArgumentException(INVALID_INPUT);
        }
        return price;
    }
    
}

package cashregister;

public class NoDiscount implements Discount {

    @Override
    public double returnDiscountedPrice(double price) {
        return price;
    }
    
}

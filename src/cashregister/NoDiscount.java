package cashregister;

public class NoDiscount implements Discount {

    @Override
    public double returnDiscountedPrice(double price) {
        //Need to validate input
        return price;
    }
    
}

package cashregister;

public class NoDiscount implements Discount {

    @Override
    public double applyDiscountToPrice(double price) {
        return price;
    }
    
}

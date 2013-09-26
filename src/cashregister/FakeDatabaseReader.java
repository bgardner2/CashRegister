package cashregister;

public class FakeDatabaseReader implements StorageReader{
    private final String INVALID_INPUT = "You entered invalid input into the FakeDatabaseReader object";
    Product[] products = {new Product(new PercentageDiscount(), "BC001", "Brewers Baseball Cap",  20.00),
                            new Product(new PercentageDiscount(), "BS001", "Polka Dot Bed Sheets", 80.00),
                            new Product(new PercentageDiscount(), "FP001", "Paula Dean Frying Pan", 30.00)};
    
    Customer[] customers = {new Customer("SJ001", "Sally", "Jones", "52 Sunken cir", "", "New York", "NY", "23145"),
                            new Customer("DJ001", "Davey", "Jones", "87 Flying Dutchmen Way", "", "Miami", "FL", "14587"),
                            new Customer()};
    
    @Override
    public Product getProductByID(String itemNo) {
        if (itemNo.length() == 0) {
            throw new IllegalArgumentException(INVALID_INPUT);
        }
        
        for(Product p : products){
            if(p.getProductID().equals(itemNo)){
                return p;
            }
        }
        
        return null;
    }

    @Override
    public Customer getCustomerbyID(String custNo) {
        if (custNo.length() == 0) {
            throw new IllegalArgumentException(INVALID_INPUT);
        }
       for(Customer c : customers){
            if(c.getCustomerID().equals(custNo)){
                return c;
            }
        }
        
        return null;
    }

}

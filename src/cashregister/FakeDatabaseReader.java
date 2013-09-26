package cashregister;

public class FakeDatabaseReader implements StorageReader{
    Product[] products = {new Product(new PercentageDiscount(), "BC001", "Brewers Baseball Cap",  20.00),
                            new Product(new PercentageDiscount(), "BS001", "Polka Dot Bed Sheets", 80.00),
                            new Product(new PercentageDiscount(), "FP001", "Paula Dean Frying Pan", 30.00)};
    
    Customer[] customers = {new Customer("SJ001", "Sally", "Jones", "52 Sunken cir", "", "New York", "NY", "23145"),
                            new Customer("DJ001", "Davey", "Jones", "87 Flying Dutchmen Way", "", "Miami", "FL", "14587"),
                            new Customer()};
    
    @Override
    public Product getProductByID(String itemNo) {
        //Need to validate input
        for(Product p : products){
            if(p.getProductID().equals(itemNo)){
                return p;
            }
        }
        
        return null;
    }

    @Override
    public Customer getCustomerbyID(String custNo) {
        //Need to validate input
       for(Customer c : customers){
            if(c.getCustomerID().equals(custNo)){
                return c;
            }
        }
        
        return null;
    }

}

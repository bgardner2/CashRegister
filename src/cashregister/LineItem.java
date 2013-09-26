package cashregister;

public class LineItem {
    private Product product;
    private int itemQty = 0;

    
    private StorageManager sm = new StorageManager();
    
    public LineItem(String productID, int qty){
        //Need to validate input
            sm.setStorageType(new FakeDatabaseReader());
            Product p = sm.getProductById(productID);
            addProduct(p);
            setItemQty(qty);
            
    }
    
    public double returnDiscountedPrice(){
        return product.returnDiscountedPrice();
    }
    
    public Product getCurrentLineProduct(){
        return product;
    }
    
    
    
    private void addProduct(Product p){
        if(p != null){
            product = p;
        }
    }
    
    public int getItemQty() {
        return itemQty;
    }

    public void setItemQty(int itemQty) {
        if (itemQty >= 1){
            this.itemQty = itemQty;
        }
    }
}

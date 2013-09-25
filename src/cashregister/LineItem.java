package cashregister;

public class LineItem {
    private Product product;
    private int itemQty = 0;

    
    private StorageManager sm = new StorageManager();
    
    public LineItem(String productID, int qty){
            sm.setStorageType(new FakeDatabaseReader());
            Product p = sm.getProductById(productID);
            addProduct(p);
            setItemQty(qty);
            
    }
    
    public double applyDiscount(){
        return product.applyDiscount();
    }
    
    public Product returnProduct(){
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

package cashregister;

public class LineItem {
    private Product product;
    private int itemQty = 0;
    
    
    
    public LineItem(Product p, int qty){
        addProduct(p);
        setQty(qty);
    }
    
    private void addProduct(Product p){
        product = p;
    }
    
    private void setQty(int qty){
        itemQty = qty;
    }
}

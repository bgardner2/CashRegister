package cashregister;

public interface OutputStrategy {
    public abstract void outputReceiptData();
    
    /**
     * This method should be made private in the subclass
     * @return 
     */
    public String buildReceiptHeader();
    
    /**
     * This method should be made private in the sub
     * @return 
     */
    public abstract String buildItemLineString();
    
    /**
     * This method should be made private in the subclass
     * @return 
     */
    public abstract String buildReceiptFooter();
}

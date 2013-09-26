package cashregister;

public interface OutputStrategy {
    public abstract void outputReceiptData(Receipt receipt);
    
    /**
     * This method should be made private in the subclass
     * @return 
     */
    public String buildReceiptHeader(Receipt receipt);
    
    /**
     * This method should be made private in the sub
     * @return 
     */
    public abstract String buildItemLineString(Receipt receipt);
    
    /**
     * This method should be made private in the subclass
     * @return 
     */
    public abstract String buildReceiptFooter(Receipt receipt);
}

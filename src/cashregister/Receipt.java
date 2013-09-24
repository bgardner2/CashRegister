package cashregister;

public class Receipt {
    private final String TEST_TRANSACTION_ID = "000395834";
    private LineItem[] lineItems = new LineItem[1];
    private Customer customer;
    private StorageManager sm = new StorageManager();
    private String transactionID;
    
    public Receipt(){
        this.initializeReceipt();
    }
    
    private void initializeReceipt(){
        /*Assign transaction id a test id for now
         * In real world we could search a database for a transaction id
         * and assign a value that is not found in the database
         */
        this.transactionID = this.TEST_TRANSACTION_ID;
        customer = new Customer();
        
    }
    
    public void addLine(Product p, int qty){
        if(lineItems[1] == null){
            lineItems[1] = new LineItem(p, qty);
        }else
        {
            //Add item to array
            LineItem lineItem = new LineItem(p, qty);
            LineItem[] temp = new LineItem[lineItems.length + 1];
            System.arraycopy(lineItems, 0, temp, 0, temp.length);
            temp[temp.length -1] = lineItem;
            lineItems = temp;
        }
    }
}

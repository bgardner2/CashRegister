package cashregister;

import java.text.DecimalFormat;
import java.text.NumberFormat;

public class Receipt {

    NumberFormat formatter = NumberFormat.getCurrencyInstance();
    DecimalFormat receiptFormatNumber = new DecimalFormat("0000");
    private static int receiptNumber = 0;
    private LineItem[] lineItems = new LineItem[1];
    private Customer customer;
    private StorageManager sm = new StorageManager();
    private OutputManager om  = new OutputManager();
    private Store store = new Store();

    
    /**
     * This constructor takes a customer number argument and a reader argument
     * and sets the customer lookup data source as the reader then looks up the
     * customer number in the data source
     *
     * @param custNo
     * @param reader
     */
    public Receipt(String custNo, StorageReader reader, OutputStrategy output) {
        if (custNo.length() <= 0 || reader == null || output == null) {
            throw new IllegalArgumentException("Please enter valid data");
        }
        sm.setStorageType(reader);
        om.setOutputStratetgy(output);
        customer = sm.getCustomerByID(custNo);
        receiptNumber++;

    }

    /**
     * This method returns the customer object associated with this receipt
     *
     * @return
     */
    public Customer getCustomer() {
        return customer;
    }

    /**
     * This method adds a product object and quantity to  new LineItem object
     * in the LineItem array
     * @param productID
     * @param qty 
     */
    public void addItemToLine(String productID, int qty) {
        //Validate the product ID and quanitity
        if (productID.length() <= 0 || qty <= 0) {
            throw new IllegalArgumentException("Please enter valid data");
        }
        
        //If this is the first time adding an object to the array, add it at index 0
        if (lineItems[0] == null) {
            lineItems[0] = new LineItem(productID, qty);
        }
        else {
            /*
             * Look through all the items in the lineItem array
             * if the same item is found, add a quantity to the existing quantity
             * If found, break out of the method
             */
            for (LineItem item : lineItems) {
                if (item.getCurrentLineProduct().getProductID().equals(productID)) {
                    item.setItemQty(item.getItemQty() + qty);
                    return;
                }
            }

            /*
             * This code will only be reached if the item isn't found, and add the item to 
             * the lineItem array
             */
            LineItem newItem = new LineItem(productID, qty);
            LineItem[] temp = new LineItem[lineItems.length + 1];
            System.arraycopy(lineItems, 0, temp, 0, lineItems.length);
            temp[temp.length - 1] = newItem;
            lineItems = temp;
        }
    }
    
    /**
     * This method outputs the receipt data to the output strategy
     */
    public void outputReceiptData(){
        om.returnOutput().outputReceiptData(this);
    }
    

    // <editor-fold defaultstate="collapsed" desc="Getters and setters">
    public int getReceiptNumber() {
        return receiptNumber;
    }


    public LineItem[] getLineItems() {
        return lineItems;
    }


    public void setSm(StorageManager sm) {
        this.sm = sm;
    }

    public Store getStore() {
        return store;
    }
    
    
    
    // </editor-fold>

    
    
}

package cashregister;

import java.text.NumberFormat;

public class Receipt {
    NumberFormat formatter = NumberFormat.getCurrencyInstance();
    
    public static int receiptNumber = 0;
    private LineItem[] lineItems = new LineItem[1];
    private Customer customer;
    private StorageManager sm = new StorageManager();
    private Store store = new Store();
    

    public Receipt() {
        this.initializeReceipt();
        
    }

    public Receipt(String custNo) {
        sm.setStorageType(new FakeDatabaseReader());
        customer = sm.getCustomerByID(custNo);
        receiptNumber++;

    }

    public Customer getCustomer() {
        return customer;
    }

    private void initializeReceipt() {
        customer = new Customer();
        receiptNumber++;
    }

    public void addLine(String productID, int qty) {
        if (lineItems[0] == null) {
            lineItems[0] = new LineItem(productID, qty);
        }
        else{
            /*
             * Look through all the items in the lineItem array
             * if the same item is found, add a quantity to the existing quantity
             * If found, break out of the method
             */
            for (LineItem item : lineItems) {
                if (item.returnProduct().getProductID().equals(productID)) {
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
    
    public String outputReceipt(){
         return this.buildReceiptHeader()
                + this.buildItemLineString()
                + this.buildReceiptFooter();
    }

    private String buildReceiptHeader(){
        String header = "";
        //Add store information
        header += store.getFormattedAddress() + "\n"
                + store.getPhoneNumber()
                + "\n\n";
        
        //Add customer greeting
        header += "Hello, " 
                + customer.getFirstName() + " " + customer.getLastName()
                + ".\nThank you for shopping at " + store.getCompanyName()
                + "\n\n";
        
        return header;
    }
    
    private String buildItemLineString() {
        String lineHeader = "";
        String item = "";
        item += "Product Description\t\t"
                + "Product Quantity\t\t"
                + "Product Base Price\t\t"
                + "Product Extended Price\t\t"
                + "Price after discount\n\n";
        
        //Add line item information
        for (LineItem items : lineItems) {
            item += items.returnProduct().getProductDesc() + "\t\t"
                    + items.getItemQty() + "\t\t\t\t\t\t"
                    + formatter.format(items.returnProduct().getPrice())+ "\t\t\t\t"
                    + formatter.format(items.returnProduct().getPrice() * items.getItemQty()) + "\t\t\t\t"
                    + formatter.format(items.applyDiscount() * items.getItemQty())
                    + "\n";
        }
        
        return item;
    }
    
    private String buildReceiptFooter(){
        double total = 0;
        
        for(LineItem items : lineItems){
            total += items.applyDiscount() * items.getItemQty();
        }
        
        String footer = "";
        footer += "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t---------------------\n";
        footer += "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t" + "Total" + "\t\t" + formatter.format(total);
        
        
        return footer;
        
    }
}

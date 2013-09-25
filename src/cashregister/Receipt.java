package cashregister;

import java.text.DecimalFormat;
import java.text.NumberFormat;

public class Receipt {
    NumberFormat formatter = NumberFormat.getCurrencyInstance();
    DecimalFormat receiptFormatNumber = new DecimalFormat("0000");
    
    
    public static int receiptNumber = 0;
    private LineItem[] lineItems = new LineItem[1];
    private Customer customer;
    private StorageManager sm = new StorageManager();
    private Store store = new Store();
    

    public Receipt(String custNo, StorageReader reader) {
        sm.setStorageType(reader);
        customer = sm.getCustomerByID(custNo);
        receiptNumber++;
        
    }

    public Customer getCustomer() {
        return customer;
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
    
    public String outputReceipt(){
         return this.buildReceiptHeader()
                + this.buildItemLineString()
                + this.buildReceiptFooter();
    }

    private String buildReceiptHeader(){
        String header = "";
        //Add store information
        header += store.getFormattedAddress() + "\n"
                + store.getPhoneNumber() + "\n"
                + "Transaction Number: #" + receiptFormatNumber.format(receiptNumber)
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
                + "Quantity\t\t\t"
                + "Product Base Price\t\t"
                + "Product Extended Price\t\t"
                + "Price after discount\n\n";
        
        //Add line item information
        for (LineItem items : lineItems) {
            item += items.getCurrentLineProduct().getProductDesc() + "\t\t"
                    + items.getItemQty() + "\t\t\t\t\t"
                    + formatter.format(items.getCurrentLineProduct().getPrice())+ "\t\t\t\t"
                    + formatter.format(items.getCurrentLineProduct().getPrice() * items.getItemQty()) + "\t\t\t\t"
                    + formatter.format(items.applyDiscount() * items.getItemQty())
                    + "\n";
        }
        
        return item;
    }
    
    private String buildReceiptFooter(){
        double total = 0;
        double amountSaved = 0;
        
        for(LineItem items : lineItems){
            total += items.applyDiscount() * items.getItemQty();
            amountSaved += (items.getCurrentLineProduct().getPrice() * items.getItemQty()) 
                    - items.applyDiscount() * items.getItemQty();
            
        }
        
        String footer = "";
        footer += "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t------------------------\n";
        footer += "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t" + "Total" + "\t\t" + formatter.format(total);
        footer += "\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t" + "Amount Saved" + "\t" + formatter.format(amountSaved);
        
        return footer;
        
    }
}

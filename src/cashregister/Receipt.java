package cashregister;

import java.text.DecimalFormat;
import java.text.NumberFormat;

public class Receipt {
    //TODO add an output strategy to the constructor

    NumberFormat formatter = NumberFormat.getCurrencyInstance();
    DecimalFormat receiptFormatNumber = new DecimalFormat("0000");
    public static int receiptNumber = 0;
    private LineItem[] lineItems = new LineItem[1];
    private Customer customer;
    private StorageManager sm = new StorageManager();
    private Store store = new Store();

    /**
     * This constructor takes a customer number argument and a reader argument
     * and sets the customer lookup data source as the reader then looks up the
     * customer number in the data source
     *
     * @param custNo
     * @param reader
     */
    public Receipt(String custNo, StorageReader reader) {
        if (custNo.length() <= 0 || reader == null) {
            throw new IllegalArgumentException("Please enter valid data");
        }
        sm.setStorageType(reader);
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
     * This method returns a fully formatted receipt output
     * @return 
     */
    //TODO move this to an output strategy
    public String outputReceipt() {
        return this.buildReceiptHeader()
                + this.buildItemLineString()
                + this.buildReceiptFooter();
    }
    
    /**
     * This method builds the receipt header which contains
     * the store object's formatted address, phone number
     * and customer greeting
     * @return 
     */
    private String buildReceiptHeader() {
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

    /**
     * This method builds the body of the receipt which is all the
     * items contained on the receipt
     * @return 
     */
    private String buildItemLineString() {
        String lineHeader = "";
        String item = "";
        item += "Product Description\t\t"
                + "Quantity\t\t\t"
                + "Product Base Price\t\t"
                + "Product Extended Price\t\t"
                + "Price after discount\n\n";

        /*Cycle through the LineItem array and
         *Add line item information to the body of the receipt
         */
        for (LineItem items : lineItems) {
            item += items.getCurrentLineProduct().getProductDesc() + "\t\t"
                    + items.getItemQty() + "\t\t\t\t\t"
                    + formatter.format(items.getCurrentLineProduct().getPrice()) + "\t\t\t\t"
                    + formatter.format(items.getCurrentLineProduct().getPrice() * items.getItemQty()) + "\t\t\t\t\t"
                    + formatter.format(items.returnDiscountedPrice() * items.getItemQty())
                    + "\n";
        }

        return item;
    }

    /**
     * This method builds the last part of the receipt which contains the
     * total of the sale and the amount saved with discounts
     * @return 
     */
    private String buildReceiptFooter() {
        double total = 0;
        double amountSaved = 0;

        for (LineItem items : lineItems) {
            total += items.returnDiscountedPrice() * items.getItemQty();
            amountSaved += (items.getCurrentLineProduct().getPrice() * items.getItemQty())
                    - items.returnDiscountedPrice() * items.getItemQty();

        }

        String footer = "";
        footer += "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t------------------------\n";
        footer += "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t" + "Total" + "\t\t" + formatter.format(total);
        footer += "\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t" + "Amount Saved" + "\t" + formatter.format(amountSaved);

        return footer;

    }
}

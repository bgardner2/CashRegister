package cashregister;

import java.text.DecimalFormat;
import java.text.NumberFormat;

public class ConsoleOutput implements OutputStrategy{

    NumberFormat formatter = NumberFormat.getCurrencyInstance();
    DecimalFormat receiptFormatNumber = new DecimalFormat("0000");
    
    @Override
    public void outputReceiptData(Receipt receipt) {
         System.out.println(this.buildReceiptHeader(receipt) 
                 + this.buildItemLineString(receipt)
                 + this.buildReceiptFooter(receipt));
    }

    @Override
    public String buildReceiptHeader(Receipt receipt) {
        String header = "";
        //Add store information
        header += receipt.getStore().getFormattedAddress() + "\n"
                + receipt.getStore().getPhoneNumber() + "\n"
                + "Transaction Number: #" + receiptFormatNumber.format(receipt.getReceiptNumber())
                + "\n\n";

        //Add customer greeting
        header += "Hello, "
                + receipt.getCustomer().getFirstName() + " " + receipt.getCustomer().getLastName()
                + ".\nThank you for shopping at " + receipt.getStore().getCompanyName()
                + "\n\n";

        return header;
    }

    @Override
    public String buildItemLineString(Receipt receipt) {
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
        for (LineItem items : receipt.getLineItems()) {
            item += items.getCurrentLineProduct().getProductDesc() + "\t\t"
                    + items.getItemQty() + "\t\t\t\t\t"
                    + formatter.format(items.getCurrentLineProduct().getPrice()) + "\t\t\t\t"
                    + formatter.format(items.getCurrentLineProduct().getPrice() * items.getItemQty()) + "\t\t\t\t\t"
                    + formatter.format(items.returnDiscountedPrice() * items.getItemQty())
                    + "\n";
        }

        return item;
    }

    @Override
    public String buildReceiptFooter(Receipt receipt) {
        double total = 0;
        double amountSaved = 0;

        for (LineItem items : receipt.getLineItems()) {
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

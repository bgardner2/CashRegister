package cashregister;


public class Driver {

    
    public static void main(String[] args) {
        
        CashRegister cr = new CashRegister();
        
        cr.startTransaction("SJ001");
        cr.addItem("BC001", 13);
        cr.addItem("BC001", 10);//Total baseball caps will be 24
        cr.addItem("BS001", 1); 
        cr.addItem("FP001", 2);
        cr.addItem("FP001", 3); //Total frying pans will be 5
        System.out.println(cr.printReceipt());
        
        System.out.println("\n\n");
        
        cr.startTransaction("BG001");
        cr.addItem("FP001", 2);
        cr.addItem("BS001", 1);
        System.out.println(cr.printReceipt());
    }

}

package cashregister;

import java.util.Scanner;

public class Customer {
    Scanner keyboard = new Scanner(System.in);
    
    private final String TEST_FIRST_NAME = "Ben";
    private final String TEST_LAST_NAME = "Gardner";
    private final String TEST_STREET1 = "1234 Main Street";
    private final String TEST_STREET2 = "Apt 5";
    private final String TEST_CITY = "Sussex";
    private final String TEST_STATE = "Wi";
    private final String TEST_ZIP = "53089";
    
    
    private String firstName;
    private String lastName;
    private String street1;
    private String street2;
    private String city;
    private String state;
    private String zip;
    
    //Create a new blank customer, and get all information for it from the keyboard
    public Customer(){
        this.firstName = TEST_FIRST_NAME;
        this.lastName = TEST_LAST_NAME;
        this.street1 = TEST_STREET1;
        this.street1 = TEST_STREET1;
        this. street2 = TEST_STREET2;
        this. city = TEST_CITY;
        this.state = TEST_STATE;
        this.zip = TEST_ZIP;
        
        
        /* This function can be used in the constructor to initialize a customer from keyboard
         * 
        this.initializeCustomer();
        * 
        */
    }
    
    public Customer(String firstName, String lastName, String street1, String street2, String city, String state, String zip) 
    {
        this.firstName = firstName;
        this.lastName = lastName;
        this.street1 = street1;
        this.street2 = street2;
        this.city = city;
        this.state = state;
        this.zip = zip;
    }
    
    private void initializeCustomer(){
        //Get input for first name
        do
        {
            System.out.print("Enter customer first name: ");
            firstName = keyboard.nextLine();
        }while(firstName.equals("") || firstName == null);
        
        //Get input for last name
        do
        {
            System.out.print("Enter customer last name: ");
            lastName = keyboard.nextLine();
        }while(lastName.equals("") || lastName == null);
        
        //Get input for street1
        do
        {
            System.out.print("Enter customer Street 1 address: ");
            street1 = keyboard.nextLine();
        }while(street1.equals("") || street1 == null);
        
        //Get input for street 2
        do
        {
            System.out.print("Enter customer street 2 address: ");
            street2 = keyboard.nextLine();
        }while(street2.equals("") || street2 == null);
        
        //Get input for city
        do
        {
            System.out.print("Enter customer city: ");
            city = keyboard.nextLine();
        }while(city.equals("") || city == null);
        
        //Get input for state
        do
        {
            System.out.print("Enter customer state: ");
            state = keyboard.nextLine();
        }while(state.equals("") || state == null);
        
        //Get input for zip
        do
        {
            System.out.print("Enter customer zip: ");
            zip = keyboard.nextLine();
        }while(zip.equals("") || zip == null);
            
    }
        
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getStreet1() {
        return street1;
    }

    public void setStreet1(String street1) {
        this.street1 = street1;
    }

    public String getStreet2() {
        return street2;
    }

    public void setStreet2(String street2) {
        this.street2 = street2;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getZip() {
        return zip;
    }

    public void setZip(String zip) {
        this.zip = zip;
    }
    
}
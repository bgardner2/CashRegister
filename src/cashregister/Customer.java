package cashregister;

public class Customer {

    private final String INVALID_INPUT = "You entered invalid input into the Customer object";
    private final String TEST_CUST_ID = "BG001";
    private final String TEST_FIRST_NAME = "Ben";
    private final String TEST_LAST_NAME = "Gardner";
    private final String TEST_STREET1 = "1234 Main Street";
    private final String TEST_STREET2 = "Apt 5";
    private final String TEST_CITY = "Sussex";
    private final String TEST_STATE = "Wi";
    private final String TEST_ZIP = "53089";
    private String customerID;
    private String firstName;
    private String lastName;
    private String street1;
    private String street2;
    private String city;
    private String state;
    private String zip;

    //Create a new blank customer, and get all information for it from the keyboard
    public Customer() {
        this.customerID = TEST_CUST_ID;
        this.firstName = TEST_FIRST_NAME;
        this.lastName = TEST_LAST_NAME;
        this.street1 = TEST_STREET1;
        this.street1 = TEST_STREET1;
        this.street2 = TEST_STREET2;
        this.city = TEST_CITY;
        this.state = TEST_STATE;
        this.zip = TEST_ZIP;



    }

    public Customer(String customerID, String firstName, String lastName, String street1, String street2, String city, String state, String zip) {

        if (customerID.length() == 0 || firstName.length() == 0
                || lastName.length() == 0 || street1.length() == 0
                 || city.length() == 0
                || state.length() == 0 || zip.length() == 0) {
            throw new IllegalArgumentException(INVALID_INPUT);
        }

        this.customerID = customerID;
        this.firstName = firstName;
        this.lastName = lastName;
        this.street1 = street1;
        this.street2 = street2;
        this.city = city;
        this.state = state;
        this.zip = zip;
    }

    public String getCustomerID() {
        return customerID;
    }

    public void setCustomerID(String customerID) {
        if (customerID.length() == 0) {
            throw new IllegalArgumentException(INVALID_INPUT);
        }
        this.customerID = customerID;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        if (firstName.length() == 0) {
            throw new IllegalArgumentException(INVALID_INPUT);
        }
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        if (lastName.length() == 0) {
            throw new IllegalArgumentException(INVALID_INPUT);
        }
        this.lastName = lastName;
    }

    public String getStreet1() {
        return street1;
    }

    public void setStreet1(String street1) {
        if (street1.length() == 0) {
            throw new IllegalArgumentException(INVALID_INPUT);
        }
        this.street1 = street1;
    }

    public String getStreet2() {
        return street2;
    }

    public void setStreet2(String street2) {
        if (street2.length() == 0) {
            throw new IllegalArgumentException(INVALID_INPUT);
        }
        this.street2 = street2;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        if (city.length() == 0) {
            throw new IllegalArgumentException(INVALID_INPUT);
        }
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        if (state.length() == 0) {
            throw new IllegalArgumentException(INVALID_INPUT);
        }
        this.state = state;
    }

    public String getZip() {
        return zip;
    }

    public void setZip(String zip) {
        if (zip.length() == 0) {
            throw new IllegalArgumentException(INVALID_INPUT);
        }
        this.zip = zip;
    }
}

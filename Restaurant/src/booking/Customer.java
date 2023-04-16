package booking;

import enums.Payement;
import enums.Preferences;

import java.util.Random;

/**
 * This class represents a Customer
 * @author Valentina Carpentiero, Alvise Zingales, Daniele Caramanica
 */

public class Customer {

    private String name;
    private String surname;
    private String telephoneNumber;
    private String email;
    private Preferences customerPreferences;
    private int customerId;
    private int groupSize;

    /**
     * Customer constructor that takes the following parameters:
     *
     * @param name                 Customer name
     * @param surname              Customer surname
     * @param telephoneNumber      Customer telephone number
     * @param email                Customer email
     * @param customerPreferences  Customer's food preferences
     * @param groupSize            Customer's booking group size
     *

     */


    public Customer(String name, String surname, String telephoneNumber, String email, Preferences customerPreferences, int groupSize) {
        this.name = name;
        this.surname = surname;
        this.telephoneNumber = telephoneNumber;
        this.email = email;
        this.customerPreferences = customerPreferences;
        this.groupSize = groupSize;
        this.customerId = createRandomCustomerId();
    }

    /**
     *The following methods are getters and setters for each variable
     */

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getTelephoneNumber() {
        return telephoneNumber;
    }
    public void setTelephoneNumber(String telephoneNumber) {
        this.telephoneNumber = telephoneNumber;
    }
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Preferences getCustomerPreferences() {
        return customerPreferences;
    }

    public void setCustomerPreferences(Preferences customerPreferences) {
        this.customerPreferences = customerPreferences;
    }

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public int getGroupSize() {
        return groupSize;
    }

    public void setGroupSize(int groupSize) {
        this.groupSize = groupSize;
    }

    /**
     * Generates and returns a random customer identifier.
     *
     * @return the random customer identifier
     */

    private int createRandomCustomerId(){
        Random random = new Random();
        return random.nextInt(0,Integer.MAX_VALUE);
    }

    /**
     * This is a method that prints all the customer's details
     */
    public void printCustomerDetails() {
        System.out.println ("Customer ID "+this.customerId+"- Name: " + this.name +" Surname: "+this.surname+ " Telephone-number: " + this.telephoneNumber +" Email: " + this.email + " Preferences: " + this.customerPreferences);
    }


}

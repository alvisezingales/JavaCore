package booking;

import restaurant.Restaurant;

import java.time.LocalDateTime;
import java.util.Random;

public class Booking {
    private int bookingId;
    private Customer customer;
    private Restaurant restaurant;
    private LocalDateTime bookingDateTime;
    private int groupSize;


    /**
     * Booking constructor that takes the following parameters:
     *
     * @param customer        the customer who made the booking
     * @param groupSize       the number of people in the group for this booking
     * @param bookingDateTime the date and the time of the booking
     */


    public Booking(Customer customer, LocalDateTime bookingDateTime, int groupSize){
        this.customer = customer;
        this.bookingDateTime = bookingDateTime;
        this.groupSize = groupSize;
        this.bookingId = createRandomBookingId();
    }

    /**
     * The following methods are getters and setters for each variable
     */


    public int getBookingId() {
        return bookingId;
    }

    public Restaurant getRestaurant() {
        return restaurant;
    }

    public void setRestaurant(Restaurant restaurant) {
        this.restaurant = restaurant;
    }

    public LocalDateTime getBookingDateTime() {
        return bookingDateTime;
    }
    public void setBookingDateTime(LocalDateTime bookingDateTime) {
        this.bookingDateTime = bookingDateTime;
    }
    public void setBookingId(int bookingId) {
        this.bookingId = bookingId;
    }

    public int getGroupSize() {
        return groupSize;
    }

    public void setGroupSize(int groupSize) {
        this.groupSize = groupSize;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    /**
     * Generates and returns a random booking identifier.
     *
     * @return the random booking identifier
     */

    private int createRandomBookingId() {
        Random random = new Random();
        return random.nextInt(0, 500);
    }

    /**
     * This is a method that prints all the booking's details
     */

    public void printBookingDetails(){
        System.out.println("\n###BOOKING NUMBER: " + this.getBookingId() + "###" +
                "\nCustomer name: " + customer.getName() + " " + customer.getSurname() +
                "\nCustomer ID: " + customer.getCustomerId() +
                "\nTotal People: " + customer.getGroupSize() +
                "\nBooking Date and Time: " + bookingDateTime);
    }
}

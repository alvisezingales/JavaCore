package restaurant;

import booking.Booking;
import booking.Customer;
import enums.TablePosition;
import enums.TableService;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

/**
 * This class represents a Restaurant
 *
 * @author Valentina Carpentiero, Alvise Zingales, Daniele Caramanica
 */
public class Restaurant {

    private static int tableId = 0;
    private String restaurantName;
    private String address;
    private boolean isOpen;
    private int seatingCapacity;
    private double averagePrice;
    private String recommendedDish;
    private TableService tableService;
    private String services;
    private boolean hasHomeDelivery;
    private boolean hasAllYouCanEat;
    private List<Menu> menu;
    private List<Customer> customerList = new ArrayList<>();
    private List<Booking> bookingList = new ArrayList<>();
    private List<Table> tableList = new ArrayList<>();

    public Restaurant(String restaurantName, String address, int seatingCapacity, double averagePrice, String recommendedDish, String services, boolean hasAllYouCanEat, boolean isOpen) {
        this.restaurantName = restaurantName;
        this.address = address;
        this.seatingCapacity = seatingCapacity;
        this.averagePrice = averagePrice;
        this.recommendedDish = recommendedDish;
        this.services = services;
        this.hasAllYouCanEat = hasAllYouCanEat;
        this.isOpen = isOpen;
    }

    public Restaurant(String restaurantName, String address) {
        this.restaurantName = restaurantName;
        this.address = address;
    }



    /**
     * Restaurant constructor that takes the following parameters:
     *
     * @param restaurantName  Restaurant name
     * @param address         Restaurant address
     * @param recommendedDish Restaurant chef's choice
     * @param seatingCapacity Restaurant seating capacity
     * @param tableService    Restaurant plates service
     * @param averagePrice    Restaurant average bill's cost
     * @param services        Restaurant's services
     * @param hasHomeDelivery Boolean about restaurant's delivery
     * @param hasAllYouCanEat Boolean about restaurant all-you-can-eat form
     */



    public Restaurant(String restaurantName, String address, String recommendedDish, int seatingCapacity, TableService tableService, double averagePrice, String services, boolean hasHomeDelivery, boolean hasAllYouCanEat) {
        this.restaurantName = restaurantName;
        this.address = address;
        this.isOpen = true;
        this.averagePrice = averagePrice;
        this.recommendedDish = recommendedDish;
        this.seatingCapacity = seatingCapacity;
        this.tableService = tableService;
        this.services = services;
        this.hasHomeDelivery = hasHomeDelivery;
        this.hasAllYouCanEat = hasAllYouCanEat;
    }

    /**
     * The following methods are getters and setters for each instance variables
     */

    public boolean isOpen() {
        return isOpen;
    }

    public void setOpen(boolean open) {
        isOpen = open;
    }

    public double getAveragePrice() {
        return averagePrice;
    }

    public void setAveragePrice(double averagePrice) {
        this.averagePrice = averagePrice;
    }

    public String getRecommendedDish() {
        return recommendedDish;
    }

    public void setRecommendedDish(String recommendedDish) {
        this.recommendedDish = recommendedDish;
    }

    public TableService getTableService() {
        return tableService;
    }

    public void setTableService(TableService tableService) {
        this.tableService = tableService;
    }

    public String getServices() {
        return services;
    }

    public void setServices(String services) {
        this.services = services;
    }

    public boolean getHasHomeDelivery() {
        return hasHomeDelivery;
    }

    public void setHasHomeDelivery(boolean hasHomeDelivery) {
        this.hasHomeDelivery = hasHomeDelivery;
    }

    public boolean getHasAllYouCanEat() {
        return hasAllYouCanEat;
    }

    public void setHasAllYouCanEat(boolean hasAllYouCanEat) {
        this.hasAllYouCanEat = hasAllYouCanEat;
    }

    public List<Menu> getMenu() {
        return menu;
    }

    public void setMenu(List<Menu> menu) {
        this.menu = menu;
    }

    public String getRestaurantName() {
        return restaurantName;
    }

    public void setRestaurantName(String restaurantName) {
        this.restaurantName = restaurantName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public boolean getIsOpen() {
        return isOpen;
    }

    public void setIsOpen(boolean open) {
        isOpen = open;
    }

    public int getSeatingCapacity() {
        return seatingCapacity;
    }

    public void setSeatingCapacity(int seatingCapacity) {
        this.seatingCapacity = seatingCapacity;
    }

    public void setBookingList(List<Booking> bookingList) {
        this.bookingList = bookingList;
    }

    /**
     * This is a method that prints the details of the restaurant
     */

    public void printRestaurantDetails() {
        System.out.println(this.restaurantName
                + "\nAddress: " + this.address
                + "\nAverage Price: " + this.averagePrice
                + "\nChef's choice: " + this.recommendedDish
                + "\nTable service: " + this.tableService.getDescription()
                + "\nServices: " + this.services
        );
        System.out.println("All you can eat: " + (hasAllYouCanEat ? "Yes" : "No"));
        System.out.println("Home delivery: " + (hasHomeDelivery ? "Yes" : "No"));
    }

    /**
     * This method prints each Menu from List<Menu> in relations to the preferences
     *
     * @param customer provides the customer's preferences to compare with the menu type
     */

    public void printMenu(Customer customer) {
        for (Menu singleMenu : menu) {
            if (singleMenu.getMenuPreferences() == customer.getCustomerPreferences()) {
                singleMenu.printMenu();
            }
        }
    }

    /**
     * This method books a table for a customer with a specific date and time.
     *
     * @param customer The customer who is booking the table.
     * @param bookingDateTime date and time of the booking
     * @param tablePosition position of the table to book
     **/

    public void bookTable(Customer customer, LocalDateTime bookingDateTime, TablePosition tablePosition) {
        if (seatingCapacity == 0) {
            System.out.println("We're sorry Mr./Ms./Mrs./Miss " + customer.getSurname() + ", our restaurant is full right now. No tables available!");
        } else if (customer.getGroupSize() <= seatingCapacity) {
            Table table = new Table(tableId, customer.getGroupSize(), tablePosition);
            tableList.add(table);
            customerList.add(customer);
            tableId++;

            Booking booking = new Booking(customer, bookingDateTime, customer.getGroupSize());
            bookingList.add(booking);

            System.out.println("Booking for table "+tableId+" successfully done. ");
            booking.printBookingDetails();

            seatingCapacity -= customer.getGroupSize();

        } else {
            System.out.println("We're sorry Mr./Ms./Mrs./Miss " + customer.getSurname() + " you booked for " + customer.getGroupSize()
                    + " people, but there's room for just " + seatingCapacity + " people, right now.");
        }
    }

    /**
     * This method calculates and prints the bill for a customer.
     * @param customer The customer for whom the bill is being calculated.
     * @param total    The total cost of the bill.
     **/

    public void bill(Customer customer, double total) {
        if (total > 0) {
            System.out.println("Paga va, sono: " + total + " euro ");
            customerList.remove(customer);
            seatingCapacity += customer.getGroupSize();
        } else {
            System.out.println("This customer isn't paying");
        }
    }

    /**
     * This method deletes a booking made by a customer.
     *
     * @param customer The customer whose booking is being deleted.
     **/

    public void deleteBooking(Customer customer) {
        for (int i = 0; i < bookingList.size(); i++) {
            Booking bookingToDelete = bookingList.get(i);
            if (bookingToDelete.getCustomer().getCustomerId() == customer.getCustomerId()) {
                bookingList.remove(i);
                seatingCapacity += customer.getGroupSize();
                System.out.println("Booking nr " + bookingToDelete.getBookingId() + " deleted.");
            }
        }
    }
    /**
     * This is a method that prints all the bookings that are on the list.
     */

    public void printBookingList(){
        System.out.println("BOOKING LIST: ");
        for (Booking booking:bookingList) {
            booking.printBookingDetails();
        }
    }
}





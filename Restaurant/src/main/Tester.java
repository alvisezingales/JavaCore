package main;

//import booking.BookingManager;
import booking.Customer;
import dishes.*;
import enums.*;
import restaurant.Menu;
import restaurant.Restaurant;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * This is the Tester class with a main method
 * @author Valentina Carpentiero, Alvise Zingales, Daniele Caramanica
 */
public class Tester {

    /**
     * Main method from where the Java program starts.
     * @param args for all the parameters from command line
     */
    public static void main(String[] args) {

        /**
         *  DISH LISTS CREATION
         */

        List<Dish> dishList1 = new ArrayList<>();
        dishList1.add(new FirstCourse("First Course", "Spaghetti allo scoglio", Preferences.CARNIVOROUS,DietaryOptions.LOCALLY_PRODUCED, 12.55, "Spaghetti con vongole, cozze, calamari",true));
        dishList1.add(new SecondCourse("Second Course", "Orata al forno con patate", Preferences.CARNIVOROUS,DietaryOptions.LOCALLY_PRODUCED, 17.00, "Orata","patate, rosmarino, aglio"));
        dishList1.add(new Dessert("Dessert", "Torta al cioccolato", Preferences.MIXED, DietaryOptions.LOCALLY_PRODUCED, 6.50,"panna, zucchero",true));
        dishList1.add(new Drink("Drink", "Vino Lapilli", Preferences.MIXED, DietaryOptions.LOCALLY_PRODUCED, "Base di chardonnay vinificato insieme ad altri vitigni della zona che conferiscono sapidità.", 16.00, 12.5,true));

        List<Dish> dishList2 = new ArrayList<>();
        dishList2.add(new FirstCourse("First Course", "Orecchiette alle cime di rapa", Preferences.VEGETARIAN, DietaryOptions.LOCALLY_PRODUCED, 10.50, "Orecchiette, Aglio, Cime di Rapa,Peperone Crusco",true));
        dishList2.add(new SecondCourse("Second Course", "Burger di Soia", Preferences.VEGETARIAN, DietaryOptions.LACTOSE_FREE, 7.00, "Burger Vegetale alla Soia","Erba"));
        dishList2.add(new Dessert("Dessert", "Cheesecake Frutti di Bosco", Preferences.MIXED, DietaryOptions.PEANUT_FREE,6.50,"Frutti di bosco",false));
        dishList2.add(new Drink("Drink", "Coca Zero", Preferences.MIXED,DietaryOptions.LOCALLY_PRODUCED, "Coca cola senza zuccheri", 6.00, 0,false));

        List<Dish> dishList3 = new ArrayList<>();
        dishList3.add(new FirstCourse("First Course", "Paccheri zucca e mandorle ", Preferences.VEGAN, DietaryOptions.LACTOSE_FREE, 10.50, "Paccheri , zucca, mandorle",true));
        dishList3.add(new SecondCourse("Second Course", "Sushi avocado", Preferences.VEGAN, DietaryOptions.GLUTEN_FREE,7.50, "Riso, avocado, Spalmabile alla Soia","Alghe"));
        dishList3.add(new Dessert("Dessert", "Vegan Souffle", Preferences.VEGAN,DietaryOptions.LACTOSE_FREE, 6.20,"Zucchero",false));
        dishList3.add(new Drink("Drink", "Coca 0", Preferences.MIXED, DietaryOptions.LOCALLY_PRODUCED, "Coca cola senza zuccheri", 6.00, 0,false));

        /**
         *  MENUS CREATION
         */

        Menu menu1 = new Menu(Preferences.CARNIVOROUS, TypeOfMenu.DAILY, BasedOn.FISH,dishList1);
        Menu menu2 = new Menu(Preferences.VEGETARIAN, TypeOfMenu.SPECIAL,BasedOn.VEGETABLES,dishList2);
        Menu menu3 = new Menu(Preferences.VEGAN, TypeOfMenu.TASTING, BasedOn.VEGETABLES,dishList3);

        List<Menu> menus = new ArrayList<>();
        menus.add(menu1);
        menus.add(menu2);
        menus.add(menu3);

        /**
         *  RESTAURANTS CREATION
         */

        Restaurant restaurant1 = new Restaurant("Ristorante Gruppo 4", "Java 8", menu3.getDishList().get(1).getDishName(), 50,TableService.A_LA_CARTE,32,"Credit Card, WiFi, Air-Conditioning, Wheelchair Accessible, Free Parking",true, false);
        restaurant1.printRestaurantDetails();

        /**
         *  CUSTOMERS CREATION
         */

        Customer customer1= new Customer("Lebron", "James","345545741","TacoThursday66@gmail.com",Preferences.VEGETARIAN, 13);
        Customer customer2= new Customer("Roger","Federer","334525458", "backmaster@gmail.nadal",Preferences.CARNIVOROUS, 8);
        Customer customer3= new Customer("Ciro","Mertens","332253545","ciro@hotmail.com",Preferences.VEGAN, 2);


        restaurant1.printMenu(customer1);



        /**
         *  BOOKINGS CREATION
         */

        restaurant1.bookTable(customer1, LocalDateTime.of(2023,1,25,20,30),TablePosition.INDOOR);
        System.out.println();
        restaurant1.bill(customer1,100);
        System.out.println();
        restaurant1.bookTable(customer2, LocalDateTime.of(2023,1,25,21,0),TablePosition.INDOOR);
        System.out.println();
        restaurant1.bookTable(customer3, LocalDateTime.of(2023,1,26,20,30),TablePosition.OUTDOOR);
        System.out.println();
        restaurant1.deleteBooking(customer2);
        System.out.println();
        restaurant1.printBookingList();

    }
}

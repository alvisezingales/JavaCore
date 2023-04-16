package database;

import enums.TableService;
import restaurant.Restaurant;

import java.sql.SQLException;

public class DBMain {
    public static void main(String[] args) throws SQLException {

        RestaurantDBTable restaurantDBTable = new RestaurantDBTable();
        Restaurant restaurantGruppo4 = new Restaurant("xx", "xy", 4, 2.0, "sf", "ser", false, true);
        //Restaurant restaurantGruppo4 = new Restaurant("ristorante_scimmia", "via_dei_cretini", 3, 4.0, "cicci_alla_fragola", "wi_fi", false, true);
        //Restaurant restaurantGruppo4 = new Restaurant("ristorante_scimmia", "via_dei_cretini");

        restaurantDBTable.createRestaurantDB();
        restaurantDBTable.insertRestaurantDB(restaurantGruppo4);
    }
}

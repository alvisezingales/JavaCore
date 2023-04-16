package database;

import restaurant.Restaurant;

import java.sql.*;

public class RestaurantDBTable {


    public void createRestaurantDB() throws SQLException{

        try (Connection conn = DriverManager.getConnection(DBUtilities.getUrl(), DBUtilities.getUser(), DBUtilities.getPassword())){
             //Statement statement = conn.createStatement();
             PreparedStatement psCreate = conn.prepareStatement("CREATE TABLE IF NOT EXISTS `restaurantgruppo4`.`restaurant` ("
                     + "`id_restaurant` INT NOT NULL AUTO_INCREMENT, "
                     + "`restaurant_name` VARCHAR(64) NOT NULL, "
                     + "`restaurant_address` VARCHAR(64) NOT NULL, "
                     + "`seating_capacity` INT NOT NULL, "
                     + "`restaurant_avg_price` DECIMAL NOT NULL, "
                     + "`restaurant_recomm_dish` VARCHAR(64) NOT NULL, "
                     + "`restaurant_services` VARCHAR(64) NOT NULL, "
                     + "`has_home_delivery` TINYINT NOT NULL, "
                     + "`has_all_you_can_eat` TINYINT NOT NULL, "
                     + "`is_open` TINYINT NOT NULL, "
                     + "PRIMARY KEY (`id_restaurant`))");

             psCreate.execute();

             psCreate.close();

             //already closed for the try with resources
             //conn.close();

        }catch(SQLException e){
        System.out.println(e.getMessage());
        }
    }

    public void describeRestaurantDB() throws SQLException{

        try (Connection conn = DriverManager.getConnection(DBUtilities.getUrl(), DBUtilities.getUser(), DBUtilities.getPassword())){

             Statement statement = conn.createStatement();

             PreparedStatement ps = conn.prepareStatement("SELECT * FROM `restaurantgruppo4`.`restaurant`");

            ps.executeQuery();

            ps.close();


        }catch(SQLException e){
            System.out.println(e.getMessage());
        }
    }

    public void insertRestaurantDB(Restaurant restaurant) throws SQLException {

        try(Connection conn = DriverManager.getConnection(DBUtilities.getUrl(), DBUtilities.getUser(), DBUtilities.getPassword())){
            /*
            PreparedStatement psInsert = conn.prepareStatement("INSERT INTO `restaurantgruppo4`.`restaurant` "
                    + "(restaurant_name, restaurant_address) "
                    + "VALUES ("+ restaurant.getRestaurantName() + ", " + restaurant.getAddress() + ")");

             */

            PreparedStatement psInsert = conn.prepareStatement("INSERT INTO `restaurantgruppo4`.`restaurant` "
                    + "(restaurant_name, restaurant_address, seating_capacity, restaurant_avg_price, "
                    + "restaurant_recomm_dish, restaurant_services, has_all_you_can_eat, is_open) "
                    + "VALUES ("+ restaurant.getRestaurantName() + ", " + restaurant.getAddress() + ", "
                    + restaurant.getSeatingCapacity() + ", " + restaurant.getAveragePrice() + ", "
                    + restaurant.getRecommendedDish() + ", " + restaurant.getServices() + ", "
                    + restaurant.getHasAllYouCanEat() + ", " + restaurant.getIsOpen() + ")");


            psInsert.executeUpdate();

            psInsert.close();

        }catch (SQLException e){
            System.out.println(e.getMessage());
        }


    }
}

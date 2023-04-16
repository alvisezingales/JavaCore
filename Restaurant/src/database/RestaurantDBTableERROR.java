/*
package database;

import enums.TableService;

import java.sql.*;

public class RestaurantDBTableERROR {

    static final String DB_NAME = "restaurantgruppo4";
    static final String URL = "jdbc:mysql://localhost:3306/" + DB_NAME;
    static final String USER = "root";
    static final String PASSWORD = "root";


    public void createRestaurantDB() {

        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD){
             Statement statement = conn.createStatement();

             PreparedStatement preparedStatement = conn.prepareStatement("INSERT INTO `restaurantgruppo4`.`restaurant` "
                     + "(id_restaurant, restaurant_name, restaurant_address, seating_capacity, restaurant_avg_price, "
                     + "restaurant_recomm_dish, restaurant_services, has_home_delivery, has_all_you_can_eat, is_open, tableservice) "
                     + "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)")) {

            statement.executeQuery("CREATE TABLE IF NOT EXISTS `restaurantgruppo4`.`restaurant` ("
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
                    + "`tableservice` ENUM('buffet', 'a_la_carte') NOT NULL, "
                    + "PRIMARY KEY (`id_restaurant`))");

            insertRestaurantDB(preparedStatement, 1, "Ristorante Gruppo 4", "Java 8",
                    50,32.0, "Paccheri zucca e mandorle", "Credit Card, WiFi, Air-Conditioning, Wheelchair Accessible, Free Parking",
                    true, false, true, TableService.A_LA_CARTE);

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void insertRestaurantDB(PreparedStatement preparedStatement, int id_restaurant, String restaurant_name,
                                          String restaurant_address, int seating_capacity, double restaurant_avg_price,
                                          String restaurant_recomm_dish, String restaurant_services, boolean has_home_delivery,
                                          boolean has_all_you_can_eat, boolean is_open, TableService tableservice) throws SQLException {

        preparedStatement.setInt(1, id_restaurant);
        preparedStatement.setString(2, restaurant_name);
        preparedStatement.setString(3, restaurant_address);
        preparedStatement.setInt(4, seating_capacity);
        preparedStatement.setDouble(5, restaurant_avg_price);
        preparedStatement.setString(6, restaurant_recomm_dish);
        preparedStatement.setString(7, restaurant_services);
        preparedStatement.setBoolean(8, has_home_delivery);
        preparedStatement.setBoolean(9, has_all_you_can_eat);
        preparedStatement.setBoolean(10, is_open);
        preparedStatement.setString(11, tableservice.name());
        preparedStatement.executeUpdate();
    }

    /*
    //Preso dal gruppo di Francesco Sepe, lì c'era un'interfaccia
    public void describeTable(Connection connection) throws SQLException {
        ResultSet rs = null;
        ResultSetMetaData rsDesc = null;
        try(Statement describeTable = connection.createStatement();) {
            rs =describeTable.executeQuery("SELECT * FROM " + tableName);
            rsDesc = rs.getMetaData();
            System.out.printf("Client restaurant table has %d column\n",rsDesc.getColumnCount());
            System.out.println("Table description");
            for (int i = 1; i < rsDesc.getColumnCount(); i++) {
                System.out.println("Column number " + i + " is " + rsDesc.getColumnName(i) + " and the type of column is " + rsDesc.getColumnTypeName(i));
            }
        }
        rs.close();
    }

     */
/*
}

*/

/*
package database;

import enums.BasedOn;
import enums.Preferences;
import enums.TableService;
import enums.TypeOfMenu;
import restaurant.Menu;

import java.sql.*;

public class MenuDBTable {

    static final String DB_NAME = "restaurantgruppo4";
    static final String URL = "jdbc:mysql://localhost:3306/" + DB_NAME;
    static final String USER = "root";
    static final String PASSWORD = "root";

    public void createMenuDB() {

        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
             Statement statement = conn.createStatement();
             PreparedStatement preparedStatement = conn.prepareStatement("INSERT INTO `restaurantgruppo4`.`menu` "
                     + "(id_menu, menu_preferences, menu_based_on, menu_type_of_menu, restaurant_id_restaurant) "
                     + "VALUES (?, ?, ?, ?, ?)")) {

            statement.executeQuery("CREATE TABLE IF NOT EXISTS `restaurantgruppo4`.`menu` ("
                    + "`id_menu` INT NOT NULL AUTO_INCREMENT, "
                    + "`menu_preferences` ENUM('carnivorous','vegetarian', 'vegan', 'mixed') NOT NULL, "
                    + "`menu_based_on` ENUM('fish', 'meat', 'vegetable') NOT NULL, "
                    + "`menu_type_of_menu` ENUM('special', 'children', 'tasting', 'daily') NOT NULL, "
                    + "`restaurant_id_restaurant` INT NOT NULL, "
                    + "PRIMARY KEY (`id_menu`))"
                    + "INDEX `fk_menu_restaurant_idx` (`restaurant_id_restaurant` ASC) VISIBLE,"
                    + "CONSTRAINT `fk_menu_restaurant`"
                    + "FOREIGN KEY (`restaurant_id_restaurant`)"
                    + "REFERENCES `restaurantgruppo4`.`restaurant` (`id_restaurant`)"
                    + "ON DELETE NO ACTION"
                    + "ON UPDATE NO ACTION)"
                    + "ENGINE = InnoDB");


            //TODO che devo fare con la foreign key restaurant_id_restaurant? Devo tenerne conto?
            //TODO e come la aggiungo se devo?
            insertMenuDB(preparedStatement, 1, Preferences.CARNIVOROUS, TypeOfMenu.DAILY, BasedOn.FISH);

            insertMenuDB(preparedStatement, 2, Preferences.VEGETARIAN, TypeOfMenu.SPECIAL,BasedOn.VEGETABLES);

            insertMenuDB(preparedStatement, 3, Preferences.VEGAN, TypeOfMenu.TASTING, BasedOn.VEGETABLES);


        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    //TODO l'ultimo parametro è dubbio... è la foreign key, questo parametro deve essere di tipo int o di tipo Restaurant o RestaurantDBTable?
    public static void insertMenuDB(PreparedStatement preparedStatement, int id_menu, Preferences preferences,
                                    BasedOn basedOn, TypeOfMenu typeOfMenu, int restaurant_id_restaurant ) throws SQLException {

        preparedStatement.setInt(1, id_menu);
        preparedStatement.setString(2, preferences.name());
        preparedStatement.setString(3, basedOn.name());
        preparedStatement.setString(4, typeOfMenu.name());
        //TODO dubbio, questo parametro deve essere di tipo int o di tipo Restaurant o RestaurantDBTable?
        preparedStatement.setInt(5, restaurant_id_restaurant );
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

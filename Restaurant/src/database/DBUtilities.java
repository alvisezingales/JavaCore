package database;

public class DBUtilities {
    private static final String db_name = "restaurantgruppo4";
    private static final String url = "jdbc:mysql://localhost:3306/" + db_name;
    private static final String user = "root";
    private static final String password = "root";

    //TODO cambia i nomi delle variabili in minuscolo

    public static String getDb_name() {
        return db_name;
    }

    public static String getUrl() {
        return url;
    }

    public static String getUser() {
        return user;
    }

    public static String getPassword() {
        return password;
    }
}

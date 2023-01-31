import java.sql.*;

public class DB_functions {

    public Connection connect_to_db(String dbname, String username, String password) {
        Connection conn = null;
        try {
            Class.forName("org.postgresql.Driver");
            conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/" + dbname, username, password);
            if (conn != null) {
                System.out.println("Connection Established!");
            } else {
                System.out.println("Connection Failed.");
            }

        } catch (Exception e) {
            System.out.println(e);
        }

        return conn;
    }
}
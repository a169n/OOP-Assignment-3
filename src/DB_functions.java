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
    public void createTable(Connection conn, String table_name){
        Statement statement;
        try{
            String query = "create table "+ table_name+ "(ID serial, username varchar(30), password varchar(30), primary key(ID))";
            statement = conn.createStatement();
            statement.executeUpdate(query);
            System.out.println("Table created");
        } catch (Exception e){
            System.out.println(e);
        }
    }
}
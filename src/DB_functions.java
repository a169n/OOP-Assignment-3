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

    public void createTable (Connection conn, String table_name) {
        Statement statement;
        try {
            String query = "create table " + table_name + "(id SERIAL, username varchar(20), password varchar(20), primary key(id));";
            statement = conn.createStatement();
            statement.executeUpdate(query);
            System.out.println("Table created.");
        } catch (Exception e){
            System.out.println(e);
        }
    }

    public void insertRow(Connection conn, String table_name, String name, String password){
        Statement statement;
        try{
            String query = String.format("insert into %s(username,password) values('%s', '%s');", table_name, name, password);
            statement = conn.createStatement();
            statement.executeUpdate(query);
            System.out.println("Information is successfully inserted.");
        }catch (Exception e) {
            System.out.println(e);
        }
    }

    public void read_data(Connection conn, String table_name){
        Statement statement;
        ResultSet rs = null;
        try{
            String query = String.format("select * from %s", table_name);
            statement = conn.createStatement();
            rs = statement.executeQuery(query);

            while(rs.next()){
                System.out.println(rs.getString("id") + " "+
                        rs.getString("username") + " "+
                        rs.getString("password") + " ");
            }
        } catch (Exception e){
            System.out.println(e);
        }
    }

    public void update_username (Connection conn, String table_name, String old_username, String new_username){
        Statement statement;
        try{
            String query = String.format("update %s set username = '%s' where username = '%s'", table_name, new_username, old_username);
            statement = conn.createStatement();
            statement.executeUpdate(query);
            System.out.println("Username updated.");
        } catch (Exception e){
            System.out.println(e);
        }
    }


    public void search_by_name(Connection conn, String table_name, String username){
        Statement statement;
        ResultSet rs = null;
        try{
            String query = String.format("select * from %s where username = '%s'", table_name, username);
            statement = conn.createStatement();
            rs = statement.executeQuery(query);
            while (rs.next()){
                System.out.print(rs.getString("id") + " ");
                System.out.print(rs.getString("username") + " ");
                System.out.println(rs.getString("password"));
            }
        } catch (Exception e){
            System.out.println(e);
        }
    }

    public void search_by_id(Connection conn, String table_name, int id){
        Statement statement;
        ResultSet rs = null;
        try{
            String query = String.format("select * from %s where id = %s", table_name, id);
            statement = conn.createStatement();
            rs = statement.executeQuery(query);
            while (rs.next()){
                System.out.print(rs.getString("id") + " ");
                System.out.print(rs.getString("username") + " ");
                System.out.println(rs.getString("password"));
            }
        } catch (Exception e){
            System.out.println(e);
        }
    }

    public void delete_row_by_name(Connection conn, String table_name, String username){
        Statement statement;
        try{
            String query = String.format("delete from %s where username = '%s'", table_name, username);
            statement = conn.createStatement();
            statement.executeUpdate(query);
            System.out.println("Data deleted");
        } catch (Exception e){
            System.out.println(e);
        }
    }
    public void delete_row_by_id(Connection conn, String table_name, int id){
        Statement statement;
        try{
            String query = String.format("delete from %s where id = %s", table_name, id);
            statement = conn.createStatement();
            statement.executeUpdate(query);
            System.out.println("Data deleted");
        } catch (Exception e){
            System.out.println(e);
        }
    }

    public void delete_table(Connection conn, String table_name){
        Statement statement;
        try{
            String query = String.format("drop table %s", table_name);
            statement = conn.createStatement();
            statement.executeUpdate(query);
            System.out.println("Table deleted");
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
import java.sql.*;

public class DB_functions {
    //Enter your connection info here
    Connection conn = connect_to_db("postgres", "postgres", "d05");
    //Enter table name
    String table_name = "st";
    Statement statement= null;

    {
        try {
            statement = conn.createStatement();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    ResultSet rs = null;

    public Connection connect_to_db(String dbname, String username, String password) {
        try {
            Class.forName("org.postgresql.Driver");
            conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/" + dbname, "postgres", "d05");
            if (conn == null) {
                System.out.println("Connection Failed!");
            }

        } catch (Exception e) {
            System.out.println(e);
        }

        return conn;
    }

    public void createTable () {
        try {
            String query = "create table " + table_name + "(id SERIAL, username varchar(20), password varchar(20), primary key(id));";
            statement.executeUpdate(query);
            System.out.println("Table created.");
        } catch (Exception e){
            System.out.println(e);
        }
    }

    public void insertUser(String username, String password){
        try{
            String query = String.format("insert into %s(username,password) values('%s', '%s');", table_name, username, password);
            statement.executeUpdate(query);
            System.out.println("Information is successfully inserted.");
        }catch (Exception e) {
            System.out.println(e);
        }
    }

    public void read_data(){
        try{
            String query = String.format("select * from %s", table_name);
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

    public void update_username (String old_username, String new_username){
        try{
            String query = String.format("update %s set username = '%s' where username = '%s'", table_name, new_username, old_username);
            statement.executeUpdate(query);
            System.out.println("Username updated.");
        } catch (Exception e){
            System.out.println(e);
        }
    }


    public void search_by_name(String username){
        try{
            String query = String.format("select * from %s where username = '%s'", table_name, username);
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

    public void search_by_id(int id){
        try{
            String query = String.format("select * from %s where id = %s", table_name, id);
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

    public void delete_row_by_name(String username){
        try{
            String query = String.format("delete from %s where username = '%s'", table_name, username);
            statement.executeUpdate(query);
            System.out.println("Data deleted");
        } catch (Exception e){
            System.out.println(e);
        }
    }
    public void delete_row_by_id(int id){
        try{
            String query = String.format("delete from %s where id = %s", table_name, id);
            statement.executeUpdate(query);
            System.out.println("Data deleted");
        } catch (Exception e){
            System.out.println(e);
        }
    }

    public void delete_table(){
        try{
            String query = String.format("drop table %s", table_name);
            statement.executeUpdate(query);
            System.out.println("Table deleted");
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
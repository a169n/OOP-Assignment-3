import java.sql.*;

public class DB_methods {
    //Enter your connection info here
    Connection conn = connect_to_db("postgres", "postgres", "1234");
    //Enter table name
    String table_name = "users";
    Statement statement= null;
    public static String username;

    public String getUsername() {
        return username;
    }

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
            conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/" + dbname, username, password);
            if (conn == null) {
                System.out.println("Connection Failed!");
            }

        } catch (Exception e) {
            System.out.println(e);
        }

        return conn;
    }

    public void createTableUsers () {
        try {
            String query = "create table " + table_name + "(id SERIAL, username varchar(20), password varchar(20), primary key(id));";
            statement.executeUpdate(query);
            System.out.println("Users table created.");
        } catch (Exception e){
            System.out.println(e);
        }
    }
    public void createTableTasks () {
        try {
            String query = "create table " + "tasks" + "(id SERIAL,user_id int, task_name varchar(20), primary key(id));";
            statement.executeUpdate(query);
            System.out.println("Tasks table created.");
        } catch (Exception e){
            System.out.println(e);
        }
    }
    public void insertUser(String username, String password){
        try{
            String query = String.format("insert into %s(username,password) values('%s', '%s');", table_name, username, password);
            statement.executeUpdate(query);
            System.out.println("New user added.");
        }catch (Exception e) {
            System.out.println(e);
        }
    }
    public void insertTask(String task,int user_id){
        try{
            String query = String.format("insert into %s(task_name,user_id) values('%s','%s');", "tasks", task,user_id);
            statement.executeUpdate(query);
            System.out.println("New task added.");
        }catch (Exception e) {
            System.out.println(e);
        }
    }
    public boolean checkName(String username){
        try{
            String query = String.format("select * from %s where username = '%s'", table_name, username);
            rs = statement.executeQuery(query);
            while (rs.next()){
                return true;
            }
        } catch (Exception e){
            System.out.println(e);
        }
        return false;
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
    public boolean checkUser(String username,String password){
        try{
            String query = String.format("SELECT * FROM %s WHERE username = '%s' AND password = '%s'", table_name, username, password);
            ResultSet result = statement.executeQuery(query);
            return result.next();
        } catch (Exception e){
            System.out.println(e);
        }
        return false;
    }
    public boolean checkPassword(String password){
        try{
            String query = String.format("SELECT * FROM %s WHERE password = '%s'", table_name, password);
            ResultSet result = statement.executeQuery(query);
            return result.next();
        } catch (Exception e){
            System.out.println(e);
        }
        return false;
    }

    public int getID(String username){
        try{
            String query = String.format("select id from %s where username = '%s'", table_name, username);
            ResultSet result = statement.executeQuery(query);
            if (result.next()) {
                int id = result.getInt("id");
                return id;
            } else {
                return 0;
            }
        } catch (Exception e){
            System.out.println("Error executing query: " + e);
        }
        return 0;
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
    public void output_tasks(int user_id){
        try{
            String query = String.format("select * from %s where user_id='%s'" , "tasks",user_id);
            rs = statement.executeQuery(query);
            int task_id = 1;
            while(rs.next()){
                System.out.println(task_id + ". " + rs.getString("task_name"));
                task_id++;
            }
        } catch (Exception e){
            System.out.println(e);
        }
    }


    public void update_username (String old_username, String new_username){
        try{
            String query = String.format("update %s set username = '%s' where username = '%s'", table_name, new_username, old_username);
            statement.executeUpdate(query);
            System.out.println("Username is successfully updated.");
        } catch (Exception e){
            System.out.println(e);
        }
    }
    public void update_the_task (int task_ID, String new_task_name){
        try{
            String query = String.format("update %s set task_name = '%s' where id = '%s'", "tasks", new_task_name, task_ID);
            statement.executeUpdate(query);
            System.out.println("Task is successfully updated.");
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
    public void delete_task_by_name(String task_name){
        try{
            String query = String.format("delete from %s where task_name = '%s'", "tasks", task_name);
            statement.executeUpdate(query);
            System.out.println("Task deleted");
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
            String query = String.format("drop table %s", "tasks");
            statement.executeUpdate(query);
            System.out.println("Table deleted");
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
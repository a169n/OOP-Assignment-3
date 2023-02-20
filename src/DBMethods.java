import java.sql.*;
public class DBMethods {
    Connection conn = connectToDb("postgres", "postgres", "d05");
    String table_name = "users ";
    Statement statement= null;
    {
        try {
            statement = conn.createStatement();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    ResultSet rs = null;
    public Connection connectToDb(String dbname, String username, String password) {
        try {
            Class.forName("org.postgresql.Driver");
            conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/" + dbname, username, password);
            if (conn == null) {System.out.println("Connection Failed!");}
        } catch (Exception e) {System.out.println(e);}
        return conn;
    }
    public void createTableUsers () {
        try {
            String query = "create table " + table_name + "(id SERIAL, username varchar(20), password varchar(20), primary key(id));";
            statement.executeUpdate(query);
            System.out.println("Users table created.");
        } catch (Exception e){System.out.println(e);}
    }
    public void createTableTasks () {
        try {
            String query = "create table " + "tasks" + "(id SERIAL,user_id int, task_name varchar(20), deadline varchar(25), importance int, primary key(id));";
            statement.executeUpdate(query);
            System.out.println("Tasks table created.");
        } catch (Exception e){System.out.println(e);}
    }
    public void insertUser(String username, String password){
        try{
            String query = String.format("insert into %s(username,password) values('%s', '%s');", table_name, username, password);
            statement.executeUpdate(query);
        }catch (Exception e) {System.out.println(e);}
    }
    public void insertTask(String task, String deadline, int importance, int user_id){
        try{
            String query = String.format("insert into %s(task_name,deadline,importance,user_id) values('%s','%s','%s','%s');", "tasks", task, deadline, importance, user_id);
            statement.executeUpdate(query);
            System.out.println("New task added.");
        }catch (Exception e) {System.out.println(e);}
    }
    public boolean checkName(String username){
        try{
            String query = String.format("select * from %s where username = '%s'", table_name, username);
            rs = statement.executeQuery(query);
            while (rs.next()){
                return true;
            }
        } catch (Exception e){System.out.println(e);}
        return false;
    }
    public boolean checkUser(String username,String password){
        try{
            String query = String.format("SELECT * FROM %s WHERE username = '%s' AND password = '%s'", table_name, username, password);
            ResultSet result = statement.executeQuery(query);
            return result.next();
        } catch (Exception e){System.out.println(e);}
        return false;
    }

    public int getUserId(String username){
        try{
            String query = String.format("select id from %s where username = '%s'", table_name, username);
            ResultSet result = statement.executeQuery(query);
            if (result.next()) {
                int id = result.getInt("id");
                return id;
            } else {
                return 0;
            }
        } catch (Exception e){System.out.println(e);}
        return 0;
    }
    public void outputTasks(int user_id){
        try{
            String query = String.format("select * from %s where user_id='%s'" , "tasks",user_id);
            rs = statement.executeQuery(query);
            int task_id = 1;
            while(rs.next()){
                System.out.println(task_id + ". " + rs.getString("task_name"));
                task_id++;
            }
        } catch (Exception e){System.out.println(e);}
    }
    public void sortByImportance(int user_id){
            int[] importance = new int[100];
            String[] task_names = new String[100];
        try{
            String query = String.format("select * from %s where user_id='%s'" , "tasks",user_id);
            rs = statement.executeQuery(query);
            int counter = 0;
            int task_id = 1;
            while(rs.next()){
                importance[counter]=rs.getInt("importance");
                task_names[counter]=rs.getString("task_name");
                counter++;
            }
            int temp=0;
            String temp1;
            for(int i=0;i<=counter;i++){
                for(int k=0;k<=counter-i;k++) {
                    if(importance[k]<importance[k+1]){
                        temp=importance[k];
                        importance[k]=importance[k+1];
                        importance[k+1]=temp;
                        temp1=task_names[k];
                        task_names[k]=task_names[k+1];
                        task_names[k+1]=temp1;
                    }
                }
                }
            for(int i=0;i<counter;i++){
                System.out.println(task_id+". "+task_names[i]+". Importance: "+importance[i]);
                task_id++;
            }
            }
        catch (Exception e){System.out.println(e);}
    }
    public void updateTheTask(String task, String new_task_name, int userId){
        try{
            String query = String.format("update %s set task_name = '%s' where task_name = '%s' and user_id='%s'", "tasks", new_task_name, task, userId);
            statement.executeUpdate(query);
            System.out.println("Task i                                                                                                                                                                                                                                     s successfully updated.");
        } catch (Exception e){System.out.println(e);}
    }
    public String searchByTask(String name, int userId){
        try{
            String query = String.format("select * from %s where lower(task_name) = '%s' and user_id= '%s'", "tasks",  name, userId);
            rs = statement.executeQuery(query);
            if (rs.next()) {
                String deadline = rs.getString("deadline");
                return deadline;
            } else {
                return null;
            }
        } catch (Exception e){System.out.println(e);}
        return null;
    }
    public void deleteTaskByName(String task_name, int userId){
        try{
            String query = String.format("delete from %s where task_name = '%s' and user_id='%s'", "tasks", task_name, userId);
            statement.executeUpdate(query);
            System.out.println("Task deleted");
        } catch (Exception e){System.out.println(e);}
    }
}
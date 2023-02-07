import java.sql.Statement;

public class Tasks {
    public int id;
    public String task_name;

    public Tasks() {
    }
    public Tasks(String task_name){

    }

    public void addTask(String task_name) {
        Statement statement= null;
        try{
            String query = String.format("insert into %s(task_name) values('%s');", "tasks", task_name);
            statement.executeUpdate(query);
            System.out.println("Task added.");
        }catch (Exception e) {
            System.out.println(e);
        }
    }

    public void editTask() {
    }

    public void ReadTasks() {
    }

    public void deleteTasks() {
    }

    public void sortByDeadline() {
    }
}

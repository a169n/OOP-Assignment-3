import java.util.Scanner;

public class TaskMethods extends Login{

    Scanner sc = new Scanner(System.in);

    public void taskAddNew(){
        System.out.print("Task name: ");
        String task = sc.nextLine();
        insertTask(task, getCurrentUser().getID());
    }

    public void taskUpdate(){
        taskRead();
        System.out.print("Task name that will be updated:");
        String task = sc.nextLine();
        //check if such task exists
        System.out.print("New task name: ");
        String new_task = sc.nextLine();

        updateTheTask(task, new_task);
    }
    public void taskDelete(){
        System.out.print("Task name that will be deleted: ");
        //check if such task exists
        String task = sc.nextLine();

        deleteTaskByName(task);
    }
    public void taskRead(){
        outputTasks(getID(getCurrentUser().getUsername()));
    }
}

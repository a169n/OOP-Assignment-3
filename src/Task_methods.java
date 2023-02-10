import java.util.Scanner;

public class Task_methods extends Login {

    Scanner sc = new Scanner(System.in);

    public void task_add_new(){
        System.out.print("Task name: ");
        String task = sc.nextLine();
        insertTask(task, getCurrentUser().getID());
    }

    public void task_update(){
        task_read();
        System.out.print("Task name that will be updated:");
        String task = sc.nextLine();
        //check if such task exists
        System.out.print("New task name: ");
        String new_task = sc.nextLine();

        update_the_task(task, new_task);
    }
    public void task_delete(){
        System.out.print("Task name that will be deleted: ");
        //check if such task exists
        String task = sc.nextLine();

        delete_task_by_name(task);
    }
    public void task_read(){
        output_tasks(getID(getCurrentUser().getUsername()));
    }
}

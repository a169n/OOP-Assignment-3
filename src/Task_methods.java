import java.util.Scanner;

public class Task_methods {
    DB_methods db = new DB_methods();
    Scanner sc = new Scanner(System.in);


    public void task_add_new(){
        System.out.print("Task name: ");
        String task = sc.nextLine();

        db.insertTask(task);
    }
    public void task_update(){
        System.out.print("Task name: ");
        String task = sc.nextLine();
        //check if such task exists
        System.out.print("New task name: ");
        String new_task = sc.nextLine();

        db.update_the_task(task, new_task);
    }
    public void task_delete(){
        System.out.print("Task name that will be deleted: ");
        //check if such task exists
        String task = sc.nextLine();

        db.delete_task_by_name(task);
    }
    public void task_read(){
        db.output_tasks();
    }
}

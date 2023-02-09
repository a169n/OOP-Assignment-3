import java.util.Scanner;

public class Start_page {
    Scanner sc = new Scanner(System.in);
    Registration rg = new Registration();
    Login lg = new Login();
    Task_methods ts = new Task_methods();
    DB_methods db= new DB_methods();

    public void reg_or_log_text() {
        System.out.print("""
                1.Registration
                2.Login
                """);
        System.out.print("Choose the option: ");
    }

    public void taskFunctions_text() {
        System.out.print("""
                1. Add a new task
                2. Update the task
                3. Delete the task
                4. Show all tasks
                0. Exit
                """);
        System.out.print("Choose the option: ");
    }

    public void reg_or_log(){
        int option1 = sc.nextInt();

        switch (option1) {
            case 1 -> rg.registration();
            case 2 -> lg.login();
            default -> {
                System.out.println("Enter either 1 or 2.");
                System.out.print("Choose the option: ");
                reg_or_log();
            }
        }
    }
    public void taskFunctions(){
        int option2 = sc.nextInt();

        switch (option2) {
            case 1 -> ts.task_add_new();
            case 2 -> ts.task_update();
            case 3 -> ts.task_delete();
            case 4 -> ts.task_read();
            case 0 -> start();
            default -> {
                System.out.println("Enter the appropriate option.");
                System.out.print("Choose the option: ");
                taskFunctions();
            }
        }
    }
    public void start() {
        reg_or_log_text();

        reg_or_log();

        taskFunctions_text();

        taskFunctions();
    }
}

import java.util.Scanner;

public class Start_page {
    Scanner sc = new Scanner(System.in);
    Registration rg = new Registration();
    Login lg = new Login();
    Task_methods ts = new Task_methods();

    DB_methods db= new DB_methods();

    public void reg_or_log_text() {
        System.out.print("""
                ==============
                1.Registration
                2.Login
                ==============
                """);
        System.out.print("Choose the option: ");
    }

    public void taskFunctions_text() {
        System.out.print("""
                ==================
                1. Add a new task
                2. Update the task
                3. Delete the task
                4. Show all tasks
                0. Exit
                ==================
                
                
                Choose the option:
                """);
    }

    public void reg_or_log(){
        int option1 = sc.nextInt();

        while (option1 != 1 && option1 != 2) {
            System.out.println("""
                    Enter either 1 or 2.
                    Choose the option:
                    """);
            option1 = sc.nextInt();
        }

        switch (option1) {
            case 1 -> rg.registration();
            case 2 -> lg.login();
        }
    }
    public void taskFunctions(){
        int option2 = sc.nextInt();

        while (option2 != 0) {
            switch (option2) {
                case 1 -> ts.task_add_new();
                case 2 -> ts.task_update();
                case 3 -> ts.task_delete();
                case 4 -> ts.task_read();
                default -> System.out.print("Enter the appropriate option: ");
            }

            taskFunctions_text();
            option2 = sc.nextInt();
        }

        start();
    }
    public void start() {
        reg_or_log_text();

        reg_or_log();

        taskFunctions_text();

        taskFunctions();
    }
}

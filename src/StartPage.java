import java.util.Scanner;

public class StartPage {
    Scanner sc = new Scanner(System.in);
    Registration rg = new Registration();
    Login lg = new Login();
    TaskMethods ts = new TaskMethods();

    DBMethods db= new DBMethods();

    public void regOrLogText() {
        System.out.print("""
                ==============
                1.Registration
                2.Login
                ==============
                """);
        System.out.print("Choose the option: ");
    }

    public void taskFunctionsText() {
        System.out.print("""
                ==================
                1. Add a new task
                2. Update the task
                3. Delete the task
                4. Show all tasks
                5. Show task deadline
                0. Exit
                ==================
                Choose the option:
                """);
    }

    public void regOrLog(){
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
                case 1 -> ts.taskAddNew();
                case 2 -> ts.taskUpdate();
                case 3 -> ts.taskDelete();
                case 4 -> ts.taskRead();
                case 5 -> ts.taskDeadline();
                default -> System.out.print("Enter the appropriate option: ");
            }

            taskFunctionsText();
            option2 = sc.nextInt();
        }

        start();
    }
    public void start() {
        regOrLogText();

        regOrLog();

        taskFunctionsText();

        taskFunctions();
    }
}

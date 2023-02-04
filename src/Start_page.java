import java.util.Scanner;

public class Start_page {
    Scanner sc = new Scanner(System.in);
    Registration rg = new Registration();
    Login lg = new Login();
    public void reg_or_log_text(){
        System.out.println("1. Registration");
        System.out.println("2. Login");
        System.out.print("Choose the option: ");
    }
    public void taskFunctions_text(){
        System.out.print("1. Add a new task");
        System.out.print("2. Update the task");
        System.out.print("3. Delete the task");
        System.out.print("4. Show all tasks");
        System.out.print("0. Exit");
        System.out.print("Choose the option: ");
    }

    public void start() {


        reg_or_log_text();

        int option = sc.nextInt();

        switch (option) {
            case 1 -> rg.registration();
            case 2 -> lg.login();
            default -> {
                System.out.println("Enter either 1 or 2.");
                System.out.println("━━━━━━━━━━━━━━━━━━━━━━");
                start();
            }
        }






    }
}

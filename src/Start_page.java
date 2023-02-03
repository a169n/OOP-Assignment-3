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

    public void start() {
        System.out.println("Welcome to TO-DO console application by ADGO!");

        reg_or_log_text();

        int option = sc.nextInt();
        if (option == 1){
            rg.registration();
        }
        else if (option == 2) {
            lg.login();
        }
        else{
            Exception e;
        }

        System.out.println("━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━");


    }
}

import java.sql.Connection;
import java.util.Scanner;
import java.util.InputMismatchException;


public class Start_page {

    String table_name = "users";
    Scanner sc = new Scanner(System.in);
    DB_functions db = new DB_functions();

    Registration rg = new Registration();
    Login lg=new Login();
    Connection conn = db.connect_to_db("postgres", "postgres", "d05");

    public void start() {
        System.out.println("Welcome to TO-DO console application by ADGO!");

        System.out.println("""
                1.Registration
                2.Login
                """);
        int option = sc.nextInt();
        switch (option){
            case 1:
                Registration.registration();
            case 2:
                Login.login();
        }

        System.out.println("━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━");


    }
}

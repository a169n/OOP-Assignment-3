import java.sql.Connection;
import java.util.Scanner;
import java.util.InputMismatchException;


public class Start_page {

    String table_name = "users";
    Scanner sc = new Scanner(System.in);
    DB_functions db = new DB_functions();

    Registration rg = new Registration();
    Connection conn = db.connect_to_db("postgres", "postgres", "1234");

    public void start() {
        System.out.println("Welcome to TO-DO console application by ADGO!");

        System.out.println("1. Registration");
        System.out.println("2. Login");

        try {
            System.out.println("Enter option (1-2): ");
            int option = sc.nextInt();
            if (option == 1) {
                rg.registration();
            }
        } catch (Exception e) {
            System.out.println(e);
        }
//            } else if (option == 2){
//                //login
//            } else {
//                break;
//            }


        System.out.println("━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━");


    }
}

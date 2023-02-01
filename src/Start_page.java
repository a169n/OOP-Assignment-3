import java.sql.Connection;
import java.util.Scanner;
import java.util.InputMismatchException;


public class Start_page {

//    String table_name = "users";
//    Scanner sc = new Scanner(System.in);
//    DB_functions db = new DB_functions();
//    Connection conn = db.connect_to_db("postgres", "postgres", "1234");
//    public void start(){
//        System.out.println("Welcome to TO-DO console application by ADGO!");
//
//        System.out.println("1. Registration");
//        System.out.println("2. Login");
//
//        try{
//            System.out.println("Enter option (1-2): ");
//            int option = sc.nextInt();
//            if (option == 1) {
//                registration();
//            } else if (option == 2){
//
//            } else {
//                break;
//            }
//            catch (InputMismatchException _){
//                System.out.println("Input must be integer");
//                sc.nextLine(); // to ignore incorrect input
//            }
//            catch (Exception e){
//                System.out.println(e);
//            }
//
//            System.out.println("━━━━━━━━━━━━━━━━━━━━━━━━━");
//
//        }
//    }



    public void registration () {
        System.out.println("Enter username: ");
        String username = sc.nextLine();
        System.out.println("Enter password: ");
        String password = sc.nextLine();
        System.out.println("Confirm the password: ");
        String password2 = sc.nextLine();

        db.insertRow(conn, table_name, username, password);
    }
    public void login () {

    }

}

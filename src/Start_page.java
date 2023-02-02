import java.sql.Connection;
import java.util.Scanner;
import java.util.InputMismatchException;


public class Start_page {
    public boolean checkPasswordValidity(String password) {
        boolean first=false, second=false, third = false;
        if (password.length()<8) return false;
        for (int i = 0; i < password.length(); i++) {
            char c = password.charAt(i);
            if ('a' <= c && c <= 'z') first = true;
            if ('0' <= c && c <= '9') second = true;
            if ('A' <= c && c <= 'Z') third = true;
            if(first && second && third) return true;
        }
        return false;
    }

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
//                Sy
//                stem.out.println("Input must be integer");
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

    String table_name = "users";
    Scanner sc = new Scanner(System.in);
    DB_functions db = new DB_functions();


    public void registration () {
        System.out.println("Enter username: ");
        String username = sc.nextLine();

        System.out.println("Enter password: ");
        String password = sc.nextLine();
        while(!checkPasswordValidity(password)){
            System.out.println("Your password should contain lowercase, uppercase characters and numbers");
            password= sc.nextLine();
        }
        System.out.println("Confirm the password: ");
        String password2 = sc.nextLine();
        while(!password.equals(password2)){
            System.out.println("Your passwords don't match");
            password2=sc.nextLine();
        }
        db.insertUser("st", username, password);
    }
    public void login () {

    }

}

import Interfaces.IPassword;
import java.util.Scanner;

public class Login extends Registration implements IPassword {
    static DB_methods db = new DB_methods();
    static Scanner sc = new Scanner(System.in);


    public void login(){
        System.out.print("Enter username: ");
        String username = sc.nextLine();
        if(!db.checkName(username)){
            System.out.print("No such user found" + '\n');
            login();
        }
        else {
            System.out.print("Enter password: ");
            String password = sc.nextLine();
            if(db.checkUser(username,password)){
                System.out.println("Welcome, "+username);
            }
            else {
                System.out.println("Incorrect username or password");
                login();
            }
        }
    }
}

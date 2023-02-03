import Interfaces.Password;
import java.util.Scanner;

public class Login extends Registration implements Password {
    static DB_functions db = new DB_functions();
    static Scanner sc = new Scanner(System.in);

    @Override
    public boolean checkPasswordValidity(String password){

        return true;
    }

    @Override
    public void check_duplicate(String username) {
        if(!db.checkName(username)){
            System.out.print("No such user found" + '\n');
            login();
        }
    }


    public void login(){
        System.out.print("Enter username: ");
        String username = sc.nextLine();
        check_duplicate(username);
        System.out.print("Enter password: ");
        String password = sc.nextLine();
        if(checkPasswordValidity(password)){
            // some statements
        }
        if(db.checkUser(username,password)){
            System.out.println("Welcome, "+username);
        }
        else{ System.out.println("Username or password is incorrect");
        login();}
    }
}

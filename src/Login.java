import Interfaces.IPassword;
import java.util.Scanner;

public class Login extends DB_methods implements IPassword {
    private static User currentUser = null;
    public static User getCurrentUser() {
        return currentUser;
    }

    public static void setCurrentUser(User user) {
        currentUser = user;
    }
    static Scanner sc = new Scanner(System.in);

    @Override
    public boolean checkPasswordValidity(String password){

        return true;
    }


    public void check_duplicate(String username) {
        if(checkName(username)){
            System.out.println("No such user found");
            login();
        }
    }


    public void login(){
        System.out.print("Enter username: ");
        String username = sc.nextLine();
        check_duplicate(username);

        System.out.print("Enter password: ");
        String password = sc.nextLine();
        checkPasswordValidity(password);
        if(checkUser(username,password)){
            System.out.println("Welcome, "+username);
            return;
        }
        else{
            System.out.println("Username or password is incorrect");
            login();
        }
    }
}

import Interfaces.IPassword;
import java.util.Scanner;

public class Login extends DBMethods implements IPassword {
    static User currentUser =new User();
    public static User getCurrentUser() {
        return currentUser;
    }
    public static void setCurrentUser(User user) {
        currentUser = user;
    }
    static Scanner sc = new Scanner(System.in);

    @Override
    public boolean checkPasswordValidity(String password){
        return checkUser(getCurrentUser().getUsername(), password);
    }

    public void login(){
        System.out.print("Enter username: ");
        String username = sc.nextLine();
        setCurrentUser(currentUser);
        while(!checkName(username.toLowerCase())){
            System.out.print("No such user found! Please try again: ");
            username= sc.nextLine();
        }
        currentUser.setUsername(username.toLowerCase());
        System.out.print("Enter the password: ");
        String password = sc.nextLine();
        while(!checkPasswordValidity(password)){
            System.out.print("The password is incorrect! Please try again: ");
            password= sc.nextLine();
        }
        System.out.println("Welcome, "+username + "!");
        currentUser.setPassword(password);
        currentUser.setID(getID(currentUser.getUsername()));
    }
}

import Interfaces.IPassword;
import java.util.Scanner;

public class Login extends DB_methods implements IPassword {
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
            System.out.println("No such user found");
            username= sc.nextLine();
        }
        currentUser.setUsername(username.toLowerCase());
        System.out.println("Enter the password:");
        String password = sc.nextLine();
        while(!checkPasswordValidity(password)){
            System.out.println("The password is incorrect! Please try again:");
            password= sc.nextLine();
        }
        System.out.println("Welcome, "+username);
        currentUser.setPassword(password);
        currentUser.setID(getID(currentUser.getUsername()));
    }
}

import Interfaces.IPassword;
import java.util.Scanner;

public class Login extends Registration implements IPassword {
    DB_methods db = new DB_methods();

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
        db.username = sc.nextLine();
        check_duplicate(db.username);
        System.out.print("Enter password: ");
        String password = sc.nextLine();
        checkPasswordValidity(password);// some statements
        if(db.checkUser(db.username,password)){
            System.out.println("Welcome, "+db.username);
        }
        else{ System.out.println("password is incorrect");
        login();}
    }
}

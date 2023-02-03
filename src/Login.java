import Interfaces.Password;

import java.util.Scanner;

public class Login extends Registration implements Password {
    DB_functions db = new DB_functions();
    static Scanner sc = new Scanner(System.in);

    @Override
    public boolean checkPasswordValidity(String password){
        //some statements
        return true;
    }
    public static void login(){
        System.out.print("Enter username: ");
        String username = sc.nextLine();
        System.out.print("Enter password: ");
        String password = sc.nextLine();

    }
}

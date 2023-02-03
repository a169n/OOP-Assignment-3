import Interfaces.Password;

import java.util.Scanner;

public class Login extends Registration implements Password {
    DB_functions db = new DB_functions();

    @Override
    public boolean checkPasswordValidity(String password){
        //some statements
        return true;
    }
    public void login(){
        System.out.print("Enter username: ");
        Scanner sc = new Scanner(System.in);
        String username = sc.nextLine();
        System.out.print("Enter password: ");
        String password = sc.nextLine();

    }
}

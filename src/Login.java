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
        Scanner sc= new Scanner(System.in);
        System.out.println("Enter username");

    }
}

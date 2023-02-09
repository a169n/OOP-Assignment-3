import Interfaces.IPassword;

import java.util.Scanner;

public class Registration implements IPassword {
    Scanner sc = new Scanner(System.in);
    DB_methods db = new DB_methods();


    public boolean checkPasswordValidity(String password) {
        boolean first=false, second=false, third = false;
        if (password.length() < 8) return false;
        for (int i = 0; i < password.length(); i++) {
            char c = password.charAt(i);
            if ('a' <= c && c <= 'z') first = true;
            if ('0' <= c && c <= '9') second = true;
            if ('A' <= c && c <= 'Z') third = true;
            if(first && second && third) return true;
        }
        return false;
    }

    public void check_duplicate(String username){
        if(db.checkName(username)){
            System.out.print(username + " already exists"+"\n");
            registration();
        }
    }

    public void registration () {
        System.out.print("Enter username: ");
        String username = sc.nextLine();
        check_duplicate(username);

        System.out.print("Enter password: ");
        String password = sc.nextLine();

        while(!checkPasswordValidity(password)){
            System.out.println("Your password should be at least 8 symbol long and contain lowercase, uppercase characters and numbers");
            password = sc.nextLine();
        }
        System.out.print("Confirm the password: ");
        String password2 = sc.nextLine();
        while(!password.equals(password2)){
            System.out.println("Your passwords don't match. Try again.");
            password2 = sc.nextLine();
        }

        db.insertUser(username, password);
    }
}

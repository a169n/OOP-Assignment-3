import Interfaces.IPassword;

import java.util.Scanner;

public class Registration extends DB_methods implements IPassword {
    Scanner sc = new Scanner(System.in);
    DB_methods db = new DB_methods();

    @Override
    public boolean checkPasswordValidity(String password) {
        boolean hasLowerCase = false;
        boolean hasUpperCase = false;
        boolean hasDigit = false;
        boolean hasSpecialChar = false;

        if (password.length() < 8) {
            System.out.println("Password must be at least 8 characters long");
            return false;
        }

        for (int i = 0; i < password.length(); i++) {
            char c = password.charAt(i);
            if (Character.isLowerCase(c)) {
                hasLowerCase = true;
            } else if (Character.isUpperCase(c)) {
                hasUpperCase = true;
            } else if (Character.isDigit(c)) {
                hasDigit = true;
            } else if (!Character.isLetterOrDigit(c)) {
                hasSpecialChar = true;
            }
        }

        if (!hasLowerCase || !hasUpperCase || !hasDigit || !hasSpecialChar) {
            System.out.println("Password must contain at least one lowercase letter, one uppercase letter, one digit, and one special character");
            return false;
        }

        return true;
    }


    public void check_duplicate(String username){
        if(checkName(username)){
            System.out.print(username + " already exists"+"\n");
            registration();
        }
    }

    public void registration () {
        System.out.print("Enter username: ");
        db.username = sc.nextLine();
        check_duplicate(db.username);

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

        insertUser(username, password);
    }
}

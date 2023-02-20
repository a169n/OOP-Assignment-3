import Interfaces.IPassword;

import java.util.Scanner;

public class Registration extends DBMethods implements IPassword {
    static boolean regOrLog= false;
    public static User currentUser = new User();
    public static User getCurrentUser() {
        return currentUser;
    }
    public static void setCurrentUser(User user) {
        currentUser = user;
    }
    Scanner sc = new Scanner(System.in);
    @Override
    public boolean checkPasswordValidity(String password) {
        boolean hasLowerCase = false;
        boolean hasUpperCase = false;
        boolean hasDigit = false;
        boolean hasSpecialChar = false;
        if (password.length() < 8) {
            System.out.println("Password must be at least 8 characters long! Please try again");
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
            System.out.println("Password must contain at least one lowercase letter, one uppercase letter, one digit, and one special character \n"+
                    "Please try again!");
            return false;
        }
        return true;
    }

    public void registration () {
        regOrLog = true;
        System.out.print("Enter username: ");
        String username = sc.nextLine();
        while(checkName(username.toLowerCase())){
            System.out.print("Username " + username.toLowerCase() + " already exists! Please try again: ");
            username= sc.nextLine();        }
        setCurrentUser(currentUser);
        currentUser.setUsername(username.toLowerCase());
        System.out.print("Enter the password: ");
        String password = sc.nextLine();
        while(!checkPasswordValidity(password)){
            password = sc.nextLine();
        }
        System.out.print("Confirm the password: ");
        String password2 = sc.nextLine();
        while(!password.equals(password2)){
            System.out.print("Your passwords don't match! Please try again: ");
            password2 = sc.nextLine();
        }
        System.out.println("Welcome, "+currentUser.getUsername() + "!");
        currentUser.setPassword(password);
        insertUser(currentUser.getUsername().toLowerCase(), currentUser.getPassword());
        currentUser.setID(getUserId(currentUser.getUsername()));
    }
}


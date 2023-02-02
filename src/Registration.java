import java.util.Scanner;

public class Registration implements Password{
    DB_functions db= new DB_functions();
    @Override
    public boolean checkPasswordValidity(String password) {
        boolean first=false, second=false, third = false;
        if (password.length()<8) return false;
        for (int i = 0; i < password.length(); i++) {
            char c = password.charAt(i);
            if ('a' <= c && c <= 'z') first = true;
            if ('0' <= c && c <= '9') second = true;
            if ('A' <= c && c <= 'Z') third = true;
            if(first && second && third) return true;
        }
        return false;
    }
    public void registration () {
        System.out.println("Enter username: ");
        Scanner sc = new Scanner(System.in);
        String username = sc.nextLine();

        System.out.println("Enter password: ");
        String password = sc.nextLine();
        while(!checkPasswordValidity(password)){
            System.out.println("Your password should contain lowercase, uppercase characters and numbers");
            password= sc.nextLine();
        }
        System.out.println("Confirm the password: ");
        String password2 = sc.nextLine();
        while(!password.equals(password2)){
            System.out.println("Your passwords don't match");
            password2=sc.nextLine();
        }
        db.insertUser(username, password);
    }
}

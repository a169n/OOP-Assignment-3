import java.sql.Connection;

public class Main {
    public static void main(String[] args) {
        DB_functions db = new DB_functions();
        Start_page st = new Start_page();
        db.read_data();
    }


}
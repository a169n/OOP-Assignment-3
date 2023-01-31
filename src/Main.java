import java.sql.Connection;

public class Main {
    public static void main(String[] args) {

        DB_functions db = new DB_functions();

        Connection conn = db.connect_to_db("postgres", "postgres", "1234");
    }
}
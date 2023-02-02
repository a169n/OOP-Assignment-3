import java.sql.Connection;

public class Main {
    public static void main(String[] args) {
        DB_functions db = new DB_functions();
        Start_page st = new Start_page();
        st.registration();
        db.read_data("st");
    }


}
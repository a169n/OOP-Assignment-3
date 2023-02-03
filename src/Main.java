public class Main {
    public static void main(String[] args) {
        DB_functions db = new DB_functions();

        String db_name = "postgres";

        db.connect_to_db(db_name, "postgres", "qwerty");

        Start_page app = new Start_page();

        app.start();
    }
}
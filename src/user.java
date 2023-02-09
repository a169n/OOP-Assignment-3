import java.sql.Connection;
import java.sql.PreparedStatement;
//import java.sql.ResultSet;
import java.sql.SQLException;

abstract class User {
    private String username;
    private String position;
    private String password;

    static Connection connection = null;
    PreparedStatement ps =null;

    //static ResultSet rs = null;

    //public User(){ }
    public User(String username, String position, String password){
        this.username = username;
        this.password = password;
        this.position = position;
    }

    public void setUsername(String name) {
        this.username = name;
    }


    public void setPosition(String position) {
        this.position = position;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUsername() {
        return username;
    }


    public String getPosition() {
        return position;
    }

    public String getPassword() {
        return password;
    }
    public void insert() throws SQLException {
        new DB_methods();
        ps = connection.prepareStatement("INSERT INTO users (username, password, role) values (?, ? ,?)");
        ps.setString(1, getUsername());
        ps.setString(2, getPassword());
        ps.setString(3, getPosition());
        ps.execute();
    }

    @Override
    public String toString() {
        return ("Username: " + getUsername() + " Possition: " + getPosition());
    }
}

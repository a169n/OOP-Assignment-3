import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

abstract class User {
    private String username, password;

    static Connection connection = null;
    PreparedStatement ps =null;

    static ResultSet rs = null;

    //public User(){ }
    public User(String username, String position, String password){
        setPassword(password);
        setUsername(username);
    }

    public void setUsername(String name) {
        this.username = name;
    }


    public void setPassword(String password) {
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }
    public void insert() throws SQLException {
        new DB_methods();
        ps = connection.prepareStatement("INSERT INTO users (username, password, role) values (?, ? ,?)");
        ps.setString(1, getUsername());
        ps.setString(2, getPassword());
        ps.execute();
    }

    @Override
    public String toString() {
        return ("Username: " + getUsername());
    }
}


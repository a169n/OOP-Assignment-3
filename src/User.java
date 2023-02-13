import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

class User {
    private String username, password;
    private int ID;

    public User(String username) {
        setUsername(username);
    }

    static Connection connection = null;
    PreparedStatement ps =null;

    static ResultSet rs = null;

    public User(String username, String password){
        setPassword(password);
        setUsername(username);
    }
    public User(){
    }

    public void setUsername(String name) {
        this.username = name;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public int getID() {
        return ID;
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

    @Override
    public String toString() {
        return ("Username: " + getUsername());
    }
}


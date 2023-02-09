public class User {
    String password, username, position;
    public User(){

    }
    public User(String username, String password, String position){
        setPassword(password);
        setPosition(position);
        setUsername(username);
    }
    public String getPassword() {
        return password;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPosition() {
        return position;
    }

    public String getUsername() {
        return username;
    }
}

package Bean;

public class User{
    private String username;
    private String password;

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Override
    public String toString() {
        return username + ", " + password;
    }

    @Override
    public boolean equals(Object obj) {
        if(obj instanceof User){
            if(((User) obj).getUsername().equals(this.username)){
                if(((User) obj).password.equals(this.password)){
                    return true;
                }
            }
        }
        return false;
    }
}

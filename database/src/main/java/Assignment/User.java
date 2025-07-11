package Assignment;

import java.io.Serializable;

public class User implements Serializable{
    private String name;
    private String password;

    public User(String name, String password) {
        this.name = name;
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public boolean validatePassword(String inputPassword) {
        return password.equals(inputPassword);
    }
}

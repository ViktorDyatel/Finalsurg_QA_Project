package models;

public class User {
    private String email = System.getProperty("email");
    private String password =System.getProperty("password");"QWERTY1998q";

    public User(){
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}

package sohail_login.login_node.API;

/**
 * Created by Sohail on 11/30/15.
 */
public class ConfirmDeletion {
    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String password) {
        Password = password;
    }

    public String getToken() {
        return Token;
    }

    public void setToken(String token) {
        Token = token;
    }

    String Email, Password, Token;
}

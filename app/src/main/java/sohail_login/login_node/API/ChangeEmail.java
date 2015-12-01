package sohail_login.login_node.API;

/**
 * Created by Sohail on 11/30/15.
 */
public class ChangeEmail {
    public String getOldEmail() {
        return OldEmail;
    }

    public void setOldEmail(String oldEmail) {
        OldEmail = oldEmail;
    }

    public String getNewEmail() {
        return NewEmail;
    }

    public void setNewEmail(String newEmail) {
        NewEmail = newEmail;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String password) {
        Password = password;
    }

    String OldEmail, NewEmail, Password;
}

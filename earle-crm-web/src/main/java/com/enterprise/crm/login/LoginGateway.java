package com.enterprise.crm.login;

import com.enterprise.crm.navigation.Pages;
import java.io.Serializable;
import javax.ejb.Stateful;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;

/**
 *
 * @author jamescrabbe
 */
@Named
@Stateful
@SessionScoped
public class LoginGateway implements Serializable {
      private static final long serialVersionUID = 1L;

    @Inject
    transient LoginAuthenticator authenitcator;
    
    @Inject 
    transient UserSecurityService userSecurityService;   
    
    @Inject
    transient UserContent userContent;
            
    private String username;
    private String password;
    private String resetpassword;
    private String resetpassword1;
    private String oldpassword;
    private String welcomeMessage;
    private boolean invalidLoginAttempt;
    private boolean newPasswordDontMatch;
    private boolean oldPasswordDontMatch;
    private boolean passwordChanged;
    private boolean passwordUsed;

    public String getWelcomeMessage() {
        return welcomeMessage;
    }

    public void setWelcomeMessage(String welcomeMessage) {
        this.welcomeMessage = welcomeMessage;
    }

    public String login() {
        passwordChanged = false;
        String responsePage = Pages.WELCOME.getURLRedirect();
        LoginResponse response = authenitcator.authenticate(username, password);
        if (response.isValid()) {
            responsePage = Pages.HOME.getURLRedirect();
            invalidLoginAttempt = false;
            userContent.setLoggedInUser(response.getUserDetails());
        } else {
            invalidLoginAttempt = true;
        }
        return responsePage;
    }

    public String resetPassword() {
        oldPasswordDontMatch = false;
        newPasswordDontMatch = false;
        passwordUsed = false;
        if (password.equals(oldpassword)) {
            if (resetpassword.equals(resetpassword1)) {
                if (resetpassword.equals(password)) {
                    passwordUsed = true;
                } else {
                    passwordChanged = true;
                    newPasswordDontMatch = false;
                    password = resetpassword;

                    //UpdatePassword update = authenitcator.update(username, password);
                }
            } else {
                newPasswordDontMatch = true;
            }
            return null;
        } else {
            oldPasswordDontMatch = true;
            return null;
        }
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public boolean isInvalidLoginAttempt() {
        return invalidLoginAttempt;
    }

    public void setInvalidLoginAttempt(boolean inValidLoginAttempt) {
        this.invalidLoginAttempt = inValidLoginAttempt;
    }

    public LoginAuthenticator getAuthenitcator() {
        return authenitcator;
    }

    public void setAuthenitcator(LoginAuthenticator authenitcator) {
        this.authenitcator = authenitcator;
    }

    public boolean isNewPasswordDontMatch() {
        return newPasswordDontMatch;
    }

    public void setNewPasswordDontMatch(boolean newPasswordDontMatch) {
        this.newPasswordDontMatch = newPasswordDontMatch;
    }

    public boolean isOldPasswordDontMatch() {
        return oldPasswordDontMatch;
    }

    public void setOldPasswordDontMatch(boolean oldPasswordDontMatch) {
        this.oldPasswordDontMatch = oldPasswordDontMatch;
    }

    public String getOldpassword() {
        return oldpassword;
    }

    public void setOldpassword(String oldpassword) {
        this.oldpassword = oldpassword;
    }

    public boolean isPasswordChanged() {
        return passwordChanged;
    }

    public void setPasswordChanged(boolean passwordChanged) {
        this.passwordChanged = passwordChanged;
    }

    public boolean isPasswordUsed() {
        return passwordUsed;
    }

    public void setPasswordUsed(boolean passwordUsed) {
        this.passwordUsed = passwordUsed;
    }

    public String getResetpassword() {
        return resetpassword;
    }

    public void setResetpassword(String resetpassword) {
        this.resetpassword = resetpassword;
    }

    public String getResetpassword1() {
        return resetpassword1;
    }

    public void setResetpassword1(String resetpassword1) {
        this.resetpassword1 = resetpassword1;
    }
}
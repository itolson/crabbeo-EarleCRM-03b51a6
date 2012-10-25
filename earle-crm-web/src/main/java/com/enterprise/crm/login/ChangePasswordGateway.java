/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.enterprise.crm.login;

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
public class ChangePasswordGateway implements Serializable {

    private static final long serialVersionUID = 1L;
    @Inject
    transient UserSecurityService userSecurityService;
    @Inject
    transient UserContent userContent;
    
    private String password;
    private String oldPassword;
    //rename these to newPassword and confirmation password
    //varibles should be in camel case
    private String newPassword;
    //varibles should be in camel case
    private String confirmationPassword;
    //change this to newPasswordMatch
    private boolean newPasswordMatch;
    //change this to oldPasswordMatch
    private boolean oldPasswordMatch;
    private boolean passwordChanged;
    private boolean passwordUsed;

// needs to reset the flags once updated i.e password changed is still flagged when you go back into the facelet...
    
    //method is set to return a String but only ever returns a null, this indicates
    //that it should be a public void method
    public void resetPassword() {
        oldPasswordMatch = false;
        newPasswordMatch = false;
        passwordUsed = false;
        passwordChanged=false;
        String username = userContent.getLoggedInUser().getUserName();
        UserSecurity userSecurity = userSecurityService.getUserSecurity(username);
//        if (password.equals(oldPassword)) {
            //I would try to split this down into smaller methods if possible
            //as i'm seeing a lot of booleans being set but its difficult to read
            //instead of having a lots of differnt booleans another solution would be to 
            //use a enum to hold the password reset status..much cleaner..
            // e.g. PASSWORD_USED, PASSWORD_RESET, INVALID_PASSWORD, PASSWORDS_DONT_MATCH
            if (newPassword.equals(confirmationPassword)) {
                if (newPassword.equals(password)) {
                    passwordUsed = true;
                } else {
                    passwordChanged = true;
                    password = newPassword;
                    updatePassword();
                }
            } else {
                newPasswordMatch = true;
            }
            //multiple return statement in a method are bad practice
//        } else {
//            oldPasswordMatch = true;
//multiple return statement in a method are bad practice
//        }
    }

    private void updatePassword() {
        String username = userContent.getLoggedInUser().getUserName();
        UserSecurity userSecurity = userSecurityService.getUserSecurity(username);
        userSecurity.setPassword(newPassword);
        userSecurityService.saveUserSecurity(userSecurity);
    }

    public String getConfirmationPassword() {
        return confirmationPassword;
    }

    public void setConfirmationPassword(String confirmationPassword) {
        this.confirmationPassword = confirmationPassword;
    }

    public String getNewPassword() {
        return newPassword;
    }

    public void setNewPassword(String newPassword) {
        this.newPassword = newPassword;
    }

    public boolean isNewPasswordMatch() {
        return newPasswordMatch;
    }

    public void setNewPasswordMatch(boolean newPasswordMatch) {
        this.newPasswordMatch = newPasswordMatch;
    }

    public String getOldPassword() {
        return oldPassword;
    }

    public void setOldPassword(String oldPassword) {
        this.oldPassword = oldPassword;
    }

    public boolean isOldPasswordMatch() {
        return oldPasswordMatch;
    }

    public void setOldPasswordMatch(boolean oldPasswordMatch) {
        this.oldPasswordMatch = oldPasswordMatch;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
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

    public UserContent getUserContent() {
        return userContent;
    }

    public void setUserContent(UserContent userContent) {
        this.userContent = userContent;
    }

    public UserSecurityService getUserSecurityService() {
        return userSecurityService;
    }

    public void setUserSecurityService(UserSecurityService userSecurityService) {
        this.userSecurityService = userSecurityService;
    }

 
}

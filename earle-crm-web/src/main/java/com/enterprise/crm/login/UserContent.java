/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.enterprise.crm.login;

import com.enterprise.crm.user.UserDetails;
import java.io.Serializable;
import javax.ejb.Stateful;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

/**
 *
 * @author user
 */
@Named
@Stateful
@SessionScoped
public class UserContent implements Serializable {

    private static final long serialVersionUID = 1L;
    private UserDetails loggedInUser;

    public UserDetails getLoggedInUser() {
        return loggedInUser;
    }

    public void setLoggedInUser(UserDetails loggedInUser) {
        this.loggedInUser = loggedInUser;
    }
}

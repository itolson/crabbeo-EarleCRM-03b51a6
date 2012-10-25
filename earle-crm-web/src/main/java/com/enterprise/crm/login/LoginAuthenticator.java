/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.enterprise.crm.login;

import com.enterprise.crm.user.UserDetails;
import com.enterprise.crm.user.UserDetailsService;
import java.io.Serializable;
import javax.enterprise.inject.Default;
import javax.inject.Inject;
import javax.inject.Named;

/**
 *
 * @author jamescrabbe
 */
@Named
@Default
public class LoginAuthenticator implements Serializable {
    private static final long serialVersionUID = 1L;
    
    private static final int MAX_LOGIN_FAILED_LOGIN_ATTEMPTS = 3;
    
    @Inject    
    transient UserSecurityService userSecurityService;
    
    @Inject 
    transient UserDetailsService userDetailsService;
    
    
    public LoginResponse authenticate(String username, String password) {
        LoginResponse response = new LoginResponse();
        
        UserSecurity userSecurity = userSecurityService.getUserSecurity(username);
        
        if (userSecurity != null) {
            boolean authenticated = isAuthenitcated(userSecurity, username, password);
            response.setValid(authenticated);
            
            if (!authenticated) {
                incrementFailedLoginAttempts(userSecurity);
            } else {
                userSecurity.setFailedLoginAttempts(0);
                UserDetails userDetails = userDetailsService.getUser(username);
                response.setUserDetails(userDetails);
            }
            
            userSecurityService.saveUserSecurity(userSecurity);
            
        }
        
        return response;
    }
    
    private boolean isAuthenitcated(UserSecurity userSecurity, String userId, String password) {
        return (userSecurity.getPassword().equals(password) && (userSecurity.getFailedLoginAttempts() == null || MAX_LOGIN_FAILED_LOGIN_ATTEMPTS >= userSecurity.getFailedLoginAttempts()));
    }
    
    private void incrementFailedLoginAttempts(UserSecurity userSecurity) {
        int failedAttempts = userSecurity.getFailedLoginAttempts() + 1;
        userSecurity.setFailedLoginAttempts(failedAttempts);
    }
}

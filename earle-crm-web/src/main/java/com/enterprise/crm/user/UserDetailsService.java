/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.enterprise.crm.user;

import com.enterprise.crm.common.CrudService;
import com.enterprise.crm.common.QueryParameters;
import com.enterprise.crm.insured.InsuredDetails;
import java.util.List;
import javax.enterprise.inject.Default;
import javax.inject.Inject;
import javax.inject.Named;

/**
 *
 * @author user
 */
@Named
@Default
public class UserDetailsService {
    private static final long serialVersionUID = 1L;
    @Inject
    CrudService crudService;

    public List<UserDetails> getAllUsers() {
        return crudService.findWithNamedQuery("UserDetails.findAll");
    }
    
    public UserDetails getUser(String username) {
        return crudService.findUniqueWithNamedQuery("UserDetails.findByUserId", QueryParameters.withParameters("userName", username));
    }
    
    public void save(UserDetails user) {
        crudService.update(user);     
    }
    
    public void delete(UserDetails user) {
        UserDetails userToDelete = crudService.find(UserDetails.class, user.getId());                
        crudService.delete(userToDelete);
    }
    
    public void add(String userName, String forename, String surname, boolean partner) {
        UserDetails user = new UserDetails();
        user.setUserName(userName);
        user.setForename(forename);
        user.setSurname(surname); 
        user.setPartner(partner);
       
        crudService.create(user);
    }
    
}
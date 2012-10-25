/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.enterprise.crm.login;

import com.enterprise.crm.common.CrudService;
import com.enterprise.crm.common.QueryParameters;
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
public class UserSecurityService implements Serializable {

    @Inject
    CrudService crudService;
    private static final long serialVersionUID = 1L;

    public void saveUserSecurity(UserSecurity userSecurity) {
        crudService.update(userSecurity);
    }

    public UserSecurity getUserSecurity(String userId) {
        return crudService.findUniqueWithNamedQuery("UserSecurity.findByUserName", QueryParameters.withParameters("userName", userId));
    }
}

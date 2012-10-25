/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.enterprise.crm.messaging;

import com.enterprise.crm.common.CrudService;
import com.enterprise.crm.common.QueryParameters;
import java.util.Date;
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
public class MessageService {
    private static final long serialVersionUID = 1L;
    @Inject
    CrudService crudService;

    /**public List<Messages> messageService.loadMessagesForUser(UserContent.getId()) {
        return crudService.findWithNamedQuery("Messages.findByIdTo", QueryParameters.withParameters("idto", UserContent.getId()));
    }*/
    
    public List<Messages> getMessagesByUserName(String username) {
        return crudService.findWithNamedQuery("Messages.findByIdTo",QueryParameters.withParameters("idto", username));
    }
    
    public void save(Messages message) {
        crudService.update(message);     
    }
    
    public void delete(Messages message) {
        Messages messageToDelete = crudService.find(Messages.class, message.getId());        
        crudService.delete(messageToDelete);
    }
    
    public void add(String idfrom, String idto, Date datesent, Date dateread, String message1) {
        Messages message = new Messages();
        message.setIdFrom(idfrom);
        message.setIdTo(idto);        
        message.setDateSent(datesent);
        message.setDateRead(dateread);
        message.setMessage(message1);
       
        crudService.create(message);
    }
    
}
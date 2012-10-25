/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.enterprise.crm.insured;

import com.enterprise.crm.common.CrudService;
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
public class InsuredService {
    private static final long serialVersionUID = 1L;
    @Inject
    CrudService crudService;

    public List<InsuredDetails> getAllInsureds() {
        return crudService.findWithNamedQuery("InsuredDetails.findAll");
    }
    
    public void save(InsuredDetails insured) {
        crudService.update(insured);     
    }
    
    public void delete(InsuredDetails insured) {
        InsuredDetails insuredToDelete = crudService.find(InsuredDetails.class, insured.getId());        
        crudService.delete(insuredToDelete);
    }
    
    public void add(Long id, String name, String address1, String address2, String address3, String address4, String postcode, String contacts) {
        InsuredDetails insured = new InsuredDetails();
        insured.setName(name);
        insured.setAddress1(address1);
        insured.setAddress2(address2);
        insured.setAddress3(address3);
        insured.setAddress4(address4);        
        insured.setPostcode(postcode);        
        insured.setContacts(contacts);
        crudService.create(insured);
    }
    
}
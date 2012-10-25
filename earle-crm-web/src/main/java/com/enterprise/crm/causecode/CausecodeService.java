/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.enterprise.crm.causecode;

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
public class CausecodeService {
    private static final long serialVersionUID = 1L;
    @Inject
    CrudService crudService;

    public List<Causecode> getAllCausecodes() {
        return crudService.findWithNamedQuery("Causecode.findAll");
    }
    
    public void save(Causecode causecode) {
        crudService.update(causecode);     
    }
    
    public void delete(Causecode causecode) {
       Causecode causecodeToDelete = crudService.find(Causecode.class, causecode.getId());                
        crudService.delete(causecodeToDelete);
    }
    
    public void add(Long id, String description) {
        Causecode causecode = new Causecode();
        causecode.setId(id);
        causecode.setDescription(description);
        
        crudService.create(causecode);
    }
    
}
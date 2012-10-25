/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.enterprise.crm.subcause;

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
public class SubcauseService {
    private static final long serialVersionUID = 1L;
    @Inject
    CrudService crudService;

    public List<Subcause> getAllSubcauses() {
        return crudService.findWithNamedQuery("Subcause.findAll");
    }
    
    public void save(Subcause subcause) {
        crudService.update(subcause);     
    }
    
    public void delete(Subcause subcause) {
        Subcause subcauseToDelete = crudService.find(Subcause.class, subcause.getId());                
        crudService.delete(subcauseToDelete);
    }
    
    public void add(Long id, String description) {
        Subcause subcause = new Subcause();
        subcause.setId(id);
        subcause.setDescription(description);
        
        crudService.create(subcause);
    }
    
}
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.enterprise.crm.practice;

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
public class PracticeService {
    private static final long serialVersionUID = 1L;
    @Inject
    CrudService crudService;

    public List<Practice> getAllPractices() {
        return crudService.findWithNamedQuery("Practice.findAll");
    }
    
    public void save(Practice practice) {
        crudService.update(practice);     
    }
    
    public void delete(Practice practice) {
        Practice practiceToDelete = crudService.find(Practice.class, practice.getId());
        crudService.delete(practiceToDelete);
    }
    
    public void add(Long id, String description) {
        Practice practice = new Practice();
        practice.setId(id);
        practice.setDescription(description);
        
        crudService.create(practice);
    }
    
}
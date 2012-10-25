/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.enterprise.crm.profession;

import com.enterprise.crm.common.CrudService;
import java.util.List;
import javax.ejb.Stateful;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;

/**
 *
 * @author user
 */
@Named
@Stateful
@SessionScoped
public class ProfessionService {

    private static final long serialVersionUID = 1L;
    @Inject
    CrudService crudService;

    public List<Profession> getAllProfessions() {
        return crudService.findWithNamedQuery("Profession.findAll");
    }

    public List<Profession> getProfessionsByDescription() {
        return crudService.findWithNamedQuery("Profession.findByDescription");
    }
    
    public List<Profession> getProfessionsById() {
        return crudService.findWithNamedQuery("Profession.findById");
    }

    public void save(Profession profession) {
        crudService.update(profession);
    }
    public void delete(Profession profession) {
        Profession professionToDelete = crudService.find(Profession.class, profession.getId());
        crudService.delete(professionToDelete);
    }

    public void add(Long id, String description) {
        Profession profession = new Profession();
        profession.setId(id);
        profession.setDescription(description);
        crudService.create(profession);
    }
}
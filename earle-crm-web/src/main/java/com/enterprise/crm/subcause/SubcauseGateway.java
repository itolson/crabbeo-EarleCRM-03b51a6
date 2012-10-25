package com.enterprise.crm.subcause;

import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.Stateful;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;

/**
 *
 * @author iantolson
 */
@Named
@Stateful
@SessionScoped
public class SubcauseGateway {

    @Inject
    transient SubcauseService subcauseService;
    private Subcause onRowSelect;
    private List<Subcause> subcauses;
    private Subcause selectedSubcause;
    private Long subcauseId;
    private String subcauseDescription;

    @PostConstruct
    public void initializeSubcause() {
        subcauses = subcauseService.getAllSubcauses();
    }

    public Subcause getSelectedSubcause() {
        return selectedSubcause;
    }

    public void setSelectedSubcause(Subcause selectedSubcause) {
        this.selectedSubcause = selectedSubcause;
    }

    public List<Subcause> getSubcauses() {
        return subcauses;
    }

    public void setSubcauses(List<Subcause> subcauses) {
        this.subcauses = subcauses;
    }

    public Long getSubcauseId() {
        return subcauseId;
    }

    public void setSubcauseId(Long subcauseId) {
        this.subcauseId = subcauseId;
    }

    public String getSubcauseDescription() {
        return subcauseDescription;
    }

    public void setSubcauseDescription(String subcauseDescription) {
        this.subcauseDescription = subcauseDescription;
    }

    public void save() {
        subcauseService.save(selectedSubcause);
    }

    public void delete() {
        subcauseService.delete(selectedSubcause);
        //Refresh the subcauses list
        initializeSubcause();

    }

    public void add() {
        subcauseService.add(subcauseId, subcauseDescription);
        //Reset the values
        subcauseId = null;
        subcauseDescription = null;

        //Refresh the subcauses list
        initializeSubcause();
    }
}

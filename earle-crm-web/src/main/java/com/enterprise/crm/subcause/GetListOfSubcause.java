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
public class GetListOfSubcause {

    @Inject
    transient SubcauseService subcauseService;
    private Subcause selectedSubcause;
    private List<Subcause> subcauses;
    private String subcauseId;
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

    public String getSubcauseId() {
        return subcauseId;
    }

    public void setSubcauseId(String subcauseId) {
        this.subcauseId = subcauseId;
    }

    public String getSubcauseDescription() {
        return subcauseDescription;
    }

    public void setSubcauseDescription(String subcauseDescription) {
        this.subcauseDescription = subcauseDescription;
    }
}

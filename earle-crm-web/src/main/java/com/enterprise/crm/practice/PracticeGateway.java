package com.enterprise.crm.practice;

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
public class PracticeGateway {

    @Inject
    transient PracticeService practiceService;
    private Practice selectedPractice;
    private Practice onRowSelect;
    private List<Practice> practices;
    private Long practiceId;
    private String practiceDescription;

    @PostConstruct
    public void initializePractice() {
        practices = practiceService.getAllPractices();
    }

    public Practice getOnRowSelect() {
        return onRowSelect;
    }

    public void setOnRowSelect(Practice onRowSelect) {
        this.onRowSelect = onRowSelect;
    }

    public String getPracticeDescription() {
        return practiceDescription;
    }

    public void setPracticeDescription(String practiceDescription) {
        this.practiceDescription = practiceDescription;
    }

    public Long getPracticeId() {
        return practiceId;
    }

    public void setPracticeId(Long practiceId) {
        this.practiceId = practiceId;
    }

    public PracticeService getPracticeService() {
        return practiceService;
    }

    public void setPracticeService(PracticeService practiceService) {
        this.practiceService = practiceService;
    }

    public List<Practice> getPractices() {
        return practices;
    }

    public void setPractices(List<Practice> practices) {
        this.practices = practices;
    }

    public Practice getSelectedPractice() {
        return selectedPractice;
    }

    public void setSelectedPractice(Practice selectedPractice) {
        this.selectedPractice = selectedPractice;
    }

    
    public void save() {
        practiceService.save(selectedPractice);
        initializePractice();
    }

    public void delete() {
        practiceService.delete(selectedPractice);
        //Refresh the practices list
        initializePractice();

    }

    public void add() {
        practiceService.add(practiceId, practiceDescription);
        //Reset the values
        practiceId = null;
        practiceDescription = null;

        //Refresh the practices list
        initializePractice();
    }
}

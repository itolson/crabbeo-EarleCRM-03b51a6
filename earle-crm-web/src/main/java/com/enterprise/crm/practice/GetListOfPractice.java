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
public class GetListOfPractice {

    @Inject
    transient PracticeService practiceService;
    private Practice selectedPractice;
    private List<Practice> practices;
    private String practiceId;
    private String practiceDescription;

    @PostConstruct
    public void initializePractice() {
        practices = practiceService.getAllPractices();
    }

    public Practice getSelectedPractice() {
        return selectedPractice;
    }

    public void setSelectedPractice(Practice selectedPractice) {
        this.selectedPractice = selectedPractice;
    }

    public List<Practice> getPractices() {
        return practices;
    }

    public void setPractices(List<Practice> practices) {
        this.practices = practices;
    }

    public String getPracticeId() {
        return practiceId;
    }

    public void setPracticeId(String practiceId) {
        this.practiceId = practiceId;
    }

    public String getPracticeDescription() {
        return practiceDescription;
    }

    public void setPracticeDescription(String practiceDescription) {
        this.practiceDescription = practiceDescription;
    }
}

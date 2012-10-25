package com.enterprise.crm.newclaim;

import com.enterprise.crm.login.UserContent;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.Stateful;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;

/**
 *
 * @author jamescrabbe
 */
@Named
@Stateful
@SessionScoped
public class GetListOfClaimsDetails {

    @Inject
    transient ClaimsDetailsService claimsdetailsService;
    @Inject
    transient UserContent userContent;    
    
    private ClaimsDetails selectedClaimsDetails;
    private List<ClaimsDetails> claimsdetails;
    private String diaryId;
    private String diaryDescription;

    @PostConstruct
    public void initializeClaimsDetails() {
        String username = userContent.getLoggedInUser().getUserName();
        claimsdetails = claimsdetailsService.getAllClaims();        
    }

    public ClaimsDetails getSelectedClaimsDetails() {
        return selectedClaimsDetails;
    }

    public void setSelectedClaimsDetails(ClaimsDetails selectedClaimsDetails) {
        this.selectedClaimsDetails = selectedClaimsDetails;
    }

    public List<ClaimsDetails> getClaimsDetailss() {
        return claimsdetails;
    }

    public void setClaimsDetailss(List<ClaimsDetails> claimsdetails) {
        this.claimsdetails = claimsdetails;
    }

    public String getClaimsDetailsId() {
        return diaryId;
    }

    public void setClaimsDetailsId(String diaryId) {
        this.diaryId = diaryId;
    }

    public String getClaimsDetailsDescription() {
        return diaryDescription;
    }

    public void setClaimsDetailsDescription(String diaryDescription) {
        this.diaryDescription = diaryDescription;
    }
}

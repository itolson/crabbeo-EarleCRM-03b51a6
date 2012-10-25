package com.enterprise.crm.workbook;

import java.util.Date;
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
public class ClaimsworkbookGateway {

    @Inject
    transient ClaimsworkbookService claimsworkbookService;
    private Claimsworkbook selectedClaimsworkbook;
    private List<Claimsworkbook> claimsworkbooks;
    private Long claimsworkbookId;
    private String claimNo;
    private Date claimsworkbookclaimDate;
    private String claimsworkbookclaimUpdate;

    @PostConstruct
    public void initializeClaimsworkbook() {
        claimsworkbooks =claimsworkbookService.getAllClaimsworkbooks();
    }

    public Claimsworkbook getSelectedClaimsworkbook() {
        return selectedClaimsworkbook;
    }

    public void setSelectedClaimsworkbook(Claimsworkbook selectedClaimsworkbook) {
        this.selectedClaimsworkbook = selectedClaimsworkbook;
    }

    public List<Claimsworkbook> getClaimsworkbooks() {
        return claimsworkbooks;
    }

    public void setClaimsworkbooks(List<Claimsworkbook> claimsworkbooks) {
        this.claimsworkbooks = claimsworkbooks;
    }

    public String getClaimNo() {
        return claimNo;
    }

    public void setClaimNo(String claimNo) {
        this.claimNo = claimNo;
    }

    public Long getClaimsworkbookId() {
        return claimsworkbookId;
    }

    public void setClaimsworkbookId(Long claimsworkbookId) {
        this.claimsworkbookId = claimsworkbookId;
    }

    public Date getClaimsworkbookclaimDate() {
        return claimsworkbookclaimDate;
    }

    public void setClaimsworkbookclaimDate(Date claimsworkbookclaimDate) {
        this.claimsworkbookclaimDate = claimsworkbookclaimDate;
    }

    public String getClaimsworkbookclaimUpdate() {
        return claimsworkbookclaimUpdate;
    }

    public void setClaimsworkbookclaimUpdate(String claimsworkbookclaimUpdate) {
        this.claimsworkbookclaimUpdate = claimsworkbookclaimUpdate;
    }


    public ClaimsworkbookService getClaimsworkbookService() {
        return claimsworkbookService;
    }

    public void setClaimsworkbookService(ClaimsworkbookService claimsworkbookService) {
        this.claimsworkbookService = claimsworkbookService;
    }

    public void save() {
        claimsworkbookService.save(selectedClaimsworkbook);
    }

    public void delete() {
        claimsworkbookService.delete(selectedClaimsworkbook);
        //Refresh the User list
        initializeClaimsworkbook();

    }

    public void add() {
        claimsworkbookService.add(claimsworkbookId, claimNo, claimsworkbookclaimDate, claimsworkbookclaimUpdate);
        //Reset the values
        claimsworkbookId = null;
        claimsworkbookclaimDate = null;
        claimsworkbookclaimUpdate = null;


        //Refresh the USer list
        initializeClaimsworkbook();
    }
}

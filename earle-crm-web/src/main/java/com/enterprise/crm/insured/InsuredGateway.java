package com.enterprise.crm.insured;

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
public class InsuredGateway {

    @Inject
    transient InsuredService insuredService;
    private InsuredDetails selectedInsured;
    private List<InsuredDetails> insureds;
    private Long insuredId;
    private String insuredName;
    private String insuredAddress1;
    private String insuredAddress2;
    private String insuredAddress3;
    private String insuredAddress4;
    private String insuredPostcode;
    private String insuredContacts;

    @PostConstruct
    public void initializeInsured() {
        insureds = insuredService.getAllInsureds();
    }

    public InsuredDetails getSelectedInsured() {
        return selectedInsured;
    }

    public void setSelectedInsured(InsuredDetails selectedInsured) {
        this.selectedInsured = selectedInsured;
    }

    public List<InsuredDetails> getInsureds() {
        return insureds;
    }

    public void setInsureds(List<InsuredDetails> insureds) {
        this.insureds = insureds;
    }

    public String getInsuredAddress1() {
        return insuredAddress1;
    }

    public void setInsuredAddress1(String insuredAddress1) {
        this.insuredAddress1 = insuredAddress1;
    }

    public String getInsuredAddress2() {
        return insuredAddress2;
    }

    public void setInsuredAddress2(String insuredAddress2) {
        this.insuredAddress2 = insuredAddress2;
    }

    public String getInsuredAddress3() {
        return insuredAddress3;
    }

    public void setInsuredAddress3(String insuredAddress3) {
        this.insuredAddress3 = insuredAddress3;
    }

    public String getInsuredAddress4() {
        return insuredAddress4;
    }

    public void setInsuredAddress4(String insuredAddress4) {
        this.insuredAddress4 = insuredAddress4;
    }

    public Long getInsuredId() {
        return insuredId;
    }

    public void setInsuredId(Long insuredId) {
        this.insuredId = insuredId;
    }

    public String getInsuredName() {
        return insuredName;
    }

    public void setInsuredName(String insuredName) {
        this.insuredName = insuredName;
    }

    public String getInsuredPostcode() {
        return insuredPostcode;
    }

    public void setInsuredPostcode(String insuredPostcode) {
        this.insuredPostcode = insuredPostcode;
    }

    public InsuredService getInsuredService() {
        return insuredService;
    }

    public void setInsuredService(InsuredService insuredService) {
        this.insuredService = insuredService;
    }

    public void save() {
        insuredService.save(selectedInsured);
    }

    public void delete() {
        insuredService.delete(selectedInsured);
        //Refresh the User list
        initializeInsured();

    }

    public void add() {
        insuredService.add(insuredId, insuredName, insuredAddress1, insuredAddress2, insuredAddress3, insuredAddress4, insuredPostcode, insuredContacts);

        //Reset the values
        insuredId = null;
        insuredName = null;
        insuredAddress1 = null;
        insuredAddress2 = null;
        insuredAddress3 = null;
        insuredAddress4 = null;
        insuredPostcode = null;        

        insuredContacts = null;


        //Refresh the USer list
        initializeInsured();
    }
}

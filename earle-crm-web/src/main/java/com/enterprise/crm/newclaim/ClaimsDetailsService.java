/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.enterprise.crm.newclaim;

import com.enterprise.crm.common.CrudService;
import java.math.BigDecimal;
import java.util.Date;
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
public class ClaimsDetailsService {
    private static final long serialVersionUID = 1L;
    @Inject
    CrudService crudService;

    public List<ClaimsDetails> getAllClaims() {
        return crudService.findWithNamedQuery("ClaimsDetails.findAll");
    }
    
    public void save(ClaimsDetails claimsdetails) {
        crudService.update(claimsdetails);     
    }
    
    public void delete(ClaimsDetails claimsdetails) {
        ClaimsDetails claimToDelete = crudService.find(ClaimsDetails.class, claimsdetails.getId());                
        crudService.delete(claimToDelete);
    }
    
    public void add(Long ID, String claimRef, Long feeEarner, Long partner, String insuredRef, Long insured, String policyNumber, Date yearOfAccount, 
            String leadFollow, Long insuredLine, String claimant, String claimantSolicitors, Long broker, String brokerRef, Long profession, Long areaOfPractice,
            Long causeCode, Long subCause, Date dateReceived, BigDecimal initialCaseEstimate, BigDecimal caseEstimateIndemnity, BigDecimal indemnityPayments, 
            BigDecimal claimantCostsEstimate, BigDecimal claimantCostsPaid, BigDecimal totalIncurred, BigDecimal mpl, String claimCircumstance, Date dateSettled,
            Date papLetterServed, Date papResponseDue, Date papResponseSent, boolean fraud, Date fileOpenDate, Date fileClosedDate, String detailsOfLoss, String currentPosition,
            String reasonForRemovalFromDA) {
        ClaimsDetails claimsdetails = new ClaimsDetails();
        claimsdetails.setId(ID);
        claimsdetails.setClaimRef(claimRef);
        claimsdetails.setFeeEarner(feeEarner);
        claimsdetails.setPartner(partner);
        claimsdetails.setInsuredRef(insuredRef);
        claimsdetails.setInsured(insured);
        claimsdetails.setPolicyNumber(policyNumber);
        claimsdetails.setYearOfAccount(yearOfAccount);
        claimsdetails.setLeadFollow(leadFollow);
        claimsdetails.setInsuredLine(insuredLine);
        claimsdetails.setClaimant(claimant);
        claimsdetails.setClaimantSolicitors(claimantSolicitors);
        claimsdetails.setBroker(broker);
        claimsdetails.setBrokerRef(brokerRef);
        claimsdetails.setProfession(profession);
        claimsdetails.setAreaOfPractice(areaOfPractice);
        claimsdetails.setCauseCode(causeCode);
        claimsdetails.setSubCause(subCause);
        claimsdetails.setDateReceived(dateReceived);
        claimsdetails.setInitialCaseEstimate(initialCaseEstimate);
        claimsdetails.setCaseEstimateIndemnity(caseEstimateIndemnity);
        claimsdetails.setIndemnityPayments(indemnityPayments);
        claimsdetails.setClaimantCostsEstimate(claimantCostsEstimate);
        claimsdetails.setClaimantCostsPaid(claimantCostsPaid);
        claimsdetails.setTotalIncurred(totalIncurred);
        claimsdetails.setMpl(mpl);
        claimsdetails.setClaimCircumstance(claimCircumstance);
        claimsdetails.setDateSettled(dateSettled);
        claimsdetails.setPapLetterServed(papLetterServed);
        claimsdetails.setPapResponseDue(papResponseDue);
        claimsdetails.setPapResponseSent(papResponseSent);
        claimsdetails.setFraud(fraud);
        claimsdetails.setFileOpenDate(fileOpenDate);        
        claimsdetails.setFileClosedDate(fileClosedDate);
        claimsdetails.setDetailsOfLoss(detailsOfLoss);
        claimsdetails.setCurrentPosition(currentPosition);
        claimsdetails.setReasonForRemovalFromDA(reasonForRemovalFromDA);
        crudService.create(claimsdetails);
    }
}
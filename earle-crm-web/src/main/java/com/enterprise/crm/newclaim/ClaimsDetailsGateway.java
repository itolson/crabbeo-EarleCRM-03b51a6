package com.enterprise.crm.newclaim;

import com.enterprise.crm.login.UserContent;
import java.math.BigDecimal;
import java.sql.Time;
import java.util.Date;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.Stateful;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;

/**
 *
 * @author Ian Tolson
 */
@Named
@Stateful
@SessionScoped
public class ClaimsDetailsGateway {
    
    @Inject
    transient ClaimsDetailsService claimsdetailsService;

    @Inject
    transient UserContent userContent;

    
    private ClaimsDetails selectedClaimsDetails;
    private ClaimsDetails onRowSelect;
    private List<ClaimsDetails> claimdetails;
    private Long Id;
    private String claimRef;
    private Long feeEarner;
    private Long partner;    
    private String insuredRef;
    private Long insured;
    private String policyNumber;
    private Date yearOfAccount;
    private String leadFollow;
    private Long insuredLine;
    private String claimant;
    private String claimantSolicitors;
    private Long broker;
    private String brokerRef;
    private Long profession;
    private Long areaOfPractice;
    private Long causeCode;
    private Long subCause;
    private Date dateReceived;
    private BigDecimal initialCaseEstimate;
    private BigDecimal caseEstimateIndemnity;
    private BigDecimal indemnityPayments;
    private BigDecimal claimantCostsEstimate;
    private BigDecimal claimantCostsPaid;
    private BigDecimal totalIncurred;
    private BigDecimal mpl;
    private String claimCircumstance;
    private Date dateSettled;
    private Date papLetterServed;
    private Date papResponseDue;
    private Date papResponseSent;
    private boolean fraud;
    private Date fileOpenDate;
    private Date fileClosedDate;
    private String detailsOfLoss;
    private String currentPosition;
    private String reasonForRemovalFromDA;
    
    @PostConstruct
    public void initializeClaimsDetails() {
        String username = userContent.getLoggedInUser().getUserName();
        claimdetails = claimsdetailsService.getAllClaims();
    }

    public Long getId() {
        return Id;
    }

    public void setId(Long Id) {
        this.Id = Id;
    }

    public Long getBroker() {
        return broker;
    }

    public void setBroker(Long broker) {
        this.broker = broker;
    }

    public Long getProfession() {
        return profession;
    }

    public void setProfession(Long profession) {
        this.profession = profession;
    }

    public Long getAreaOfPractice() {
        return areaOfPractice;
    }

    public void setAreaOfPractice(Long areaOfPractice) {
        this.areaOfPractice = areaOfPractice;
    }

    public String getBrokerRef() {
        return brokerRef;
    }

    public void setBrokerRef(String brokerRef) {
        this.brokerRef = brokerRef;
    }

    public BigDecimal getCaseEstimateIndemnity() {
        return caseEstimateIndemnity;
    }

    public void setCaseEstimateIndemnity(BigDecimal caseEstimateIndemnity) {
        this.caseEstimateIndemnity = caseEstimateIndemnity;
    }

    public long getCauseCode() {
        return causeCode;
    }

    public void setCauseCode(long causeCode) {
        this.causeCode = causeCode;
    }

    public String getClaimCircumstance() { 
        return claimCircumstance;
    }

    public void setClaimCircumstance(String claimCircumstance) {
        this.claimCircumstance = claimCircumstance;
    }

    public String getClaimRef() {
        return claimRef;
    }

    public void setClaimRef(String claimRef) {
        this.claimRef = claimRef;
    }

    public BigDecimal getClaimantCostsEstimate() {
        return claimantCostsEstimate;
    }

    public void setClaimantCostsEstimate(BigDecimal claimantCostsEstimate) {
        this.claimantCostsEstimate = claimantCostsEstimate;
    }

    public BigDecimal getClaimantCostsPaid() {
        return claimantCostsPaid;
    }

    public void setClaimantCostsPaid(BigDecimal claimantCostsPaid) {
        this.claimantCostsPaid = claimantCostsPaid;
    }

    public List<ClaimsDetails> getClaimdetails() {
        return claimdetails;
    }

    public void setClaimdetails(List<ClaimsDetails> claimdetails) {
        this.claimdetails = claimdetails;
    }

    public String getClaimant() {
        return claimant;
    }

    public void setClaimant(String claimant) {
        this.claimant = claimant;
    }

    public String getClaimantSolicitors() {
        return claimantSolicitors;
    }

    public void setClaimantSolicitors(String claimantSolicitors) {
        this.claimantSolicitors = claimantSolicitors;
    }

    public void setCauseCode(Long causeCode) {
        this.causeCode = causeCode;
    }

    public String getCurrentPosition() {
        return currentPosition;
    }

    public void setCurrentPosition(String currentPosition) {
        this.currentPosition = currentPosition;
    }

    public Date getDateReceived() {
        return dateReceived;
    }

    public void setDateReceived(Date dateReceived) {
        this.dateReceived = dateReceived;
    }

    public Date getDateSettled() {
        return dateSettled;
    }

    public void setDateSettled(Date dateSettled) {
        this.dateSettled = dateSettled;
    }

    public String getDetailsOfLoss() {
        return detailsOfLoss;
    }

    public void setDetailsOfLoss(String detailsOfLoss) {
        this.detailsOfLoss = detailsOfLoss;
    }

    public Long getFeeEarner() {
        return feeEarner;
    }

    public void setFeeEarner(Long feeEarner) {
        this.feeEarner = feeEarner;
    }

    public Date getFileClosedDate() {
        return fileClosedDate;
    }

    public void setFileClosedDate(Date fileClosedDate) {
        this.fileClosedDate = fileClosedDate;
    }

    public Date getFileOpenDate() {
        return fileOpenDate;
    }

    public void setFileOpenDate(Date fileOpenDate) {
        this.fileOpenDate = fileOpenDate;
    }

    public boolean isFraud() {
        return fraud;
    }

    public void setFraud(boolean fraud) {
        this.fraud = fraud;
    }

    public BigDecimal getIndemnityPayments() {
        return indemnityPayments;
    }

    public void setIndemnityPayments(BigDecimal indemnityPayments) {
        this.indemnityPayments = indemnityPayments;
    }

    public BigDecimal getInitialCaseEstimate() {
        return initialCaseEstimate;
    }

    public void setInitialCaseEstimate(BigDecimal initialCaseEstimate) {
        this.initialCaseEstimate = initialCaseEstimate;
    }

    public Long getInsured() {
        return insured;
    }

    public void setInsured(Long insured) {
        this.insured = insured;
    }

    public Long getInsuredLine() {
        return insuredLine;
    }

    public void setInsuredLine(Long insuredLine) {
        this.insuredLine = insuredLine;
    }

    public String getInsuredRef() {
        return insuredRef;
    }

    public void setInsuredRef(String insuredRef) {
        this.insuredRef = insuredRef;
    }

    public String getLeadFollow() {
        return leadFollow;
    }

    public void setLeadFollow(String leadFollow) {
        this.leadFollow = leadFollow;
    }

    public BigDecimal getMpl() {
        return mpl;
    }

    public void setMpl(BigDecimal mpl) {
        this.mpl = mpl;
    }

    public Date getPapLetterServed() {
        return papLetterServed;
    }

    public void setPapLetterServed(Date papLetterServed) {
        this.papLetterServed = papLetterServed;
    }

    public Date getPapResponseDue() {
        return papResponseDue;
    }

    public void setPapResponseDue(Date papResponseDue) {
        this.papResponseDue = papResponseDue;
    }

    public Date getPapResponseSent() {
        return papResponseSent;
    }

    public void setPapResponseSent(Date papResponseSent) {
        this.papResponseSent = papResponseSent;
    }

    public Long getPartner() {
        return partner;
    }

    public void setPartner(Long partner) {
        this.partner = partner;
    }

    public String getPolicyNumber() {
        return policyNumber;
    }

    public void setPolicyNumber(String policyNumber) {
        this.policyNumber = policyNumber;
    }

    public String getReasonForRemovalFromDA() {
        return reasonForRemovalFromDA;
    }

    public void setReasonForRemovalFromDA(String reasonForRemovalFromDA) {
        this.reasonForRemovalFromDA = reasonForRemovalFromDA;
    }

    public Long getSubCause() {
        return subCause;
    }

    public void setSubCause(Long subCause) {
        this.subCause = subCause;
    }

    public BigDecimal getTotalIncurred() {
        return totalIncurred;
    }

    public void setTotalIncurred(BigDecimal totalIncurred) {
        this.totalIncurred = totalIncurred;
    }

    public UserContent getUserContent() {
        return userContent;
    }

    public void setUserContent(UserContent userContent) {
        this.userContent = userContent;
    }

    public Date getYearOfAccount() {
        return yearOfAccount;
    }

    public void setYearOfAccount(Date yearOfAccount) {
        this.yearOfAccount = yearOfAccount;
    }

    public ClaimsDetailsService getClaimsDetailsService() {
        return claimsdetailsService;
    }

    public void setClaimsDetailsService(ClaimsDetailsService claimsdetailsService) {
        this.claimsdetailsService = claimsdetailsService;
    }

    public List<ClaimsDetails> getClaimsDetails() {
        return claimdetails;
    }

    public void setClaimsDetailss(List<ClaimsDetails> claimdetails) {
        this.claimdetails = claimdetails;
    }

       public ClaimsDetails getOnRowSelect() {
        return onRowSelect;
    }

    public void setOnRowSelect(ClaimsDetails onRowSelect) {
        this.onRowSelect = onRowSelect;
    }

    public ClaimsDetails getSelectedClaimsDetails() {
        return selectedClaimsDetails;
    }

    public void setSelectedClaimsDetails(ClaimsDetails selectedClaimsDetails) {
        this.selectedClaimsDetails = selectedClaimsDetails;
    }

    public void save() {
        claimsdetailsService.save(selectedClaimsDetails);
    }

    public void delete() {
        claimsdetailsService.delete(selectedClaimsDetails);
        //Refresh the claimdetailss list
        initializeClaimsDetails();

    }

    public void add() {
        claimsdetailsService.add(Id, claimRef, feeEarner, partner, insuredRef, insured, policyNumber, yearOfAccount, leadFollow, insuredLine, claimant, claimantSolicitors, broker, brokerRef, profession,
                areaOfPractice, causeCode, subCause, dateReceived, initialCaseEstimate, caseEstimateIndemnity, indemnityPayments, claimantCostsEstimate, claimantCostsPaid, totalIncurred, mpl, claimCircumstance,
                dateSettled, papLetterServed, papResponseDue, papResponseSent, fraud, fileOpenDate, fileClosedDate, detailsOfLoss, currentPosition, reasonForRemovalFromDA);
        //Reset the values
        Id = null;
        claimRef = null;
        feeEarner = null;
        partner = null;
        insuredRef = null;
        policyNumber = null;
        yearOfAccount = null;
        leadFollow = null;
        insuredLine = null;
        claimant = null;
        claimantSolicitors = null;
        broker = null;
        brokerRef = null;
        profession = null;
        areaOfPractice = null;
        causeCode = null;
        subCause = null;
        dateReceived = null;
        initialCaseEstimate = null;
        caseEstimateIndemnity = null;
        indemnityPayments = null;
        claimantCostsEstimate = null;
        claimantCostsPaid = null;
        totalIncurred = null;
        mpl = null;
        claimCircumstance = null;
        dateSettled = null;
        papLetterServed = null;
        papResponseDue = null;
        fraud = false;
        fileOpenDate = null;
        fileClosedDate = null;
        detailsOfLoss = null;
        currentPosition = null;
        reasonForRemovalFromDA = null;        
        //Refresh the claimdetailss list
        initializeClaimsDetails();
    }
}

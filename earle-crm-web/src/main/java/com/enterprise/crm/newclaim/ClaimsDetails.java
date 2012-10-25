/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.enterprise.crm.newclaim;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author user
 */
@Entity
@Table(name = "claimsdetails")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ClaimsDetails.findAll", query = "SELECT c FROM ClaimsDetails c") ,
    @NamedQuery(name = "ClaimsDetails.findById", query = "SELECT c FROM ClaimsDetails c WHERE c.id = :id"),
    @NamedQuery(name = "ClaimsDetails.findByClaimRef", query = "SELECT c FROM ClaimsDetails c WHERE c.claimRef = :claimRef"),
    @NamedQuery(name = "ClaimsDetails.findByFeeEarner", query = "SELECT c FROM ClaimsDetails c WHERE c.feeEarner = :feeEarner"),
    @NamedQuery(name = "ClaimsDetails.findByPartner", query = "SELECT c FROM ClaimsDetails c WHERE c.partner = :partner"),
    @NamedQuery(name = "ClaimsDetails.findByInsuredRef", query = "SELECT c FROM ClaimsDetails c WHERE c.insuredRef = :insuredRef"),
    @NamedQuery(name = "ClaimsDetails.findByInsured", query = "SELECT c FROM ClaimsDetails c WHERE c.insured = :insured"),
    @NamedQuery(name = "ClaimsDetails.findByPolicyNumber", query = "SELECT c FROM ClaimsDetails c WHERE c.policyNumber = :policyNumber"),
    @NamedQuery(name = "ClaimsDetails.findByYearOfAccount", query = "SELECT c FROM ClaimsDetails c WHERE c.yearOfAccount = :yearOfAccount"),
    @NamedQuery(name = "ClaimsDetails.findByLeadFollow", query = "SELECT c FROM ClaimsDetails c WHERE c.leadFollow = :leadFollow"),
    @NamedQuery(name = "ClaimsDetails.findByInsuredLine", query = "SELECT c FROM ClaimsDetails c WHERE c.insuredLine = :insuredLine"),
    @NamedQuery(name = "ClaimsDetails.findByClaimant", query = "SELECT c FROM ClaimsDetails c WHERE c.claimant = :claimant"),
    @NamedQuery(name = "ClaimsDetails.findByClaimantSolicitors", query = "SELECT c FROM ClaimsDetails c WHERE c.claimantSolicitors = :claimantSolicitors"),
    @NamedQuery(name = "ClaimsDetails.findByBroker", query = "SELECT c FROM ClaimsDetails c WHERE c.broker = :broker"),
    @NamedQuery(name = "ClaimsDetails.findByBrokerRef", query = "SELECT c FROM ClaimsDetails c WHERE c.brokerRef = :brokerRef"),
    @NamedQuery(name = "ClaimsDetails.findByProfession", query = "SELECT c FROM ClaimsDetails c WHERE c.profession = :profession"),
    @NamedQuery(name = "ClaimsDetails.findByAreaOfPractice", query = "SELECT c FROM ClaimsDetails c WHERE c.areaOfPractice = :areaOfPractice"),
    @NamedQuery(name = "ClaimsDetails.findByCauseCode", query = "SELECT c FROM ClaimsDetails c WHERE c.causeCode = :causeCode"),
    @NamedQuery(name = "ClaimsDetails.findBySubCause", query = "SELECT c FROM ClaimsDetails c WHERE c.subCause = :subCause"),
    @NamedQuery(name = "ClaimsDetails.findByInitialCaseEstimate", query = "SELECT c FROM ClaimsDetails c WHERE c.initialCaseEstimate = :initialCaseEstimate"),
    @NamedQuery(name = "ClaimsDetails.findByCaseEstimateIndemnity", query = "SELECT c FROM ClaimsDetails c WHERE c.caseEstimateIndemnity = :caseEstimateIndemnity"),
    @NamedQuery(name = "ClaimsDetails.findByIndemnityPayments", query = "SELECT c FROM ClaimsDetails c WHERE c.indemnityPayments = :indemnityPayments"),
    @NamedQuery(name = "ClaimsDetails.findByClaimantCostsEstimate", query = "SELECT c FROM ClaimsDetails c WHERE c.claimantCostsEstimate = :claimantCostsEstimate"),
    @NamedQuery(name = "ClaimsDetails.findByClaimantCostsPaid", query = "SELECT c FROM ClaimsDetails c WHERE c.claimantCostsPaid = :claimantCostsPaid"),
    @NamedQuery(name = "ClaimsDetails.findByTotalIncurred", query = "SELECT c FROM ClaimsDetails c WHERE c.totalIncurred = :totalIncurred"),
    @NamedQuery(name = "ClaimsDetails.findByMpl", query = "SELECT c FROM ClaimsDetails c WHERE c.mpl = :mpl"),
    @NamedQuery(name = "ClaimsDetails.findByClaimCircumstance", query = "SELECT c FROM ClaimsDetails c WHERE c.claimCircumstance = :claimCircumstance"),
    @NamedQuery(name = "ClaimsDetails.findByDateSettled", query = "SELECT c FROM ClaimsDetails c WHERE c.dateSettled = :dateSettled"),
    @NamedQuery(name = "ClaimsDetails.findByPapLetterServed", query = "SELECT c FROM ClaimsDetails c WHERE c.papLetterServed = :papLetterServed"),
    @NamedQuery(name = "ClaimsDetails.findByPapResponseDue", query = "SELECT c FROM ClaimsDetails c WHERE c.papResponseDue = :papResponseDue"),
    @NamedQuery(name = "ClaimsDetails.findByPapResponseSent", query = "SELECT c FROM ClaimsDetails c WHERE c.papResponseSent = :papResponseSent"),
    @NamedQuery(name = "ClaimsDetails.findByFraud", query = "SELECT c FROM ClaimsDetails c WHERE c.fraud = :fraud"),
    @NamedQuery(name = "ClaimsDetails.findByFileOpenDate", query = "SELECT c FROM ClaimsDetails c WHERE c.fileOpenDate = :fileOpenDate"),
    @NamedQuery(name = "ClaimsDetails.findByFileClosedDate", query = "SELECT c FROM ClaimsDetails c WHERE c.fileClosedDate = :fileClosedDate"),
    @NamedQuery(name = "ClaimsDetails.findByDetailsOfLoss", query = "SELECT c FROM ClaimsDetails c WHERE c.detailsOfLoss = :detailsOfLoss"),
    @NamedQuery(name = "ClaimsDetails.findByCurrentPosition", query = "SELECT c FROM ClaimsDetails c WHERE c.currentPosition = :currentPosition"),
    @NamedQuery(name = "ClaimsDetails.findByReasonForRemovalFromDA", query = "SELECT c FROM ClaimsDetails c WHERE c.reasonForRemovalFromDA = :reasonForRemovalFromDA")})
public class ClaimsDetails implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID")
    private Long id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "claimRef")
    private String claimRef;
    @Column(name = "feeEarner")
    private Long feeEarner;
    @Column(name = "partner")
    private Long partner;
    @Size(max = 45)
    @Column(name = "insuredRef")
    private String insuredRef;
    @Column(name = "insured")
    private Long insured;
    @Size(max = 45)
    @Column(name = "policyNumber")
    private String policyNumber;
    @Column(name = "yearOfAccount")
    @Temporal(TemporalType.DATE)
    private Date yearOfAccount;
    @Size(max = 45)
    @Column(name = "leadFollow")
    private String leadFollow;
    @Column(name = "insuredLine")
    private Long insuredLine;
    @Size(max = 100)
    @Column(name = "claimant")
    private String claimant;
    @Size(max = 100)
    @Column(name = "claimantSolicitors")
    private String claimantSolicitors;
    @Size(max = 45)
    @Column(name = "broker")
    private Long broker;
    @Size(max = 45)
    @Column(name = "brokerRef")
    private String brokerRef;
    @Column(name = "profession")
    private Long profession;
    @Column(name = "areaOfPractice")
    private Long areaOfPractice;
    @Column(name = "causeCode")
    private Long causeCode;
    @Column(name = "subCause")
    private Long subCause;
    @Column(name = "dateReceived")
    @Temporal(TemporalType.DATE)
    private Date dateReceived;
    @Column(name = "initialCaseEstimate")
    private BigDecimal initialCaseEstimate;
    @Column(name = "caseEstimateIndemnity")
    private BigDecimal caseEstimateIndemnity;
    @Column(name = "indemnityPayments")
    private BigDecimal indemnityPayments;
    @Column(name = "claimantCostsEstimate")
    private BigDecimal claimantCostsEstimate;
    @Column(name = "claimantCostsPaid")
    private BigDecimal claimantCostsPaid;
    @Column(name = "totalIncurred")
    private BigDecimal totalIncurred;
    @Column(name = "mpl")
    private BigDecimal mpl;
    @Size(max = 20)
    @Column(name = "claimCircumstance")
    private String claimCircumstance;
    @Column(name = "dateSettled")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateSettled;
    @Column(name = "papLetterServed")
    @Temporal(TemporalType.TIMESTAMP)
    private Date papLetterServed;
    @Column(name = "papResponseDue")
    @Temporal(TemporalType.TIMESTAMP)
    private Date papResponseDue;
    @Column(name = "papResponseSent")
    @Temporal(TemporalType.TIMESTAMP)
    private Date papResponseSent;
    @Column(name = "fraud")
    private boolean fraud;
    @Column(name = "fileOpenDate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fileOpenDate;
    @Column(name = "fileClosedDate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fileClosedDate;
    @Size(max = 500)
    @Column(name = "detailsOfLoss")
    private String detailsOfLoss;
    @Size(max = 500)
    @Column(name = "currentPosition")
    private String currentPosition;
    @Size(max = 250)
    @Column(name = "reasonForRemovalFromDA")
    private String reasonForRemovalFromDA;

    public ClaimsDetails() {
    }

    public ClaimsDetails(Long id) {
        this.id = id;
    }

    public ClaimsDetails(Long id, String claimRef) {
        this.id = id;
        this.claimRef = claimRef;
    }

    public Long getAreaOfPractice() {
        return areaOfPractice;
    }

    public void setAreaOfPractice(Long areaOfPractice) {
        this.areaOfPractice = areaOfPractice;
    }

    public Long getBroker() {
        return broker;
    }

    public void setBroker(Long broker) {
        this.broker = broker;
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

    public Long getCauseCode() {
        return causeCode;
    }

    public void setCauseCode(Long causeCode) {
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

    public String getClaimant() {
        return claimant;
    }

    public void setClaimant(String claimant) {
        this.claimant = claimant;
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

    public String getClaimantSolicitors() {
        return claimantSolicitors;
    }

    public void setClaimantSolicitors(String claimantSolicitors) {
        this.claimantSolicitors = claimantSolicitors;
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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public Long getProfession() {
        return profession;
    }

    public void setProfession(Long profession) {
        this.profession = profession;
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

    public Date getYearOfAccount() {
        return yearOfAccount;
    }

    public void setYearOfAccount(Date yearOfAccount) {
        this.yearOfAccount = yearOfAccount;
    }

 

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ClaimsDetails)) {
            return false;
        }
        ClaimsDetails other = (ClaimsDetails) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.enterprise.crm.newclaim.ClaimsDetails[ id=" + id + " ]";
    }
    
}

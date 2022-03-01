package com.devglan.domain;


import org.hibernate.validator.constraints.NotBlank;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.math.BigInteger;

public class VoLoanApplication {
    private BigInteger uid;
  //  @NotNull(message = "Cbo Id cannot be null")
    private BigInteger cboId;
    //@NotNull(message = "Loan Application Id cannot be null")
    private BigInteger loanApplicationId;
    //@NotNull(message = "Member Id cannot be null")
    private BigInteger memId;
   // @NotNull(message = "Request Date cannot be null")
    private Long requestDate;
    private Integer loanFee;
    //@NotNull(message = "Amount Demand cannot be null")
    private Integer amtDemand;
    private Integer amtSanction;
    private Integer amtDisbursed;
    private Long approvalDate;
    private Long tentativeDate;
    private Integer loanProductId;
    private Integer loanSource;
    //@NotNull(message = "Loan Purpose cannot be null")
    private Integer loanPurpose;
    private Integer loanPeriod;
    //@NotNull(message = "Loan Request Meeting No cannot be null")
    private Integer loanRequestedMtgNo;
    //@NotBlank(message = "Loan Request Meeting Guid cannot be blank")
    //@Size(max=50,message="Loan Request Meeting Guid can be max of 50 chars long")
    private String loanRequestedMtgGuid;
    private Integer loanSanctionedMtgNo;
    //@Size(max=50,message="Loan Sanctioned Meeting Guid can be max of 50 chars long")
    private String loanSanctionedMtgGuid;
    private Long createdOn;
    //@Size(max=30,message="Created by can be max of 30 chars long")
    private String createdBy;
    private Long updatedOn;
    //@Size(max=30,message="Updated by can be max of 30 chars long")
    private String updatedBy;
    private Integer loanRequestPriority;

    public BigInteger getUid() {
        return uid;
    }

    public void setUid(BigInteger uid) {
        this.uid = uid;
    }

    public BigInteger getCboId() {
        return cboId;
    }

    public void setCboId(BigInteger cboId) {
        this.cboId = cboId;
    }

    public BigInteger getLoanApplicationId() {
        return loanApplicationId;
    }

    public void setLoanApplicationId(BigInteger loanApplicationId) {
        this.loanApplicationId = loanApplicationId;
    }

    public BigInteger getMemId() {
        return memId;
    }

    public void setMemId(BigInteger memId) {
        this.memId = memId;
    }

    public Long getRequestDate() {
        return requestDate;
    }

    public void setRequestDate(Long requestDate) {
        this.requestDate = requestDate;
    }

    public Integer getLoanFee() {
        return loanFee;
    }

    public void setLoanFee(Integer loanFee) {
        this.loanFee = loanFee;
    }

    public Integer getAmtDemand() {
        return amtDemand;
    }

    public void setAmtDemand(Integer amtDemand) {
        this.amtDemand = amtDemand;
    }

    public Integer getAmtSanction() {
        return amtSanction;
    }

    public void setAmtSanction(Integer amtSanction) {
        this.amtSanction = amtSanction;
    }

    public Integer getAmtDisbursed() {
        return amtDisbursed;
    }

    public void setAmtDisbursed(Integer amtDisbursed) {
        this.amtDisbursed = amtDisbursed;
    }

    public Long getApprovalDate() {
        return approvalDate;
    }

    public void setApprovalDate(Long approvalDate) {
        this.approvalDate = approvalDate;
    }

    public Long getTentativeDate() {
        return tentativeDate;
    }

    public void setTentativeDate(Long tentativeDate) {
        this.tentativeDate = tentativeDate;
    }

    public Integer getLoanProductId() {
        return loanProductId;
    }

    public void setLoanProductId(Integer loanProductId) {
        this.loanProductId = loanProductId;
    }

    public Integer getLoanSource() {
        return loanSource;
    }

    public void setLoanSource(Integer loanSource) {
        this.loanSource = loanSource;
    }

    public Integer getLoanPurpose() {
        return loanPurpose;
    }

    public void setLoanPurpose(Integer loanPurpose) {
        this.loanPurpose = loanPurpose;
    }

    public Integer getLoanPeriod() {
        return loanPeriod;
    }

    public void setLoanPeriod(Integer loanPeriod) {
        this.loanPeriod = loanPeriod;
    }

    public Integer getLoanRequestedMtgNo() {
        return loanRequestedMtgNo;
    }

    public void setLoanRequestedMtgNo(Integer loanRequestedMtgNo) {
        this.loanRequestedMtgNo = loanRequestedMtgNo;
    }

    public String getLoanRequestedMtgGuid() {
        return loanRequestedMtgGuid;
    }

    public void setLoanRequestedMtgGuid(String loanRequestedMtgGuid) {
        this.loanRequestedMtgGuid = loanRequestedMtgGuid;
    }

    public Integer getLoanSanctionedMtgNo() {
        return loanSanctionedMtgNo;
    }

    public void setLoanSanctionedMtgNo(Integer loanSanctionedMtgNo) {
        this.loanSanctionedMtgNo = loanSanctionedMtgNo;
    }

    public String getLoanSanctionedMtgGuid() {
        return loanSanctionedMtgGuid;
    }

    public void setLoanSanctionedMtgGuid(String loanSanctionedMtgGuid) {
        this.loanSanctionedMtgGuid = loanSanctionedMtgGuid;
    }

    public Long getCreatedOn() {
        return createdOn;
    }

    public void setCreatedOn(Long createdOn) {
        this.createdOn = createdOn;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    public Long getUpdatedOn() {
        return updatedOn;
    }

    public void setUpdatedOn(Long updatedOn) {
        this.updatedOn = updatedOn;
    }

    public String getUpdatedBy() {
        return updatedBy;
    }

    public void setUpdatedBy(String updatedBy) {
        this.updatedBy = updatedBy;
    }

	public Integer getLoanRequestPriority() {
		return loanRequestPriority;
	}

	public void setLoanRequestPriority(Integer loanRequestPriority) {
		this.loanRequestPriority = loanRequestPriority;
	}
    
}

package com.devglan.domain;

import org.hibernate.validator.constraints.NotBlank;

import javax.persistence.Column;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.math.BigInteger;

public class ShgMcp {
    private BigInteger uid;
    private BigInteger mcpId;
    private BigInteger cboId;
    private BigInteger memId;
    private Integer amtDemand;
    private Long tentativeDate;
    private Integer loanProductId;
    private Integer loanPurpose;
    private Integer loanPeriod;
    private Integer loanRequestedMtgNo;
    private String loanRequestedMtgGuid;
    private Integer loanSanctionedMtgNo;
    private String loanSanctionedMtgGuid;
    private Long createdOn;
    private String createdBy;
    private Long updatedOn;
    private String updatedBy;
    private Long requestDate;

    private Integer proposedEmiAmount;
    

    public BigInteger getCboId() {
        return cboId;
    }

    public void setCboId(BigInteger cboId) {
        this.cboId = cboId;
    }

    public BigInteger getMemId() {
        return memId;
    }

    public void setMemId(BigInteger memId) {
        this.memId = memId;
    }

    public Integer getAmtDemand() {
        return amtDemand;
    }

    public void setAmtDemand(Integer amtDemand) {
        this.amtDemand = amtDemand;
    }

    public Integer getLoanProductId() {
        return loanProductId;
    }

    public void setLoanProductId(Integer loanProductId) {
        this.loanProductId = loanProductId;
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

    public BigInteger getUid() {
        return uid;
    }

    public void setUid(BigInteger uid) {
        this.uid = uid;
    }



    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }


    public Long getTentativeDate() {
        return tentativeDate;
    }

    public void setTentativeDate(Long tentativeDate) {
        this.tentativeDate = tentativeDate;
    }

    public Long getCreatedOn() {
        return createdOn;
    }

    public void setCreatedOn(Long createdOn) {
        this.createdOn = createdOn;
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

	public BigInteger getMcpId() {
		return mcpId;
	}

	public void setMcpId(BigInteger mcpId) {
		this.mcpId = mcpId;
	}

	public Long getRequestDate() {
		return requestDate;
	}

	public void setRequestDate(Long requestDate) {
		this.requestDate = requestDate;
	}

    public Integer getProposedEmiAmount() {
        return proposedEmiAmount;
    }

    public void setProposedEmiAmount(Integer proposedEmiAmount) {
        this.proposedEmiAmount = proposedEmiAmount;
    }
}


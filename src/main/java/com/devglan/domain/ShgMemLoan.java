package com.devglan.domain;


import java.math.BigInteger;
import java.util.List;

import javax.persistence.Column;
import javax.validation.Valid;

public class ShgMemLoan {
    private BigInteger uid;
    private BigInteger cboId;
    private BigInteger loanApplicationId;
    private BigInteger memId;
    private Integer loanNo;

    private Long installmentDate;
    private Integer amount;
    private Integer loanPurpose;
    private Integer loanProductId;
    private Double interestRate;
    private Integer period;
    private Integer principalOverdue;
    private Integer interestOverdue;
    private Boolean completionFlag;
    private Integer loanType;
    private Integer loanSource;
    private Integer modePayment;
    private String bankCode;
    private String transactionNo;
    private Integer installmentFreq;
    private Integer moratoriumPeriod;
    private Long createdOn;
    private String createdBy;
    private Long updatedOn;
    private String updatedBy;
    
    private Integer originalLoanAmount;
    private Integer principalRepaid;
    private Integer interestRepaid;
    private Long disbursementDate;
    
  
    private Integer noOfLoans;
    private Double originalInterestRate;
    private Integer originalPeriod;
    private  Integer  rescheduleReason;


    @Valid
    private List<ShgMemLoanSchedule> shgMemberLoanScheduleList;

    private Integer mtgNo;
    private Long mtgDate;
    private String mtgGuid;

    public Integer getMtgNo() {
        return mtgNo;
    }

    public void setMtgNo(Integer mtgNo) {
        this.mtgNo = mtgNo;
    }

    public Long getMtgDate() {
        return mtgDate;
    }

    public void setMtgDate(Long mtgDate) {
        this.mtgDate = mtgDate;
    }

    public String getMtgGuid() {
        return mtgGuid;
    }

    public void setMtgGuid(String mtgGuid) {
        this.mtgGuid = mtgGuid;
    }

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

    public Integer getLoanNo() {
        return loanNo;
    }

    public void setLoanNo(Integer loanNo) {
        this.loanNo = loanNo;
    }

    public Long getInstallmentDate() {
        return installmentDate;
    }

    public void setInstallmentDate(Long installmentDate) {
        this.installmentDate = installmentDate;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    public Integer getLoanPurpose() {
        return loanPurpose;
    }

    public void setLoanPurpose(Integer loanPurpose) {
        this.loanPurpose = loanPurpose;
    }

    public Integer getLoanProductId() {
        return loanProductId;
    }

    public void setLoanProductId(Integer loanProductId) {
        this.loanProductId = loanProductId;
    }

    public Double getInterestRate() {
        return interestRate;
    }

    public void setInterestRate(Double interestRate) {
        this.interestRate = interestRate;
    }

    public Integer getPeriod() {
        return period;
    }

    public void setPeriod(Integer period) {
        this.period = period;
    }

    public Integer getPrincipalOverdue() {
        return principalOverdue;
    }

    public void setPrincipalOverdue(Integer principalOverdue) {
        this.principalOverdue = principalOverdue;
    }

    public Integer getInterestOverdue() {
        return interestOverdue;
    }

    public void setInterestOverdue(Integer interestOverdue) {
        this.interestOverdue = interestOverdue;
    }

    public Boolean getCompletionFlag() {
        return completionFlag;
    }

    public void setCompletionFlag(Boolean completionFlag) {
        this.completionFlag = completionFlag;
    }

    public Integer getLoanType() {
        return loanType;
    }

    public void setLoanType(Integer loanType) {
        this.loanType = loanType;
    }

    public Integer getLoanSource() {
        return loanSource;
    }

    public void setLoanSource(Integer loanSource) {
        this.loanSource = loanSource;
    }

    public Integer getModePayment() {
        return modePayment;
    }

    public void setModePayment(Integer modePayment) {
        this.modePayment = modePayment;
    }

    public String getBankCode() {
        return bankCode;
    }

    public void setBankCode(String bankCode) {
        this.bankCode = bankCode;
    }

    public String getTransactionNo() {
        return transactionNo;
    }

    public void setTransactionNo(String transactionNo) {
        this.transactionNo = transactionNo;
    }

    public Integer getInstallmentFreq() {
        return installmentFreq;
    }

    public void setInstallmentFreq(Integer installmentFreq) {
        this.installmentFreq = installmentFreq;
    }

    public Integer getMoratoriumPeriod() {
        return moratoriumPeriod;
    }

    public void setMoratoriumPeriod(Integer moratoriumPeriod) {
        this.moratoriumPeriod = moratoriumPeriod;
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

	public List<ShgMemLoanSchedule> getShgMemberLoanScheduleList() {
		return shgMemberLoanScheduleList;
	}

	public void setShgMemberLoanScheduleList(List<ShgMemLoanSchedule> shgMemberLoanScheduleList) {
		this.shgMemberLoanScheduleList = shgMemberLoanScheduleList;
	}

	public BigInteger getMemId() {
		return memId;
	}

	public void setMemId(BigInteger memId) {
		this.memId = memId;
	}

	public Integer getOriginalLoanAmount() {
		return originalLoanAmount;
	}

	public void setOriginalLoanAmount(Integer originalLoanAmount) {
		this.originalLoanAmount = originalLoanAmount;
	}

	public Integer getPrincipalRepaid() {
		return principalRepaid;
	}

	public void setPrincipalRepaid(Integer principalRepaid) {
		this.principalRepaid = principalRepaid;
	}

	public Integer getInterestRepaid() {
		return interestRepaid;
	}

	public void setInterestRepaid(Integer interestRepaid) {
		this.interestRepaid = interestRepaid;
	}

	public Long getDisbursementDate() {
		return disbursementDate;
	}

	public void setDisbursementDate(Long disbursementDate) {
		this.disbursementDate = disbursementDate;
	}

	public Integer getNoOfLoans() {
		return noOfLoans;
	}

	public void setNoOfLoans(Integer noOfLoans) {
		this.noOfLoans = noOfLoans;
	}

	public Double getOriginalInterestRate() {
		return originalInterestRate;
	}

	public void setOriginalInterestRate(Double originalInterestRate) {
		this.originalInterestRate = originalInterestRate;
	}

	public Integer getOriginalPeriod() {
		return originalPeriod;
	}

	public void setOriginalPeriod(Integer originalPeriod) {
		this.originalPeriod = originalPeriod;
	}

	public Integer getRescheduleReason() {
		return rescheduleReason;
	}

	public void setRescheduleReason(Integer rescheduleReason) {
		this.rescheduleReason = rescheduleReason;
	}
	
	
	

   
}

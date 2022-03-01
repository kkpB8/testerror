package com.devglan.domain;


import javax.persistence.Column;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.math.BigInteger;
import java.util.List;

public class VoMemLoan {
    private BigInteger uid;
    //@NotNull(message = "Cbo Id cannot be null")
    private BigInteger cboId;
    //@NotNull(message = "Loan Application Id cannot be null")
    private BigInteger loanApplicationId;
	//@Size(max=50,message="Meeting guid can be max of 50 chars long")
	private String mtgGuid;
    //@NotNull(message = "Member Id cannot be null")
    private BigInteger memId;
    //@NotNull(message = "Loan no cannot be null")
    private Integer loanNo;
	//@NotNull(message = "Meeting No cannot be null")
	private Integer mtgNo;
	private Long mtgDate;
    private Long installmentDate;
    private Integer amount;
    private Integer loanPurpose;
	private Integer fundType;
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
    //@Size(max=30,message="Created by can be max of 30 chars long")
    private String createdBy;
    private Long updatedOn;
   // @Size(max=30,message="Updated by can be max of 30 chars long")
    private String updatedBy;
	private BigInteger voMtgDetUid;
    private Integer originalLoanAmount;
    private Integer principalRepaid;
    private Integer interestRepaid;
    private Long disbursementDate;
    
  //@Anshul271121
    private Integer noOfLoans;
    private Double originalInterestRate;
    private Integer originalPeriod;
    private Integer rescheduleReason;

    private List<VoMemLoanSchedule> voMemberLoanScheduleList;
    
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

    public String getMtgGuid() {
        return mtgGuid;
    }

    public void setMtgGuid(String mtgGuid) {
        this.mtgGuid = mtgGuid;
    }

    public BigInteger getMemId() {
        return memId;
    }

    public void setMemId(BigInteger memId) {
        this.memId = memId;
    }

    public Integer getLoanNo() {
        return loanNo;
    }

    public void setLoanNo(Integer loanNo) {
        this.loanNo = loanNo;
    }

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

    public Integer getFundType() {
        return fundType;
    }

    public void setFundType(Integer fundType) {
        this.fundType = fundType;
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

    public BigInteger getVoMtgDetUid() {
        return voMtgDetUid;
    }

    public void setVoMtgDetUid(BigInteger voMtgDetUid) {
        this.voMtgDetUid = voMtgDetUid;
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

	public List<VoMemLoanSchedule> getVoMemberLoanScheduleList() {
		return voMemberLoanScheduleList;
	}

	public void setVoMemberLoanScheduleList(List<VoMemLoanSchedule> voMemberLoanScheduleList) {
		this.voMemberLoanScheduleList = voMemberLoanScheduleList;
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

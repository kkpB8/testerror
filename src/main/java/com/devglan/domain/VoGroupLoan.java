package com.devglan.domain;

import javax.persistence.Column;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.math.BigInteger;
import java.sql.Timestamp;
import java.util.List;

public class VoGroupLoan {
    private BigInteger uid;
    //@NotNull(message = "Cbo Id cannot be null")
    private BigInteger cboId;
    //@NotNull(message = "Loan Application Id cannot be null")
    private BigInteger loanApplicationId;
	//@Size(max=50,message="Meeting guid can be max of 50 chars long")
	private String mtgGuid;
    //@NotNull(message = "Loan No cannot be null")
    private Integer loanNo;
	//@NotNull(message = "Meeting No cannot be null")
	private Integer mtgNo;
	private Long mtgDate;
	private Long disbursementDate;
    private Long installmentDate;
	private Integer loanRefNo;
    private Integer amount;
    private Integer loanPurpose;
    private Integer loanProductId;
    private Double interestRate;
    private Integer period;
	private Integer principalOverdue;
	private Integer orignalLoanAmount;
	private Integer principalRepaid;
	private Integer interestDue;
	private Integer interestOverdue;
    private Boolean completionFlag;
    private Integer loanType;
    private Integer loanSource;
    private Integer externalLoanId;
    private Integer modePayment;
    private String bankCode;
    private String transactionNo;
    private Integer installmentFreq;
    private Integer moratoriumPeriod;
    private String loanAccountNo;
    private Integer repayTo;
    private Long createdOn;
	private Integer institution;
	private Integer organizationName;
	private Integer sanctionedAmount;
	private Integer drawingLimit;
   // @Size(max=30,message="Created by can be max of 30 chars long")
    private String createdBy;
    private Long updatedOn;
    //@Size(max=30,message="Updated by can be max of 30 chars long")
    private String updatedBy;
    
  //@Anshul271121
    private Integer overduePeriod;
    private Long actualTransactionDate;
    private Double originalInterestRate;
    private Integer originalPeriod;
    private Integer rescheduleReason;
    private  Integer  totalAmount;
    private  Integer  noOfLoan ;
    
    private List<VoGroupLoanSchedule> voGroupLoanScheduleList;

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

    public Long getDisbursementDate() {
        return disbursementDate;
    }

    public void setDisbursementDate(Long disbursementDate) {
        this.disbursementDate = disbursementDate;
    }

    public Long getInstallmentDate() {
        return installmentDate;
    }

    public void setInstallmentDate(Long installmentDate) {
        this.installmentDate = installmentDate;
    }

    public Integer getLoanRefNo() {
        return loanRefNo;
    }

    public void setLoanRefNo(Integer loanRefNo) {
        this.loanRefNo = loanRefNo;
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

    public Integer getOrignalLoanAmount() {
        return orignalLoanAmount;
    }

    public void setOrignalLoanAmount(Integer orignalLoanAmount) {
        this.orignalLoanAmount = orignalLoanAmount;
    }

    public Integer getPrincipalRepaid() {
        return principalRepaid;
    }

    public void setPrincipalRepaid(Integer principalRepaid) {
        this.principalRepaid = principalRepaid;
    }

    public Integer getInterestDue() {
        return interestDue;
    }

    public void setInterestDue(Integer interestDue) {
        this.interestDue = interestDue;
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

    public Integer getExternalLoanId() {
        return externalLoanId;
    }

    public void setExternalLoanId(Integer externalLoanId) {
        this.externalLoanId = externalLoanId;
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

    public String getLoanAccountNo() {
        return loanAccountNo;
    }

    public void setLoanAccountNo(String loanAccountNo) {
        this.loanAccountNo = loanAccountNo;
    }

    public Integer getRepayTo() {
        return repayTo;
    }

    public void setRepayTo(Integer repayTo) {
        this.repayTo = repayTo;
    }

    public Long getCreatedOn() {
        return createdOn;
    }

    public void setCreatedOn(Long createdOn) {
        this.createdOn = createdOn;
    }

    public Integer getInstitution() {
        return institution;
    }

    public void setInstitution(Integer institution) {
        this.institution = institution;
    }

    public Integer getOrganizationName() {
        return organizationName;
    }

    public void setOrganizationName(Integer organizationName) {
        this.organizationName = organizationName;
    }

    public Integer getSanctionedAmount() {
        return sanctionedAmount;
    }

    public void setSanctionedAmount(Integer sanctionedAmount) {
        this.sanctionedAmount = sanctionedAmount;
    }

    public Integer getDrawingLimit() {
        return drawingLimit;
    }

    public void setDrawingLimit(Integer drawingLimit) {
        this.drawingLimit = drawingLimit;
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

	public List<VoGroupLoanSchedule> getVoGroupLoanScheduleList() {
		return voGroupLoanScheduleList;
	}

	public void setVoGroupLoanScheduleList(List<VoGroupLoanSchedule> voGroupLoanScheduleList) {
		this.voGroupLoanScheduleList = voGroupLoanScheduleList;
	}

	public Integer getOverduePeriod() {
		return overduePeriod;
	}

	public void setOverduePeriod(Integer overduePeriod) {
		this.overduePeriod = overduePeriod;
	}

	public Long getActualTransactionDate() {
		return actualTransactionDate;
	}

	public void setActualTransactionDate(Long actualTransactionDate) {
		this.actualTransactionDate = actualTransactionDate;
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

	public Integer getTotalAmount() {
		return totalAmount;
	}

	public void setTotalAmount(Integer totalAmount) {
		this.totalAmount = totalAmount;
	}

	public Integer getNoOfLoan() {
		return noOfLoan;
	}

	public void setNoOfLoan(Integer noOfLoan) {
		this.noOfLoan = noOfLoan;
	}
    
    
    
}

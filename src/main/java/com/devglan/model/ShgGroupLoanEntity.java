package com.devglan.model;

import java.io.Serializable;
import java.math.BigInteger;
import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * $table.getTableComment()
 */
@Entity
@Table(name = "shg_group_loan")
public class ShgGroupLoanEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "uid", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private BigInteger uid;

    @Column(name = "loan_application_id", nullable = false)
    private BigInteger loanApplicationId;

    @Column(name = "cbo_id", nullable = false)
    private BigInteger cboId;

    @Column(name = "mtg_guid", nullable = false)
    private String mtgGuid;

    @Column(name = "loan_no", nullable = false)
    private Integer loanNo;

    @Column(name = "mtg_no", nullable = false)
    private Integer mtgNo;

    @Column(name = "mtg_date")
    private Timestamp mtgDate1;

    @Column(name = "installment_date")
    private Timestamp installmentDate1;

    @Column(name = "amount")
    private Integer amount;

    @Column(name = "loan_purpose")
    private Integer loanPurpose;

    @Column(name = "loan_product_id")
    private Integer loanProductId;

    @Column(name = "interest_rate")
    private Double interestRate;

    @Column(name = "period")
    private Integer period;

    @Column(name = "interest_due")
    private Integer interestDue;

     @Column(name = "completion_flag")
     private Boolean completionFlag;

    @Column(name = "loan_type")
    private Integer loanType;

    @Column(name = "loan_source")
    private Integer loanSource;

    @Column(name = "external_loan_id")
    private Integer externalLoanId;

    @Column(name = "mode_payment")
    private Integer modePayment;

    @Column(name = "bank_code")
    private String bankCode;

    @Column(name = "transaction_no")
    private String transactionNo;

    @Column(name = "installment_freq")
    private Integer installmentFreq;

    @Column(name = "moratorium_period")
    private Integer moratoriumPeriod;

    @Column(name = "loan_account_no")
    private String loanAccountNo;

    @Column(name = "repay_to")
    private Integer repayTo;

    @Column(name = "created_by")
    private String createdBy;

    @Column(name = "created_on")
    private Timestamp createdOn1;

    @Column(name = "updated_by")
    private String updatedBy;

    @Column(name = "updated_on")
    private Timestamp updatedOn1;

    @Column(name = "uploaded_by")
    private String uploadedBy;

    @Column(name = "uploaded_on")
    private Timestamp uploadedOn;
    
    @Column(name = "shg_mtg_uid")
    private BigInteger shgMtgUid;

    @Column(name = "disbursement_date")
    private Timestamp disbursementDate1;

    @Column(name = "principal_overdue")
    private Integer principalOverdue;

    @Column(name = "interest_overdue")
    private Integer interestOverdue;

    @Column(name = "loan_ref_no")
    private String loanRefNo;

    @Column(name = "organization_name")
    private String organizationName;

    @Column(name = "principle_repaid")
    private Integer principleRepaid;

    @Column(name = "orignal_loan_amount")
    private Integer orignalLoanAmount;
    
    @Column(name = "institution")
    private Integer institution;
    
    
  //@anshul261121
    @Column(name = "overdue_period")
    private Integer overduePeriod;

    @Column(name = "actual_transaction_date")
    private Timestamp actualTransactionDate1;

    @Column(name = "original_interest_rate")
    private Double originalInterestRate;

    @Column(name = "original_period")
    private  Integer originalPeriod;
    
    @Column(name = " reschedule_reason")
    private  Integer  rescheduleReason;
    
    @Column(name = "total_amount")
    private  Integer  totalAmount;

    @Column(name = "no_of_loan")
    private  Integer  noOfLoan ;


    public BigInteger getUid() {
        return uid;
    }

    public void setUid(BigInteger uid) {
        this.uid = uid;
    }

    public BigInteger getLoanApplicationId() {
        return loanApplicationId;
    }

    public void setLoanApplicationId(BigInteger loanApplicationId) {
        this.loanApplicationId = loanApplicationId;
    }

    public BigInteger getCboId() {
        return cboId;
    }

    public void setCboId(BigInteger cboId) {
        this.cboId = cboId;
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

    public Timestamp getMtgDate1() {
        return mtgDate1;
    }

    public void setMtgDate1(Timestamp mtgDate1) {
        this.mtgDate1 = mtgDate1;
    }

    public Timestamp getInstallmentDate1() {
        return installmentDate1;
    }

    public void setInstallmentDate1(Timestamp installmentDate1) {
        this.installmentDate1 = installmentDate1;
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

    public Integer getInterestDue() {
        return interestDue;
    }

    public void setInterestDue(Integer interestDue) {
        this.interestDue = interestDue;
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

    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    public Timestamp getCreatedOn1() {
        return createdOn1;
    }

    public void setCreatedOn1(Timestamp createdOn1) {
        this.createdOn1 = createdOn1;
    }

    public String getUpdatedBy() {
        return updatedBy;
    }

    public void setUpdatedBy(String updatedBy) {
        this.updatedBy = updatedBy;
    }

    public Timestamp getUpdatedOn1() {
        return updatedOn1;
    }

    public void setUpdatedOn1(Timestamp updatedOn1) {
        this.updatedOn1 = updatedOn1;
    }

    public String getUploadedBy() {
        return uploadedBy;
    }

    public void setUploadedBy(String uploadedBy) {
        this.uploadedBy = uploadedBy;
    }

    public Timestamp getUploadedOn() {
        return uploadedOn;
    }

    public void setUploadedOn(Timestamp uploadedOn) {
        this.uploadedOn = uploadedOn;
    }

    public Timestamp getDisbursementDate1() {
        return disbursementDate1;
    }

    public void setDisbursementDate1(Timestamp disbursementDate1) {
        this.disbursementDate1 = disbursementDate1;
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

    public String getLoanRefNo() {
        return loanRefNo;
    }

    public void setLoanRefNo(String loanRefNo) {
        this.loanRefNo = loanRefNo;
    }

    public String getOrganizationName() {
        return organizationName;
    }

    public void setOrganizationName(String organizationName) {
        this.organizationName = organizationName;
    }

    public Integer getPrincipleRepaid() {
        return principleRepaid;
    }

    public void setPrincipleRepaid(Integer principleRepaid) {
        this.principleRepaid = principleRepaid;
    }

    public Integer getOrignalLoanAmount() {
        return orignalLoanAmount;
    }

    public void setOrignalLoanAmount(Integer orignalLoanAmount) {
        this.orignalLoanAmount = orignalLoanAmount;
    }

	public BigInteger getShgMtgUid() {
		return shgMtgUid;
	}

	public void setShgMtgUid(BigInteger shgMtgUid) {
		this.shgMtgUid = shgMtgUid;
	}

	public Boolean getCompletionFlag() {
		return completionFlag;
	}

	public void setCompletionFlag(Boolean completionFlag) {
		this.completionFlag = completionFlag;
	}

	public Integer getInstitution() {
		return institution;
	}

	public void setInstitution(Integer institution) {
		this.institution = institution;
	}

	public Integer getOverduePeriod() {
		return overduePeriod;
	}

	public void setOverduePeriod(Integer overduePeriod) {
		this.overduePeriod = overduePeriod;
	}

	public Timestamp getActualTransactionDate1() {
		return actualTransactionDate1;
	}

	public void setActualTransactionDate1(Timestamp actualTransactionDate1) {
		this.actualTransactionDate1 = actualTransactionDate1;
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

package com.devglan.model;

import java.io.Serializable;
import java.math.BigInteger;
import java.sql.Time;
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
@Table(name = "shg_mem_loan")
public class ShgMemLoanEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "uid", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private BigInteger uid;

    @Column(name = "loan_application_id", nullable = false)
    private BigInteger loanApplicationId;

    @Column(name = "mtg_guid", nullable = false)
    private String mtgGuid;

    @Column(name = "cbo_id", nullable = false)
    private BigInteger cboId;

    @Column(name = "mem_id", nullable = false)
    private BigInteger memId;

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

    @Column(name = "principal_overdue")
    private Integer principalOverdue;

    @Column(name = "interest_overdue")
    private Integer interestOverdue;

    @Column(name = "completion_flag")
    private Boolean completionFlag;

    @Column(name = "loan_type")
    private Integer loanType;

    @Column(name = "loan_source")
    private Integer loanSource;

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

    @Column(name = "shg_mtg_det_uid")
    private BigInteger shgMtgDetUid;

    @Column(name = "shg_mtg_uid")
    private BigInteger shgMtgUid;

    @Column(name = "original_loan_amount")
    private Integer originalLoanAmount;

    @Column(name = "principal_repaid")
    private Integer principalRepaid;

    @Column(name = "interest_repaid")
    private Integer interestRepaid;

    @Column(name = "disbursement_date")
    private Timestamp disbursementDate1;
    
    //@Anshul261121
    @Column(name = "no_of_loans")
    private Integer noOfLoans;

    @Column(name = "original_interest_rate")
    private Double originalInterestRate;

    @Column(name = "original_period")
    private Integer originalPeriod;
    
    @Column(name = " reschedule_reason")
    private  Integer  rescheduleReason;

    public void setUid(BigInteger uid) {
        this.uid = uid;
    }

    public BigInteger getUid() {
        return uid;
    }



    public void setMtgGuid(String mtgGuid) {
        this.mtgGuid = mtgGuid;
    }

    public String getMtgGuid() {
        return mtgGuid;
    }

    public void setLoanNo(Integer loanNo) {
        this.loanNo = loanNo;
    }

    public Integer getLoanNo() {
        return loanNo;
    }

    public void setMtgNo(Integer mtgNo) {
        this.mtgNo = mtgNo;
    }

    public Integer getMtgNo() {
        return mtgNo;
    }


    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setLoanPurpose(Integer loanPurpose) {
        this.loanPurpose = loanPurpose;
    }

    public Integer getLoanPurpose() {
        return loanPurpose;
    }

    public void setLoanProductId(Integer loanProductId) {
        this.loanProductId = loanProductId;
    }

    public Integer getLoanProductId() {
        return loanProductId;
    }

    public void setInterestRate(Double interestRate) {
        this.interestRate = interestRate;
    }

    public Double getInterestRate() {
        return interestRate;
    }

    public void setPeriod(Integer period) {
        this.period = period;
    }

    public Integer getPeriod() {
        return period;
    }

    public void setPrincipalOverdue(Integer principalOverdue) {
        this.principalOverdue = principalOverdue;
    }

    public Integer getPrincipalOverdue() {
        return principalOverdue;
    }

    public void setInterestOverdue(Integer interestOverdue) {
        this.interestOverdue = interestOverdue;
    }

    public Integer getInterestOverdue() {
        return interestOverdue;
    }

    public void setCompletionFlag(Boolean completionFlag) {
        this.completionFlag = completionFlag;
    }

    public Boolean isCompletionFlag() {
        return completionFlag;
    }

    public void setLoanType(Integer loanType) {
        this.loanType = loanType;
    }

    public Integer getLoanType() {
        return loanType;
    }

    public void setLoanSource(Integer loanSource) {
        this.loanSource = loanSource;
    }

    public Integer getLoanSource() {
        return loanSource;
    }

    public void setModePayment(Integer modePayment) {
        this.modePayment = modePayment;
    }

    public Integer getModePayment() {
        return modePayment;
    }

    public void setBankCode(String bankCode) {
        this.bankCode = bankCode;
    }

    public String getBankCode() {
        return bankCode;
    }

    public void setTransactionNo(String transactionNo) {
        this.transactionNo = transactionNo;
    }

    public String getTransactionNo() {
        return transactionNo;
    }

    public void setInstallmentFreq(Integer installmentFreq) {
        this.installmentFreq = installmentFreq;
    }

    public Integer getInstallmentFreq() {
        return installmentFreq;
    }

    public void setMoratoriumPeriod(Integer moratoriumPeriod) {
        this.moratoriumPeriod = moratoriumPeriod;
    }

    public Integer getMoratoriumPeriod() {
        return moratoriumPeriod;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public void setUpdatedBy(String updatedBy) {
        this.updatedBy = updatedBy;
    }

    public String getUpdatedBy() {
        return updatedBy;
    }


    public void setUploadedBy(String uploadedBy) {
        this.uploadedBy = uploadedBy;
    }

    public String getUploadedBy() {
        return uploadedBy;
    }

    public void setUploadedOn(Timestamp uploadedOn) {
        this.uploadedOn = uploadedOn;
    }

    public Timestamp getUploadedOn() {
        return uploadedOn;
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

    public Timestamp getCreatedOn1() {
        return createdOn1;
    }

    public void setCreatedOn1(Timestamp createdOn1) {
        this.createdOn1 = createdOn1;
    }

    public Timestamp getUpdatedOn1() {
        return updatedOn1;
    }

    public void setUpdatedOn1(Timestamp updatedOn1) {
        this.updatedOn1 = updatedOn1;
    }

    public Boolean getCompletionFlag() {
        return completionFlag;
    }

    @Override
    public String toString() {
        return "ShgMemLoanEntity{" +
                "uid=" + uid + '\'' +
                "loanApplicationId=" + loanApplicationId + '\'' +
                "mtgGuid=" + mtgGuid + '\'' +
                "cboId=" + cboId + '\'' +
                "memId=" + memId + '\'' +
                "loanNo=" + loanNo + '\'' +
                "mtgNo=" + mtgNo + '\'' +
                "mtgDate=" + mtgDate1 + '\'' +
                "installmentDate=" + installmentDate1 + '\'' +
                "amount=" + amount + '\'' +
                "loanPurpose=" + loanPurpose + '\'' +
                "loanProductId=" + loanProductId + '\'' +
                "interestRate=" + interestRate + '\'' +
                "period=" + period + '\'' +
                "principalOverdue=" + principalOverdue + '\'' +
                "interestOverdue=" + interestOverdue + '\'' +
                "completionFlag=" + completionFlag + '\'' +
                "loanType=" + loanType + '\'' +
                "loanSource=" + loanSource + '\'' +
                "modePayment=" + modePayment + '\'' +
                "bankCode=" + bankCode + '\'' +
                "transactionNo=" + transactionNo + '\'' +
                "installmentFreq=" + installmentFreq + '\'' +
                "moratoriumPeriod=" + moratoriumPeriod + '\'' +
                "createdBy=" + createdBy + '\'' +
                "createdOn=" + createdOn1 + '\'' +
                "updatedBy=" + updatedBy + '\'' +
                "updatedOn=" + updatedOn1 + '\'' +
                "uploadedBy=" + uploadedBy + '\'' +
                "uploadedOn=" + uploadedOn + '\'' +
                '}';
    }

    public BigInteger getShgMtgDetUid() {
        return shgMtgDetUid;
    }

    public void setShgMtgDetUid(BigInteger shgMtgDetUid) {
        this.shgMtgDetUid = shgMtgDetUid;
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

    public Timestamp getDisbursementDate1() {
        return disbursementDate1;
    }

    public void setDisbursementDate1(Timestamp disbursementDate1) {
        this.disbursementDate1 = disbursementDate1;
    }

    public BigInteger getShgMtgUid() {
        return shgMtgUid;
    }

    public void setShgMtgUid(BigInteger shgMtgUid) {
        this.shgMtgUid = shgMtgUid;
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

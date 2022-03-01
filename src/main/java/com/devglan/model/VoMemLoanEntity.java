package com.devglan.model;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigInteger;
import java.sql.Timestamp;

/**
 * $table.getTableComment()
 */
@Entity
@Table(name = "vo_mem_loan")
public class VoMemLoanEntity implements Serializable {

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
	
	@Column(name = "fund_type")
    private Integer fundType;

    @Column(name = "interest_rate")
    private Float interestRate;

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

    @Column(name = "vo_mtg_det_uid")
    private BigInteger voMtgDetUid;

    @Column(name = "original_loan_amount")
    private Integer originalLoanAmount;

    @Column(name = "principal_repaid")
    private Integer principalRepaid;

    @Column(name = "interest_repaid")
    private Integer interestRepaid;

    @Column(name = "disbursement_date")
    private Timestamp disbursementDate1;

    @Column(name = "vo_mtg_uid")
    private BigInteger voMtgUid;
    
  //@Anshul271121
    @Column(name = "no_of_loans")
    private Integer noOfLoans;

    @Column(name = "original_interest_rate")
    private Double originalInterestRate;

    @Column(name = "original_period")
    private Integer originalPeriod;

    @Column(name = "reschedule_reason")
    private Integer rescheduleReason;

    public BigInteger getVoMtgUid() {
        return voMtgUid;
    }

    public void setVoMtgUid(BigInteger voMtgUid) {
        this.voMtgUid = voMtgUid;
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

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

    public String getMtgGuid() {
        return mtgGuid;
    }

    public void setMtgGuid(String mtgGuid) {
        this.mtgGuid = mtgGuid;
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

    public Integer getFundType() {
        return fundType;
    }

    public void setFundType(Integer fundType) {
        this.fundType = fundType;
    }

    public Float getInterestRate() {
        return interestRate;
    }

    public void setInterestRate(Float interestRate) {
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

    public Timestamp getDisbursementDate1() {
        return disbursementDate1;
    }

    public void setDisbursementDate1(Timestamp disbursementDate1) {
        this.disbursementDate1 = disbursementDate1;
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

	@Override
    public String toString() {
        return "ShgMemLoanEntity{" +
                "uid=" + uid + '\'' +
                "loanApplicationId=" + loanApplicationId + '\'' +
                "mtgGuid=" + mtgGuid + '\'' +
				"voMtgDetUid=" + voMtgDetUid + '\'' +
                "cboId=" + cboId + '\'' +
                "memId=" + memId + '\'' +
                "loanNo=" + loanNo + '\'' +
                "mtgNo=" + mtgNo + '\'' +
                "mtgDate=" + mtgDate1 + '\'' +
                "installmentDate=" + installmentDate1 + '\'' +
				  "originalLoanAmount=" + originalLoanAmount + '\'' +
                "amount=" + amount + '\'' +
                "loanPurpose=" + loanPurpose + '\'' +
				"fund_type=" + fundType + '\'' +
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
				"interestRepaid=" + interestRepaid + '\'' +
				"disbursementDate1=" + disbursementDate1 + '\'' +
				"principalRepaid=" + principalRepaid + '\'' +
                "createdBy=" + createdBy + '\'' +
                "createdOn=" + createdOn1 + '\'' +
                "updatedBy=" + updatedBy + '\'' +
                "updatedOn=" + updatedOn1 + '\'' +
                "uploadedBy=" + uploadedBy + '\'' +
                "uploadedOn=" + uploadedOn + '\'' +
                '}';
    }
}

package com.devglan.model;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigInteger;
import java.sql.Timestamp;
import java.util.Date;

@Entity
@Cacheable(value = false)
@Table(name = "clf_mem_loan")
public class ClfMemLoanEntity implements Serializable {

    @Id
    @Column(name = "uid", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private BigInteger uid;

    @Column(name = "loan_application_id", nullable = false)
    private BigInteger loanApplicationId;

    @Column(name = "cbo_id", nullable = false)
    private BigInteger cboId;

    @Column(name = "loan_no", nullable = false)
    private Integer loanNo;

    @Column(name = "mtg_no", nullable = false)
    private Integer mtgNo;

    @Column(name = "installment_date")
    private Timestamp installmentDate1;

    @Column(name = "original_loan_amount")
    private Integer originalLoanAmount;

    @Column(name = "amount")
    private Integer amount;

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
    private Integer completionFlag;

    @Column(name = "mode_payment")
    private Integer modePayment;

    @Column(name = "bank_code")
    private String bankCode;

    @Column(name = "transaction_no")
    private String transactionNo;

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

    @Column(name = "principal_repaid")
    private Integer principalRepaid;

    @Column(name = "interest_repaid")
    private Integer interestRepaid;

    @Column(name = "disbursement_date")
    private Timestamp disbursementDate1;

    @Column(name = "vo_id", nullable = false)
    private BigInteger voId;

    @Column(name = "shg_id", nullable = false)
    private BigInteger shgId;

    @Column(name = "organization_type")
    private Integer organizationType;

    @Column(name = "organization_name")
    private String organizationName;

    @Column(name = "installment_type")
    private Integer installmentType;

    @Column(name = "cheque_issued_date")
    private Timestamp chequeIssuedDate1;

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


    public Integer getOriginalLoanAmount() {
        return originalLoanAmount;
    }

    public void setOriginalLoanAmount(Integer originalLoanAmount) {
        this.originalLoanAmount = originalLoanAmount;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
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

    public Integer getCompletionFlag() {
        return completionFlag;
    }

    public void setCompletionFlag(Integer completionFlag) {
        this.completionFlag = completionFlag;
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

    public Integer getMoratoriumPeriod() {
        return moratoriumPeriod;
    }

    public void setMoratoriumPeriod(Integer moratoriumPeriod) {
        this.moratoriumPeriod = moratoriumPeriod;
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

    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    public String getUpdatedBy() {
        return updatedBy;
    }

    public void setUpdatedBy(String updatedBy) {
        this.updatedBy = updatedBy;
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

    public Timestamp getInstallmentDate1() {
        return installmentDate1;
    }

    public void setInstallmentDate1(Timestamp installmentDate1) {
        this.installmentDate1 = installmentDate1;
    }

    public Timestamp getDisbursementDate1() {
        return disbursementDate1;
    }

    public void setDisbursementDate1(Timestamp disbursementDate1) {
        this.disbursementDate1 = disbursementDate1;
    }

    public BigInteger getVoId() {
        return voId;
    }

    public void setVoId(BigInteger voId) {
        this.voId = voId;
    }

    public BigInteger getShgId() {
        return shgId;
    }

    public void setShgId(BigInteger shgId) {
        this.shgId = shgId;
    }

    public Integer getOrganizationType() {
        return organizationType;
    }

    public void setOrganizationType(Integer organizationType) {
        this.organizationType = organizationType;
    }

    public String getOrganizationName() {
        return organizationName;
    }

    public void setOrganizationName(String organizationName) {
        this.organizationName = organizationName;
    }

    public Integer getInstallmentType() {
        return installmentType;
    }

    public void setInstallmentType(Integer installmentType) {
        this.installmentType = installmentType;
    }


    public Timestamp getChequeIssuedDate1() {
        return chequeIssuedDate1;
    }

    public void setChequeIssuedDate1(Timestamp chequeIssuedDate1) {
        this.chequeIssuedDate1 = chequeIssuedDate1;
    }
}

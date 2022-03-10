package com.devglan.model;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigInteger;
import java.sql.Timestamp;
@Entity
@Cacheable(value = false)
@Table(name="clf_group_loan")
public class ClfGroupLoanEntity implements Serializable {

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

    @Column(name = "mtg_no")
    private Integer mtgNo;

    @Column(name = "disbursement_date", nullable = false)
    private Timestamp disbursementDate1;

    @Column(name = "installment_date")
    private Timestamp installmentDate1;

    @Column(name = "loan_ref_no")
    private Integer loanRefNo;

    @Column(name = "amount")
    private Integer amount;

    @Column(name = "interest_rate")
    private Float interestRate;

    @Column(name = "period")
    private Integer period;

    @Column(name = "principal_overdue")
    private Integer principalOverdue;

    @Column(name = "orignal_loan_amount")
    private Integer orignalLoanAmount;

    @Column(name = "principal_repaid")
    private Integer principalRepaid;

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

    @Column(name = "installment_freq")
    private Integer installmentFreq;

    @Column(name = "moratorium_period")
    private Integer moratoriumPeriod;

    @Column(name = "organization_name")
    private String organizationName;

    @Column(name = "sanctioned_amount")
    private Integer sanctionedAmount;

    @Column(name = "drawing_limit")
    private Integer drawingLimit;

    @Column(name = "created_by")
    private String createdBy;

    @Column(name = "created_on")
    private Timestamp createdOn1;

    @Column(name = "updated_by")
    private String updatedBy;

    @Column(name = "updated_on")
    private Timestamp updatedOn1;

    @Column(name = "organization_type")
    private Integer organizationType;

    @Column(name = "fund_type")
    private Integer fundType;

    @Column(name = "payee_branchid")
    private Integer payeeBranchid;

    @Column(name = "payee_bankid")
    private Integer payeeBankid;

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

    public Timestamp getDisbursementDate1() {
        return disbursementDate1;
    }

    public void setDisbursementDate1(Timestamp disbursementDate1) {
        this.disbursementDate1 = disbursementDate1;
    }

    public Timestamp getInstallmentDate1() {
        return installmentDate1;
    }

    public void setInstallmentDate1(Timestamp installmentDate1) {
        this.installmentDate1 = installmentDate1;
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

    public String getOrganizationName() {
        return organizationName;
    }

    public void setOrganizationName(String organizationName) {
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

    public Integer getOrganizationType() {
        return organizationType;
    }

    public void setOrganizationType(Integer organizationType) {
        this.organizationType = organizationType;
    }

    public Integer getFundType() {
        return fundType;
    }

    public void setFundType(Integer fundType) {
        this.fundType = fundType;
    }

    public Integer getPayeeBranchid() {
        return payeeBranchid;
    }

    public void setPayeeBranchid(Integer payeeBranchid) {
        this.payeeBranchid = payeeBranchid;
    }

    public Integer getPayeeBankid() {
        return payeeBankid;
    }

    public void setPayeeBankid(Integer payeeBankid) {
        this.payeeBankid = payeeBankid;
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

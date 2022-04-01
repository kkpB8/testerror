package com.devglan.model;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigInteger;
import java.sql.Timestamp;
import java.util.Date;

@Entity
@Cacheable(value = false)
@Table(name = "clf_mem_loan_schedule")
public class ClfMemLoanScheduleEntity implements Serializable {

    @Id
    @Column(name = "uid", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private BigInteger uid;

    @Column(name = "cbo_id", nullable = false)
    private BigInteger cboId;

    @Column(name = "loan_no")
    private Integer loanNo;

    @Column(name = "principal_demand")
    private Integer principalDemand;

    @Column(name = "loan_repaid")
    private Integer loanRePaid;

    @Column(name = "installment_no", nullable = false)
    private Integer installmentNo;

    @Column(name = "sub_installment_no", nullable = false)
    private Integer subInstallmentNo;

    @Column(name = "installment_date")
    private Date installmentDate1;

    @Column(name = "repaid")
    private Short repaid;

    @Column(name = "last_paid_date")
    private Date lastPaidDate1;

    @Column(name = "txn_mtg_no")
    private Integer txnMtgNo;

    @Column(name = "created_by")
    private String createdBy;

    @Column(name = "created_on")
    private Timestamp createdOn1;

    @Column(name = "updated_by")
    private String updatedBy;

    @Column(name = "updated_on")
    private Timestamp updatedOn1;

    @Column(name = "interest_repaid")
    private Integer interestRePaid;

    @Column(name = "mode_payment")
    private Integer modePayment;

    @Column(name = "bank_code")
    private String bankCode;

    @Column(name = "transaction_no")
    private String transactionNo;

    @Column(name = "is_original")
    private Short isOriginal;

    @Column(name = "original_amount")
    private Integer originalAmount;

    @Column(name = "gap_days_schedule")
    private Integer gapDaysSchedule;

    @Column(name = "gap_days_actual")
    private Integer gapDaysActual;

    @Column(name = "interest_demand_schedule")
    private Integer interestDemandSchedule;

    @Column(name = "interest_demand_actual")
    private Integer interestDemandActual;

    @Column(name = "loan_os_actual")
    private BigInteger loanOsActual;

    @Column(name = "loan_os_schedule")
    private BigInteger loanOsSchedule;

    @Column(name = "installment_type")
    private Integer installmentType;

    @Column(name = "cheque_issued_date")
    private Timestamp chequeIssuedDate1;

    @Column(name = "interest_accured")
    private Integer interestAccured;

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

    public Integer getLoanNo() {
        return loanNo;
    }

    public void setLoanNo(Integer loanNo) {
        this.loanNo = loanNo;
    }

    public Integer getPrincipalDemand() {
        return principalDemand;
    }

    public void setPrincipalDemand(Integer principalDemand) {
        this.principalDemand = principalDemand;
    }

    public Integer getInstallmentNo() {
        return installmentNo;
    }

    public void setInstallmentNo(Integer installmentNo) {
        this.installmentNo = installmentNo;
    }

    public Integer getSubInstallmentNo() {
        return subInstallmentNo;
    }

    public void setSubInstallmentNo(Integer subInstallmentNo) {
        this.subInstallmentNo = subInstallmentNo;
    }

    public Date getInstallmentDate1() {
        return installmentDate1;
    }

    public void setInstallmentDate1(Date installmentDate1) {
        this.installmentDate1 = installmentDate1;
    }

    public void setInstallmentDate1(Timestamp installmentDate1) {
        this.installmentDate1 = installmentDate1;
    }

    public Short getRepaid() {
        return repaid;
    }

    public void setRepaid(Short repaid) {
        this.repaid = repaid;
    }

    public Date getLastPaidDate1() {
        return lastPaidDate1;
    }

    public void setLastPaidDate1(Date lastPaidDate1) {
        this.lastPaidDate1 = lastPaidDate1;
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

    public BigInteger getLoanOsActual() {
        return loanOsActual;
    }

    public void setLoanOsActual(BigInteger loanOsActual) {
        this.loanOsActual = loanOsActual;
    }

    public BigInteger getLoanOsSchedule() {
        return loanOsSchedule;
    }

    public void setLoanOsSchedule(BigInteger loanOsSchedule) {
        this.loanOsSchedule = loanOsSchedule;
    }



    public Integer getInstallmentType() {
        return installmentType;
    }

    public void setInstallmentType(Integer installmentType) {
        this.installmentType = installmentType;
    }

    public Integer getInterestDemandActual() {
        return interestDemandActual;
    }

    public void setInterestDemandActual(Integer interestDemandActual) {
        this.interestDemandActual = interestDemandActual;
    }

    public Integer getInterestDemandSchedule() {
        return interestDemandSchedule;
    }

    public void setInterestDemandSchedule(Integer interestDemandSchedule) {
        this.interestDemandSchedule = interestDemandSchedule;
    }

    public Integer getGapDaysActual() {
        return gapDaysActual;
    }

    public void setGapDaysActual(Integer gapDaysActual) {
        this.gapDaysActual = gapDaysActual;
    }

    public Integer getGapDaysSchedule() {
        return gapDaysSchedule;
    }

    public void setGapDaysSchedule(Integer gapDaysSchedule) {
        this.gapDaysSchedule = gapDaysSchedule;
    }

    public Integer getOriginalAmount() {
        return originalAmount;
    }

    public void setOriginalAmount(Integer originalAmount) {
        this.originalAmount = originalAmount;
    }

    public Short getOriginal() {
        return isOriginal;
    }

    public void setOriginal(Short original) {
        isOriginal = original;
    }

    public String getTransactionNo() {
        return transactionNo;
    }

    public void setTransactionNo(String transactionNo) {
        this.transactionNo = transactionNo;
    }

    public String getBankCode() {
        return bankCode;
    }

    public void setBankCode(String bankCode) {
        this.bankCode = bankCode;
    }

    public Integer getModePayment() {
        return modePayment;
    }

    public void setModePayment(Integer modePayment) {
        this.modePayment = modePayment;
    }

    public Integer getInterestRePaid() {
        return interestRePaid;
    }

    public void setInterestRePaid(Integer interestRePaid) {
        this.interestRePaid = interestRePaid;
    }

    public Integer getTxnMtgNo() {
        return txnMtgNo;
    }

    public void setTxnMtgNo(Integer txnMtgNo) {
        this.txnMtgNo = txnMtgNo;
    }

    public Integer getLoanRePaid() {
        return loanRePaid;
    }

    public void setLoanRePaid(Integer loanRePaid) {
        this.loanRePaid = loanRePaid;
    }

    public Integer getInterestAccured() {
        return interestAccured;
    }

    public void setInterestAccured(Integer interestAccured) {
        this.interestAccured = interestAccured;
    }

    public Timestamp getChequeIssuedDate1() {
        return chequeIssuedDate1;
    }

    public void setChequeIssuedDate1(Timestamp chequeIssuedDate1) {
        this.chequeIssuedDate1 = chequeIssuedDate1;
    }
}

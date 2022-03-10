package com.devglan.model;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigInteger;
import java.sql.Timestamp;
@Entity
@Cacheable(value = false)
@Table(name = "clf_group_loan_schedule")
public class ClfGroupLoanScheduleEntity implements Serializable {

    @Id
    @Column(name = "uid", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private BigInteger uid;

    @Column(name = "cbo_id", nullable = false)
    private BigInteger cboId;

    @Column(name = "loan_no", nullable = false)
    private Integer loanNo;

    @Column(name = "principal_demand")
    private Integer principalDemand;

    @Column(name = "loan_demand_os")
    private Integer loanDemandOs;

    @Column(name = "installment_no")
    private Integer installmentNo;

    @Column(name = "sub_installment_no", nullable = false)
    private Integer subInstallmentNo;

    @Column(name = "installment_date", nullable = false)
    private Timestamp installmentDate1;

    @Column(name = "loan_date")
    private Timestamp loanDate1;

    @Column(name = "repaid")
    private Boolean repaid;

    @Column(name = "last_paid_date")
    private Timestamp lastPaidDate1;

    @Column(name = "created_by")
    private String createdBy;

    @Column(name = "created_on")
    private Timestamp createdOn1;

    @Column(name = "updated_by")
    private String updatedBy;

    @Column(name = "updated_on")
    private Timestamp updatedOn1;

    @Column(name = "loan_repaid")
    private Integer loanRepaid;

    @Column(name = "interest_paid")
    private Integer interestPaid;

    @Column(name = "txn_mtg_no")
    private Integer txnMtgNo;

    @Column(name = "mode_payment")
    private Integer modePayment;

    @Column(name = "bank_code")
    private Integer bankCode;

    @Column(name = "transaction_no")
    private Integer transactionNo;

    @Column(name = "is_original")
    private Boolean isOriginal;

    @Column(name = "original_amount")
    private BigInteger originalAmount;

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

    @Column(name = "interest_accured")
    private Integer interestAccured;

    @Column(name = "installment_type")
    private Integer installmentType;

    @Column(name = "cheque_issued_date")
    private Timestamp chequeIssuedDate1;

    @Column(name = "emi")
    private Integer emi;

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

    public Integer getLoanDemandOs() {
        return loanDemandOs;
    }

    public void setLoanDemandOs(Integer loanDemandOs) {
        this.loanDemandOs = loanDemandOs;
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

    public Timestamp getInstallmentDate1() {
        return installmentDate1;
    }

    public void setInstallmentDate1(Timestamp installmentDate1) {
        this.installmentDate1 = installmentDate1;
    }

    public Timestamp getLoanDate1() {
        return loanDate1;
    }

    public void setLoanDate1(Timestamp loanDate1) {
        this.loanDate1 = loanDate1;
    }

    public Boolean getRepaid() {
        return repaid;
    }

    public void setRepaid(Boolean repaid) {
        this.repaid = repaid;
    }

    public Timestamp getLastPaidDate1() {
        return lastPaidDate1;
    }

    public void setLastPaidDate1(Timestamp lastPaidDate1) {
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

    public Integer getLoanRepaid() {
        return loanRepaid;
    }

    public void setLoanRepaid(Integer loanRepaid) {
        this.loanRepaid = loanRepaid;
    }

    public Integer getInterestPaid() {
        return interestPaid;
    }

    public void setInterestPaid(Integer interestPaid) {
        this.interestPaid = interestPaid;
    }

    public Integer getTxnMtgNo() {
        return txnMtgNo;
    }

    public void setTxnMtgNo(Integer txnMtgNo) {
        this.txnMtgNo = txnMtgNo;
    }

    public Integer getModePayment() {
        return modePayment;
    }

    public void setModePayment(Integer modePayment) {
        this.modePayment = modePayment;
    }

    public Integer getBankCode() {
        return bankCode;
    }

    public void setBankCode(Integer bankCode) {
        this.bankCode = bankCode;
    }

    public Integer getTransactionNo() {
        return transactionNo;
    }

    public void setTransactionNo(Integer transactionNo) {
        this.transactionNo = transactionNo;
    }

    public Boolean getOriginal() {
        return isOriginal;
    }

    public void setOriginal(Boolean original) {
        isOriginal = original;
    }

    public BigInteger getOriginalAmount() {
        return originalAmount;
    }

    public void setOriginalAmount(BigInteger originalAmount) {
        this.originalAmount = originalAmount;
    }

    public Integer getGapDaysSchedule() {
        return gapDaysSchedule;
    }

    public void setGapDaysSchedule(Integer gapDaysSchedule) {
        this.gapDaysSchedule = gapDaysSchedule;
    }

    public Integer getGapDaysActual() {
        return gapDaysActual;
    }

    public void setGapDaysActual(Integer gapDaysActual) {
        this.gapDaysActual = gapDaysActual;
    }

    public Integer getInterestDemandSchedule() {
        return interestDemandSchedule;
    }

    public void setInterestDemandSchedule(Integer interestDemandSchedule) {
        this.interestDemandSchedule = interestDemandSchedule;
    }

    public Integer getInterestDemandActual() {
        return interestDemandActual;
    }

    public void setInterestDemandActual(Integer interestDemandActual) {
        this.interestDemandActual = interestDemandActual;
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


    public Integer getInterestAccured() {
        return interestAccured;
    }

    public void setInterestAccured(Integer interestAccured) {
        this.interestAccured = interestAccured;
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

    public Integer getEmi() {
        return emi;
    }

    public void setEmi(Integer emi) {
        this.emi = emi;
    }
}

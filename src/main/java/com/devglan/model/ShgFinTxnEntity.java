package com.devglan.model;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigInteger;
import java.sql.Timestamp;
import java.util.Date;

/**
 * $table.getTableComment()
 */
@Entity
@Table(name = "shg_fin_txn")
public class ShgFinTxnEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "uid", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private BigInteger uid;

    @Column(name = "cbo_id", nullable = false)
    private BigInteger cboId;

    @Column(name = "mtg_guid", nullable = false)
    private String mtgGuid;

    @Column(name = "mtg_no", nullable = false)
    private Integer mtgNo;

    @Column(name = "bank_code", nullable = false)
    private String bankCode;

    @Column(name = "opening_balance")
    private Integer openingBalance;

    @Column(name = "closing_balance")
    private Integer closingBalance;

    @Column(name = "other_deposits")
    private Integer otherDeposits;

    @Column(name = "other_withdrawals")
    private Integer otherWithdrawals;

    @Column(name = "deposited_cash")
    private Integer depositedCash;

    @Column(name = "withdrawn_cash")
    private Integer withdrawnCash;

    @Column(name = "opening_balance_cash")
    private Integer openingBalanceCash;

    @Column(name = "closing_balance_cash")
    private Integer closingBalanceCash;

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

    @Column(name = "balance_date")
    private Timestamp balanceDate1;

    @Column(name = "zero_mtg_cash_bank")
    private Integer zeroMtgCashBank;

    @Column(name = "cheque_issued_not_realized")
    private Integer chequeIssuedNotRealized;

    @Column(name = "cheque_received_not_credited")
    private Integer chequeReceivedNotCredited;

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

    public String getMtgGuid() {
        return mtgGuid;
    }

    public void setMtgGuid(String mtgGuid) {
        this.mtgGuid = mtgGuid;
    }

    public Integer getMtgNo() {
        return mtgNo;
    }

    public void setMtgNo(Integer mtgNo) {
        this.mtgNo = mtgNo;
    }

    public String getBankCode() {
        return bankCode;
    }

    public void setBankCode(String bankCode) {
        this.bankCode = bankCode;
    }

    public Integer getOpeningBalance() {
        return openingBalance;
    }

    public void setOpeningBalance(Integer openingBalance) {
        this.openingBalance = openingBalance;
    }

    public Integer getClosingBalance() {
        return closingBalance;
    }

    public void setClosingBalance(Integer closingBalance) {
        this.closingBalance = closingBalance;
    }

    public Integer getOtherDeposits() {
        return otherDeposits;
    }

    public void setOtherDeposits(Integer otherDeposits) {
        this.otherDeposits = otherDeposits;
    }

    public Integer getOtherWithdrawals() {
        return otherWithdrawals;
    }

    public void setOtherWithdrawals(Integer otherWithdrawals) {
        this.otherWithdrawals = otherWithdrawals;
    }

    public Integer getDepositedCash() {
        return depositedCash;
    }

    public void setDepositedCash(Integer depositedCash) {
        this.depositedCash = depositedCash;
    }

    public Integer getWithdrawnCash() {
        return withdrawnCash;
    }

    public void setWithdrawnCash(Integer withdrawnCash) {
        this.withdrawnCash = withdrawnCash;
    }

    public Integer getOpeningBalanceCash() {
        return openingBalanceCash;
    }

    public void setOpeningBalanceCash(Integer openingBalanceCash) {
        this.openingBalanceCash = openingBalanceCash;
    }

    public Integer getClosingBalanceCash() {
        return closingBalanceCash;
    }

    public void setClosingBalanceCash(Integer closingBalanceCash) {
        this.closingBalanceCash = closingBalanceCash;
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

    public BigInteger getShgMtgUid() {
        return shgMtgUid;
    }

    public void setShgMtgUid(BigInteger shgMtgUid) {
        this.shgMtgUid = shgMtgUid;
    }

    public Timestamp getBalanceDate1() {
        return balanceDate1;
    }

    public void setBalanceDate1(Timestamp balanceDate1) {
        this.balanceDate1 = balanceDate1;
    }

    public Integer getZeroMtgCashBank() {
        return zeroMtgCashBank;
    }

    public void setZeroMtgCashBank(Integer zeroMtgCashBank) {
        this.zeroMtgCashBank = zeroMtgCashBank;
    }

    public Integer getChequeIssuedNotRealized() {
        return chequeIssuedNotRealized;
    }

    public void setChequeIssuedNotRealized(Integer chequeIssuedNotRealized) {
        this.chequeIssuedNotRealized = chequeIssuedNotRealized;
    }

    public Integer getChequeReceivedNotCredited() {
        return chequeReceivedNotCredited;
    }

    public void setChequeReceivedNotCredited(Integer chequeReceivedNotCredited) {
        this.chequeReceivedNotCredited = chequeReceivedNotCredited;
    }
}

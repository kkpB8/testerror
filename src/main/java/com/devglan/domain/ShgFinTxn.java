package com.devglan.domain;


import java.math.BigInteger;

public class ShgFinTxn {
    private BigInteger uid;
    private String bankCode;
    private Integer openingBalance;
    private Integer closingBalance;
    private Integer otherDeposits;
    private Integer otherWithdrawals;
    private Integer depositedCash;
    private Integer withdrawnCash;
    private Integer openingBalanceCash;
    private Integer closingBalanceCash;
    private Long createdOn;
    private String createdBy;
    private Long updatedOn;
    private String updatedBy;

    private Long balanceDate;
    private Integer zeroMtgCashBank;
    private Integer chequeIssuedNotRealized;
    private Integer chequeReceivedNotCredited;

    public BigInteger getUid() {
        return uid;
    }

    public void setUid(BigInteger uid) {
        this.uid = uid;
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

    public Long getBalanceDate() {
        return balanceDate;
    }

    public void setBalanceDate(Long balanceDate) {
        this.balanceDate = balanceDate;
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

package com.devglan.domain;

import javax.persistence.Column;
import java.math.BigInteger;
import java.sql.Timestamp;

public class ShgFinTxnVouchers {

    private BigInteger uid;
    //@NotNull(message = "Cbo Id cannot be null")
    private BigInteger cboId ;
    private BigInteger memberId ;
    //@NotNull(message = "Meeting No  cannot be null")
    private Integer mtgNo;

    //@NotNull(message = "Payment Mode  cannot be null")
    private Integer modePayment;

    //@Size(max=25,message="Bank Code can be max of 25 chars long")
    private String BankCode;

    //@Size(max=25,message="Bank Code can be max of 25 chars long")
    private String transactionNo;

    //@Size(max=6,message="Cheque No can be max of 6 chars long")
    private String ChequeNo;

    private Integer amount;
    private Long voucherDate;
    private String voucherNo;
    private Long dateRealisation;
    private Integer auid;
    private Short voucherType;
    private Long createdOn;
   // @Size(max=30,message="Created by can be max of 30 chars long")
    private String createdBy;
    private Long updatedOn;
   // @Size(max=30,message="Updated by can be max of 30 chars long")
    private String updatedBy;

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

    public BigInteger getMemberId() {
        return memberId;
    }

    public void setMemberId(BigInteger memberId) {
        this.memberId = memberId;
    }

    public Integer getMtgNo() {
        return mtgNo;
    }

    public void setMtgNo(Integer mtgNo) {
        this.mtgNo = mtgNo;
    }

    public Integer getModePayment() {
        return modePayment;
    }

    public void setModePayment(Integer modePayment) {
        this.modePayment = modePayment;
    }

    public String getBankCode() {
        return BankCode;
    }

    public void setBankCode(String bankCode) {
        BankCode = bankCode;
    }

    public String getTransactionNo() {
        return transactionNo;
    }

    public void setTransactionNo(String transactionNo) {
        this.transactionNo = transactionNo;
    }

    public String getChequeNo() {
        return ChequeNo;
    }

    public void setChequeNo(String chequeNo) {
        ChequeNo = chequeNo;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    public Long getVoucherDate() {
        return voucherDate;
    }

    public void setVoucherDate(Long voucherDate) {
        this.voucherDate = voucherDate;
    }

    public String getVoucherNo() {
        return voucherNo;
    }

    public void setVoucherNo(String voucherNo) {
        this.voucherNo = voucherNo;
    }

    public Long getDateRealisation() {
        return dateRealisation;
    }

    public void setDateRealisation(Long dateRealisation) {
        this.dateRealisation = dateRealisation;
    }

    public Integer getAuid() {
        return auid;
    }

    public void setAuid(Integer auid) {
        this.auid = auid;
    }

    public Short getVoucherType() {
        return voucherType;
    }

    public void setVoucherType(Short voucherType) {
        this.voucherType = voucherType;
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
}

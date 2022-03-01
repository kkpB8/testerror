package com.devglan.domain;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.math.BigInteger;

public class VoFinTxnDetGrp {
    private BigInteger uid;
    //@NotNull(message = "auid cannot be null")
    private Integer auid;
    //@NotNull(message = "Meeting Uid cannot be null")
    private String mtgUid;
    //@NotNull(message = "Cboid cannot be null")
    private BigInteger cboId;
    //@NotNull(message = "Meeting date cannot be null")
    private Long mtgDate;
    //@NotNull(message = "Meeting no cannot be null")
    private Integer mtgNo;
    //@NotNull(message = "Fund Type cannot be null")
    private Integer fundType;
   // @NotNull(message = "Fund Source cannot be null")
    private Integer fundSource;
    //@NotNull(message = "Amount to From cannot be null")
    private Integer amountToFrom;
    //@Size(max = 1, message = "type can be of 1 char")
    private String type;
    private Integer amount;
    private Long dateRealisation;
    private Integer modePayment;
    //@Size(max = 25, message = "Bank Code can be max of 25 chars long")
    private String bankCode;
    //@Size(max = 25, message = "Transaction No can be max of 25 chars long")
    private String transactionNo;
   // @NotNull(message = "Voucher Date cannot be null")
    private Long voucherDate;
   // @Size(max = 50, message = "Voucher Number can be max of 	50 chars long")
    private String voucherNumber;
    //@Size(max = 100, message = "Narration can be max of 	100 chars long")
    private String narration;
   
    private Long addlRefDate;

    private Long createdOn;
    //@Size(max = 30, message = "Created by can be max of 30 chars long")
    private String createdBy;
    private Long updatedOn;
   // @Size(max = 30, message = "Updated by can be max of 30 chars long")
    private String updatedBy;
    
    private Integer orgType;

    public BigInteger getUid() {
        return uid;
    }

    public void setUid(BigInteger uid) {
        this.uid = uid;
    }

    public Integer getAuid() {
        return auid;
    }

    public void setAuid(Integer auid) {
        this.auid = auid;
    }

    public String getMtgUid() {
        return mtgUid;
    }

    public void setMtgUid(String mtgUid) {
        this.mtgUid = mtgUid;
    }

    public BigInteger getCboId() {
        return cboId;
    }

    public void setCboId(BigInteger cboId) {
        this.cboId = cboId;
    }

    public Long getMtgDate() {
        return mtgDate;
    }

    public void setMtgDate(Long mtgDate) {
        this.mtgDate = mtgDate;
    }

    public Integer getMtgNo() {
        return mtgNo;
    }

    public void setMtgNo(Integer mtgNo) {
        this.mtgNo = mtgNo;
    }

    public Integer getFundType() {
        return fundType;
    }

    public void setFundType(Integer fundType) {
        this.fundType = fundType;
    }

    public Integer getFundSource() {
        return fundSource;
    }

    public void setFundSource(Integer fundSource) {
        this.fundSource = fundSource;
    }

    public Integer getAmountToFrom() {
        return amountToFrom;
    }

    public void setAmountToFrom(Integer amountToFrom) {
        this.amountToFrom = amountToFrom;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    public Long getDateRealisation() {
        return dateRealisation;
    }

    public void setDateRealisation(Long dateRealisation) {
        this.dateRealisation = dateRealisation;
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

    public Long getVoucherDate() {
        return voucherDate;
    }

    public void setVoucherDate(Long voucherDate) {
        this.voucherDate = voucherDate;
    }

    public String getVoucherNumber() {
        return voucherNumber;
    }

    public void setVoucherNumber(String voucherNumber) {
        this.voucherNumber = voucherNumber;
    }

    public String getNarration() {
        return narration;
    }

    public void setNarration(String narration) {
        this.narration = narration;
    }

    public Long getAddlRefDate() {
        return addlRefDate;
    }

    public void setAddlRefDate(Long addlRefDate) {
        this.addlRefDate = addlRefDate;
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

	public Integer getOrgType() {
		return orgType;
	}

	public void setOrgType(Integer orgType) {
		this.orgType = orgType;
	}
    
    
}
  

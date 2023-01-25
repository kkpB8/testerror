package com.devglan.domain;

import org.hibernate.validator.constraints.NotBlank;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class ShgFinTxnDetGrp {
    private Integer auid;
    private Integer fundType;
    private Integer amountToFrom ;
    private String type ;
    private Integer amount;
    private Long transDate;
    private Long dateRealisation;
    private Integer modePayment;
    private String bankCode;
    private String transactionNo;
    private Long createdOn;
    private String createdBy;
    private Long updatedOn;
    private String updatedBy;
	private Integer systGenerated;
	private Long effectiveDate;
	private String guid;


    private String link_guid;
   
    public Integer getAuid() {
        return auid;
    }

    public void setAuid(Integer auid) {
        this.auid = auid;
    }

    public Integer getFundType() {
        return fundType;
    }

    public void setFundType(Integer fundType) {
        this.fundType = fundType;
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

    public Long getTransDate() {
        return transDate;
    }

    public void setTransDate(Long transDate) {
        this.transDate = transDate;
    }

    public Long getDateRealisation() {
        return dateRealisation;
    }

    public void setDateRealisation(Long dateRealisation) {
        this.dateRealisation = dateRealisation;
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

	public Integer getSystGenerated() {
		return systGenerated;
	}

	public void setSystGenerated(Integer systGenerated) {
		this.systGenerated = systGenerated;
	}

	public Long getEffectiveDate() {
		return effectiveDate;
	}

	public void setEffectiveDate(Long effectiveDate) {
		this.effectiveDate = effectiveDate;
	}

	public String getGuid() {
		return guid;
	}

	public void setGuid(String guid) {
		this.guid = guid;
	}

    public String getLink_guid() {
        return link_guid;
    }

    public void setLink_guid(String link_guid) {
        this.link_guid = link_guid;
    }
}


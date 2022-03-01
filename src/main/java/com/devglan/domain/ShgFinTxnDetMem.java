package com.devglan.domain;

import org.hibernate.validator.constraints.NotBlank;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class ShgFinTxnDetMem {
    
    private Integer auid;
    private String type;
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
	//@070921 mohit
	private Integer referenceMtgNo;

	public Integer getAuid() {
		return auid;
	}
	public void setAuid(Integer auid) {
		this.auid = auid;
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

	public Integer getReferenceMtgNo() {
		return referenceMtgNo;
	}

	public void setReferenceMtgNo(Integer referenceMtgNo) {
		this.referenceMtgNo = referenceMtgNo;
	}
}


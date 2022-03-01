package com.devglan.domain;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.math.BigInteger;

public class VoFinTxnDetMem {
    private BigInteger uid;

    //@NotNull(message = "auid cannot be null")
    private Integer auid;
	//@Size(max=50,message="Meeting guid can be max of 50 chars long")
	private String mtgGuid;
	//@NotNull(message = "cboid cannot be null")
	private BigInteger cboId;
	//@NotNull(message = "Member Id cannot be null")
	private BigInteger memId;
	//@NotNull(message = "Meeting No cannot be null")
	private Integer mtgNo;
	//@NotNull(message = "Meeting Date cannot be null")
	private Long mtgDate;
	//@Size(max=1,message="type can be of 1 char")
    private String type;
    private Integer amount;
    private Long dateRealisation;
    private Integer modePayment;
    private String bankCode;
    private String transactionNo;
	//@Size(max=50,message="Voucher Number can be max of 	50 chars long")
	private String voucherNumber;
	//@NotNull(message = "Voucher Date cannot be null")
	private Long voucherDate;
	//@Size(max=100,message="Narration can be max of 	100 chars long")
	private String narration;
	
	private Long addlRefDate;
    private Long createdOn;
    //@Size(max=30,message="Created by can be max of 30 chars long")
    private String createdBy;
    private Long updatedOn;
    //@Size(max=30,message="Updated by can be max of 30 chars long")
    private String updatedBy;
    private Integer referenceMtgNo;
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

	public String getVoucherNumber() {
		return voucherNumber;
	}

	public void setVoucherNumber(String voucherNumber) {
		this.voucherNumber = voucherNumber;
	}

	public Long getVoucherDate() {
		return voucherDate;
	}

	public void setVoucherDate(Long voucherDate) {
		this.voucherDate = voucherDate;
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

	public void setAddlrefDate(Long addlRefDate) {
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

	public String getMtgGuid() {
		return mtgGuid;
	}

	public void setMtgGuid(String mtgGuid) {
		this.mtgGuid = mtgGuid;
	}

	public BigInteger getCboId() {
		return cboId;
	}

	public void setCboId(BigInteger cboId) {
		this.cboId = cboId;
	}

	public BigInteger getMemId() {
		return memId;
	}

	public void setMemId(BigInteger memId) {
		this.memId = memId;
	}

	public Integer getMtgNo() {
		return mtgNo;
	}

	public void setMtgNo(Integer mtgNo) {
		this.mtgNo = mtgNo;
	}

	public Long getMtgDate() {
		return mtgDate;
	}

	public void setMtgDate(Long mtgDate) {
		this.mtgDate = mtgDate;
	}

	public Integer getReferenceMtgNo() {
		return referenceMtgNo;
	}

	public void setReferenceMtgNo(Integer referenceMtgNo) {
		this.referenceMtgNo = referenceMtgNo;
	}

	public Integer getOrgType() {
		return orgType;
	}

	public void setOrgType(Integer orgType) {
		this.orgType = orgType;
	}
	
	
}


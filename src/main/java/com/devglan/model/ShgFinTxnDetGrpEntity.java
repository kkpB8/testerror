package com.devglan.model;

import java.io.Serializable;
import java.math.BigInteger;
import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * $table.getTableComment()
 */
@Entity
@Table(name = "shg_fin_txn_det_grp")
public class ShgFinTxnDetGrpEntity implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "uid", nullable = false)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private BigInteger uid;

	@Column(name = "mtg_guid", nullable = false)
	private String mtgGuid;

	@Column(name = "shg_mtg_uid", nullable = false)
	private BigInteger shgMtgUid;

	@Column(name = "cbo_id", nullable = false)
	private BigInteger cboId;

	@Column(name = "mtg_no", nullable = false)
	private Integer mtgNo;

	@Column(name = "auid", nullable = false)
	private Integer auid;

	@Column(name = "fund_type", nullable = false)
	private Integer fundType;

	@Column(name = "amount_to_from", nullable = false)
	private Integer amountToFrom;

	@Column(name = "type")
	private String type;

	@Column(name = "amount")
	private Integer amount;

	@Column(name = "trans_date", nullable = false)
	private Timestamp transDate1;

	@Column(name = "date_realisation")
	private Timestamp dateRealisation1;

	@Column(name = "mode_payment")
	private Integer modePayment;

	@Column(name = "bank_code")
	private String bankCode;

	@Column(name = "transaction_no")
	private String transactionNo;

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

	@Override
	public String toString() {
		return "ShgFinTxnDetGrpEntity{" +
				"uid=" + uid + '\'' +
				"mtgGuid=" + mtgGuid + '\'' +
				"cboId=" + cboId + '\'' +
				"mtgNo=" + mtgNo + '\'' +
				"auid=" + auid + '\'' +
				"fundType=" + fundType + '\'' +
				"amountToFrom=" + amountToFrom + '\'' +
				"type=" + type + '\'' +
				"amount=" + amount + '\'' +
				"transDate=" + transDate1 + '\'' +
				"dateRealisation=" + dateRealisation1 + '\'' +
				"modePayment=" + modePayment + '\'' +
				"bankCode=" + bankCode + '\'' +
				"transactionNo=" + transactionNo + '\'' +
				"createdBy=" + createdBy + '\'' +
				"createdOn=" + createdOn1 + '\'' +
				"updatedBy=" + updatedBy + '\'' +
				"updatedOn=" + updatedOn1 + '\'' +
				"uploadedBy=" + uploadedBy + '\'' +
				"uploadedOn=" + uploadedOn + '\'' +
				'}';
	}

	public BigInteger getUid() {
		return uid;
	}

	public void setUid(BigInteger uid) {
		this.uid = uid;
	}

	public String getMtgGuid() {
		return mtgGuid;
	}

	public void setMtgGuid(String mtgGuid) {
		this.mtgGuid = mtgGuid;
	}

	public BigInteger getShgMtgUid() {
		return shgMtgUid;
	}

	public void setShgMtgUid(BigInteger shgMtgUid) {
		this.shgMtgUid = shgMtgUid;
	}

	public BigInteger getCboId() {
		return cboId;
	}

	public void setCboId(BigInteger cboId) {
		this.cboId = cboId;
	}

	public Integer getMtgNo() {
		return mtgNo;
	}

	public void setMtgNo(Integer mtgNo) {
		this.mtgNo = mtgNo;
	}

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

	public Timestamp getTransDate1() {
		return transDate1;
	}

	public void setTransDate1(Timestamp transDate1) {
		this.transDate1 = transDate1;
	}

	public Timestamp getDateRealisation1() {
		return dateRealisation1;
	}

	public void setDateRealisation1(Timestamp dateRealisation1) {
		this.dateRealisation1 = dateRealisation1;
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
}

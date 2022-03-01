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
@Table(name = "shg_fin_txn_det_mem")
public class ShgFinTxnDetMemEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "uid", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private BigInteger uid;

    @Column(name = "mtg_guid", nullable = false)
    private String mtgGuid;

    @Column(name = "cbo_id", nullable = false)
    private BigInteger cboId;

    @Column(name = "mem_id", nullable = false)
    private BigInteger memId;

    @Column(name = "mtg_no", nullable = false)
    private Integer mtgNo;

    @Column(name = "auid", nullable = false)
    private Integer auid;

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

    @Column(name = "shg_mtg_det_uid")
    private BigInteger shgMtgDetUid;
    
    @Column(name = "shg_mtg_uid")
    private BigInteger shgMtgUid;

    //@070921 mohit
    @Column(name = "reference_mtg_no")
    private Integer referenceMtgNo;

    public void setUid(BigInteger uid) {
        this.uid = uid;
    }

    public BigInteger getUid() {
        return uid;
    }

    public void setMtgGuid(String mtgGuid) {
        this.mtgGuid = mtgGuid;
    }

    public String getMtgGuid() {
        return mtgGuid;
    }

    public void setCboId(BigInteger cboId) {
        this.cboId = cboId;
    }

    public BigInteger getCboId() {
        return cboId;
    }

    public void setMemId(BigInteger memId) {
        this.memId = memId;
    }

    public BigInteger getMemId() {
        return memId;
    }

    public void setMtgNo(Integer mtgNo) {
        this.mtgNo = mtgNo;
    }

    public Integer getMtgNo() {
        return mtgNo;
    }

    public void setAuid(Integer auid) {
        this.auid = auid;
    }

    public Integer getAuid() {
        return auid;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getType() {
        return type;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    public Integer getAmount() {
        return amount;
    }



    public void setModePayment(Integer modePayment) {
        this.modePayment = modePayment;
    }

    public Integer getModePayment() {
        return modePayment;
    }

    public void setBankCode(String bankCode) {
        this.bankCode = bankCode;
    }

    public String getBankCode() {
        return bankCode;
    }

    public void setTransactionNo(String transactionNo) {
        this.transactionNo = transactionNo;
    }

    public String getTransactionNo() {
        return transactionNo;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    public String getCreatedBy() {
        return createdBy;
    }


    public void setUpdatedBy(String updatedBy) {
        this.updatedBy = updatedBy;
    }

    public String getUpdatedBy() {
        return updatedBy;
    }



    public void setUploadedBy(String uploadedBy) {
        this.uploadedBy = uploadedBy;
    }

    public String getUploadedBy() {
        return uploadedBy;
    }

    public void setUploadedOn(Timestamp uploadedOn) {
        this.uploadedOn = uploadedOn;
    }

    public Timestamp getUploadedOn() {
        return uploadedOn;
    }

    @Override
    public String toString() {
        return "ShgFinTxnDetMemEntity{" +
                "uid=" + uid + '\'' +
                "mtgGuid=" + mtgGuid + '\'' +
                "cboId=" + cboId + '\'' +
                "memId=" + memId + '\'' +
                "mtgNo=" + mtgNo + '\'' +
                "auid=" + auid + '\'' +
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

    public Timestamp getCreatedOn1() {
        return createdOn1;
    }

    public void setCreatedOn1(Timestamp createdOn1) {
        this.createdOn1 = createdOn1;
    }

    public Timestamp getUpdatedOn1() {
        return updatedOn1;
    }

    public void setUpdatedOn1(Timestamp updatedOn1) {
        this.updatedOn1 = updatedOn1;
    }

    public BigInteger getShgMtgDetUid() {
        return shgMtgDetUid;
    }

    public void setShgMtgDetUid(BigInteger shgMtgDetUid) {
        this.shgMtgDetUid = shgMtgDetUid;
    }

	public BigInteger getShgMtgUid() {
		return shgMtgUid;
	}

	public void setShgMtgUid(BigInteger shgMtgUid) {
		this.shgMtgUid = shgMtgUid;
	}

    public Integer getReferenceMtgNo() {
        return referenceMtgNo;
    }

    public void setReferenceMtgNo(Integer referenceMtgNo) {
        this.referenceMtgNo = referenceMtgNo;
    }
}

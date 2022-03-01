package com.devglan.model;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigInteger;
import java.sql.Timestamp;

/**
 * $table.getTableComment()
 */
@Entity
@Table(name = "vo_fin_txn_det_mem")
public class VoFinTxnDetMemEntity implements Serializable {

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

    @Column(name = "mtg_date", nullable = false)
    private Timestamp mtgDate1;

    @Column(name = "auid", nullable = false)
    private Integer auid;

    @Column(name = "type")
    private String type;

    @Column(name = "amount")
    private Integer amount;

    @Column(name = "date_realisation")
    private Timestamp dateRealisation1;

    @Column(name = "mode_payment")
    private Integer modePayment;

    @Column(name = "bank_code")
    private String bankCode;

    @Column(name = "transaction_no")
    private String transactionNo;

    @Column(name = "voucher_number")
    private String voucherNumber;

    @Column(name = "voucher_date")
    private Timestamp voucherDate1;

    @Column(name = "narration", nullable = false)
    private String narration;

    @Column(name = "add_lref_date")
    private Timestamp addlRefDate1;

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

    @Column(name = "vo_mtg_det_uid")
    private BigInteger voMtgDetUid;
    
    @Column(name = "vo_mtg_uid", nullable = false)
    private BigInteger voMtgUid;
    
    @Column(name = "reference_mtg_no")
    private Integer referenceMtgNo;

    @Column(name = "org_type")
	private Integer orgType;

    public BigInteger getVoMtgDetUid() {
        return voMtgDetUid;
    }

    public void setVoMtgDetUid(BigInteger voMtgDetUid) {
        this.voMtgDetUid = voMtgDetUid;
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
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

    public Timestamp getMtgDate1() {
        return mtgDate1;
    }

    public void setMtgDate1(Timestamp mtgDate1) {
        this.mtgDate1 = mtgDate1;
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

    public String getVoucherNumber() {
        return voucherNumber;
    }

    public void setVoucherNumber(String voucherNumber) {
        this.voucherNumber = voucherNumber;
    }

    public Timestamp getVoucherDate1() {
        return voucherDate1;
    }

    public void setVoucherDate1(Timestamp voucherDate1) {
        this.voucherDate1 = voucherDate1;
    }

    public String getNarration() {
        return narration;
    }

    public void setNarration(String narration) {
        this.narration = narration;
    }

    public Timestamp getAddlRefDate1() {
        return addlRefDate1;
    }

    public void setAddlRefDate1(Timestamp addlRefDate1) {
        this.addlRefDate1 = addlRefDate1;
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

    

    public BigInteger getVoMtgUid() {
		return voMtgUid;
	}

	public void setVoMtgUid(BigInteger voMtgUid) {
		this.voMtgUid = voMtgUid;
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

	@Override
    public String toString() {
        return "VoFinTxnDetMemEntity{" +
                "uid=" + uid + '\'' +
                "mtgGuid=" + mtgGuid + '\'' +
                "cboId=" + cboId + '\'' +
                "memId=" + memId + '\'' +
                "mtgNo=" + mtgNo + '\'' +
                "mtgDate=" + mtgDate1 + '\'' +
                 "voMtgUid=" + voMtgUid + '\'' +
                "auid=" + auid + '\'' +
                "type=" + type + '\'' +
                "amount=" + amount + '\'' +
                "dateRealisation=" + dateRealisation1 + '\'' +
                "modePayment=" + modePayment + '\'' +
                "bankCode=" + bankCode + '\'' +
                "transactionNo=" + transactionNo + '\'' +
                "voucherNo=" + voucherNumber + '\'' +
                "voucherDate=" + voucherDate1 + '\'' +
                "narration=" + narration + '\'' +
                "addlRefDate=" + addlRefDate1 + '\'' +
                "createdBy=" + createdBy + '\'' +
                "createdOn=" + createdOn1 + '\'' +
                "updatedBy=" + updatedBy + '\'' +
                "updatedOn=" + updatedOn1 + '\'' +
                "uploadedBy=" + uploadedBy + '\'' +
                "uploadedOn=" + uploadedOn + '\'' +
                '}';

    }
}
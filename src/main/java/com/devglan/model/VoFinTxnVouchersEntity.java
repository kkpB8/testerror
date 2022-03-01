package com.devglan.model;

import java.io.Serializable;
import java.math.BigInteger;
import java.sql.Timestamp;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "vo_fin_txn_vouchers")
public class VoFinTxnVouchersEntity implements Serializable {

    @Id
    @Column(name = "uid", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private BigInteger uid;

    @Column(name = "vo_mtg_uid")
    private BigInteger voMtgUid ;

    @Column(name = "cbo_id", nullable = false)
    private BigInteger cboId;

    @Column(name = "member_id")
    private BigInteger memberId;

    @Column(name = "mtg_no", nullable = false)
    private Integer mtgNo;

    @Column(name = "mode_payment", nullable = false)
    private Integer modePayment;

    @Column(name = "bank_code")
    private String bankCode;

    /*@Column(name = "ref_mtg_no", nullable = false)
    private Integer refMtgNo;*/

    @Column(name = "transaction_no")
    private String transactionNo;

    @Column(name = "cheque_no")
    private String chequeNo;

    @Column(name = "amount")
    private Integer amount;

    @Column(name = "voucher_date")
    private Timestamp voucherDate1;

    @Column(name = "voucher_no")
    private String voucherNo;

    @Column(name = "date_realisation")
    private Timestamp dateRealisation1;

    @Column(name = "auid")
    private Integer auid;

    @Column(name = "voucher_type")
    private Short voucherType;


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

    public BigInteger getUid() {
        return uid;
    }

    public void setUid(BigInteger uid) {
        this.uid = uid;
    }

    public BigInteger getVoMtgUid() {
        return voMtgUid;
    }

    public void setVoMtgUid(BigInteger voMtgUid) {
        this.voMtgUid = voMtgUid;
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

    public String getChequeNo() {
        return chequeNo;
    }

    public void setChequeNo(String chequeNo) {
        this.chequeNo = chequeNo;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    

    public String getVoucherNo() {
        return voucherNo;
    }

    public void setVoucherNo(String voucherNo) {
        this.voucherNo = voucherNo;
    }

    

    public Timestamp getVoucherDate1() {
		return voucherDate1;
	}

	public void setVoucherDate1(Timestamp voucherDate1) {
		this.voucherDate1 = voucherDate1;
	}

	public Timestamp getDateRealisation1() {
		return dateRealisation1;
	}

	public void setDateRealisation1(Timestamp dateRealisation1) {
		this.dateRealisation1 = dateRealisation1;
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

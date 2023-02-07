package com.devglan.model;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigInteger;
import java.sql.Timestamp;

@Entity
@Table(name = "shg_mem_settlement")
public class ShgMemSettlementEntity implements Serializable  {

    @Id
    @Column(name = "uid", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private BigInteger uid;

    @Column(name = "cbo_id", nullable = false)
    private BigInteger cboId;

    @Column(name = "mem_id", nullable = false)
    private BigInteger memId;

    @Column(name = "mtg_guid", nullable = false)
    private String mtgGuid;

    @Column(name = "mtg_no", nullable = false)
    private Integer mtgNo;

    @Column(name = "mtg_date")
    private Timestamp mtgDate1;

    @Column(name = "sav_comp")
    private Integer savComp;

    @Column(name = "sav_vol")
    private Integer savVol;

    @Column(name = "share_capital")
    private Integer shareCapital;

    @Column(name = "member_surplus")
    private Integer memberSurplus;

    @Column(name = "loan_outstanding")
    private Integer loanOutstanding;

    @Column(name = "member_deficit")
    private Integer memberDeficit;

    @Column(name = "other")
    private Integer other;

    @Column(name = "other_specify")
    private Integer otherSpecify;

    @Column(name = "available_amt")
    private Integer availableAmt;

    @Column(name = "paid_amt")
    private Integer paidAmt;

    @Column(name = "receiver_name")
    private String receiverName;

    @Column(name = "receiver_relation")
    private Integer receiverRelation;

    @Column(name = "reason")
    private Integer reason;

    @Column(name = "payment_date")
    private Timestamp paymentDate1;

    @Column(name = "settlement_status")
    private Integer settlementStatus;

    @Column(name = "mode_payment")
    private Integer modePayment;

    @Column(name = "bank_code")
    private String bankCode;

    @Column(name = "transaction_no")
    private String transactionNo;

    @Column(name = "narration")
    private String narration;

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

    public BigInteger getMemId() {
        return memId;
    }

    public void setMemId(BigInteger memId) {
        this.memId = memId;
    }

    public String getMtgGuid() {
        return mtgGuid;
    }

    public void setMtgGuid(String mtgGuid) {
        this.mtgGuid = mtgGuid;
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

    public Integer getSavComp() {
        return savComp;
    }

    public void setSavComp(Integer savComp) {
        this.savComp = savComp;
    }

    public Integer getSavVol() {
        return savVol;
    }

    public void setSavVol(Integer savVol) {
        this.savVol = savVol;
    }

    public Integer getShareCapital() {
        return shareCapital;
    }

    public void setShareCapital(Integer shareCapital) {
        this.shareCapital = shareCapital;
    }

    public Integer getMemberSurplus() {
        return memberSurplus;
    }

    public void setMemberSurplus(Integer memberSurplus) {
        this.memberSurplus = memberSurplus;
    }

    public Integer getLoanOutstanding() {
        return loanOutstanding;
    }

    public void setLoanOutstanding(Integer loanOutstanding) {
        this.loanOutstanding = loanOutstanding;
    }

    public Integer getMemberDeficit() {
        return memberDeficit;
    }

    public void setMemberDeficit(Integer memberDeficit) {
        this.memberDeficit = memberDeficit;
    }

    public Integer getOther() {
        return other;
    }

    public void setOther(Integer other) {
        this.other = other;
    }



    public Integer getAvailableAmt() {
        return availableAmt;
    }

    public void setAvailableAmt(Integer availableAmt) {
        this.availableAmt = availableAmt;
    }

    public Integer getPaidAmt() {
        return paidAmt;
    }

    public void setPaidAmt(Integer paidAmt) {
        this.paidAmt = paidAmt;
    }

    public String getReceiverName() {
        return receiverName;
    }

    public void setReceiverName(String receiverName) {
        this.receiverName = receiverName;
    }

    public Integer getReceiverRelation() {
        return receiverRelation;
    }

    public void setReceiverRelation(Integer receiverRelation) {
        this.receiverRelation = receiverRelation;
    }

    public Integer getReason() {
        return reason;
    }

    public void setReason(Integer reason) {
        this.reason = reason;
    }

    public Timestamp getPaymentDate1() {
        return paymentDate1;
    }

    public void setPaymentDate1(Timestamp paymentDate1) {
        this.paymentDate1 = paymentDate1;
    }

    public Integer getSettlementStatus() {
        return settlementStatus;
    }

    public void setSettlementStatus(Integer settlementStatus) {
        this.settlementStatus = settlementStatus;
    }

    public Integer getModePayment() {
        return modePayment;
    }

    public void setModePayment(Integer modePayment) {
        this.modePayment = modePayment;
    }



    public String getTransactionNo() {
        return transactionNo;
    }

    public void setTransactionNo(String transactionNo) {
        this.transactionNo = transactionNo;
    }

    public String getNarration() {
        return narration;
    }

    public void setNarration(String narration) {
        this.narration = narration;
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


    public Integer getOtherSpecify() {
        return otherSpecify;
    }

    public void setOtherSpecify(Integer otherSpecify) {
        this.otherSpecify = otherSpecify;
    }

    public String getBankCode() {
        return bankCode;
    }

    public void setBankCode(String bankCode) {
        this.bankCode = bankCode;
    }
}

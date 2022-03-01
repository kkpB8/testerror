package com.devglan.domain;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.math.BigInteger;

public class ShgMemSettlement {

    private BigInteger uid;
    private BigInteger cboId;
    private BigInteger memId;
    private String mtgGuid;
    private Integer mtgNo;
    private Long mtgDate;
    private Integer savComp;
    private Integer savVol;
    private Integer shareCapital;
    private Integer memberSurplus;
    private Integer loanOutstanding;
    private Integer memberDeficit;
    private Integer other;
    private Integer other_specify;
    private Integer availableAmt;
    private Integer paidAmt;
    private String receiverName;
    private Integer receiverRelation;
    private Integer reason;
    private Long paymentDate;
    private Integer settlementStatus;
    private Integer modePayment;
    private String bank_code;
    private String transactionNo;
    private String narration;
    private Long createdOn;
    private String createdBy;
    private Long updatedOn;
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

    public Long getMtgDate() {
        return mtgDate;
    }

    public void setMtgDate(Long mtgDate) {
        this.mtgDate = mtgDate;
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

    public Integer getOther_specify() {
        return other_specify;
    }

    public void setOther_specify(Integer other_specify) {
        this.other_specify = other_specify;
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

    public Long getPaymentDate() {
        return paymentDate;
    }

    public void setPaymentDate(Long paymentDate) {
        this.paymentDate = paymentDate;
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

    public String getBank_code() {
        return bank_code;
    }

    public void setBank_code(String bank_code) {
        this.bank_code = bank_code;
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

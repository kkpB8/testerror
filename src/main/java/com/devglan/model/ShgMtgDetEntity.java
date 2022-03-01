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
@Table(name = "shg_mtg_det")
public class ShgMtgDetEntity implements Serializable {

    private static final long serialVersionUID = 1L;

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

    @Column(name = "group_m_code", nullable = false)
    private Long groupMCode;

    @Column(name = "sno", nullable = false)
    private Integer sno;

    @Column(name = "member_name")
    private String memberName;

    @Column(name = "attendance")
    private String attendance;

    @Column(name = "sav_comp_ob")
    private Integer savCompOb;

    @Column(name = "sav_comp")
    private Integer savComp;

    @Column(name = "sav_comp_cb")
    private Integer savCompCb;

    @Column(name = "sav_vol_ob")
    private Integer savVolOb;

    @Column(name = "sav_vol")
    private Integer savVol;

    @Column(name = "sav_vol_cb")
    private Integer savVolCb;

    @Column(name = "other_receipts")
    private Integer otherReceipts;

    @Column(name = "other_payments")
    private Integer otherPayments;

    @Column(name = "other_receipts_type")
    private Integer otherReceiptsType;

    @Column(name = "other_payments_type")
    private Integer otherPaymentsType;

    @Column(name = "loan1_no")
    private Integer loan1No;

    @Column(name = "loan2_no")
    private Integer loan2No;

    @Column(name = "loan3_no")
    private Integer loan3No;

    @Column(name = "loan4_no")
    private Integer loan4No;

    @Column(name = "loan5_no")
    private Integer loan5No;

    @Column(name = "loan1_ob")
    private Integer loan1Ob;

    @Column(name = "loan2_ob")
    private Integer loan2Ob;

    @Column(name = "loan3_ob")
    private Integer loan3Ob;

    @Column(name = "loan4_ob")
    private Integer loan4Ob;

    @Column(name = "loan5_ob")
    private Integer loan5Ob;

    @Column(name = "loan1_int_ob")
    private Integer loan1IntOb;

    @Column(name = "loan2_int_ob")
    private Integer loan2IntOb;

    @Column(name = "loan3_int_ob")
    private Integer loan3IntOb;

    @Column(name = "loan4_int_ob")
    private Integer loan4IntOb;

    @Column(name = "loan5_int_ob")
    private Integer loan5IntOb;

    @Column(name = "loan1_repaid")
    private Integer loan1Repaid;

    @Column(name = "loan2_repaid")
    private Integer loan2Repaid;

    @Column(name = "loan3_repaid")
    private Integer loan3Repaid;

    @Column(name = "loan4_repaid")
    private Integer loan4Repaid;

    @Column(name = "loan5_repaid")
    private Integer loan5Repaid;

    @Column(name = "loan1_repaid_cum")
    private Integer loan1RepaidCum;

    @Column(name = "loan2_repaid_cum")
    private Integer loan2RepaidCum;

    @Column(name = "loan3_repaid_cum")
    private Integer loan3RepaidCum;

    @Column(name = "loan4_repaid_cum")
    private Integer loan4RepaidCum;

    @Column(name = "loan5_repaid_cum")
    private Integer loan5RepaidCum;

    @Column(name = "interest1_repaid")
    private Integer interest1Repaid;

    @Column(name = "interest2_repaid")
    private Integer interest2Repaid;

    @Column(name = "interest3_repaid")
    private Integer interest3Repaid;

    @Column(name = "interest4_repaid")
    private Integer interest4Repaid;

    @Column(name = "interest5_repaid")
    private Integer interest5Repaid;

    @Column(name = "loan1_cb")
    private Integer loan1Cb;

    @Column(name = "loan2_cb")
    private Integer loan2Cb;

    @Column(name = "loan3_cb")
    private Integer loan3Cb;

    @Column(name = "loan4_cb")
    private Integer loan4Cb;

    @Column(name = "loan5_cb")
    private Integer loan5Cb;

    @Column(name = "loan1_int_cb")
    private Integer loan1IntCb;

    @Column(name = "loan2_int_cb")
    private Integer loan2IntCb;

    @Column(name = "loan3_int_cb")
    private Integer loan3IntCb;

    @Column(name = "loan4_int_cb")
    private Integer loan4IntCb;

    @Column(name = "loan5_int_cb")
    private Integer loan5IntCb;

    @Column(name = "loan1_int_accrued")
    private Integer loan1IntAccrued;

    @Column(name = "loan2_int_accrued")
    private Integer loan2IntAccrued;

    @Column(name = "loan3_int_accrued")
    private Integer loan3IntAccrued;

    @Column(name = "loan4_int_accrued")
    private Integer loan4IntAccrued;

    @Column(name = "loan5_int_accrued")
    private Integer loan5IntAccrued;

    @Column(name = "penalty")
    private Integer penalty;

    @Column(name = "loan_no_disbursed")
    private Integer loanNoDisbursed;

    @Column(name = "loan_amt_disbursed")
    private Integer loanAmtDisbursed;

    @Column(name = "sav_comp_withdrawal")
    private Integer savCompWithdrawal;

    @Column(name = "sav_vol_withdrawal")
    private Integer savVolWithdrawal;

    @Column(name = "sav_comp_interest")
    private Integer savCompInterest;

    @Column(name = "sav_vol_interest")
    private Integer savVolInterest;

    @Column(name = "status")
    private String status;

    @Column(name = "zero_mtg_attn")
    private Integer zeroMtgAttn;

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

    @Column(name = "shg_mtg_uid")
    private BigInteger shgMtgUid;
    //030921 @mohit
    @Column(name = "reference_mtg_no")
    private Integer referenceMtgNo;

    public void setUid(BigInteger uid) {
        this.uid = uid;
    }

    public BigInteger getUid() {
        return uid;
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

    public void setMtgGuid(String mtgGuid) {
        this.mtgGuid = mtgGuid;
    }

    public String getMtgGuid() {
        return mtgGuid;
    }

    public void setMtgNo(Integer mtgNo) {
        this.mtgNo = mtgNo;
    }

    public Integer getMtgNo() {
        return mtgNo;
    }


    public void setGroupMCode(Long groupMCode) {
        this.groupMCode = groupMCode;
    }

    public Long getGroupMCode() {
        return groupMCode;
    }

    public void setSno(Integer sno) {
        this.sno = sno;
    }

    public Integer getSno() {
        return sno;
    }

    public void setMemberName(String memberName) {
        this.memberName = memberName;
    }

    public String getMemberName() {
        return memberName;
    }

    public void setAttendance(String attendance) {
        this.attendance = attendance;
    }

    public String getAttendance() {
        return attendance;
    }

    public void setSavCompOb(Integer savCompOb) {
        this.savCompOb = savCompOb;
    }

    public Integer getSavCompOb() {
        return savCompOb;
    }

    public void setSavComp(Integer savComp) {
        this.savComp = savComp;
    }

    public Integer getSavComp() {
        return savComp;
    }

    public void setSavCompCb(Integer savCompCb) {
        this.savCompCb = savCompCb;
    }

    public Integer getSavCompCb() {
        return savCompCb;
    }

    public void setSavVolOb(Integer savVolOb) {
        this.savVolOb = savVolOb;
    }

    public Integer getSavVolOb() {
        return savVolOb;
    }

    public void setSavVol(Integer savVol) {
        this.savVol = savVol;
    }

    public Integer getSavVol() {
        return savVol;
    }

    public void setSavVolCb(Integer savVolCb) {
        this.savVolCb = savVolCb;
    }

    public Integer getSavVolCb() {
        return savVolCb;
    }

    public void setOtherReceipts(Integer otherReceipts) {
        this.otherReceipts = otherReceipts;
    }

    public Integer getOtherReceipts() {
        return otherReceipts;
    }

    public void setOtherPayments(Integer otherPayments) {
        this.otherPayments = otherPayments;
    }

    public Integer getOtherPayments() {
        return otherPayments;
    }

    public void setOtherReceiptsType(Integer otherReceiptsType) {
        this.otherReceiptsType = otherReceiptsType;
    }

    public Integer getOtherReceiptsType() {
        return otherReceiptsType;
    }

    public void setOtherPaymentsType(Integer otherPaymentsType) {
        this.otherPaymentsType = otherPaymentsType;
    }

    public Integer getOtherPaymentsType() {
        return otherPaymentsType;
    }

    public void setLoan1No(Integer loan1No) {
        this.loan1No = loan1No;
    }

    public Integer getLoan1No() {
        return loan1No;
    }

    public void setLoan2No(Integer loan2No) {
        this.loan2No = loan2No;
    }

    public Integer getLoan2No() {
        return loan2No;
    }

    public void setLoan3No(Integer loan3No) {
        this.loan3No = loan3No;
    }

    public Integer getLoan3No() {
        return loan3No;
    }

    public void setLoan4No(Integer loan4No) {
        this.loan4No = loan4No;
    }

    public Integer getLoan4No() {
        return loan4No;
    }

    public void setLoan5No(Integer loan5No) {
        this.loan5No = loan5No;
    }

    public Integer getLoan5No() {
        return loan5No;
    }

    public void setLoan1Ob(Integer loan1Ob) {
        this.loan1Ob = loan1Ob;
    }

    public Integer getLoan1Ob() {
        return loan1Ob;
    }

    public void setLoan2Ob(Integer loan2Ob) {
        this.loan2Ob = loan2Ob;
    }

    public Integer getLoan2Ob() {
        return loan2Ob;
    }

    public void setLoan3Ob(Integer loan3Ob) {
        this.loan3Ob = loan3Ob;
    }

    public Integer getLoan3Ob() {
        return loan3Ob;
    }

    public void setLoan4Ob(Integer loan4Ob) {
        this.loan4Ob = loan4Ob;
    }

    public Integer getLoan4Ob() {
        return loan4Ob;
    }

    public void setLoan5Ob(Integer loan5Ob) {
        this.loan5Ob = loan5Ob;
    }

    public Integer getLoan5Ob() {
        return loan5Ob;
    }

    public void setLoan1IntOb(Integer loan1IntOb) {
        this.loan1IntOb = loan1IntOb;
    }

    public Integer getLoan1IntOb() {
        return loan1IntOb;
    }

    public void setLoan2IntOb(Integer loan2IntOb) {
        this.loan2IntOb = loan2IntOb;
    }

    public Integer getLoan2IntOb() {
        return loan2IntOb;
    }

    public void setLoan3IntOb(Integer loan3IntOb) {
        this.loan3IntOb = loan3IntOb;
    }

    public Integer getLoan3IntOb() {
        return loan3IntOb;
    }

    public void setLoan4IntOb(Integer loan4IntOb) {
        this.loan4IntOb = loan4IntOb;
    }

    public Integer getLoan4IntOb() {
        return loan4IntOb;
    }

    public void setLoan5IntOb(Integer loan5IntOb) {
        this.loan5IntOb = loan5IntOb;
    }

    public Integer getLoan5IntOb() {
        return loan5IntOb;
    }

    public void setLoan1Repaid(Integer loan1Repaid) {
        this.loan1Repaid = loan1Repaid;
    }

    public Integer getLoan1Repaid() {
        return loan1Repaid;
    }

    public void setLoan2Repaid(Integer loan2Repaid) {
        this.loan2Repaid = loan2Repaid;
    }

    public Integer getLoan2Repaid() {
        return loan2Repaid;
    }

    public void setLoan3Repaid(Integer loan3Repaid) {
        this.loan3Repaid = loan3Repaid;
    }

    public Integer getLoan3Repaid() {
        return loan3Repaid;
    }

    public void setLoan4Repaid(Integer loan4Repaid) {
        this.loan4Repaid = loan4Repaid;
    }

    public Integer getLoan4Repaid() {
        return loan4Repaid;
    }

    public void setLoan5Repaid(Integer loan5Repaid) {
        this.loan5Repaid = loan5Repaid;
    }

    public Integer getLoan5Repaid() {
        return loan5Repaid;
    }

    public void setLoan1RepaidCum(Integer loan1RepaidCum) {
        this.loan1RepaidCum = loan1RepaidCum;
    }

    public Integer getLoan1RepaidCum() {
        return loan1RepaidCum;
    }

    public void setLoan2RepaidCum(Integer loan2RepaidCum) {
        this.loan2RepaidCum = loan2RepaidCum;
    }

    public Integer getLoan2RepaidCum() {
        return loan2RepaidCum;
    }

    public void setLoan3RepaidCum(Integer loan3RepaidCum) {
        this.loan3RepaidCum = loan3RepaidCum;
    }

    public Integer getLoan3RepaidCum() {
        return loan3RepaidCum;
    }

    public void setLoan4RepaidCum(Integer loan4RepaidCum) {
        this.loan4RepaidCum = loan4RepaidCum;
    }

    public Integer getLoan4RepaidCum() {
        return loan4RepaidCum;
    }

    public void setLoan5RepaidCum(Integer loan5RepaidCum) {
        this.loan5RepaidCum = loan5RepaidCum;
    }

    public Integer getLoan5RepaidCum() {
        return loan5RepaidCum;
    }

    public void setInterest1Repaid(Integer interest1Repaid) {
        this.interest1Repaid = interest1Repaid;
    }

    public Integer getInterest1Repaid() {
        return interest1Repaid;
    }

    public void setInterest2Repaid(Integer interest2Repaid) {
        this.interest2Repaid = interest2Repaid;
    }

    public Integer getInterest2Repaid() {
        return interest2Repaid;
    }

    public void setInterest3Repaid(Integer interest3Repaid) {
        this.interest3Repaid = interest3Repaid;
    }

    public Integer getInterest3Repaid() {
        return interest3Repaid;
    }

    public void setInterest4Repaid(Integer interest4Repaid) {
        this.interest4Repaid = interest4Repaid;
    }

    public Integer getInterest4Repaid() {
        return interest4Repaid;
    }

    public void setInterest5Repaid(Integer interest5Repaid) {
        this.interest5Repaid = interest5Repaid;
    }

    public Integer getInterest5Repaid() {
        return interest5Repaid;
    }

    public void setLoan1Cb(Integer loan1Cb) {
        this.loan1Cb = loan1Cb;
    }

    public Integer getLoan1Cb() {
        return loan1Cb;
    }

    public void setLoan2Cb(Integer loan2Cb) {
        this.loan2Cb = loan2Cb;
    }

    public Integer getLoan2Cb() {
        return loan2Cb;
    }

    public void setLoan3Cb(Integer loan3Cb) {
        this.loan3Cb = loan3Cb;
    }

    public Integer getLoan3Cb() {
        return loan3Cb;
    }

    public void setLoan4Cb(Integer loan4Cb) {
        this.loan4Cb = loan4Cb;
    }

    public Integer getLoan4Cb() {
        return loan4Cb;
    }

    public void setLoan5Cb(Integer loan5Cb) {
        this.loan5Cb = loan5Cb;
    }

    public Integer getLoan5Cb() {
        return loan5Cb;
    }

    public void setLoan1IntCb(Integer loan1IntCb) {
        this.loan1IntCb = loan1IntCb;
    }

    public Integer getLoan1IntCb() {
        return loan1IntCb;
    }

    public void setLoan2IntCb(Integer loan2IntCb) {
        this.loan2IntCb = loan2IntCb;
    }

    public Integer getLoan2IntCb() {
        return loan2IntCb;
    }

    public void setLoan3IntCb(Integer loan3IntCb) {
        this.loan3IntCb = loan3IntCb;
    }

    public Integer getLoan3IntCb() {
        return loan3IntCb;
    }

    public void setLoan4IntCb(Integer loan4IntCb) {
        this.loan4IntCb = loan4IntCb;
    }

    public Integer getLoan4IntCb() {
        return loan4IntCb;
    }

    public void setLoan5IntCb(Integer loan5IntCb) {
        this.loan5IntCb = loan5IntCb;
    }

    public Integer getLoan5IntCb() {
        return loan5IntCb;
    }

    public void setLoan1IntAccrued(Integer loan1IntAccrued) {
        this.loan1IntAccrued = loan1IntAccrued;
    }

    public Integer getLoan1IntAccrued() {
        return loan1IntAccrued;
    }

    public void setLoan2IntAccrued(Integer loan2IntAccrued) {
        this.loan2IntAccrued = loan2IntAccrued;
    }

    public Integer getLoan2IntAccrued() {
        return loan2IntAccrued;
    }

    public void setLoan3IntAccrued(Integer loan3IntAccrued) {
        this.loan3IntAccrued = loan3IntAccrued;
    }

    public Integer getLoan3IntAccrued() {
        return loan3IntAccrued;
    }

    public void setLoan4IntAccrued(Integer loan4IntAccrued) {
        this.loan4IntAccrued = loan4IntAccrued;
    }

    public Integer getLoan4IntAccrued() {
        return loan4IntAccrued;
    }

    public void setLoan5IntAccrued(Integer loan5IntAccrued) {
        this.loan5IntAccrued = loan5IntAccrued;
    }

    public Integer getLoan5IntAccrued() {
        return loan5IntAccrued;
    }

    public void setPenalty(Integer penalty) {
        this.penalty = penalty;
    }

    public Integer getPenalty() {
        return penalty;
    }

    public void setLoanNoDisbursed(Integer loanNoDisbursed) {
        this.loanNoDisbursed = loanNoDisbursed;
    }

    public Integer getLoanNoDisbursed() {
        return loanNoDisbursed;
    }

    public void setLoanAmtDisbursed(Integer loanAmtDisbursed) {
        this.loanAmtDisbursed = loanAmtDisbursed;
    }

    public Integer getLoanAmtDisbursed() {
        return loanAmtDisbursed;
    }

    public void setSavCompWithdrawal(Integer savCompWithdrawal) {
        this.savCompWithdrawal = savCompWithdrawal;
    }

    public Integer getSavCompWithdrawal() {
        return savCompWithdrawal;
    }

    public void setSavVolWithdrawal(Integer savVolWithdrawal) {
        this.savVolWithdrawal = savVolWithdrawal;
    }

    public Integer getSavVolWithdrawal() {
        return savVolWithdrawal;
    }

    public void setSavCompInterest(Integer savCompInterest) {
        this.savCompInterest = savCompInterest;
    }

    public Integer getSavCompInterest() {
        return savCompInterest;
    }

    public void setSavVolInterest(Integer savVolInterest) {
        this.savVolInterest = savVolInterest;
    }

    public Integer getSavVolInterest() {
        return savVolInterest;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getStatus() {
        return status;
    }

    public void setZeroMtgAttn(Integer zeroMtgAttn) {
        this.zeroMtgAttn = zeroMtgAttn;
    }

    public Integer getZeroMtgAttn() {
        return zeroMtgAttn;
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


    public Timestamp getMtgDate1() {
        return mtgDate1;
    }

    public void setMtgDate1(Timestamp mtgDate1) {
        this.mtgDate1 = mtgDate1;
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

    @Override
    public String toString() {
        return "ShgMtgDetEntity{" +
                "uid=" + uid + '\'' +
                "cboId=" + cboId + '\'' +
                "memId=" + memId + '\'' +
                "mtgGuid=" + mtgGuid + '\'' +
                "mtgNo=" + mtgNo + '\'' +
                "mtgDate=" + mtgDate1 + '\'' +
                "groupMCode=" + groupMCode + '\'' +
                "sno=" + sno + '\'' +
                "memberName=" + memberName + '\'' +
                "attendance=" + attendance + '\'' +
                "savCompOb=" + savCompOb + '\'' +
                "savComp=" + savComp + '\'' +
                "savCompCb=" + savCompCb + '\'' +
                "savVolOb=" + savVolOb + '\'' +
                "savVol=" + savVol + '\'' +
                "savVolCb=" + savVolCb + '\'' +
                "otherReceipts=" + otherReceipts + '\'' +
                "otherPayments=" + otherPayments + '\'' +
                "otherReceiptsType=" + otherReceiptsType + '\'' +
                "otherPaymentsType=" + otherPaymentsType + '\'' +
                "loan1No=" + loan1No + '\'' +
                "loan2No=" + loan2No + '\'' +
                "loan3No=" + loan3No + '\'' +
                "loan4No=" + loan4No + '\'' +
                "loan5No=" + loan5No + '\'' +
                "loan1Ob=" + loan1Ob + '\'' +
                "loan2Ob=" + loan2Ob + '\'' +
                "loan3Ob=" + loan3Ob + '\'' +
                "loan4Ob=" + loan4Ob + '\'' +
                "loan5Ob=" + loan5Ob + '\'' +
                "loan1IntOb=" + loan1IntOb + '\'' +
                "loan2IntOb=" + loan2IntOb + '\'' +
                "loan3IntOb=" + loan3IntOb + '\'' +
                "loan4IntOb=" + loan4IntOb + '\'' +
                "loan5IntOb=" + loan5IntOb + '\'' +
                "loan1Repaid=" + loan1Repaid + '\'' +
                "loan2Repaid=" + loan2Repaid + '\'' +
                "loan3Repaid=" + loan3Repaid + '\'' +
                "loan4Repaid=" + loan4Repaid + '\'' +
                "loan5Repaid=" + loan5Repaid + '\'' +
                "loan1RepaidCum=" + loan1RepaidCum + '\'' +
                "loan2RepaidCum=" + loan2RepaidCum + '\'' +
                "loan3RepaidCum=" + loan3RepaidCum + '\'' +
                "loan4RepaidCum=" + loan4RepaidCum + '\'' +
                "loan5RepaidCum=" + loan5RepaidCum + '\'' +
                "interest1Repaid=" + interest1Repaid + '\'' +
                "interest2Repaid=" + interest2Repaid + '\'' +
                "interest3Repaid=" + interest3Repaid + '\'' +
                "interest4Repaid=" + interest4Repaid + '\'' +
                "interest5Repaid=" + interest5Repaid + '\'' +
                "loan1Cb=" + loan1Cb + '\'' +
                "loan2Cb=" + loan2Cb + '\'' +
                "loan3Cb=" + loan3Cb + '\'' +
                "loan4Cb=" + loan4Cb + '\'' +
                "loan5Cb=" + loan5Cb + '\'' +
                "loan1IntCb=" + loan1IntCb + '\'' +
                "loan2IntCb=" + loan2IntCb + '\'' +
                "loan3IntCb=" + loan3IntCb + '\'' +
                "loan4IntCb=" + loan4IntCb + '\'' +
                "loan5IntCb=" + loan5IntCb + '\'' +
                "loan1IntAccrued=" + loan1IntAccrued + '\'' +
                "loan2IntAccrued=" + loan2IntAccrued + '\'' +
                "loan3IntAccrued=" + loan3IntAccrued + '\'' +
                "loan4IntAccrued=" + loan4IntAccrued + '\'' +
                "loan5IntAccrued=" + loan5IntAccrued + '\'' +
                "penalty=" + penalty + '\'' +
                "loanNoDisbursed=" + loanNoDisbursed + '\'' +
                "loanAmtDisbursed=" + loanAmtDisbursed + '\'' +
                "savCompWithdrawal=" + savCompWithdrawal + '\'' +
                "savVolWithdrawal=" + savVolWithdrawal + '\'' +
                "savCompInterest=" + savCompInterest + '\'' +
                "savVolInterest=" + savVolInterest + '\'' +
                "status=" + status + '\'' +
                "zeroMtgAttn=" + zeroMtgAttn + '\'' +
                "createdBy=" + createdBy + '\'' +
                "createdOn=" + createdOn1 + '\'' +
                "updatedBy=" + updatedBy + '\'' +
                "updatedOn=" + updatedOn1 + '\'' +
                "uploadedBy=" + uploadedBy + '\'' +
                "uploadedOn=" + uploadedOn + '\'' +
                '}';
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
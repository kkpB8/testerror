package com.devglan.domain;

import org.hibernate.validator.constraints.NotBlank;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.math.BigInteger;
import java.util.List;

public class ShgMtgDet {
    private BigInteger uid;
    private BigInteger cboId;
    private BigInteger memId;
    private Long groupMCode;
    private Integer sno;
    private String memberName;
    private String attendance;
    private Integer savCompOb;
    private Integer savComp;
    private Integer savCompCb;
    private Integer savVolOb;
    private Integer savVol;
    private Integer savVolCb;
    private Integer otherReceipts;
    private Integer otherPayments;
    private Integer otherReceiptsType;
    private Integer otherPaymentsType;
    private Integer loan1No;
    private Integer loan2No;
    private Integer loan3No;
    private Integer loan4No;
    private Integer loan5No;
    private Integer loan1Ob;
    private Integer loan2Ob;
    private Integer loan3Ob;
    private Integer loan4Ob;
    private Integer loan5Ob;
    private Integer loan1IntOb;
    private Integer loan2IntOb;
    private Integer loan3IntOb;
    private Integer loan4IntOb;
    private Integer loan5IntOb;
    private Integer loan1Repaid;
    private Integer loan2Repaid;
    private Integer loan3Repaid;
    private Integer loan4Repaid;
    private Integer loan5Repaid;
    private Integer loan1RepaidCum;
    private Integer loan2RepaidCum;
    private Integer loan3RepaidCum;
    private Integer loan4RepaidCum;
    private Integer loan5RepaidCum;
    private Integer interest1Repaid;
    private Integer interest2Repaid;
    private Integer interest3Repaid;
    private Integer interest4Repaid;
    private Integer interest5Repaid;
    private Integer loan1Cb;
    private Integer loan2Cb;
    private Integer loan3Cb;
    private Integer loan4Cb;
    private Integer loan5Cb;
    private Integer loan1IntCb;
    private Integer loan2IntCb;
    private Integer loan3IntCb;
    private Integer loan4IntCb;
    private Integer loan5IntCb;
    private Integer loan1IntAccrued;
    private Integer loan2IntAccrued;
    private Integer loan3IntAccrued;
    private Integer loan4IntAccrued;
    private Integer loan5IntAccrued;
    private Integer penalty;
    private Integer loanNoDisbursed;
    private Integer loanAmtDisbursed;
    private Integer savCompWithdrawal;
    private Integer savVolWithdrawal;
    private Integer savCompInterest;
    private Integer savVolInterest;
    private String status;
    private Integer zeroMtgAttn;
    private Long createdOn;
    private String createdBy;
    private Long updatedOn;
    private String updatedBy;
    //030921 @mohit
    private Integer referenceMtgNo;


    private List<ShgMemLoanTxn> shgMemberLoanTransactionList;
    private List<ShgMemSettlement> shgMemberSettlementList;
    private List<ShgFinTxnDetMem> shgFinanceTransactionDetailMemberList;

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


    public List<ShgMemLoanTxn> getShgMemberLoanTransactionList() {
        return shgMemberLoanTransactionList;
    }

    public void setShgMemberLoanTransactionList(List<ShgMemLoanTxn> shgMemberLoanTransactionList) {
        this.shgMemberLoanTransactionList = shgMemberLoanTransactionList;
    }

    public Long getGroupMCode() {
        return groupMCode;
    }

    public void setGroupMCode(Long groupMCode) {
        this.groupMCode = groupMCode;
    }

    public Integer getSno() {
        return sno;
    }

    public void setSno(Integer sno) {
        this.sno = sno;
    }

    public String getMemberName() {
        return memberName;
    }

    public void setMemberName(String memberName) {
        this.memberName = memberName;
    }

    public String getAttendance() {
        return attendance;
    }

    public void setAttendance(String attendance) {
        this.attendance = attendance;
    }

    public Integer getSavCompOb() {
        return savCompOb;
    }

    public void setSavCompOb(Integer savCompOb) {
        this.savCompOb = savCompOb;
    }

    public Integer getSavComp() {
        return savComp;
    }

    public void setSavComp(Integer savComp) {
        this.savComp = savComp;
    }

    public Integer getSavCompCb() {
        return savCompCb;
    }

    public void setSavCompCb(Integer savCompCb) {
        this.savCompCb = savCompCb;
    }

    public Integer getSavVolOb() {
        return savVolOb;
    }

    public void setSavVolOb(Integer savVolOb) {
        this.savVolOb = savVolOb;
    }

    public Integer getSavVol() {
        return savVol;
    }

    public void setSavVol(Integer savVol) {
        this.savVol = savVol;
    }

    public Integer getSavVolCb() {
        return savVolCb;
    }

    public void setSavVolCb(Integer savVolCb) {
        this.savVolCb = savVolCb;
    }

    public Integer getOtherReceipts() {
        return otherReceipts;
    }

    public void setOtherReceipts(Integer otherReceipts) {
        this.otherReceipts = otherReceipts;
    }

    public Integer getOtherPayments() {
        return otherPayments;
    }

    public void setOtherPayments(Integer otherPayments) {
        this.otherPayments = otherPayments;
    }

    public Integer getOtherReceiptsType() {
        return otherReceiptsType;
    }

    public void setOtherReceiptsType(Integer otherReceiptsType) {
        this.otherReceiptsType = otherReceiptsType;
    }

    public Integer getOtherPaymentsType() {
        return otherPaymentsType;
    }

    public void setOtherPaymentsType(Integer otherPaymentsType) {
        this.otherPaymentsType = otherPaymentsType;
    }

    public Integer getLoan1No() {
        return loan1No;
    }

    public void setLoan1No(Integer loan1No) {
        this.loan1No = loan1No;
    }

    public Integer getLoan2No() {
        return loan2No;
    }

    public void setLoan2No(Integer loan2No) {
        this.loan2No = loan2No;
    }

    public Integer getLoan3No() {
        return loan3No;
    }

    public void setLoan3No(Integer loan3No) {
        this.loan3No = loan3No;
    }

    public Integer getLoan4No() {
        return loan4No;
    }

    public void setLoan4No(Integer loan4No) {
        this.loan4No = loan4No;
    }

    public Integer getLoan5No() {
        return loan5No;
    }

    public void setLoan5No(Integer loan5No) {
        this.loan5No = loan5No;
    }

    public Integer getLoan1Ob() {
        return loan1Ob;
    }

    public void setLoan1Ob(Integer loan1Ob) {
        this.loan1Ob = loan1Ob;
    }

    public Integer getLoan2Ob() {
        return loan2Ob;
    }

    public void setLoan2Ob(Integer loan2Ob) {
        this.loan2Ob = loan2Ob;
    }

    public Integer getLoan3Ob() {
        return loan3Ob;
    }

    public void setLoan3Ob(Integer loan3Ob) {
        this.loan3Ob = loan3Ob;
    }

    public Integer getLoan4Ob() {
        return loan4Ob;
    }

    public void setLoan4Ob(Integer loan4Ob) {
        this.loan4Ob = loan4Ob;
    }

    public Integer getLoan5Ob() {
        return loan5Ob;
    }

    public void setLoan5Ob(Integer loan5Ob) {
        this.loan5Ob = loan5Ob;
    }

    public Integer getLoan1IntOb() {
        return loan1IntOb;
    }

    public void setLoan1IntOb(Integer loan1IntOb) {
        this.loan1IntOb = loan1IntOb;
    }

    public Integer getLoan2IntOb() {
        return loan2IntOb;
    }

    public void setLoan2IntOb(Integer loan2IntOb) {
        this.loan2IntOb = loan2IntOb;
    }

    public Integer getLoan3IntOb() {
        return loan3IntOb;
    }

    public void setLoan3IntOb(Integer loan3IntOb) {
        this.loan3IntOb = loan3IntOb;
    }

    public Integer getLoan4IntOb() {
        return loan4IntOb;
    }

    public void setLoan4IntOb(Integer loan4IntOb) {
        this.loan4IntOb = loan4IntOb;
    }

    public Integer getLoan5IntOb() {
        return loan5IntOb;
    }

    public void setLoan5IntOb(Integer loan5IntOb) {
        this.loan5IntOb = loan5IntOb;
    }

    public Integer getLoan1Repaid() {
        return loan1Repaid;
    }

    public void setLoan1Repaid(Integer loan1Repaid) {
        this.loan1Repaid = loan1Repaid;
    }

    public Integer getLoan2Repaid() {
        return loan2Repaid;
    }

    public void setLoan2Repaid(Integer loan2Repaid) {
        this.loan2Repaid = loan2Repaid;
    }

    public Integer getLoan3Repaid() {
        return loan3Repaid;
    }

    public void setLoan3Repaid(Integer loan3Repaid) {
        this.loan3Repaid = loan3Repaid;
    }

    public Integer getLoan4Repaid() {
        return loan4Repaid;
    }

    public void setLoan4Repaid(Integer loan4Repaid) {
        this.loan4Repaid = loan4Repaid;
    }

    public Integer getLoan5Repaid() {
        return loan5Repaid;
    }

    public void setLoan5Repaid(Integer loan5Repaid) {
        this.loan5Repaid = loan5Repaid;
    }

    public Integer getLoan1RepaidCum() {
        return loan1RepaidCum;
    }

    public void setLoan1RepaidCum(Integer loan1RepaidCum) {
        this.loan1RepaidCum = loan1RepaidCum;
    }

    public Integer getLoan2RepaidCum() {
        return loan2RepaidCum;
    }

    public void setLoan2RepaidCum(Integer loan2RepaidCum) {
        this.loan2RepaidCum = loan2RepaidCum;
    }

    public Integer getLoan3RepaidCum() {
        return loan3RepaidCum;
    }

    public void setLoan3RepaidCum(Integer loan3RepaidCum) {
        this.loan3RepaidCum = loan3RepaidCum;
    }

    public Integer getLoan4RepaidCum() {
        return loan4RepaidCum;
    }

    public void setLoan4RepaidCum(Integer loan4RepaidCum) {
        this.loan4RepaidCum = loan4RepaidCum;
    }

    public Integer getLoan5RepaidCum() {
        return loan5RepaidCum;
    }

    public void setLoan5RepaidCum(Integer loan5RepaidCum) {
        this.loan5RepaidCum = loan5RepaidCum;
    }

    public Integer getInterest1Repaid() {
        return interest1Repaid;
    }

    public void setInterest1Repaid(Integer interest1Repaid) {
        this.interest1Repaid = interest1Repaid;
    }

    public Integer getInterest2Repaid() {
        return interest2Repaid;
    }

    public void setInterest2Repaid(Integer interest2Repaid) {
        this.interest2Repaid = interest2Repaid;
    }

    public Integer getInterest3Repaid() {
        return interest3Repaid;
    }

    public void setInterest3Repaid(Integer interest3Repaid) {
        this.interest3Repaid = interest3Repaid;
    }

    public Integer getInterest4Repaid() {
        return interest4Repaid;
    }

    public void setInterest4Repaid(Integer interest4Repaid) {
        this.interest4Repaid = interest4Repaid;
    }

    public Integer getInterest5Repaid() {
        return interest5Repaid;
    }

    public void setInterest5Repaid(Integer interest5Repaid) {
        this.interest5Repaid = interest5Repaid;
    }

    public Integer getLoan1Cb() {
        return loan1Cb;
    }

    public void setLoan1Cb(Integer loan1Cb) {
        this.loan1Cb = loan1Cb;
    }

    public Integer getLoan2Cb() {
        return loan2Cb;
    }

    public void setLoan2Cb(Integer loan2Cb) {
        this.loan2Cb = loan2Cb;
    }

    public Integer getLoan3Cb() {
        return loan3Cb;
    }

    public void setLoan3Cb(Integer loan3Cb) {
        this.loan3Cb = loan3Cb;
    }

    public Integer getLoan4Cb() {
        return loan4Cb;
    }

    public void setLoan4Cb(Integer loan4Cb) {
        this.loan4Cb = loan4Cb;
    }

    public Integer getLoan5Cb() {
        return loan5Cb;
    }

    public void setLoan5Cb(Integer loan5Cb) {
        this.loan5Cb = loan5Cb;
    }

    public Integer getLoan1IntCb() {
        return loan1IntCb;
    }

    public void setLoan1IntCb(Integer loan1IntCb) {
        this.loan1IntCb = loan1IntCb;
    }

    public Integer getLoan2IntCb() {
        return loan2IntCb;
    }

    public void setLoan2IntCb(Integer loan2IntCb) {
        this.loan2IntCb = loan2IntCb;
    }

    public Integer getLoan3IntCb() {
        return loan3IntCb;
    }

    public void setLoan3IntCb(Integer loan3IntCb) {
        this.loan3IntCb = loan3IntCb;
    }

    public Integer getLoan4IntCb() {
        return loan4IntCb;
    }

    public void setLoan4IntCb(Integer loan4IntCb) {
        this.loan4IntCb = loan4IntCb;
    }

    public Integer getLoan5IntCb() {
        return loan5IntCb;
    }

    public void setLoan5IntCb(Integer loan5IntCb) {
        this.loan5IntCb = loan5IntCb;
    }

    public Integer getLoan1IntAccrued() {
        return loan1IntAccrued;
    }

    public void setLoan1IntAccrued(Integer loan1IntAccrued) {
        this.loan1IntAccrued = loan1IntAccrued;
    }

    public Integer getLoan2IntAccrued() {
        return loan2IntAccrued;
    }

    public void setLoan2IntAccrued(Integer loan2IntAccrued) {
        this.loan2IntAccrued = loan2IntAccrued;
    }

    public Integer getLoan3IntAccrued() {
        return loan3IntAccrued;
    }

    public void setLoan3IntAccrued(Integer loan3IntAccrued) {
        this.loan3IntAccrued = loan3IntAccrued;
    }

    public Integer getLoan4IntAccrued() {
        return loan4IntAccrued;
    }

    public void setLoan4IntAccrued(Integer loan4IntAccrued) {
        this.loan4IntAccrued = loan4IntAccrued;
    }

    public Integer getLoan5IntAccrued() {
        return loan5IntAccrued;
    }

    public void setLoan5IntAccrued(Integer loan5IntAccrued) {
        this.loan5IntAccrued = loan5IntAccrued;
    }

    public Integer getPenalty() {
        return penalty;
    }

    public void setPenalty(Integer penalty) {
        this.penalty = penalty;
    }

    public Integer getLoanNoDisbursed() {
        return loanNoDisbursed;
    }

    public void setLoanNoDisbursed(Integer loanNoDisbursed) {
        this.loanNoDisbursed = loanNoDisbursed;
    }

    public Integer getLoanAmtDisbursed() {
        return loanAmtDisbursed;
    }

    public void setLoanAmtDisbursed(Integer loanAmtDisbursed) {
        this.loanAmtDisbursed = loanAmtDisbursed;
    }

    public Integer getSavCompWithdrawal() {
        return savCompWithdrawal;
    }

    public void setSavCompWithdrawal(Integer savCompWithdrawal) {
        this.savCompWithdrawal = savCompWithdrawal;
    }

    public Integer getSavVolWithdrawal() {
        return savVolWithdrawal;
    }

    public void setSavVolWithdrawal(Integer savVolWithdrawal) {
        this.savVolWithdrawal = savVolWithdrawal;
    }

    public Integer getSavCompInterest() {
        return savCompInterest;
    }

    public void setSavCompInterest(Integer savCompInterest) {
        this.savCompInterest = savCompInterest;
    }

    public Integer getSavVolInterest() {
        return savVolInterest;
    }

    public void setSavVolInterest(Integer savVolInterest) {
        this.savVolInterest = savVolInterest;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Integer getZeroMtgAttn() {
        return zeroMtgAttn;
    }

    public void setZeroMtgAttn(Integer zeroMtgAttn) {
        this.zeroMtgAttn = zeroMtgAttn;
    }

    public List<ShgFinTxnDetMem> getShgFinanceTransactionDetailMemberList() {
        return shgFinanceTransactionDetailMemberList;
    }

    public void setShgFinanceTransactionDetailMemberList(List<ShgFinTxnDetMem> shgFinanceTransactionDetailMemberList) {
        this.shgFinanceTransactionDetailMemberList = shgFinanceTransactionDetailMemberList;
    }

    

    public Long getCreatedOn() {
		return createdOn;
	}

	public void setCreatedOn(Long createdOn) {
		this.createdOn = createdOn;
	}

	public Long getUpdatedOn() {
		return updatedOn;
	}

	public void setUpdatedOn(Long updatedOn) {
		this.updatedOn = updatedOn;
	}

	public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    
    public String getUpdatedBy() {
        return updatedBy;
    }

    public void setUpdatedBy(String updatedBy) {
        this.updatedBy = updatedBy;
    }

    public BigInteger getUid() {
        return uid;
    }

    public void setUid(BigInteger uid) {
        this.uid = uid;
    }

    public List<ShgMemSettlement> getShgMemberSettlementList() {
        return shgMemberSettlementList;
    }

    public void setShgMemberSettlementList(List<ShgMemSettlement> shgMemberSettlementList) {
        this.shgMemberSettlementList = shgMemberSettlementList;
    }
    public Integer getReferenceMtgNo() {
        return referenceMtgNo;
    }

    public void setReferenceMtgNo(Integer referenceMtgNo) {
        this.referenceMtgNo = referenceMtgNo;
    }
}
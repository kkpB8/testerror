package com.devglan.domain;

import org.hibernate.validator.constraints.NotBlank;

import javax.persistence.Column;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.math.BigInteger;
import java.util.List;

public class VoMtg {
    private BigInteger uid;
    private BigInteger cboId;
    private String mtgGuid;
    private Integer mtgType;
    private Integer mtgNo;
   	private String flagOpen;
   	private String mtgFrq;
   	private String flagDow;
    private Long mtgDate;
    private Integer daysElapsed;
    private Integer openingBalance;
    private Integer closingBalance;
    private Integer totalMeetingHeld;
    private Long expectedDate;
    private Integer approvalStatus;
    private Long actionOn;
    private String actionBy;
    private Integer mnthCompSav;
    private Integer totalAttendance;
    private Integer savCompOb;
    private Integer savComp;
    private Integer savCompCb;
    private Integer savCompWithdrawal;
    private Integer savVolOb;
    private Integer savVol;
    private Integer savVolCb;
    private Integer savVolWithdrawal;
    private Integer memOtherReceipts;
    private Integer memOtherPayments;
    private Integer noLoansDisbursed;
    private Integer amtLoansDisbursed;
	private Integer amtLoansDemand;
    private Integer noLoansRepaid;
    private Integer amtLoansRepaid;
    private Integer noLoanOverdue;
    private Integer amtLoansOverdue;
    private Integer noLoansOs;
    private Integer amtLoansOs;
    private Integer amtInterestReceived;
    private Integer noLoansNpa;
    private Integer amtLoansNpa;
    private Integer noLoansReceivedExt;
    private Integer amtLoansReceivedExt;
    private Integer noLoansRepaidExt;
    private Integer amtLoansRepaidExt;
    private Integer noLoanOverdueExt;
	private Integer amtLoansDemandExt;
    private Integer amtLoansOverdueExt;
    private Integer noLoansOsExt;
    private Integer amtLoansOsExt;
    private Integer amtInterestPaidExt;
    private Integer noLoansNpaExt;
    private Integer amtLoansNpaExt;
    private Integer otherReceipts;
    private Integer otherPayments;
    private Integer depositedCash;
    private Integer withdrawnCash;
    private Integer openingBalanceCash;
    private Integer closingBalanceCash;
    private Long createdOn;
    private Boolean summaryFlag;
    //@Size(max=30,message="Created by can be max of 30 chars long")
    private String createdBy;
    private Long updatedOn;
   // @Size(max=30,message="Updated by can be max of 30 chars long")
    private String updatedBy;
    
    private Integer amtLoansRequest;
    private Integer totalReceipts;
    private Integer totalPayments;
    private Integer zeroMtgCashInHand;
    private Integer zeroMtgCashInTransit;
    private Integer balanceDate;

    private List<VoMtgDet> voMeetingDetailsList;
    private List<VoFinTxn> voFinanceTransactionList;
    private List<VoFinTxnDetGrp> voFinanceTransactionDetailGroupList;
    private List<VoGroupLoanTxn> voGroupLoanTransactionList;
    //@anshul
   private List<VoFinTxnVouchers> voFinanceTransactionVouchersList;
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

    public String getMtgGuid() {
        return mtgGuid;
    }

    public void setMtgGuid(String mtgGuid) {
        this.mtgGuid = mtgGuid;
    }

    public Integer getMtgType() {
        return mtgType;
    }

    public void setMtgType(Integer mtgType) {
        this.mtgType = mtgType;
    }

    public Integer getMtgNo() {
        return mtgNo;
    }

    public void setMtgNo(Integer mtgNo) {
        this.mtgNo = mtgNo;
    }

    public String getFlagOpen() {
        return flagOpen;
    }

    public void setFlagOpen(String flagOpen) {
        this.flagOpen = flagOpen;
    }

    public String getMtgFrq() {
        return mtgFrq;
    }

    public void setMtgFrq(String mtgFrq) {
        this.mtgFrq = mtgFrq;
    }

    public String getFlagDow() {
        return flagDow;
    }

    public void setFlagDow(String flagDow) {
        this.flagDow = flagDow;
    }

    public Long getMtgDate() {
        return mtgDate;
    }

    public void setMtgDate(Long mtgDate) {
        this.mtgDate = mtgDate;
    }

    public Integer getDaysElapsed() {
        return daysElapsed;
    }

    public void setDaysElapsed(Integer daysElapsed) {
        this.daysElapsed = daysElapsed;
    }

    public Integer getOpeningBalance() {
        return openingBalance;
    }

    public void setOpeningBalance(Integer openingBalance) {
        this.openingBalance = openingBalance;
    }

    public Integer getClosingBalance() {
        return closingBalance;
    }

    public void setClosingBalance(Integer closingBalance) {
        this.closingBalance = closingBalance;
    }

    public Integer getTotalMeetingHeld() {
        return totalMeetingHeld;
    }

    public void setTotalMeetingHeld(Integer totalMeetingHeld) {
        this.totalMeetingHeld = totalMeetingHeld;
    }

    public Long getExpectedDate() {
        return expectedDate;
    }

    public void setExpectedDate(Long expectedDate) {
        this.expectedDate = expectedDate;
    }

    public Integer getApprovalStatus() {
        return approvalStatus;
    }

    public void setApprovalStatus(Integer approvalStatus) {
        this.approvalStatus = approvalStatus;
    }

    public Long getActionOn() {
        return actionOn;
    }

    public void setActionOn(Long actionOn) {
        this.actionOn = actionOn;
    }

    public String getActionBy() {
        return actionBy;
    }

    public void setActionBy(String actionBy) {
        this.actionBy = actionBy;
    }

    public Integer getMnthCompSav() {
        return mnthCompSav;
    }

    public void setMnthCompSav(Integer mnthCompSav) {
        this.mnthCompSav = mnthCompSav;
    }

    public Integer getTotalAttendance() {
        return totalAttendance;
    }

    public void setTotalAttendance(Integer totalAttendance) {
        this.totalAttendance = totalAttendance;
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

    public Integer getSavCompWithdrawal() {
        return savCompWithdrawal;
    }

    public void setSavCompWithdrawal(Integer savCompWithdrawal) {
        this.savCompWithdrawal = savCompWithdrawal;
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

    public Integer getSavVolWithdrawal() {
        return savVolWithdrawal;
    }

    public void setSavVolWithdrawal(Integer savVolWithdrawal) {
        this.savVolWithdrawal = savVolWithdrawal;
    }

    public Integer getMemOtherReceipts() {
        return memOtherReceipts;
    }

    public void setMemOtherReceipts(Integer memOtherReceipts) {
        this.memOtherReceipts = memOtherReceipts;
    }

    public Integer getMemOtherPayments() {
        return memOtherPayments;
    }

    public void setMemOtherPayments(Integer memOtherPayments) {
        this.memOtherPayments = memOtherPayments;
    }

    public Integer getNoLoansDisbursed() {
        return noLoansDisbursed;
    }

    public void setNoLoansDisbursed(Integer noLoansDisbursed) {
        this.noLoansDisbursed = noLoansDisbursed;
    }

    public Integer getAmtLoansDisbursed() {
        return amtLoansDisbursed;
    }

    public void setAmtLoansDisbursed(Integer amtLoansDisbursed) {
        this.amtLoansDisbursed = amtLoansDisbursed;
    }

    public Integer getAmtLoansDemand() {
        return amtLoansDemand;
    }

    public void setAmtLoansDemand(Integer amtLoansDemand) {
        this.amtLoansDemand = amtLoansDemand;
    }

    public Integer getNoLoansRepaid() {
        return noLoansRepaid;
    }

    public void setNoLoansRepaid(Integer noLoansRepaid) {
        this.noLoansRepaid = noLoansRepaid;
    }

    public Integer getAmtLoansRepaid() {
        return amtLoansRepaid;
    }

    public void setAmtLoansRepaid(Integer amtLoansRepaid) {
        this.amtLoansRepaid = amtLoansRepaid;
    }

    public Integer getNoLoanOverdue() {
        return noLoanOverdue;
    }

    public void setNoLoanOverdue(Integer noLoanOverdue) {
        this.noLoanOverdue = noLoanOverdue;
    }

    public Integer getAmtLoansOverdue() {
        return amtLoansOverdue;
    }

    public void setAmtLoansOverdue(Integer amtLoansOverdue) {
        this.amtLoansOverdue = amtLoansOverdue;
    }

    public Integer getNoLoansOs() {
        return noLoansOs;
    }

    public void setNoLoansOs(Integer noLoansOs) {
        this.noLoansOs = noLoansOs;
    }

    public Integer getAmtLoansOs() {
        return amtLoansOs;
    }

    public void setAmtLoansOs(Integer amtLoansOs) {
        this.amtLoansOs = amtLoansOs;
    }

    public Integer getAmtInterestReceived() {
        return amtInterestReceived;
    }

    public void setAmtInterestReceived(Integer amtInterestReceived) {
        this.amtInterestReceived = amtInterestReceived;
    }

    public Integer getNoLoansNpa() {
        return noLoansNpa;
    }

    public void setNoLoansNpa(Integer noLoansNpa) {
        this.noLoansNpa = noLoansNpa;
    }

    public Integer getAmtLoansNpa() {
        return amtLoansNpa;
    }

    public void setAmtLoansNpa(Integer amtLoansNpa) {
        this.amtLoansNpa = amtLoansNpa;
    }

    public Integer getNoLoansReceivedExt() {
        return noLoansReceivedExt;
    }

    public void setNoLoansReceivedExt(Integer noLoansReceivedExt) {
        this.noLoansReceivedExt = noLoansReceivedExt;
    }

    public Integer getAmtLoansReceivedExt() {
        return amtLoansReceivedExt;
    }

    public void setAmtLoansReceivedExt(Integer amtLoansReceivedExt) {
        this.amtLoansReceivedExt = amtLoansReceivedExt;
    }

    public Integer getNoLoansRepaidExt() {
        return noLoansRepaidExt;
    }

    public void setNoLoansRepaidExt(Integer noLoansRepaidExt) {
        this.noLoansRepaidExt = noLoansRepaidExt;
    }

    public Integer getAmtLoansRepaidExt() {
        return amtLoansRepaidExt;
    }

    public void setAmtLoansRepaidExt(Integer amtLoansRepaidExt) {
        this.amtLoansRepaidExt = amtLoansRepaidExt;
    }

    public Integer getNoLoanOverdueExt() {
        return noLoanOverdueExt;
    }

    public void setNoLoanOverdueExt(Integer noLoanOverdueExt) {
        this.noLoanOverdueExt = noLoanOverdueExt;
    }

    public Integer getAmtLoansDemandExt() {
        return amtLoansDemandExt;
    }

    public void setAmtLoansDemandExt(Integer amtLoansDemandExt) {
        this.amtLoansDemandExt = amtLoansDemandExt;
    }

    public Integer getAmtLoansOverdueExt() {
        return amtLoansOverdueExt;
    }

    public void setAmtLoansOverdueExt(Integer amtLoansOverdueExt) {
        this.amtLoansOverdueExt = amtLoansOverdueExt;
    }

    public Integer getNoLoansOsExt() {
        return noLoansOsExt;
    }

    public void setNoLoansOsExt(Integer noLoansOsExt) {
        this.noLoansOsExt = noLoansOsExt;
    }

    public Integer getAmtLoansOsExt() {
        return amtLoansOsExt;
    }

    public void setAmtLoansOsExt(Integer amtLoansOsExt) {
        this.amtLoansOsExt = amtLoansOsExt;
    }

    public Integer getAmtInterestPaidExt() {
        return amtInterestPaidExt;
    }

    public void setAmtInterestPaidExt(Integer amtInterestPaidExt) {
        this.amtInterestPaidExt = amtInterestPaidExt;
    }

    public Integer getNoLoansNpaExt() {
        return noLoansNpaExt;
    }

    public void setNoLoansNpaExt(Integer noLoansNpaExt) {
        this.noLoansNpaExt = noLoansNpaExt;
    }

    public Integer getAmtLoansNpaExt() {
        return amtLoansNpaExt;
    }

    public void setAmtLoansNpaExt(Integer amtLoansNpaExt) {
        this.amtLoansNpaExt = amtLoansNpaExt;
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

    public Integer getDepositedCash() {
        return depositedCash;
    }

    public void setDepositedCash(Integer depositedCash) {
        this.depositedCash = depositedCash;
    }

    public Integer getWithdrawnCash() {
        return withdrawnCash;
    }

    public void setWithdrawnCash(Integer withdrawnCash) {
        this.withdrawnCash = withdrawnCash;
    }

    public Integer getOpeningBalanceCash() {
        return openingBalanceCash;
    }

    public void setOpeningBalanceCash(Integer openingBalanceCash) {
        this.openingBalanceCash = openingBalanceCash;
    }

    public Integer getClosingBalanceCash() {
        return closingBalanceCash;
    }

    public void setClosingBalanceCash(Integer closingBalanceCash) {
        this.closingBalanceCash = closingBalanceCash;
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

    public Boolean getSummaryFlag() {
        return summaryFlag;
    }

    public void setSummaryFlag(Boolean summaryFlag) {
        this.summaryFlag = summaryFlag;
    }

	public List<VoMtgDet> getVoMeetingDetailsList() {
		return voMeetingDetailsList;
	}

	public void setVoMeetingDetailsList(List<VoMtgDet> voMeetingDetailsList) {
		this.voMeetingDetailsList = voMeetingDetailsList;
	}

	public List<VoFinTxn> getVoFinanceTransactionList() {
		return voFinanceTransactionList;
	}

	public void setVoFinanceTransactionList(List<VoFinTxn> voFinanceTransactionList) {
		this.voFinanceTransactionList = voFinanceTransactionList;
	}

	public List<VoFinTxnDetGrp> getVoFinanceTransactionDetailGroupList() {
		return voFinanceTransactionDetailGroupList;
	}

	public void setVoFinanceTransactionDetailGroupList(List<VoFinTxnDetGrp> voFinanceTransactionDetailGroupList) {
		this.voFinanceTransactionDetailGroupList = voFinanceTransactionDetailGroupList;
	}

	public List<VoGroupLoanTxn> getVoGroupLoanTransactionList() {
		return voGroupLoanTransactionList;
	}

	public void setVoGroupLoanTransactionList(List<VoGroupLoanTxn> voGroupLoanTransactionList) {
		this.voGroupLoanTransactionList = voGroupLoanTransactionList;
	}

	public Integer getAmtLoansRequest() {
		return amtLoansRequest;
	}

	public void setAmtLoansRequest(Integer amtLoansRequest) {
		this.amtLoansRequest = amtLoansRequest;
	}

	public Integer getTotalReceipts() {
		return totalReceipts;
	}

	public void setTotalReceipts(Integer totalReceipts) {
		this.totalReceipts = totalReceipts;
	}

	public Integer getTotalPayments() {
		return totalPayments;
	}

	public void setTotalPayments(Integer totalPayments) {
		this.totalPayments = totalPayments;
	}

	public Integer getZeroMtgCashInHand() {
		return zeroMtgCashInHand;
	}

	public void setZeroMtgCashInHand(Integer zeroMtgCashInHand) {
		this.zeroMtgCashInHand = zeroMtgCashInHand;
	}

	public Integer getZeroMtgCashInTransit() {
		return zeroMtgCashInTransit;
	}

	public void setZeroMtgCashInTransit(Integer zeroMtgCashInTransit) {
		this.zeroMtgCashInTransit = zeroMtgCashInTransit;
	}

	public Integer getBalanceDate() {
		return balanceDate;
	}

	public void setBalanceDate(Integer balanceDate) {
		this.balanceDate = balanceDate;
	}

	public List<VoFinTxnVouchers> getVoFinanceTransactionVouchersList() {
		return voFinanceTransactionVouchersList;
	}

	public void setVoFinanceTransactionVouchersList(List<VoFinTxnVouchers> voFinanceTransactionVouchersList) {
		this.voFinanceTransactionVouchersList = voFinanceTransactionVouchersList;
	}
    
	
	
}

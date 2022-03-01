package com.devglan.domain;

import javax.persistence.Column;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.math.BigInteger;
import java.util.List;

public class VoMtgDet {
    private BigInteger uid;
    private BigInteger cboId;
	private BigInteger voMtgUid;
    private BigInteger memId;
	private String mtgGuid;
	private Integer mtgNo;
	private Long mtgDate;
	private Integer sNo;
	private String childCboName;
	private String attendance;
	private String ec1;
	private String ec2;
	private String ec3;
	private String ec4;
	private String ec5;
	private Integer attendanceOther;
	private Integer attendanceExternal;
	private String status;
	private Integer zeroMtgAttn;
    private Long createdOn;
    private String createdBy;
    private Long updatedOn;
    private String updatedBy;
    private Integer savCompOb;
    private Integer savCompCb;
    private Integer savComp;
    private Integer savCompWithdrawal;
    private Integer savVolOb;
    private Integer savVol;
    private Integer savVolCb;
    private Integer savVolWithdrawal;
    private Integer penalty;
    private Short settlementStatus;
    
    private List<VoMemLoanTxn> voMemberLoanTransactionList;
   private List<VoMemSettlement> voMemberSettlementList;
    private List<VoFinTxnDetMem> voFinanceTransactionDetailMemberList;

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

	public BigInteger getVoMtgUid() {
		return voMtgUid;
	}

	public void setVoMtgUid(BigInteger voMtgUid) {
		this.voMtgUid = voMtgUid;
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

	public String getChildCboName() {
		return childCboName;
	}

	public void setChildCboName(String childCboName) {
		this.childCboName = childCboName;
	}

	public String getAttendance() {
		return attendance;
	}

	public void setAttendance(String attendance) {
		this.attendance = attendance;
	}

	
	public Integer getAttendanceOther() {
		return attendanceOther;
	}

	public void setAttendanceOther(Integer attendanceOther) {
		this.attendanceOther = attendanceOther;
	}

	public Integer getAttendanceExternal() {
		return attendanceExternal;
	}

	public void setAttendanceExternal(Integer attendanceExternal) {
		this.attendanceExternal = attendanceExternal;
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

	public List<VoMemLoanTxn> getVoMemberLoanTransactionList() {
		return voMemberLoanTransactionList;
	}

	public void setVoMemberLoanTransactionList(List<VoMemLoanTxn> voMemberLoanTransactionList) {
		this.voMemberLoanTransactionList = voMemberLoanTransactionList;
	}

	public List<VoFinTxnDetMem> getVoFinanceTransactionDetailMemberList() {
		return voFinanceTransactionDetailMemberList;
	}

	public void setVoFinanceTransactionDetailMemberList(List<VoFinTxnDetMem> voFinanceTransactionDetailMemberList) {
		this.voFinanceTransactionDetailMemberList = voFinanceTransactionDetailMemberList;
	}

	public Integer getSavCompOb() {
		return savCompOb;
	}

	public void setSavCompOb(Integer savCompOb) {
		this.savCompOb = savCompOb;
	}

	public Integer getSavCompCb() {
		return savCompCb;
	}

	public void setSavCompCb(Integer savCompCb) {
		this.savCompCb = savCompCb;
	}

	public Integer getSavComp() {
		return savComp;
	}

	public void setSavComp(Integer savComp) {
		this.savComp = savComp;
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

	public Integer getPenalty() {
		return penalty;
	}

	public void setPenalty(Integer penalty) {
		this.penalty = penalty;
	}

	public Integer getsNo() {
		return sNo;
	}

	public void setsNo(Integer sNo) {
		this.sNo = sNo;
	}

	public String getEc1() {
		return ec1;
	}

	public void setEc1(String ec1) {
		this.ec1 = ec1;
	}

	public String getEc2() {
		return ec2;
	}

	public void setEc2(String ec2) {
		this.ec2 = ec2;
	}

	public String getEc3() {
		return ec3;
	}

	public void setEc3(String ec3) {
		this.ec3 = ec3;
	}

	public String getEc4() {
		return ec4;
	}

	public void setEc4(String ec4) {
		this.ec4 = ec4;
	}

	public String getEc5() {
		return ec5;
	}

	public void setEc5(String ec5) {
		this.ec5 = ec5;
	}

	
	public Short getSettlementStatus() {
		return settlementStatus;
	}

	public void setSettlementStatus(Short settlementStatus) {
		this.settlementStatus = settlementStatus;
	}

	public List<VoMemSettlement> getVoMemberSettlementList() {
		return voMemberSettlementList;
	}

	public void setVoMemberSettlementList(List<VoMemSettlement> voMemberSettlementList) {
		this.voMemberSettlementList = voMemberSettlementList;
	}

	
}
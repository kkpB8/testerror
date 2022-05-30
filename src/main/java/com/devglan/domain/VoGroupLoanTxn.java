package com.devglan.domain;


import javax.persistence.Column;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.math.BigInteger;

public class VoGroupLoanTxn {
    private BigInteger uid;
	//@Size(max=50,message="Meeting guid can be max of 50 chars long")
	private String mtgGuid;
	//@NotNull(message = "cboid cannot be null")
	private BigInteger cboId;
	//@NotNull(message = "Meeting No cannot be null")
	private Integer mtgNo;
	private Long mtgDate;
    //@NotNull(message = "Loan No cannot be null")
    private Integer loanNo;
    private Integer loanOp;
    private Integer loanOpInt;
    private Integer loanPaid;
    private Integer loanPaidInt;
    private Integer loanCl;
    private Integer loanClInt;
    private Boolean completionFlag;
    private Integer intAccruedOp;
    private Integer intAccrued;
    private Integer intAccruedCl;
    private Integer principalDemandOb;
    private Integer principalDemand;
    private Integer principalDemandCb;
    private Integer modePayment;
    private String bankCode;
    private String transactionNo;
    private Long createdOn;
    //@Size(max=30,message="Created by can be max of 30 chars long")
    private String createdBy;
    private Long updatedOn;
    //@Size(max=30,message="Updated by can be max of 30 chars long")
    private String updatedBy;
    
    private Integer interestRepaid;
    private Double interestRate;
    private Integer period;


    private Integer zeroMtgCashInHand;
    private Integer zeroMtgCashInTransit;
    private Integer withdrawnCash;
    private Integer isLoanReschedule;
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

    public Integer getLoanNo() {
        return loanNo;
    }

    public void setLoanNo(Integer loanNo) {
        this.loanNo = loanNo;
    }

    public Integer getLoanOp() {
        return loanOp;
    }

    public void setLoanOp(Integer loanOp) {
        this.loanOp = loanOp;
    }

    public Integer getLoanOpInt() {
        return loanOpInt;
    }

    public void setLoanOpInt(Integer loanOpInt) {
        this.loanOpInt = loanOpInt;
    }

    public Integer getLoanPaid() {
        return loanPaid;
    }

    public void setLoanPaid(Integer loanPaid) {
        this.loanPaid = loanPaid;
    }

    public Integer getLoanPaidInt() {
        return loanPaidInt;
    }

    public void setLoanPaidInt(Integer loanPaidInt) {
        this.loanPaidInt = loanPaidInt;
    }

    public Integer getLoanCl() {
        return loanCl;
    }

    public void setLoanCl(Integer loanCl) {
        this.loanCl = loanCl;
    }

    public Integer getLoanClInt() {
        return loanClInt;
    }

    public void setLoanClInt(Integer loanClInt) {
        this.loanClInt = loanClInt;
    }

    public Boolean getCompletionFlag() {
        return completionFlag;
    }

    public void setCompletionFlag(Boolean completionFlag) {
        this.completionFlag = completionFlag;
    }

    public Integer getIntAccruedOp() {
        return intAccruedOp;
    }

    public void setIntAccruedOp(Integer intAccruedOp) {
        this.intAccruedOp = intAccruedOp;
    }

    public Integer getIntAccrued() {
        return intAccrued;
    }

    public void setIntAccrued(Integer intAccrued) {
        this.intAccrued = intAccrued;
    }

    public Integer getIntAccruedCl() {
        return intAccruedCl;
    }

    public void setIntAccruedCl(Integer intAccruedCl) {
        this.intAccruedCl = intAccruedCl;
    }

    public Integer getPrincipalDemandOb() {
        return principalDemandOb;
    }

    public void setPrincipalDemandOb(Integer principalDemandOb) {
        this.principalDemandOb = principalDemandOb;
    }

    public Integer getPrincipalDemand() {
        return principalDemand;
    }

    public void setPrincipalDemand(Integer principalDemand) {
        this.principalDemand = principalDemand;
    }

    public Integer getPrincipalDemandCb() {
        return principalDemandCb;
    }

    public void setPrincipalDemandCb(Integer principalDemandCb) {
        this.principalDemandCb = principalDemandCb;
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

	public Integer getInterestRepaid() {
		return interestRepaid;
	}

	public void setInterestRepaid(Integer interestRepaid) {
		this.interestRepaid = interestRepaid;
	}

	public Double getInterestRate() {
		return interestRate;
	}

	public void setInterestRate(Double interestRate) {
		this.interestRate = interestRate;
	}

	public Integer getPeriod() {
		return period;
	}

	public void setPeriod(Integer period) {
		this.period = period;
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

	public Integer getWithdrawnCash() {
		return withdrawnCash;
	}

	public void setWithdrawnCash(Integer withdrawnCash) {
		this.withdrawnCash = withdrawnCash;
	}

	public Integer getIsLoanReschedule() {
		return isLoanReschedule;
	}

	public void setIsLoanReschedule(Integer isLoanReschedule) {
		this.isLoanReschedule = isLoanReschedule;
	}
    
    
    
}

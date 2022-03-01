package com.devglan.domain;


import org.hibernate.validator.constraints.NotBlank;

import javax.persistence.Column;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.math.BigInteger;

public class VoFinTxn {
    private BigInteger uid;

  //  @NotBlank(message = "Bank Code cannot be empty")
   // @Size(max=25,message="Bank Code can be max of 25 chars long")
    private String bankCode;
	//@NotNull(message = "Vo Meeting Uid can not be null")
	private BigInteger voMtgUid;
	//@NotNull(message = "Cboid can not be null")
	private BigInteger cboId;
	//@Size(max=50,message="Meeting guid can be max of 50 chars long")
	private String mtgGuid;
	///@NotNull(message = "Meeting No can not be null")
	private Integer mtgNo;
    private Integer openingBalance;
    private Integer closingBalance;
    private Integer otherDeposits;
    private Integer otherWithdrawals;
    private Integer depositedCash;
    private Integer withdrawnCash;
    private Integer openingBalanceCash;
    private Integer closingBalanceCash;
    private Long createdOn;
    //@Size(max=30,message="Created by can be max of 30 chars long")
    private String createdBy;
    private Long updatedOn;
    //@Size(max=30,message="Updated by can be max of 30 chars long")
    private String updatedBy;
    private Integer totalReceipts;
    private Integer totalPayments ;
    private Integer zeroMtgCashBank ;
    private Integer chequeIssuedNotRealized ;
    private Integer chequeReceivedNotCredited ;
    private Integer balanceDate ;
    private Integer zeroMtgCashInHand;
    private Integer zeroMtgCashInTransit;
    
    public BigInteger getUid() {
        return uid;
    }

    public void setUid(BigInteger uid) {
        this.uid = uid;
    }

    public String getBankCode() {
        return bankCode;
    }

    public void setBankCode(String bankCode) {
        this.bankCode = bankCode;
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

    public Integer getOtherDeposits() {
        return otherDeposits;
    }

    public void setOtherDeposits(Integer otherDeposits) {
        this.otherDeposits = otherDeposits;
    }

    public Integer getOtherWithdrawals() {
        return otherWithdrawals;
    }

    public void setOtherWithdrawals(Integer otherWithdrawals) {
        this.otherWithdrawals = otherWithdrawals;
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

	public Integer getZeroMtgCashBank() {
		return zeroMtgCashBank;
	}

	public void setZeroMtgCashBank(Integer zeroMtgCashBank) {
		this.zeroMtgCashBank = zeroMtgCashBank;
	}

	public Integer getChequeIssuedNotRealized() {
		return chequeIssuedNotRealized;
	}

	public void setChequeIssuedNotRealized(Integer chequeIssuedNotRealized) {
		this.chequeIssuedNotRealized = chequeIssuedNotRealized;
	}

	public Integer getChequeReceivedNotCredited() {
		return chequeReceivedNotCredited;
	}

	public void setChequeReceivedNotCredited(Integer chequeReceivedNotCredited) {
		this.chequeReceivedNotCredited = chequeReceivedNotCredited;
	}

	public Integer getBalanceDate() {
		return balanceDate;
	}

	public void setBalanceDate(Integer balanceDate) {
		this.balanceDate = balanceDate;
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
    
    
}

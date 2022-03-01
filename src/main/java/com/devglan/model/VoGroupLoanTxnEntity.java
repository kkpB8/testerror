package com.devglan.model;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigInteger;
import java.sql.Timestamp;

/**
 * $table.getTableComment()
 */
@Entity
@Table(name = "vo_group_loan_txn")
public class VoGroupLoanTxnEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "uid", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private BigInteger uid;

	@Column(name = "loan_application_id", nullable = false)
    private BigInteger loanApplicationId;
	
    @Column(name = "cbo_id", nullable = false)
    private BigInteger cboId;

    @Column(name = "mtg_guid", nullable = false)
    private String mtgGuid;

    @Column(name = "mtg_no", nullable = false)
    private Integer mtgNo;

    @Column(name = "mtg_date")
    private Timestamp mtgDate1;

    @Column(name = "loan_no", nullable = false)
    private Integer loanNo;

    @Column(name = "loan_op")
    private Integer loanOp;

    @Column(name = "loan_op_int")
    private Integer loanOpInt;

    @Column(name = "loan_paid")
    private Integer loanPaid;

    @Column(name = "loan_paid_int")
    private Integer loanPaidInt;

    @Column(name = "loan_cl")
    private Integer loanCl;

    @Column(name = "loan_cl_int")
    private Integer loanClInt;

      @Column(name = "completion_flag")
      private Boolean completionFlag;

    @Column(name = "int_accrued_op")
    private Integer intAccruedOp;

    @Column(name = "int_accrued")
    private Integer intAccrued;

    @Column(name = "int_accrued_cl")
    private Integer intAccruedCl;

    @Column(name = "principal_demand_ob")
    private Integer principalDemandOb;

    @Column(name = "principal_demand")
    private Integer principalDemand;

    @Column(name = "principal_demand_cb")
    private Integer principalDemandCb;

    @Column(name = "mode_payment")
    private Integer modePayment;

    @Column(name = "bank_code")
    private String bankCode;

    @Column(name = "transaction_no")
    private String transactionNo;

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
    
    @Column(name = "vo_mtg_uid", nullable = false)
    private BigInteger voMtgUid;
    
  //@Anshul271121
    @Column(name = "interest_repaid")
    private Integer interestRepaid;

    @Column(name = "interest_rate")
    private Double interestRate;

    @Column(name = "period")
    private Integer period;

    @Column(name= "zero_mtg_cash_in_hand")
    private Integer zeroMtgCashInHand;

    @Column(name= "zero_mtg_cash_in_transit")
    private Integer zeroMtgCashInTransit;

    @Column(name = "withdrawn_cash")
    private Integer withdrawnCash;

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public BigInteger getUid() {
        return uid;
    }

    public void setUid(BigInteger uid) {
        this.uid = uid;
    }

    public BigInteger getLoanApplicationId() {
        return loanApplicationId;
    }

    public void setLoanApplicationId(BigInteger loanApplicationId) {
        this.loanApplicationId = loanApplicationId;
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

    public Timestamp getMtgDate1() {
        return mtgDate1;
    }

    public void setMtgDate1(Timestamp mtgDate1) {
        this.mtgDate1 = mtgDate1;
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

	@Override
    public String toString() {
        return "VoGroupLoanTxnEntity{" +
                "uid=" + uid + '\'' +
				"loanApplicationId =" + loanApplicationId  + '\'' +
                "cboId=" + cboId + '\'' +
                "mtgGuid=" + mtgGuid + '\'' +
                "mtgNo=" + mtgNo + '\'' +
                "mtgDate=" + mtgDate1 + '\'' +
                 "voMtgUid=" + voMtgUid + '\'' +
                "loanNo=" + loanNo + '\'' +
                "loanOp=" + loanOp + '\'' +
                "loanOpInt=" + loanOpInt + '\'' +
                "loanPaid=" + loanPaid + '\'' +
                "loanPaidInt=" + loanPaidInt + '\'' +
                "loanCl=" + loanCl + '\'' +
                "loanClInt=" + loanClInt + '\'' +
                //       "completionFlag=" + completionFlag + '\'' +
                "intAccruedOp=" + intAccruedOp + '\'' +
                "intAccrued=" + intAccrued + '\'' +
                "intAccruedCl=" + intAccruedCl + '\'' +
                "principalDemandOb=" + principalDemandOb + '\'' +
                "principalDemand=" + principalDemand + '\'' +
                "principalDemandCb=" + principalDemandCb + '\'' +
                "modePayment=" + modePayment + '\'' +
                "bankCode=" + bankCode + '\'' +
                "transactionNo=" + transactionNo + '\'' +
                "createdBy=" + createdBy + '\'' +
                "createdOn=" + createdOn1 + '\'' +
                "updatedBy=" + updatedBy + '\'' +
                "updatedOn=" + updatedOn1 + '\'' +
                "uploadedBy=" + uploadedBy + '\'' +
                "uploadedOn=" + uploadedOn + '\'' +
                '}';
    }
}

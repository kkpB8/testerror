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
@Table(name = "shg_group_loan_txn")
public class ShgGroupLoanTxnEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "uid", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private BigInteger uid;

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

    @Column(name = "shg_mtg_uid")
    private BigInteger shgMtgUid;
    
  //@Anshul261121
    @Column(name = "interest_repaid")
    private Integer interestRepaid;

    @Column(name = "interest_rate")
    private Double interestRate;

    @Column(name = "period")
    private Integer period;
    
    @Column(name = "misc_charges")
    private Integer miscCharges;

    @Column(name = "subvention")
    private Integer subvention;

    @Column(name = "loan_type")
    private Integer loanType;
    
    @Column(name = "is_loan_reschedule")
    private Integer isLoanReschedule;


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

    public void setMtgDate1(Timestamp mtgDate1) {
        this.mtgDate1 = mtgDate1;
    }

    public Timestamp getMtgDate1() {
        return mtgDate1;
    }

    public void setLoanNo(Integer loanNo) {
        this.loanNo = loanNo;
    }

    public Integer getLoanNo() {
        return loanNo;
    }

    public void setLoanOp(Integer loanOp) {
        this.loanOp = loanOp;
    }

    public Integer getLoanOp() {
        return loanOp;
    }

    public void setLoanOpInt(Integer loanOpInt) {
        this.loanOpInt = loanOpInt;
    }

    public Integer getLoanOpInt() {
        return loanOpInt;
    }

    public void setLoanPaid(Integer loanPaid) {
        this.loanPaid = loanPaid;
    }

    public Integer getLoanPaid() {
        return loanPaid;
    }

    public void setLoanPaidInt(Integer loanPaidInt) {
        this.loanPaidInt = loanPaidInt;
    }

    public Integer getLoanPaidInt() {
        return loanPaidInt;
    }

    public void setLoanCl(Integer loanCl) {
        this.loanCl = loanCl;
    }

    public Integer getLoanCl() {
        return loanCl;
    }

    public void setLoanClInt(Integer loanClInt) {
        this.loanClInt = loanClInt;
    }

    public Integer getLoanClInt() {
        return loanClInt;
    }

   /* public void setCompletionFlag(Boolean completionFlag) {
        this.completionFlag = completionFlag;
    }

    public Boolean isCompletionFlag() {
        return completionFlag;
    }*/

    public void setIntAccruedOp(Integer intAccruedOp) {
        this.intAccruedOp = intAccruedOp;
    }

    public Integer getIntAccruedOp() {
        return intAccruedOp;
    }

    public void setIntAccrued(Integer intAccrued) {
        this.intAccrued = intAccrued;
    }

    public Integer getIntAccrued() {
        return intAccrued;
    }

    public void setIntAccruedCl(Integer intAccruedCl) {
        this.intAccruedCl = intAccruedCl;
    }

    public Integer getIntAccruedCl() {
        return intAccruedCl;
    }

    public void setPrincipalDemandOb(Integer principalDemandOb) {
        this.principalDemandOb = principalDemandOb;
    }

    public Integer getPrincipalDemandOb() {
        return principalDemandOb;
    }

    public void setPrincipalDemand(Integer principalDemand) {
        this.principalDemand = principalDemand;
    }

    public Integer getPrincipalDemand() {
        return principalDemand;
    }

    public void setPrincipalDemandCb(Integer principalDemandCb) {
        this.principalDemandCb = principalDemandCb;
    }

    public Integer getPrincipalDemandCb() {
        return principalDemandCb;
    }

    public void setModePayment(Integer modePayment) {
        this.modePayment = modePayment;
    }

    public Integer getModePayment() {
        return modePayment;
    }

    public void setBankCode(String bankCode) {
        this.bankCode = bankCode;
    }

    public String getBankCode() {
        return bankCode;
    }

    public void setTransactionNo(String transactionNo) {
        this.transactionNo = transactionNo;
    }

    public String getTransactionNo() {
        return transactionNo;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedOn1(Timestamp createdOn1) {
        this.createdOn1 = createdOn1;
    }

    public Timestamp getCreatedOn1() {
        return createdOn1;
    }

    public void setUpdatedBy(String updatedBy) {
        this.updatedBy = updatedBy;
    }

    public String getUpdatedBy() {
        return updatedBy;
    }

    public void setUpdatedOn1(Timestamp updatedOn1) {
        this.updatedOn1= updatedOn1;
    }

    public Timestamp getUpdatedOn1() {
        return updatedOn1;
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

    @Override
    public String toString() {
        return "ShgGroupLoanTxnEntity{" +
                "uid=" + uid + '\'' +
                "cboId=" + cboId + '\'' +
                "mtgGuid=" + mtgGuid + '\'' +
                "mtgNo=" + mtgNo + '\'' +
                "mtgDate=" + mtgDate1 + '\'' +
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

    public BigInteger getShgMtgUid() {
        return shgMtgUid;
    }

    public void setShgMtgUid(BigInteger shgMtgUid) {
        this.shgMtgUid = shgMtgUid;
    }

	public Boolean getCompletionFlag() {
		return completionFlag;
	}

	public void setCompletionFlag(Boolean completionFlag) {
		this.completionFlag = completionFlag;
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

	public Integer getMiscCharges() {
		return miscCharges;
	}

	public void setMiscCharges(Integer miscCharges) {
		this.miscCharges = miscCharges;
	}

	public Integer getSubvention() {
		return subvention;
	}

	public void setSubvention(Integer subvention) {
		this.subvention = subvention;
	}

	public Integer getLoanType() {
		return loanType;
	}

	public void setLoanType(Integer loanType) {
		this.loanType = loanType;
	}

	public Integer getIsLoanReschedule() {
		return isLoanReschedule;
	}

	public void setIsLoanReschedule(Integer isLoanReschedule) {
		this.isLoanReschedule = isLoanReschedule;
	}
	
	
        
}

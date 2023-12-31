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
@Table(name = "shg_group_loan_schedule")
public class ShgGroupLoanScheduleEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "uid", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private BigInteger uid;

    @Column(name = "cbo_id", nullable = false)
    private BigInteger cboId;

    @Column(name = "mtg_guid")
    private String mtgGuid;

    @Column(name = "loan_no", nullable = false)
    private Integer loanNo;

    @Column(name = "principal_demand")
    private Integer principalDemand;

    @Column(name = "loan_demand_os")
    private Integer loanDemandOs;

    @Column(name = "loan_os")
    private Integer loanOs;

    @Column(name = "loan_paid")
    private Integer loanPaid;

    @Column(name = "installment_no", nullable = false)
    private Integer installmentNo;

    @Column(name = "sub_installment_no", nullable = false)
    private Integer subInstallmentNo;

    @Column(name = "installment_date")
    private Timestamp installmentDate1;

    @Column(name = "loan_date")
    private Timestamp loanDate1;

    @Column(name = "repaid")
    private Boolean repaid;

    @Column(name = "last_paid_date")
    private Timestamp lastPaidDate1;

    @Column(name = "mtg_no")
    private Integer mtgNo;

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

    @Column(name = "shg_group_loan_uid")
    private BigInteger shgGroupLoanUid;
    
    @Column(name = "shg_mtg_uid")
    private BigInteger shgMtgUid;
    
    @Column(name = "interest_demand")
    private Integer interestDemand ;


    @Column(name = "rescheduled_overdue")
    private Integer rescheduledOverdue;
    
   
    @Column(name = "original_principal_demand")
    private Integer originalPrincipalDemand;
    
    @Column(name = "status")
    private Integer status  ;

    @Column(name = "org_installment_no")
    private Integer  orgInstallmentNo;

    
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

    public void setLoanNo(Integer loanNo) {
        this.loanNo = loanNo;
    }

    public Integer getLoanNo() {
        return loanNo;
    }

    public void setPrincipalDemand(Integer principalDemand) {
        this.principalDemand = principalDemand;
    }

    public Integer getPrincipalDemand() {
        return principalDemand;
    }

    public void setLoanDemandOs(Integer loanDemandOs) {
        this.loanDemandOs = loanDemandOs;
    }

    public Integer getLoanDemandOs() {
        return loanDemandOs;
    }

    public void setLoanOs(Integer loanOs) {
        this.loanOs = loanOs;
    }

    public Integer getLoanOs() {
        return loanOs;
    }

    public void setLoanPaid(Integer loanPaid) {
        this.loanPaid = loanPaid;
    }

    public Integer getLoanPaid() {
        return loanPaid;
    }

    public void setInstallmentNo(Integer installmentNo) {
        this.installmentNo = installmentNo;
    }

    public Integer getInstallmentNo() {
        return installmentNo;
    }



    public Integer getSubInstallmentNo() {
        return subInstallmentNo;
    }

    public void setSubInstallmentNo(Integer subInstallmentNo) {
        this.subInstallmentNo = subInstallmentNo;
    }

    public Timestamp getInstallmentDate1() {
        return installmentDate1;
    }

    public void setInstallmentDate1(Timestamp installmentDate1) {
        this.installmentDate1 = installmentDate1;
    }

    public Timestamp getLoanDate1() {
        return loanDate1;
    }

    public void setLoanDate1(Timestamp loanDate1) {
        this.loanDate1 = loanDate1;
    }

    public Boolean getRepaid() {
        return repaid;
    }

    public void setRepaid(Boolean repaid) {
        this.repaid = repaid;
    }

    public Timestamp getLastPaidDate1() {
        return lastPaidDate1;
    }

    public void setLastPaidDate1(Timestamp lastPaidDate1) {
        this.lastPaidDate1 = lastPaidDate1;
    }

    public Integer getMtgNo() {
        return mtgNo;
    }

    public void setMtgNo(Integer mtgNo) {
        this.mtgNo = mtgNo;
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

    @Override
    public String toString() {
        return "ShgGroupLoanScheduleEntity{" +
                "uid=" + uid + '\'' +
                "cboId=" + cboId + '\'' +
                "mtgGuid=" + mtgGuid + '\'' +
                "loanNo=" + loanNo + '\'' +
                "principalDemand=" + principalDemand + '\'' +
                "loanDemandOs=" + loanDemandOs + '\'' +
                "loanOs=" + loanOs + '\'' +
                "loanPaid=" + loanPaid + '\'' +
                "installmentNo=" + installmentNo + '\'' +
                "subInstallmentNo=" + subInstallmentNo + '\'' +
                "installmentDate=" + installmentDate1 + '\'' +
                "loanDate=" + loanDate1 + '\'' +
                "repaid=" + repaid + '\'' +
                "lastPaidDate=" + lastPaidDate1 + '\'' +
                "mtgNo=" + mtgNo + '\'' +
                "createdBy=" + createdBy + '\'' +
                "createdOn=" + createdOn1 + '\'' +
                "updatedBy=" + updatedBy + '\'' +
                "updatedOn=" + updatedOn1 + '\'' +
                "uploadedBy=" + uploadedBy + '\'' +
                "uploadedOn=" + uploadedOn + '\'' +
                '}';
    }

    public BigInteger getShgGroupLoanUid() {
        return shgGroupLoanUid;
    }

    public void setShgGroupLoanUid(BigInteger shgGroupLoanUid) {
        this.shgGroupLoanUid = shgGroupLoanUid;
    }

	public BigInteger getShgMtgUid() {
		return shgMtgUid;
	}

	public void setShgMtgUid(BigInteger shgMtgUid) {
		this.shgMtgUid = shgMtgUid;
	}

	public Integer getInterestDemand() {
		return interestDemand;
	}

	public void setInterestDemand(Integer interestDemand) {
		this.interestDemand = interestDemand;
	}

	public Integer getRescheduledOverdue() {
		return rescheduledOverdue;
	}

	public void setRescheduledOverdue(Integer rescheduledOverdue) {
		this.rescheduledOverdue = rescheduledOverdue;
	}

	public Integer getOriginalPrincipalDemand() {
		return originalPrincipalDemand;
	}

	public void setOriginalPrincipalDemand(Integer originalPrincipalDemand) {
		this.originalPrincipalDemand = originalPrincipalDemand;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public Integer getOrgInstallmentNo() {
		return orgInstallmentNo;
	}

	public void setOrgInstallmentNo(Integer orgInstallmentNo) {
		this.orgInstallmentNo = orgInstallmentNo;
	}
    
    
}

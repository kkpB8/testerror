package com.devglan.model;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigInteger;
import java.sql.Timestamp;

/**
 * $table.getTableComment()
 */
@Entity
@Table(name = "vo_mem_loan_schedule")
public class VoMemLoanScheduleEntity implements Serializable {

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

    @Column(name = "vo_mem_loan_uid")
    private BigInteger voMemberLoanUid;

    @Column(name = "vo_mtg_uid")
    private BigInteger voMtgUid;
    
    @Column(name = "loan_no")
    private Integer loanNo;


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

    
    public BigInteger getVoMemberLoanUid() {
        return voMemberLoanUid;
    }

    public void setVoMemberLoanUid(BigInteger voMemberLoanUid) {
        this.voMemberLoanUid = voMemberLoanUid;
    }

    public BigInteger getVoMtgUid() {
        return voMtgUid;
    }

    public void setVoMtgUid(BigInteger voMtgUid) {
        this.voMtgUid = voMtgUid;
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

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

    public Integer getPrincipalDemand() {
        return principalDemand;
    }

    public void setPrincipalDemand(Integer principalDemand) {
        this.principalDemand = principalDemand;
    }

    public Integer getLoanDemandOs() {
        return loanDemandOs;
    }

    public void setLoanDemandOs(Integer loanDemandOs) {
        this.loanDemandOs = loanDemandOs;
    }

    public Integer getLoanOs() {
        return loanOs;
    }

    public void setLoanOs(Integer loanOs) {
        this.loanOs = loanOs;
    }

    public Integer getLoanPaid() {
        return loanPaid;
    }

    public void setLoanPaid(Integer loanPaid) {
        this.loanPaid = loanPaid;
    }

    public Integer getInstallmentNo() {
        return installmentNo;
    }

    public void setInstallmentNo(Integer installmentNo) {
        this.installmentNo = installmentNo;
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

    
    public Integer getLoanNo() {
		return loanNo;
	}

	public void setLoanNo(Integer loanNo) {
		this.loanNo = loanNo;
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

	@Override
    public String toString() {
        return "ShgMemLoanScheduleEntity{" +
                "uid=" + uid + '\'' +
                "cboId=" + cboId + '\'' +
                "memId=" + memId + '\'' +
                "mtgGuid=" + mtgGuid + '\'' +
                "principalDemand=" + principalDemand + '\'' +
                "loanDemandOs=" + loanDemandOs + '\'' +
                "loanOs=" + loanOs + '\'' +
                "loanPaid=" + loanPaid + '\'' +
                "installmentNo=" + installmentNo + '\'' +
                "subInstallmentNo=" + subInstallmentNo + '\'' +
                "installmentDate=" + installmentDate1 + '\'' +
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
}

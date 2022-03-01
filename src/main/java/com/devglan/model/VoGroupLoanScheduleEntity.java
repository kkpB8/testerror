package com.devglan.model;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigInteger;
import java.sql.Timestamp;

/**
 * $table.getTableComment()
 */
@Entity
@Table(name = "vo_group_loan_schedule")
public class VoGroupLoanScheduleEntity implements Serializable {

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

    @Column(name = "vo_group_loan_uid")
    private BigInteger voGroupLoanUid;

    @Column(name = "vo_mtg_uid")
    private BigInteger voMtgUid;

    public BigInteger getVoGroupLoanUid() {
        return voGroupLoanUid;
    }

    public void setVoGroupLoanUid(BigInteger voGroupLoanUid) {
        this.voGroupLoanUid = voGroupLoanUid;
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

    

    public String getMtgGuid() {
		return mtgGuid;
	}

	public void setMtgGuid(String mtgGuid) {
		this.mtgGuid = mtgGuid;
	}

	public Integer getLoanNo() {
        return loanNo;
    }

    public void setLoanNo(Integer loanNo) {
        this.loanNo = loanNo;
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
}

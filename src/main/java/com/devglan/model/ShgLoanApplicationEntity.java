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
@Table(name = "shg_loan_application")
public class ShgLoanApplicationEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "uid", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private BigInteger uid;

    @Column(name = "loan_application_id", nullable = false)
    private BigInteger loanApplicationId;

    @Column(name = "cbo_id", nullable = false)
    private BigInteger cboId;

    @Column(name = "mem_id", nullable = false)
    private BigInteger memId;

    @Column(name = "request_date", nullable = false)
    private Timestamp requestDate1;

    @Column(name = "loan_fee")
    private Integer loanFee;

    @Column(name = "amt_demand", nullable = false)
    private Integer amtDemand;

    @Column(name = "amt_sanction")
    private Integer amtSanction;

    @Column(name = "amt_disbursed")
    private Integer amtDisbursed;

    @Column(name = "approval_date")
    private Timestamp approvalDate1;

    @Column(name = "tentative_date")
    private Timestamp tentativeDate1;

    @Column(name = "loan_product_id")
    private Integer loanProductId;

    @Column(name = "loan_source")
    private Integer loanSource;

    @Column(name = "loan_purpose", nullable = false)
    private Integer loanPurpose;

    @Column(name = "loan_period")
    private Integer loanPeriod;

    @Column(name = "loan_requested_mtg_no", nullable = false)
    private Integer loanRequestedMtgNo;

    @Column(name = "loan_requested_mtg_guid", nullable = false)
    private String loanRequestedMtgGuid;

    @Column(name = "loan_sanctioned_mtg_no", nullable = false)
    private Integer loanSanctionedMtgNo;

    @Column(name = "loan_sanctioned_mtg_guid", nullable = false)
    private String loanSanctionedMtgGuid;

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

    //030921 @mohit
    @Column(name = "loan_request_priority")
    private Integer loanRequestPriority;
    @Column(name = "mcp_id")
    private Long mcpId;

    public void setUid(BigInteger uid) {
        this.uid = uid;
    }

    public BigInteger getUid() {
        return uid;
    }

    public void setLoanApplicationId(BigInteger loanApplicationId) {
        this.loanApplicationId = loanApplicationId;
    }

    public BigInteger getLoanApplicationId() {
        return loanApplicationId;
    }

    public void setCboId(BigInteger cboId) {
        this.cboId = cboId;
    }

    public BigInteger getCboId() {
        return cboId;
    }

    public void setMemId(BigInteger memId) {
        this.memId = memId;
    }

    public BigInteger getMemId() {
        return memId;
    }


    public void setLoanFee(Integer loanFee) {
        this.loanFee = loanFee;
    }

    public Integer getLoanFee() {
        return loanFee;
    }

    public void setAmtDemand(Integer amtDemand) {
        this.amtDemand = amtDemand;
    }

    public Integer getAmtDemand() {
        return amtDemand;
    }

    public void setAmtSanction(Integer amtSanction) {
        this.amtSanction = amtSanction;
    }

    public Integer getAmtSanction() {
        return amtSanction;
    }

    public void setAmtDisbursed(Integer amtDisbursed) {
        this.amtDisbursed = amtDisbursed;
    }

    public Integer getAmtDisbursed() {
        return amtDisbursed;
    }

    public Timestamp getApprovalDate1() {
        return approvalDate1;
    }

    public void setApprovalDate1(Timestamp approvalDate1) {
        this.approvalDate1 = approvalDate1;
    }

    public void setLoanProductId(Integer loanProductId) {
        this.loanProductId = loanProductId;
    }

    public Integer getLoanProductId() {
        return loanProductId;
    }

    public void setLoanSource(Integer loanSource) {
        this.loanSource = loanSource;
    }

    public Integer getLoanSource() {
        return loanSource;
    }

    public void setLoanPurpose(Integer loanPurpose) {
        this.loanPurpose = loanPurpose;
    }

    public Integer getLoanPurpose() {
        return loanPurpose;
    }

    public void setLoanPeriod(Integer loanPeriod) {
        this.loanPeriod = loanPeriod;
    }

    public Integer getLoanPeriod() {
        return loanPeriod;
    }

    public void setLoanRequestedMtgNo(Integer loanRequestedMtgNo) {
        this.loanRequestedMtgNo = loanRequestedMtgNo;
    }

    public Integer getLoanRequestedMtgNo() {
        return loanRequestedMtgNo;
    }

    public void setLoanRequestedMtgGuid(String loanRequestedMtgGuid) {
        this.loanRequestedMtgGuid = loanRequestedMtgGuid;
    }

    public String getLoanRequestedMtgGuid() {
        return loanRequestedMtgGuid;
    }

    public void setLoanSanctionedMtgNo(Integer loanSanctionedMtgNo) {
        this.loanSanctionedMtgNo = loanSanctionedMtgNo;
    }

    public Integer getLoanSanctionedMtgNo() {
        return loanSanctionedMtgNo;
    }

    public void setLoanSanctionedMtgGuid(String loanSanctionedMtgGuid) {
        this.loanSanctionedMtgGuid = loanSanctionedMtgGuid;
    }

    public String getLoanSanctionedMtgGuid() {
        return loanSanctionedMtgGuid;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    public String getCreatedBy() {
        return createdBy;
    }



    public void setUpdatedBy(String updatedBy) {
        this.updatedBy = updatedBy;
    }

    public String getUpdatedBy() {
        return updatedBy;
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



    public Timestamp getRequestDate1() {
        return requestDate1;
    }

    public void setRequestDate1(Timestamp requestDate1) {
        this.requestDate1 = requestDate1;
    }

    public Timestamp getTentativeDate1() {
        return tentativeDate1;
    }

    public void setTentativeDate1(Timestamp tentativeDate1) {
        this.tentativeDate1 = tentativeDate1;
    }

    public Timestamp getCreatedOn1() {
        return createdOn1;
    }

    public void setCreatedOn1(Timestamp createdOn1) {
        this.createdOn1 = createdOn1;
    }

    public Timestamp getUpdatedOn1() {
        return updatedOn1;
    }

    public void setUpdatedOn1(Timestamp updatedOn1) {
        this.updatedOn1 = updatedOn1;
    }

    @Override
    public String toString() {
        return "ShgLoanApplicationEntity{" +
                "uid=" + uid + '\'' +
                "loanApplicationId=" + loanApplicationId + '\'' +
                "cboId=" + cboId + '\'' +
                "memId=" + memId + '\'' +
                "requestDate=" + requestDate1 + '\'' +
                "loanFee=" + loanFee + '\'' +
                "amtDemand=" + amtDemand + '\'' +
                "amtSanction=" + amtSanction + '\'' +
                "amtDisbursed=" + amtDisbursed + '\'' +
                "approvalDate1=" + approvalDate1 + '\'' +
                "tentativeDate=" + tentativeDate1 + '\'' +
                "loanProductId=" + loanProductId + '\'' +
                "loanSource=" + loanSource + '\'' +
                "loanPurpose=" + loanPurpose + '\'' +
                "loanPeriod=" + loanPeriod + '\'' +
                "loanRequestedMtgNo=" + loanRequestedMtgNo + '\'' +
                "loanRequestedMtgGuid=" + loanRequestedMtgGuid + '\'' +
                "loanSanctionedMtgNo=" + loanSanctionedMtgNo + '\'' +
                "loanSanctionedMtgGuid=" + loanSanctionedMtgGuid + '\'' +
                "createdBy=" + createdBy + '\'' +
                "createdOn=" + createdOn1 + '\'' +
                "updatedBy=" + updatedBy + '\'' +
                "updatedOn=" + updatedOn1+ '\'' +
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

    public Integer getLoanRequestPriority() {
        return loanRequestPriority;
    }

    public void setLoanRequestPriority(Integer loanRequestPriority) {
        this.loanRequestPriority = loanRequestPriority;
    }

    public Long getMcpId() {
        return mcpId;
    }

    public void setMcpId(Long mcpId) {
        this.mcpId = mcpId;
    }
}

package com.devglan.model;


import javax.persistence.*;
import java.math.*;
import java.sql.Timestamp;
import java.time.*;
import java.util.*;

@Entity
@Table(name = "shg_member_designation")
public class SHGDesignationEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "member_designation_id", nullable = false)
    private BigInteger memberDesignationId;
    @Column(name = "cbo_guid", nullable = false)
    private String cboGUID;
    @Column(name = "member_designation_guid", nullable = false)
    private String memberDesignationGUID;
    @Column(name = "cbo_code")
    private BigInteger cboCode;
    @Column(name = "member_code")
    private BigInteger memberCode;
    @Column(name = "member_guid")
    private String memberGUID;
    @Column(name = "designation", nullable = false)
    private Short designation;
    @Column(name = "date_election")
    private Date dateElection;
    @Column(name = "from_date")
    private Date fromDate;
    @Column(name = "to_date")
    private Date toDate;
    @Column(name = "status")
    private Short status;
    @Column(name = "entry_source", nullable = false)
    private Short entrySource;
    @Column(name = "is_edited", nullable = false)
    private Integer isEdited;
    @Column(name = "is_active", nullable = false)
    private Boolean isActive;
    @Column(name = "last_uploaded_date")
    private Timestamp lastUploadedDate;
    @Column(name = "uploaded_by")
    private String uploadedBy;
    @Column(name = "created_date", nullable = false)
    private Timestamp createdDate;
    @Column(name = "created_by", nullable = false)
    private String createdBy;
    @Column(name = "updated_date")
    private Timestamp updatedDate;
    @Column(name = "updated_by")
    private String updatedBy;
	
	@Column(name = "is_signatory")
    private Short isSignatory;

    public BigInteger getMemberDesignationId() {
        return memberDesignationId;
    }

    public void setMemberDesignationId(final BigInteger memberDesignationId) {
        this.memberDesignationId = memberDesignationId;
    }

    public String getCboGUID() {
        return cboGUID;
    }

    public void setCboGUID(final String cboGUID) {
        this.cboGUID = cboGUID;
    }

    public String getMemberDesignationGUID() {
        return memberDesignationGUID;
    }

    public void setMemberDesignationGUID(final String memberDesignationGUID) {
        this.memberDesignationGUID = memberDesignationGUID;
    }

    public BigInteger getCboCode() {
        return cboCode;
    }

    public void setCboCode(final BigInteger cboCode) {
        this.cboCode = cboCode;
    }

    public BigInteger getMemberCode() {
        return memberCode;
    }

    public void setMemberCode(final BigInteger memberCode) {
        this.memberCode = memberCode;
    }

    public String getMemberGUID() {
        return memberGUID;
    }

    public void setMemberGUID(final String memberGUID) {
        this.memberGUID = memberGUID;
    }

    public Short getDesignation() {
        return designation;
    }

    public void setDesignation(final Short designation) {
        this.designation = designation;
    }

    public Date getDateElection() {
        return dateElection;
    }

    public void setDateElection(final Date dateElection) {
        this.dateElection = dateElection;
    }

    public Date getFromDate() {
        return fromDate;
    }

    public void setFromDate(final Date fromDate) {
        this.fromDate = fromDate;
    }

    public Date getToDate() {
        return toDate;
    }

    public void setToDate(final Date toDate) {
        this.toDate = toDate;
    }

    public Short getStatus() {
        return status;
    }

    public void setStatus(final Short status) {
        this.status = status;
    }

    public Short getEntrySource() {
        return entrySource;
    }

    public void setEntrySource(final Short entrySource) {
        this.entrySource = entrySource;
    }

    public Integer getIsEdited() {
        return isEdited;
    }

    public void setIsEdited(final Integer isEdited) {
        this.isEdited = isEdited;
    }

    public Boolean getActive() {
        return isActive;
    }

    public void setActive(final Boolean active) {
        isActive = active;
    }

    public Timestamp getLastUploadedDate() {
        return lastUploadedDate;
    }

    public void setLastUploadedDate(final Timestamp lastUploadedDate) {
        this.lastUploadedDate = lastUploadedDate;
    }

    public String getUploadedBy() {
        return uploadedBy;
    }

    public void setUploadedBy(final String uploadedBy) {
        this.uploadedBy = uploadedBy;
    }

    public Timestamp getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(final Timestamp createdDate) {
        this.createdDate = createdDate;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(final String createdBy) {
        this.createdBy = createdBy;
    }

    public Timestamp getUpdatedDate() {
        return updatedDate;
    }

    public void setUpdatedDate(final Timestamp updatedDate) {
        this.updatedDate = updatedDate;
    }

    public String getUpdatedBy() {
        return updatedBy;
    }

    public void setUpdatedBy(final String updatedBy) {
        this.updatedBy = updatedBy;
    }
	
	 public Short getIsSignatory() {
        return isSignatory;
    }

    public void setIsSignatory(final Short isSignatory) {
        this.isSignatory = isSignatory;
    }
}

package com.devglan.model;


import javax.persistence.*;
import java.math.*;
import java.sql.Timestamp;
import java.time.*;
import java.util.*;

@Entity
@Table(name = "cbo_mapping_details")
public class CboMappingDetailsEntity {

 
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cbo_mapping_id", nullable = false)
    private BigInteger cboMappingId;

    @Column(name = "cbo_guid", nullable = false)
    private String cboGUID;
    @Column(name = "cbo_child_guid")
    private String cboChildGUID;
    @Column(name = "cbo_id", nullable = false)
    private BigInteger cboId;
    @Column(name = "cbo_child_id")
    private BigInteger cboChildId;
    @Column(name = "cbo_child_code")
    private BigInteger cboChildCode;
    @Column(name = "cbo_level", nullable = false)
    private Short cboLevel;
    @Column(name = "cbo_child_level", nullable = false)
    private Short cboChildLevel;

    @Column(name = "joining_date")
    private Date joiningDate;
    @Column(name = "leaving_date")
    private Date leavingDate;

    @Column(name = "settlement_status")
    private Short settlementStatus;

    @Column(name = "leaving_reason")
    private String leavingReason;

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

    public BigInteger getCboMappingId() {
        return cboMappingId;
    }

    public void setCboMappingId(final BigInteger cboMappingId) {
        this.cboMappingId = cboMappingId;
    }

    public String getCboGUID() {
        return cboGUID;
    }

    public void setCboGUID(final String cboGUID) {
        this.cboGUID = cboGUID;
    }

    public String getCboChildGUID() {
        return cboChildGUID;
    }

    public void setCboChildGUID(final String cboChildGUID) {
        this.cboChildGUID = cboChildGUID;
    }

    public BigInteger getCboId() {
        return cboId;
    }

    public void setCboId(final BigInteger cboId) {
        this.cboId = cboId;
    }

    public BigInteger getCboChildId() {
        return cboChildId;
    }

    public void setCboChildId(final BigInteger cboChildId) {
        this.cboChildId = cboChildId;
    }

    public BigInteger getCboChildCode() {
        return cboChildCode;
    }

    public void setCboChildCode(final BigInteger cboChildCode) {
        this.cboChildCode = cboChildCode;
    }

    public Short getCboLevel() {
        return cboLevel;
    }

    public void setCboLevel(final Short cboLevel) {
        this.cboLevel = cboLevel;
    }

    public Short getCboChildLevel() {
        return cboChildLevel;
    }

    public void setCboChildLevel(final Short cboChildLevel) {
        this.cboChildLevel = cboChildLevel;
    }

    public Date getJoiningDate() {
        return joiningDate;
    }

    public void setJoiningDate(final Date joiningDate) {
        this.joiningDate = joiningDate;
    }

    public Date getLeavingDate() {
        return leavingDate;
    }

    public void setLeavingDate(final Date leavingDate) {
        this.leavingDate = leavingDate;
    }

    public Short getSettlementStatus() {
        return settlementStatus;
    }

    public void setSettlementStatus(final Short settlementStatus) {
        this.settlementStatus = settlementStatus;
    }

    public String getLeavingReason() {
        return leavingReason;
    }

    public void setLeavingReason(final String leavingReason) {
        this.leavingReason = leavingReason;
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
}

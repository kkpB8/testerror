package com.devglan.model;



import javax.persistence.*;
import java.math.*;
import java.sql.Timestamp;

@Entity
@Table(name = "system_tags")
public class SystemTagsEntity {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "systemtags_id", nullable = false)
    private BigInteger systemTagsId;
    @Column(name = "cbo_guid")
    private String cboGUID;
    @Column(name = "system_tag_guid")
    private String systemTagGUID;
    @Column(name = "cbo_code")
    private BigInteger cboCode;
    @Column(name = "system_type")
    private Short systemType;
    @Column(name = "system_id")
    private String systemId;
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
    //@satwant06052021
    @Column(name = "is_complete")
    private Integer isComplete;

    public BigInteger getSystemTagsId() {
        return systemTagsId;
    }

    public void setSystemTagsId(final BigInteger systemTagsId) {
        this.systemTagsId = systemTagsId;
    }

    public String getCboGUID() {
        return cboGUID;
    }

    public void setCboGUID(final String cboGUID) {
        this.cboGUID = cboGUID;
    }

    public String getSystemTagGUID() {
        return systemTagGUID;
    }

    public void setSystemTagGUID(final String systemTagGUID) {
        this.systemTagGUID = systemTagGUID;
    }

    public BigInteger getCboCode() {
        return cboCode;
    }

    public void setCboCode(final BigInteger cboCode) {
        this.cboCode = cboCode;
    }

    public Short getSystemType() {
        return systemType;
    }

    public void setSystemType(final Short systemType) {
        this.systemType = systemType;
    }

    public String getSystemId() {
        return systemId;
    }

    public void setSystemId(final String systemId) {
        this.systemId = systemId;
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

    public Integer getIsComplete() {
        return isComplete;
    }

    public void setIsComplete(Integer isComplete) {
        this.isComplete = isComplete;
    }
}


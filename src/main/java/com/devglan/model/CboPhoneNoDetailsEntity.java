package com.devglan.model;

//import org.apache.fineract.cn.group.internal.entity.identity.CustomPhoneNoIdentity;


import javax.persistence.*;
import java.math.BigInteger;
import java.sql.Timestamp;
import java.util.Date;

@Entity
@Table(name = "cbo_phone_details")
public class CboPhoneNoDetailsEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cbo_phone_id", nullable = false)
    private BigInteger cboPhoneId;
    @Column(name = "phone_guid")
    private String phoneGuid;
    @Column(name = "cbo_guid")
    private String cboGuid;
    @Column(name = "cbo_id", nullable = false)
    private BigInteger cboId;
    @Column(name = "mobile_no", nullable = false)
    private BigInteger mobileNo;
    @Column(name = "cbo_type", nullable = false)
    private Short cboType;
    @Column(name = "phone_ownership", nullable = false)
    private Short phoneOwnership;
    @Column(name = "phone_ownership_details")
    private String phoneOwnershipDetails;
    @Column(name = "valid_from", nullable = false)
    private Date validFrom;
    @Column(name = "valid_till")
    private Date validTill;
    @Column(name = "is_default", nullable = false)
    private Short isDefault;
    @Column(name = "dedupl_status")
    private Short deduplicationStatus;
    @Column(name = "activation_status")
    private Short activationStatus;
    @Column(name = "status")
    private Short status;
    @Column(name = "is_active", nullable = false)
    private Boolean isActive;
    @Column(name = "entry_source", nullable = false)
    private Short entrySource;
    @Column(name = "is_edited", nullable = false)
    private Integer isEdited;
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
    @Column(name = "member_guid")
    private String memberGuid;
    //@satwant06052021
    @Column(name = "is_verified")
    private Integer isVerified;

    @Column(name = "is_complete")
    private Integer isComplete;


    public CboPhoneNoDetailsEntity() {
        super();
    }

    public String getPhoneOwnershipDetails() {
        return phoneOwnershipDetails;
    }

    public void setPhoneOwnershipDetails(final String phoneOwnershipDetails) {
        this.phoneOwnershipDetails = phoneOwnershipDetails;
    }

    public Date getValidFrom() {
        return validFrom;
    }

    public void setValidFrom(final Date validFrom) {
        this.validFrom = validFrom;
    }

    public Date getValidTill() {
        return validTill;
    }

    public void setValidTill(final Date validTill) {
        this.validTill = validTill;
    }

    public Short getCboType() {
        return cboType;
    }

    public void setCboType(final Short cboType) {
        this.cboType = cboType;
    }

    public Short getDeduplicationStatus() {
        return deduplicationStatus;
    }

    public void setDeduplicationStatus(final Short deduplicationStatus) {
        this.deduplicationStatus = deduplicationStatus;
    }

    public Short getActivationStatus() {
        return activationStatus;
    }

    public void setActivationStatus(final Short activationStatus) {
        this.activationStatus = activationStatus;
    }

    public Boolean getActive() {
        return isActive;
    }

    public void setActive(final Boolean active) {
        isActive = active;
    }

    public Timestamp getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(final Timestamp createdDate) {
        this.createdDate = createdDate;
    }

    public Timestamp getUpdatedDate() {
        return updatedDate;
    }

    public void setUpdatedDate(final Timestamp updatedDate) {
        this.updatedDate = updatedDate;
    }


    public Short getIsDefault() {
        return isDefault;
    }

    public void setIsDefault(final Short isDefault) {
        this.isDefault = isDefault;
    }

    public BigInteger getCboPhoneId() {
        return cboPhoneId;
    }

    public void setCboPhoneId(final BigInteger cboPhoneId) {
        this.cboPhoneId = cboPhoneId;
    }

    public BigInteger getCboId() {
        return cboId;
    }

    public void setCboId(BigInteger cboId) {
        this.cboId = cboId;
    }

    public BigInteger getMobileNo() {
        return mobileNo;
    }

    public void setMobileNo(final BigInteger mobileNo) {
        this.mobileNo = mobileNo;
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

    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(final String createdBy) {
        this.createdBy = createdBy;
    }

    public String getUpdatedBy() {
        return updatedBy;
    }

    public void setUpdatedBy(final String updatedBy) {
        this.updatedBy = updatedBy;
    }

    public String getPhoneGuid() {
        return phoneGuid;
    }

    public void setPhoneGuid(final String phoneGuid) {
        this.phoneGuid = phoneGuid;
    }

    public String getCboGuid() {
        return cboGuid;
    }

    public void setCboGuid(final String cboGuid) {
        this.cboGuid = cboGuid;
    }

    public Short getPhoneOwnership() {
        return phoneOwnership;
    }

    public void setPhoneOwnership(final Short phoneOwnership) {
        this.phoneOwnership = phoneOwnership;
    }

    public Short getStatus() {
        return status;
    }

    public void setStatus(final Short status) {
        this.status = status;
    }

    public String getMemberGuid() {
        return memberGuid;
    }

    public void setMemberGuid(String memberGuid) {
        this.memberGuid = memberGuid;
    }

    public Integer getIsVerified() {
        return isVerified;
    }

    public void setIsVerified(Integer isVerified) {
        this.isVerified = isVerified;
    }

    public Integer getIsComplete() {
        return isComplete;
    }

    public void setIsComplete(Integer isComplete) {
        this.isComplete = isComplete;
    }
}

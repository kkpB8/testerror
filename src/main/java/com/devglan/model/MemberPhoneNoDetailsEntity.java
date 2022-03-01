package com.devglan.model;

//import org.apache.fineract.cn.group.internal.entity.identity.CustomPhoneNoIdentity;


import javax.persistence.*;
import java.math.BigInteger;
import java.sql.Timestamp;
import java.util.Date;

@Entity
@Table(name = "member_phone_details")
public class MemberPhoneNoDetailsEntity {

    /*@EmbeddedId
    private org.apache.fineract.cn.group.internal.repository.MemberPhoneNoIdentity memberPhoneNoIdentity;
    */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "member_phone_details_id", nullable = false)
    private BigInteger memberPhoneDetailsId;
    @Column(name = "phone_guid", nullable = false)
    private String phoneGUID;
    @Column(name = "member_guid")
    private String memberGUID;
    @Column(name = "member_code")
    private BigInteger memberCode;
    @Column(name = "phone_no", nullable = false)
    private BigInteger phoneNo;
    @Column(name = "is_default", nullable = false)
    private Short isDefault;
    @Column(name = "phone_ownership", nullable = false)
    private Short phoneOwnership;
    @Column(name = "phone_ownership_details")
    private String phoneOwnershipDetails;
    @Column(name = "valid_from", nullable = false)
    private Date validFrom;
    @Column(name = "valid_till")
    private Date validTill;
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
    @Column(name = "activation_status")
    private Short activationStatus;
    @Column(name = "dedupl_status")
    private Short deduplSatus;
    @Column(name = "cbo_id")
    private BigInteger cboId;
    //@satwant06052021
    @Column(name = "is_verified")
    private Integer isVerified;

    @Column(name = "is_complete")
    private Integer isComplete;

    public MemberPhoneNoDetailsEntity() {
        super();
    }

    public BigInteger getMemberPhoneDetailsId() {
        return memberPhoneDetailsId;
    }

    public void setMemberPhoneDetailsId(final BigInteger memberPhoneDetailsId) {
        this.memberPhoneDetailsId = memberPhoneDetailsId;
    }

    public String getPhoneGUID() {
        return phoneGUID;
    }

    public void setPhoneGUID(final String  phoneGUID) {
        this.phoneGUID = phoneGUID;
    }

    public BigInteger getMemberCode() {
        return memberCode;
    }

    public void setMemberCode(final BigInteger memberCode) {
        this.memberCode = memberCode;
    }

    public BigInteger getPhoneNo() {
        return phoneNo;
    }

    public void setPhoneNo(final BigInteger phoneNo) {
        this.phoneNo = phoneNo;
    }

    public Short getIsDefault() {
        return isDefault;
    }

    public void setIsDefault(final Short  isDefault) {
        this.isDefault = isDefault;
    }

    public Short getPhoneOwnership() {
        return phoneOwnership;
    }

    public void setPhoneOwnership(final Short  phoneOwnership) {
        this.phoneOwnership = phoneOwnership;
    }

    public String getPhoneOwnershipDetails() {
        return phoneOwnershipDetails;
    }

    public void setPhoneOwnershipDetails(final String  phoneOwnershipDetails) {
        this.phoneOwnershipDetails = phoneOwnershipDetails;
    }

    public Date getValidFrom() {
        return validFrom;
    }

    public void setValidFrom(final Date  validFrom) {
        this.validFrom = validFrom;
    }

    public Date getValidTill() {
        return validTill;
    }

    public void setValidTill(final Date  validTill) {
        this.validTill = validTill;
    }

    public Short getEntrySource() {
        return entrySource;
    }

    public void setEntrySource(final Short  entrySource) {
        this.entrySource = entrySource;
    }

    public Integer getIsEdited() {
        return isEdited;
    }

    public void setIsEdited(Integer isEdited) {
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



    public Timestamp getUpdatedDate() {
        return updatedDate;
    }

    public void setUpdatedDate(final Timestamp updatedDate) {
        this.updatedDate = updatedDate;
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

    public Short getActivationStatus() {
        return activationStatus;
    }

    public void setActivationStatus(Short activationStatus) {
        this.activationStatus = activationStatus;
    }

    public Short getDedupStatus() {
        return deduplSatus;
    }

    public void setDedupStatus(Short deduplSatus) {
        this.deduplSatus = deduplSatus;
    }

    public String getMemberGUID() {
        return memberGUID;
    }

    public void setMemberGUID(String memberGUID) {
        this.memberGUID = memberGUID;
    }

    public BigInteger getCboId() {
        return cboId;
    }

    public void setCboId(BigInteger cboId) {
        this.cboId = cboId;
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

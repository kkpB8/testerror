
package com.devglan.model;

        import javax.persistence.*;
        import java.math.BigInteger;
import java.sql.Timestamp;

@Entity
@Table(name = "member_systemTags")
public class MemberSystemTagsEntity {

    /*@EmbeddedId
    private org.apache.fineract.cn.group.internal.repository.MemberBankIdentity memberBankIdentity;*/
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "systemTags_id", nullable = false)
    private BigInteger systemTagsId;

    @Column(name = "member_GUID", nullable = false)
    private String memberGUID;
    @Column(name = "system_tag_guid")
    private String systemTagGUID;
    @Column(name = "cbo_id")
    private BigInteger cboId;
    @Column(name = "member_code")
    private BigInteger memberCode;
    @Column(name = "system_type", nullable = false)
    private Integer systemType;
    @Column(name = "system_id", nullable = false)
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

    public String getMemberGUID() {
        return memberGUID;
    }

    public void setMemberGUID(final String memberGUID) {
        this.memberGUID = memberGUID;
    }

    public BigInteger getMemberCode() {
        return memberCode;
    }

    public void setMemberCode(final BigInteger memberCode) {
        this.memberCode = memberCode;
    }

    public Integer getSystemType() {
        return systemType;
    }

    public void setSystemType(final Integer systemType) {
        this.systemType = systemType;
    }

    public String getSystemId() {
        return systemId;
    }

    public void setSystemId(String systemId) {
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

    public String getSystemTagGUID() {
        return systemTagGUID;
    }

    public void setSystemTagGUID(String systemTagGUID) {
        this.systemTagGUID = systemTagGUID;
    }

    public BigInteger getCboId() {
        return cboId;
    }

    public void setCboId(BigInteger cboId) {
        this.cboId = cboId;
    }

    public Integer getIsComplete() {
        return isComplete;
    }

    public void setIsComplete(Integer isComplete) {
        this.isComplete = isComplete;
    }
}

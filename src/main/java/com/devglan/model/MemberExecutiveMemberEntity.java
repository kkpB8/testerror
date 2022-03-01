package com.devglan.model;

        

        import javax.persistence.*;
        import java.math.BigInteger;
        import java.sql.Timestamp;
        import java.util.Date;

@Entity
@Table(name = "Executive_member")
public class MemberExecutiveMemberEntity {

    /*@EmbeddedId
    private org.apache.fineract.cn.group.internal.repository.MemberBankIdentity memberBankIdentity;*/
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Executive_member_id", nullable = false)
    private BigInteger executiveMemberId;

    @Column(name = "cbo_GUID", nullable = false)
    private String cboGUID;
    @Column(name = "cbo_code", nullable = false)
    private String cboCode;
    @Column(name = "member_code")
    private BigInteger memberCode;
    @Column(name = "designation", nullable = false)
    private Integer designation;
    @Column(name = "fromDate", nullable = false)
    private Date fromDate;
    @Column(name = "toDate")
    private Date toDate;
    @Column(name = "Status")
    private Boolean status;
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
    @Column(name = "designation_at_CBO")
    private String designationAtCBO;
    @Column(name = "designation_at_CBO_level")
    private Short designationAtCBOLevel;
    //@satwant06052021
    @Column(name = "is_complete")
    private Integer isComplete;
    
    //@Adish 
    @Column(name = "signatory_joining_date")
    private Date signatoryJoiningDate;
    @Column(name = "signatory_leaving_date")
    private Date signatoryLeavingDate;

  

    public Date getSignatoryJoiningDate() {
		return signatoryJoiningDate;
	}

	public void setSignatoryJoiningDate(Date signatoryJoiningDate) {
		this.signatoryJoiningDate = signatoryJoiningDate;
	}

	public Date getSignatoryLeavingDate() {
		return signatoryLeavingDate;
	}

	public void setSignatoryLeavingDate(Date signatoryLeavingDate) {
		this.signatoryLeavingDate = signatoryLeavingDate;
	}

	public BigInteger getExecutiveMemberId() {
        return executiveMemberId;
    }

    public void setExecutiveMemberId(final BigInteger executiveMemberId) {
        this.executiveMemberId = executiveMemberId;
    }

    public String getCboGUID() {
        return cboGUID;
    }

    public void setCboGUID(final String cboGUID) {
        this.cboGUID = cboGUID;
    }

    public String getCboCode() {
        return cboCode;
    }

    public void setCboCode(final String cboCode) {
        this.cboCode = cboCode;
    }

    public BigInteger getMemberCode() {
        return memberCode;
    }

    public void setMemberCode(final BigInteger memberCode) {
        this.memberCode = memberCode;
    }

    public Integer getDesignation() {
        return designation;
    }

    public void setDesignation(final Integer designation) {
        this.designation = designation;
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

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(final Boolean status) {
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

    public Boolean getActive() {
        return isActive;
    }

    public void setActive(final Boolean active) {
        isActive = active;
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

    public String getDesignationAtCBO() {
        return designationAtCBO;
    }

    public void setDesignationAtCBO(String designationAtCBO) {
        this.designationAtCBO = designationAtCBO;
    }

    public Short getDesignationAtCBOLevel() {
        return designationAtCBOLevel;
    }

    public void setDesignationAtCBOLevel(Short designationAtCBOLevel) {
        this.designationAtCBOLevel = designationAtCBOLevel;
    }

    public Integer getIsComplete() {
        return isComplete;
    }

    public void setIsComplete(Integer isComplete) {
        this.isComplete = isComplete;
    }
}

package com.devglan.model;



import javax.persistence.*;
import java.math.BigInteger;
import java.sql.Timestamp;
import java.util.Date;

@Entity
@Table(name = "member_profile")
public class MemberProfileEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "member_id", nullable = false)
    private BigInteger memberId;
    @Column(name = "member_code")
    private BigInteger memberCode;
    /*code add by mohit kumar start*/
    @Column(name = "cbo_id" , nullable = false)
    private BigInteger cboId;
    @Column(name = "cbo_GUID", nullable = false)
    private String cboGUID;
    @Column(name = "member_GUID")
    private String memberGUID;
    @Column(name = "group_m_code")
    private Integer groupMCode;
    @Column(name = "seq_no")
    private Integer seqNo;
    @Column(name = "member_name" , nullable = false)
    private String memberName;
    @Column(name = "member_name_local")
    private String memberNameLocal;
    @Column(name = "father_husband" , nullable = false)
    private String fatherHusband;
    @Column(name = "relation_name" , nullable = false)
    private String relationName;
    @Column(name = "relation_name_local")
    private String relationNameLocal;
    @Column(name = "gender", nullable = false)
    private Short gender;
    @Column(name = "marital_status", nullable = false)
    private Short maritalStatus;
    @Column(name = "religion")
    private Short religion;
    @Column(name = "social_category")
    private Short socialCategory;
    @Column(name = "tribal_category")
    private Short tribalCategory;
    @Column(name = "bpl", nullable = false)
    private Integer bpl;
    @Column(name = "bpl_number")
    private String bplNumber;
    @Column(name = "pip_category")
    private Short pipCategory;
    @Column(name = "pip_Date")
    //@Convert(converter = TimestampConverter.class)
    private Date pipDate;
    @Column(name = "highest_education_level")
    private Short highestEducationLevel;
    @Column(name = "dob_available", nullable = false)
    private Short dobAvailable;
    @Column(name = "dob")
    //@Convert(converter = TimestampConverter.class)
    private Date dob;
    @Column(name = "age")
    private Integer age;
    @Column(name = "age_as_on", nullable = false)
    //@Convert(converter = TimestampConverter.class)
    private Date ageAsOn;
    @Column(name = "minority", nullable = false)
    private Short minority;
    @Column(name = "is_disabled", nullable = false)
    private  Short isDisabled;
    @Column(name = "disability_details")
    private  String disabilityDetails;
    @Column(name = "wellbeing_category")
    private  Short wellbeingCategory;
    @Column(name = "primary_occupation")
    private  Short primaryOccupation;
    @Column(name = "secondary_occupation")
    private  Short secondaryOccupation;
    @Column(name = "tertiary_occupation")
    private  Short tertiaryOccupation;
    @Column(name = "joining_date", nullable = false)
    private Date joiningDate;
    @Column(name = "leaving_date")
    private Date leavingDate;
    @Column(name = "reason_for_leaving")
    private  Short reasonForLeaving;
    @Column(name = "if_minor_member_replaced")
    private  String ifMinorMemberReplaced;
    @Column(name = "guardian_name")
    private  String guardianName;
    @Column(name = "guardian_name_local")
    private  String guardianNameLocal;
    @Column(name = "guardian_relation")
    private  Short guardianRelation;
    @Column(name = "designation", nullable = false)
    private Integer designation;
    @Column(name = "status", nullable = false)
    private Integer status;
    @Column(name = "house_hold_code")
    private Integer houseHoldCode;
    @Column(name = "head_house_hold", nullable = false)
    private Short headHouseHold;
    @Column(name = "insurance", nullable = false)
    private Integer insurance;
    @Column(name = "marked_as_defaulter")
    private String markedAsDefaulter;
    @Column(name = "marked_as_defaulter_date")
    //@Convert(converter = TimestampConverter.class)
    private Date markedAsDefaulterDate;
    @Column(name = "record_modified")
    private String recordModified;
    @Column(name = "last_sync_date")

    private Timestamp lastSyncDate;

    @Column(name = "is_active", nullable = false)
    private Boolean isActive;
    @Column(name = "mem_activation_status")
    private Short memActivationStatus;
    @Column(name = "mem_dedup_status")
    private Short memDedupStatus;
    @Column(name = "entry_source")
    private Short entrySource;
    @Column(name = "settlement_status")
    private Short settlementStatus;
    @Column(name = "read_flag")
    private Boolean readFlag;
    @Column(name = "checker_remark")
    private String checkerRemark;
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
    @Column(name = "member_image")
    private String memberImage;

    @Column(name = "member_profile_document_id")
    private BigInteger memberProfileDocumentId;

    @Column(name = "approve_status")
    private Short approveStatus;
    //@satwant06052021
    @Column(name = "is_verified")
    private Integer isVerified;

    @Column(name = "is_complete")
    private Integer isComplete;
    
    @Column(name = "is_insurance")
    private Short isInsurance;

    @Column(name = "consent_form_id")
    private BigInteger consentFormId;
    
    @Column(name = "consent_form_image")
    private String consentFormImage;

    

    public static Integer stateType = 1;
    public static Integer districtType = 2;
    public static Integer blockType = 3;
    public static Integer panchayatType = 4;
    public static Integer villageType = 5;
    public static Integer groupCodeType = 6;
    public static Integer groupNameType = 7;
    public static Integer memberCodeType = 8;
    public static Integer memberNameType = 9;
    public static Integer phoneNoType = 10;


    public BigInteger getMemberId() {
        return memberId;
    }

    public void setMemberId(final BigInteger memberId) {
        this.memberId = memberId;
    }

    public BigInteger getMemberCode() {
        return memberCode;
    }

    public void setMemberCode(final BigInteger memberCode) {
        this.memberCode = memberCode;
    }

    public BigInteger getCboId() {
        return cboId;
    }

    public void setCboId(BigInteger cboId) {
        this.cboId = cboId;
    }

    public String getCboGUID() {
        return cboGUID;
    }

    public void setCboGUID(final String cboGUID) {
        this.cboGUID = cboGUID;
    }

    public String getMemberGUID() {
        return memberGUID;
    }

    public void setMemberGUID(final String memberGUID) {
        this.memberGUID = memberGUID;
    }

    public Integer getGroupMCode() {
        return groupMCode;
    }

    public void setGroupMCode(final Integer groupMCode) {
        this.groupMCode = groupMCode;
    }

    public Integer getSeqNo() {
        return seqNo;
    }

    public void setSeqNo(final Integer seqNo) {
        this.seqNo = seqNo;
    }

    public String getMemberName() {
        return memberName;
    }

    public void setMemberName(final String memberName) {
        this.memberName = memberName;
    }

    public String getMemberNameLocal() {
        return memberNameLocal;
    }

    public void setMemberNameLocal(final String memberNameLocal) {
        this.memberNameLocal = memberNameLocal;
    }

    public String getFatherHusband() {
        return fatherHusband;
    }

    public void setFatherHusband(final String fatherHusband) {
        this.fatherHusband = fatherHusband;
    }

    public String getRelationName() {
        return relationName;
    }

    public void setRelationName(final String relationName) {
        this.relationName = relationName;
    }

    public String getRelationNameLocal() {
        return relationNameLocal;
    }

    public void setRelationNameLocal(final String relationNameLocal) {
        this.relationNameLocal = relationNameLocal;
    }

    public Short getGender() {
        return gender;
    }

    public void setGender(final Short gender) {
        this.gender = gender;
    }

    public Short getMaritalStatus() {
        return maritalStatus;
    }

    public void setMaritalStatus(final Short maritalStatus) {
        this.maritalStatus = maritalStatus;
    }

    public Short getReligion() {
        return religion;
    }

    public void setReligion(final Short religion) {
        this.religion = religion;
    }

    public Short getSocialCategory() {
        return socialCategory;
    }

    public void setSocialCategory(final Short socialCategory) {
        this.socialCategory = socialCategory;
    }

    public Short getTribalCategory() {
        return tribalCategory;
    }

    public void setTribalCategory(final Short tribalCategory) {
        this.tribalCategory = tribalCategory;
    }

    public Integer getBpl() {
        return bpl;
    }

    public void setBpl(final Integer bpl) {
        this.bpl = bpl;
    }

    public String getBplNumber() {
        return bplNumber;
    }

    public void setBplNumber(final String bplNumber) {
        this.bplNumber = bplNumber;
    }

    public Short getPipCategory() {
        return pipCategory;
    }

    public void setPipCategory(final Short pipCategory) {
        this.pipCategory = pipCategory;
    }

    public Date getPipDate() {
        return pipDate;
    }

    public void setPipDate(final Date pipDate) {
        this.pipDate = pipDate;
    }

    public Short getHighestEducationLevel() {
        return highestEducationLevel;
    }

    public void setHighestEducationLevel(final Short highestEducationLevel) {
        this.highestEducationLevel = highestEducationLevel;
    }


    public Date getDob() {
        return dob;
    }

    public void setDob(final Date dob) {
        this.dob = dob;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(final Integer age) {
        this.age = age;
    }

    public Date getAgeAsOn() {
        return ageAsOn;
    }

    public void setAgeAsOn(final Date ageAsOn) {
        this.ageAsOn = ageAsOn;
    }

    public Short getMinority() {
        return minority;
    }

    public void setMinority(final Short minority) {
        this.minority = minority;
    }


    public String getDisabilityDetails() {
        return disabilityDetails;
    }

    public void setDisabilityDetails(final String disabilityDetails) {
        this.disabilityDetails = disabilityDetails;
    }

    public Short getWellbeingCategory() {
        return wellbeingCategory;
    }

    public void setWellbeingCategory(final Short wellbeingCategory) {
        this.wellbeingCategory = wellbeingCategory;
    }

    public Short getPrimaryOccupation() {
        return primaryOccupation;
    }

    public void setPrimaryOccupation(final Short primaryOccupation) {
        this.primaryOccupation = primaryOccupation;
    }

    public Short getSecondaryOccupation() {
        return secondaryOccupation;
    }

    public void setSecondaryOccupation(final Short secondaryOccupation) {
        this.secondaryOccupation = secondaryOccupation;
    }

    public Short getTertiaryOccupation() {
        return tertiaryOccupation;
    }

    public void setTertiaryOccupation(final Short tertiaryOccupation) {
        this.tertiaryOccupation = tertiaryOccupation;
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

    public Short getReasonForLeaving() {
        return reasonForLeaving;
    }

    public void setReasonForLeaving(final Short reasonForLeaving) {
        this.reasonForLeaving = reasonForLeaving;
    }

    public String getIfMinorMemberReplaced() {
        return ifMinorMemberReplaced;
    }

    public void setIfMinorMemberReplaced(final String ifMinorMemberReplaced) {
        this.ifMinorMemberReplaced = ifMinorMemberReplaced;
    }

    public String getGuardianName() {
        return guardianName;
    }

    public void setGuardianName(final String guardianName) {
        this.guardianName = guardianName;
    }

    public String getGuardianNameLocal() {
        return guardianNameLocal;
    }

    public void setGuardianNameLocal(final String guardianNameLocal) {
        this.guardianNameLocal = guardianNameLocal;
    }

    public Short getGuardianRelation() {
        return guardianRelation;
    }

    public void setGuardianRelation(final Short guardianRelation) {
        this.guardianRelation = guardianRelation;
    }

    public Integer getDesignation() {
        return designation;
    }

    public void setDesignation(final Integer designation) {
        this.designation = designation;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(final Integer status) {
        this.status = status;
    }

    public Integer getHouseHoldCode() {
        return houseHoldCode;
    }

    public void setHouseHoldCode(final Integer houseHoldCode) {
        this.houseHoldCode = houseHoldCode;
    }

    public Short getHeadHouseHold() {
        return headHouseHold;
    }

    public void setHeadHouseHold(Short headHouseHold) {
        this.headHouseHold = headHouseHold;
    }

    public Integer getInsurance() {
        return insurance;
    }

    public void setInsurance(final Integer insurance) {
        this.insurance = insurance;
    }

    public String getMarkedAsDefaulter() {
        return markedAsDefaulter;
    }

    public void setMarkedAsDefaulter(final String markedAsDefaulter) {
        this.markedAsDefaulter = markedAsDefaulter;
    }

    public Date getMarkedAsDefaulterDate() {
        return markedAsDefaulterDate;
    }

    public void setMarkedAsDefaulterDate(final Date markedAsDefaulterDate) {
        this.markedAsDefaulterDate = markedAsDefaulterDate;
    }

    public String getRecordModified() {
        return recordModified;
    }

    public void setRecordModified(final String recordModified) {
        this.recordModified = recordModified;
    }

    public Timestamp getLastSyncDate() {
        return lastSyncDate;
    }

    public void setLastSyncDate(final Timestamp lastSyncDate) {
        this.lastSyncDate = lastSyncDate;
    }


    public Boolean getActive() {
        return isActive;
    }

    public void setActive(Boolean active) {
        isActive = active;
    }

    public Short getMemActivationStatus() {
        return memActivationStatus;
    }

    public void setMemActivationStatus(final Short memActivationStatus) {
        this.memActivationStatus = memActivationStatus;
    }

    public Short getMemDedupStatus() {
        return memDedupStatus;
    }

    public void setMemDedupStatus(final Short memDedupStatus) {
        this.memDedupStatus = memDedupStatus;
    }


    public Timestamp getLastUploadedDate() {
        return lastUploadedDate;
    }

    public void setLastUploadedDate(Timestamp lastUploadedDate) {
        this.lastUploadedDate = lastUploadedDate;
    }

    public String getUploadedBy() {
        return uploadedBy;
    }

    public void setUploadedBy(String uploadedBy) {
        this.uploadedBy = uploadedBy;
    }

    public Timestamp getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(final Timestamp createdDate) {
        this.createdDate = createdDate;
    }

    public Short getEntrySource() {
        return entrySource;
    }

    public void setEntrySource(Short entrySource) {
        this.entrySource = entrySource;
    }

    public Integer getIsEdited() {
        return isEdited;
    }

    public void setIsEdited(final Integer isEdited) {
        this.isEdited = isEdited;
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


    public Short getSettlementStatus() {
        return settlementStatus;
    }

    public void setSettlementStatus(final Short settlementStatus) {
        this.settlementStatus = settlementStatus;
    }

    /*code add by mohit kumar end*/

    public Boolean getReadFlag() {
        return readFlag;
    }

    public void setReadFlag(final Boolean readFlag) {
        this.readFlag = readFlag;
    }

    public String getCheckerRemark() {
        return checkerRemark;
    }

    public void setCheckerRemark(final String checkerRemark) {
        this.checkerRemark = checkerRemark;
    }

    public String getMemberImage() {
        return memberImage;
    }

    public void setMemberImage(final String memberImage) {
        this.memberImage = memberImage;
    }

    public BigInteger getMemberProfileDocumentId() {
        return memberProfileDocumentId;
    }

    public void setMemberProfileDocumentId(final BigInteger memberProfileDocumentId) {
        this.memberProfileDocumentId = memberProfileDocumentId;
    }

    public Short getDobAvailable() {
        return dobAvailable;
    }

    public void setDobAvailable(final Short dobAvailable) {
        this.dobAvailable = dobAvailable;
    }

    public Short getIsDisabled() {
        return isDisabled;
    }

    public void setIsDisabled(final Short isDisabled) {
        this.isDisabled = isDisabled;
    }

    public Short getApproveStatus() {
        return approveStatus;
    }

    public void setApproveStatus(Short approveStatus) {
        this.approveStatus = approveStatus;
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

	public Short getIsInsurance() {
		return isInsurance;
	}

	public void setIsInsurance(Short isInsurance) {
		this.isInsurance = isInsurance;
	}


	public BigInteger getConsentFormId() {
		return consentFormId;
	}

	public void setConsentFormId(BigInteger consentFormId) {
		this.consentFormId = consentFormId;
	}

	public String getConsentFormImage() {
		return consentFormImage;
	}

	public void setConsentFormImage(String consentFormImage) {
		this.consentFormImage = consentFormImage;
	}
    
	
    
}


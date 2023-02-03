package com.devglan.model;



import javax.persistence.*;
import java.math.BigInteger;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.Date;

@Entity
@Table(name = "federation_profile")
public class
FederationProfileEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "federation_id", nullable = false)
    private BigInteger federationId;
    @Column(name = "state_id", nullable = false)
    private Integer stateId;
    @Column(name = "district_id", nullable = false)
    private Integer districtId;
    @Column(name = "block_id", nullable = false)
    private Integer blockId;
    @Column(name = "panchayat_id")
    private Integer panchayatId;
    @Column(name = "village_id")
    private Integer villageId;
    @Column(name = "federation_code")
    private BigInteger federation_code;
    @Column(name = "temp_code")
    private BigInteger temp_code;
    @Column(name = "guid")
    private String guid;
    @Column(name = "federation_name", nullable = false)
    private String federationName;
    @Column(name = "federation_type_code")
    private Short federationTypeCode;
    @Column(name = "cbo_type")
    private Short cboType;
    @Column(name = "cbo_level")
    private Short cboLevel;
    @Column(name = "child_level")
    private Short childLevel;
    @Column(name = "geographic_level")
    private Short geographicLevel;
    @Column(name = "federation_name_short_en")
    private String federationNameShortEN;
    @Column(name = "federation_name_local")
    private String federationNameLocal;
    @Column(name = "federation_name_short_local")
    private String federationNameShortLocal;
    @Column(name = "federation_formation_date")
    private Date federationFormationDate;
    @Column(name = "federation_revival_date")
    private Date federationRevivalDate;
    @Column(name = "meeting_frequency")
    private Short meetingFrequency;
    @Column(name = "meeting_frequency_value")
    private Short meetingFrequencyValue;
    @Column(name = "meeting_on")
    private Short meetingOn;
    @Column(name = "mode")
    private Short mode;
    @Column(name = "month_comp_saving")
    private Integer monthCompSaving;
    @Column(name = "is_bankaccount")
    private Boolean isBankAccount;
    @Column(name = "parent_cbo_code")
    private BigInteger parentCboId;
    @Column(name = "parent_cbo_type")
    private Short parentCboType;
    @Column(name = "dedupl_status")
    private Short deduplicationStatus;
    @Column(name = "activation_status")
    private Short activationStatus;
    @Column(name = "status")
    private Short status;
    @Column(name = "settlement_status")
    private Short settlementStatus;
    @Column(name = "is_active", nullable = false)
    private Boolean isActive;
    @Column(name = "user_id")
    private String userId;
    @Column(name = "checker_remark")
    private String checkerRemark;
    @Column(name = "promoted_by")
    private Integer promotedBy;
    @Column(name = "savings_frequency")
    private Short savingFrequency;
    @Column(name = "is_voluntary_saving")
    private Short isVoluntarySaving;
    @Column(name = "savings_interest")
    private Double savingsInterest  ;
    @Column(name = "voluntary_savings_interest")
    private Double voluntarySavingsInterest;
    @Column(name = "primary_activity")
    private Integer primaryActivity;
    @Column(name = "secondary_activity")
    private Integer secondaryActivity;
    @Column(name = "tertiary_activity")
    private Integer tertiaryActivity;
    @Column(name = "bookkeeper_name")
    private String bookkeeperName;
    @Column(name = "bookkeeper_mobile")
    private String bookkeeperMobile;
    @Column(name = "bookkeeper_identified")
    private Short bookkeeperIdentified;
    @Column(name = "election_tenure")
    private Integer electionTenure;
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

    @Column(name = "cooption_date")
    private Date cooptionDate;
    @Column(name = "federation_name_hindi")
    private String federationNameHindi;
    @Column(name = "federation_name_short")
    private String federationNameShort;
    @Column(name = "is_financial_intermediation")
    private Boolean isFinancialIntermediation;
    @Column(name = "is_volutary_saving")
    private Boolean isVolutarySaving;
    @Column(name = "meber_cbo_count")
    private Short meberCboCount;
    @Column(name = "approve_status")
    private Short approveStatus;
    @Column(name = "read_flag")
    private Boolean readFlag;
    @Column(name = "promoter_name")
    private String promoterName;

	@Column(name = "promoter_code")
    private String promoterCode;
	
    @Column(name = "federation_profile_doc_id")
    private BigInteger federationProfileDocId;
    @Column(name = "federation_resolution")
    private String federationResolution;
    //@Satwant 06052021
    @Column(name = "is_complete")
    private Integer isComplete;
    
    //@Anshul 210921
    private String approver;
    
    @Column(name = "inactive_reason")
    private Integer inactiveReason;

    @Column(name = "membership_flag")
    private Integer membershipFlag;

    @Column(name = " registration_act")
    private Integer registrationAct;

    @Column(name = "is_registered")
    private Integer isRegistered;

    @Column(name = "registration_no")
    private String registrationNo;

    @Column(name = "registration_date")
    private Date registrationDate;


    @Column(name = "registration_image")
    private  String registration_image;


    public String getApprover() {
		return approver;
	}

	public void setApprover(String approver) {
		this.approver = approver;
	}

	public BigInteger getFederationId() {
        return federationId;
    }

    public void setFederationId(final BigInteger federationId) {
        this.federationId = federationId;
    }

    public BigInteger getFederation_code() {
        return federation_code;
    }

    public void setFederation_code(final BigInteger federation_code) {
        this.federation_code = federation_code;
    }

    public BigInteger getTemp_code() {
        return temp_code;
    }

    public void setTemp_code(final BigInteger temp_code) {
        this.temp_code = temp_code;
    }

    public Integer getStateId() {
        return stateId;
    }

    public void setStateId(final Integer stateId) {
        this.stateId = stateId;
    }

    public Integer getDistrictId() {
        return districtId;
    }

    public void setDistrictId(final Integer districtId) {
        this.districtId = districtId;
    }

    public Integer getBlockId() {
        return blockId;
    }

    public void setBlockId(final Integer blockId) {
        this.blockId = blockId;
    }

    public Integer getPanchayatId() {
        return panchayatId;
    }

    public void setPanchayatId(final Integer panchayatId) {
        this.panchayatId = panchayatId;
    }

    public Integer getVillageId() {
        return villageId;
    }

    public void setVillageId(final Integer villageId) {
        this.villageId = villageId;
    }

    public String getFederationName() {
        return federationName;
    }

    public void setFederationName(final String federationName) {
        this.federationName = federationName;
    }

    public Short getFederationTypeCode() {
        return federationTypeCode;
    }

    public void setFederationTypeCode(final Short federationTypeCode) {
        this.federationTypeCode = federationTypeCode;
    }

    public String getFederationNameLocal() {
        return federationNameLocal;
    }

    public void setFederationNameLocal(final String federationNameLocal) {
        this.federationNameLocal = federationNameLocal;
    }

    public Date getFederationRevivalDate() {
        return federationRevivalDate;
    }

    public void setFederationRevivalDate(final Date federationRevivalDate) {
        this.federationRevivalDate = federationRevivalDate;
    }

    public Short getMeetingFrequency() {
        return meetingFrequency;
    }

    public void setMeetingFrequency(final Short meetingFrequency) {
        this.meetingFrequency = meetingFrequency;
    }

    public Short getMode() {
        return mode;
    }

    public void setMode(final Short mode) {
        this.mode = mode;
    }

    public Integer getMonthCompSaving() {
        return monthCompSaving;
    }

    public void setMonthCompSaving(final Integer monthCompSaving) {
        this.monthCompSaving = monthCompSaving;
    }

    public Boolean getBankAccount() {
        return isBankAccount;
    }

    public void setBankAccount(final Boolean bankAccount) {
        isBankAccount = bankAccount;
    }

    public Short getParentCboType() {
        return parentCboType;
    }

    public void setParentCboType(final Short parentCboType) {
        this.parentCboType = parentCboType;
    }

    public Boolean getActive() {
        return isActive;
    }

    public void setActive(final Boolean active) {
        isActive = active;
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

    public String getUserId() {
        return userId;
    }

    public void setUserId(final String userId) {
        this.userId = userId;
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

    public String getGuid() {
        return guid;
    }

    public void setGuid(String guid) {
        this.guid = guid;
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

    public Short getCboLevel() {
        return cboLevel;
    }

    public void setCboLevel(final Short cboLevel) {
        this.cboLevel = cboLevel;
    }

    public Short getChildLevel() {
        return childLevel;
    }

    public void setChildLevel(final Short childLevel) {
        this.childLevel = childLevel;
    }

    public Short getGeographicLevel() {
        return geographicLevel;
    }

    public void setGeographicLevel(final Short geographicLevel) {
        this.geographicLevel = geographicLevel;
    }

    public String getFederationNameShortEN() {
        return federationNameShortEN;
    }

    public void setFederationNameShortEN(final String federationNameShortEN) {
        this.federationNameShortEN = federationNameShortEN;
    }

    public String getFederationNameShortLocal() {
        return federationNameShortLocal;
    }

    public void setFederationNameShortLocal(final String federationNameShortLocal) {
        this.federationNameShortLocal = federationNameShortLocal;
    }

    public Date getFederationFormationDate() {
        return federationFormationDate;
    }

    public void setFederationFormationDate(final Date federationFormationDate) {
        this.federationFormationDate = federationFormationDate;
    }

    public Short getMeetingFrequencyValue() {
        return meetingFrequencyValue;
    }

    public void setMeetingFrequencyValue(final Short meetingFrequencyValue) {
        this.meetingFrequencyValue = meetingFrequencyValue;
    }

    public Short getMeetingOn() {
        return meetingOn;
    }

    public void setMeetingOn(final Short meetingOn) {
        this.meetingOn = meetingOn;
    }

    public BigInteger getParentCboId() {
        return parentCboId;
    }

    public void setParentCboId(final BigInteger parentCboId) {
        this.parentCboId = parentCboId;
    }

    public Short getStatus() {
        return status;
    }

    public void setStatus(final Short status) {
        this.status = status;
    }

    public Short getSettlementStatus() {
        return settlementStatus;
    }

    public void setSettlementStatus(final Short settlementStatus) {
        this.settlementStatus = settlementStatus;
    }

    public String getCheckerRemark() {
        return checkerRemark;
    }

    public void setCheckerRemark(final String checkerRemark) {
        this.checkerRemark = checkerRemark;
    }

    public Short getCboType() {
        return cboType;
    }

    public void setCboType(final Short cboType) {
        this.cboType = cboType;
    }

    public Integer getPromotedBy() {
        return promotedBy;
    }

    public void setPromotedBy(Integer promotedBy) {
        this.promotedBy = promotedBy;
    }

    public Short getSavingFrequency() {
        return savingFrequency;
    }

    public void setSavingFrequency(final Short savingFrequency) {
        this.savingFrequency = savingFrequency;
    }

    public Short getIsVoluntarySaving() {
        return isVoluntarySaving;
    }

    public void setIsVoluntarySaving(final Short isVoluntarySaving) {
        this.isVoluntarySaving = isVoluntarySaving;
    }

    public Double getSavingsInterest() {
        return savingsInterest;
    }

    public void setSavingsInterest(final Double savingsInterest) {
        this.savingsInterest = savingsInterest;
    }

    public Double getVoluntarySavingsInterest() {
        return voluntarySavingsInterest;
    }

    public void setVoluntarySavingsInterest(final Double voluntarySavingsInterest) {
        this.voluntarySavingsInterest = voluntarySavingsInterest;
    }

    public Integer getPrimaryActivity() {
        return primaryActivity;
    }

    public void setPrimaryActivity(final Integer primaryActivity) {
        this.primaryActivity = primaryActivity;
    }

    public Integer getSecondaryActivity() {
        return secondaryActivity;
    }

    public void setSecondaryActivity(final Integer secondaryActivity) {
        this.secondaryActivity = secondaryActivity;
    }

    public Integer getTertiaryActivity() {
        return tertiaryActivity;
    }

    public void setTertiaryActivity(final Integer tertiaryActivity) {
        this.tertiaryActivity = tertiaryActivity;
    }

    public String getBookkeeperName() {
        return bookkeeperName;
    }

    public void setBookkeeperName(final String bookkeeperName) {
        this.bookkeeperName = bookkeeperName;
    }

    public String getBookkeeperMobile() {
        return bookkeeperMobile;
    }

    public void setBookkeeperMobile(final String bookkeeperMobile) {
        this.bookkeeperMobile = bookkeeperMobile;
    }

    public Short getBookkeeperIdentified() {
        return bookkeeperIdentified;
    }

    public void setBookkeeperIdentified(Short bookkeeperIdentified) {
        this.bookkeeperIdentified = bookkeeperIdentified;
    }

    public Integer getElectionTenure() {
        return electionTenure;
    }

    public void setElectionTenure(final Integer electionTenure) {
        this.electionTenure = electionTenure;
    }

    public Date getCooptionDate() {
        return cooptionDate;
    }

    public void setCooptionDate(final Date cooptionDate) {
        this.cooptionDate = cooptionDate;
    }

    public String getFederationNameHindi() {
        return federationNameHindi;
    }

    public void setFederationNameHindi(final String federationNameHindi) {
        this.federationNameHindi = federationNameHindi;
    }

    public String getFederationNameShort() {
        return federationNameShort;
    }

    public void setFederationNameShort(final String federationNameShort) {
        this.federationNameShort = federationNameShort;
    }

    public Boolean getFinancialIntermediation() {
        return isFinancialIntermediation;
    }

    public void setFinancialIntermediation(final Boolean financialIntermediation) {
        isFinancialIntermediation = financialIntermediation;
    }

    public Boolean getVolutarySaving() {
        return isVolutarySaving;
    }

    public void setVolutarySaving(final Boolean volutarySaving) {
        isVolutarySaving = volutarySaving;
    }

    public Short getMeberCboCount() {
        return meberCboCount;
    }

    public void setMeberCboCount(final Short meberCboCount) {
        this.meberCboCount = meberCboCount;
    }

    public Short getApproveStatus() {
        return approveStatus;
    }

    public void setApproveStatus(final Short approveStatus) {
        this.approveStatus = approveStatus;
    }

    public Boolean getReadFlag() {
        return readFlag;
    }

    public void setReadFlag(final Boolean readFlag) {
        this.readFlag = readFlag;
    }

    public String getPromoterName() {
        return promoterName;
    }

    public void setPromoterName(final String promoterName) {
        this.promoterName = promoterName;
    }

    public BigInteger getFederationProfileDocId() {
        return federationProfileDocId;
    }

    public void setFederationProfileDocId(final BigInteger federationProfileDocId) {
        this.federationProfileDocId = federationProfileDocId;
    }

    public String getFederationResolution() {
        return federationResolution;
    }

    public void setFederationResolution(final String federationResolution) {
        this.federationResolution = federationResolution;
    }
	
	public String getPromoterCode() {
        return promoterCode;
    }

    public void setPromoterCode(String promoterCode) {
        this.promoterCode = promoterCode;
    }

	public Integer getIsComplete() {
		return isComplete;
	}

	public void setIsComplete(Integer isComplete) {
		this.isComplete = isComplete;
	}

	public Integer getInactiveReason() {
		return inactiveReason;
	}

	public void setInactiveReason(Integer inactiveReason) {
		this.inactiveReason = inactiveReason;
	}

    public Integer getMembershipFlag() {
        return membershipFlag;
    }

    public void setMembershipFlag(Integer membershipFlag) {
        this.membershipFlag = membershipFlag;
    }

    public Integer getRegistrationAct() {
        return registrationAct;
    }

    public void setRegistrationAct(Integer registrationAct) {
        this.registrationAct = registrationAct;
    }

    public Integer getIsRegistered() {
        return isRegistered;
    }

    public void setIsRegistered(Integer isRegistered) {
        this.isRegistered = isRegistered;
    }

    public Date getRegistrationDate() {
        return registrationDate;
    }

    public void setRegistrationDate(Date registrationDate) {
        this.registrationDate = registrationDate;
    }

    public String getRegistrationNo() {
        return registrationNo;
    }

    public void setRegistrationNo(String registrationNo) {
        this.registrationNo = registrationNo;
    }


    public String getRegistration_image() {
        return registration_image;
    }

    public void setRegistration_image(String registration_image) {
        this.registration_image = registration_image;
    }
}

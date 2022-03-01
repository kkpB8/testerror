package com.devglan.model;


import javax.persistence.*;
import java.math.BigInteger;
import java.sql.Timestamp;
import java.util.Date;
import java.util.Map;
import java.util.Objects;

@Entity
@Table(name = "shg_profile")
public class ShgProfileEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "shg_id", nullable = false)
    private BigInteger shgId;
    @Column(name = "state_id", nullable = false)
    private Integer stateId;
    @Column(name = "district_id", nullable = false)
    private Integer districtId;
    @Column(name = "block_id", nullable = false)
    private Integer blockId;
    @Column(name = "village_id", nullable = false)
    private Integer villageId;
    @Column(name = "panchayat_id", nullable = false)
    private Integer panchayatId;
    @Column(name = "hamlet_id")
    private String hamletId;
    @Column(name = "guid", nullable = false)
    private String guid;
    @Column(name = "shg_code")
    private String shgCode;
    @Column(name = "shg_name", nullable = false)
    private String shgName;
    @Column(name = "composition")
    private Short composition;
    @Column(name = "shg_type_code", nullable = false)
    private Short shgTypeCode;
    @Column(name = "shg_name_local")
    private String shgNameLocal;
    @Column(name = "shg_name_short_en")
    private String shgNameShortEN ;
    @Column(name = "shg_name_short_local ")
    private String shgNameShortLocal;
    @Column(name = "shg_formation_date", nullable = false)
    private Date shgFormationDate;
    @Column(name = "shg_revival_date")
    private Date shgRevivalDate;

    @Column(name = "shg_promoted_by", nullable = false)
    private Integer shgPromotedBy;
    @Column(name = " shg_revived_by")
    private Integer shgRevivedBy;
    @Column(name = "meeting_frequency", nullable = false)
    private Short meetingFrequency;
    @Column(name = "meeting_frequency_value")
    private Short meetingFrequencyValue;
    @Column(name = "meeting_on")
    private Short meetingOn;
    @Column(name = "mode", nullable = false)
    private Short mode;
    @Column(name = "month_comp_saving", nullable = false)
    private Integer monthCompSaving;
    @Column(name = "panelty_non_saving")
    private Double paneltyNonSaving ;
    @Column(name = "interloaning_rate", nullable = false)
    private Double interloaningRate ;
    @Column(name = "savings_interest", nullable = false)
    private Double savingsInterest  ;
    @Column(name = "voluntary_savings_interest", nullable = false)
    private Double voluntarySavingsInterest;
    @Column(name = "is_bankaccount")
    private Boolean isBankAccount;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "funding_agency_id")
    private FundingAgencyMasterEntity fundingAgencyMasterEntity;
    @Column(name = "parent_cbo_code")
    private BigInteger parentCboId;
    @Column(name = "parent_cbo_type")
    private Short parentCboType;
    @Column(name = "dedupl_status")
    private Short deduplicationStatus;
    @Column(name = "activation_status")
    private Short activationStatus;
    @Column(name = "mobile_default_user")
    private Integer mobileDefaultUser;
    @Column(name = "web_default_checker")
    private Integer webDefaultChecker;
    @Column(name = "account_books_maintained")
    private Boolean accountBooksMaintained;
    @Column(name = "cash_book_start_date")
    private Boolean cashBookStartDate;
    @Column(name = "bank_book_start_date")
    private Boolean bankBookStartDate;
    @Column(name = "members_ledger_start_date")
    private Boolean membersLedgerStartDate;
    @Column(name = "book4")
    private Boolean book4;
    @Column(name = "book5")
    private Boolean book5;
    @Column(name = "grade")
    private String grade;
    @Column(name = "grading_done_on")
    private Timestamp gradingDoneOn;
    @Column(name = "grade_confirmation_status")
    private String gradeConfirmationStatus;
    @Column(name = "latitude")
    private Double latitude  ;
    @Column(name = "longitude")
    private Double longitude  ;
    @Column(name = "bookkeeper_identified")
    private Short bookkeeperIdentified;
    @Column(name = "micro_plan_prepared")
    private Boolean microPlanPrepared;
    @Column(name = "user_id")
    private String userId;
    @Column(name = "read_flag")
    private Boolean readFlag;
    @Column(name = "basic_shg_training")
    private Boolean basicShgTraining;
    @Column(name = "primary_activity")
    private Integer primaryActivity;
    @Column(name = "secondary_activity")
    private Integer secondaryActivity;
    @Column(name = "tertiary_activity")
    private Integer tertiaryActivity;
    @Column(name = "promoter_name")
    private String promoterName;
    @Column(name = "saving_frequency")
    private Short savingFrequency;
    @Column(name = "volutary_saving")
    private Double volutarySaving;
    @Column(name = "cbo_level")
    private Short cboLevel;
    @Column(name = "geographic_level")
    private Short geographicLevel;
    @Column(name = "settlement_status")
    private Short settlementStatus;
    @Column(name = "bookkeeper_name")
    private String bookkeeperName;
    @Column(name = "bookkeeper_mobile")
    private String bookkeeperMobile;
    @Column(name = "election_tenure")
    private Integer electionTenure;
    @Column(name = "is_voluntary_saving")
    private Short isVoluntarySaving;
    @Column(name = "status")
    private Short status;
    @Column(name = "checker_remark")
    private String checkerRemark;
    @Column(name = "is_active", nullable = false)
    private Boolean isActive;
    @Column(name = "entry_source", nullable = false)
    private Short entrySource;
    @Column(name = "is_edited")
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

    @Column(name = "shg_cooption_date")
    private Date shgCooptionDate;
    @Column(name = "tags")
    private Short tags;
    @Column(name = "approve_status")
    private Short approveStatus;
    @Column(name = "profile_document_id")
    private BigInteger profileDocumentId;
    @Column(name = "shg_resolution")
    private String shgResolution;
    //@satwant06052021
    @Column(name = "is_verified")
    private Integer isVerified;

    @Column(name = "is_complete")
    private Integer isComplete;


//30-3-2021 mohit

    @Column(name = "shg_type_other")
    private  String shgTypeOther;
    @Column(name = "promoter_code")
    private  String promoterCode;

    //@Anshul160921
    @Column(name = "is_locked")
    private short is_locked;
    //@Anshul210921
    @Column(name = "approver")
    private String approver;
    
    //Anshul250921
    @Column(name = "inactive_reason")
    private Integer inactiveReason;
    
   

	public static Integer stateType = 1;
    public static Integer districtType = 2;
    public static Integer blockType = 3;
    public static Integer panchayateType = 4;
    public static Integer villageType = 5;



   /* public SHGProfileEntity() {}
    public static void setDefaultValuesWhilefetching(SHGProfileEntity sHGProfileEntity){
            try{
                for (java.lang.reflect.Field f : sHGProfileEntity.getClass().getDeclaredFields()) {
                    if(f.getType()==String.class){
                        Object val =  f.get(sHGProfileEntity);
                        if(val==null){
                            f.set(sHGProfileEntity,"");
                        }
                    }
                    else if(f.getType()==Integer.class || f.getType()==BigInteger.class ||
                            f.getType()==Short.class){
                        Object val =  f.get(sHGProfileEntity);
                        if(val==null){
                            f.set(sHGProfileEntity,-1);
                        }
                    }
                }
            }catch(Exception e){
                e.printStackTrace();
            }

    }*/

    public BigInteger getShgId() {
        return shgId;
    }

    public void setShgId(final BigInteger shgId) {
        this.shgId = shgId;
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

    public void setBlockId(Integer blockId) {
        this.blockId = blockId;
    }

    public Integer getVillageId() {
        return villageId;
    }

    public void setVillageId(final Integer villageId) {
        this.villageId = villageId;
    }

    public Integer getPanchayatId() {
        return panchayatId;
    }

    public void setPanchayatId(final Integer panchayatId) {
        this.panchayatId = panchayatId;
    }

    public String getHamletId() {
        return hamletId;
    }

    public void setHamletId(final String hamletId) {
        this.hamletId = hamletId;
    }

    public String getGuid() {
        return guid;
    }

    public void setGuid(final String guid) {
        this.guid = guid;
    }

    public String getShgCode() {
        return shgCode;
    }

    public void setShgCode(final String shgCode) {
        this.shgCode = shgCode;
    }

    public String getShgName() {
        return shgName;
    }

    public void setShgName(final String shgName) {
        this.shgName = shgName;
    }

    public Short getComposition() {
        return composition;
    }

    public void setComposition(final Short composition) {
        this.composition = composition;
    }

    public Short getShgTypeCode() {
        return shgTypeCode;
    }

    public void setShgTypeCode(final Short shgTypeCode) {
        this.shgTypeCode = shgTypeCode;
    }

    public String getShgNameLocal() {
        return shgNameLocal;
    }

    public void setShgNameLocal(final String shgNameLocal) {
        this.shgNameLocal = shgNameLocal;
    }

    public String getShgNameShortEN() {
        return shgNameShortEN;
    }

    public void setShgNameShortEN(final String shgNameShortEN) {
        this.shgNameShortEN = shgNameShortEN;
    }

    public String getShgNameShortLocal() {
        return shgNameShortLocal;
    }

    public void setShgNameShortLocal(final String shgNameShortLocal) {
        this.shgNameShortLocal = shgNameShortLocal;
    }

    public Date getShgFormationDate() {
        return shgFormationDate;
    }

    public void setShgFormationDate(Date shgFormationDate) {
        this.shgFormationDate = shgFormationDate;
    }

    public Date getShgRevivalDate() {
        return shgRevivalDate;
    }

    public void setShgRevivalDate(Date shgRevivalDate) {
        this.shgRevivalDate = shgRevivalDate;
    }

    public Integer getShgPromotedBy() {
        return shgPromotedBy;
    }

    public void setShgPromotedBy(final Integer shgPromotedBy) {
        this.shgPromotedBy = shgPromotedBy;
    }

    public Integer getShgRevivedBy() {
        return shgRevivedBy;
    }

    public void setShgRevivedBy(final Integer shgRevivedBy) {
        this.shgRevivedBy = shgRevivedBy;
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

    public Double getPaneltyNonSaving() {
        return paneltyNonSaving;
    }

    public void setPaneltyNonSaving(final Double paneltyNonSaving) {
        this.paneltyNonSaving = paneltyNonSaving;
    }

    public Double getInterloaningRate() {
        return interloaningRate;
    }

    public void setInterloaningRate(final Double interloaningRate) {
        this.interloaningRate = interloaningRate;
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

    public Boolean getBankAccount() {
        return isBankAccount;
    }

    public void setBankAccount(final Boolean bankAccount) {
        isBankAccount = bankAccount;
    }

    public FundingAgencyMasterEntity getFundingAgencyMasterEntity() {
        return fundingAgencyMasterEntity;
    }

    public void setFundingAgencyMasterEntity(final FundingAgencyMasterEntity fundingAgencyMasterEntity) {
        this.fundingAgencyMasterEntity = fundingAgencyMasterEntity;
    }

    public BigInteger getParentCboId() {
        return parentCboId;
    }

    public void setParentCboId(BigInteger parentCboId) {
        this.parentCboId = parentCboId;
    }

    public Short getParentCboType() {
        return parentCboType;
    }

    public void setParentCboType(final Short parentCboType) {
        this.parentCboType = parentCboType;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(final String userId) {
        this.userId = userId;
    }

    public Boolean getBasicShgTraining() {
        return basicShgTraining;
    }

    public void setBasicShgTraining(final Boolean basicShgTraining) {
        this.basicShgTraining = basicShgTraining;
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

    public Short getEntrySource() {
        return entrySource;
    }

    public void setEntrySource(final Short entrySource) {
        this.entrySource = entrySource;
    }

    public Integer getMobileDefaultUser() {
        return mobileDefaultUser;
    }

    public void setMobileDefaultUser(final Integer mobileDefaultUser) {
        this.mobileDefaultUser = mobileDefaultUser;
    }

    public Integer getWebDefaultChecker() {
        return webDefaultChecker;
    }

    public void setWebDefaultChecker(final Integer webDefaultChecker) {
        this.webDefaultChecker = webDefaultChecker;
    }

    public Integer getIsEdited() {
        return isEdited;
    }

    public void setIsEdited(final Integer isEdited) {
        this.isEdited = isEdited;
    }

    public Boolean getAccountBooksMaintained() {
        return accountBooksMaintained;
    }

    public void setAccountBooksMaintained(final Boolean accountBooksMaintained) {
        this.accountBooksMaintained = accountBooksMaintained;
    }

    public Boolean getCashBookStartDate() {
        return cashBookStartDate;
    }

    public void setCashBookStartDate(final Boolean cashBookStartDate) {
        this.cashBookStartDate = cashBookStartDate;
    }

    public Boolean getBankBookStartDate() {
        return bankBookStartDate;
    }

    public void setBankBookStartDate(final Boolean bankBookStartDate) {
        this.bankBookStartDate = bankBookStartDate;
    }

    public Boolean getMembersLedgerStartDate() {
        return membersLedgerStartDate;
    }

    public void setMembersLedgerStartDate(final Boolean membersLedgerStartDate) {
        this.membersLedgerStartDate = membersLedgerStartDate;
    }

    public Boolean getBook4() {
        return book4;
    }

    public void setBook4(final Boolean book4) {
        this.book4 = book4;
    }

    public Boolean getBook5() {
        return book5;
    }

    public void setBook5(final Boolean book5) {
        this.book5 = book5;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(final String grade) {
        this.grade = grade;
    }

    public Timestamp getGradingDoneOn() {
        return gradingDoneOn;
    }

    public void setGradingDoneOn(final Timestamp gradingDoneOn) {
        this.gradingDoneOn = gradingDoneOn;
    }

    public String getGradeConfirmationStatus() {
        return gradeConfirmationStatus;
    }

    public void setGradeConfirmationStatus(final String gradeConfirmationStatus) {
        this.gradeConfirmationStatus = gradeConfirmationStatus;
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

    public Double getLatitude() {
        return latitude;
    }

    public void setLatitude(final Double latitude) {
        this.latitude = latitude;
    }

    public Double getLongitude() {
        return longitude;
    }

    public void setLongitude(final Double longitude) {
        this.longitude = longitude;
    }

    public Short getBookkeeperIdentified() {
        return bookkeeperIdentified;
    }

    public void setBookkeeperIdentified(final Short bookkeeperIdentified) {
        this.bookkeeperIdentified = bookkeeperIdentified;
    }

    public Boolean getMicroPlanPrepared() {
        return microPlanPrepared;
    }

    public void setMicroPlanPrepared(final Boolean microPlanPrepared) {
        this.microPlanPrepared = microPlanPrepared;
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

    public Short getSavingFrequency() {
        return savingFrequency;
    }

    public void setSavingFrequency(final Short savingFrequency) {
        this.savingFrequency = savingFrequency;
    }

    public Double getVolutarySaving() {
        return volutarySaving;
    }

    public void setVolutarySaving(final Double volutarySaving) {
        this.volutarySaving = volutarySaving;
    }

    public Short getCboLevel() {
        return cboLevel;
    }

    public void setCboLevel(final Short cboLevel) {
        this.cboLevel = cboLevel;
    }

    public Short getGeographicLevel() {
        return geographicLevel;
    }

    public void setGeographicLevel(final Short geographicLevel) {
        this.geographicLevel = geographicLevel;
    }

    public Short getSettlementStatus() {
        return settlementStatus;
    }

    public void setSettlementStatus(final Short settlementStatus) {
        this.settlementStatus = settlementStatus;
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

    public Integer getElectionTenure() {
        return electionTenure;
    }

    public void setElectionTenure(final Integer electionTenure) {
        this.electionTenure = electionTenure;
    }

    public Short getStatus() {
        return status;
    }

    public void setStatus(final Short status) {
        this.status = status;
    }

    public Short getIsVoluntarySaving() {
        return isVoluntarySaving;
    }

    public void setIsVoluntarySaving(final Short isVoluntarySaving) {
        this.isVoluntarySaving = isVoluntarySaving;
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

    public String getCheckerRemark() {
        return checkerRemark;
    }

    public void setCheckerRemark(final String checkerRemark) {
        this.checkerRemark = checkerRemark;
    }

    public Date getShgCooptionDate() {
        return shgCooptionDate;
    }

    public void setShgCooptionDate(final Date shgCooptionDate) {
        this.shgCooptionDate = shgCooptionDate;
    }

    public Short getTags() {
        return tags;
    }

    public void setTags(final Short tags) {
        this.tags = tags;
    }

    public Short getApproveStatus() {
        return approveStatus;
    }

    public void setApproveStatus(final Short approveStatus) {
        this.approveStatus = approveStatus;
    }

    public BigInteger getProfileDocumentId() {
        return profileDocumentId;
    }

    public void setProfileDocumentId(final BigInteger profileDocumentId) {
        this.profileDocumentId = profileDocumentId;
    }

    public String getShgResolution() {
        return shgResolution;
    }

    public void setShgResolution(final String shgResolution) {
        this.shgResolution = shgResolution;
    }
	
	    public String getShgTypeOther() {
        return shgTypeOther;
    }

    public void setShgTypeOther(String shgTypeOther) {
        this.shgTypeOther = shgTypeOther;
    }

    public String getPromoterCode() {
        return promoterCode;
    }

    public void setPromoterCode(String promoterCode) {
        this.promoterCode = promoterCode;
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

    public short getIs_locked() {
        return is_locked;
    }

    public void setIs_locked(short is_locked) {
        this.is_locked = is_locked;
    }

	public String getApprover() {
		return approver;
	}

	public void setApprover(String approver) {
		this.approver = approver;
	}
    
	 public Integer getInactiveReason() {
			return inactiveReason;
		}

		public void setInactiveReason(Integer inactiveReason) {
			this.inactiveReason = inactiveReason;
		}
}

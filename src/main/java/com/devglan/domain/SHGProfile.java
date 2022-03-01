package com.devglan.domain;

import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.Column;
import javax.validation.constraints.NotNull;
import java.math.BigInteger;
import java.util.List;

public class SHGProfile {

    private BigInteger shg_id;
    @NotNull(message = "State Must be given")
    private Integer state_id;
    @NotNull(message = "District must be given")
    private Integer district_id;
    @NotNull(message = "Block must be given")
    private Integer block_id;
    @NotNull(message = "Panchayat must be given")
    private Integer panchayat_id;
    @NotNull(message = "Village must be given")
    private Integer village_id;
    //@Size(max=30,message="hamlet id can be 30 char long")
    private String hamlet_id;
    // @NotBlank(message = "GUID must be specified")
    //@Size(max=50,message="guid can be max of 50 char long")
    private String guid;

    private String shg_code;
    @NotBlank(message = "Shg Name must be given")
    //@Size(max=60,message="Shg  Name can be max of 60 char long")
    private String shg_name;
    @NotNull(message = "Please Select the Composition")
    private Short composition;
    private Short shg_type_code;
    //@Size(max=2,message="language id can be of 2 char")
    private String language_id;
    //@Size(max=120,message="Shg Name in Local language can be 120 chars")
    private String shg_name_local;
    //@Size(max=20,message="Shg Short Name can be 20 chars")
    private String shg_name_short_en;
    //@Size(max=40,message="Shg Short Name  in Local language can be 40 chars")
    private String shg_name_short_local;
    @NotNull(message = "Formation Date must be given")
    private Integer shg_formation_date;
    private Integer shg_revival_date;
    @NotNull(message = "Select Promoted by value")
    private Integer shg_promoted_by;
    private Integer shg_revived_by;
    @NotNull(message = "please select meeting frequency")
    private Short meeting_frequency;
    private Short meeting_frequency_value;
    private Short meeting_on;
    @NotNull(message = "Select mode")
    private Short mode;
    @NotNull(message = "Monthly Compulsory Savings must be given")
    private Integer month_comp_saving;
    private Double panelty_non_saving;
    @NotNull(message = "Interloaning Rate must be given")
    private Double interloaning_rate;
    @NotNull(message = "Savings Interest must be given")
    private Double savings_interest;
    @NotNull(message = "Voluntary Savings Interest must be given")
    private Double voluntary_savings_interest;
    private Short is_bankaccount;
    private Integer funding_agency_id;
    private BigInteger parent_cbo_code;
    private Short parent_cbo_type;
    private Short is_active;
    private Short dedupl_status;
    private Short activation_status;
    @NotNull(message = "Set Entry Source ")
    private Short entry_source;
    private Integer mobile_default_user;
    private Integer web_default_checker;
    @NotNull(message = "Set Is Edited")
    private Integer is_edited;
    private Short account_books_maintained;
    private Short cash_book_start_date;
    private Short bank_book_start_date;
    private Short members_ledger_start_date;
    private Short book4;
    private Short book5;
    //@Size(max=1,message="Grade can be of 1 digit")
    private String grade;
    private Integer grading_done_on;
    //@Size(max=1,message="Grade Confirmation Status can be of 1 char")
    private String grade_confirmation_status;
    private Integer last_uploaded_date;
    private String uploaded_by;
    @NotNull(message = "Created Date Must be Given")
    private Integer created_date;
    @NotBlank(message = "Created By Must be Given")
    private String created_by;
    private Integer updated_date;
    private String updated_by;
    private  Double latitude;
    private Double longitude;
    private Short bookkeeper_identified;
    private Short micro_plan_prepared;
    private String user_id;
    private Integer basic_shg_training;
    private Integer primary_activity;
    private Integer secondary_activity;
    private Integer tertiary_activity;
    private String promoter_name;
    private Short saving_frequency;
    private Double volutary_saving;
    private Short cbo_level;
    private Short geographic_level;
    private Short settlement_status;
    private String bookkeeper_name;
    //@Size(max=10,message="Bookkeeper Mobile No can be of 10 digits")
    private String bookkeeper_mobile;
    private Integer election_tenure;
    private Short is_voluntary_saving;
    //@LookupConstraint(key1 = 5)
    private Short status;
    private String checker_remark;
    //@NotEmpty(message = "Address should be specified")
    //private @Valid
    List<CBOAddresses> cboAddressesList;
    //@NotEmpty(message = "Phone Details should be specified")
    //private @Valid
    List<CBOPhoneNoDetails> cboPhoneNoDetailsList;
    //@NotEmpty(message = "Bank Details should be specified")
    //private @Valid
    List<CBOBankDetails> cboBankDetailsList;
    // @NotEmpty(message = "KYC Details should be specified")
    private CboKYCDetails cboKYCDetails;
    //private @Valid
    List<MemberProfile> memberProfileList;

    //private @Valid
    List<SystemTags> cboSystemTagsList;

    //private @Valid
    List<SHGDesignation> shgDesignationList;


    private Integer shg_cooption_date;
    private Short tags;

    //FEDERATION
    private BigInteger federation_code;
    private String federation_name;
    private String federation_name_local;
    private Short child_level;

    private Long member_count;
    private Long dedup_member_count;
    private Long active_member_count;
    private  String transaction_id;

    private Short approve_status;

    public static String exceptionString;

    private String view_status;

    private Integer mapped_date;
    private Integer unmapped_date;
    private Integer federation_joining_date;
    private String shg_resolution;
    private String shg_resolution_document;

    //30-3-2021 (mohit)

    private  String shg_type_other;
    private  String promoter_code;
    //@Satwant 06052021
    private Integer is_verified;
    private Integer is_complete;
    
    private BigInteger processingId;

    //@Anshul 16092021
    private Short is_locked;
    
    private String approver; 
    
    private Integer inactive_reason ;

    public SHGProfile() {
    }

    public Integer getIs_verified() {
        return is_verified;
    }

    public void setIs_verified(Integer is_verified) {
        this.is_verified = is_verified;
    }

    public Integer getIs_complete() {
        return is_complete;
    }

    public void setIs_complete(Integer is_complete) {
        this.is_complete = is_complete;
    }



    public String getView_status() {
        return view_status;
    }

    public void setView_status(String view_status) {
        this.view_status = view_status;
    }

    public BigInteger getShg_id() {
        return shg_id;
    }

    public void setShg_id(BigInteger shg_id) {
        this.shg_id = shg_id;
    }

    public Integer getState_id() {
        return state_id;
    }

    public void setState_id(Integer state_id) {
        this.state_id = state_id;
    }

    public Integer getDistrict_id() {
        return district_id;
    }

    public void setDistrict_id(Integer district_id) {
        this.district_id = district_id;
    }

    public Integer getBlock_id() {
        return block_id;
    }

    public void setBlock_id(Integer block_id) {
        this.block_id = block_id;
    }

    public Integer getPanchayat_id() {
        return panchayat_id;
    }

    public void setPanchayat_id(Integer panchayat_id) {
        this.panchayat_id = panchayat_id;
    }

    public Integer getVillage_id() {
        return village_id;
    }

    public void setVillage_id(Integer village_id) {
        this.village_id = village_id;
    }

    public String getHamlet_id() {
        return hamlet_id;
    }

    public void setHamlet_id(String hamlet_id) {
        this.hamlet_id = hamlet_id;
    }

    public String getGuid() {
        return guid;
    }

    public void setGuid(String guid) {
        this.guid = guid;
    }

    public String getShg_code() {
        return shg_code;
    }

    public void setShg_code(String shg_code) {
        this.shg_code = shg_code;
    }

    public String getShg_name() {
        return shg_name;
    }

    public void setShg_name(String shg_name) {
        this.shg_name = shg_name;
    }

    public Short getComposition() {
        return composition;
    }

    public void setComposition(Short composition) {
        this.composition = composition;
    }

    public Short getShg_type_code() {
        return shg_type_code;
    }

    public void setShg_type_code(Short shg_type_code) {
        this.shg_type_code = shg_type_code;
    }

    public String getLanguage_id() {
        return language_id;
    }

    public void setLanguage_id(String language_id) {
        this.language_id = language_id;
    }

    public String getShg_name_local() {
        return shg_name_local;
    }

    public void setShg_name_local(String shg_name_local) {
        this.shg_name_local = shg_name_local;
    }

    public String getShg_name_short_en() {
        return shg_name_short_en;
    }

    public void setShg_name_short_en(String shg_name_short_en) {
        this.shg_name_short_en = shg_name_short_en;
    }

    public String getShg_name_short_local() {
        return shg_name_short_local;
    }

    public void setShg_name_short_local(String shg_name_short_local) {
        this.shg_name_short_local = shg_name_short_local;
    }


    public Integer getShg_promoted_by() {
        return shg_promoted_by;
    }

    public void setShg_promoted_by(Integer shg_promoted_by) {
        this.shg_promoted_by = shg_promoted_by;
    }

    public Integer getShg_revived_by() {
        return shg_revived_by;
    }

    public void setShg_revived_by(Integer shg_revived_by) {
        this.shg_revived_by = shg_revived_by;
    }

    public Short getMode() {
        return mode;
    }

    public void setMode(Short mode) {
        this.mode = mode;
    }

    public Double getPanelty_non_saving() {
        return panelty_non_saving;
    }

    public void setPanelty_non_saving(Double panelty_non_saving) {
        this.panelty_non_saving = panelty_non_saving;
    }

    public Double getInterloaning_rate() {
        return interloaning_rate;
    }

    public void setInterloaning_rate(Double interloaning_rate) {
        this.interloaning_rate = interloaning_rate;
    }

    public Double getSavings_interest() {
        return savings_interest;
    }

    public void setSavings_interest(Double savings_interest) {
        this.savings_interest = savings_interest;
    }

    public Double getVoluntary_savings_interest() {
        return voluntary_savings_interest;
    }

    public void setVoluntary_savings_interest(Double voluntary_savings_interest) {
        this.voluntary_savings_interest = voluntary_savings_interest;
    }

    public Integer getFunding_agency_id() {
        return funding_agency_id;
    }

    public void setFunding_agency_id(Integer funding_agency_id) {
        this.funding_agency_id = funding_agency_id;
    }

    public Short getIs_bankaccount() {
        return is_bankaccount;
    }

    public void setIs_bankaccount(Short is_bankaccount) {
        this.is_bankaccount = is_bankaccount;
    }

    public Short getIs_active() {
        return is_active;
    }

    public void setIs_active(Short is_active) {
        this.is_active = is_active;
    }

    public Short getDedupl_status() {
        return dedupl_status;
    }

    public void setDedupl_status(Short dedupl_status) {
        this.dedupl_status = dedupl_status;
    }

    public Short getActivation_status() {
        return activation_status;
    }

    public void setActivation_status(Short activation_status) {
        this.activation_status = activation_status;
    }

    public Short getEntry_source() {
        return entry_source;
    }

    public void setEntry_source(Short entry_source) {
        this.entry_source = entry_source;
    }

    public Integer getMobile_default_user() {
        return mobile_default_user;
    }

    public void setMobile_default_user(Integer mobile_default_user) {
        this.mobile_default_user = mobile_default_user;
    }

    public Integer getWeb_default_checker() {
        return web_default_checker;
    }

    public void setWeb_default_checker(Integer web_default_checker) {
        this.web_default_checker = web_default_checker;
    }

    public Integer getIs_edited() {
        return is_edited;
    }

    public void setIs_edited(Integer is_edited) {
        this.is_edited = is_edited;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    public Integer getShg_formation_date() {
        return shg_formation_date;
    }

    public void setShg_formation_date(Integer shg_formation_date) {
        this.shg_formation_date = shg_formation_date;
    }

    public Integer getShg_revival_date() {
        return shg_revival_date;
    }

    public void setShg_revival_date(Integer shg_revival_date) {
        this.shg_revival_date = shg_revival_date;
    }

    public Integer getGrading_done_on() {
        return grading_done_on;
    }

    public void setGrading_done_on(Integer grading_done_on) {
        this.grading_done_on = grading_done_on;
    }

    public String getGrade_confirmation_status() {
        return grade_confirmation_status;
    }

    public void setGrade_confirmation_status(String grade_confirmation_status) {
        this.grade_confirmation_status = grade_confirmation_status;
    }

    public Integer getLast_uploaded_date() {
        return last_uploaded_date;
    }

    public void setLast_uploaded_date(Integer last_uploaded_date) {
        this.last_uploaded_date = last_uploaded_date;
    }

    public Integer getCreated_date() {
        return created_date;
    }

    public void setCreated_date(Integer created_date) {
        this.created_date = created_date;
    }

    public Integer getUpdated_date() {
        return updated_date;
    }

    public void setUpdated_date(Integer updated_date) {
        this.updated_date = updated_date;
    }

    public Double getLatitude() {
        return latitude;
    }

    public void setLatitude(Double latitude) {
        this.latitude = latitude;
    }

    public Double getLongitude() {
        return longitude;
    }

    public void setLongitude(Double longitude) {
        this.longitude = longitude;
    }

    public Short getAccount_books_maintained() {
        return account_books_maintained;
    }

    public void setAccount_books_maintained(Short account_books_maintained) {
        this.account_books_maintained = account_books_maintained;
    }

    public Short getCash_book_start_date() {
        return cash_book_start_date;
    }

    public void setCash_book_start_date(Short cash_book_start_date) {
        this.cash_book_start_date = cash_book_start_date;
    }

    public Short getBank_book_start_date() {
        return bank_book_start_date;
    }

    public void setBank_book_start_date(Short bank_book_start_date) {
        this.bank_book_start_date = bank_book_start_date;
    }

    public Short getMembers_ledger_start_date() {
        return members_ledger_start_date;
    }

    public void setMembers_ledger_start_date(Short members_ledger_start_date) {
        this.members_ledger_start_date = members_ledger_start_date;
    }

    public Short getBook4() {
        return book4;
    }

    public void setBook4(Short book4) {
        this.book4 = book4;
    }

    public Short getBook5() {
        return book5;
    }

    public void setBook5(Short book5) {
        this.book5 = book5;
    }

    public Short getBookkeeper_identified() {
        return bookkeeper_identified;
    }

    public void setBookkeeper_identified(Short bookkeeper_identified) {
        this.bookkeeper_identified = bookkeeper_identified;
    }

    public Short getMicro_plan_prepared() {
        return micro_plan_prepared;
    }

    public void setMicro_plan_prepared(Short micro_plan_prepared) {
        this.micro_plan_prepared = micro_plan_prepared;
    }

    public List<CBOAddresses> getCboAddressesList() {
        return cboAddressesList;
    }

    public void setCboAddressesList(List<CBOAddresses> cboAddressesList) {
        this.cboAddressesList = cboAddressesList;
    }

    public List<CBOPhoneNoDetails> getCboPhoneNoDetailsList() {
        return cboPhoneNoDetailsList;
    }

    public void setCboPhoneNoDetailsList(List<CBOPhoneNoDetails> cboPhoneNoDetailsList) {
        this.cboPhoneNoDetailsList = cboPhoneNoDetailsList;
    }

    public List<CBOBankDetails> getCboBankDetailsList() {
        return cboBankDetailsList;
    }

    public void setCboBankDetailsList(List<CBOBankDetails> cboBankDetailsList) {
        this.cboBankDetailsList = cboBankDetailsList;
    }

    public CboKYCDetails getCboKYCDetails() {
        return cboKYCDetails;
    }

    public void setCboKYCDetails(CboKYCDetails cboKYCDetails) {
        this.cboKYCDetails = cboKYCDetails;
    }

    public String getUploaded_by() {
        return uploaded_by;
    }

    public void setUploaded_by(String uploaded_by) {
        this.uploaded_by = uploaded_by;
    }

    public String getCreated_by() {
        return created_by;
    }

    public void setCreated_by(String created_by) {
        this.created_by = created_by;
    }

    public String getUpdated_by() {
        return updated_by;
    }

    public void setUpdated_by(String updated_by) {
        this.updated_by = updated_by;
    }

    public String getUser_id() {
        return user_id;
    }

    public void setUser_id(String user_id) {
        this.user_id = user_id;
    }

    public Integer getBasic_shg_training() {
        return basic_shg_training;
    }

    public void setBasic_shg_training(Integer basic_shg_training) {
        this.basic_shg_training = basic_shg_training;
    }

    public Integer getPrimary_activity() {
        return primary_activity;
    }

    public void setPrimary_activity(Integer primary_activity) {
        this.primary_activity = primary_activity;
    }

    public Integer getSecondary_activity() {
        return secondary_activity;
    }

    public void setSecondary_activity(Integer secondary_activity) {
        this.secondary_activity = secondary_activity;
    }

    public Integer getTertiary_activity() {
        return tertiary_activity;
    }

    public void setTertiary_activity(Integer tertiary_activity) {
        this.tertiary_activity = tertiary_activity;
    }

    public Short getMeeting_frequency() {
        return meeting_frequency;
    }

    public void setMeeting_frequency(Short meeting_frequency) {
        this.meeting_frequency = meeting_frequency;
    }

    public Short getMeeting_frequency_value() {
        return meeting_frequency_value;
    }

    public void setMeeting_frequency_value(Short meeting_frequency_value) {
        this.meeting_frequency_value = meeting_frequency_value;
    }

    public Short getMeeting_on() {
        return meeting_on;
    }

    public void setMeeting_on(Short meeting_on) {
        this.meeting_on = meeting_on;
    }

    public Integer getMonth_comp_saving() {
        return month_comp_saving;
    }

    public void setMonth_comp_saving(Integer month_comp_saving) {
        this.month_comp_saving = month_comp_saving;
    }

    public BigInteger getParent_cbo_code() {
        return parent_cbo_code;
    }

    public void setParent_cbo_code(BigInteger parent_cbo_code) {
        this.parent_cbo_code = parent_cbo_code;
    }

    public Short getParent_cbo_type() {
        return parent_cbo_type;
    }

    public void setParent_cbo_type(Short parent_cbo_type) {
        this.parent_cbo_type = parent_cbo_type;
    }

    public List<MemberProfile> getMemberProfileList() {
        return memberProfileList;
    }

    public void setMemberProfileList(List<MemberProfile> memberProfileList) {
        this.memberProfileList = memberProfileList;
    }

    public String getPromoter_name() {
        return promoter_name;
    }

    public void setPromoter_name(String promoter_name) {
        this.promoter_name = promoter_name;
    }

    public Short getSaving_frequency() {
        return saving_frequency;
    }

    public void setSaving_frequency(Short saving_frequency) {
        this.saving_frequency = saving_frequency;
    }

    public Double getVolutary_saving() {
        return volutary_saving;
    }

    public void setVolutary_saving(Double volutary_saving) {
        this.volutary_saving = volutary_saving;
    }

    public Short getCbo_level() {
        return cbo_level;
    }

    public void setCbo_level(Short cbo_level) {
        this.cbo_level = cbo_level;
    }

    public Short getGeographic_level() {
        return geographic_level;
    }

    public void setGeographic_level(Short geographic_level) {
        this.geographic_level = geographic_level;
    }

    public Short getSettlement_status() {
        return settlement_status;
    }

    public void setSettlement_status(Short settlement_status) {
        this.settlement_status = settlement_status;
    }

    public String getBookkeeper_name() {
        return bookkeeper_name;
    }

    public void setBookkeeper_name(String bookkeeper_name) {
        this.bookkeeper_name = bookkeeper_name;
    }

    public String getBookkeeper_mobile() {
        return bookkeeper_mobile;
    }

    public void setBookkeeper_mobile(String bookkeeper_mobile) {
        this.bookkeeper_mobile = bookkeeper_mobile;
    }

    public Integer getElection_tenure() {
        return election_tenure;
    }

    public void setElection_tenure(Integer election_tenure) {
        this.election_tenure = election_tenure;
    }

    public Short getStatus() {
        return status;
    }

    public void setStatus(Short status) {
        this.status = status;
    }

    public BigInteger getFederation_code() {
        return federation_code;
    }

    public void setFederation_code(BigInteger federation_code) {
        this.federation_code = federation_code;
    }

    public String getFederation_name() {
        return federation_name;
    }

    public void setFederation_name(String federation_name) {
        this.federation_name = federation_name;
    }

    public String getFederation_name_local() {
        return federation_name_local;
    }

    public void setFederation_name_local(String federation_name_local) {
        this.federation_name_local = federation_name_local;
    }

    public Short getChild_level() {
        return child_level;
    }

    public void setChild_level(Short child_level) {
        this.child_level = child_level;
    }

    public Short getIs_voluntary_saving() {
        return is_voluntary_saving;
    }

    public void setIs_voluntary_saving(final Short is_voluntary_saving) {
        this.is_voluntary_saving = is_voluntary_saving;
    }

    public String getChecker_remark() {
        return checker_remark;
    }

    public void setChecker_remark(String checker_remark) {
        this.checker_remark = checker_remark;
    }

    public Long getMember_count() {
        return member_count;
    }

    public void setMember_count(Long member_count) {
        this.member_count = member_count;
    }

    public Long getDedup_member_count() {
        return dedup_member_count;
    }

    public void setDedup_member_count(Long dedup_member_count) {
        this.dedup_member_count = dedup_member_count;
    }

    public List<SystemTags> getCboSystemTagsList() {
        return cboSystemTagsList;
    }

    public void setCboSystemTagsList(List<SystemTags> cboSystemTagsList) {
        this.cboSystemTagsList = cboSystemTagsList;
    }

    public Integer getShg_cooption_date() {
        return shg_cooption_date;
    }

    public void setShg_cooption_date(Integer shg_cooption_date) {
        this.shg_cooption_date = shg_cooption_date;
    }

    public Short getTags() {
        return tags;
    }

    public void setTags(Short tags) {
        this.tags = tags;
    }

    public Long getActive_member_count() {
        return active_member_count;
    }

    public void setActive_member_count(Long active_member_count) {
        this.active_member_count = active_member_count;
    }

    public Short getApprove_status() {
        return approve_status;
    }

    public void setApprove_status(Short approve_status) {
        this.approve_status = approve_status;
    }

    public List<SHGDesignation> getShgDesignationList() {
        return shgDesignationList;
    }

    public void setShgDesignationList(List<SHGDesignation> shgDesignationList) {
        this.shgDesignationList = shgDesignationList;
    }

    public Integer getMapped_date() {
        return mapped_date;
    }

    public void setMapped_date(Integer mapped_date) {
        this.mapped_date = mapped_date;
    }

    public Integer getUnmapped_date() {
        return unmapped_date;
    }

    public void setUnmapped_date(Integer unmapped_date) {
        this.unmapped_date = unmapped_date;
    }

    public Integer getFederation_joining_date() {
        return federation_joining_date;
    }

    public void setFederation_joining_date(Integer federation_joining_date) {
        this.federation_joining_date = federation_joining_date;
    }

    public String getShg_resolution() {
        return shg_resolution;
    }

    public void setShg_resolution(String shg_resolution) {
        this.shg_resolution = shg_resolution;
    }

    public String getShg_resolution_document() {
        return shg_resolution_document;
    }

    public void setShg_resolution_document(String shg_resolution_document) {
        this.shg_resolution_document = shg_resolution_document;
    }

    public String getTransaction_id() {
        return transaction_id;
    }

    public void setTransaction_id(String transaction_id) {
        this.transaction_id = transaction_id;
    }

    public String getShg_type_other() {
        return shg_type_other;
    }

    public void setShg_type_other(String shg_type_other) {
        this.shg_type_other = shg_type_other;
    }

    public String getPromoter_code() {
        return promoter_code;
    }

    public void setPromoter_code(String promoter_code) {
        this.promoter_code = promoter_code;
    }

	public BigInteger getProcessingId() {
		return processingId;
	}

	public void setProcessingId(BigInteger processingId) {
		this.processingId = processingId;
	}


	public String getApprover() {
		return approver;
	}

	public void setApprover(String approver) {
		this.approver = approver;
	}

	

	public Integer getInactive_reason() {
		return inactive_reason;
	}

	public void setInactive_reason(Integer inactive_reason) {
		this.inactive_reason = inactive_reason;
	}

	public Short getIs_locked() {
		return is_locked;
	}

	public void setIs_locked(Short is_locked) {
		this.is_locked = is_locked;
	}

	
    
    
}

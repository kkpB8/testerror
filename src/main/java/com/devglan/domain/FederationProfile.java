package com.devglan.domain;

import java.math.BigInteger;
import java.util.List;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotBlank;

public class FederationProfile {
	private BigInteger federation_id;
	private BigInteger federation_code;
	private BigInteger temp_code;
	@NotNull(message = "State Must be given")
	private Integer state_id;
	@NotNull(message = "District must be given")
	private Integer district_id;
	@NotNull(message = "Block must be given")
	private Integer block_id;
	//@NotNull(message = "Panchayat must be given")
	private Integer panchayat_id;
	//@NotNull(message = "Village must be given")
	private Integer village_id;
	@NotNull
	private Short cbo_type;
	private String guid;
	private Short federation_type_code;
	@NotBlank(message = "Federation Name must be given")
	private String federation_name;
	private Short cbo_level;
	private Short child_level;
	private Short geographic_level;
	private String federation_name_short_en;
	private String federation_name_local;
	private String federation_name_short_local;
	@NotNull(message = "Formation Date must be given")
	private Integer federation_formation_date;
	private Integer federation_revival_date;
	@NotNull(message = "please select meeting frequency")
	private Short meeting_frequency;
	private Short meeting_frequency_value;
	private Short meeting_on;
	@NotNull(message = "Select mode")
	private Short mode;
	@NotNull(message = "Monthly Compulsory Savings must be given")
	private Integer month_comp_saving;
	private Integer is_bankaccount;
	private BigInteger parent_cbo_code;
	private Short parent_cbo_type;
	private Short is_active;
	private Short dedupl_status;
	private Short activation_status;
	private Short status;
	private Short settlement_status;
	private String checker_remark;
	private String bookkeeper_name;
	private String bookkeeper_mobile;
	private Integer election_tenure;
	private Short is_voluntary_saving;
	private Short saving_frequency;
	private Integer promoted_by;
	private Integer primary_activity;
	private Integer secondary_activity;
	private Integer tertiary_activity;
	private Short bookkeeper_identified;
	private String user_id;
	@NotNull(message = "Set Entry Source ")
	private Short entry_source;
	@NotNull(message = "Set Is Edited")
	private Integer is_edited;
	private Integer last_uploaded_date;
	private String uploaded_by;
	private Integer created_date;
	@NotBlank(message = "Set User Login Details")
	private String created_by;
	private Integer updated_date;
	private String updated_by;
	private String promoter_code;
	//@satwant06052021
	private Integer is_complete;
	
	//@Anshul 210921
	private String approver;

	//@NotEmpty(message = "Address should be specified")
	private List<CBOAddresses> cboAddressesList;
	//@NotEmpty(message = "Phone Details should be specified")
	private List<CBOPhoneNoDetails> cboPhoneNoDetailsList;
	//@NotEmpty(message = "Bank Details should be specified")
	private List<CBOBankDetails> cboBankDetailsList;
	private List<CboKYCDetails> cboKYCDetailsList;
	private List<ECMember> ecMembersList;
	private List<SubCommittee> subCommitteeList;

	public static String exceptionStringFederation;

	private Integer cooption_date;
	private String federation_name_hindi;
	private String federation_name_short;
	private Short is_financial_intermediation;
	private Short is_volutary_saving;
	private Short meber_cbo_count;
	private Double savings_interest;
	private Double voluntary_savings_interest;
	private Short approve_status;

	private Long ec_member_count;
	private Long sc_count;

	private String promoter_name;
	private String federation_resolution;


	private String view_status;
	private String federation_resolution_document;
	private String transaction_id;
	private BigInteger processingId;
	 private Integer inactiveReason;

	public String getView_status() {
		return view_status;
	}

	public void setView_status(String view_status) {
		this.view_status = view_status;
	}
	public BigInteger getFederation_id() {
		return federation_id;
	}

	public void setFederation_id(BigInteger federation_id) {
		this.federation_id = federation_id;
	}

	public BigInteger getFederation_code() {
		return federation_code;
	}

	public void setFederation_code(BigInteger federation_code) {
		this.federation_code = federation_code;
	}

	public BigInteger getTemp_code() {
		return temp_code;
	}

	public void setTemp_code(BigInteger temp_code) {
		this.temp_code = temp_code;
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

	public Short getCbo_type() {
		return cbo_type;
	}

	public void setCbo_type(Short cbo_type) {
		this.cbo_type = cbo_type;
	}

	public String getGuid() {
		return guid;
	}

	public void setGuid(String guid) {
		this.guid = guid;
	}

	public Short getFederation_type_code() {
		return federation_type_code;
	}

	public void setFederation_type_code(Short federation_type_code) {
		this.federation_type_code = federation_type_code;
	}

	public String getFederation_name() {
		return federation_name;
	}

	public void setFederation_name(String federation_name) {
		this.federation_name = federation_name;
	}

	public Short getCbo_level() {
		return cbo_level;
	}

	public void setCbo_level(Short cbo_level) {
		this.cbo_level = cbo_level;
	}

	public Short getChild_level() {
		return child_level;
	}

	public void setChild_level(Short child_level) {
		this.child_level = child_level;
	}

	public Short getGeographic_level() {
		return geographic_level;
	}

	public void setGeographic_level(Short geographic_level) {
		this.geographic_level = geographic_level;
	}

	public String getFederation_name_short_en() {
		return federation_name_short_en;
	}

	public void setFederation_name_short_en(String federation_name_short_en) {
		this.federation_name_short_en = federation_name_short_en;
	}

	public String getFederation_name_local() {
		return federation_name_local;
	}

	public void setFederation_name_local(String federation_name_local) {
		this.federation_name_local = federation_name_local;
	}

	public String getFederation_name_short_local() {
		return federation_name_short_local;
	}

	public void setFederation_name_short_local(String federation_name_short_local) {
		this.federation_name_short_local = federation_name_short_local;
	}

	public Integer getFederation_formation_date() {
		return federation_formation_date;
	}

	public void setFederation_formation_date(Integer federation_formation_date) {
		this.federation_formation_date = federation_formation_date;
	}

	public Integer getFederation_revival_date() {
		return federation_revival_date;
	}

	public void setFederation_revival_date(Integer federation_revival_date) {
		this.federation_revival_date = federation_revival_date;
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

	public Short getMode() {
		return mode;
	}

	public void setMode(Short mode) {
		this.mode = mode;
	}

	public Integer getMonth_comp_saving() {
		return month_comp_saving;
	}

	public void setMonth_comp_saving(Integer month_comp_saving) {
		this.month_comp_saving = month_comp_saving;
	}

	public Integer getIs_bankaccount() {
		return is_bankaccount;
	}

	public void setIs_bankaccount(Integer is_bankaccount) {
		this.is_bankaccount = is_bankaccount;
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

	public Short getStatus() {
		return status;
	}

	public void setStatus(Short status) {
		this.status = status;
	}

	public Short getSettlement_status() {
		return settlement_status;
	}

	public void setSettlement_status(Short settlement_status) {
		this.settlement_status = settlement_status;
	}

	public String getUser_id() {
		return user_id;
	}

	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}

	public Short getEntry_source() {
		return entry_source;
	}

	public void setEntry_source(Short entry_source) {
		this.entry_source = entry_source;
	}

	public Integer getIs_edited() {
		return is_edited;
	}

	public void setIs_edited(Integer is_edited) {
		this.is_edited = is_edited;
	}

	public Integer getLast_uploaded_date() {
		return last_uploaded_date;
	}

	public void setLast_uploaded_date(Integer last_uploaded_date) {
		this.last_uploaded_date = last_uploaded_date;
	}

	public String getUploaded_by() {
		return uploaded_by;
	}

	public void setUploaded_by(String uploaded_by) {
		this.uploaded_by = uploaded_by;
	}

	public Integer getCreated_date() {
		return created_date;
	}

	public void setCreated_date(Integer created_date) {
		this.created_date = created_date;
	}

	public String getCreated_by() {
		return created_by;
	}

	public void setCreated_by(String created_by) {
		this.created_by = created_by;
	}

	public Integer getUpdated_date() {
		return updated_date;
	}

	public void setUpdated_date(Integer updated_date) {
		this.updated_date = updated_date;
	}

	public String getUpdated_by() {
		return updated_by;
	}

	public void setUpdated_by(String updated_by) {
		this.updated_by = updated_by;
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

	public List<CboKYCDetails> getCboKYCDetailsList() {
		return cboKYCDetailsList;
	}

	public void setCboKYCDetailsList(List<CboKYCDetails> cboKYCDetailsList) {
		this.cboKYCDetailsList = cboKYCDetailsList;
	}

	public List<ECMember> getEcMembersList() {
		return ecMembersList;
	}

	public void setEcMembersList(List<ECMember> ecMembersList) {
		this.ecMembersList = ecMembersList;
	}

	public String getChecker_remark() {
		return checker_remark;
	}

	public void setChecker_remark(String checker_remark) {
		this.checker_remark = checker_remark;
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

	public Short getIs_voluntary_saving() {
		return is_voluntary_saving;
	}

	public void setIs_voluntary_saving(Short is_voluntary_saving) {
		this.is_voluntary_saving = is_voluntary_saving;
	}

	public Short getSaving_frequency() {
		return saving_frequency;
	}

	public void setSaving_frequency(Short saving_frequency) {
		this.saving_frequency = saving_frequency;
	}

	public Integer getPromoted_by() {
		return promoted_by;
	}

	public void setPromoted_by(Integer promoted_by) {
		this.promoted_by = promoted_by;
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

	public Short getBookkeeper_identified() {
		return bookkeeper_identified;
	}

	public void setBookkeeper_identified(Short bookkeeper_identified) {
		this.bookkeeper_identified = bookkeeper_identified;
	}

	public List<SubCommittee> getSubCommitteeList() {
		return subCommitteeList;
	}

	public void setSubCommitteeList(List<SubCommittee> subCommitteeList) {
		this.subCommitteeList = subCommitteeList;
	}

	public Integer getCooption_date() {
		return cooption_date;
	}

	public void setCooption_date(Integer cooption_date) {
		this.cooption_date = cooption_date;
	}

	public String getFederation_name_hindi() {
		return federation_name_hindi;
	}

	public void setFederation_name_hindi(String federation_name_hindi) {
		this.federation_name_hindi = federation_name_hindi;
	}

	public String getFederation_name_short() {
		return federation_name_short;
	}

	public void setFederation_name_short(String federation_name_short) {
		this.federation_name_short = federation_name_short;
	}

	public Short getIs_financial_intermediation() {
		return is_financial_intermediation;
	}

	public void setIs_financial_intermediation(Short is_financial_intermediation) {
		this.is_financial_intermediation = is_financial_intermediation;
	}

	public Short getIs_volutary_saving() {
		return is_volutary_saving;
	}

	public void setIs_volutary_saving(Short is_volutary_saving) {
		this.is_volutary_saving = is_volutary_saving;
	}

	public Short getMeber_cbo_count() {
		return meber_cbo_count;
	}

	public void setMeber_cbo_count(Short meber_cbo_count) {
		this.meber_cbo_count = meber_cbo_count;
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

	public Short getApprove_status() {
		return approve_status;
	}

	public void setApprove_status(Short approve_status) {
		this.approve_status = approve_status;
	}

	public Long getEc_member_count() {
		return ec_member_count;
	}

	public void setEc_member_count(Long ec_member_count) {
		this.ec_member_count = ec_member_count;
	}

	public Long getSc_count() {
		return sc_count;
	}

	public void setSc_count(Long sc_count) {
		this.sc_count = sc_count;
	}

	public String getPromoter_name() {
		return promoter_name;
	}

	public void setPromoter_name(String promoter_name) {
		this.promoter_name = promoter_name;
	}

	public String getFederation_resolution() {
		return federation_resolution;
	}

	public void setFederation_resolution(String federation_resolution) {
		this.federation_resolution = federation_resolution;
	}

	public String getFederation_resolution_document() {
		return federation_resolution_document;
	}

	public void setFederation_resolution_document(String federation_resolution_document) {
		this.federation_resolution_document = federation_resolution_document;
	}

	public String getTransaction_id() {
		return transaction_id;
	}

	public void setTransaction_id(String transaction_id) {
		this.transaction_id = transaction_id;
	}

	public String getPromoter_code() {
		return promoter_code;
	}

	public void setPromoter_code(String promoter_code) {
		this.promoter_code = promoter_code;
	}

	public Integer getIs_complete() {
		return is_complete;
	}

	public void setIs_complete(Integer is_complete) {
		this.is_complete = is_complete;
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

	public Integer getInactiveReason() {
		return inactiveReason;
	}

	public void setInactiveReason(Integer inactiveReason) {
		this.inactiveReason = inactiveReason;
	}
	
	
}

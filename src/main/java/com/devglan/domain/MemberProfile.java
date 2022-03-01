package com.devglan.domain;

import org.hibernate.validator.constraints.NotBlank;

import javax.persistence.Column;
import javax.validation.constraints.NotNull;
import java.math.BigInteger;
import java.util.List;

public class MemberProfile {

    @NotNull
    private BigInteger member_id;
    private BigInteger member_code;
    /*code add by mohit kumar start*/
    ////@NotBlank(message = "cbo_id cannot be empty")
    private BigInteger cbo_id;
    // //@NotBlank(message = "cbo_guid cannot be empty")
    private String cbo_guid;
    @NotBlank(message = "GUID must be specified")
    private String member_guid;
    private Integer group_m_code;
    private Integer seq_no;
    @NotBlank(message = "Member Name cannot be empty")
    private String member_name;
    private String member_name_local;
    @NotBlank(message = "father_husband cannot be empty")
    private String father_husband;
    @NotBlank(message = "relation_name cannot be empty")
    private String relation_name;
    private String relation_name_local;
    @NotBlank(message = "gender cannot be empty")
    private Short gender;
    @NotBlank(message = "marital_status cannot be empty")
    private Short marital_status;
    private Short religion;
    private Short social_category;
    private Short tribal_category;
    @NotNull(message = "bpl cannot be empty")
    private Integer bpl;
    private String bpl_number;
    private Short pip_category;
    private Integer pip_date;
    private Short highest_education_level;
    private Short dob_available;
    private Long dob;
    private Integer age;
    private Integer age_as_on;
    @NotNull(message = "minority cannot be empty")
    private Short minority;
    private  Short is_disabled;
    private  String disability_details;
    private  Short wellbeing_category;
    private  Short primary_occupation;
    private  Short secondary_occupation;
    private  Short tertiary_occupation;
    //@NotBlank(message = "joining_date cannot be empty")
    private Integer joining_date;
    private Integer leaving_date;
    private  Short reason_for_leaving;
    private  String if_minor_member_replaced;
    private  String guardian_name;
    private  String guardian_name_local;
    private  Short guardian_relation;
    private Integer designation;
    //@NotNull(message = "status cannot be empty")
    private Integer status;
    private Integer house_hold_code;
    private Short head_house_hold;
    private Integer insurance;
    private String marked_as_defaulter;
    private Integer marked_as_defaulter_date;
    private String record_modified;
    private Integer last_sync_date;
    //@NotNull(message = "Set Entry Source ")
    private Short entry_source;
    //@NotNull(message = "Set Is Edited")
    private Integer is_edited;
    private Short is_active;
    private Short settlement_status;

    private Short mem_activation_status;
    private Short mem_dedup_status;

    private String uploaded_by;
    private Integer created_date;
    private Integer uploaded_date;
    private Integer updated_date;
    //@NotBlank(message = "createdBy cannot be empty")
    private String created_by;
    private String updated_by;
    private String shg_name;
    private String checker_remarks;
    private String member_image;
    private Short approve_status;
    private String member_document;
    private Short is_insurance;
    private String consent_form;
    private String consent_form_image;

    private List<MemberAddresses> memberAddressesList;
    private List<MemberBank> memberBankList;
    private List<MemberKYCDetails> memberKYCDetailsList;
    private List<MemberPhoneNoDetails> memberPhoneNoDetailsList;
   // private List<MemberExecutiveMember> memberExecutiveMemberList;
  // private List<MemberSubExecutiveMember> memberSubExecutiveMemberList;
    private List<MemberSystemTags> memberSystemTagsList;
    private List<CadreNonMembersModel> cadreNonMembersModeslList;
    private List<CadreShgMembersModel> cadreShgMembersModeslList;
    private List<MemberInsurance> memberInsuranceList;

    private String view_status;

    public String getView_status() {
        return view_status;
    }

    //@Satwant 06052021
    private Integer is_verified;
    private Integer is_complete;

    public void setView_status(String view_status) {
        this.view_status = view_status;
    }


    @NotNull
    public BigInteger getMember_id() {
        return member_id;
    }

    public void setMember_id(@NotNull BigInteger member_id) {
        this.member_id = member_id;
    }

    public BigInteger getMember_code() {
        return member_code;
    }

    public void setMember_code(BigInteger member_code) {
        this.member_code = member_code;
    }

    public BigInteger getCbo_id() {
        return cbo_id;
    }

    public void setCbo_id(BigInteger cbo_id) {
        this.cbo_id = cbo_id;
    }

    public String getCbo_guid() {
        return cbo_guid;
    }

    public void setCbo_guid(String cbo_guid) {
        this.cbo_guid = cbo_guid;
    }

    public String getMember_guid() {
        return member_guid;
    }

    public void setMember_guid(String member_guid) {
        this.member_guid = member_guid;
    }

    public Integer getGroup_m_code() {
        return group_m_code;
    }

    public void setGroup_m_code(Integer group_m_code) {
        this.group_m_code = group_m_code;
    }

    public Integer getSeq_no() {
        return seq_no;
    }

    public void setSeq_no(Integer seq_no) {
        this.seq_no = seq_no;
    }

    public String getMember_name() {
        return member_name;
    }

    public void setMember_name(String member_name) {
        this.member_name = member_name;
    }

    public String getMember_name_local() {
        return member_name_local;
    }

    public void setMember_name_local(String member_name_local) {
        this.member_name_local = member_name_local;
    }

    public String getFather_husband() {
        return father_husband;
    }

    public void setFather_husband(String father_husband) {
        this.father_husband = father_husband;
    }

    public String getRelation_name() {
        return relation_name;
    }

    public void setRelation_name(String relation_name) {
        this.relation_name = relation_name;
    }

    public String getRelation_name_local() {
        return relation_name_local;
    }

    public void setRelation_name_local(String relation_name_local) {
        this.relation_name_local = relation_name_local;
    }

    public Short getGender() {
        return gender;
    }

    public void setGender(Short gender) {
        this.gender = gender;
    }

    public Short getMarital_status() {
        return marital_status;
    }

    public void setMarital_status(Short marital_status) {
        this.marital_status = marital_status;
    }

    public Short getReligion() {
        return religion;
    }

    public void setReligion(Short religion) {
        this.religion = religion;
    }

    public Short getSocial_category() {
        return social_category;
    }

    public void setSocial_category(Short social_category) {
        this.social_category = social_category;
    }

    public Short getTribal_category() {
        return tribal_category;
    }

    public void setTribal_category(Short tribal_category) {
        this.tribal_category = tribal_category;
    }

    public Integer getBpl() {
        return bpl;
    }

    public void setBpl(Integer bpl) {
        this.bpl = bpl;
    }

    public String getBpl_number() {
        return bpl_number;
    }

    public void setBpl_number(String bpl_number) {
        this.bpl_number = bpl_number;
    }

    public Short getPip_category() {
        return pip_category;
    }

    public void setPip_category(Short pip_category) {
        this.pip_category = pip_category;
    }

    public Short getHighest_education_level() {
        return highest_education_level;
    }

    public void setHighest_education_level(Short highest_education_level) {
        this.highest_education_level = highest_education_level;
    }

    public Short getDob_available() {
        return dob_available;
    }

    public void setDob_available(Short dob_available) {
        this.dob_available = dob_available;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Short getMinority() {
        return minority;
    }

    public void setMinority(Short minority) {
        this.minority = minority;
    }

    public Short getIs_disabled() {
        return is_disabled;
    }

    public void setIs_disabled(Short is_disabled) {
        this.is_disabled = is_disabled;
    }

    public String getDisability_details() {
        return disability_details;
    }

    public void setDisability_details(String disability_details) {
        this.disability_details = disability_details;
    }

    public Short getWellbeing_category() {
        return wellbeing_category;
    }

    public void setWellbeing_category(Short wellbeing_category) {
        this.wellbeing_category = wellbeing_category;
    }

    public Short getPrimary_occupation() {
        return primary_occupation;
    }

    public void setPrimary_occupation(Short primary_occupation) {
        this.primary_occupation = primary_occupation;
    }

    public Short getSecondary_occupation() {
        return secondary_occupation;
    }

    public void setSecondary_occupation(Short secondary_occupation) {
        this.secondary_occupation = secondary_occupation;
    }

    public Short getTertiary_occupation() {
        return tertiary_occupation;
    }

    public void setTertiary_occupation(Short tertiary_occupation) {
        this.tertiary_occupation = tertiary_occupation;
    }

    public Integer getJoining_date() {
        return joining_date;
    }

    public void setJoining_date(Integer joining_date) {
        this.joining_date = joining_date;
    }

    public Integer getLeaving_date() {
        return leaving_date;
    }

    public void setLeaving_date(Integer leaving_date) {
        this.leaving_date = leaving_date;
    }

    public Short getReason_for_leaving() {
        return reason_for_leaving;
    }

    public void setReason_for_leaving(Short reason_for_leaving) {
        this.reason_for_leaving = reason_for_leaving;
    }

    public String getIf_minor_member_replaced() {
        return if_minor_member_replaced;
    }

    public void setIf_minor_member_replaced(String if_minor_member_replaced) {
        this.if_minor_member_replaced = if_minor_member_replaced;
    }

    public String getGuardian_name() {
        return guardian_name;
    }

    public void setGuardian_name(String guardian_name) {
        this.guardian_name = guardian_name;
    }

    public String getGuardian_name_local() {
        return guardian_name_local;
    }

    public void setGuardian_name_local(String guardian_name_local) {
        this.guardian_name_local = guardian_name_local;
    }

    public Short getGuardian_relation() {
        return guardian_relation;
    }

    public void setGuardian_relation(Short guardian_relation) {
        this.guardian_relation = guardian_relation;
    }

    public Integer getDesignation() {
        return designation;
    }

    public void setDesignation(Integer designation) {
        this.designation = designation;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getHouse_hold_code() {
        return house_hold_code;
    }

    public void setHouse_hold_code(Integer house_hold_code) {
        this.house_hold_code = house_hold_code;
    }

    public Short getHead_house_hold() {
        return head_house_hold;
    }

    public void setHead_house_hold(Short head_house_hold) {
        this.head_house_hold = head_house_hold;
    }

    public Integer getInsurance() {
        return insurance;
    }

    public void setInsurance(Integer insurance) {
        this.insurance = insurance;
    }

    public String getMarked_as_defaulter() {
        return marked_as_defaulter;
    }

    public void setMarked_as_defaulter(String marked_as_defaulter) {
        this.marked_as_defaulter = marked_as_defaulter;
    }

    public String getRecord_modified() {
        return record_modified;
    }

    public void setRecord_modified(String record_modified) {
        this.record_modified = record_modified;
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

    public Short getIs_active() {
        return is_active;
    }

    public void setIs_active(Short is_active) {
        this.is_active = is_active;
    }

    public Short getSettlement_status() {
        return settlement_status;
    }

    public void setSettlement_status(Short settlement_status) {
        this.settlement_status = settlement_status;
    }

    public Short getMem_activation_status() {
        return mem_activation_status;
    }

    public void setMem_activation_status(Short mem_activation_status) {
        this.mem_activation_status = mem_activation_status;
    }

    public Short getMem_dedup_status() {
        return mem_dedup_status;
    }

    public void setMem_dedup_status(Short mem_dedup_status) {
        this.mem_dedup_status = mem_dedup_status;
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

    public List<MemberAddresses> getMemberAddressesList() {
        return memberAddressesList;
    }

    public void setMemberAddressesList(List<MemberAddresses> memberAddressesList) {
        this.memberAddressesList = memberAddressesList;
    }

    public List<MemberBank> getMemberBankList() {
        return memberBankList;
    }

    public void setMemberBankList(List<MemberBank> memberBankList) {
        this.memberBankList = memberBankList;
    }

    public List<MemberKYCDetails> getMemberKYCDetailsList() {
        return memberKYCDetailsList;
    }

    public void setMemberKYCDetailsList(List<MemberKYCDetails> memberKYCDetailsList) {
        this.memberKYCDetailsList = memberKYCDetailsList;
    }

    public List<MemberPhoneNoDetails> getMemberPhoneNoDetailsList() {
        return memberPhoneNoDetailsList;
    }

    public void setMemberPhoneNoDetailsList(List<MemberPhoneNoDetails> memberPhoneNoDetailsList) {
        this.memberPhoneNoDetailsList = memberPhoneNoDetailsList;
    }


    public List<MemberSystemTags> getMemberSystemTagsList() {
        return memberSystemTagsList;
    }

    public void setMemberSystemTagsList(List<MemberSystemTags> memberSystemTagsList) {
        this.memberSystemTagsList = memberSystemTagsList;
    }

    public void setPip_date(Integer pip_date) {
        this.pip_date = pip_date;
    }

    public void setDob(Long dob) {
        this.dob = dob;
    }

    public void setAge_as_on(Integer age_as_on) {
        this.age_as_on = age_as_on;
    }

    public void setMarked_as_defaulter_date(Integer marked_as_defaulter_date) {
        this.marked_as_defaulter_date = marked_as_defaulter_date;
    }

    public void setLast_sync_date(Integer last_sync_date) {
        this.last_sync_date = last_sync_date;
    }

    public Integer getCreated_date() {
        return created_date;
    }

    public void setCreated_date(Integer created_date) {
        this.created_date = created_date;
    }

    public Integer getUploaded_date() {
        return uploaded_date;
    }

    public void setUploaded_date(Integer uploaded_date) {
        this.uploaded_date = uploaded_date;
    }

    public Integer getPip_date() {
        return pip_date;
    }

    public Long getDob() {
        return dob;
    }

    public Integer getAge_as_on() {
        return age_as_on;
    }

    public Integer getMarked_as_defaulter_date() {
        return marked_as_defaulter_date;
    }

    public Integer getLast_sync_date() {
        return last_sync_date;
    }

    public Integer getUpdated_date() {
        return updated_date;
    }

    public void setUpdated_date(Integer updated_date) {
        this.updated_date = updated_date;
    }







    public String getShg_name() {
        return shg_name;
    }

    public void setShg_name(String shg_name) {
        this.shg_name = shg_name;
    }

    public String getChecker_remarks() {
        return checker_remarks;
    }

    public void setChecker_remarks(String checker_remarks) {
        this.checker_remarks = checker_remarks;
    }

    public String getMember_image() {
        return member_image;
    }

    public void setMember_image(String member_image) {
        this.member_image = member_image;
    }

    public Short getApprove_status() {
        return approve_status;
    }

    public void setApprove_status(Short approve_status) {
        this.approve_status = approve_status;
    }

    public String getMember_document() {
        return member_document;
    }

    public void setMember_document(String member_document) {
        this.member_document = member_document;
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


	public List<CadreNonMembersModel> getCadreNonMembersModeslList() {
		return cadreNonMembersModeslList;
	}


	public void setCadreNonMembersModeslList(List<CadreNonMembersModel> cadreNonMembersModeslList) {
		this.cadreNonMembersModeslList = cadreNonMembersModeslList;
	}


	public List<CadreShgMembersModel> getCadreShgMembersModeslList() {
		return cadreShgMembersModeslList;
	}


	public void setCadreShgMembersModeslList(List<CadreShgMembersModel> cadreShgMembersModeslList) {
		this.cadreShgMembersModeslList = cadreShgMembersModeslList;
	}


	public List<MemberInsurance> getMemberInsuranceList() {
		return memberInsuranceList;
	}


	public void setMemberInsuranceList(List<MemberInsurance> memberInsuranceList) {
		this.memberInsuranceList = memberInsuranceList;
	}


	public Short getIs_insurance() {
		return is_insurance;
	}


	public void setIs_insurance(Short is_insurance) {
		this.is_insurance = is_insurance;
	}


	public String getConsent_form() {
		return consent_form;
	}


	public void setConsent_form(String consent_form) {
		this.consent_form = consent_form;
	}


	public String getConsent_form_image() {
		return consent_form_image;
	}


	public void setConsent_form_image(String consent_form_image) {
		this.consent_form_image = consent_form_image;
	}
    
	
}

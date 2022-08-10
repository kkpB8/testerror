package com.devglan.domain;

import org.hibernate.validator.constraints.NotBlank;

import javax.persistence.Column;
import javax.validation.constraints.NotNull;
import java.math.BigInteger;
import java.sql.Timestamp;

public class MemberBank {
    private BigInteger member_bank_details_id;
    ////@NotBlank(message = "CBO GUID cannot be empty")
    private String bank_guid;
    private BigInteger member_code;
    private String member_guid;
    @NotBlank(message = "account Number cannot be empty")
    //@Size(max=20,message="Account Number can be of 20 chars long")
    private String account_no;
    @NotNull(message = "bank_id cannot be empty")
    private BigInteger bank_id;
    @NotNull(message = "Account Type cannot be empty")
    private Short account_type;
    //@Size(max=12,message="Member Branch Code can be of 12 chars long")
    private String mem_branch_code;
    //@Size(max=20,message="IFSC Code can be of 20 chars long")
    private String ifsc_code;
    @NotNull(message = "Account Open Date cannot be empty")
    private Integer account_open_date;
    @NotNull(message = "is default account cannot be empty")
    private Integer is_default_account;
    private Short status;
    private Integer closing_date;
    //@Size(max=20,message="GL Code can be of 20 chars long")
    private String gl_code;
    private Integer same_as_group;
    @NotNull(message = "Set Entry Source")
    private Short entry_source;
    @NotNull(message = "Set Is Edited")
    private Integer is_edited;
    private Short is_active;
    private String updated_by;
    @NotBlank(message = "Created By cannot be empty")
    private String created_by;
    private String uploaded_by;
    private Short activation_status;
    private Short dedupl_status;
    private BigInteger cbo_id;
    //@Size(max=60,message="Account Number can be of 60 chars long")
    private String bank_passbook_name;
    private String passbook_first_page;
    @NotNull(message = "Created Date Must be Given")
    private Integer created_date;
    private Integer uploaded_date;
    private Integer updated_date;
    private String member_name;
    private String member_bank_document;

    //02-04-21 mohit
    private String identified_duplicates;
    private Short npci_status;
    //@Satwant 06052021
    private Integer is_verified;
    private Integer is_complete;
    private Integer inactive_date ;


    public BigInteger getMember_bank_details_id() {
        return member_bank_details_id;
    }

    public void setMember_bank_details_id(BigInteger member_bank_details_id) {
        this.member_bank_details_id = member_bank_details_id;
    }

    public String getBank_guid() {
        return bank_guid;
    }

    public void setBank_guid(String bank_guid) {
        this.bank_guid = bank_guid;
    }

    public BigInteger getMember_code() {
        return member_code;
    }

    public void setMember_code(BigInteger member_code) {
        this.member_code = member_code;
    }

    public String getMember_guid() {
        return member_guid;
    }

    public void setMember_guid(String member_guid) {
        this.member_guid = member_guid;
    }

    public String getAccount_no() {
        return account_no;
    }

    public void setAccount_no(String account_no) {
        this.account_no = account_no;
    }

    public BigInteger getBank_id() {
        return bank_id;
    }

    public void setBank_id(BigInteger bank_id) {
        this.bank_id = bank_id;
    }

    public Short getAccount_type() {
        return account_type;
    }

    public void setAccount_type(Short account_type) {
        this.account_type = account_type;
    }

    public String getMem_branch_code() {
        return mem_branch_code;
    }

    public void setMem_branch_code(String mem_branch_code) {
        this.mem_branch_code = mem_branch_code;
    }

    public String getIfsc_code() {
        return ifsc_code;
    }

    public void setIfsc_code(String ifsc_code) {
        this.ifsc_code = ifsc_code;
    }

    public Integer getAccount_open_date() {
        return account_open_date;
    }

    public void setAccount_open_date(Integer account_open_date) {
        this.account_open_date = account_open_date;
    }

    public Integer getIs_default_account() {
        return is_default_account;
    }

    public void setIs_default_account(Integer is_default_account) {
        this.is_default_account = is_default_account;
    }

    public Integer getClosing_date() {
        return closing_date;
    }

    public void setClosing_date(Integer closing_date) {
        this.closing_date = closing_date;
    }

    public String getGl_code() {
        return gl_code;
    }

    public void setGl_code(String gl_code) {
        this.gl_code = gl_code;
    }

    public Integer getSame_as_group() {
        return same_as_group;
    }

    public void setSame_as_group(Integer same_as_group) {
        this.same_as_group = same_as_group;
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

    public String getUpdated_by() {
        return updated_by;
    }

    public void setUpdated_by(String updated_by) {
        this.updated_by = updated_by;
    }

    public String getCreated_by() {
        return created_by;
    }

    public void setCreated_by(String created_by) {
        this.created_by = created_by;
    }

    public String getUploaded_by() {
        return uploaded_by;
    }

    public void setUploaded_by(String uploaded_by) {
        this.uploaded_by = uploaded_by;
    }

    public Short getActivation_status() {
        return activation_status;
    }

    public void setActivation_status(Short activation_status) {
        this.activation_status = activation_status;
    }

    public Short getDedupl_status() {
        return dedupl_status;
    }

    public void setDedupl_status(Short dedupl_status) {
        this.dedupl_status = dedupl_status;
    }

    public BigInteger getCbo_id() {
        return cbo_id;
    }

    public void setCbo_id(BigInteger cbo_id) {
        this.cbo_id = cbo_id;
    }

    public String getBank_passbook_name() {
        return bank_passbook_name;
    }

    public void setBank_passbook_name(String bank_passbook_name) {
        this.bank_passbook_name = bank_passbook_name;
    }

    public String getPassbook_first_page() {
        return passbook_first_page;
    }

    public void setPassbook_first_page(String passbook_first_page) {
        this.passbook_first_page = passbook_first_page;
    }

    public void setStatus(Short status) {
        this.status = status;
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

    public Integer getUpdated_date() {
        return updated_date;
    }

    public void setUpdated_date(Integer updated_date) {
        this.updated_date = updated_date;
    }

    public Short getStatus() {
        return status;
    }
    public String getMember_name() {
        return member_name;
    }

    public void setMember_name(String member_name) {
        this.member_name = member_name;
    }

    public String getMember_bank_document() {
        return member_bank_document;
    }

    public void setMember_bank_document(String member_bank_document) {
        this.member_bank_document = member_bank_document;
    }

    public String getIdentified_duplicates() {
        return identified_duplicates;
    }

    public void setIdentified_duplicates(String identified_duplicates) {
        this.identified_duplicates = identified_duplicates;
    }

    public Short getNpci_status() {
        return npci_status;
    }

    public void setNpci_status(Short npci_status) {
        this.npci_status = npci_status;
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

    public Integer getInactive_date() {
        return inactive_date;
    }

    public void setInactive_date(Integer inactive_date) {
        this.inactive_date = inactive_date;
    }
}

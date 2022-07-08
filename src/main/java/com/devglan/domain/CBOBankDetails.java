package com.devglan.domain;

import org.hibernate.validator.constraints.NotBlank;

import javax.validation.constraints.NotNull;
import java.math.BigInteger;
import java.sql.Timestamp;

public class CBOBankDetails {
    private BigInteger cbo_bank_id;
    private String bank_guid;
    private String cbo_guid;
    private BigInteger cbo_id;
    @NotBlank(message = "Account No cannot be empty")
    //@Size(max=20,message="Account No can be of 20 chars Long")
    private String account_no;
    @NotBlank(message = "Account Opening Date cannot be empty")
    private Integer account_opening_date;
    private Integer account_linkage_date;
    @NotNull(message = "Bank Id cannot be empty")
    private Integer bank_id;
    //@Size(max=10,message="Bank Code can be 10 chars long")
    private String bank_code;
    //@Size(max=50,message="Bank Branch can be 50 chars long")
    private String bank_branch;
    @NotNull(message = "Bank Branch Id cannot be empty")
    private BigInteger bank_branch_id;
    @NotBlank(message = "IFSC Code cannot be empty")
    //@Size(max=20,message="IFSC Code can be 20 chars long")
    private String ifsc_code;
    //@Size(max=3,message="Account Type can be 3 chars long")
    private String account_type;
    @NotNull(message = "Set Is Default")
    private Short is_default;
    @NotNull(message = "Set Cbo Type")
    private Short cbo_type;
    @NotNull(message = "Sequence No cannot be empty")
    private Integer sequence_no;
    private Integer verification;
    private Integer closure_date;
    //@Size(max=60,message="Bank Passbook Name can be 60 chars long")
    private String bankpassbook_name;
    private String passbook_firstpage;
    private Short status;
    private Short deduplication_status;
    private Short activation_status;
    @NotNull(message = "Set Entry Source ")
    private Short entry_source;
    @NotNull(message = "Set Is Edited")
    private Integer is_edited;
    private Integer last_uploaded_date;
    private String uploaded_by;
    private Integer created_date;
    private String created_by;
    private Integer updated_date;
    private String updated_by;
    @NotNull(message = "Set Is Active")
    private Short is_active;
    private String bank_document;

    //02-04-21 mohit
    private String identified_duplicates;
    private Short npci_status;

    //@Satwant 06052021
    private Integer is_verified;
    private Integer is_complete;
    private Integer inactive_date;

    public BigInteger getCbo_bank_id() {
        return cbo_bank_id;
    }

    public void setCbo_bank_id(BigInteger cbo_bank_id) {
        this.cbo_bank_id = cbo_bank_id;
    }

    public BigInteger getCbo_id() {
        return cbo_id;
    }

    public void setCbo_id(BigInteger cbo_id) {
        this.cbo_id = cbo_id;
    }

    public BigInteger getBank_branch_id() {
        return bank_branch_id;
    }

    public void setBank_branch_id(BigInteger bank_branch_id) {
        this.bank_branch_id = bank_branch_id;
    }

    public Integer getClosure_date() {
        return closure_date;
    }

    public void setClosure_date(Integer closure_date) {
        this.closure_date = closure_date;
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

    public String getAccount_no() {
        return account_no;
    }

    public void setAccount_no(String account_no) {
        this.account_no = account_no;
    }

    public Integer getBank_id() {
        return bank_id;
    }

    public void setBank_id(Integer bank_id) {
        this.bank_id = bank_id;
    }

    public String getBank_code() {
        return bank_code;
    }

    public void setBank_code(String bank_code) {
        this.bank_code = bank_code;
    }

    public String getBank_branch() {
        return bank_branch;
    }

    public void setBank_branch(String bank_branch) {
        this.bank_branch = bank_branch;
    }

    public String getIfsc_code() {
        return ifsc_code;
    }

    public void setIfsc_code(String ifsc_code) {
        this.ifsc_code = ifsc_code;
    }

    public String getAccount_type() {
        return account_type;
    }

    public void setAccount_type(String account_type) {
        this.account_type = account_type;
    }

    public Short getIs_default() {
        return is_default;
    }

    public void setIs_default(Short is_default) {
        this.is_default = is_default;
    }

    public Integer getSequence_no() {
        return sequence_no;
    }

    public void setSequence_no(Integer sequence_no) {
        this.sequence_no = sequence_no;
    }

    public Integer getVerification() {
        return verification;
    }

    public void setVerification(Integer verification) {
        this.verification = verification;
    }

    public Integer getAccount_opening_date() {
        return account_opening_date;
    }

    public void setAccount_opening_date(Integer account_opening_date) {
        this.account_opening_date = account_opening_date;
    }

    public Integer getAccount_linkage_date() {
        return account_linkage_date;
    }

    public void setAccount_linkage_date(Integer account_linkage_date) {
        this.account_linkage_date = account_linkage_date;
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

    public String getBank_guid() {
        return bank_guid;
    }

    public void setBank_guid(String bank_guid) {
        this.bank_guid = bank_guid;
    }

    public String getCbo_guid() {
        return cbo_guid;
    }

    public void setCbo_guid(String cbo_guid) {
        this.cbo_guid = cbo_guid;
    }

    public String getBankpassbook_name() {
        return bankpassbook_name;
    }

    public void setBankpassbook_name(String bankpassbook_name) {
        this.bankpassbook_name = bankpassbook_name;
    }

    public String getPassbook_firstpage() {
        return passbook_firstpage;
    }

    public void setPassbook_firstpage(String passbook_firstpage) {
        this.passbook_firstpage = passbook_firstpage;
    }

    public Short getStatus() {
        return status;
    }

    public void setStatus(Short status) {
        this.status = status;
    }


    public Short getDeduplication_status() {
        return deduplication_status;
    }

    public void setDeduplication_status(Short deduplication_status) {
        this.deduplication_status = deduplication_status;
    }

    public Short getActivation_status() {
        return activation_status;
    }

    public void setActivation_status(Short activation_status) {
        this.activation_status = activation_status;
    }

    public Short getIs_active() {
        return is_active;
    }

    public void setIs_active(Short is_active) {
        this.is_active = is_active;
    }

    public Short getCbo_type() {
        return cbo_type;
    }

    public void setCbo_type(Short cbo_type) {
        this.cbo_type = cbo_type;
    }

    public String getBank_document() {
        return bank_document;
    }

    public void setBank_document(String bank_document) {
        this.bank_document = bank_document;
    }

    public Short getNpci_status() {
        return npci_status;
    }

    public void setNpci_status(Short npci_status) {
        this.npci_status = npci_status;
    }

    public String getIdentified_duplicates() {
        return identified_duplicates;
    }

    public void setIdentified_duplicates(String identified_duplicates) {
        this.identified_duplicates = identified_duplicates;
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

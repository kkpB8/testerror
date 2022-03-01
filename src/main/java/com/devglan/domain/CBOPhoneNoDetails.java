package com.devglan.domain;

import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.NotEmpty;

import javax.validation.constraints.NotNull;
import java.math.BigInteger;

public class CBOPhoneNoDetails {

    private BigInteger cbo_phone_id;
    private  String phone_guid;
    private String cbo_guid;
    private BigInteger cbo_id;
    @NotNull(message = "Mobile No cannot be empty")
    private BigInteger mobile_no;
    @NotNull(message = "Phone Ownership cannot be empty")
    private Short phone_ownership;
    private String phone_ownership_details;
    @NotNull(message = "Valid From cannot be empty")
    private Integer  valid_from;
    private Integer valid_till;
    @NotNull(message = "Cbo Type cannot be empty")
    private Short cbo_type;
    private Short status;
    private Short deduplication_status;
    private Short activation_status;
    @NotNull(message = "Is Default cannot be empty")
    private Short is_default;
    @NotNull(message = "Set Entry Source ")
    private Short entry_source;
    @NotNull(message = "Set Is Edited")
    private Integer is_edited;
    @NotNull(message = "Set Is Active")
    private Short is_active;
    private Integer last_uploaded_date;
    private String uploaded_by;

    @NotNull(message = "Created Date Must be Given")
    private Integer created_date;
    @NotNull(message = "Created By Must be Given")
    private String created_by;
    private Integer updated_date;
    private String updated_by;
    private String member_guid;
    private String member_name;

    private String identified_duplicates;
    //@Satwant 06052021
    private Integer is_verified;
    private Integer is_complete;

    public BigInteger getCbo_id() {
        return cbo_id;
    }

    public void setCbo_id(BigInteger cbo_id) {
        this.cbo_id = cbo_id;
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

    public BigInteger getMobile_no() {
        return mobile_no;
    }

    public void setMobile_no(BigInteger mobile_no) {
        this.mobile_no = mobile_no;
    }

    public String getPhone_ownership_details() {
        return phone_ownership_details;
    }

    public void setPhone_ownership_details(String phone_ownership_details) {
        this.phone_ownership_details = phone_ownership_details;
    }

    public Short getCbo_type() {
        return cbo_type;
    }

    public void setCbo_type(Short cbo_type) {
        this.cbo_type = cbo_type;
    }

    public BigInteger getCbo_phone_id() {
        return cbo_phone_id;
    }

    public void setCbo_phone_id(BigInteger cbo_phone_id) {
        this.cbo_phone_id = cbo_phone_id;
    }

    public Short getIs_default() {
        return is_default;
    }

    public void setIs_default(Short is_default) {
        this.is_default = is_default;
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

    public Integer getValid_from() {
        return valid_from;
    }

    public void setValid_from(Integer valid_from) {
        this.valid_from = valid_from;
    }

    public Integer getValid_till() {
        return valid_till;
    }

    public void setValid_till(Integer valid_till) {
        this.valid_till = valid_till;
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

    public String getPhone_guid() {
        return phone_guid;
    }

    public void setPhone_guid(String phone_guid) {
        this.phone_guid = phone_guid;
    }

    public String getCbo_guid() {
        return cbo_guid;
    }

    public void setCbo_guid(String cbo_guid) {
        this.cbo_guid = cbo_guid;
    }

    public Short getPhone_ownership() {
        return phone_ownership;
    }

    public void setPhone_ownership(Short phone_ownership) {
        this.phone_ownership = phone_ownership;
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

    public String getMember_guid() {
        return member_guid;
    }

    public void setMember_guid(String member_guid) {
        this.member_guid = member_guid;
    }

    public Short getIs_active() {
        return is_active;
    }

    public void setIs_active(Short is_active) {
        this.is_active = is_active;
    }

    public String getMember_name() {
        return member_name;
    }

    public void setMember_name(String member_name) {
        this.member_name = member_name;
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
}

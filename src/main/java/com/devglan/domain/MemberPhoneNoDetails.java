package com.devglan.domain;

import org.hibernate.validator.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.math.BigInteger;

public class MemberPhoneNoDetails {


    private BigInteger member_phone_details_id;
    //@NotBlank(message = "CBO GUID cannot be empty")
    private String phone_guid;
    private String member_guid;
    private BigInteger member_code;
    @NotNull(message = "Phone Number cannot be empty")
    private BigInteger phone_no;
    @NotNull(message = "Set is_default")
    private Short is_default;
    //@NotBlank(message = "Phone Ownership cannot be empty")
    private Short phone_ownership;
    private String phone_ownership_details;
    @NotNull(message = "Valid From cannot be empty")
    private Integer valid_from;
    private Integer valid_till;
    @NotNull(message = "Set Entry Source")
    private Short entry_source;
    @NotNull(message = "Set Is Edited")
    private Integer is_edited;
    private Short is_active;
    private String uploaded_by;
    @NotBlank(message = "Created By cannot be empty")
    private String created_by;
    private String updated_by;
    private Short activation_status;
    private Short dedupl_status;
    private BigInteger cbo_id;
    private Short status;
    @NotNull(message = "Created Date Must be Given")
    private Integer created_date;
    private Integer uploaded_date;
    private Integer updated_date;

    //@Satwant 06052021
    private Integer is_verified;
    private Integer is_complete;

    public BigInteger getMember_phone_details_id() {
        return member_phone_details_id;
    }

    public void setMember_phone_details_id(BigInteger member_phone_details_id) {
        this.member_phone_details_id = member_phone_details_id;
    }

    public String getPhone_guid() {
        return phone_guid;
    }

    public void setPhone_guid(String phone_guid) {
        this.phone_guid = phone_guid;
    }

    public String getMember_guid() {
        return member_guid;
    }

    public void setMember_guid(String member_guid) {
        this.member_guid = member_guid;
    }

    public BigInteger getMember_code() {
        return member_code;
    }

    public void setMember_code(BigInteger member_code) {
        this.member_code = member_code;
    }

    public BigInteger getPhone_no() {
        return phone_no;
    }

    public void setPhone_no(BigInteger phone_no) {
        this.phone_no = phone_no;
    }

    public Short getIs_default() {
        return is_default;
    }

    public void setIs_default(Short is_default) {
        this.is_default = is_default;
    }

    public Short getPhone_ownership() {
        return phone_ownership;
    }

    public void setPhone_ownership(Short phone_ownership) {
        this.phone_ownership = phone_ownership;
    }

    public String getPhone_ownership_details() {
        return phone_ownership_details;
    }

    public void setPhone_ownership_details(String phone_ownership_details) {
        this.phone_ownership_details = phone_ownership_details;
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

    public Short getStatus() {
        return status;
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

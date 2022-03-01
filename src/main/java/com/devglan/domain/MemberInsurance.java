package com.devglan.domain;

import org.hibernate.validator.constraints.NotBlank;

import javax.persistence.Column;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.math.BigInteger;

public class MemberInsurance {

    private BigInteger insurance_id;
    private String member_guid;
    private BigInteger cbo_id;
    private BigInteger member_code;
    private Integer insurance_type;
    private Short status;
    private Short entry_source;
    private Integer is_edited;
    private Short is_active;
    private String uploaded_by;
    private Integer uploaded_date;
    private Integer created_date;
    private String created_by;
    private Integer updated_date;
    private String updated_by;
    private Integer is_complete;
    private Integer valid_to;

    public BigInteger getInsurance_id() {
        return insurance_id;
    }

    public void setInsurance_id(BigInteger insurance_id) {
        this.insurance_id = insurance_id;
    }

    public String getMember_guid() {
        return member_guid;
    }

    public void setMember_guid(String member_guid) {
        this.member_guid = member_guid;
    }

    public BigInteger getCbo_id() {
        return cbo_id;
    }

    public void setCbo_id(BigInteger cbo_id) {
        this.cbo_id = cbo_id;
    }

    public BigInteger getMember_code() {
        return member_code;
    }

    public void setMember_code(BigInteger member_code) {
        this.member_code = member_code;
    }

    public Integer getInsurance_type() {
        return insurance_type;
    }

    public void setInsurance_type(Integer insurance_type) {
        this.insurance_type = insurance_type;
    }

    public Short getStatus() {
        return status;
    }

    public void setStatus(Short status) {
        this.status = status;
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

    public Integer getUploaded_date() {
        return uploaded_date;
    }

    public void setUploaded_date(Integer uploaded_date) {
        this.uploaded_date = uploaded_date;
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

    public Integer getIs_complete() {
        return is_complete;
    }

    public void setIs_complete(Integer is_complete) {
        this.is_complete = is_complete;
    }

    public Integer getValid_to() {
        return valid_to;
    }

    public void setValid_to(Integer valid_to) {
        this.valid_to = valid_to;
    }
}

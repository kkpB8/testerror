package com.devglan.domain;

import javax.persistence.*;
import java.math.*;

public class SHGDesignation {
    private BigInteger member_designation_id;
    private String cbo_guid;
    private String member_designation_guid;
    private BigInteger cbo_code;
    private BigInteger member_code;
    private String member_guid;
    private Short designation;
    private Integer date_election;
    private Integer from_date;
    private Integer to_date;
    private Short status;
    private Short is_active;
    private Short entry_source;
    private Integer is_edited;
    private Integer last_uploaded_date;
    private String uploaded_by;
    private Integer created_date;
    private String created_by;
    private Integer updated_date;
    private String updated_by;
	
	private Short is_signatory;

    //30-3-2021
    private String member_name;

    public BigInteger getMember_designation_id() {
        return member_designation_id;
    }

    public void setMember_designation_id(BigInteger member_designation_id) {
        this.member_designation_id = member_designation_id;
    }

    public String getCbo_guid() {
        return cbo_guid;
    }

    public void setCbo_guid(String cbo_guid) {
        this.cbo_guid = cbo_guid;
    }

    public String getMember_designation_guid() {
        return member_designation_guid;
    }

    public void setMember_designation_guid(String member_designation_guid) {
        this.member_designation_guid = member_designation_guid;
    }

    public BigInteger getCbo_code() {
        return cbo_code;
    }

    public void setCbo_code(BigInteger cbo_code) {
        this.cbo_code = cbo_code;
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

    public Short getDesignation() {
        return designation;
    }

    public void setDesignation(Short designation) {
        this.designation = designation;
    }

    public Integer getDate_election() {
        return date_election;
    }

    public void setDate_election(Integer date_election) {
        this.date_election = date_election;
    }

    public Integer getFrom_date() {
        return from_date;
    }

    public void setFrom_date(Integer from_date) {
        this.from_date = from_date;
    }

    public Integer getTo_date() {
        return to_date;
    }

    public void setTo_date(Integer to_date) {
        this.to_date = to_date;
    }

    public Short getStatus() {
        return status;
    }

    public void setStatus(Short status) {
        this.status = status;
    }

    public Short getIs_active() {
        return is_active;
    }

    public void setIs_active(Short is_active) {
        this.is_active = is_active;
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
	
	
	 public Short getIs_signatory() {
        return is_signatory;
    }

    public void setIs_signatory(Short is_signatory) {
        this.is_signatory = is_signatory;
    }

    public String getMember_name() {
        return member_name;
    }

    public void setMember_name(String member_name) {
        this.member_name = member_name;
    }
}
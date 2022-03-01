package com.devglan.domain;

import java.math.BigInteger;

public class ECMember {
	private BigInteger executive_member_id;
    private BigInteger cbo_id;
    private String cbo_guid;
    private String guid;
    private Short cbo_level;
    private Short ec_cbo_level;
    private String ec_cbo_code;
    private BigInteger ec_cbo_id;
    private BigInteger ec_member_code;
    private Short designation;
    private Integer joining_date;
    private Integer leaving_date;
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

    private String vo_name;
    private String shg_name;
    private String member_name;
    //@Adish
    private Integer signatory_joining_date;
	private Integer signatory_leaving_date;

	public Integer getSignatory_joining_date() {
		return signatory_joining_date;
	}
	public void setSignatory_joining_date(Integer signatory_joining_date) {
		this.signatory_joining_date = signatory_joining_date;
	}
	public Integer getSignatory_leaving_date() {
		return signatory_leaving_date;
	}
	public void setSignatory_leaving_date(Integer signatory_leaving_date) {
		this.signatory_leaving_date = signatory_leaving_date;
	}
    
	public BigInteger getExecutive_member_id() {
		return executive_member_id;
	}
	public void setExecutive_member_id(BigInteger executive_member_id) {
		this.executive_member_id = executive_member_id;
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
	public String getGuid() {
		return guid;
	}
	public void setGuid(String guid) {
		this.guid = guid;
	}
	public Short getCbo_level() {
		return cbo_level;
	}
	public void setCbo_level(Short cbo_level) {
		this.cbo_level = cbo_level;
	}
	public Short getEc_cbo_level() {
		return ec_cbo_level;
	}
	public void setEc_cbo_level(Short ec_cbo_level) {
		this.ec_cbo_level = ec_cbo_level;
	}
	public String getEc_cbo_code() {
		return ec_cbo_code;
	}
	public void setEc_cbo_code(String ec_cbo_code) {
		this.ec_cbo_code = ec_cbo_code;
	}
	public BigInteger getEc_cbo_id() {
		return ec_cbo_id;
	}
	public void setEc_cbo_id(BigInteger ec_cbo_id) {
		this.ec_cbo_id = ec_cbo_id;
	}
	public BigInteger getEc_member_code() {
		return ec_member_code;
	}
	public void setEc_member_code(BigInteger ec_member_code) {
		this.ec_member_code = ec_member_code;
	}
	public Short getDesignation() {
		return designation;
	}
	public void setDesignation(Short designation) {
		this.designation = designation;
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
	public String getVo_name() {
		return vo_name;
	}
	public void setVo_name(String vo_name) {
		this.vo_name = vo_name;
	}
	public String getShg_name() {
		return shg_name;
	}
	public void setShg_name(String shg_name) {
		this.shg_name = shg_name;
	}
	public String getMember_name() {
		return member_name;
	}
	public void setMember_name(String member_name) {
		this.member_name = member_name;
	}
    
    

}

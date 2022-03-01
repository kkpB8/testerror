package com.devglan.domain;

import java.math.BigInteger;
import java.util.List;

public class SubCommittee {
	private BigInteger subcommitee_id;
	private BigInteger cbo_id;
	private BigInteger cbo_code;
	private String cbo_guid;
	private String subcommitee_guid;
	private BigInteger subcommitee_code;
	private BigInteger subcommitee_type_id;
	private Integer fromdate;
	private Integer todate;
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
	private List<SubCommitteeMember> subCommitteeMemberList;
	private String subcommitee_name;
	//@satwant06052021
	private Integer is_complete;

	public BigInteger getSubcommitee_id() {
		return subcommitee_id;
	}

	public void setSubcommitee_id(BigInteger subcommitee_id) {
		this.subcommitee_id = subcommitee_id;
	}

	public BigInteger getCbo_id() {
		return cbo_id;
	}

	public void setCbo_id(BigInteger cbo_id) {
		this.cbo_id = cbo_id;
	}

	public BigInteger getCbo_code() {
		return cbo_code;
	}

	public void setCbo_code(BigInteger cbo_code) {
		this.cbo_code = cbo_code;
	}

	public String getCbo_guid() {
		return cbo_guid;
	}

	public void setCbo_guid(String cbo_guid) {
		this.cbo_guid = cbo_guid;
	}

	public String getSubcommitee_guid() {
		return subcommitee_guid;
	}

	public void setSubcommitee_guid(String subcommitee_guid) {
		this.subcommitee_guid = subcommitee_guid;
	}

	public BigInteger getSubcommitee_code() {
		return subcommitee_code;
	}

	public void setSubcommitee_code(BigInteger subcommitee_code) {
		this.subcommitee_code = subcommitee_code;
	}

	public BigInteger getSubcommitee_type_id() {
		return subcommitee_type_id;
	}

	public void setSubcommitee_type_id(BigInteger subcommitee_type_id) {
		this.subcommitee_type_id = subcommitee_type_id;
	}

	public Integer getFromdate() {
		return fromdate;
	}

	public void setFromdate(Integer fromdate) {
		this.fromdate = fromdate;
	}

	public Integer getTodate() {
		return todate;
	}

	public void setTodate(Integer todate) {
		this.todate = todate;
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

	public List<SubCommitteeMember> getSubCommitteeMemberList() {
		return subCommitteeMemberList;
	}

	public void setSubCommitteeMemberList(List<SubCommitteeMember> subCommitteeMemberList) {
		this.subCommitteeMemberList = subCommitteeMemberList;
	}

	public String getSubcommitee_name() {
		return subcommitee_name;
	}

	public void setSubcommitee_name(String subcommitee_name) {
		this.subcommitee_name = subcommitee_name;
	}

	public Integer getIs_complete() {
		return is_complete;
	}

	public void setIs_complete(Integer is_complete) {
		this.is_complete = is_complete;
	}
}

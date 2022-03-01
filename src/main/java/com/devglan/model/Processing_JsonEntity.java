package com.devglan.model;

import java.math.BigInteger;
import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "processing_json")
public class Processing_JsonEntity {
	
	@Id
	@Column
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private BigInteger id;
	
	private String json;
	private String files;
	private String parameter;
	private Timestamp start_time;
	private Timestamp end_time;
	private Timestamp created_date;
	private Short flag;
	private Short cbo_type;
	private String transaction_id  ;
	private String user_id;
	private String role;
	
	
	public static Short noReadFlag=1;
    public static Short processingFlag=2;
    public static Short executedFlag=3;
    
    public static Short startTimeFlag = 1;
    public static Short EndTimeFlag = 2;
    
    //LOOKUPS
    public static Short shgLookupVal=0;
    public static Short federationLookupVal = 10;
    public static Short meetingLookupVal = 1;
    public static Short voMeetingLookupVal = 11;
	public BigInteger getId() {
		return id;
	}
	public void setId(BigInteger id) {
		this.id = id;
	}
	public String getJson() {
		return json;
	}
	public void setJson(String json) {
		this.json = json;
	}
	public String getFiles() {
		return files;
	}
	public void setFiles(String files) {
		this.files = files;
	}
	public String getParameter() {
		return parameter;
	}
	public void setParameter(String parameter) {
		this.parameter = parameter;
	}
	public Timestamp getStart_time() {
		return start_time;
	}
	public void setStart_time(Timestamp start_time) {
		this.start_time = start_time;
	}
	public Timestamp getEnd_time() {
		return end_time;
	}
	public void setEnd_time(Timestamp end_time) {
		this.end_time = end_time;
	}
	public Timestamp getCreated_date() {
		return created_date;
	}
	public void setCreated_date(Timestamp created_date) {
		this.created_date = created_date;
	}
	public Short getFlag() {
		return flag;
	}
	public void setFlag(Short flag) {
		this.flag = flag;
	}
	public Short getCbo_type() {
		return cbo_type;
	}
	public void setCbo_type(Short cbo_type) {
		this.cbo_type = cbo_type;
	}
	public String getTransaction_id() {
		return transaction_id;
	}
	public void setTransaction_id(String transaction_id) {
		this.transaction_id = transaction_id;
	}
	public String getUser_id() {
		return user_id;
	}
	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	
	
	
}

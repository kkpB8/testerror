package com.devglan.model;


import javax.persistence.*;
import java.math.BigInteger;
import java.util.Date;
import java.sql.Timestamp;
import java.time.LocalDateTime;

@Entity
@Table(name = "cadre_non_members")
public class CadreNonMembersEntity
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "uid", nullable = false)
    private BigInteger uid;
    @Column(name = "village_id", nullable = false)
    private Integer villageId;
    @Column(name = "member_name", nullable = false)
    private String memberName;
    @Column(name = "cadre_role_code", nullable = false)
    private Integer cadreRoleCode;
    @Column(name = "cadre_cat_code", nullable = false)
    private Integer cadreCatCode;
    @Column(name = "date_joining", nullable = false)
    private Date dateJoining;
    @Column(name = "date_leaving", nullable = false)
    private Date dateLeaving;
    @Column(name = "created_by")
    private String createdBy;
    @Column(name = "created_on")

    private Timestamp createdOn;
    @Column(name = "updated_by")
    private String updatedBy;
    @Column(name = "updated_on")
    private Timestamp updatedOn;
    @Column(name = "uploaded_by")
    private String uploadedBy;
    @Column(name = "uploaded_on")
    private Timestamp uploadedOn;
    
    @Column(name = "cadre_guid")
    private String cadreGuid;
	public String getCadreGuid() {
		return cadreGuid;
	}
	public void setCadreGuid(String cadreGuid) {
		this.cadreGuid = cadreGuid;
	}
	public BigInteger getUid() {
		return uid;
	}
	public void setUid(BigInteger uid) {
		this.uid = uid;
	}
	public Integer getVillageId() {
		return villageId;
	}
	public void setVillageId(Integer villageId) {
		this.villageId = villageId;
	}
	public String getMemberName() {
		return memberName;
	}
	public void setMemberName(String memberName) {
		this.memberName = memberName;
	}
	public Integer getCadreRoleCode() {
		return cadreRoleCode;
	}
	public void setCadreRoleCode(Integer cadreRoleCode) {
		this.cadreRoleCode = cadreRoleCode;
	}
	public Integer getCadreCatCode() {
		return cadreCatCode;
	}
	public void setCadreCatCode(Integer cadreCatCode) {
		this.cadreCatCode = cadreCatCode;
	}
	public Date getDateJoining() {
		return dateJoining;
	}
	public void setDateJoining(Date dateJoining) {
		this.dateJoining = dateJoining;
	}
	public Date getDateLeaving() {
		return dateLeaving;
	}
	public void setDateLeaving(Date dateLeaving) {
		this.dateLeaving = dateLeaving;
	}
	public String getCreatedBy() {
		return createdBy;
	}
	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}
	public Timestamp getCreatedOn() {
		return createdOn;
	}
	public void setCreatedOn(Timestamp createdOn) {
		this.createdOn = createdOn;
	}
	public String getUpdatedBy() {
		return updatedBy;
	}
	public void setUpdatedBy(String updatedBy) {
		this.updatedBy = updatedBy;
	}
	public Timestamp getUpdatedOn() {
		return updatedOn;
	}
	public void setUpdatedOn(Timestamp updatedOn) {
		this.updatedOn = updatedOn;
	}
	public String getUploadedBy() {
		return uploadedBy;
	}
	public void setUploadedBy(String uploadedBy) {
		this.uploadedBy = uploadedBy;
	}
	public Timestamp getUploadedOn() {
		return uploadedOn;
	}
	public void setUploadedOn(Timestamp uploadedOn) {
		this.uploadedOn = uploadedOn;
	}

  
}
package com.devglan.model;


import javax.persistence.*;
import java.math.BigInteger;
import java.util.Date;
import java.sql.Timestamp;
import java.time.LocalDateTime;


@Entity
@Table(name = "cadre_shg_members")
public class CadreShgMembersEntity

{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "uid", nullable = false)
    private BigInteger uid;
    
    @Column(name = "cbo_id", nullable = false)
    private BigInteger cboId;
    @Column(name = "member_id", nullable = true)
    private BigInteger memberId;
    @Column(name = "cadre_guid")
    private String cadreGuid;
    @Column(name = "cadre_role_code", nullable = false)
    private Integer cadreRoleCode;
    @Column(name = "cadre_cat_code", nullable = false)
    private Integer  cadreCatCode;
    @Column(name = "date_joining", nullable = false)
    private Date dateJoining;
    @Column(name = "date_leaving")
    private Date dateLeaving;
    @Column(name = "created_by")
    private String  createdBy;
    @Column(name = "created_on")
    private Timestamp createdOn;
    @Column(name = "updated_by")
    private String  updatedBy;
    @Column(name = "updated_on")
    private  Timestamp  updatedOn;
    @Column(name = "uploaded_by")
    private String uploadedBy;
    @Column(name = "uploaded_on")
    private Timestamp uploadedOn;
    
    @Column(name = "member_guid")
    private  String memberGuid;
    @Column(name = "is_active")
    private  Boolean isActive;
    @Column(name = "is_edited")
    private  Integer isEdited;
    @Column(name = "is_complete")
    private  Integer isComplete;
    
	public BigInteger getUid() {
		return uid;
	}
	public void setUid(BigInteger uid) {
		this.uid = uid;
	}
	public BigInteger getCboId() {
		return cboId;
	}
	public void setCboId(BigInteger cboId) {
		this.cboId = cboId;
	}
	public BigInteger getMemberId() {
		return memberId;
	}
	public void setMemberId(BigInteger memberId) {
		this.memberId = memberId;
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
	public String getCadreGuid() {
		return cadreGuid;
	}
	public void setCadreGuid(String cadreGuid) {
		this.cadreGuid = cadreGuid;
	}
	public String getMemberGuid() {
		return memberGuid;
	}
	public void setMemberGuid(String memberGuid) {
		this.memberGuid = memberGuid;
	}
	public Boolean getIsActive() {
		return isActive;
	}
	public void setIsActive(Boolean isActive) {
		this.isActive = isActive;
	}
	public Integer getIsEdited() {
		return isEdited;
	}
	public void setIsEdited(Integer isEdited) {
		this.isEdited = isEdited;
	}
	public Integer getIsComplete() {
		return isComplete;
	}
	public void setIsComplete(Integer isComplete) {
		this.isComplete = isComplete;
	}

}
package com.devglan.domain;


import javax.validation.constraints.NotNull;
import java.math.BigInteger;
import java.sql.Date;
import java.sql.Timestamp;

public class CadreNonMembersModel {
    @NotNull
    private BigInteger uid;
    @NotNull
    private Integer villageId;
    @NotNull
    private String memberName;
    @NotNull
    private Integer cadreRoleCode;
    @NotNull
    private Integer cadreCatCode;
    @NotNull
    private Integer dateJoining;
    private Integer  dateLeaving;
    private String createdBy;
    private Integer createdOn;
    private String updatedBy;
    private Integer updatedOn;
    private String uploadedBy;
    private Integer uploadedOn;
    private String cadre_guid;
	

    public String getCadre_guid() {
		return cadre_guid;
	}

	public void setCadre_guid(String cadre_guid) {
		this.cadre_guid = cadre_guid;
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

    public Integer getDateJoining() {
        return dateJoining;
    }

    public void setDateJoining(Integer dateJoining) {
        this.dateJoining = dateJoining;
    }

    public Integer getDateLeaving() {
        return dateLeaving;
    }

    public void setDateLeaving(Integer dateLeaving) {
        this.dateLeaving = dateLeaving;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    public Integer getCreatedOn() {
        return createdOn;
    }

    public void setCreatedOn(Integer createdOn) {
        this.createdOn = createdOn;
    }

    public String getUpdatedBy() {
        return updatedBy;
    }

    public void setUpdatedBy(String updatedBy) {
        this.updatedBy = updatedBy;
    }

    public Integer getUpdatedOn() {
        return updatedOn;
    }

    public void setUpdatedOn(Integer updatedOn) {
        this.updatedOn = updatedOn;
    }

    public String getUploadedBy() {
        return uploadedBy;
    }

    public void setUploadedBy(String uploadedBy) {
        this.uploadedBy = uploadedBy;
    }

    public Integer getUploadedOn() {
        return uploadedOn;
    }

    public void setUploadedOn(Integer uploadedOn) {
        this.uploadedOn = uploadedOn;
    }
}

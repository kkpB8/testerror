package com.devglan.model;

import javax.persistence.*;
import java.math.BigInteger;
import java.sql.Timestamp;
import java.util.Date;

@Entity
@Table(name = "profile_master_data")
public class ProfileMasterDataEntity
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private BigInteger id;
    @Column(name = "cbo_id", nullable = false)
    private BigInteger cboId;
    @Column(name = "cbo_type", nullable = false)
    private Short cboType;
    @Column(name = "data")
    private String data;
    @Column(name = "created_by")
    private String createdBy;
    @Column(name = "created_on")

    private Timestamp createdOn;
    @Column(name = "updated_by")
    private String updatedBy;
    @Column(name = "updated_on")
    private Timestamp updatedOn;

	public BigInteger getId() {
		return id;
	}

	public void setId(BigInteger id) {
		this.id = id;
	}

	public BigInteger getCboId() {
		return cboId;
	}

	public void setCboId(BigInteger cboId) {
		this.cboId = cboId;
	}

	public Short getCboType() {
		return cboType;
	}

	public void setCboType(Short cboType) {
		this.cboType = cboType;
	}

	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
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


}
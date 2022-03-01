package com.devglan.model;


import javax.persistence.*;

import java.sql.Timestamp;

@Entity
@Table(name = "funding_agency_master")
public class FundingAgencyMasterEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "funding_agency_id", nullable = false)
    private Long fundingAgencyId;
    @Column(name = "agency_code")
    private String agencyCode;
    @Column(name = "agency_name", nullable = false)
    private String agencyName;
    @Column(name = "agency_name_language_id")
    private String agencyNameLanguage;
    @Column(name = "agency_type")
    private Short agencyType;
    @Column(name = "is_active", nullable = false)
    private Boolean isActive;
    @Column(name = "created_date", nullable = false)
    private Timestamp createdDate;
    @Column(name = "created_by", nullable = false)
    private Integer createdBy;
    @Column(name = "updated_date")
    private Timestamp updatedDate;
    @Column(name = "updated_by")
    private Integer updatedBy;

    public Long getFundingAgencyId() {
        return fundingAgencyId;
    }

    public void setFundingAgencyId(final Long fundingAgencyId) {
        this.fundingAgencyId = fundingAgencyId;
    }

    public String getAgencyCode() {
        return agencyCode;
    }

    public void setAgencyCode(final String agencyCode) {
        this.agencyCode = agencyCode;
    }

    public String getAgencyName() {
        return agencyName;
    }

    public void setAgencyName(final String agencyName) {
        this.agencyName = agencyName;
    }

    public String getAgencyNameLanguage() {
        return agencyNameLanguage;
    }

    public void setAgencyNameLanguage(final String agencyNameLanguage) {
        this.agencyNameLanguage = agencyNameLanguage;
    }

    public Short getAgencyType() {
        return agencyType;
    }

    public void setAgencyType(final Short agencyType) {
        this.agencyType = agencyType;
    }

    public Boolean getActive() {
        return isActive;
    }

    public void setActive(final Boolean active) {
        isActive = active;
    }


    public Integer getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(final Integer createdBy) {
        this.createdBy = createdBy;
    }


    public Integer getUpdatedBy() {
        return updatedBy;
    }

    public void setUpdatedBy(final Integer updatedBy) {
        this.updatedBy = updatedBy;
    }

	public Boolean getIsActive() {
		return isActive;
	}

	public void setIsActive(Boolean isActive) {
		this.isActive = isActive;
	}

	public Timestamp getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Timestamp createdDate) {
		this.createdDate = createdDate;
	}

	public Timestamp getUpdatedDate() {
		return updatedDate;
	}

	public void setUpdatedDate(Timestamp updatedDate) {
		this.updatedDate = updatedDate;
	}
    
    


}

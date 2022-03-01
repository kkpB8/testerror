package com.devglan.model;



import javax.persistence.*;
import java.math.BigInteger;
import java.sql.Timestamp;


@Entity
@Table(name = "village_master")
public class VillageMasterEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "village_id", nullable = false)
    private BigInteger villageId;
    @Column(name = "village_name_en", nullable = false)
    private String villageNameEnglish;
    @Column(name = "village_name_hi", nullable = false)
    private String villageNameHindi;
    @Column(name = "village_name_local", nullable = false)
    private String villageNameLocal;
    @Column(name = "village_code", nullable = false)
    private Integer villageCode;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "panchayat_id", nullable = false)
    private PanchayatMasterEntity panchayatMasterEntity;
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

    public BigInteger getVillageId() {
        return villageId;
    }

    public void setVillageId(final BigInteger villageId) {
        this.villageId = villageId;
    }

    public Integer getVillageCode() {
        return villageCode;
    }

    public void setVillageCode(final Integer villageCode) {
        this.villageCode = villageCode;
    }

    public Boolean getActive() {
        return isActive;
    }

    public void setActive(final
                          Boolean active) {
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

    public String getVillageNameEnglish() {
        return villageNameEnglish;
    }

    public void setVillageNameEnglish(String villageNameEnglish) {
        this.villageNameEnglish = villageNameEnglish;
    }

    public String getVillageNameHindi() {
        return villageNameHindi;
    }

    public void setVillageNameHindi(String villageNameHindi) {
        this.villageNameHindi = villageNameHindi;
    }

    public String getVillageNameLocal() {
        return villageNameLocal;
    }

    public void setVillageNameLocal(String villageNameLocal) {
        this.villageNameLocal = villageNameLocal;
    }

	public PanchayatMasterEntity getPanchayatMasterEntity() {
		return panchayatMasterEntity;
	}

	public void setPanchayatMasterEntity(PanchayatMasterEntity panchayatMasterEntity) {
		this.panchayatMasterEntity = panchayatMasterEntity;
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

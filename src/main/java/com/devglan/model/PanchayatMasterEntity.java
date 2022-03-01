package com.devglan.model;


import javax.persistence.*;
import java.math.BigInteger;
import java.sql.Timestamp;

@Entity
@Table(name = "panchayat_master")
public class PanchayatMasterEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "panchayat_id", nullable = false)
    private BigInteger panchayatId;
    @Column(name = "panchayat_name_en", nullable = false)
    private String panchayatNameEnglish;
    @Column(name = "panchayat_name_hi", nullable = false)
    private String panchayatNameHindi;
    @Column(name = "panchayat_name_local", nullable = false)
    private String panchayatNameLocal;
    @Column(name = "panchayat_code", nullable = false)
    private Integer panchayatCode;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "block_id", nullable = false)
    private BlockMasterEntity blockMasterEntity;
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

    public BigInteger getPanchayatId() {
        return panchayatId;
    }

    public void setPanchayatId(final BigInteger panchayatId) {
        this.panchayatId = panchayatId;
    }

    public Integer getPanchayatCode() {
        return panchayatCode;
    }

    public void setPanchayatCode(final Integer panchayatCode) {
        this.panchayatCode = panchayatCode;
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

    public String getPanchayatNameEnglish() {
        return panchayatNameEnglish;
    }

    public void setPanchayatNameEnglish(String panchayatNameEnglish) {
        this.panchayatNameEnglish = panchayatNameEnglish;
    }

    public String getPanchayatNameHindi() {
        return panchayatNameHindi;
    }

    public void setPanchayatNameHindi(String panchayatNameHindi) {
        this.panchayatNameHindi = panchayatNameHindi;
    }

    public String getPanchayatNameLocal() {
        return panchayatNameLocal;
    }

    public void setPanchayatNameLocal(String panchayatNameLocal) {
        this.panchayatNameLocal = panchayatNameLocal;
    }

	public BlockMasterEntity getBlockMasterEntity() {
		return blockMasterEntity;
	}

	public void setBlockMasterEntity(BlockMasterEntity blockMasterEntity) {
		this.blockMasterEntity = blockMasterEntity;
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

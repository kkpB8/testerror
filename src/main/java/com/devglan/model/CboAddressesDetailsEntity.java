package com.devglan.model;



import javax.persistence.*;
import java.math.BigInteger;
import java.sql.Timestamp;


@Entity
@Table(name = "cbo_addresses_details")
public class CboAddressesDetailsEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cbo_address_id", nullable = false)
    private BigInteger cboAddressId;
    @Column(name = "cbo_id", nullable = false)
    private BigInteger cboId;
    @Column(name = "address_guid")
    private String addressGuid;
    @Column(name = "cbo_guid")
    private String cboGuid;
    @Column(name = "address_type")
    private Short addressType;
    @Column(name = "cbo_type", nullable = false)
    private Short cboType;
    @Column(name = "urban_rural")
    private String urbanRural;
    @Column(name = "address_line1", nullable = false)
    private String addressLine1;
    @Column(name = "address_line2")
    private String addressLine2;
    @Column(name = "city_town")
    private String cityTown;
    @Column(name = "landmark")
    private String landmark;
    @Column(name = "village_id", nullable = false)
    private Integer villageId;
    @Column(name = "panchayat_id", nullable = false)
    private Integer panchayatId;
    @Column(name = "block_id", nullable = false)
    private Integer blockId;
    @Column(name = "district_id", nullable = false)
    private Integer districtId;
    @Column(name = "state_id", nullable = false)
    private Integer stateId;
    @Column(name = "postal_code", nullable = false)
    private String postalCode;
    @Column(name = "status")
    private Short status;
    @Column(name = "is_active", nullable = false)
    private Boolean isActive;
    @Column(name = "entry_source", nullable = false)
    private Short entrySource;
    @Column(name = "is_edited", nullable = false)
    private Integer isEdited;
    @Column(name = "created_date", nullable = false)
    private Timestamp createdDate;
    @Column(name = "created_by", nullable = false)
    private String createdBy;
    @Column(name = "last_uploaded_date")
    private Timestamp lastUploadedDate;
    @Column(name = "uploaded_by")
    private String uploadedBy;
    @Column(name = "updated_date")
    private Timestamp updatedDate;
    @Column(name = "updated_by")
    private String updatedBy;
    //@satwant06052021
    @Column(name = "is_verified")
    private Integer isVerified;
    @Column(name = "is_complete")
    private Integer isComplete;


    public CboAddressesDetailsEntity() {
        super();
    }

    public BigInteger getCboAddressId() {
        return cboAddressId;
    }

    public void setCboAddressId(final BigInteger cboAddressId) {
        this.cboAddressId = cboAddressId;
    }

    public BigInteger getCboId() {
        return cboId;
    }

    public void setCboId(BigInteger cboId) {
        this.cboId = cboId;
    }

    public Short getAddressType() {
        return addressType;
    }

    public void setAddressType(final Short addressType) {
        this.addressType = addressType;
    }

    public Short getCboType() {
        return cboType;
    }

    public void setCboType(final Short cboType) {
        this.cboType = cboType;
    }
    public String getAddressLine1() {
        return addressLine1;
    }

    public void setAddressLine1(final String addressLine1) {
        this.addressLine1 = addressLine1;
    }

    public String getAddressLine2() {
        return addressLine2;
    }

    public void setAddressLine2(final String addressLine2) {
        this.addressLine2 = addressLine2;
    }


    public String getLandmark() {
        return landmark;
    }

    public void setLandmark(final String landmark) {
        this.landmark = landmark;
    }



    public Boolean getActive() {
        return isActive;
    }

    public void setActive(final Boolean active) {
        isActive = active;
    }

    public Timestamp getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(final Timestamp createdDate) {
        this.createdDate = createdDate;
    }


    public Timestamp getUpdatedDate() {
        return updatedDate;
    }

    public void setUpdatedDate(final Timestamp updatedDate) {
        this.updatedDate = updatedDate;
    }

    public Integer getVillageId() {
        return villageId;
    }

    public void setVillageId(final Integer villageId) {
        this.villageId = villageId;
    }

    public Integer getPanchayatId() {
        return panchayatId;
    }

    public void setPanchayatId(final Integer panchayatId) {
        this.panchayatId = panchayatId;
    }

    public Integer getBlockId() {
        return blockId;
    }

    public void setBlockId(final Integer blockId) {
        this.blockId = blockId;
    }

    public Integer getDistrictId() {
        return districtId;
    }

    public void setDistrictId(final Integer districtId) {
        this.districtId = districtId;
    }

    public Integer getStateId() {
        return stateId;
    }

    public void setStateId(final Integer stateId) {
        this.stateId = stateId;
    }

    public String getUrbanRural() {
        return urbanRural;
    }

    public void setUrbanRural(final String urbanRural) {
        this.urbanRural = urbanRural;
    }

    public String getCityTown() {
        return cityTown;
    }

    public void setCityTown(final String cityTown) {
        this.cityTown = cityTown;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(final String postalCode) {
        this.postalCode = postalCode;
    }

    public Short getEntrySource() {
        return entrySource;
    }

    public void setEntrySource(final Short entrySource) {
        this.entrySource = entrySource;
    }

    public Integer getIsEdited() {
        return isEdited;
    }

    public void setIsEdited(final Integer isEdited) {
        this.isEdited = isEdited;
    }

    public Timestamp getLastUploadedDate() {
        return lastUploadedDate;
    }

    public void setLastUploadedDate(final Timestamp lastUploadedDate) {
        this.lastUploadedDate = lastUploadedDate;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(final String createdBy) {
        this.createdBy = createdBy;
    }

    public String getUploadedBy() {
        return uploadedBy;
    }

    public void setUploadedBy(final String uploadedBy) {
        this.uploadedBy = uploadedBy;
    }

    public String getUpdatedBy() {
        return updatedBy;
    }

    public void setUpdatedBy(final String updatedBy) {
        this.updatedBy = updatedBy;
    }

    public String getAddressGuid() {
        return addressGuid;
    }

    public void setAddressGuid(final String addressGuid) {
        this.addressGuid = addressGuid;
    }

    public String getCboGuid() {
        return cboGuid;
    }

    public void setCboGuid(final String cboGuid) {
        this.cboGuid = cboGuid;
    }

    public Short getStatus() {
        return status;
    }

    public void setStatus(final Short status) {
        this.status = status;
    }

    public Integer getIsVerified() {
        return isVerified;
    }

    public void setIsVerified(Integer isVerified) {
        this.isVerified = isVerified;
    }

    public Integer getIsComplete() {
        return isComplete;
    }

    public void setIsComplete(Integer isComplete) {
        this.isComplete = isComplete;
    }
}

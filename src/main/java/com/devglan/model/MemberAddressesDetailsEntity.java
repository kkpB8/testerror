package com.devglan.model;




import javax.persistence.*;
import java.math.BigInteger;
import java.sql.Timestamp;

@Entity
@Table(name = "member_address")
public class MemberAddressesDetailsEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "member_address_id", nullable = false)
    private BigInteger memberAddressId;
   /* @EmbeddedId
    private MemberAddressIdentity memberAddressIdentity;*/

    @Column(name = "member_guid")
    private String memberGUID;
   @Column(name = "address_guid", nullable = false)
   private String addressGUID;
    @Column(name = "cbo_id")
    private BigInteger cboId;
    @Column(name = "member_code")
    private BigInteger memberCode;
    @Column(name = "address_type")
    private Short addressType;
    @Column(name = "address_line1", nullable = false)
    private String addressLine1;
    @Column(name = "address_line2")
    private String addressLine2;
    @Column(name = "village" , nullable = false)
    private Integer village;
    @Column(name = "block_id" , nullable = false)
    private Integer block_id;
    @Column(name = "panchayat_id" , nullable = false)
    private Integer panchayat_id;
    @Column(name = "landmark")
    private Integer landmark;
    @Column(name = "state", nullable = false)
    private Integer state;
    @Column(name = "district", nullable = false)
    private Integer district;
    @Column(name = "postal_code", nullable = false)
    private Integer postalCode;
    @Column(name = "status")
    private Short status;
    @Column(name = "entry_source", nullable = false)
    private Short entrySource;
    @Column(name = "is_edited", nullable = false)
    private Integer isEdited;
    @Column(name = "is_active", nullable = false)
    private Boolean isActive;
    @Column(name = "last_uploaded_date")

    private Timestamp lastUploadedDate;
    @Column(name = "created_date", nullable = false)

    private Timestamp createdDate;
    @Column(name = "created_by", nullable = false)
    private String createdBy;
    @Column(name = "updated_date")

    private Timestamp updatedDate;
    @Column(name = "updated_by")
    private String updatedBy;

	@Column(name = "address_location")
    private Short addressLocation;

    //@satwant06052021
    @Column(name = "is_verified")
    private Integer isVerified;

    @Column(name = "is_complete")
    private Integer isComplete;

    public MemberAddressesDetailsEntity() {
        super();
    }

    public BigInteger getMemberAddressId() {
        return memberAddressId;
    }

    public void setMemberAddressId(final BigInteger memberAddressId) {
        this.memberAddressId = memberAddressId;
    }

    public String getAddressGUID() {
        return addressGUID;
    }

    public void setAddressGUID(final String addressGUID) {
        this.addressGUID = addressGUID;
    }

    public BigInteger getMemberCode() {
        return memberCode;
    }

    public void setMemberCode(final BigInteger memberCode) {
        this.memberCode = memberCode;
    }

    public Short getAddressType() {
        return addressType;
    }

    public void setAddressType(final Short addressType) {
        this.addressType = addressType;
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

    public Integer getVillage() {
        return village;
    }

    public void setVillage(final Integer village) {
        this.village = village;
    }

    public Integer getLandmark() {
        return landmark;
    }

    public void setLandmark(final Integer landmark) {
        this.landmark = landmark;
    }

    public Integer getState() {
        return state;
    }

    public void setState(final Integer state) {
        this.state = state;
    }

    public Integer getDistrict() {
        return district;
    }

    public void setDistrict(final Integer district) {
        this.district = district;
    }

    public Integer getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(final Integer postalCode) {
        this.postalCode = postalCode;
    }

    public Short getStatus() {
        return status;
    }

    public void setStatus(final Short status) {
        this.status = status;
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

    public Boolean getActive() {
        return isActive;
    }

    public void setActive(final Boolean active) {
        isActive = active;
    }

    public Timestamp getLastUploadedDate() {
        return lastUploadedDate;
    }

    public void setLastUploadedDate(final Timestamp lastUploadedDate) {
        this.lastUploadedDate = lastUploadedDate;
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

    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(final String createdBy) {
        this.createdBy = createdBy;
    }

    public String getUpdatedBy() {
        return updatedBy;
    }

    public void setUpdatedBy(final String updatedBy) {
        this.updatedBy = updatedBy;
    }

    public String getMemberGUID() {
        return memberGUID;
    }

    public void setMemberGUID(final String memberGUID) {
        this.memberGUID = memberGUID;
    }

    public BigInteger getCboId() {
        return cboId;
    }

    public void setCboId(final BigInteger cboId) {
        this.cboId = cboId;
    }

    public Integer getBlock_id() {
        return block_id;
    }

    public void setBlock_id(final Integer block_id) {
        this.block_id = block_id;
    }

    public Integer getPanchayat_id() {
        return panchayat_id;
    }

    public void setPanchayat_id(final Integer panchayat_id) {
        this.panchayat_id = panchayat_id;
    }
	
	 public Short getAddressLocation() {
        return addressLocation;
    }

    public void setAddressLocation(Short addressLocation) {
        this.addressLocation = addressLocation;
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

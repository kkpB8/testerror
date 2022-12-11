package com.devglan.model;



import javax.persistence.*;
import java.math.BigInteger;
import java.sql.Timestamp;
import java.util.Date;

@Entity
@Table(name = "cbo_kyc_details")
public class CboKYCDetailsEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cbo_kyc_details_id", nullable = false)
    private BigInteger cboKYCDetailsId;
    @Column(name = "cbo_guid")
    private String cboGuid;
    @Column(name = "kyc_guid")
    private String kycGuid;
    @Column(name = "cbo_id", nullable = false)
    private BigInteger cboId;
    @Column(name = "kyc_type", nullable = false)
    private Integer kycType;
    @Column(name = "kyc_number", nullable = false)
    private String kycNumber;
    @Column(name = "document_id", nullable = false)
    private BigInteger documentId;
    @Column(name = "kyc_valid_from")
    private Date kycValidFrom;
    @Column(name = "kyc_valid_to")
    private Date kycValidTo;
    @Column(name = "status")
    private Short status;
    @Column(name = "dedupl_status")
    private Short deduplicationStatus;
    @Column(name = "activation_status")
    private Short activationStatus;
    @Column(name = "is_active", nullable = false)
    private Boolean isActive;
    @Column(name = "entry_source", nullable = false)
    private Short entrySource;
    @Column(name = "is_edited", nullable = false)
    private Integer isEdited;
    @Column(name = "last_uploaded_date")

    private Timestamp lastUploadedDate;
    @Column(name = "uploaded_by")
    private String uploadedBy;
    @Column(name = "created_date", nullable = false)

    private Timestamp createdDate;
    @Column(name = "created_by", nullable = false)
    private String createdBy;
    @Column(name = "updated_date")

    private Timestamp updatedDate;
    @Column(name = "updated_by")
    private String updatedBy;
    @Column(name = "cbo_type")
    private Short cboType;
    //@satwant06052021
    @Column(name = "is_verified")
    private Integer isVerified;

    @Column(name = "is_complete")
    private Integer isComplete;

    //30/06/2022@anshul
    @Column(name = "kyc_front_doc_orig_name")
    private String kycFrontDocOrigName;




    public static Integer kycRegistrationNo = 1;
    public static Integer kycTANNo = 2;
    public static Integer kycPANNo = 3;


    public CboKYCDetailsEntity() {
    }

    public String getKycNumber() {
        return kycNumber;
    }

    public void setKycNumber(final String kycNumber) {
        this.kycNumber = kycNumber;
    }

    public Timestamp getUpdatedDate() {
        return updatedDate;
    }

    public void setUpdatedDate(final Timestamp updatedDate) {
        this.updatedDate = updatedDate;
    }


    public Timestamp getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(final Timestamp createdDate) {
        this.createdDate = createdDate;
    }

    public BigInteger getCboKYCDetailsId() {
        return cboKYCDetailsId;
    }

    public void setCboKYCDetailsId(final BigInteger cboKYCDetailsId) {
        this.cboKYCDetailsId = cboKYCDetailsId;
    }

    public Integer getKycType() {
        return kycType;
    }

    public void setKycType(Integer kycType) {
        this.kycType = kycType;
    }

    public BigInteger getDocumentId() {
        return documentId;
    }

    public void setDocumentId(BigInteger documentId) {
        this.documentId = documentId;
    }

    public BigInteger getCboId() {
        return cboId;
    }

    public void setCboId(BigInteger cboId) {
        this.cboId = cboId;
    }

    public Boolean getActive() {
        return isActive;
    }

    public void setActive(final Boolean active) {
        isActive = active;
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

    public String getUploadedBy() {
        return uploadedBy;
    }

    public void setUploadedBy(final String uploadedBy) {
        this.uploadedBy = uploadedBy;
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

    public String getCboGuid() {
        return cboGuid;
    }

    public void setCboGuid(final String cboGuid) {
        this.cboGuid = cboGuid;
    }

    public String getKycGuid() {
        return kycGuid;
    }

    public void setKycGuid(final String kycGuid) {
        this.kycGuid = kycGuid;
    }

    public Date getKycValidFrom() {
        return kycValidFrom;
    }

    public void setKycValidFrom(final Date kycValidFrom) {
        this.kycValidFrom = kycValidFrom;
    }

    public Date getKycValidTo() {
        return kycValidTo;
    }

    public void setKycValidTo(final Date kycValidTo) {
        this.kycValidTo = kycValidTo;
    }

    public Short getStatus() {
        return status;
    }

    public void setStatus(final Short status) {
        this.status = status;
    }

    public Short getDeduplicationStatus() {
        return deduplicationStatus;
    }

    public void setDeduplicationStatus(final Short deduplicationStatus) {
        this.deduplicationStatus = deduplicationStatus;
    }

    public Short getActivationStatus() {
        return activationStatus;
    }

    public void setActivationStatus(final Short activationStatus) {
        this.activationStatus = activationStatus;
    }

    public Short getCboType() {
        return cboType;
    }

    public void setCboType(final Short cboType) {
        this.cboType = cboType;
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

    public String getKycFrontDocOrigName() {
        return kycFrontDocOrigName;
    }

    public void setKycFrontDocOrigName(String kycFrontDocOrigName) {
        this.kycFrontDocOrigName = kycFrontDocOrigName;
    }
    
}

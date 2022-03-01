package com.devglan.model;



import javax.persistence.*;
import java.math.BigInteger;
import java.sql.Timestamp;
import java.util.Date;

@Entity
@Table(name = "member_kyc_details")
public class MemberKYCDetailsEntity {

    /*@EmbeddedId
    private org.apache.fineract.cn.group.internal.repository.MemberKYCIdentity memberKYCIdentity;*/
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "member_kyc_details_id", nullable = false)
    private BigInteger memberKycDetailsId;
    @Column(name = "kyc_guid", nullable = false)
    private String kycGUID;
    @Column(name = "member_code")
    private BigInteger memberCode;
    @Column(name = "member_guid")
    private String memberGUID;
     @Column(name = "kyc_type", nullable = false)
    private Integer kycType;
     @Column(name = "kyc_number", nullable = false)
    private String kycNumber;
     @Column(name = "document_id")
    private Integer documentId;
    @Column(name = "kyc_valid_from", nullable = false)
    //@Convert(converter = TimestampConverter.class)
    private Date kycValidFrom;
    @Column(name = "kyc_valid_to", nullable = false)
    //@Convert(converter = TimestampConverter.class)
    private Date kycValidTo;
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
    @Column(name = "cbo_id")
    private BigInteger cboId;
    @Column(name = "dedupl_status")
    private Short deduplStatus;
    @Column(name = "activation_status")
    private Short activationStatus;
    @Column(name = "kyc_front_doc_orig_name")
    private String kycFrontDocOriginalName;
    @Column(name = "kyc_rear_doc_orig_name")
    private String kycRearDocOriginalName;

    @Column(name = "kyc_front_doc_id")
    private BigInteger kycFrontDocId;
    @Column(name = "kyc_rear_doc_id")
    private BigInteger kycRearDocId;
    //@satwant06052021
    @Column(name = "is_verified")
    private Integer isVerified;

    @Column(name = "is_complete")
    private Integer isComplete;

    public static Integer kycAdhaar = 2;
    public static Integer kycElectionId = 1;
    public static Integer kycAdhaarRear = 4;
    public static Integer kycElectionIdRear = 3;


    public BigInteger getCboId() {
        return cboId;
    }

    public void setCboId(BigInteger cboId) {
        this.cboId = cboId;
    }

    public MemberKYCDetailsEntity() {
    }

    public BigInteger getMemberKycDetailsId() {
        return memberKycDetailsId;
    }

    public void setMemberKycDetailsId(final BigInteger memberKycDetailsId) {
        this.memberKycDetailsId = memberKycDetailsId;
    }

    public String getKycGUID() {
        return kycGUID;
    }

    public void setKycGUID(final String kycGUID) {
        this.kycGUID = kycGUID;
    }

    public BigInteger getMemberCode() {
        return memberCode;
    }

    public void setMemberCode(final BigInteger memberCode) {
        this.memberCode = memberCode;
    }

    public Integer getKycType() {
        return kycType;
    }

    public void setKycType(final Integer kycType) {
        this.kycType = kycType;
    }

    public String getKycNumber() {
        return kycNumber;
    }

    public void setKycNumber(final String kycNumber) {
        this.kycNumber = kycNumber;
    }

    public Integer getDocumentId() {
        return documentId;
    }

    public void setDocumentId(final Integer documentId) {
        this.documentId = documentId;
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

    public Short getEntrySource() {
        return entrySource;
    }

    public void setEntrySource(Short entrySource) {
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

    public String getUploadedBy() {
        return uploadedBy;
    }

    public void setUploadedBy(final String uploadedBy) {
        this.uploadedBy = uploadedBy;
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

    public void setMemberGUID(String memberGUID) {
        this.memberGUID = memberGUID;
    }

    public Short getDeduplStatus() {
        return deduplStatus;
    }

    public void setDeduplStatus(Short deduplStatus) {
        this.deduplStatus = deduplStatus;
    }

    public Short getActivationStatus() {
        return activationStatus;
    }

    public void setActivationStatus(Short activationStatus) {
        this.activationStatus = activationStatus;
    }

    public String getKycFrontDocOriginalName() {
        return kycFrontDocOriginalName;
    }

    public void setKycFrontDocOriginalName(final String kycFrontDocOriginalName) {
        this.kycFrontDocOriginalName = kycFrontDocOriginalName;
    }

    public String getKycRearDocOriginalName() {
        return kycRearDocOriginalName;
    }

    public void setKycRearDocOriginalName(final String kycRearDocOriginalName) {
        this.kycRearDocOriginalName = kycRearDocOriginalName;
    }

    public BigInteger getKycFrontDocId() {
        return kycFrontDocId;
    }

    public void setKycFrontDocId(final BigInteger kycFrontDocId) {
        this.kycFrontDocId = kycFrontDocId;
    }

    public BigInteger getKycRearDocId() {
        return kycRearDocId;
    }

    public void setKycRearDocId(final BigInteger kycRearDocId) {
        this.kycRearDocId = kycRearDocId;
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

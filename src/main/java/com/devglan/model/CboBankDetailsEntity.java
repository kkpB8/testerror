package com.devglan.model;




import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.math.BigInteger;
import java.sql.Timestamp;
import java.util.Date;

@Entity
@Table(name = "cbo_bank_details")
public class CboBankDetailsEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cbo_bank_id", nullable = false)
    private BigInteger cboBankId;
    @Column(name = "bank_guid")
    private String bankGuid;
    @Column(name = "cbo_guid")
    private String cboGuid;
    @Column(name = "cbo_id", nullable = false)
    private BigInteger cboId;
    @Column(name = "account_no", nullable = false)
    private String accountNo;
    @Column(name = "bank_id", nullable = false)
    private Integer bankId;
    @Column(name = "account_opening_date")
    private Date accountOpeningDate;
    @Column(name = "account_linkage_date")
    private Date accountLinkageDate;
    @Column(name = "bank_code")
    private String bankCode;
    @Column(name = "bank_branch")
    private String bankBranch;
    @Column(name = "bank_branch_id", nullable = false)
    private BigInteger bankBranchId;
    @Column(name = "ifsc_code", nullable = false)
    private String ifscCode;
    @Column(name = "is_default", nullable = false)
    private Boolean isDefault;
    @Column(name = "sequence_no", nullable = false)
    private Integer sequenceNo;
    @Column(name = "account_type")
    private String accountType;
    @Column(name = "verification")
    private Integer verification;
    @Column(name = "closure_date")
    private Date closureDate;
    @Column(name = "dedupl_status")
    private Short deduplicationStatus;
    @Column(name = "cbo_type")
    private Short cboType;
    @Column(name = "activation_status")
    private Short activationStatus;
    @Column(name = "bankpassbook_name")
    private String bankpassbookName;
    @Column(name = "passbook_firstpage")
    private String passbookFirstpage;
    @Column(name = "status")
    private Short status;
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

    @Column(name = "bank_document_id")
    private BigInteger bankDocumentId;
	
	//02-04-21 mohit
	/*
	 * @Column(name = "identify_duplicate") private String identifyDuplicate;
	 */
    @Column(name = "npci_status")
    private Short npciStatus;
    //@satwant06052021
    @Column(name = "is_verified")
    private Integer isVerified;

    @Column(name = "is_complete")
    private Integer isComplete;

    @Column(name = "inactive_date")
    private Date inactiveDate ;

    public String getBankCode() {
        return bankCode;
    }

    public void setBankCode(final String bankCode) {
        this.bankCode = bankCode;
    }

    public String getBankBranch() {
        return bankBranch;
    }

    public void setBankBranch(final String bankBranch) {
        this.bankBranch = bankBranch;
    }

    public String getIfscCode() {
        return ifscCode;
    }

    public void setIfscCode(final String ifscCode) {
        this.ifscCode = ifscCode;
    }

    public Boolean getDefault() {
        return isDefault;
    }

    public void setDefault(final Boolean aDefault) {
        isDefault = aDefault;
    }

    public Integer getSequenceNo() {
        return sequenceNo;
    }

    public void setSequenceNo(final Integer sequenceNo) {
        this.sequenceNo = sequenceNo;
    }

    public Integer getVerification() {
        return verification;
    }

    public void setVerification(final Integer verification) {
        this.verification = verification;
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

    public BigInteger getCboBankId() {
        return cboBankId;
    }

    public void setCboBankId(final BigInteger cboBankId) {
        this.cboBankId = cboBankId;
    }

    public BigInteger getCboId() {
        return cboId;
    }

    public void setCboId(BigInteger cboId) {
        this.cboId = cboId;
    }

    public BigInteger getBankBranchId() {
        return bankBranchId;
    }

    public void setBankBranchId(BigInteger bankBranchId) {
        this.bankBranchId = bankBranchId;
    }

    public String getAccountNo() {
        return accountNo;
    }

    public void setAccountNo(final String accountNo) {
        this.accountNo = accountNo;
    }

    public Integer getBankId() {
        return bankId;
    }

    public void setBankId(final Integer bankId) {
        this.bankId = bankId;
    }

    public String getAccountType() {
        return accountType;
    }

    public void setAccountType(final String accountType) {
        this.accountType = accountType;
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

    public String getBankGuid() {
        return bankGuid;
    }

    public void setBankGuid(final String bankGuid) {
        this.bankGuid = bankGuid;
    }

    public String getCboGuid() {
        return cboGuid;
    }

    public void setCboGuid(final String cboGuid) {
        this.cboGuid = cboGuid;
    }

    public String getBankpassbookName() {
        return bankpassbookName;
    }

    public void setBankpassbookName(final String bankpassbookName) {
        this.bankpassbookName = bankpassbookName;
    }

    public String getPassbookFirstpage() {
        return passbookFirstpage;
    }

    public void setPassbookFirstpage(final String passbookFirstpage) {
        this.passbookFirstpage = passbookFirstpage;
    }

    public Short getStatus() {
        return status;
    }

    public void setStatus(final Short status) {
        this.status = status;
    }

    public Date getAccountOpeningDate() {
        return accountOpeningDate;
    }

    public void setAccountOpeningDate(final Date accountOpeningDate) {
        this.accountOpeningDate = accountOpeningDate;
    }

    public Date getAccountLinkageDate() {
        return accountLinkageDate;
    }

    public void setAccountLinkageDate(final Date accountLinkageDate) {
        this.accountLinkageDate = accountLinkageDate;
    }

    public Date getClosureDate() {
        return closureDate;
    }

    public void setClosureDate(final Date closureDate) {
        this.closureDate = closureDate;
    }

    public Short getCboType() {
        return cboType;
    }

    public void setCboType(final Short cboType) {
        this.cboType = cboType;
    }

    public BigInteger getBankDocumentId() {
        return bankDocumentId;
    }

    public void setBankDocumentId(final BigInteger bankDocumentId) {
        this.bankDocumentId = bankDocumentId;
    }
	
	

    public Short getNpciStatus() {
        return npciStatus;
    }

    public void setNpciStatus(final Short npciStatus) {
        this.npciStatus = npciStatus;
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

    public Date getInactiveDate() {
        return inactiveDate;
    }

    public void setInactiveDate(Date inactiveDate) {
        this.inactiveDate = inactiveDate;
    }
}

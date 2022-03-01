package com.devglan.model;



import javax.persistence.*;
import java.math.BigInteger;
import java.sql.Timestamp;
import java.util.Date;

@Entity
@Table(name = "member_bank_details")
public class MemberBankDetailsEntity {

    /*@EmbeddedId
    private org.apache.fineract.cn.group.internal.repository.MemberBankIdentity memberBankIdentity;*/
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "member_bank_details_id", nullable = false)
    private BigInteger memberBankDetailsId;
    @Column(name = "bank_guid", nullable = false)
    private String bankGUID;
    @Column(name = "member_guid")
    private String memberGUID;
    @Column(name = "member_code")
    private BigInteger memberCode;
    @Column(name = "account_no", nullable = false)
    private String accountNo;
    @Column(name = "bank_id", nullable = false)
    private BigInteger bankId;
    @Column(name = "account_type", nullable = false)
    private Short accountType;
    @Column(name = "mem_branch_code", nullable = false)
    private String memBranchCode;
    @Column(name = "ifsc_code", nullable = false)
    private String ifscCode;

    /* @Column(name = "lgd_reference")
     private String lgdReference;*/
    @Column(name = "account_open_date", nullable = false)
    private Date accountOpenDate;
    @Column(name = "is_default_account", nullable = false)
    private Integer isDefaultAccount;
    @Column(name = "status")
    private Short status;
    @Column(name = "closing_date")
   // @Convert(converter = TimestampConverter.class)
    private Date closingDate;
    @Column(name = "gl_code")
    private String glCode;
    @Column(name = "same_As_Group")
    private Integer sameAsGroup;
    @Column(name = "entry_source", nullable = false)
    private Short entrySource;
    @Column(name = "is_edited", nullable = false)
    private Integer isEdited;
    @Column(name = "is_active", nullable = false)
    private Boolean isActive;
    @Column(name = "last_uploaded_date", nullable = false)

    private Timestamp lastUploadedDate;
    @Column(name = "uploaded_by", nullable = false)
    private String uploadedBy;
    @Column(name = "created_date", nullable = false)

    private Timestamp createdDate;
    @Column(name = "created_by", nullable = false)
    private String createdBy;
    @Column(name = "updated_date")

    private Timestamp updatedDate;
    @Column(name = "updated_by")
    private String updatedBy;

    @Column(name = "activation_status")
    private Short activationStatus;
    @Column(name = "dedupl_status")
    private Short deduplStatus;
    @Column(name = "cbo_id")
    private BigInteger cboId;
    @Column(name = "bank_passbook_name")
    private String bankPassbookName;
    @Column(name = "passbook_first_page")
    private String passbookFirstPage;

    @Column(name = "mem_bank_doc_id")
    private BigInteger memberBankDocumentId;
	
	
	
    //02-04-21 mohit
    @Column(name = "identified_duplicates")
    private String identifyDuplicate;
    @Column(name = "npci_status")
    private Short npciStatus;
    //@satwant06052021
    @Column(name = "is_verified")
    private Integer isVerified;

    @Column(name = "is_complete")
    private Integer isComplete;

    public String getBankPassbookName() {
        return bankPassbookName;
    }

    public void setBankPassbookName(final String bankPassbookName) {
        this.bankPassbookName = bankPassbookName;
    }

    public String getPassbookFirstPage() {
        return passbookFirstPage;
    }

    public void setPassbookFirstPage(final String passbookFirstPage) {
        this.passbookFirstPage = passbookFirstPage;
    }

    public BigInteger getCboId() {
        return cboId;
    }

    public void setCboId(final BigInteger cboId) {
        this.cboId = cboId;
    }
    public BigInteger getMemberBankDetailsId() {
        return memberBankDetailsId;
    }

    public void setMemberBankDetailsId(final BigInteger memberBankDetailsId) {
        this.memberBankDetailsId = memberBankDetailsId;
    }

    public String getBankGUID() {
        return bankGUID;
    }

    public void setBankGUID(final String bankGUID) {
        this.bankGUID = bankGUID;
    }

    public BigInteger getMemberCode() {
        return memberCode;
    }

    public void setMemberCode(final BigInteger memberCode) {
        this.memberCode = memberCode;
    }

    public String getAccountNo() {
        return accountNo;
    }

    public void setAccountNo(String accountNo) {
        this.accountNo = accountNo;
    }

    public Short getDeduplStatus() {
        return deduplStatus;
    }

    public void setDeduplStatus(Short deduplStatus) {
        this.deduplStatus = deduplStatus;
    }

    public BigInteger getBankId() {
        return bankId;
    }

    public void setBankId(final BigInteger bankId) {
        this.bankId = bankId;
    }


    public Short getAccountType() {
        return accountType;
    }

    public void setAccountType(final Short accountType) {
        this.accountType = accountType;
    }

   /* public String getLgdReference() {
        return lgdReference;
    }

    public void setLgdReference(final String lgdReference) {
        this.lgdReference = lgdReference;
    }*/

    public Date getAccountOpenDate() {
        return accountOpenDate;
    }

    public void setAccountOpenDate(final Date accountOpenDate) {
        this.accountOpenDate = accountOpenDate;
    }

    public Integer getIsDefaultAccount() {
        return isDefaultAccount;
    }

    public void setIsDefaultAccount(final Integer isDefaultAccount) {
        this.isDefaultAccount = isDefaultAccount;
    }

    public Short getStatus() {
        return status;
    }

    public void setStatus(final Short status) {
        this.status = status;
    }

    public Date getClosingDate() {
        return closingDate;
    }

    public void setClosingDate(final Date closingDate) {
        this.closingDate = closingDate;
    }

    public String getGlCode() {
        return glCode;
    }

    public void setGlCode(final String glCode) {
        this.glCode = glCode;
    }

    public Integer getSameAsGroup() {
        return sameAsGroup;
    }

    public void setSameAsGroup(final Integer sameAsGroup) {
        this.sameAsGroup = sameAsGroup;
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

    public Short getActivationStatus() {
        return activationStatus;
    }

    public void setActivationStatus(Short activationStatus) {
        this.activationStatus = activationStatus;
    }

    public Short getDedupStatus() {
        return deduplStatus;
    }

    public void setDedupStatus(Short deduplStatus) {
        this.deduplStatus = deduplStatus;
    }

    public String getMemberGUID() {
        return memberGUID;
    }

    public void setMemberGUID(String memberGUID) {
        this.memberGUID = memberGUID;
    }

    public String getMemBranchCode() {
        return memBranchCode;
    }

    public void setMemBranchCode(String memBranchCode) {
        this.memBranchCode = memBranchCode;
    }

    public String getIfscCode() {
        return ifscCode;
    }

    public void setIfscCode(String ifscCode) {
        this.ifscCode = ifscCode;
    }

    public BigInteger getMemberBankDocumentId() {
        return memberBankDocumentId;
    }

    public void setMemberBankDocumentId(final BigInteger memberBankDocumentId) {
        this.memberBankDocumentId = memberBankDocumentId;
    }
	
	 public String getIdentifyDuplicate() {
        return identifyDuplicate;
    }

    public void setIdentifyDuplicate(final String identifyDuplicate) {
        this.identifyDuplicate = identifyDuplicate;
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
}

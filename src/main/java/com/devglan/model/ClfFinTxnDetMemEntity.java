package com.devglan.model;

import javax.persistence.*;
import java.math.BigInteger;
import java.sql.Timestamp;
import java.util.Date;

@Entity
@Cacheable(value = false)
@Table(name="clf_fin_txn_det_mem")
public class ClfFinTxnDetMemEntity {
    @Id
    @Column(name = "uid", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private BigInteger uid;
    @Column(name = "mtg_uid")
    private BigInteger mtgUid;
    @Column(name = "cbo_id")
    private BigInteger cboId;
    @Column(name = "guid", nullable = false)
    private String guid;
    @Column(name = "vo_id", nullable = false)
    private BigInteger voId;
    @Column(name = "shg_id", nullable = false)
    private BigInteger shgId;
    @Column(name = "organization_type")
    private Short organizationType;
    @Column(name = "organization_name")
    private String organizationName;
    @Column(name="organization_id", nullable = true)
    private BigInteger organizationId;
    @Column(name = "mtg_no")
    private Integer mtgNo;
    @Column(name = "txn_date", nullable = false)
    private Date txnDate1;
    @Column(name = "auid", nullable = false)
    private Integer auid;
    @Column(name = "type")
    private String type;
    @Column(name = "amount")
    private Integer amount;
    @Column(name = "date_realisation")
    private Date dateRealisation1;
    @Column(name = "mode_payment")
    private Short modePayment;
    @Column(name = "bank_code")
    private String bankCode;
    @Column(name = "transaction_no")
    private String transactionNo;
    @Column(name = "voucher_number")
    private String voucherNumber;
    @Column(name = "voucher_date")
    private Date voucherDate1;
    @Column(name = "narration")
    private String narration;
    @Column(name = "add_lref_date", nullable = false)
    private Date addlRefDate1;
    @Column(name = "created_by")
    private String createdBy;
    @Column(name = "created_on")
    private Date createdOn1;
    @Column(name = "updated_by")
    private String updatedBy;
    @Column(name = "updated_on")
    private Date updatedOn1;
    @Column(name = "reference_mtg_no")
    private Integer referenceMtgNo;
    @Column(name = "payee_bank_id")
    private String payeeBankId;
    @Column(name = "payee_branch_id")
    private String payeeBranchId;
    @Column(name = "loan_no")
    private Integer loanNo;
    @Column(name = "is_processed")
    private Integer isProcessed;
    @Column(name = "cheque_no")
    private BigInteger chequeNo;
    @Column(name = "cheque_issue_date")
    private Date chequeIssueDate1;
    @Column(name = "cheque_recevied_date")
    private Date chequeReceviedDate1;
    @Column(name = "recipient_account_no")
    private BigInteger recipientAccountNo;
    @Column(name = "clf_bank_id")
    private BigInteger clfBankId;

    public BigInteger getClfBankId() {
        return clfBankId;
    }

    public void setClfBankId(BigInteger clfBankId) {
        this.clfBankId = clfBankId;
    }
    public BigInteger getUid() {
        return uid;
    }

    public void setUid(BigInteger uid) {
        this.uid = uid;
    }

    public BigInteger getMtgUid() {
        return mtgUid;
    }

    public void setMtgUid(BigInteger mtgUid) {
        this.mtgUid = mtgUid;
    }

    public BigInteger getCboId() {
        return cboId;
    }

    public void setCboId(BigInteger cboId) {
        this.cboId = cboId;
    }

    public String getGuid() {
        return guid;
    }

    public void setGuid(String guid) {
        this.guid = guid;
    }

    public BigInteger getVoId() {
        return voId;
    }

    public void setVoId(BigInteger voId) {
        this.voId = voId;
    }

    public BigInteger getShgId() {
        return shgId;
    }

    public void setShgId(BigInteger shgId) {
        this.shgId = shgId;
    }

    public Short getOrganizationType() {
        return organizationType;
    }

    public void setOrganizationType(Short organizationType) {
        this.organizationType = organizationType;
    }

    public String getOrganizationName() {
        return organizationName;
    }

    public void setOrganizationName(String organizationName) {
        this.organizationName = organizationName;
    }

    public Integer getMtgNo() {
        return mtgNo;
    }

    public void setMtgNo(Integer mtgNo) {
        this.mtgNo = mtgNo;
    }

    public Date getTxnDate1() {
        return txnDate1;
    }

    public void setTxnDate1(Date txnDate1) {
        this.txnDate1 = txnDate1;
    }

    public Integer getAuid() {
        return auid;
    }

    public void setAuid(Integer auid) {
        this.auid = auid;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    public Date getDateRealisation1() {
        return dateRealisation1;
    }

    public void setDateRealisation1(Date dateRealisation1) {
        this.dateRealisation1 = dateRealisation1;
    }

    public Short getModePayment() {
        return modePayment;
    }

    public void setModePayment(Short modePayment) {
        this.modePayment = modePayment;
    }

    public String getBankCode() {
        return bankCode;
    }

    public void setBankCode(String bankCode) {
        this.bankCode = bankCode;
    }

    public String getTransactionNo() {
        return transactionNo;
    }

    public void setTransactionNo(String transactionNo) {
        this.transactionNo = transactionNo;
    }

    public String getVoucherNumber() {
        return voucherNumber;
    }

    public void setVoucherNumber(String voucherNumber) {
        this.voucherNumber = voucherNumber;
    }

    public Date getVoucherDate1() {
        return voucherDate1;
    }

    public void setVoucherDate1(Date voucherDate1) {
        this.voucherDate1 = voucherDate1;
    }

    public String getNarration() {
        return narration;
    }

    public void setNarration(String narration) {
        this.narration = narration;
    }

    public Date getAddlRefDate1() {
        return addlRefDate1;
    }

    public void setAddlRefDate1(Date addlRefDate1) {
        this.addlRefDate1 = addlRefDate1;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    public Date getCreatedOn1() {
        return createdOn1;
    }

    public void setCreatedOn1(Date createdOn1) {
        this.createdOn1 = createdOn1;
    }

    public String getUpdatedBy() {
        return updatedBy;
    }

    public void setUpdatedBy(String updatedBy) {
        this.updatedBy = updatedBy;
    }

    public Date getUpdatedOn1() {
        return updatedOn1;
    }

    public void setUpdatedOn1(Date updatedOn1) {
        this.updatedOn1 = updatedOn1;
    }

    public Integer getReferenceMtgNo() {
        return referenceMtgNo;
    }

    public void setReferenceMtgNo(Integer referenceMtgNo) {
        this.referenceMtgNo = referenceMtgNo;
    }

    public String getPayeeBankId() {
        return payeeBankId;
    }

    public void setPayeeBankId(String payeeBankId) {
        this.payeeBankId = payeeBankId;
    }

    public String getPayeeBranchId() {
        return payeeBranchId;
    }

    public void setPayeeBranchId(String payeeBranchId) {
        this.payeeBranchId = payeeBranchId;
    }

    public Integer getLoanNo() {
        return loanNo;
    }

    public void setLoanNo(Integer loanNo) {
        this.loanNo = loanNo;
    }

    public Integer getIsProcessed() {
        return isProcessed;
    }

    public void setIsProcessed(Integer isProcessed) {
        this.isProcessed = isProcessed;
    }

    public BigInteger getChequeNo() {
        return chequeNo;
    }

    public void setChequeNo(BigInteger chequeNo) {
        this.chequeNo = chequeNo;
    }

    public Date getChequeIssueDate1() {
        return chequeIssueDate1;
    }

    public void setChequeIssueDate1(Date chequeIssueDate1) {
        this.chequeIssueDate1 = chequeIssueDate1;
    }

    public Date getChequeReceviedDate1() {
        return chequeReceviedDate1;
    }

    public void setChequeReceviedDate1(Date chequeReceviedDate1) {
        this.chequeReceviedDate1 = chequeReceviedDate1;
    }

    public BigInteger getRecipientAccountNo() {
        return recipientAccountNo;
    }

    public void setRecipientAccountNo(BigInteger recipientAccountNo) {
        this.recipientAccountNo = recipientAccountNo;
    }

    public BigInteger getOrganizationId() {
        return organizationId;
    }

    public void setOrganizationId(BigInteger organizationId) {
        this.organizationId = organizationId;
    }
}

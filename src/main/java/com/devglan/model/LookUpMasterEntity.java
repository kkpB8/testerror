package com.devglan.model;


import javax.persistence.*;
import java.math.BigInteger;
import java.sql.Timestamp;

@Entity
@Table(name = "lookup_master")
public class LookUpMasterEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "lookup_id", nullable = false)
    private BigInteger lookupId ;
    @Column(name = "key_code")
    private String keyCode;
    @Column(name = "lookup_code")
    private Integer lookupCode;
    @Column(name = "language_id")
    private String languageId;
    @Column(name = "key_value")
    private String keyValue;
    @Column(name = "key1")
    private Integer key1;
    @Column(name = "description")
    private String description;
    @Column(name = "sequence_no")
    private Integer sequenceNo;
    @Column(name = "is_active", nullable = false)
    private Boolean isActive;
    @Column(name = "created_date", nullable = false)
    private Timestamp createdDate;
    @Column(name = "created_by", nullable = false)
    private String createdBy;
    @Column(name = "updated_date")
    private Timestamp updatedDate;
    @Column(name = "updated_by")
    private String updatedBy;
    @Column(name = "status")
    private String status;

    public static Integer activationStatusKey1 = 37;
    public static Short shgLookupVal = 0;
    public static Short voLookupVal = 1;
    public static Short clfLookupVal = 2;
    public static Short activationLookupValPending = 1;
    public static Short activationLookupValAccept = 2;
    public static Short activationLookupValReject = 3;
	public static Short dedupLookupValPending=1;
    public static Short dedupLookupValConfirm=2;
    public static Short dedupLookupValPotential=3;
    public static Short dedupLookupValNoDup=4;
    public static Short dedupLookupValNoApproveBYBM=5;
    public static Short dedupLookupValNoRejectBYBM=6;
    public static Short approveLookupValPending = 1;
    public static Short approveLookupValAccept = 2;
    public static Short approveLookupValReject = 3;

    public LookUpMasterEntity() {
    }



    public String getDescription() {
        return description;
    }

    public void setDescription(final String description) {
        this.description = description;
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

    public String getKeyValue() {
        return keyValue;
    }

    public void setKeyValue(final String keyValue) {
        this.keyValue = keyValue;
    }

    public Integer getKey1() {
        return key1;
    }

    public void setKey1(final Integer key1) {
        this.key1 = key1;
    }


    public String getStatus() {
        return status;
    }

    public void setStatus(final String status) {
        this.status = status;
    }

    public BigInteger getLookupId() {
        return lookupId;
    }

    public void setLookupId(final BigInteger lookupId) {
        this.lookupId = lookupId;
    }

    public String getKeyCode() {
        return keyCode;
    }

    public void setKeyCode(final String keyCode) {
        this.keyCode = keyCode;
    }

    public Integer getLookupCode() {
        return lookupCode;
    }

    public void setLookupCode(final Integer lookupCode) {
        this.lookupCode = lookupCode;
    }

    public String getLanguageId() {
        return languageId;
    }

    public void setLanguageId(String languageId) {
        this.languageId = languageId;
    }

    public Integer getSequenceNo() {
        return sequenceNo;
    }

    public void setSequenceNo(final Integer sequenceNo) {
        this.sequenceNo = sequenceNo;
    }
}


package com.devglan.model;



import javax.persistence.*;
import java.math.BigInteger;
import java.sql.Timestamp;

@Entity
@Table(name = "document_details")
public class DocumentDetailsEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "document_id", nullable = false)
    private BigInteger documentId;
    @Column(name = "front_doc_original_name")
    private String frontDocOriginalName;
    @Column(name = "front_doc_modified_name")
    private String frontDocModifiedName;
    @Column(name = "rear_doc_original_name")
    private String rearDocOriginalName;
    @Column(name = "rear_doc_modified_name")
    private String rearDocModifiedName;
    @Column(name = "doc_path")
    private String docPath;
    @Column(name = "entry_source")
    private Short entrySource;
    @Column(name = "is_edited")
    private Integer isEdited;
    @Column(name = "last_uploaded_date")

    private Timestamp lastUploadedDate;
    @Column(name = "uploaded_by")
    private Integer uploadedBy;
    @Column(name = "created_date", nullable = false)

    private Timestamp createdDate;
    @Column(name = "created_by", nullable = false)
    private String createdBy;
    @Column(name = "updated_date")

    private Timestamp updatedDate;
    @Column(name = "updated_by")
    private String updatedBy;

    public BigInteger getDocumentId() {
        return documentId;
    }

    public void setDocumentId(final BigInteger documentId) {
        this.documentId = documentId;
    }

    public String getFrontDocOriginalName() {
        return frontDocOriginalName;
    }

    public void setFrontDocOriginalName(final String frontDocOriginalName) {
        this.frontDocOriginalName = frontDocOriginalName;
    }

    public String getFrontDocModifiedName() {
        return frontDocModifiedName;
    }

    public void setFrontDocModifiedName(final String frontDocModifiedName) {
        this.frontDocModifiedName = frontDocModifiedName;
    }

    public String getRearDocOriginalName() {
        return rearDocOriginalName;
    }

    public void setRearDocOriginalName(final String rearDocOriginalName) {
        this.rearDocOriginalName = rearDocOriginalName;
    }

    public String getRearDocModifiedName() {
        return rearDocModifiedName;
    }

    public void setRearDocModifiedName(final String rearDocModifiedName) {
        this.rearDocModifiedName = rearDocModifiedName;
    }

    public String getDocPath() {
        return docPath;
    }

    public void setDocPath(final String docPath) {
        this.docPath = docPath;
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

    public Integer getUploadedBy() {
        return uploadedBy;
    }

    public void setUploadedBy(final Integer uploadedBy) {
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
}

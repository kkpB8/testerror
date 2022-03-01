package com.devglan.domain;


import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.web.multipart.MultipartFile;

import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import java.math.BigInteger;
import java.sql.Timestamp;

public class MemberKYCDetails {
    private BigInteger member_kyc_details_id;
    //@NotBlank(message = "CBO GUID cannot be empty")

    private String kyc_guid;
    private String member_guid;
    private BigInteger member_code;
    //@NotNull(message = "Set KYC Type")
    private Integer kyc_type;
    //@NotBlank(message = "KYC Number cannot be empty")
    private String kyc_number;
    private Integer document_id;
    //@NotBlank(message = "KYC Valid From cannot be empty")
    private Integer kyc_valid_from;
    private Integer kyc_valid_to;
    private Short status;
    private Short entry_source;
    //@NotNull(message = "Set Is Edited")
    private Integer is_edited;
    private Short is_active;
    private String uploaded_by;
    //@NotBlank(message = "Created By cannot be empty")
    private String created_by;
    private String updated_by;
    private BigInteger cbo_id;
    private Short dedupl_status;
    private Short activation_status;
    private Integer created_date;
    private Integer uploaded_date;
    private Integer updated_date;
    @NotEmpty(message = "Document must be uploaded")
    private DocumentDetails documentDetails;
    private String front_doc_original_name;
    private String rear_doc_original_name;
    private String kyc_front_document;
    private String kyc_rear_document;
    //@Satwant 06052021
    private Integer is_verified;
    private Integer is_complete;

    public BigInteger getMember_kyc_details_id() {
        return member_kyc_details_id;
    }

    public void setMember_kyc_details_id(BigInteger member_kyc_details_id) {
        this.member_kyc_details_id = member_kyc_details_id;
    }

    public String getKyc_guid() {
        return kyc_guid;
    }

    public void setKyc_guid(String kyc_guid) {
        this.kyc_guid = kyc_guid;
    }

    public String getMember_guid() {
        return member_guid;
    }

    public void setMember_guid(String member_guid) {
        this.member_guid = member_guid;
    }

    public BigInteger getMember_code() {
        return member_code;
    }

    public void setMember_code(BigInteger member_code) {
        this.member_code = member_code;
    }

    public Integer getKyc_type() {
        return kyc_type;
    }

    public void setKyc_type(Integer kyc_type) {
        this.kyc_type = kyc_type;
    }

    public String getKyc_number() {
        return kyc_number;
    }

    public void setKyc_number(String kyc_number) {
        this.kyc_number = kyc_number;
    }

    public Integer getDocument_id() {
        return document_id;
    }

    public void setDocument_id(Integer document_id) {
        this.document_id = document_id;
    }

    public Integer getKyc_valid_from() {
        return kyc_valid_from;
    }

    public void setKyc_valid_from(Integer kyc_valid_from) {
        this.kyc_valid_from = kyc_valid_from;
    }

    public Integer getKyc_valid_to() {
        return kyc_valid_to;
    }

    public void setKyc_valid_to(Integer kyc_valid_to) {
        this.kyc_valid_to = kyc_valid_to;
    }

    public Short getStatus() {
        return status;
    }

    public void setStatus(Short status) {
        this.status = status;
    }

    public Short getEntry_source() {
        return entry_source;
    }

    public void setEntry_source(Short entry_source) {
        this.entry_source = entry_source;
    }

    public Integer getIs_edited() {
        return is_edited;
    }

    public void setIs_edited(Integer is_edited) {
        this.is_edited = is_edited;
    }

    public Short getIs_active() {
        return is_active;
    }

    public void setIs_active(Short is_active) {
        this.is_active = is_active;
    }

    public String getUploaded_by() {
        return uploaded_by;
    }

    public void setUploaded_by(String uploaded_by) {
        this.uploaded_by = uploaded_by;
    }

    public String getCreated_by() {
        return created_by;
    }

    public void setCreated_by(String created_by) {
        this.created_by = created_by;
    }

    public String getUpdated_by() {
        return updated_by;
    }

    public void setUpdated_by(String updated_by) {
        this.updated_by = updated_by;
    }

    public BigInteger getCbo_id() {
        return cbo_id;
    }

    public void setCbo_id(BigInteger cbo_id) {
        this.cbo_id = cbo_id;
    }

    public Short getDedupl_status() {
        return dedupl_status;
    }

    public void setDedupl_status(Short dedupl_status) {
        this.dedupl_status = dedupl_status;
    }

    public Short getActivation_status() {
        return activation_status;
    }

    public void setActivation_status(Short activation_status) {
        this.activation_status = activation_status;
    }

    public Integer getCreated_date() {
        return created_date;
    }

    public void setCreated_date(Integer created_date) {
        this.created_date = created_date;
    }

    public Integer getUploaded_date() {
        return uploaded_date;
    }

    public void setUploaded_date(Integer uploaded_date) {
        this.uploaded_date = uploaded_date;
    }

    public Integer getUpdated_date() {
        return updated_date;
    }

    public void setUpdated_date(Integer updated_date) {
        this.updated_date = updated_date;
    }

    public DocumentDetails getDocumentDetails() {
        return documentDetails;
    }

    public void setDocumentDetails(DocumentDetails documentDetails) {
        this.documentDetails = documentDetails;
    }

    public String getFront_doc_original_name() {
        return front_doc_original_name;
    }

    public void setFront_doc_original_name(String front_doc_original_name) {
        this.front_doc_original_name = front_doc_original_name;
    }

    public String getRear_doc_original_name() {
        return rear_doc_original_name;
    }

    public void setRear_doc_original_name(String rear_doc_original_name) {
        this.rear_doc_original_name = rear_doc_original_name;
    }

    public String getKyc_front_document() {
        return kyc_front_document;
    }

    public void setKyc_front_document(String kyc_front_document) {
        this.kyc_front_document = kyc_front_document;
    }

    public String getKyc_rear_document() {
        return kyc_rear_document;
    }

    public void setKyc_rear_document(String kyc_rear_document) {
        this.kyc_rear_document = kyc_rear_document;
    }

    public Integer getIs_verified() {
        return is_verified;
    }

    public void setIs_verified(Integer is_verified) {
        this.is_verified = is_verified;
    }

    public Integer getIs_complete() {
        return is_complete;
    }

    public void setIs_complete(Integer is_complete) {
        this.is_complete = is_complete;
    }
}

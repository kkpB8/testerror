package com.devglan.domain;


import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.web.multipart.MultipartFile;

import javax.persistence.Column;
import javax.validation.constraints.NotNull;
import java.math.BigInteger;

public class CboKYCDetails {

    private BigInteger cbo_kyc_details_id;
    private  String cbo_guid;
    private String kyc_guid;
    private BigInteger cbo_id;
    @NotNull(message = "KYC Type cannot be Empty")
    private Integer kyc_type;
    @NotBlank(message = "KYC Number cannot be Empty")
    //@Size(max=50,message="KYC Number can be of 50 chars")
    private String kyc_number;
    private BigInteger document_id;
    private Integer kyc_valid_from;
    private Integer kyc_valid_to;
    @NotEmpty(message = "Document must be uploaded")
    private DocumentDetails documentDetails;
    private Short status;
    private Short deduplication_status;
    private Short activation_status;
    @NotNull(message = "Set Entry Source ")
    private Short entry_source;
    @NotNull(message = "Set Is Edited")
    private Integer is_edited;
    private Integer last_uploaded_date;
    private String uploaded_by;
    private Integer created_date;
    private String created_by;
    private Integer updated_date;
    private String updated_by;
    @NotNull(message = "Set Is Active")
    private Short is_active;
    private Short cbo_type;
    private String kyc_document;
    //@Satwant 06052021
    private Integer is_verified;
    private Integer is_complete;

    //30/06/2022@anshul
    private String kyc_front_doc_orig_name;


    public BigInteger getCbo_kyc_details_id() {
        return cbo_kyc_details_id;
    }

    public void setCbo_kyc_details_id(BigInteger cbo_kyc_details_id) {
        this.cbo_kyc_details_id = cbo_kyc_details_id;
    }

    public String getCbo_guid() {
        return cbo_guid;
    }

    public void setCbo_guid(String cbo_guid) {
        this.cbo_guid = cbo_guid;
    }

    public BigInteger getCbo_id() {
        return cbo_id;
    }

    public void setCbo_id(BigInteger cbo_id) {
        this.cbo_id = cbo_id;
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

    public BigInteger getDocument_id() {
        return document_id;
    }

    public void setDocument_id(BigInteger document_id) {
        this.document_id = document_id;
    }

    public Short getIs_active() {
        return is_active;
    }

    public void setIs_active(Short is_active) {
        this.is_active = is_active;
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

    public DocumentDetails getDocumentDetails() {
        return documentDetails;
    }

    public void setDocumentDetails(DocumentDetails documentDetails) {
        this.documentDetails = documentDetails;
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

    public Integer getLast_uploaded_date() {
        return last_uploaded_date;
    }

    public void setLast_uploaded_date(Integer last_uploaded_date) {
        this.last_uploaded_date = last_uploaded_date;
    }

    public Integer getCreated_date() {
        return created_date;
    }

    public void setCreated_date(Integer created_date) {
        this.created_date = created_date;
    }

    public Integer getUpdated_date() {
        return updated_date;
    }

    public void setUpdated_date(Integer updated_date) {
        this.updated_date = updated_date;
    }

    public String getKyc_guid() {
        return kyc_guid;
    }

    public void setKyc_guid(String kyc_guid) {
        this.kyc_guid = kyc_guid;
    }

    public Short getStatus() {
        return status;
    }

    public void setStatus(Short status) {
        this.status = status;
    }

    public Short getDeduplication_status() {
        return deduplication_status;
    }

    public void setDeduplication_status(Short deduplication_status) {
        this.deduplication_status = deduplication_status;
    }

    public Short getActivation_status() {
        return activation_status;
    }

    public void setActivation_status(Short activation_status) {
        this.activation_status = activation_status;
    }

    public Short getCbo_type() {
        return cbo_type;
    }

    public void setCbo_type(Short cbo_type) {
        this.cbo_type = cbo_type;
    }

    public String getKyc_document() {
        return kyc_document;
    }

    public void setKyc_document(String kyc_document) {
        this.kyc_document = kyc_document;
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

    public String getKyc_front_doc_orig_name() {
        return kyc_front_doc_orig_name;
    }

    public void setKyc_front_doc_orig_name(String kyc_front_doc_orig_name) {
        this.kyc_front_doc_orig_name = kyc_front_doc_orig_name;
    }


}

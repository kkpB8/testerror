package com.devglan.domain;

import org.springframework.web.multipart.MultipartFile;

import java.math.BigInteger;

public class DocumentDetails {

    private BigInteger document_id;
    private String front_doc_original_name;
    private String front_doc_modified_name;
    private MultipartFile front_doc;
    private String rear_doc_original_name;
    private String rear_doc_modified_name;
    private MultipartFile rear_doc;
    private String doc_path;
    private Short status;
    private Short entry_source;
    private String last_uploaded_date;
    private Integer uploaded_by;
    private String created_date;
    private String created_by;
    private String updated_date;
    private String updated_by;

    public BigInteger getDocument_id() {
        return document_id;
    }

    public void setDocument_id(BigInteger document_id) {
        this.document_id = document_id;
    }

    public String getFront_doc_original_name() {
        return front_doc_original_name;
    }

    public void setFront_doc_original_name(String front_doc_original_name) {
        this.front_doc_original_name = front_doc_original_name;
    }

    public String getFront_doc_modified_name() {
        return front_doc_modified_name;
    }

    public void setFront_doc_modified_name(String front_doc_modified_name) {
        this.front_doc_modified_name = front_doc_modified_name;
    }

    public String getRear_doc_original_name() {
        return rear_doc_original_name;
    }

    public void setRear_doc_original_name(String rear_doc_original_name) {
        this.rear_doc_original_name = rear_doc_original_name;
    }

    public String getRear_doc_modified_name() {
        return rear_doc_modified_name;
    }

    public void setRear_doc_modified_name(String rear_doc_modified_name) {
        this.rear_doc_modified_name = rear_doc_modified_name;
    }

    public MultipartFile getFront_doc() {
        return front_doc;
    }

    public void setFront_doc(MultipartFile front_doc) {
        this.front_doc = front_doc;
    }

    public MultipartFile getRear_doc() {
        return rear_doc;
    }

    public void setRear_doc(MultipartFile rear_doc) {
        this.rear_doc = rear_doc;
    }

    public String getDoc_path() {
        return doc_path;
    }

    public void setDoc_path(String doc_path) {
        this.doc_path = doc_path;
    }

    public Short getEntry_source() {
        return entry_source;
    }

    public void setEntry_source(Short entry_source) {
        this.entry_source = entry_source;
    }

    public String getLast_uploaded_date() {
        return last_uploaded_date;
    }

    public void setLast_uploaded_date(String last_uploaded_date) {
        this.last_uploaded_date = last_uploaded_date;
    }

    public Integer getUploaded_by() {
        return uploaded_by;
    }

    public void setUploaded_by(Integer uploaded_by) {
        this.uploaded_by = uploaded_by;
    }

    public String getCreated_date() {
        return created_date;
    }

    public void setCreated_date(String created_date) {
        this.created_date = created_date;
    }

    public String getUpdated_date() {
        return updated_date;
    }

    public void setUpdated_date(String updated_date) {
        this.updated_date = updated_date;
    }


    public Short getStatus() {
        return status;
    }

    public void setStatus(Short status) {
        this.status = status;
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
}

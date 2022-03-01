package com.devglan.domain;


import javax.persistence.*;
import java.math.*;
import java.time.*;

public class CboMappingDetails {

    private BigInteger cbo_mapping_id;
    private String cbo_guid;
    private String cbo_child_guid;
    private BigInteger cbo_id;
    private BigInteger cbo_child_id;
    private BigInteger cbo_child_code;
    private Short cbo_level;
    private Short cbo_child_level;
    private Integer joining_date;
    private Integer leaving_date;
    private Short settlement_status;
    private String leaving_reason;
    private Short status;
    private Short entry_source;
    private Integer is_edited;
    private Short is_active;
    private String uploaded_by;
    private String created_by;
    private String updated_by;
    private Integer last_uploaded_date;
    private Integer created_date;
    private Integer updated_date;
    private String cbo_child_name;
    private Integer cbo_child_village_id;

    public BigInteger getCbo_mapping_id() {
        return cbo_mapping_id;
    }

    public void setCbo_mapping_id(BigInteger cbo_mapping_id) {
        this.cbo_mapping_id = cbo_mapping_id;
    }

    public String getCbo_guid() {
        return cbo_guid;
    }

    public void setCbo_guid(String cbo_guid) {
        this.cbo_guid = cbo_guid;
    }

    public String getCbo_child_guid() {
        return cbo_child_guid;
    }

    public void setCbo_child_guid(String cbo_child_guid) {
        this.cbo_child_guid = cbo_child_guid;
    }

    public BigInteger getCbo_id() {
        return cbo_id;
    }

    public void setCbo_id(BigInteger cbo_id) {
        this.cbo_id = cbo_id;
    }

    public BigInteger getCbo_child_id() {
        return cbo_child_id;
    }

    public void setCbo_child_id(BigInteger cbo_child_id) {
        this.cbo_child_id = cbo_child_id;
    }

    public BigInteger getCbo_child_code() {
        return cbo_child_code;
    }

    public void setCbo_child_code(BigInteger cbo_child_code) {
        this.cbo_child_code = cbo_child_code;
    }

    public Short getCbo_level() {
        return cbo_level;
    }

    public void setCbo_level(Short cbo_level) {
        this.cbo_level = cbo_level;
    }

    public Short getCbo_child_level() {
        return cbo_child_level;
    }

    public void setCbo_child_level(Short cbo_child_level) {
        this.cbo_child_level = cbo_child_level;
    }

    public Integer getJoining_date() {
        return joining_date;
    }

    public void setJoining_date(Integer joining_date) {
        this.joining_date = joining_date;
    }

    public Integer getLeaving_date() {
        return leaving_date;
    }

    public void setLeaving_date(Integer leaving_date) {
        this.leaving_date = leaving_date;
    }

    public Short getSettlement_status() {
        return settlement_status;
    }

    public void setSettlement_status(Short settlement_status) {
        this.settlement_status = settlement_status;
    }

    public String getLeaving_reason() {
        return leaving_reason;
    }

    public void setLeaving_reason(String leaving_reason) {
        this.leaving_reason = leaving_reason;
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

    public String getCbo_child_name() {
        return cbo_child_name;
    }

    public void setCbo_child_name(String cbo_child_name) {
        this.cbo_child_name = cbo_child_name;
    }

    public Integer getCbo_child_village_id() {
        return cbo_child_village_id;
    }

    public void setCbo_child_village_id(Integer cbo_child_village_id) {
        this.cbo_child_village_id = cbo_child_village_id;
    }
}
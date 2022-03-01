package com.devglan.domain;
import javax.validation.constraints.NotNull;
import java.math.*;

public class SystemTags {

    private BigInteger systemtags_id;
    // @NotBlank(message = "system_tag_guid cannot be empty")
    private String system_tag_guid;
    private String cbo_guid;

    private BigInteger cbo_code;
    //@NotNull(message = "System Type cannot be empty")
    private Short system_type;
    //@NotNull(message = "System Id cannot be empty")
    private String system_id;
    private Short status;
    //@NotNull(message = "Set Entry Source")
    private Short entry_source;
    //@NotNull(message = "Set Is Edited")
    private Integer is_edited;
    private Short is_active;

    private String uploaded_by;
    //@NotBlank(message = "Created By cannot be empty")
    private String created_by;
    private String updated_by;
    private Integer last_uploaded_date;
    @NotNull(message = "Created Date Must be Given")
    private Integer created_date;
    private Integer updated_date;
    //@satwant06052021
    private Integer is_complete;

    public BigInteger getSystemtags_id() {
        return systemtags_id;
    }

    public void setSystemtags_id(BigInteger systemtags_id) {
        this.systemtags_id = systemtags_id;
    }

    public String getSystem_tag_guid() {
        return system_tag_guid;
    }

    public void setSystem_tag_guid(String system_tag_guid) {
        this.system_tag_guid = system_tag_guid;
    }

    public String getCbo_guid() {
        return cbo_guid;
    }

    public void setCbo_guid(String cbo_guid) {
        this.cbo_guid = cbo_guid;
    }

    public BigInteger getCbo_code() {
        return cbo_code;
    }

    public void setCbo_code(BigInteger cbo_code) {
        this.cbo_code = cbo_code;
    }

    public Short getSystem_type() {
        return system_type;
    }

    public void setSystem_type(Short system_type) {
        this.system_type = system_type;
    }

    public String getSystem_id() {
        return system_id;
    }

    public void setSystem_id(String system_id) {
        this.system_id = system_id;
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

    public Integer getIs_complete() {
        return is_complete;
    }

    public void setIs_complete(Integer is_complete) {
        this.is_complete = is_complete;
    }
}
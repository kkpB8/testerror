package com.devglan.domain;


import java.math.BigInteger;
import java.sql.Date;
import java.sql.Timestamp;

import javax.validation.constraints.NotNull;

public class CadreShgMembersModel
{
	 // @NotNull
    private BigInteger uid;
    // @NotNull
    private BigInteger cbo_id;
    private BigInteger member_id;
    @NotNull
    private Integer cadre_role_code;
    @NotNull
    private Integer  cadre_cat_code;
    @NotNull
    private Integer date_joining;
    private Integer date_leaving;
    private String  created_by;
    private Integer created_on;
    private String  updated_by;
    private  Integer  updated_on;
    private String uploaded_by;
    private Integer uploaded_on;
    private String cadre_guid;
    private  String member_guid;
    private  Short is_active;
    private  Integer is_edited;
    private  Integer is_complete;


    public BigInteger getUid() {
        return uid;
    }

    public void setUid(BigInteger uid) {
        this.uid = uid;
    }

    public BigInteger getCbo_id() {
        return cbo_id;
    }

    public void setCbo_id(BigInteger cbo_id) {
        this.cbo_id = cbo_id;
    }

    public BigInteger getMember_id() {
        return member_id;
    }

    public void setMember_id(BigInteger member_id) {
        this.member_id = member_id;
    }

    public Integer getCadre_role_code() {
        return cadre_role_code;
    }

    public void setCadre_role_code(Integer cadre_role_code) {
        this.cadre_role_code = cadre_role_code;
    }

    public Integer getCadre_cat_code() {
        return cadre_cat_code;
    }

    public void setCadre_cat_code(Integer cadre_cat_code) {
        this.cadre_cat_code = cadre_cat_code;
    }

    public Integer getDate_joining() {
        return date_joining;
    }

    public void setDate_joining(Integer date_joining) {
        this.date_joining = date_joining;
    }

    public Integer getDate_leaving() {
        return date_leaving;
    }

    public void setDate_leaving(Integer date_leaving) {
        this.date_leaving = date_leaving;
    }

    public String getCreated_by() {
        return created_by;
    }

    public void setCreated_by(String created_by) {
        this.created_by = created_by;
    }

    public Integer getCreated_on() {
        return created_on;
    }

    public void setCreated_on(Integer created_on) {
        this.created_on = created_on;
    }

    public String getUpdated_by() {
        return updated_by;
    }

    public void setUpdated_by(String updated_by) {
        this.updated_by = updated_by;
    }

    public Integer getUpdated_on() {
        return updated_on;
    }

    public void setUpdated_on(Integer updated_on) {
        this.updated_on = updated_on;
    }

    public String getUploaded_by() {
        return uploaded_by;
    }

    public void setUploaded_by(String uploaded_by) {
        this.uploaded_by = uploaded_by;
    }

    public Integer getUploaded_on() {
        return uploaded_on;
    }

    public void setUploaded_on(Integer uploaded_on) {
        this.uploaded_on = uploaded_on;
    }

    public String getCadre_guid() {
        return cadre_guid;
    }

    public void setCadre_guid(String cadre_guid) {
        this.cadre_guid = cadre_guid;
    }


    public String getMember_guid() {
        return member_guid;
    }

    public void setMember_guid(String member_guid) {
        this.member_guid = member_guid;
    }

    public Short getIs_active() {
        return is_active;
    }

    public void setIs_active(Short is_active) {
        this.is_active = is_active;
    }

    public Integer getIs_edited() {
        return is_edited;
    }

    public void setIs_edited(Integer is_edited) {
        this.is_edited = is_edited;
    }

    public Integer getIs_complete() {
        return is_complete;
    }

    public void setIs_complete(Integer is_complete) {
        this.is_complete = is_complete;
    }
}
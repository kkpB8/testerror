package com.devglan.domain;

import java.math.*;
import java.util.*;

public class MemberDetailsForMapping {
    private BigInteger member_id;
    private String member_guid;
    private String member_name;
    private String member_name_local;
    private String relation;
    private String relation_name;
    private String relation_name_local;
    private Integer joining_date;
    private Integer designation;
    private String cbo_guid;
    private List<MemberPhoneMapping> memberPhoneDetailsList;

    public BigInteger getMember_id() {
        return member_id;
    }

    public void setMember_id(BigInteger member_id) {
        this.member_id = member_id;
    }

    public String getMember_guid() {
        return member_guid;
    }

    public void setMember_guid(String member_guid) {
        this.member_guid = member_guid;
    }

    public String getMember_name() {
        return member_name;
    }

    public void setMember_name(String member_name) {
        this.member_name = member_name;
    }

    public String getMember_name_local() {
        return member_name_local;
    }

    public void setMember_name_local(String member_name_local) {
        this.member_name_local = member_name_local;
    }

    public String getRelation() {
        return relation;
    }

    public void setRelation(String relation) {
        this.relation = relation;
    }

    public String getRelation_name() {
        return relation_name;
    }

    public void setRelation_name(String relation_name) {
        this.relation_name = relation_name;
    }

    public String getRelation_name_local() {
        return relation_name_local;
    }

    public void setRelation_name_local(String relation_name_local) {
        this.relation_name_local = relation_name_local;
    }

    public Integer getJoining_date() {
        return joining_date;
    }

    public void setJoining_date(Integer joining_date) {
        this.joining_date = joining_date;
    }

    public Integer getDesignation() {
        return designation;
    }

    public void setDesignation(Integer designation) {
        this.designation = designation;
    }

    public List<MemberPhoneMapping> getMemberPhoneDetailsList() {
        return memberPhoneDetailsList;
    }

    public void setMemberPhoneDetailsList(List<MemberPhoneMapping> memberPhoneDetailsList) {
        this.memberPhoneDetailsList = memberPhoneDetailsList;
    }

    public String getCbo_guid() {
        return cbo_guid;
    }

    public void setCbo_guid(String cbo_guid) {
        this.cbo_guid = cbo_guid;
    }
}



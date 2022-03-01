package com.devglan.domain;

import java.math.*;
import java.util.*;

public class MemberPhoneMapping {
    private BigInteger member_id;
    private String member_guid;
    private String phone_guid;
    private BigInteger phone_no;
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

    public String getPhone_guid() {
        return phone_guid;
    }

    public void setPhone_guid(String phone_guid) {
        this.phone_guid = phone_guid;
    }

    public BigInteger getPhone_no() {
        return phone_no;
    }

    public void setPhone_no(BigInteger phone_no) {
        this.phone_no = phone_no;
    }
}



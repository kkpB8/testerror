package com.devglan.domain;

import javax.persistence.*;
import java.math.*;

public class ShgProfileWithMandatory {
    private BigInteger shg_id;
    private Integer state_id;
    private Integer district_id;
    private Integer block_id;
    private Integer panchayat_id;
    private Integer village_id;
    private String guid;
    private String shg_name;
    private Integer shg_formation_date;
    private String shg_code;
    private Short shg_type_code;

    public BigInteger getShg_id() {
        return shg_id;
    }

    public void setShg_id(BigInteger shg_id) {
        this.shg_id = shg_id;
    }

    public Integer getState_id() {
        return state_id;
    }

    public void setState_id(Integer state_id) {
        this.state_id = state_id;
    }

    public Integer getDistrict_id() {
        return district_id;
    }

    public void setDistrict_id(Integer district_id) {
        this.district_id = district_id;
    }

    public Integer getBlock_id() {
        return block_id;
    }

    public void setBlock_id(Integer block_id) {
        this.block_id = block_id;
    }

    public Integer getPanchayat_id() {
        return panchayat_id;
    }

    public void setPanchayat_id(Integer panchayat_id) {
        this.panchayat_id = panchayat_id;
    }

    public Integer getVillage_id() {
        return village_id;
    }

    public void setVillage_id(Integer village_id) {
        this.village_id = village_id;
    }

    public String getGuid() {
        return guid;
    }

    public void setGuid(String guid) {
        this.guid = guid;
    }

    public String getShg_name() {
        return shg_name;
    }

    public void setShg_name(String shg_name) {
        this.shg_name = shg_name;
    }

    public Integer getShg_formation_date() {
        return shg_formation_date;
    }

    public void setShg_formation_date(Integer shg_formation_date) {
        this.shg_formation_date = shg_formation_date;
    }

    public String getShg_code() {
        return shg_code;
    }

    public void setShg_code(String shg_code) {
        this.shg_code = shg_code;
    }

    public Short getShg_type_code() {
        return shg_type_code;
    }

    public void setShg_type_code(Short shg_type_code) {
        this.shg_type_code = shg_type_code;
    }
}

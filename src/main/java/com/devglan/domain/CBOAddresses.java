package com.devglan.domain;

import org.hibernate.validator.constraints.NotBlank;

import javax.validation.constraints.NotNull;
import java.math.BigInteger;

public class CBOAddresses {
    private  BigInteger cbo_address_id;
    private BigInteger cbo_id;
    @NotNull(message = "Cbo Type cannot be empty")
    private Short cbo_type;
    private String address_guid;
    private String cbo_guid;
    private Short address_type;
  
    private String urban_rural;
    @NotBlank(message = "Address Line1 cannot be empty")
  
    private String address_line1;
  
    private String address_line2;
  
    private String city_town;
    @NotBlank(message = "Postal Code cannot be empty")
   
    private String postal_code;
  //@Size(max=200,message="Landmark can be 200 chars long")
    private String landmark;
    @NotNull(message = "State Id cannot be empty")
    private Integer state_id;
    @NotNull(message = "District Id cannot be empty")
    private Integer district_id;
    @NotNull(message = "Block Id cannot be empty")
    private Integer block_id;
    @NotNull(message = "Panchayat Id cannot be empty")
    private Integer panchayat_id;
    @NotNull(message = "Village Id cannot be empty")
    private Integer village_id;
    private Short status;
    private Short deduplication_status;
    private Short activation_status;
    @NotNull(message = "Set Entry Source ")
    private Short entry_source;
    @NotNull(message = "Set Is Edited")
    private Integer is_edited;
    private Integer last_uploaded_date;
    private String uploaded_by;
    @NotNull(message = "Created Date Must be Given")
    private Integer created_date;
    @NotNull(message = "Created By Must be Given")
    private String created_by;
    private Integer updated_date;
    private String updated_by;
    @NotNull(message = "Set Is Active")
    private Short is_active;
    //@Satwant 06052021
    private Integer is_verified;
    private Integer is_complete;


    public BigInteger getCbo_address_id() {
        return cbo_address_id;
    }

    public void setCbo_address_id(BigInteger cbo_address_id) {
        this.cbo_address_id = cbo_address_id;
    }

    public BigInteger getCbo_id() {
        return cbo_id;
    }

    public void setCbo_id(BigInteger cbo_id) {
        this.cbo_id = cbo_id;
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


    public Short getAddress_type() {
        return address_type;
    }

    public void setAddress_type(Short address_type) {
        this.address_type = address_type;
    }

    public String getUrban_rural() {
        return urban_rural;
    }

    public void setUrban_rural(String urban_rural) {
        this.urban_rural = urban_rural;
    }

    public String getAddress_line1() {
        return address_line1;
    }

    public void setAddress_line1(String address_line1) {
        this.address_line1 = address_line1;
    }

    public String getAddress_line2() {
        return address_line2;
    }

    public void setAddress_line2(String address_line2) {
        this.address_line2 = address_line2;
    }

    public String getCity_town() {
        return city_town;
    }

    public void setCity_town(String city_town) {
        this.city_town = city_town;
    }

    public String getPostal_code() {
        return postal_code;
    }

    public void setPostal_code(String postal_code) {
        this.postal_code = postal_code;
    }

    public String getLandmark() {
        return landmark;
    }

    public void setLandmark(String landmark) {
        this.landmark = landmark;
    }

    public Short getCbo_type() {
        return cbo_type;
    }

    public void setCbo_type(Short cbo_type) {
        this.cbo_type = cbo_type;
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

    public String getAddress_guid() {
        return address_guid;
    }

    public void setAddress_guid(String address_guid) {
        this.address_guid = address_guid;
    }

    public String getCbo_guid() {
        return cbo_guid;
    }

    public void setCbo_guid(String cbo_guid) {
        this.cbo_guid = cbo_guid;
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

    public Short getIs_active() {
        return is_active;
    }

    public void setIs_active(Short is_active) {
        this.is_active = is_active;
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

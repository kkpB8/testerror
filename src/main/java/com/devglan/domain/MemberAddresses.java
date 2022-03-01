package com.devglan.domain;
import org.hibernate.validator.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.math.BigInteger;

public class MemberAddresses {


    private BigInteger member_address_id;
    /* @EmbeddedId
     private MemberAddressIdentity memberAddressIdentity;*/
    ////@NotBlank(message = "Address GUID cannot be empty")
    private String address_guid;
    private String member_guid;
    private BigInteger member_code;
    private Short address_type;
    @NotBlank(message = "Address Line1 cannot be empty")
    private String address_line1;
    private String address_line2;
    @NotNull(message = "Village cannot be empty")
    private Integer village_id;
    @NotNull(message = "Block cannot be empty")
    private Integer block_id;
    @NotNull(message = "Panchayat cannot be empty")
    private Integer panchayat_id;
    private Integer landmark;
    @NotNull(message = "State cannot be empty")
    private Integer state_id;
    @NotNull(message = "District cannot be empty")
    private Integer district_id;
    @NotNull(message = "PostalCode cannot be empty")
    private Integer postal_code;
    private Short status;
    @NotNull(message = "Set Entry Source ")
    private Short entry_source;
    @NotNull(message = "Set Is Edited")
    private Integer is_edited;
    private Short is_active;
    @NotBlank(message = "Created By cannot be empty")
    private String created_by;
    private String updated_by;
    private BigInteger cbo_id;
    @NotNull(message = "Created Date Must be Given")
    private Integer created_date;
    private Integer uploaded_date;
    private Integer updated_date;
    private Short address_location;
    //@Satwant 06052021
    private Integer is_verified;
    private Integer is_complete;


    public BigInteger getMember_address_id() {
        return member_address_id;
    }

    public void setMember_address_id(BigInteger member_address_id) {
        this.member_address_id = member_address_id;
    }

    public String getAddress_guid() {
        return address_guid;
    }

    public void setAddress_guid(String address_guid) {
        this.address_guid = address_guid;
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

    public Short getAddress_type() {
        return address_type;
    }

    public void setAddress_type(Short address_type) {
        this.address_type = address_type;
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

    public Integer getVillage_id() {
        return village_id;
    }

    public void setVillage_id(Integer village_id) {
        this.village_id = village_id;
    }

    public Integer getLandmark() {
        return landmark;
    }

    public void setLandmark(Integer landmark) {
        this.landmark = landmark;
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

    public Integer getPostal_code() {
        return postal_code;
    }

    public void setPostal_code(Integer postal_code) {
        this.postal_code = postal_code;
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

    public Short getAddress_location() {
        return address_location;
    }

    public void setAddress_location(Short address_location) {
        this.address_location = address_location;
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

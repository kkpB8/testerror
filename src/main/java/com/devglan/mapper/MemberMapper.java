package com.devglan.mapper;

import java.sql.Timestamp;
import java.text.ParseException;

import com.devglan.domain.CadreNonMembersModel;
import com.devglan.domain.CadreShgMembersModel;
import com.devglan.domain.MemberAddresses;
import com.devglan.domain.MemberBank;
import com.devglan.domain.MemberInsurance;
import com.devglan.domain.MemberKYCDetails;
import com.devglan.domain.MemberPhoneNoDetails;
import com.devglan.domain.MemberProfile;
import com.devglan.domain.MemberSystemTags;
import com.devglan.model.CadreNonMembersEntity;
import com.devglan.model.CadreShgMembersEntity;
import com.devglan.model.LookUpMasterEntity;
import com.devglan.model.MemberAddressesDetailsEntity;
import com.devglan.model.MemberBankDetailsEntity;
import com.devglan.model.MemberInsuranceEntity;
import com.devglan.model.MemberKYCDetailsEntity;
import com.devglan.model.MemberPhoneNoDetailsEntity;
import com.devglan.model.MemberProfileEntity;
import com.devglan.model.MemberSystemTagsEntity;
import com.devglan.utils.DateUtils;

public class MemberMapper {

    //Member PHONE NO
    public static MemberPhoneNoDetailsEntity map(final MemberPhoneNoDetails memberPhoneNoDetails) {
        MemberPhoneNoDetailsEntity memberPhoneNoDetailsEntity = new MemberPhoneNoDetailsEntity();
        try {

            memberPhoneNoDetailsEntity.setMemberPhoneDetailsId(memberPhoneNoDetails.getMember_phone_details_id());
            memberPhoneNoDetailsEntity.setCboId(memberPhoneNoDetails.getCbo_id());
            memberPhoneNoDetailsEntity.setPhoneGUID(memberPhoneNoDetails.getPhone_guid());
            memberPhoneNoDetailsEntity.setMemberGUID(memberPhoneNoDetails.getMember_guid());
            memberPhoneNoDetailsEntity.setMemberCode(memberPhoneNoDetails.getMember_code());
            memberPhoneNoDetailsEntity.setPhoneNo(memberPhoneNoDetails.getPhone_no());
            memberPhoneNoDetailsEntity.setPhoneOwnership(memberPhoneNoDetails.getPhone_ownership());
            memberPhoneNoDetailsEntity.setPhoneOwnershipDetails(memberPhoneNoDetails.getPhone_ownership_details());
            memberPhoneNoDetailsEntity.setEntrySource(memberPhoneNoDetails.getEntry_source());
            memberPhoneNoDetailsEntity.setIsEdited(memberPhoneNoDetails.getIs_edited());
            memberPhoneNoDetailsEntity.setCreatedDate(DateUtils.secondsToTimestampConverter(memberPhoneNoDetails.getCreated_date()));
            memberPhoneNoDetailsEntity.setLastUploadedDate(new Timestamp(System.currentTimeMillis()));
            memberPhoneNoDetailsEntity.setUpdatedDate(memberPhoneNoDetails.getUpdated_date()!=null ?
                    DateUtils.secondsToTimestampConverter(memberPhoneNoDetails.getUpdated_date()) : null);
            memberPhoneNoDetailsEntity.setIsDefault(memberPhoneNoDetails.getIs_default());
            memberPhoneNoDetailsEntity.setCreatedBy(memberPhoneNoDetails.getCreated_by());
            memberPhoneNoDetailsEntity.setUpdatedBy(memberPhoneNoDetails.getUpdated_by());
            memberPhoneNoDetailsEntity.setUploadedBy(memberPhoneNoDetails.getUploaded_by());
            memberPhoneNoDetailsEntity.setActivationStatus(memberPhoneNoDetails.getActivation_status());
            memberPhoneNoDetailsEntity.setDedupStatus(memberPhoneNoDetails.getDedupl_status());
            Integer shortVal = 1;
            if(memberPhoneNoDetails.getIs_active()!=null){
                if(memberPhoneNoDetails.getIs_active().equals(shortVal.shortValue()))
                    memberPhoneNoDetailsEntity.setActive(Boolean.TRUE);
                else{
                    memberPhoneNoDetailsEntity.setActive(Boolean.FALSE);
                }
            }
            else{
                memberPhoneNoDetailsEntity.setActive(Boolean.TRUE);
            }

            memberPhoneNoDetailsEntity.setValidFrom(memberPhoneNoDetails.getValid_from()!=null ?
                    DateUtils.secondsToDateConverter(memberPhoneNoDetails.getValid_from()) : null);

            //VALID TILL
            memberPhoneNoDetailsEntity.setValidTill(memberPhoneNoDetails.getValid_till()!=null ?
                    DateUtils.secondsToDateConverter(memberPhoneNoDetails.getValid_till()) : null);
            memberPhoneNoDetailsEntity.setIsVerified(memberPhoneNoDetails.getIs_verified());
            memberPhoneNoDetailsEntity.setIsComplete(memberPhoneNoDetails.getIs_complete());
        }
        catch(Exception e){
            e.printStackTrace();
        }
        return memberPhoneNoDetailsEntity;
    }

    public static MemberPhoneNoDetails map(final MemberPhoneNoDetailsEntity memberPhoneNoDetailsEntity) throws ParseException {
        MemberPhoneNoDetails memberPhoneNoDetails = new MemberPhoneNoDetails();
        memberPhoneNoDetails.setMember_phone_details_id(memberPhoneNoDetailsEntity.getMemberPhoneDetailsId());
        memberPhoneNoDetails.setCbo_id(memberPhoneNoDetailsEntity.getCboId());
        memberPhoneNoDetails.setPhone_guid(memberPhoneNoDetailsEntity.getPhoneGUID());
        memberPhoneNoDetails.setMember_guid(memberPhoneNoDetailsEntity.getMemberGUID());
        memberPhoneNoDetails.setMember_code(memberPhoneNoDetailsEntity.getMemberCode());
        memberPhoneNoDetails.setPhone_no(memberPhoneNoDetailsEntity.getPhoneNo());
        memberPhoneNoDetails.setPhone_ownership(memberPhoneNoDetailsEntity.getPhoneOwnership());
        memberPhoneNoDetails.setPhone_ownership_details(memberPhoneNoDetailsEntity.getPhoneOwnershipDetails());
        memberPhoneNoDetails.setEntry_source(memberPhoneNoDetailsEntity.getEntrySource());
        memberPhoneNoDetails.setIs_edited(0);
        memberPhoneNoDetails.setIs_default(memberPhoneNoDetailsEntity.getIsDefault());
        memberPhoneNoDetails.setCreated_by(memberPhoneNoDetailsEntity.getCreatedBy());
        memberPhoneNoDetails.setUpdated_by(memberPhoneNoDetailsEntity.getUpdatedBy());
        memberPhoneNoDetails.setUploaded_by(memberPhoneNoDetailsEntity.getUploadedBy());
        memberPhoneNoDetails.setActivation_status(memberPhoneNoDetailsEntity.getActivationStatus());
        memberPhoneNoDetails.setDedupl_status(memberPhoneNoDetailsEntity.getDedupStatus());
        memberPhoneNoDetails.setValid_from(memberPhoneNoDetailsEntity.getValidFrom()!=null ?
                DateUtils.dateToSecondsConverter(memberPhoneNoDetailsEntity.getValidFrom()) : null);
        memberPhoneNoDetails.setValid_till(memberPhoneNoDetailsEntity.getValidTill()!=null ?
                DateUtils.dateToSecondsConverter(memberPhoneNoDetailsEntity.getValidTill()) : null);
        memberPhoneNoDetails.setCreated_date(DateUtils.TimestampToSecondsConverter(memberPhoneNoDetailsEntity.getCreatedDate()));
        memberPhoneNoDetails.setUpdated_date(memberPhoneNoDetailsEntity.getUpdatedDate()!=null ?
                DateUtils.TimestampToSecondsConverter(memberPhoneNoDetailsEntity.getUpdatedDate()) : null);
        memberPhoneNoDetails.setUploaded_date(memberPhoneNoDetailsEntity.getLastUploadedDate()!=null ?
                DateUtils.TimestampToSecondsConverter(memberPhoneNoDetailsEntity.getLastUploadedDate()):null);
        Integer shortVal = 1;
        Integer shortValZero = 0;
        if(memberPhoneNoDetailsEntity.getActive()!=null) {
            if(memberPhoneNoDetailsEntity.getActive().equals(Boolean.TRUE))
                memberPhoneNoDetails.setIs_active(shortVal.shortValue());
            else
                memberPhoneNoDetails.setIs_active(shortValZero.shortValue());
        }
        memberPhoneNoDetails.setIs_verified(memberPhoneNoDetailsEntity.getIsVerified());
        memberPhoneNoDetails.setIs_complete (memberPhoneNoDetailsEntity.getIsComplete());
        return memberPhoneNoDetails;
    }

    //Member ADDRESS MAPPING
    public static MemberAddressesDetailsEntity map(final MemberAddresses memberAddresses) {
        MemberAddressesDetailsEntity memberAddressesDetailsEntity = new MemberAddressesDetailsEntity();
        try {
            memberAddressesDetailsEntity.setMemberAddressId(memberAddresses.getMember_address_id());
            memberAddressesDetailsEntity.setCboId(memberAddresses.getCbo_id());
            memberAddressesDetailsEntity.setMemberGUID(memberAddresses.getMember_guid());
            memberAddressesDetailsEntity.setAddressGUID(memberAddresses.getAddress_guid());
            memberAddressesDetailsEntity.setMemberCode(memberAddresses.getMember_code());
            memberAddressesDetailsEntity.setAddressType(memberAddresses.getAddress_type());
            memberAddressesDetailsEntity.setAddressLine1(memberAddresses.getAddress_line1());
            memberAddressesDetailsEntity.setAddressLine2(memberAddresses.getAddress_line2());
            memberAddressesDetailsEntity.setVillage(memberAddresses.getVillage_id());
            memberAddressesDetailsEntity.setLandmark(memberAddresses.getLandmark());
            memberAddressesDetailsEntity.setState(memberAddresses.getState_id());
            memberAddressesDetailsEntity.setDistrict(memberAddresses.getDistrict_id());
            memberAddressesDetailsEntity.setBlock_id(memberAddresses.getBlock_id());
            memberAddressesDetailsEntity.setPanchayat_id(memberAddresses.getPanchayat_id());
			memberAddressesDetailsEntity.setAddressLocation(memberAddresses.getAddress_location());
            memberAddressesDetailsEntity.setPostalCode(memberAddresses.getPostal_code());
            memberAddressesDetailsEntity.setStatus(memberAddresses.getStatus());
            memberAddressesDetailsEntity.setEntrySource(memberAddresses.getEntry_source());
            memberAddressesDetailsEntity.setIsEdited(memberAddresses.getIs_edited());
            Integer shortVal = 1;
            if(memberAddresses.getIs_active()!=null){
                if(memberAddresses.getIs_active().equals(shortVal.shortValue()))
                    memberAddressesDetailsEntity.setActive(Boolean.TRUE);
                else{
                    memberAddressesDetailsEntity.setActive(Boolean.FALSE);
                }
            }
            else{
                memberAddressesDetailsEntity.setActive(Boolean.TRUE);
            }
            memberAddressesDetailsEntity.setLastUploadedDate(new Timestamp(System.currentTimeMillis()));
            memberAddressesDetailsEntity.setCreatedBy(memberAddresses.getCreated_by());
            memberAddressesDetailsEntity.setUpdatedBy(memberAddresses.getUpdated_by());
            memberAddressesDetailsEntity.setCreatedDate(DateUtils.secondsToTimestampConverter(memberAddresses.getCreated_date()));
            memberAddressesDetailsEntity.setUpdatedDate(memberAddresses.getUpdated_date()!=null ?
                    DateUtils.secondsToTimestampConverter(memberAddresses.getUpdated_date()) : null);
            memberAddressesDetailsEntity.setIsVerified(memberAddresses.getIs_verified());
            memberAddressesDetailsEntity.setIsComplete(memberAddresses.getIs_complete());
        }
        catch(Exception e){
            e.printStackTrace();
        }
        return memberAddressesDetailsEntity;
    }

    public static MemberAddresses map(final MemberAddressesDetailsEntity memberAddressesDetailsEntity) throws ParseException {
        MemberAddresses memberAddresses = new MemberAddresses();
        memberAddresses.setMember_address_id(memberAddressesDetailsEntity.getMemberAddressId());
        memberAddresses.setCbo_id(memberAddressesDetailsEntity.getCboId());
        memberAddresses.setMember_guid(memberAddressesDetailsEntity.getMemberGUID());
        memberAddresses.setAddress_guid(memberAddressesDetailsEntity.getAddressGUID());
        memberAddresses.setMember_code(memberAddressesDetailsEntity.getMemberCode());
        memberAddresses.setAddress_type(memberAddressesDetailsEntity.getAddressType());
        memberAddresses.setAddress_line1(memberAddressesDetailsEntity.getAddressLine1());
        memberAddresses.setAddress_line2(memberAddressesDetailsEntity.getAddressLine2());
        memberAddresses.setVillage_id(memberAddressesDetailsEntity.getVillage());
        memberAddresses.setLandmark(memberAddressesDetailsEntity.getLandmark());
        memberAddresses.setState_id(memberAddressesDetailsEntity.getState());
        memberAddresses.setDistrict_id(memberAddressesDetailsEntity.getDistrict());
        memberAddresses.setBlock_id(memberAddressesDetailsEntity.getBlock_id());
        memberAddresses.setPanchayat_id(memberAddressesDetailsEntity.getPanchayat_id());
		 memberAddresses.setAddress_location(memberAddressesDetailsEntity.getAddressLocation());
        memberAddresses.setPostal_code(memberAddressesDetailsEntity.getPostalCode());
        memberAddresses.setStatus(memberAddressesDetailsEntity.getStatus());
        memberAddresses.setEntry_source(memberAddressesDetailsEntity.getEntrySource());
        memberAddresses.setIs_edited(0);
        memberAddresses.setCreated_by(memberAddressesDetailsEntity.getCreatedBy());
        memberAddresses.setUpdated_by(memberAddressesDetailsEntity.getUpdatedBy());
        memberAddresses.setCreated_date(DateUtils.TimestampToSecondsConverter(memberAddressesDetailsEntity.getCreatedDate()));
        memberAddresses.setUpdated_date(memberAddressesDetailsEntity.getUpdatedDate()!=null ?
                DateUtils.TimestampToSecondsConverter(memberAddressesDetailsEntity.getUpdatedDate()) : null);
        memberAddresses.setUploaded_date(memberAddressesDetailsEntity.getLastUploadedDate()!=null ?
                DateUtils.TimestampToSecondsConverter(memberAddressesDetailsEntity.getLastUploadedDate()):null);
        Integer shortVal = 1;
        Integer shortValZero = 0;
        if(memberAddressesDetailsEntity.getActive()!=null) {
            if(memberAddressesDetailsEntity.getActive().equals(Boolean.TRUE))
                memberAddresses.setIs_active(shortVal.shortValue());
            else
                memberAddresses.setIs_active(shortValZero.shortValue());
        }
        memberAddresses.setIs_verified(memberAddressesDetailsEntity.getIsVerified());
        memberAddresses.setIs_complete (memberAddressesDetailsEntity.getIsComplete());
        return memberAddresses;
    }

    //
  //Cadre SHG MAPPING
  //@adish 15092021

    public static CadreShgMembersEntity map ( final CadreShgMembersModel cadreShgMembersModel)
    {
        CadreShgMembersEntity cadreShgMembersEntity = new CadreShgMembersEntity();
        cadreShgMembersEntity.setUid(cadreShgMembersModel.getUid());
        cadreShgMembersEntity.setCadreGuid(cadreShgMembersModel.getCadre_guid());
        cadreShgMembersEntity.setCboId(cadreShgMembersModel.getCbo_id());
        cadreShgMembersEntity.setMemberId(cadreShgMembersModel.getMember_id());
        cadreShgMembersEntity.setCadreRoleCode(cadreShgMembersModel.getCadre_role_code());
        cadreShgMembersEntity.setCadreCatCode(cadreShgMembersModel.getCadre_cat_code());
        cadreShgMembersEntity.setDateJoining(cadreShgMembersModel.getDate_joining() != null ? DateUtils.secondsToDateConverter(cadreShgMembersModel.getDate_joining()) : null);
        cadreShgMembersEntity.setDateLeaving(cadreShgMembersModel.getDate_leaving() != null ? DateUtils.secondsToDateConverter(cadreShgMembersModel.getDate_leaving()) : null);
        cadreShgMembersEntity.setCreatedBy(cadreShgMembersModel.getCreated_by());
        cadreShgMembersEntity.setCreatedOn(cadreShgMembersModel.getCreated_on() != null ? DateUtils.secondsToTimestampConverter(cadreShgMembersModel.getCreated_on()) : null);
        cadreShgMembersEntity.setUpdatedBy(cadreShgMembersModel.getUpdated_by());
        cadreShgMembersEntity.setUpdatedOn(cadreShgMembersModel.getUpdated_on() != null ? DateUtils.secondsToTimestampConverter(cadreShgMembersModel.getUpdated_on()) : null);
        cadreShgMembersEntity.setUploadedBy(cadreShgMembersModel.getUploaded_by());
        cadreShgMembersEntity.setUploadedOn(cadreShgMembersModel.getUploaded_on() != null ? DateUtils.secondsToTimestampConverter(cadreShgMembersModel.getUploaded_on()) : null);
        cadreShgMembersEntity.setMemberGuid(cadreShgMembersModel.getMember_guid());
        Integer shortVal = 1;
        if(cadreShgMembersModel.getIs_active()!=null){
            if(cadreShgMembersModel.getIs_active().equals(shortVal.shortValue()))
                cadreShgMembersEntity.setIsActive(Boolean.TRUE);
            else{
                cadreShgMembersEntity.setIsActive(Boolean.FALSE);
            }
        }
        else{
            cadreShgMembersEntity.setIsActive(Boolean.TRUE);
        }
        cadreShgMembersEntity.setIsEdited(cadreShgMembersModel.getIs_edited());
        cadreShgMembersEntity.setIsComplete(cadreShgMembersModel.getIs_complete());
        return cadreShgMembersEntity;
    }

    public static CadreShgMembersModel map ( final CadreShgMembersEntity cadreShgMembersEntity) throws ParseException {
        {
            CadreShgMembersModel cadreShgMembersModel = new CadreShgMembersModel();
            cadreShgMembersModel.setUid(cadreShgMembersEntity.getUid());
            cadreShgMembersModel.setCadre_guid(cadreShgMembersEntity.getCadreGuid());
            cadreShgMembersModel.setCbo_id(cadreShgMembersEntity.getCboId());
            cadreShgMembersModel.setMember_id(cadreShgMembersEntity.getMemberId());
            cadreShgMembersModel.setCadre_role_code(cadreShgMembersEntity.getCadreRoleCode());
            cadreShgMembersModel.setCadre_cat_code(cadreShgMembersEntity.getCadreCatCode());
            cadreShgMembersModel.setDate_joining(cadreShgMembersEntity.getDateJoining() != null ? DateUtils.dateToSecondsConverter(cadreShgMembersEntity.getDateJoining()) : null);
            cadreShgMembersModel.setDate_leaving(cadreShgMembersEntity.getDateLeaving() != null ? DateUtils.dateToSecondsConverter(cadreShgMembersEntity.getDateLeaving()) : null);
            cadreShgMembersModel.setCreated_by(cadreShgMembersEntity.getCreatedBy());
            cadreShgMembersModel.setCreated_on(cadreShgMembersEntity.getCreatedOn() != null ? DateUtils.TimestampToSecondsConverter(cadreShgMembersEntity.getCreatedOn()) : null);
            cadreShgMembersModel.setUpdated_by(cadreShgMembersEntity.getUpdatedBy());
            cadreShgMembersModel.setUpdated_on(cadreShgMembersEntity.getUpdatedOn() != null ? DateUtils.TimestampToSecondsConverter(cadreShgMembersEntity.getUpdatedOn()) : null);
            cadreShgMembersModel.setUploaded_by(cadreShgMembersEntity.getUploadedBy());
            cadreShgMembersModel.setUploaded_on(cadreShgMembersEntity.getUploadedOn() != null ? DateUtils.TimestampToSecondsConverter(cadreShgMembersEntity.getUploadedOn()) : null);
          cadreShgMembersModel.setMember_guid(cadreShgMembersEntity.getMemberGuid());
            Integer shortVal = 1;
            Integer shortValZero = 0;
            if(cadreShgMembersEntity.getIsActive()!=null) {
                if(cadreShgMembersEntity.getIsActive().equals(Boolean.TRUE))
                    cadreShgMembersModel.setIs_active(shortVal.shortValue());
                else
                    cadreShgMembersModel.setIs_active(shortValZero.shortValue());
            }

          cadreShgMembersModel.setIs_edited(cadreShgMembersEntity.getIsEdited());
          cadreShgMembersModel.setIs_complete(cadreShgMembersEntity.getIsComplete());
            return cadreShgMembersModel;
        }
    }
/*
    public static CadreNonMembersEntity map (final CadreNonMembersModel cadreNonMembersModel)
    {
        CadreNonMembersEntity cadreNonMembersEntity = new CadreNonMembersEntity();
        cadreNonMembersEntity.setUid(cadreNonMembersModel.getUid());
        cadreNonMembersEntity.setCadreGuid(cadreNonMembersModel.getCadre_guid());
        cadreNonMembersEntity.setVillageId(cadreNonMembersModel.getVillage_id());
        cadreNonMembersEntity.setMemberName(cadreNonMembersModel.getMember_name());
        cadreNonMembersEntity.setCadreRoleCode(cadreNonMembersModel.getCadre_role_code());
        cadreNonMembersEntity.setCadreCatCode(cadreNonMembersModel.getCadre_cat_code());
        cadreNonMembersEntity.setDateJoining(cadreNonMembersModel.getDate_joining() != null ? DateUtils.secondsToDateConverter(cadreNonMembersModel.getDateJoining()) : null);
        cadreNonMembersEntity.setDateLeaving(cadreNonMembersModel.getDate_leaving() != null ? DateUtils.secondsToDateConverter(cadreNonMembersModel.getDateLeaving()) : null);
        cadreNonMembersEntity.setCreatedBy(cadreNonMembersModel.getCreated_by());
        cadreNonMembersEntity.setCreatedOn(cadreNonMembersModel.getCreated_on() != null ? DateUtils.secondsToTimestampConverter(cadreNonMembersModel.getCreatedOn()) : null);
        cadreNonMembersEntity.setUpdatedBy(cadreNonMembersModel.getUpdated_by());
        cadreNonMembersEntity.setUpdatedOn(cadreNonMembersModel.getUpdated_on() != null ? DateUtils.secondsToTimestampConverter(cadreNonMembersModel.getUpdatedOn()) : null);
        cadreNonMembersEntity.setUploadedBy(cadreNonMembersModel.getUploaded_by());
        cadreNonMembersEntity.setUploadedOn(cadreNonMembersModel.getUploaded_on() != null ? DateUtils.secondsToTimestampConverter(cadreNonMembersModel.getUploadedOn()) : null);
        return cadreNonMembersEntity;
    }
    public static CadreNonMembersModel map (final CadreNonMembersEntity cadreNonMembersEntity) throws ParseException {

        {
            CadreNonMembersModel cadreNonMembersModel = new CadreNonMembersModel();
            cadreNonMembersModel.setUid(cadreNonMembersEntity.getUid());
            cadreNonMembersModel.setCadre_guid(cadreNonMembersEntity.getCadreGuid());
            cadreNonMembersModel.setVillage_id(cadreNonMembersEntity.getVillageId());
            cadreNonMembersModel.setMember_name(cadreNonMembersEntity.getMemberName());
            cadreNonMembersModel.setCadre_role_code(cadreNonMembersEntity.getCadreRoleCode());
            cadreNonMembersModel.setCadre_cat_code(cadreNonMembersEntity.getCadreCatCode());
            cadreNonMembersModel.setDate_joining(cadreNonMembersEntity.getDateJoining() != null ? DateUtils.dateToSecondsConverter(cadreNonMembersEntity.getDateJoining()) : null);
            cadreNonMembersModel.setDate_leaving(cadreNonMembersEntity.getDateLeaving() != null ? DateUtils.dateToSecondsConverter(cadreNonMembersEntity.getDateLeaving()) : null);
            cadreNonMembersModel.setCreated_by(cadreNonMembersEntity.getCreatedBy());
            cadreNonMembersModel.setCreated_on(cadreNonMembersEntity.getCreatedOn() != null ? DateUtils.TimestampToSecondsConverter(cadreNonMembersEntity.getCreatedOn()) : null);
            cadreNonMembersModel.setUpdated_by(cadreNonMembersEntity.getUpdatedBy());
            cadreNonMembersModel.setUpdated_on(cadreNonMembersEntity.getUpdatedOn() != null ? DateUtils.TimestampToSecondsConverter(cadreNonMembersEntity.getUpdatedOn()) : null);
            cadreNonMembersModel.setUpdated_by(cadreNonMembersEntity.getUploadedBy());
            cadreNonMembersModel.setUploaded_on(cadreNonMembersEntity.getUploadedOn() != null ? DateUtils.TimestampToSecondsConverter(cadreNonMembersEntity.getUploadedOn()) : null);
            return cadreNonMembersModel;
        }
    }
*/
    //Adish    
    //Member BANK MAPPING
    public static MemberBankDetailsEntity map(final MemberBank memberBank) {
        MemberBankDetailsEntity memberBankDetailsEntity = new MemberBankDetailsEntity();
        try {

            memberBankDetailsEntity.setMemberBankDetailsId(memberBank.getMember_bank_details_id());
            memberBankDetailsEntity.setCboId(memberBank.getCbo_id());
            memberBankDetailsEntity.setMemberGUID(memberBank.getMember_guid());
            memberBankDetailsEntity.setBankGUID(memberBank.getBank_guid());
            memberBankDetailsEntity.setPassbookFirstPage(memberBank.getPassbook_first_page());
            memberBankDetailsEntity.setBankPassbookName(memberBank.getBank_passbook_name());
            memberBankDetailsEntity.setMemberCode(memberBank.getMember_code());
            memberBankDetailsEntity.setAccountNo(memberBank.getAccount_no());
            memberBankDetailsEntity.setBankId(memberBank.getBank_id());
            memberBankDetailsEntity.setMemBranchCode(memberBank.getMem_branch_code());
            memberBankDetailsEntity.setIfscCode(memberBank.getIfsc_code());
            memberBankDetailsEntity.setBankId(memberBank.getBank_id());
            memberBankDetailsEntity.setAccountType(memberBank.getAccount_type());
            memberBankDetailsEntity.setStatus(memberBank.getStatus());
            memberBankDetailsEntity.setGlCode(memberBank.getGl_code());
            memberBankDetailsEntity.setSameAsGroup(memberBank.getSame_as_group());
            memberBankDetailsEntity.setEntrySource(memberBank.getEntry_source());
            memberBankDetailsEntity.setIsEdited(memberBank.getIs_edited());
            memberBankDetailsEntity.setLastUploadedDate(new Timestamp(System.currentTimeMillis()));
            memberBankDetailsEntity.setIsDefaultAccount(memberBank.getIs_default_account());
            memberBankDetailsEntity.setCreatedDate(DateUtils.secondsToTimestampConverter(memberBank.getCreated_date()));
            memberBankDetailsEntity.setUpdatedDate(memberBank.getUpdated_date()!=null ?
                    DateUtils.secondsToTimestampConverter(memberBank.getUpdated_date()) : null);
            memberBankDetailsEntity.setCreatedBy(memberBank.getCreated_by());
            memberBankDetailsEntity.setUpdatedBy(memberBank.getUpdated_by());
            memberBankDetailsEntity.setUploadedBy(memberBank.getUploaded_by());
            memberBankDetailsEntity.setActivationStatus(memberBank.getActivation_status());
            memberBankDetailsEntity.setDedupStatus(memberBank.getDedupl_status());
            memberBankDetailsEntity.setAccountOpenDate(memberBank.getAccount_open_date()!=null ?
                    DateUtils.secondsToDateConverter(memberBank.getAccount_open_date()) : null);
            Integer shortVal = 1;
            if(memberBank.getIs_active()!=null){
                if(memberBank.getIs_active().equals(shortVal.shortValue()))
                    memberBankDetailsEntity.setActive(Boolean.TRUE);
                else{
                    memberBankDetailsEntity.setActive(Boolean.FALSE);
                }
            }
            else{
                memberBankDetailsEntity.setActive(Boolean.TRUE);
            }

            memberBankDetailsEntity.setClosingDate(memberBank.getClosing_date()!=null ?
                    DateUtils.secondsToDateConverter(memberBank.getClosing_date()) : null);
					
			//02-04-21
            memberBankDetailsEntity.setIdentifyDuplicate(memberBank.getIdentified_duplicates());
            memberBankDetailsEntity.setNpciStatus(memberBank.getNpci_status());
            memberBankDetailsEntity.setIsVerified(memberBank.getIs_verified());
            memberBankDetailsEntity.setIsComplete(memberBank.getIs_complete());
            memberBankDetailsEntity.setInactiveDate((memberBank.getInactive_date() != null) ? DateUtils.secondsToDateConverter(memberBank.getInactive_date()) : null);
        }
        catch(Exception e){
            e.printStackTrace();
        }
        return memberBankDetailsEntity;
    }

    public static MemberBank map(final MemberBankDetailsEntity memberBankDetailsEntity) throws ParseException {
        MemberBank memberBank = new MemberBank();
        memberBank.setMember_bank_details_id(memberBankDetailsEntity.getMemberBankDetailsId());
        memberBank.setCbo_id(memberBankDetailsEntity.getCboId());
        memberBank.setMember_guid(memberBankDetailsEntity.getMemberGUID());
        memberBank.setBank_guid(memberBankDetailsEntity.getBankGUID());
        memberBank.setPassbook_first_page(memberBankDetailsEntity.getPassbookFirstPage());
        memberBank.setBank_passbook_name(memberBankDetailsEntity.getBankPassbookName());
        memberBank.setMember_code(memberBankDetailsEntity.getMemberCode());
        memberBank.setAccount_no(memberBankDetailsEntity.getAccountNo());
        memberBank.setBank_id(memberBankDetailsEntity.getBankId());
        memberBank.setMem_branch_code(memberBankDetailsEntity.getMemBranchCode());
        memberBank.setIfsc_code(memberBankDetailsEntity.getIfscCode());
        memberBank.setAccount_type(memberBankDetailsEntity.getAccountType());
        memberBank.setStatus(memberBankDetailsEntity.getStatus());
        memberBank.setGl_code(memberBankDetailsEntity.getGlCode());
        memberBank.setSame_as_group(memberBankDetailsEntity.getSameAsGroup());
        memberBank.setEntry_source(memberBankDetailsEntity.getEntrySource());
        memberBank.setIs_edited(0);

        memberBank.setCreated_by(memberBankDetailsEntity.getCreatedBy());
        memberBank.setUpdated_by(memberBankDetailsEntity.getUpdatedBy());
        memberBank.setUploaded_by(memberBankDetailsEntity.getUploadedBy());
        memberBank.setActivation_status(memberBankDetailsEntity.getActivationStatus());
        memberBank.setDedupl_status(memberBankDetailsEntity.getDedupStatus());
        memberBank.setAccount_open_date(memberBankDetailsEntity.getAccountOpenDate()!=null ?
                DateUtils.dateToSecondsConverter(memberBankDetailsEntity.getAccountOpenDate()) : null);
        memberBank.setClosing_date(memberBankDetailsEntity.getClosingDate()!=null ?
                DateUtils.dateToSecondsConverter(memberBankDetailsEntity.getClosingDate()) : null);
        memberBank.setUpdated_date(memberBankDetailsEntity.getUpdatedDate()!=null ?
                DateUtils.TimestampToSecondsConverter(memberBankDetailsEntity.getUpdatedDate()) : null);
        memberBank.setCreated_date(memberBankDetailsEntity.getCreatedDate()!=null ?
                DateUtils.TimestampToSecondsConverter(memberBankDetailsEntity.getCreatedDate()):null);
        memberBank.setUploaded_date(memberBankDetailsEntity.getLastUploadedDate()!=null ?
                DateUtils.TimestampToSecondsConverter(memberBankDetailsEntity.getLastUploadedDate()) : null);
        Integer shortVal = 1;
        Integer shortValZero = 0;
        if(memberBankDetailsEntity.getActive()!=null) {
            if(memberBankDetailsEntity.getActive().equals(Boolean.TRUE))
                memberBank.setIs_active(shortVal.shortValue());
            else
                memberBank.setIs_active(shortValZero.shortValue());
        }
        memberBank.setIs_default_account(memberBankDetailsEntity.getIsDefaultAccount());

        //02-04-21
        // memberBank.setIdentify_duplicate(memberBankDetailsEntity.getIdentifyDuplicate());
        memberBank.setNpci_status(memberBankDetailsEntity.getNpciStatus());
        memberBank.setIs_verified(memberBankDetailsEntity.getIsVerified());
        memberBank.setIs_complete (memberBankDetailsEntity.getIsComplete());
        memberBank.setInactive_date((memberBankDetailsEntity.getInactiveDate() != null) ? DateUtils.dateToSecondsConverter(memberBankDetailsEntity.getInactiveDate()) : null);
        return memberBank;
    }

    //SHG KYC MAPPING
    public static MemberKYCDetailsEntity map(final MemberKYCDetails memberKYCDetails) {
        MemberKYCDetailsEntity memberKYCDetailsEntity = new MemberKYCDetailsEntity();
        try {
            memberKYCDetailsEntity.setMemberKycDetailsId(memberKYCDetails.getMember_kyc_details_id());
            memberKYCDetailsEntity.setKycGUID(memberKYCDetails.getKyc_guid());
             memberKYCDetailsEntity.setActivationStatus(memberKYCDetails.getActivation_status());
             memberKYCDetailsEntity.setDeduplStatus(memberKYCDetails.getDedupl_status());
            memberKYCDetailsEntity.setCboId(memberKYCDetails.getCbo_id());
            memberKYCDetailsEntity.setMemberGUID(memberKYCDetails.getMember_guid());
            memberKYCDetailsEntity.setMemberCode(memberKYCDetails.getMember_code());
            memberKYCDetailsEntity.setKycType(memberKYCDetails.getKyc_type());
            memberKYCDetailsEntity.setKycNumber(memberKYCDetails.getKyc_number());
            memberKYCDetailsEntity.setDocumentId(memberKYCDetails.getDocument_id());
            memberKYCDetailsEntity.setStatus(memberKYCDetails.getStatus());
            memberKYCDetailsEntity.setEntrySource(memberKYCDetails.getEntry_source());
            memberKYCDetailsEntity.setIsEdited(memberKYCDetails.getIs_edited());
            memberKYCDetailsEntity.setLastUploadedDate(new Timestamp(System.currentTimeMillis()));
            memberKYCDetailsEntity.setCreatedBy(memberKYCDetails.getCreated_by());
            memberKYCDetailsEntity.setUpdatedBy(memberKYCDetails.getUpdated_by());
            memberKYCDetailsEntity.setUploadedBy(memberKYCDetails.getUploaded_by());
            Integer shortVal = 1;
            if(memberKYCDetails.getIs_active()!=null){
                if(memberKYCDetails.getIs_active().equals(shortVal.shortValue()))
                    memberKYCDetailsEntity.setActive(Boolean.TRUE);
                else{
                    memberKYCDetailsEntity.setActive(Boolean.FALSE);
                }
            }
            else{
                memberKYCDetailsEntity.setActive(Boolean.TRUE);
            }
            memberKYCDetailsEntity.setKycValidFrom(memberKYCDetails.getKyc_valid_from()!=null ?
                    DateUtils.secondsToDateConverter(memberKYCDetails.getKyc_valid_from()) : null);

            //VALID TILL
            memberKYCDetailsEntity.setKycValidTo(memberKYCDetails.getKyc_valid_to()!=null ?
                    DateUtils.secondsToDateConverter(memberKYCDetails.getKyc_valid_to()) : null);
            memberKYCDetailsEntity.setCreatedDate(DateUtils.secondsToTimestampConverter(memberKYCDetails.getCreated_date()));
            memberKYCDetailsEntity.setUpdatedDate(memberKYCDetails.getUpdated_date()!=null ?
                    DateUtils.secondsToTimestampConverter(memberKYCDetails.getUpdated_date()) : null);
            memberKYCDetailsEntity.setKycFrontDocOriginalName(memberKYCDetails.getKyc_front_doc_orig_name() !=null ?
                    memberKYCDetails.getKyc_front_doc_orig_name()  : null);
            memberKYCDetailsEntity.setKycRearDocOriginalName(memberKYCDetails.getKyc_rear_doc_orig_name() !=null ?
                    memberKYCDetails.getKyc_rear_doc_orig_name()  : null);
            memberKYCDetailsEntity.setDeduplStatus(memberKYCDetails.getDedupl_status());
            memberKYCDetailsEntity.setActivationStatus(memberKYCDetails.getActivation_status());
            memberKYCDetailsEntity.setIsVerified(memberKYCDetails.getIs_verified());
            memberKYCDetailsEntity.setIsComplete(memberKYCDetails.getIs_complete());
        }
        catch(Exception e){
            e.printStackTrace();
        }
        return memberKYCDetailsEntity;
    }

    public static MemberKYCDetails map(final MemberKYCDetailsEntity memberKYCDetailsEntity) {
        MemberKYCDetails memberKYCDetails = new MemberKYCDetails();
        try {
            memberKYCDetails.setMember_kyc_details_id(memberKYCDetailsEntity.getMemberKycDetailsId());
            memberKYCDetails.setKyc_guid(memberKYCDetailsEntity.getKycGUID());
           memberKYCDetails.setActivation_status(memberKYCDetailsEntity.getActivationStatus());
           memberKYCDetails.setDedupl_status(memberKYCDetailsEntity.getDeduplStatus());
            memberKYCDetails.setCbo_id(memberKYCDetailsEntity.getCboId());
            memberKYCDetails.setMember_guid(memberKYCDetailsEntity.getMemberGUID());
            memberKYCDetails.setMember_code(memberKYCDetailsEntity.getMemberCode());
            memberKYCDetails.setKyc_type(memberKYCDetailsEntity.getKycType());
            memberKYCDetails.setKyc_number(memberKYCDetailsEntity.getKycNumber());
            memberKYCDetails.setDocument_id(memberKYCDetailsEntity.getDocumentId());
            memberKYCDetails.setStatus(memberKYCDetailsEntity.getStatus());
            memberKYCDetails.setEntry_source(memberKYCDetailsEntity.getEntrySource());
            memberKYCDetails.setIs_edited(0);
            memberKYCDetails.setCreated_by(memberKYCDetailsEntity.getCreatedBy());
            memberKYCDetails.setUpdated_by(memberKYCDetailsEntity.getUpdatedBy());
            memberKYCDetails.setUploaded_by(memberKYCDetailsEntity.getUploadedBy());
            memberKYCDetails.setKyc_valid_from(memberKYCDetailsEntity.getKycValidFrom()!=null ?
                    DateUtils.dateToSecondsConverter(memberKYCDetailsEntity.getKycValidFrom()) : null);
            memberKYCDetails.setKyc_valid_to(memberKYCDetailsEntity.getKycValidTo()!=null ?
                    DateUtils.dateToSecondsConverter(memberKYCDetailsEntity.getKycValidTo()) : null);
            memberKYCDetails.setUpdated_date(memberKYCDetailsEntity.getUpdatedDate()!=null ?
                    DateUtils.TimestampToSecondsConverter(memberKYCDetailsEntity.getUpdatedDate()) : null);
            memberKYCDetails.setCreated_date(memberKYCDetailsEntity.getCreatedDate()!=null ?
                    DateUtils.TimestampToSecondsConverter(memberKYCDetailsEntity.getCreatedDate()):null);
            memberKYCDetails.setUploaded_date(memberKYCDetailsEntity.getLastUploadedDate()!=null ?
                    DateUtils.TimestampToSecondsConverter(memberKYCDetailsEntity.getLastUploadedDate()):null);
            Integer shortVal = 1;
            Integer shortValZero = 0;
            if(memberKYCDetailsEntity.getActive()!=null) {
                if(memberKYCDetailsEntity.getActive().equals(Boolean.TRUE))
                    memberKYCDetails.setIs_active(shortVal.shortValue());
                else
                    memberKYCDetails.setIs_active(shortValZero.shortValue());
            }
            memberKYCDetails.setKyc_front_doc_orig_name(memberKYCDetailsEntity.getKycFrontDocOriginalName());
            memberKYCDetails.setKyc_rear_doc_orig_name(memberKYCDetailsEntity.getKycRearDocOriginalName());
            memberKYCDetails.setDedupl_status(memberKYCDetailsEntity.getDeduplStatus());
            memberKYCDetails.setActivation_status(memberKYCDetailsEntity.getActivationStatus());
            memberKYCDetails.setIs_verified(memberKYCDetailsEntity.getIsVerified());
            memberKYCDetails.setIs_complete (memberKYCDetailsEntity.getIsComplete());
        }
        catch(Exception e){
            e.printStackTrace();
        }
        return memberKYCDetails;
    }

    //SHG PROFILE
    public static MemberProfileEntity map(final MemberProfile memberProfile) {
        MemberProfileEntity memberProfileEntity = new MemberProfileEntity();
        Integer shortVal = 1;
        try {
            memberProfileEntity.setMemberId(memberProfile.getMember_id());
            memberProfileEntity.setMemberCode(memberProfile.getMember_code());
            memberProfileEntity.setCboId(memberProfile.getCbo_id());
            memberProfileEntity.setCboGUID(memberProfile.getCbo_guid());
            memberProfileEntity.setMemberGUID(memberProfile.getMember_guid());
            memberProfileEntity.setGroupMCode(memberProfile.getGroup_m_code());
            memberProfileEntity.setSeqNo(memberProfile.getSeq_no());
            memberProfileEntity.setMemberName(memberProfile.getMember_name());
            memberProfileEntity.setMemberNameLocal(memberProfile.getMember_name_local());
            memberProfileEntity.setFatherHusband(memberProfile.getFather_husband());
            memberProfileEntity.setRelationName(memberProfile.getRelation_name());
            memberProfileEntity.setRelationNameLocal(memberProfile.getRelation_name_local());
            memberProfileEntity.setGender(memberProfile.getGender());
            memberProfileEntity.setMaritalStatus(memberProfile.getMarital_status());
            memberProfileEntity.setReligion(memberProfile.getReligion());
            memberProfileEntity.setSocialCategory(memberProfile.getSocial_category());
            memberProfileEntity.setTribalCategory(memberProfile.getTribal_category());
            memberProfileEntity.setBpl(memberProfile.getBpl());
            memberProfileEntity.setBplNumber(memberProfile.getBpl_number());
            memberProfileEntity.setPipCategory(memberProfile.getPip_category());
            memberProfileEntity.setConsentFormImage(memberProfile.getConsent_form_image());
            memberProfileEntity.setIsInsurance(memberProfile.getIs_insurance());
            memberProfileEntity.setPipDate(memberProfile.getPip_date() !=null ?
                    DateUtils.secondsToDateConverter(memberProfile.getPip_date()) : null);
            memberProfileEntity.setHighestEducationLevel(memberProfile.getHighest_education_level());
            memberProfileEntity.setDobAvailable(memberProfile.getDob_available());
            memberProfileEntity.setDob(memberProfile.getDob() !=null ?
                    DateUtils.secondsToDateConverterLong(memberProfile.getDob()) : null);
            memberProfileEntity.setAge(memberProfile.getAge());
            memberProfileEntity.setAgeAsOn((memberProfile.getAge_as_on() != null) ?
                    DateUtils.secondsToDateConverter(memberProfile.getAge_as_on()) : null);
            memberProfileEntity.setMinority(memberProfile.getMinority());

            memberProfileEntity.setIsDisabled(memberProfile.getIs_disabled());
            memberProfileEntity.setDisabilityDetails(memberProfile.getDisability_details());
            memberProfileEntity.setWellbeingCategory(memberProfile.getWellbeing_category());
            memberProfileEntity.setPrimaryOccupation(memberProfile.getPrimary_occupation());
            memberProfileEntity.setSecondaryOccupation(memberProfile.getSecondary_occupation());
            memberProfileEntity.setTertiaryOccupation(memberProfile.getTertiary_occupation());
            memberProfileEntity.setJoiningDate(memberProfile.getJoining_date() !=null ?
                    DateUtils.secondsToDateConverter(memberProfile.getJoining_date()) : null);

            memberProfileEntity.setLeavingDate(memberProfile.getLeaving_date() !=null ?
                    DateUtils.secondsToDateConverter(memberProfile.getLeaving_date()) : null);
            memberProfileEntity.setReasonForLeaving(memberProfile.getReason_for_leaving());
            memberProfileEntity.setIfMinorMemberReplaced(memberProfile.getIf_minor_member_replaced());
            memberProfileEntity.setGuardianName(memberProfile.getGuardian_name());
            memberProfileEntity.setGuardianNameLocal(memberProfile.getGuardian_name_local());
            memberProfileEntity.setGuardianRelation(memberProfile.getGuardian_relation());
            memberProfileEntity.setDesignation(memberProfile.getDesignation());
            memberProfileEntity.setStatus(memberProfile.getStatus());
            memberProfileEntity.setHouseHoldCode(memberProfile.getHouse_hold_code());
            memberProfileEntity.setHeadHouseHold(memberProfile.getHead_house_hold());
            memberProfileEntity.setInsurance(memberProfile.getInsurance());
            memberProfileEntity.setMarkedAsDefaulter(memberProfile.getMarked_as_defaulter());
            memberProfileEntity.setMarkedAsDefaulterDate(memberProfile.getMarked_as_defaulter_date() !=null
                    ? DateUtils.secondsToDateConverter(memberProfile.getMarked_as_defaulter_date()) : null);
            memberProfileEntity.setRecordModified(memberProfile.getRecord_modified());
            memberProfileEntity.setLastSyncDate(memberProfile.getLast_sync_date() !=null ?
                    DateUtils.secondsToTimestampConverter(memberProfile.getLast_sync_date()) : null);
            memberProfileEntity.setUpdatedDate(memberProfile.getUpdated_date() !=null ?
                    DateUtils.secondsToTimestampConverter(memberProfile.getUpdated_date()) : null);
            memberProfileEntity.setCreatedDate(
                    DateUtils.secondsToTimestampConverter(memberProfile.getCreated_date()));
            memberProfileEntity.setLastUploadedDate(new Timestamp(System.currentTimeMillis()));
            memberProfileEntity.setEntrySource(memberProfile.getEntry_source());
            memberProfileEntity.setIsEdited(memberProfile.getIs_edited());

            if(memberProfile.getIs_active()!=null){
                if(memberProfile.getIs_active().equals(shortVal.shortValue()))
                    memberProfileEntity.setActive(Boolean.TRUE);
                else{
                    memberProfileEntity.setActive(Boolean.FALSE);
                }
            }
            else{
                memberProfileEntity.setActive(Boolean.TRUE);
            }
            memberProfileEntity.setMemActivationStatus(memberProfile.getMem_activation_status());
            memberProfileEntity.setMemDedupStatus(memberProfile.getMem_dedup_status());
            memberProfileEntity.setCreatedBy(memberProfile.getCreated_by());
            memberProfileEntity.setUpdatedBy(memberProfile.getUpdated_by());
            memberProfileEntity.setUploadedBy(memberProfile.getUploaded_by());
            memberProfileEntity.setReadFlag(Boolean.FALSE);
            memberProfileEntity.setCheckerRemark(memberProfile.getChecker_remarks()!=null ? memberProfile.getChecker_remarks() : null);
            memberProfileEntity.setMemberImage(memberProfile.getMember_image());
            memberProfileEntity.setMemActivationStatus(memberProfile.getMem_activation_status());
            memberProfileEntity.setApproveStatus(memberProfile.getApprove_status());
            memberProfileEntity.setIsVerified(memberProfile.getIs_verified());
            memberProfileEntity.setIsComplete(memberProfile.getIs_complete());
        }
        catch(Exception e){
            e.printStackTrace();
        }
        return memberProfileEntity;

    }

    public static MemberProfile map(final MemberProfileEntity memberProfileEntity) throws ParseException {
        MemberProfile memberProfile = new MemberProfile();
        memberProfile.setMember_id(memberProfileEntity.getMemberId());
        memberProfile.setMember_code(memberProfileEntity.getMemberCode());
        memberProfile.setCbo_id(memberProfileEntity.getCboId());
        memberProfile.setCbo_guid(memberProfileEntity.getCboGUID());
        memberProfile.setMember_guid(memberProfileEntity.getMemberGUID());
        memberProfile.setGroup_m_code(memberProfileEntity.getGroupMCode());
        memberProfile.setSeq_no(memberProfileEntity.getSeqNo());
        memberProfile.setMember_name(memberProfileEntity.getMemberName());
        memberProfile.setMember_name_local(memberProfileEntity.getMemberNameLocal());
        memberProfile.setFather_husband(memberProfileEntity.getFatherHusband());
        memberProfile.setRelation_name(memberProfileEntity.getRelationName());
        memberProfile.setRelation_name_local(memberProfileEntity.getRelationNameLocal());
        memberProfile.setGender(memberProfileEntity.getGender());
        memberProfile.setMarital_status(memberProfileEntity.getMaritalStatus());
        memberProfile.setReligion(memberProfileEntity.getReligion());
        memberProfile.setSocial_category(memberProfileEntity.getSocialCategory());
        memberProfile.setTribal_category(memberProfileEntity.getTribalCategory());
        memberProfile.setBpl(memberProfileEntity.getBpl());
        memberProfile.setBpl_number(memberProfileEntity.getBplNumber());
        memberProfile.setPip_category(memberProfileEntity.getPipCategory());
        memberProfile.setConsent_form_image(memberProfileEntity.getConsentFormImage());
        memberProfile.setIs_insurance(memberProfileEntity.getIsInsurance());
        memberProfile.setPip_date((memberProfileEntity.getPipDate() != null) ? DateUtils.dateToSecondsConverter(memberProfileEntity.getPipDate()) : null);
        memberProfile.setHighest_education_level(memberProfileEntity.getHighestEducationLevel());
        memberProfile.setDob_available((short) ((memberProfileEntity.getDobAvailable().equals(Boolean.FALSE)) ? 0 : 1));
        memberProfile.setDob((memberProfileEntity.getDob() !=null) ? DateUtils.dateToSecondsConverterLong(memberProfileEntity.getDob()) : null);
        memberProfile.setAge(memberProfileEntity.getAge());
        memberProfile.setAge_as_on((memberProfileEntity.getAgeAsOn() != null) ? DateUtils.dateToSecondsConverter(memberProfileEntity.getAgeAsOn()) : null);
        memberProfile.setMinority(memberProfileEntity.getMinority());
        memberProfile.setIs_disabled(memberProfileEntity.getIsDisabled());
        memberProfile.setDisability_details(memberProfileEntity.getDisabilityDetails());
        memberProfile.setWellbeing_category(memberProfileEntity.getWellbeingCategory());
        memberProfile.setPrimary_occupation(memberProfileEntity.getPrimaryOccupation());
        memberProfile.setSecondary_occupation(memberProfileEntity.getSecondaryOccupation());
        memberProfile.setTertiary_occupation(memberProfileEntity.getTertiaryOccupation());
        memberProfile.setJoining_date((memberProfileEntity.getJoiningDate() !=null) ? DateUtils.dateToSecondsConverter(memberProfileEntity.getJoiningDate()) : null);
        memberProfile.setLeaving_date((memberProfileEntity.getLeavingDate() !=null) ? DateUtils.dateToSecondsConverter(memberProfileEntity.getLeavingDate()) : null);
        memberProfile.setReason_for_leaving(memberProfileEntity.getReasonForLeaving());
        memberProfile.setIf_minor_member_replaced(memberProfileEntity.getIfMinorMemberReplaced());
        memberProfile.setGuardian_name(memberProfileEntity.getGuardianName());
        memberProfile.setGuardian_name_local(memberProfileEntity.getGuardianNameLocal());
        memberProfile.setGuardian_relation(memberProfileEntity.getGuardianRelation());
        memberProfile.setDesignation(memberProfileEntity.getDesignation());
        memberProfile.setStatus(memberProfileEntity.getStatus());
        memberProfile.setHouse_hold_code(memberProfileEntity.getHouseHoldCode());
        memberProfile.setHead_house_hold(memberProfileEntity.getHeadHouseHold());
        memberProfile.setInsurance(memberProfileEntity.getInsurance());
        memberProfile.setMarked_as_defaulter(memberProfileEntity.getMarkedAsDefaulter());
        memberProfile.setMarked_as_defaulter_date((memberProfileEntity.getMarkedAsDefaulterDate() !=null) ? DateUtils.dateToSecondsConverter(memberProfileEntity.getMarkedAsDefaulterDate()) : null);
        memberProfile.setRecord_modified(memberProfileEntity.getRecordModified());
        memberProfile.setLast_sync_date((memberProfileEntity.getLastSyncDate() !=null) ? DateUtils.TimestampToSecondsConverter(memberProfileEntity.getLastSyncDate()) : null);
        memberProfile.setEntry_source(memberProfileEntity.getEntrySource());
        memberProfile.setIs_edited(0);
        memberProfile.setIs_active((short) ((memberProfileEntity.getActive().equals(Boolean.FALSE)) ? 0 : 1));
        memberProfile.setMem_activation_status(memberProfileEntity.getMemActivationStatus());
        memberProfile.setMem_dedup_status(memberProfileEntity.getMemDedupStatus());
        memberProfile.setCreated_by(memberProfileEntity.getCreatedBy());
        memberProfile.setUpdated_by(memberProfileEntity.getUpdatedBy());
        memberProfile.setUploaded_by(memberProfileEntity.getUploadedBy());
        memberProfile.setUpdated_date((memberProfileEntity.getUpdatedDate() !=null) ? DateUtils.TimestampToSecondsConverter(memberProfileEntity.getUpdatedDate()) : null);
        memberProfile.setCreated_date(memberProfileEntity.getCreatedDate()!=null ?
                DateUtils.TimestampToSecondsConverter(memberProfileEntity.getCreatedDate()):null);
        memberProfile.setUpdated_date(memberProfileEntity.getUpdatedDate()!=null ?
                DateUtils.TimestampToSecondsConverter(memberProfileEntity.getUpdatedDate()):null);
        memberProfile.setUploaded_date(memberProfileEntity.getLastUploadedDate()!=null ?
                DateUtils.TimestampToSecondsConverter(memberProfileEntity.getLastUploadedDate()):null);
        memberProfile.setChecker_remarks(memberProfileEntity.getCheckerRemark());
        memberProfile.setMember_image(memberProfileEntity.getMemberImage());
        memberProfile.setApprove_status(memberProfileEntity.getApproveStatus());

        if(memberProfileEntity.getMemActivationStatus()!=null && memberProfileEntity.getMemActivationStatus().
                equals(LookUpMasterEntity.activationLookupValPending)){
            if(memberProfileEntity.getApproveStatus() !=null &&
                    memberProfileEntity.getApproveStatus().equals(LookUpMasterEntity.approveLookupValReject)){
                memberProfile.setView_status("New(Rejected)");
            }else{
                memberProfile.setView_status("New");
            }
        }else {
            if(memberProfileEntity.getApproveStatus()!=null && memberProfileEntity.getApproveStatus().
                    equals(LookUpMasterEntity.approveLookupValPending)){
                memberProfile.setView_status("Modified");
            }else if(memberProfileEntity.getApproveStatus()!=null && memberProfileEntity.getApproveStatus().
                    equals(LookUpMasterEntity.approveLookupValAccept)) {
                memberProfile.setView_status("Activated");
            } else if(memberProfileEntity.getApproveStatus()!=null && memberProfileEntity.getApproveStatus().
                    equals(LookUpMasterEntity.approveLookupValReject)) {
                memberProfile.setView_status("Rejected");
            }
        }
        memberProfile.setIs_verified(memberProfileEntity.getIsVerified());
        memberProfile.setIs_complete(memberProfileEntity.getIsComplete());
        memberProfile.setSettlement_status(memberProfileEntity.getSettlementStatus());
        return memberProfile;
    }

    public static MemberSystemTagsEntity map(final MemberSystemTags memberSystemTags) {
        MemberSystemTagsEntity memberSystemTagsEntity = new MemberSystemTagsEntity();
        try {
            memberSystemTagsEntity.setSystemTagsId(memberSystemTags.getSystemtags_id());
            memberSystemTagsEntity.setCboId(memberSystemTags.getCbo_id());
            memberSystemTagsEntity.setMemberGUID(memberSystemTags.getMember_guid());
            memberSystemTagsEntity.setSystemTagGUID(memberSystemTags.getSystem_tag_guid());
            memberSystemTagsEntity.setMemberCode(memberSystemTags.getMember_code());
            memberSystemTagsEntity.setSystemType(memberSystemTags.getSystem_type());
            memberSystemTagsEntity.setSystemId(memberSystemTags.getSystem_id());
            memberSystemTagsEntity.setIsEdited(memberSystemTags.getIs_edited());
            memberSystemTagsEntity.setEntrySource(memberSystemTags.getEntry_source());
            Integer shortVal = 1;
            if(memberSystemTags.getIs_active()!=null){
                if(memberSystemTags.getIs_active().equals(shortVal.shortValue()))
                    memberSystemTagsEntity.setActive(Boolean.TRUE);
                else{
                    memberSystemTagsEntity.setActive(Boolean.FALSE);
                }
            }
            else{
                memberSystemTagsEntity.setActive(Boolean.TRUE);
            }
            memberSystemTagsEntity.setCreatedDate(new Timestamp(System.currentTimeMillis()));
            memberSystemTagsEntity.setCreatedBy(memberSystemTags.getCreated_by());
            memberSystemTagsEntity.setUpdatedBy(memberSystemTags.getUpdated_by());
            memberSystemTagsEntity.setUploadedBy(memberSystemTags.getUploaded_by());
            memberSystemTagsEntity.setUpdatedDate(memberSystemTags.getUpdated_date() !=null ?
                    DateUtils.secondsToTimestampConverter(memberSystemTags.getUpdated_date()) : null);
            memberSystemTagsEntity.setCreatedDate(
                    DateUtils.secondsToTimestampConverter(memberSystemTags.getCreated_date()));
            memberSystemTagsEntity.setLastUploadedDate(new Timestamp(System.currentTimeMillis()));
            memberSystemTagsEntity.setIsComplete(memberSystemTags.getIs_complete());
        }
        catch(Exception e){
            e.printStackTrace();
        }
        return memberSystemTagsEntity;
    }

    //Member Insurance
    public static MemberInsuranceEntity map(final MemberInsurance memberInsurance) {
        MemberInsuranceEntity memberInsuranceEntity = new MemberInsuranceEntity();
        try {
            memberInsuranceEntity.setInsuranceId(memberInsurance.getInsurance_id());
            memberInsuranceEntity.setCboId(memberInsurance.getCbo_id());
            memberInsuranceEntity.setMemberGUID(memberInsurance.getMember_guid());
            memberInsuranceEntity.setMemberCode(memberInsurance.getMember_code());
            memberInsuranceEntity.setInsuranceType(memberInsurance.getInsurance_type());
            memberInsuranceEntity.setIsEdited(memberInsurance.getIs_edited());
            memberInsuranceEntity.setEntrySource(memberInsurance.getEntry_source());
            memberInsuranceEntity.setInsuranceType(memberInsurance.getInsurance_type());
            memberInsuranceEntity.setValidTo(memberInsurance.getValid_to() != null ? DateUtils.secondsToTimestampConverter(memberInsurance.getValid_to()) : null);
            memberInsuranceEntity.setIsComplete(memberInsurance.getIs_complete());
            memberInsuranceEntity.setStatus(memberInsurance.getStatus());
            
            Integer shortVal = 1;
            if(memberInsurance.getIs_active()!=null){
                if(memberInsurance.getIs_active().equals(shortVal.shortValue()))
                    memberInsuranceEntity.setActive(Boolean.TRUE);
                else{
                    memberInsuranceEntity.setActive(Boolean.FALSE);
                }
            }
            else{
                memberInsuranceEntity.setActive(Boolean.TRUE);
            }
            memberInsuranceEntity.setCreatedDate(new Timestamp(System.currentTimeMillis()));
            memberInsuranceEntity.setCreatedBy(memberInsurance.getCreated_by());
            memberInsuranceEntity.setUpdatedBy(memberInsurance.getUpdated_by());
            memberInsuranceEntity.setUploadedBy(memberInsurance.getUploaded_by());
            memberInsuranceEntity.setUpdatedDate(memberInsurance.getUpdated_date() !=null ?
                    DateUtils.secondsToTimestampConverter(memberInsurance.getUpdated_date()) : null);
            memberInsuranceEntity.setCreatedDate(
                    DateUtils.secondsToTimestampConverter(memberInsurance.getCreated_date()));
            memberInsuranceEntity.setLastUploadedDate(new Timestamp(System.currentTimeMillis()));
        }
        catch(Exception e){
            e.printStackTrace();
        }
        return memberInsuranceEntity;
    }

    public static MemberSystemTags map(final MemberSystemTagsEntity memberSystemTagsEntity) throws ParseException {
        MemberSystemTags memberSystemTags = new MemberSystemTags();
        memberSystemTags.setSystemtags_id(memberSystemTagsEntity.getSystemTagsId());
        memberSystemTags.setCbo_id(memberSystemTagsEntity.getCboId());
        memberSystemTags.setMember_guid(memberSystemTagsEntity.getMemberGUID());
        memberSystemTags.setSystem_tag_guid(memberSystemTagsEntity.getSystemTagGUID());
        memberSystemTags.setMember_code(memberSystemTagsEntity.getMemberCode());
        memberSystemTags.setSystem_type(memberSystemTagsEntity.getSystemType());
        memberSystemTags.setSystem_id(memberSystemTagsEntity.getSystemId());
        memberSystemTags.setEntry_source(memberSystemTagsEntity.getEntrySource());
        memberSystemTags.setIs_edited(0);
        memberSystemTags.setCreated_by(memberSystemTagsEntity.getCreatedBy());
        memberSystemTags.setUpdated_by(memberSystemTagsEntity.getUpdatedBy());
        memberSystemTags.setUploaded_by(memberSystemTagsEntity.getUploadedBy());
        memberSystemTags.setUpdated_date((memberSystemTagsEntity.getUpdatedDate() !=null) ? DateUtils.TimestampToSecondsConverter(memberSystemTagsEntity.getUpdatedDate()) : null);
        memberSystemTags.setCreated_date(memberSystemTagsEntity.getCreatedDate()!=null ?
                DateUtils.TimestampToSecondsConverter(memberSystemTagsEntity.getCreatedDate()):null);
        memberSystemTags.setUploaded_date(memberSystemTagsEntity.getLastUploadedDate()!=null ?
                DateUtils.TimestampToSecondsConverter(memberSystemTagsEntity.getLastUploadedDate()):null);
        Integer shortVal = 1;
        Integer shortValZero = 0;
        if(memberSystemTagsEntity.getActive()!=null) {
            if(memberSystemTagsEntity.getActive().equals(Boolean.TRUE))
                memberSystemTags.setIs_active(shortVal.shortValue());
            else
                memberSystemTags.setIs_active(shortValZero.shortValue());
        }
        memberSystemTags.setIs_complete (memberSystemTagsEntity.getIsComplete());
        return memberSystemTags;
    }

    public static MemberInsurance map(final MemberInsuranceEntity memberInsuranceEntity) throws ParseException {
        MemberInsurance memberInsurance = new MemberInsurance();
        memberInsurance.setInsurance_id(memberInsuranceEntity.getInsuranceId());
        memberInsurance.setCbo_id(memberInsuranceEntity.getCboId());
        memberInsurance.setMember_guid(memberInsuranceEntity.getMemberGUID());
        memberInsurance.setMember_code(memberInsuranceEntity.getMemberCode());
        memberInsurance.setInsurance_type(memberInsuranceEntity.getInsuranceType());
        memberInsurance.setEntry_source(memberInsuranceEntity.getEntrySource());
        memberInsurance.setIs_edited(memberInsuranceEntity.getIsEdited());
        memberInsurance.setCreated_by(memberInsuranceEntity.getCreatedBy());
        memberInsurance.setUpdated_by(memberInsuranceEntity.getUpdatedBy());
        memberInsurance.setUploaded_by(memberInsuranceEntity.getUploadedBy());
        memberInsurance.setStatus(memberInsuranceEntity.getStatus());
        memberInsurance.setUpdated_date((memberInsuranceEntity.getUpdatedDate() !=null) ?
                DateUtils.TimestampToSecondsConverter(memberInsuranceEntity.getUpdatedDate()) : null);
        memberInsurance.setCreated_date(memberInsuranceEntity.getCreatedDate()!=null ?
                DateUtils.TimestampToSecondsConverter(memberInsuranceEntity.getCreatedDate()):null);
        memberInsurance.setUploaded_date(memberInsuranceEntity.getLastUploadedDate()!=null ?
                DateUtils.TimestampToSecondsConverter(memberInsuranceEntity.getLastUploadedDate()):null);
        Integer shortVal = 1;
        Integer shortValZero = 0;
        if(memberInsuranceEntity.getActive()!=null) {
            if(memberInsuranceEntity.getActive().equals(Boolean.TRUE))
                memberInsurance.setIs_active(shortVal.shortValue());
            else
                memberInsurance.setIs_active(shortValZero.shortValue());
        }
        memberInsurance.setIs_complete(memberInsuranceEntity.getIsComplete());
        memberInsurance.setValid_to((memberInsuranceEntity.getValidTo()!=null) ?
                DateUtils.TimestampToSecondsConverter(memberInsuranceEntity.getValidTo()) : null);
        memberInsurance.setInsurance_type(memberInsuranceEntity.getInsuranceType());
        return memberInsurance;
    }

       /* public static MemberExecutiveMemberEntity map ( final MemberExecutiveMember memberExecutiveMember){
            MemberExecutiveMemberEntity memberExecutiveMemberEntity = new MemberExecutiveMemberEntity();
            try {
                memberExecutiveMemberEntity.setExecutiveMemberId(memberExecutiveMember.getExecutiveMemberId());
                memberExecutiveMemberEntity.setCboGUID(memberExecutiveMember.getCboGUID());
                memberExecutiveMemberEntity.setMemberCode(memberExecutiveMember.getMemberCode());
                memberExecutiveMemberEntity.setDesignation(memberExecutiveMember.getDesignation());
                memberExecutiveMemberEntity.setFromDate(new SimpleDateFormat("yyyy-MM-dd").parse(memberExecutiveMember.getFromDate()));
                memberExecutiveMemberEntity.setToDate(new SimpleDateFormat("yyyy-MM-dd").parse(memberExecutiveMember.getFromDate()));
                memberExecutiveMemberEntity.setStatus((memberExecutiveMember.getStatus()== 0) ? Boolean.FALSE : Boolean.TRUE);
                memberExecutiveMemberEntity.setEntrySource(memberExecutiveMember.getEntrySource());
                memberExecutiveMemberEntity.setIsEdited(memberExecutiveMember.getIsEdited());
                memberExecutiveMemberEntity.setCreatedDate(new Timestamp(System.currentTimeMillis()));
                memberExecutiveMemberEntity.setCreatedBy(memberExecutiveMember.getCreatedBy());
                memberExecutiveMemberEntity.setUpdatedBy(memberExecutiveMember.getUpdatedBy());
                memberExecutiveMemberEntity.setUploadedBy(memberExecutiveMember.getUploadedBy());
            } catch (Exception e) {
                e.printStackTrace();
            }
            return memberExecutiveMemberEntity;
        }

        public static MemberExecutiveMember map ( final MemberExecutiveMemberEntity memberExecutiveMemberEntity) {
            MemberExecutiveMember memberExecutiveMember = new MemberExecutiveMember();

                memberExecutiveMember.setExecutiveMemberId(memberExecutiveMemberEntity.getExecutiveMemberId());
                memberExecutiveMember.setCboGUID(memberExecutiveMemberEntity.getCboGUID());
                memberExecutiveMember.setMemberCode(memberExecutiveMemberEntity.getMemberCode());
                memberExecutiveMember.setDesignation(memberExecutiveMemberEntity.getDesignation());
                memberExecutiveMember.setFromDate(DateConverter.toIsoString(memberExecutiveMemberEntity.getFromDate()));
                memberExecutiveMember.setToDate(DateConverter.toIsoString(memberExecutiveMemberEntity.getToDate()));
                memberExecutiveMember.setStatus((short) ((memberExecutiveMemberEntity.getStatus().equals(Boolean.FALSE)) ? 0 : 1));
                memberExecutiveMember.setEntrySource(memberExecutiveMemberEntity.getEntrySource());
                memberExecutiveMember.setIsEdited(memberExecutiveMemberEntity.getIsEdited());
                memberExecutiveMember.setCreatedBy(memberExecutiveMemberEntity.getCreatedBy());
                memberExecutiveMember.setUpdatedBy(memberExecutiveMemberEntity.getUpdatedBy());
                memberExecutiveMember.setUploadedBy(memberExecutiveMemberEntity.getUploadedBy());
            return memberExecutiveMember;

        }




    public static MemberSubExecutiveMemberEntity map ( final MemberSubExecutiveMember memberSubExecutiveMember){
        MemberSubExecutiveMemberEntity memberSubExecutiveMemberEntity = new MemberSubExecutiveMemberEntity();
        try {
            memberSubExecutiveMemberEntity.setSubExecutiveMemberId(memberSubExecutiveMember.getSubExecutiveMemberId());
            memberSubExecutiveMemberEntity.setCboGUID(memberSubExecutiveMember.getCboGUID());
            memberSubExecutiveMemberEntity.setCboCode(memberSubExecutiveMember.getCboCode());
            memberSubExecutiveMemberEntity.setMemberCode(memberSubExecutiveMember.getMemberCode());
            memberSubExecutiveMemberEntity.setDesignation(memberSubExecutiveMember.getDesignation());
            memberSubExecutiveMemberEntity.setFromDate(new SimpleDateFormat("yyyy-MM-dd").parse(memberSubExecutiveMember.getFromDate()));
            memberSubExecutiveMemberEntity.setToDate(new SimpleDateFormat("yyyy-MM-dd").parse(memberSubExecutiveMember.getFromDate()));
            memberSubExecutiveMemberEntity.setStatus((memberSubExecutiveMember.getStatus()== 0) ? Boolean.FALSE : Boolean.TRUE);
            memberSubExecutiveMemberEntity.setEntrySource(memberSubExecutiveMember.getEntrySource());
            memberSubExecutiveMemberEntity.setIsEdited(memberSubExecutiveMember.getIsEdited());
            memberSubExecutiveMemberEntity.setCreatedDate(new Timestamp(System.currentTimeMillis()));
            memberSubExecutiveMemberEntity.setCreatedBy(memberSubExecutiveMember.getCreatedBy());
            memberSubExecutiveMemberEntity.setUpdatedBy(memberSubExecutiveMember.getUpdatedBy());
            memberSubExecutiveMemberEntity.setUploadedBy(memberSubExecutiveMember.getUploadedBy());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return memberSubExecutiveMemberEntity;
    }

    public static MemberSubExecutiveMember map ( final MemberSubExecutiveMemberEntity memberSubExecutiveMemberEntity) {
        MemberSubExecutiveMember memberSubExecutiveMember = new MemberSubExecutiveMember();

        memberSubExecutiveMember.setSubExecutiveMemberId(memberSubExecutiveMemberEntity.getSubExecutiveMemberId());
        memberSubExecutiveMember.setCboGUID(memberSubExecutiveMemberEntity.getCboGUID());
        memberSubExecutiveMember.setCboCode(memberSubExecutiveMemberEntity.getCboCode());
        memberSubExecutiveMember.setMemberCode(memberSubExecutiveMemberEntity.getMemberCode());
        memberSubExecutiveMember.setDesignation(memberSubExecutiveMemberEntity.getDesignation());
        memberSubExecutiveMember.setFromDate(DateConverter.toIsoString(memberSubExecutiveMemberEntity.getFromDate()));
        memberSubExecutiveMember.setToDate(DateConverter.toIsoString(memberSubExecutiveMemberEntity.getToDate()));
        memberSubExecutiveMember.setStatus((short) ((memberSubExecutiveMemberEntity.getStatus().equals(Boolean.FALSE)) ? 0 : 1));
        memberSubExecutiveMember.setEntrySource(memberSubExecutiveMemberEntity.getEntrySource());
        memberSubExecutiveMember.setIsEdited(memberSubExecutiveMemberEntity.getIsEdited());
        memberSubExecutiveMember.setCreatedBy(memberSubExecutiveMemberEntity.getCreatedBy());
        memberSubExecutiveMember.setUpdatedBy(memberSubExecutiveMemberEntity.getUpdatedBy());
        memberSubExecutiveMember.setUploadedBy(memberSubExecutiveMemberEntity.getUploadedBy());
        return memberSubExecutiveMember;

    }


    public static MemberDocumentDetailsEntity map ( final MemberDocumentDetails memberDocumentDetails){
        MemberDocumentDetailsEntity memberDocumentDetailsEntity = new MemberDocumentDetailsEntity();
        try {
            memberDocumentDetailsEntity.setDocumentId(memberDocumentDetails.getDocumentId());
            memberDocumentDetailsEntity.setFrontDocOriginalNname(memberDocumentDetails.getFrontDocOriginalNname());
            memberDocumentDetailsEntity.setFrontDocModifiedName(memberDocumentDetails.getFrontDocModifiedName());
            memberDocumentDetailsEntity.setRearDocOriginalName(memberDocumentDetails.getRearDocOriginalName());
            memberDocumentDetailsEntity.setRearDocModifiedName(memberDocumentDetails.getRearDocModifiedName());
            memberDocumentDetailsEntity.setDocPath(memberDocumentDetails.getDocPath());
            memberDocumentDetailsEntity.setIsEdited(memberDocumentDetails.getIsEdited());
            memberDocumentDetailsEntity.setActive((memberDocumentDetails.getActive()== 0) ? Boolean.FALSE : Boolean.TRUE);
            memberDocumentDetailsEntity.setCreatedDate(new Timestamp(System.currentTimeMillis()));
            memberDocumentDetailsEntity.setCreatedBy(memberDocumentDetails.getCreatedBy());
            memberDocumentDetailsEntity.setUpdatedBy(memberDocumentDetails.getUpdatedBy());
            memberDocumentDetailsEntity.setUploadedBy(memberDocumentDetails.getUploadedBy());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return memberDocumentDetailsEntity;
    }

    public static MemberDocumentDetails map ( final MemberDocumentDetailsEntity memberDocumentDetailsEntity) {
        MemberDocumentDetails memberDocumentDetails = new MemberDocumentDetails();

        memberDocumentDetails.setDocumentId(memberDocumentDetailsEntity.getDocumentId());
        memberDocumentDetails.setFrontDocOriginalNname(memberDocumentDetailsEntity.getFrontDocOriginalNname());
        memberDocumentDetails.setFrontDocModifiedName(memberDocumentDetailsEntity.getFrontDocModifiedName());
        memberDocumentDetails.setRearDocOriginalName(memberDocumentDetailsEntity.getRearDocOriginalName());
        memberDocumentDetails.setRearDocModifiedName(memberDocumentDetailsEntity.getRearDocModifiedName());
        memberDocumentDetails.setDocPath(memberDocumentDetailsEntity.getDocPath());
        memberDocumentDetails.setIsEdited(memberDocumentDetailsEntity.getIsEdited());
        memberDocumentDetails.setActive((short) ((memberDocumentDetailsEntity.getActive().equals(Boolean.FALSE)) ? 0 : 1));
        memberDocumentDetails.setCreatedBy(memberDocumentDetailsEntity.getCreatedBy());
        memberDocumentDetails.setUpdatedBy(memberDocumentDetailsEntity.getUpdatedBy());
        memberDocumentDetails.setUploadedBy(memberDocumentDetailsEntity.getUploadedBy());
        return memberDocumentDetails;

    }
*/
}

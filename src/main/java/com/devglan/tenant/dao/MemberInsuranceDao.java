package com.devglan.tenant.dao;

import com.devglan.model.MemberInsuranceEntity;
import com.devglan.model.MemberSystemTagsEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.math.BigInteger;

public interface MemberInsuranceDao extends JpaRepository<MemberInsuranceEntity, BigInteger> {
    @Query("FROM MemberInsuranceEntity c WHERE c.memberCode = :member_code and c.insuranceType = :insurance_type")
    MemberInsuranceEntity fetchByMemberCodeAndInsuranceType(Integer insurance_type, BigInteger member_code);
}

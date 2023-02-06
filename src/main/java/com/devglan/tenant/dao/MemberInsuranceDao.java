package com.devglan.tenant.dao;

import com.devglan.model.MemberInsuranceEntity;
import com.devglan.model.MemberSystemTagsEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.math.BigInteger;
import java.util.List;

public interface MemberInsuranceDao extends JpaRepository<MemberInsuranceEntity, BigInteger> {
    @Query("FROM MemberInsuranceEntity c WHERE c.memberCode = :member_code and c.insuranceType = :insurance_type")
    MemberInsuranceEntity fetchByMemberCodeAndInsuranceType(Integer insurance_type, BigInteger member_code);
    @Query("FROM MemberInsuranceEntity c WHERE c.cboId = :cboId and  c.memberCode = :memberCode")
    List<MemberInsuranceEntity> findListByMemberCodeCboId(@Param("memberCode") final BigInteger memberCode, @Param("cboId") final BigInteger cboId);

}

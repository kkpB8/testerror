package com.devglan.tenant.dao;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.devglan.model.MemberAddressesDetailsEntity;

import java.math.BigInteger;
import java.util.List;


@Repository
public interface MemberAddressesDetailsDao extends JpaRepository<MemberAddressesDetailsEntity, BigInteger> {
    @Query("FROM MemberAddressesDetailsEntity c WHERE c.memberCode = :memberCode and c.cboId = :cboId")
    MemberAddressesDetailsEntity findByMemberCodeCboId(@Param("memberCode") final BigInteger memberCode, @Param("cboId") final BigInteger cboId);

    @Query("FROM MemberAddressesDetailsEntity c WHERE c.memberCode = :memberCode and c.cboId = :cboId")
    List<MemberAddressesDetailsEntity> findListByMemberCodeCboId(@Param("memberCode") final BigInteger memberCode, @Param("cboId") final BigInteger cboId);

    @Query("FROM MemberAddressesDetailsEntity c WHERE c.cboId = :cboId AND c.isActive= :isActive")
    List<MemberAddressesDetailsEntity> fetchByCboId(@Param("cboId") final BigInteger cboId,@Param("isActive") final Boolean isActive);

    @Query("FROM MemberAddressesDetailsEntity c WHERE c.addressGUID = :addressGUID AND c.isActive= :isActive")
    MemberAddressesDetailsEntity fetchByGUID(@Param("addressGUID") final String addressGUID,@Param("isActive") final Boolean isActive);


}

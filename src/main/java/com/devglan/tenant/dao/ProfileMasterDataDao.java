package com.devglan.tenant.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.devglan.model.CadreNonMembersEntity;
import com.devglan.model.MemberAddressesDetailsEntity;

import java.math.BigInteger;
import java.util.List;

@Repository
public interface CadreNonMemberDao extends JpaRepository<CadreNonMembersEntity, BigInteger> {

    @Query("FROM CadreNonMembersEntity c WHERE c.uid = :uid")
    List<CadreNonMembersEntity> findListByNonMemberCadreId(@Param("uid") final BigInteger uid);
    
	/*
	 * @Query("FROM CadreNonMembersEntity c WHERE c.cadreGuid = :cadreGuid AND c.isActive= :isActive"
	 * ) CadreNonMembersEntity fetchByGUID(@Param("cadreGuid") final String
	 * cadreGuid,@Param("isActive") final Boolean isActive);
	 * 
	 */
    
    @Query("FROM CadreNonMembersEntity c WHERE c.cadreGuid = :cadreGuid")
    CadreNonMembersEntity fetchByGUID(@Param("cadreGuid") final String cadreGuid);


    //@Query("FROM CadreNonMembersEntity c WHERE c.uid = :uid AND c.isActive= :isActive")
    // List<CadreNonMembersEntity> fetchByCboId(@Param("cboId") final BigInteger cboId,@Param("isActive") final Boolean isActive);



}

package com.devglan.tenant.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.devglan.model.CadreNonMembersEntity;
import com.devglan.model.CadreShgMembersEntity;

import java.math.BigInteger;
import java.util.List;

@Repository
public interface CadreShgMembersDao extends JpaRepository<CadreShgMembersEntity, BigInteger> {

    @Query("FROM CadreShgMembersEntity c WHERE c.uid = :uid")
    List<CadreShgMembersEntity> findListByshgMemberCadreUid(@Param("uid") final BigInteger uid);
    
    @Query("FROM CadreShgMembersEntity c WHERE c.cadreGuid = :cadreGuid")
    CadreShgMembersEntity fetchByGUID(@Param("cadreGuid") final String cadreGuid);



}
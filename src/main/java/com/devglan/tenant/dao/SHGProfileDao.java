package com.devglan.tenant.dao;

import java.math.BigInteger;
import java.util.Date;
import java.util.List;
import java.util.Set;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.devglan.model.ShgProfileEntity;

@Repository
public interface SHGProfileDao extends JpaRepository<ShgProfileEntity, BigInteger> {

    @Query("FROM ShgProfileEntity c WHERE c.guid = :guid AND c.isActive= :isActive")
    ShgProfileEntity fetchByGUID(@Param("guid") final String guid,@Param("isActive") final Boolean isActive);


    @Modifying
    @Transactional
    @Query("update ShgProfileEntity u set u.readFlag = :readFlag where u.shgId =:shgId")
    void updateReadFlag(@Param("shgId") final BigInteger shgId,@Param("readFlag") final Boolean readFlag);
	
	
			
	
    
    @Query("SELECT count(c) FROM ShgProfileEntity c WHERE c.shgId = :shgId AND c.isActive= :isActive")
    Integer getActiveShg(@Param("shgId") final BigInteger shgId,
                                         @Param("isActive") final Boolean isActive);


    @Query(nativeQuery = true,value = "select MAX(mtg_no) from shg_mtg where cbo_id = ?1")
    Long getMaxMtgNo(BigInteger shgId);
}

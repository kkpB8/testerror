package com.devglan.tenant.dao;

import org.springframework.data.jpa.repository.*;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.*;

import com.devglan.model.CboKYCDetailsEntity;

import java.math.*;
import java.util.*;

@Repository
public interface CboKYCDetailsDao extends JpaRepository<CboKYCDetailsEntity, BigInteger> {

    @Query("FROM CboKYCDetailsEntity c WHERE c.kycGuid = :kycGuid")
    CboKYCDetailsEntity fetchByGUID(@Param("kycGuid") final String kycGuid
           );
    
    @Query("FROM CboKYCDetailsEntity c WHERE c.kycGuid = :kycGuid AND c.isActive= :isActive " +
            "AND c.cboType = :cboType")
    CboKYCDetailsEntity fetchByGUID(@Param("kycGuid") final String kycGuid,
                                     @Param("isActive") final Boolean isActive
            , @Param("cboType") final Short cboType);


    @Query("FROM CboKYCDetailsEntity c WHERE c.cboId = :cboId AND c.isActive= :isActive")
    List<CboKYCDetailsEntity> fetchByCboId(@Param("cboId") final BigInteger cboId,
                                           @Param("isActive") final Boolean isActive);

    @Modifying
    @Transactional
    @Query("update CboKYCDetailsEntity u set u.deduplicationStatus = :deduplicationStatus,  u.activationStatus = :activationStatus where u.cboKYCDetailsId =:cboKYCDetailsId")
    void updateDDSById(@Param("cboKYCDetailsId") final BigInteger cboKYCDetailsId,
                       @Param("deduplicationStatus") final Short deduplicationStatus,
                       @Param("activationStatus") final Short activationStatus);


    @Query("FROM CboKYCDetailsEntity c WHERE c.deduplicationStatus = :deduplicationStatus AND c.cboId= :cboId " +
            "AND c.isActive= :isActive")
    List<CboKYCDetailsEntity> fetchCboKYCDetailsByDedupStatusAndCboIdAll(
            @Param("deduplicationStatus") final Short deduplicationStatus,
            @Param("cboId") final BigInteger cboId
            ,@Param("isActive") final Boolean isActive);

    @Query("select case when count(c)>1 then true else false end from CboKYCDetailsEntity c" +
            "    where c.kycNumber= :kycNumber AND c.isActive= :isActive")
    Boolean existsByKYCNo(@Param("kycNumber") final
                          String kycNumber,@Param("isActive") final Boolean isActive);


    @Modifying
    @Transactional
    @Query("update CboKYCDetailsEntity u set u.deduplicationStatus = :deduplicationStatus where u.cboKYCDetailsId =:cboKYCDetailsId")
    void updateDedupStatusByCboKYCId(@Param("cboKYCDetailsId") final BigInteger cboKYCDetailsId,
                                        @Param("deduplicationStatus") final Short deduplicationStatus);
}

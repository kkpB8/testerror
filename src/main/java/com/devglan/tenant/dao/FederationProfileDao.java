package com.devglan.tenant.dao;

import java.math.BigInteger;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.devglan.model.FederationProfileEntity;

@Repository
public interface FederationProfileDao extends JpaRepository<FederationProfileEntity, BigInteger> {
    @Query("FROM FederationProfileEntity c WHERE c.stateId = :stateId AND c.isActive= :isActive")
    List<FederationProfileEntity> findByStateId(@Param("stateId") final Integer stateId,@Param("isActive") final Boolean isActive);

    @Query("FROM FederationProfileEntity c WHERE c.districtId = :districtId AND c.isActive= :isActive")
    List<FederationProfileEntity> findByDistrictId(@Param("districtId") final Integer districtId,@Param("isActive") final Boolean isActive);

    @Query("FROM FederationProfileEntity c WHERE c.blockId = :blockId AND c.isActive= :isActive")
    List<FederationProfileEntity> findByBlockId(@Param("blockId") final Integer blockId,@Param("isActive") final Boolean isActive);

    @Query("FROM FederationProfileEntity c WHERE c.panchayatId = :panchayatId AND c.isActive= :isActive")
    List<FederationProfileEntity> findByPanchayatId(@Param("panchayatId") final Integer panchayatId,@Param("isActive") final Boolean isActive);

    @Query("FROM FederationProfileEntity c WHERE c.villageId = :villageId AND c.isActive= :isActive")
    List<FederationProfileEntity> findByVillageId(@Param("villageId") final Integer villageId,@Param("isActive") final Boolean isActive);

    @Query("FROM FederationProfileEntity c WHERE c.guid = :guid  AND c.isActive= :isActive")
    FederationProfileEntity fetchByGUID(@Param("guid") final String guid,
                                        @Param("isActive") final Boolean isActive);

    @Modifying
    @Query("update FederationProfileEntity u set u.isActive = :status where u.federationId =:federationId")
    void deactivateFederation(@Param("federationId") final BigInteger federationId,@Param("status") final Boolean status);

    @Modifying
    @Query("update FederationProfileEntity u set u.deduplicationStatus = :deduplicationStatus where u.federationId =:federationId")
    void updateDedupByFederationId(@Param("federationId") final BigInteger federationId,@Param("deduplicationStatus") final Short deduplStatus);

    @Modifying
    @Query("update FederationProfileEntity u set u.activationStatus = :activationStatus where u.federationId =:federationId")
    void updateActivationByFederationId(@Param("federationId") final BigInteger federationId,
                                 @Param("activationStatus") final Short activationStatus);

    @Query("FROM FederationProfileEntity c WHERE c.deduplicationStatus = :deduplicationStatus AND c.isActive= :isActive")
    List<FederationProfileEntity> fetchFederationProfileByDedupStatus(@Param("deduplicationStatus") final Short deDupStatus,@Param("isActive") final Boolean isActive);

    @Query("FROM FederationProfileEntity c WHERE c.activationStatus = :activationStatus AND c.isActive= :isActive")
    List<FederationProfileEntity> fetchFederationProfileByActivationStatus(@Param("activationStatus") final
                                                             Short activationStatus,@Param("isActive") final Boolean isActive);
															 
															 
 
	 @Query(value = "FROM FederationProfileEntity c WHERE "+
            "c.stateId = :stateId AND c.districtId= :districtId AND c.blockId = :blockId AND "+
            "(:panchayatId = -1 OR c.panchayatId= :panchayatId) AND "+
            "(:villageId = -1 OR c.villageId= :villageId) AND "+
            "(:cboType = -1 OR c.cboType= :cboType) AND "+
            "(:federation_code = -1 OR c.federation_code= :federation_code) AND "+
            "(:federationName is null OR lower(c.federationName) like :federationName) AND c.isActive = :isActive")
     Page<FederationProfileEntity> searchFederation(
            @Param("stateId") final Integer stateId,
            @Param("districtId") final Integer districtId,
            @Param("blockId") final Integer blockId,
            @Param("panchayatId") final Integer panchayatId,
            @Param("villageId") final Integer villageId,
            @Param("cboType") final Short cboType,
            @Param("federation_code") final BigInteger federation_code,
            @Param("federationName") final String federationName,
            @Param("isActive") final Boolean isActive,
            Pageable pageable);

    @Query(value = "FROM FederationProfileEntity c WHERE "+
            "c.stateId = :stateId AND c.districtId= :districtId AND c.blockId = :blockId AND "+
            "(:panchayatId = -1 OR c.panchayatId= :panchayatId) AND "+
            "(:villageId = -1 OR c.villageId= :villageId) AND "+
            "(:cboType = -1 OR c.cboType= :cboType) AND "+
            "(c.approveStatus= :approveStatus) AND "+
            "(:federation_code = -1 OR c.federation_code= :federation_code) AND "+
            "(:federationName is null OR lower(c.federationName) like :federationName) AND c.isActive = :isActive")
    Page<FederationProfileEntity> searchFederationForApprove(
            @Param("stateId") final Integer stateId,
            @Param("districtId") final Integer districtId,
            @Param("blockId") final Integer blockId,
            @Param("panchayatId") final Integer panchayatId,
            @Param("villageId") final Integer villageId,
            @Param("cboType") final Short cboType,
            @Param("approveStatus") final Short approveStatus,
            @Param("federation_code") final BigInteger federation_code,
            @Param("federationName") final String federationName,
            @Param("isActive") final Boolean isActive,
            Pageable pageable);

    @Query("FROM FederationProfileEntity c WHERE c.userId = :userId AND c.isActive= :isActive AND c.cboType= :cboType")
    List<FederationProfileEntity> fetchByUserIdMobile(@Param("userId") final String userId
            ,@Param("isActive") final Boolean isActive
            ,@Param("cboType") final Short cboType);

    @Modifying
    @Transactional
    @Query("update FederationProfileEntity u set u.deduplicationStatus = :deduplicationStatus, u.approveStatus = :approveStatus, u.checkerRemark = :checkerRemark where u.federationId =:federationId")
    void updateDDSByFederationId(@Param("federationId") final BigInteger federationId,
                             @Param("deduplicationStatus") final Short deduplicationStatus,
                             @Param("approveStatus") final Short approveStatus,
                             @Param("checkerRemark") final String checkerRemark);

    @Modifying
    @Transactional
    @Query("update FederationProfileEntity u set u.readFlag = :readFlag where u.federationId =:federationId")
    void updateReadFlag(@Param("federationId") final BigInteger federationId,@Param("readFlag") final Boolean readFlag);

    @Modifying
    @Transactional
    @Query("update FederationProfileEntity u set u.activationStatus = :activationStatus where u.federationId =:federationId")
    void updateActivationByFederationId2(@Param("federationId") final BigInteger federationId,
                                     @Param("activationStatus") final Short activationStatus);


    @Query("FROM FederationProfileEntity c WHERE c.userId = :userId AND (c.approveStatus = :approveStatus1 OR " +
            "c.approveStatus = :approveStatus2) AND " +
            "c.readFlag = :readFlag  AND c.isActive = :isActive  AND c.cboType = :cboType")
    List<FederationProfileEntity> nonSyncFederationByAS(@Param("userId") final String userId,
                                                         @Param("approveStatus1") final Short approveStatus1,
                                                         @Param("approveStatus2") final Short approveStatus2,
                                                         @Param("readFlag") final Boolean readFlag,
                                                         @Param("isActive") final Boolean isActive,
                                                        @Param("cboType") final Short cboType);

    @Query("FROM FederationProfileEntity c WHERE c.userId = :userId AND " +
            "c.readFlag = :readFlag  AND c.isActive = :isActive")
    List<FederationProfileEntity> nonSyncFederationByAS(@Param("userId") final String userId,
                                                      @Param("readFlag") final Boolean readFlag,
                                                      @Param("isActive") final Boolean isActive);

    @Modifying
    @Transactional
    @Query("update FederationProfileEntity u set u.federation_code = :federation_code where u.federationId =:federationId")
    void updateFederationCode(@Param("federationId") final BigInteger federationId,
                       @Param("federation_code") final BigInteger federation_code);
					   
	
	@Query(value = "FROM FederationProfileEntity c WHERE "+
            "c.stateId = :stateId AND c.districtId= :districtId AND c.blockId = :blockId AND "+
            "(:panchayatId = -1 OR c.panchayatId= :panchayatId) AND "+
            "(:villageId = -1 OR c.villageId= :villageId) AND "+
            "(:cboType = -1 OR c.cboType= :cboType) AND "+
            "(c.parentCboId= :parentCboId1  "+
            "OR c.parentCboId is NULL OR c.parentCboId = 0) AND "+
            "(:federationName is null OR lower(c.federationName) like :federationName) AND c.isActive = :isActive")
    Page<FederationProfileEntity> searchFederationForMapping(
            @Param("stateId") final Integer stateId,
            @Param("districtId") final Integer districtId,
            @Param("blockId") final Integer blockId,
            @Param("panchayatId") final Integer panchayatId,
            @Param("villageId") final Integer villageId,
            @Param("cboType") final Short cboType,
            @Param("parentCboId1") final BigInteger parentCboId1,
            @Param("federationName") final String federationName,
            @Param("isActive") final Boolean isActive,
            Pageable pageable);



    @Modifying
    @Transactional
    @Query("update FederationProfileEntity u set u.parentCboId = :parentCboId where u.federationId =:federationId")
    void updateParentCboId(@Param("federationId") final BigInteger federationId,@Param("parentCboId") final BigInteger parentCboId);

 @Query(value = "SELECT count(c) FROM FederationProfileEntity c WHERE " +
            ":stateId = -1 OR c.stateId = :stateId AND " +
            ":districtId = -1 OR c.districtId= :districtId AND " +
            ":blockId = -1 OR c.blockId = :blockId AND "+
            "(:panchayatId = -1 OR c.panchayatId= :panchayatId) AND "+
            "(:villageId = -1 OR c.villageId= :villageId) AND "+
            " c.activationStatus = :activationStatus AND c.isActive= :isActive")
    Long getPendingActivated(
            @Param("stateId") final Integer stateId,
            @Param("districtId") final Integer districtId,
            @Param("blockId") final Integer blockId,
            @Param("panchayatId") final Integer panchayatId,
            @Param("villageId") final Integer villageId,
            @Param("activationStatus") final Short activationStatus,
            @Param("isActive") final Boolean isActive);

    @Query(value = "SELECT count(c) FROM FederationProfileEntity c WHERE " +
            ":stateId = -1 OR c.stateId = :stateId AND " +
            ":districtId = -1 OR c.districtId= :districtId AND " +
            ":blockId = -1 OR c.blockId = :blockId AND "+
            "(:panchayatId = -1 OR c.panchayatId= :panchayatId) AND "+
            "(:villageId = -1 OR c.villageId= :villageId) AND "+
            " c.approveStatus = :approveStatus AND c.isActive= :isActive")
    Long getPendingApprove(
            @Param("stateId") final Integer stateId,
            @Param("districtId") final Integer districtId,
            @Param("blockId") final Integer blockId,
            @Param("panchayatId") final Integer panchayatId,
            @Param("villageId") final Integer villageId,
            @Param("approveStatus") final Short approveStatus,
            @Param("isActive") final Boolean isActive);

    @Query(value = "SELECT count(c) FROM FederationProfileEntity c WHERE " +
            ":stateId = -1 OR c.stateId = :stateId AND " +
            ":districtId = -1 OR c.districtId= :districtId AND " +
            ":blockId = -1 OR c.blockId = :blockId AND "+
            "(:panchayatId = -1 OR c.panchayatId= :panchayatId) AND "+
            "(:villageId = -1 OR c.villageId= :villageId) AND "+
            " c.deduplicationStatus = :deduplicationStatus AND c.isActive= :isActive")
    Long getPendingDedup(
            @Param("stateId") final Integer stateId,
            @Param("districtId") final Integer districtId,
            @Param("blockId") final Integer blockId,
            @Param("panchayatId") final Integer panchayatId,
            @Param("villageId") final Integer villageId,
            @Param("deduplicationStatus") final Short deduplicationStatus,
            @Param("isActive") final Boolean isActive);

    @Query("SELECT count(c) FROM FederationProfileEntity c WHERE c.federationId = :federationId AND c.isActive= :isActive")
	Integer getActiveVo(@Param("federationId")final BigInteger federationId, @Param("isActive")final Boolean isActive);

	
	 
	

}

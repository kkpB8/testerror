package com.devglan.tenant.dao;

import com.devglan.model.ShgMtgEntity;
import com.devglan.model.VoMtgEntity;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigInteger;
import java.util.Date;
import java.util.List;
import java.util.Set;

public interface VoMtgEntityDao extends CrudRepository<VoMtgEntity, BigInteger>, JpaSpecificationExecutor<VoMtgEntity> {


    @Modifying
    @Transactional
    @Query("update VoMtgEntity u set u.readFlag = :readFlag where u.uid =:uid")
    void updateReadFlag(@Param("uid") final BigInteger uid, @Param("readFlag") final Boolean readFlag);

    @Modifying(clearAutomatically = true)
    @Transactional
    @Query("update VoMtgEntity u set u.summaryFlag = :summaryFlag where u.uid =:uid")
    void updateSummaryFlag(@Param("uid") final BigInteger uid, @Param("summaryFlag") final Boolean summaryFlag);

    @Query("FROM VoMtgEntity c WHERE c.cboId IN :cboIds AND c.readFlag= :readFlag")
    List<VoMtgEntity> getMtgListByVoIds(@Param("cboIds") final Set<Long> cboIds,
                                        @Param("readFlag") final Boolean readFlag);

    @Modifying
    @Transactional
    @Query("update VoMtgEntity u set u.approvalStatus = :approvalStatus, "+
            "u.checkerRemarks = :checkerRemarks where u.uid =:uid")
    void updateCheckerStatus(@Param("uid") final BigInteger uid,
                             @Param("approvalStatus") final Integer approvalStatus,
                             @Param("checkerRemarks") final String checkerRemarks);

    @Modifying
    @Transactional
    @Query("update VoMtgEntity u set u.approvalStatus = :approvalStatus, "+
            "u.checkerRemarks = :checkerRemarks where u.cboId =:cboId and u.mtgNo >=:mtgNo")
    void updateCheckerStatusForReject(@Param("cboId") final BigInteger cboId,
                                      @Param("mtgNo") final Integer mtgNo,
                                      @Param("approvalStatus") final Integer approvalStatus,
                                      @Param("checkerRemarks") final String checkerRemarks);


    @Query("SELECT COUNT(c) FROM VoMtgEntity c WHERE c.cboId IN :cboIds AND "+
            "(:approvalStatus = -1 OR c.approvalStatus= :approvalStatus)")
    Long getMeetingCountByApprovedStatusCboId(@Param("cboIds") final Set<BigInteger> cboIds,
                                              @Param("approvalStatus") final Integer approvalStatus);

    @Query(nativeQuery = true,value="SELECT * FROM vo_mtg  WHERE cbo_id=?1 AND mtg_no<=?2 ORDER BY mtg_no DESC " +
            "LIMIT ?3;")
    List<VoMtgEntity> fetchByVoIdAndMeetingNo(BigInteger cboId,
                                              Integer mtgNo,
                                              Integer noOfMeetings);


    @Query(nativeQuery = true,value="SELECT a.shg_id as shgId,a.shg_name as shgName,b.mtg_frq as meetingFrequency" +
            ",b.mtg_no as lastMeetingNo,b.mtg_date as lastMeetingDate," +
            "b.sav_comp_cb as totalSavings,b.amt_loans_os as totalOutstanding," +
            "b.approval_status as status,b.min_mtg_no,b.uid,u.user_name,u.mobile_no" +
            " FROM shg_profile a " +
            "INNER JOIN (SELECT s.*,b.min_mtg_no " +
            "from shg_mtg s INNER JOIN (SELECT Cbo_id,MAX(Mtg_no)Mtg_no,MIN(mtg_no)min_mtg_no FROM shg_mtg " +
            "GROUP BY cbo_id) b ON " +
            "b.cbo_id=s.cbo_id AND b.Mtg_no=s.Mtg_no)b " +
            "on a.shg_id=b.cbo_id LEFT JOIN (select user_id,user_name,mobile_no from users_master) " +
            "u ON a.user_id=u.user_id" +
            " where a.state_id = ?1 and a.district_id = ?2 and a.block_id = ?3 and " +
            "a.panchayat_id = ?4 and a.village_id = ?5 and " +
            "(?6 is null or lower(a.shg_name) like ?6) and DATE(b.mtg_date)  " +
            "BETWEEN ?7 AND ?8 ORDER BY ?9 LIMIT ?10 OFFSET ?11")
    List<Object[]> getListingData(Integer stateId,
                                  Integer districtId,
                                  Integer blockId,
                                  Integer panchayatId,
                                  Integer villageId,
                                  String shgName, Date mtgFrom, Date mtgTo, String sortParam, Integer size, Integer page);//,Pageable pageable);


    @Query("FROM VoMtgEntity c WHERE c.cboId = :cboId ")
    List<VoMtgEntity> getMtgListByCboId(@Param("cboId") final Long cboId);

    @Transactional
    @Query("FROM VoMtgEntity c WHERE c.cboId = :cboId and c.mtgNo = :mtgNo")
    VoMtgEntity getMtgByCboId(@Param("cboId") final BigInteger cboId,
                              @Param("mtgNo") final Integer mtgNo);

    @Query(nativeQuery = true,value = "SELECT * FROM vo_mtg a INNER JOIN (SELECT cbo_id,MAX(mtg_no) " +
            "Mx FROM vo_mtg " +
            "GROUP BY Cbo_id) b ON a.cbo_id=b.cbo_id AND a.mtg_no=b.mx WHERE a.cbo_id=?1 limit ?2")
   VoMtgEntity getMaxMtgByCboId(BigInteger cboId, Integer noOfMeetings);

    @Query(nativeQuery = true,value = "SELECT * FROM shg_mtg a INNER JOIN (SELECT cbo_id,MAX(mtg_no) " +
            "Mx FROM vo_mtg " +
            "GROUP BY Cbo_id) b ON a.cbo_id=b.cbo_id AND a.mtg_no between (mx-abs(cast (((?2)-1) as int))) and mx WHERE a.cbo_id=?1 order by a.mtg_no DESC")
    List<VoMtgEntity> getNoOfMeetingsFromMaxMtgByCboId(BigInteger cboId, Integer noOfMeetings);


    /*@Query(nativeQuery = true,value = "SELECT * FROM vo_mtg a INNER JOIN (SELECT cbo_id,MAX(mtg_no) " +
            "Mx FROM vo_mtg " +
            "GROUP BY Cbo_id) b ON a.cbo_id=b.cbo_id AND a.mtg_no<=b.mx WHERE a.cbo_id=?1 order by a.mtg_no DESC limit ?2")
    List<VoMtgEntity> getNoOfMeetingsFromMaxMtgByCboId(BigInteger cboId,Integer noOfMeetings);
*/
    @Query("select count(c) from VoMtgEntity c where " +
            "c.mtgNo=:mtgNo and c.cboId=:cboId")
    Integer existsByMtgNo(@Param("mtgNo") final Integer mtgNo,
                          @Param("cboId") final BigInteger cboId);

    @Query("select count(c) from VoMtgEntity c where " +
            "c.cboId=:cboId")
    Integer existsByCboId(
            @Param("cboId") final BigInteger cboId);


    @Query(nativeQuery = true,value="SELECT me.cbo_id AS cboId," +
                    "s.shg_name AS voName," +
                    "MIN(me.mtg_no) AS mtgNo," +
                    "MIN(me.mtg_date) AS mtgDate," +
                    "COUNT(me) AS pendingMtgCount " +
                    " FROM" +
                    " shg_mtg AS me" +
                    " INNER JOIN shg_profile AS s " +
                    " ON me.cbo_id = s.shg_id" +
                    " INNER JOIN federation_profile AS f" +
                    " ON f.federation_id = s.parent_cbo_code" +
                    " WHERE f.user_id=?1 AND me.approval_status=?2 AND s.is_active=?3" +
                    " GROUP BY me.cbo_id, s.shg_name ORDER BY me.cbo_id")
    List<Object[]> fetchMeetingApprovalList(String userId, Integer approvalStatus, Boolean isActive);

    @Query("select max(c.mtgNo) from ShgMtgEntity c where " +
            "c.cboId=:cboId")
    Integer maxMtgNoByCboId(
            @Param("cboId") final BigInteger cboId);

    @Modifying(clearAutomatically = true)
    @Query(nativeQuery = true, value = "Delete from vo_mtg where uid=?1")
    void deleteVoMtg(BigInteger uid);

	
	  @Query(nativeQuery = true,value =
	  "SELECT * FROM vo_mtg c where c.cbo_id = :cboId ORDER BY c.uid DESC LIMIT 1")
	  VoMtgEntity getLastMeetingByCboId(@Param("cboId")final BigInteger cboId);
	 
	
    
    @Query(nativeQuery = true,value = "SELECT count(c) FROM vo_mtg c where c.mtg_no = :mtgNo and c.cbo_id= :cboId ")
    Integer countByMeetingNo(@Param("mtgNo")final Integer mtgNo,@Param("cboId")final  BigInteger cboId);

 	@Query("FROM VoMtgEntity c WHERE c.mtgNo = :mtgNo and c.cboId= :cboId")
	VoMtgEntity getPreviousMtg(@Param("mtgNo")final Integer mtgNo,@Param("cboId")final  BigInteger cboId);

 

    


   /* @Query("select max(c.mtgNo) from ShgMtgEntity c where " + "c.cboId=:cboId and c.mtgNo=:mtgNo")
    List<ShgMtgEntity> getMtgNo(@Param("cboId") BigInteger cboId,@Param("mtgNo") final Integer mtgNo );
*/
    //@Query("select max(c.mtgNo) from ShgMtgEntity c where " + "c.cboId=:cboId")
    //List<ShgMtgEntity> getMtgNo(@Param("cboId") final BigInteger cboId);
}
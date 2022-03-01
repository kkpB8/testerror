package  com.devglan.tenant.dao;

import java.math.BigInteger;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.devglan.model.ShgMtgEntity;

@Repository
public interface ShgMtgDao extends JpaRepository<ShgMtgEntity, BigInteger> {
	
	 	@Query("SELECT count(c) FROM ShgMtgEntity c WHERE c.mtgNo = :meetingNo and c.cboId= :cboId")
	    Integer countByMeetingNo(@Param("meetingNo") final Integer meetingNo,@Param("cboId") final BigInteger cboId);
	 	
	 	@Query(nativeQuery = true, value = " Select * FROM shg_mtg c WHERE c.cbo_id = :cboId AND c.mtg_type != :zeroMeeting ORDER BY c.uid DESC LIMIT 1")
	 	ShgMtgEntity getLastRegularMeetingByCboId(@Param("cboId") final BigInteger cboId,
				 @Param("zeroMeeting") final Short zeroMeeting);
	
	 	@Query(nativeQuery = true, value = " Select * FROM shg_mtg c WHERE c.cbo_id = :cboId  ORDER BY c.uid DESC LIMIT 1")
	 	ShgMtgEntity getLastMeetingByCboId(@Param("cboId") final BigInteger cboId);
	
	 	@Query("FROM ShgMtgEntity c WHERE c.mtgNo = :meetingNo and c.cboId= :cboId")
	 	ShgMtgEntity getPreviousMtg(@Param("meetingNo") final Integer meetingNo,@Param("cboId") final BigInteger cboId);
	 	
	 	@Procedure("update_meeting_summary")
	 	void createMeetingSummary(int uid);
	 	
	 
	 	@Modifying(clearAutomatically = true)
		@Query(nativeQuery = true, value = "Delete from shg_mtg where uid=?1")
	 	void deleteShgMtg(BigInteger uid); 	
	 	
}
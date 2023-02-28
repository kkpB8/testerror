package  com.devglan.tenant.dao;


import com.devglan.model.ClfMemLoanScheduleEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;

import java.math.BigInteger;
import java.util.List;

public interface ClfMemLoanScheduleDao extends JpaRepository<ClfMemLoanScheduleEntity, Long>, JpaSpecificationExecutor<ClfMemLoanScheduleEntity> {
    @Query("from ClfMemLoanScheduleEntity cms where cms.loanNo = ?1 and cms.cboId = ?2 order by cms.installmentDate1,cms.subInstallmentNo")
    List<ClfMemLoanScheduleEntity> findByLoanNo(Integer loanNo, BigInteger cboId);

//	 @Modifying
//	@Query(nativeQuery = true, value = "Update shg_mem_loan_schedule set repaid=false, loan_paid=0, loan_os=principal_demand,last_paid_date=null where shg_mtg_uid=?1")
// 	void updateShgMemLoanSchedule(BigInteger shgMtgUID);
//
//	 @Modifying(clearAutomatically = true)
//	@Query(nativeQuery = true, value = "Delete from shg_mem_loan_schedule where shg_mtg_uid=?1 ") // - and sub_installment_no>1
// 	void deleteShgMemLoanSchedule(BigInteger shgMtgUID);
//
//	 @Query(nativeQuery = true, value = "Select * from shg_mem_loan_schedule where cbo_id=?1 and loan_no=?2 and installment_no = ?3 and sub_installment_no=?4")
//	 ShgMemLoanScheduleEntity findByParam(BigInteger cboId, Integer loanNo, Integer installmentNo,
//				Integer subInstallmentNo);

	
}
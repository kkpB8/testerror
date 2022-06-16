package  com.devglan.tenant.dao;

import java.math.BigInteger;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.devglan.model.ShgGroupLoanScheduleEntity;
import com.devglan.model.ShgMemLoanScheduleEntity;
import com.devglan.model.ShgMtgEntity;

public interface ShgMemLoanScheduleDao extends JpaRepository<ShgMemLoanScheduleEntity, Long>, JpaSpecificationExecutor<ShgMemLoanScheduleEntity> {

	 @Modifying
	@Query(nativeQuery = true, value = "Update shg_mem_loan_schedule set repaid=false, loan_paid=0, loan_os=principal_demand,last_paid_date=null,status=1 where shg_mtg_uid=?1 or (cbo_id=?2 and mtg_no=?3)")
 	void updateShgMemLoanSchedule(BigInteger shgMtgUID, BigInteger cboId, Integer mtgNo);

	 @Modifying(clearAutomatically = true)
	@Query(nativeQuery = true, value = "Delete from shg_mem_loan_schedule where shg_mtg_uid=?1 ") // - and sub_installment_no>1
 	void deleteShgMemLoanSchedule(BigInteger shgMtgUID);
	 
	 @Query(nativeQuery = true, value = "Select * from shg_mem_loan_schedule where cbo_id=?1 and loan_no=?2 and installment_no = ?3 and sub_installment_no=?4 and org_installment_no=?5 and status=?6")
	 ShgMemLoanScheduleEntity findByParam(BigInteger cboId, Integer loanNo, Integer installmentNo,
				Integer subInstallmentNo, Integer orgInstallmentNo, Integer status);

	
}
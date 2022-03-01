package  com.devglan.tenant.dao;

import java.math.BigInteger;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.devglan.model.ShgGroupLoanScheduleEntity;

public interface ShgGroupLoanScheduleDao extends JpaRepository<ShgGroupLoanScheduleEntity, Long>, JpaSpecificationExecutor<ShgGroupLoanScheduleEntity> {

	@Modifying
	@Query(nativeQuery = true, value = "Update shg_group_loan_schedule set repaid=false, loan_paid=0, loan_os=principal_demand,last_paid_date=null where shg_mtg_uid=?1")
 	void updateShgGroupLoanSchedule(BigInteger shgMtgUID);

	 @Modifying(clearAutomatically = true)
	@Query(nativeQuery = true, value = "Delete from shg_group_loan_schedule where shg_mtg_uid=?1") // -  and sub_installment_no>1
 	void deleteShgGroupLoanSchedule(BigInteger shgMtgUID);

	 @Query(nativeQuery = true, value = "Select * from shg_group_loan_schedule where cbo_id=?1 and loan_no=?2 and installment_no = ?3 and sub_installment_no=?4")
	ShgGroupLoanScheduleEntity findByParam(BigInteger cboId, Integer loanNo, Integer installmentNo,
			Integer subInstallmentNo);
}
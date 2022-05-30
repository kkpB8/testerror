package com.devglan.tenant.dao;

import com.devglan.model.VoGroupLoanScheduleEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.math.BigInteger;
import java.util.List;

public interface VoGroupLoanScheduleEntityDao extends JpaRepository<VoGroupLoanScheduleEntity, BigInteger>, JpaSpecificationExecutor<VoGroupLoanScheduleEntity> {
    @Query("FROM VoGroupLoanScheduleEntity c WHERE c.voGroupLoanUid = :voGroupLoanUid")
    List<VoGroupLoanScheduleEntity> fetchByVoGroupLoanUid(@Param("voGroupLoanUid") final BigInteger voGroupLoanUid);
    @Modifying
    @Query(nativeQuery = true, value = "Update vo_group_loan_schedule set repaid=false, loan_paid=0, loan_os=principal_demand,last_paid_date=null,status=1 where vo_mtg_uid=?1 or (cbo_id=?2 and mtg_no=?3)")
    void updateVoGroupLoanSchedule(BigInteger voMtgUID, BigInteger cboId, Integer mtgNo);

    @Modifying(clearAutomatically = true)
    @Query(nativeQuery = true, value = "Delete from vo_group_loan_schedule where vo_mtg_uid=?1 ")//and sub_installment_no>1
    void deleteVoGroupLoanSchedule(BigInteger voMtgUID);
    
    @Query(nativeQuery = true, value = "Select * from vo_group_loan_schedule where cbo_id=?1 and loan_no=?2 and installment_no = ?3 and sub_installment_no=?4 and org_installment_no=?5 and status=?6")
	VoGroupLoanScheduleEntity findByParam(BigInteger cboId, Integer loanNo, Integer installmentNo,
			Integer subInstallmentNo, Integer orgInstallmentNo, Integer status);
}
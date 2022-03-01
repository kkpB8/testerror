package com.devglan.tenant.dao;

import com.devglan.model.VoMemLoanEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.math.BigInteger;
import java.util.List;

public interface VoMemLoanEntityDao extends JpaRepository<VoMemLoanEntity, BigInteger>, JpaSpecificationExecutor<VoMemLoanEntity> {
    @Query("FROM VoMemLoanEntity c WHERE c.voMtgUid = :voMtgUid ")
    List<VoMemLoanEntity> fetchByVoMtgUid(@Param("voMtgUid") final BigInteger voMtgUid);

    @Query(nativeQuery = true,value="SELECT a.* from vo_mem_loan a inner join " +
            "(select cbo_id,loan_no from vo_mem_loan_txn WHERE " +
            "cbo_id=?1 and mtg_no=?2 GROUP BY cbo_id,loan_no) b " +
            "on a.cbo_id=b.cbo_id AND " +
            "a.loan_no=b.loan_no;")
    List<VoMemLoanEntity> fetchMemberLoanByMemberTransactions(BigInteger cboId,
                                                              Integer mtgNo);

    @Query(nativeQuery = true, value = " Select * FROM vo_mem_loan c WHERE c.cbo_id = ?1 AND c.loan_no = ?2")
	VoMemLoanEntity findLoanByCboIdLoanNo(BigInteger cboId, Integer loanNo);
    
    @Modifying
    @Query(nativeQuery = true, value = "update vo_mem_loan set completion_flag=false from "+
            "(select cbo_id,loan_no,completion_flag from  vo_mem_loan_txn "+
            " where completion_flag=true and cbo_id=?1 and mtg_no=?2) b "+
            " where vo_mem_loan.cbo_id=b.cbo_id and vo_mem_loan.loan_no=b.loan_no")
    void updateVoMemLoan(BigInteger cboId, Integer mtgNo);
}
package  com.devglan.tenant.dao;

import java.math.BigInteger;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.devglan.model.ShgGroupLoanEntity;
import com.devglan.model.ShgMemLoanEntity;

public interface ShgMemLoanDao extends JpaRepository<ShgMemLoanEntity, Long>, JpaSpecificationExecutor<ShgMemLoanEntity> {

	@Query(nativeQuery = true, value = " Select * FROM shg_mem_loan c WHERE c.cbo_id = ?1 AND c.loan_no = ?2")
	ShgMemLoanEntity findLoanByCboIdLoanNo(BigInteger cboId, Integer loanNo);
	
	@Modifying
    @Query(nativeQuery = true, value = "update shg_mem_loan set completion_flag=false from "+
            "(select cbo_id,loan_no,completion_flag from  shg_mem_loan_txn "+
            " where completion_flag=true and cbo_id=?1 and mtg_no=?2) b "+
            " where shg_mem_loan.cbo_id=b.cbo_id and shg_mem_loan.loan_no=b.loan_no")
    void updateShgMemLoan(BigInteger cboId, Integer mtgNo);
}
package  com.devglan.tenant.dao;



import com.devglan.model.ClfGroupLoanEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface ClfGroupLoanDao extends JpaRepository<ClfGroupLoanEntity, Long>, JpaSpecificationExecutor<ClfGroupLoanEntity> {

//	@Query(nativeQuery = true, value = " Select * FROM shg_group_loan c WHERE c.cbo_id = ?1 AND c.loan_no = ?2")
//	ShgGroupLoanEntity findLoanByCboIdLoanNo(BigInteger cboId, Integer loanNo);
//
//	 @Modifying
//	    @Query(nativeQuery = true, value = "update shg_group_loan set completion_flag=false from "+
//	            "(select cbo_id,loan_no,completion_flag from  shg_group_loan_txn "+
//	            " where completion_flag=true and cbo_id=?1 and mtg_no=?2) b "+
//	            " where shg_group_loan.cbo_id=b.cbo_id and shg_group_loan.loan_no=b.loan_no")
//	    void updateShgGroupLoan(BigInteger cboId, Integer mtgNo);


}
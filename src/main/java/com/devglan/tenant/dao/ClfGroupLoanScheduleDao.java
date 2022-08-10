package  com.devglan.tenant.dao;



import com.devglan.model.ClfGroupLoanScheduleEntity;
import com.devglan.model.ClfMemLoanScheduleEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;

import java.math.BigInteger;
import java.util.List;

public interface ClfGroupLoanScheduleDao extends JpaRepository<ClfGroupLoanScheduleEntity, Long>, JpaSpecificationExecutor<ClfGroupLoanScheduleEntity> {
    @Query("from ClfGroupLoanScheduleEntity cms where cms.loanNo = ?1 and cms.cboId = ?2 order by cms.installmentNo,cms.subInstallmentNo")
    List<ClfGroupLoanScheduleEntity> findByLoanNo(Integer loanNo, BigInteger cboId);


}
package  com.devglan.tenant.dao;



import com.devglan.model.ClfMemLoanEntity;
import com.devglan.model.ClfMemLoanScheduleEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ClfMemLoanDao extends JpaRepository<ClfMemLoanEntity, Long>, JpaSpecificationExecutor<ClfMemLoanEntity> {

    @Query("from ClfMemLoanEntity cms where cms.loanNo = ?1")
    ClfMemLoanEntity findByLoanNo(Integer loanNo);

}
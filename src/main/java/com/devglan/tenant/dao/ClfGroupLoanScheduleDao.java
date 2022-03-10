package  com.devglan.tenant.dao;



import com.devglan.model.ClfGroupLoanScheduleEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface ClfGroupLoanScheduleDao extends JpaRepository<ClfGroupLoanScheduleEntity, Long>, JpaSpecificationExecutor<ClfGroupLoanScheduleEntity> {


}
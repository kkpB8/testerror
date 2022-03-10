package  com.devglan.tenant.dao;

import com.devglan.model.ClfFinTxnDetMemEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;

import java.util.List;


public interface ClfFinTxnDetMemDao extends JpaRepository<ClfFinTxnDetMemEntity, Long>, JpaSpecificationExecutor<ClfFinTxnDetMemEntity> {
    @Query("FROM ClfFinTxnDetMemEntity cfm WHERE (cfm.isProcessed is null or cfm.isProcessed = 0)")
    List<ClfFinTxnDetMemEntity> getUnProcessedPayments();
}
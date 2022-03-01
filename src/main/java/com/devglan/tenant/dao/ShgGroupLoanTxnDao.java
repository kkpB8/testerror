package  com.devglan.tenant.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import com.devglan.model.ShgGroupLoanTxnEntity;

public interface ShgGroupLoanTxnDao extends JpaRepository<ShgGroupLoanTxnEntity, Long>, JpaSpecificationExecutor<ShgGroupLoanTxnEntity> {

}
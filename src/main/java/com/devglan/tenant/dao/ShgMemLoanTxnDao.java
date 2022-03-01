package  com.devglan.tenant.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import com.devglan.model.ShgMemLoanTxnEntity;

public interface ShgMemLoanTxnDao extends JpaRepository<ShgMemLoanTxnEntity, Long>, JpaSpecificationExecutor<ShgMemLoanTxnEntity> {

}
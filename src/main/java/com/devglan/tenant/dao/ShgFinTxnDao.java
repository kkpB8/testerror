package  com.devglan.tenant.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import com.devglan.model.ShgFinTxnEntity;

public interface ShgFinTxnDao extends JpaRepository<ShgFinTxnEntity, Long>, JpaSpecificationExecutor<ShgFinTxnEntity> {

}
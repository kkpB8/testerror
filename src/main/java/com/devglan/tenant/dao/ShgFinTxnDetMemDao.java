package  com.devglan.tenant.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import com.devglan.model.ShgFinTxnDetMemEntity;

public interface ShgFinTxnDetMemDao extends JpaRepository<ShgFinTxnDetMemEntity, Long>, JpaSpecificationExecutor<ShgFinTxnDetMemEntity> {

}
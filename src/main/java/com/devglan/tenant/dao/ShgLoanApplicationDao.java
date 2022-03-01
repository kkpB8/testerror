package  com.devglan.tenant.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import com.devglan.model.ShgLoanApplicationEntity;

public interface ShgLoanApplicationDao extends JpaRepository<ShgLoanApplicationEntity, Long>, JpaSpecificationExecutor<ShgLoanApplicationEntity> {

}
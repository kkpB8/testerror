package  com.devglan.tenant.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import com.devglan.model.ShgMtgDetEntity;

public interface ShgMtgDetDao extends JpaRepository<ShgMtgDetEntity, Long>, JpaSpecificationExecutor<ShgMtgDetEntity> {

}
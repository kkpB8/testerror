package  com.devglan.tenant.dao;

import java.math.BigInteger;

import org.springframework.data.convert.ReadingConverter;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import com.devglan.model.ShgMcpEntity;

@Repository
public interface ShgMcpDao extends JpaRepository<ShgMcpEntity, BigInteger>, JpaSpecificationExecutor<ShgMcpEntity> {

}
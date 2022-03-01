package com.devglan.tenant.dao;

import com.devglan.model.ShgMemSettlementEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import java.math.BigInteger;

public interface ShgMemSettlementDao extends JpaRepository<ShgMemSettlementEntity, BigInteger>, JpaSpecificationExecutor<ShgMemSettlementEntity> {

}

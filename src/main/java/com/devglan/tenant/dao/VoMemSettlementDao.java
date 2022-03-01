package com.devglan.tenant.dao;

import com.devglan.model.ShgMemSettlementEntity;
import com.devglan.model.VoMemSettlementEntity;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import java.math.BigInteger;

public interface VoMemSettlementDao extends JpaRepository<VoMemSettlementEntity, BigInteger>, JpaSpecificationExecutor<VoMemSettlementEntity> {

}

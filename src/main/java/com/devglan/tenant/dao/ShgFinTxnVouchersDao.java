package com.devglan.tenant.dao;

import com.devglan.model.ShgFinTxnVouchersEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.math.BigInteger;

public interface ShgFinTxnVouchersDao extends JpaRepository<ShgFinTxnVouchersEntity, BigInteger>, JpaSpecificationExecutor<ShgFinTxnVouchersEntity> {
}

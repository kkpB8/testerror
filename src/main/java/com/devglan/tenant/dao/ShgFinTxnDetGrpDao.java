package com.devglan.tenant.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import com.devglan.model.ShgFinTxnDetGrpEntity;

public interface ShgFinTxnDetGrpDao extends JpaRepository<ShgFinTxnDetGrpEntity, Long>, JpaSpecificationExecutor<ShgFinTxnDetGrpEntity> {

}
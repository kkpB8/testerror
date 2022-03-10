package com.devglan.tenant.dao;

import com.devglan.model.ClfFinTxnDetGrpEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;


public interface ClfFinTxnDetGrpDao extends JpaRepository<ClfFinTxnDetGrpEntity, Long>, JpaSpecificationExecutor<ClfFinTxnDetGrpEntity> {

}
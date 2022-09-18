package com.devglan.tenant.dao;

import com.devglan.model.ClfFinTxnDetGrpEntity;
import com.devglan.model.ClfFinTxnDetMemEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;

import java.util.List;


public interface ClfFinTxnDetGrpDao extends JpaRepository<ClfFinTxnDetGrpEntity, Long>, JpaSpecificationExecutor<ClfFinTxnDetGrpEntity> {
    @Query("FROM ClfFinTxnDetGrpEntity cfm WHERE (cfm.isProcessed is null or cfm.isProcessed = 0) ORDER BY cfm.uid ASC")
    List<ClfFinTxnDetGrpEntity> getUnProcessedPayments();
}
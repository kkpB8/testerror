package com.devglan.tenant.dao;

import com.devglan.model.VoGroupLoanTxnEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.math.BigInteger;
import java.util.List;

public interface VoGroupLoanTxnEntityDao extends JpaRepository<VoGroupLoanTxnEntity, BigInteger>, JpaSpecificationExecutor<VoGroupLoanTxnEntity> {
    @Query("FROM VoGroupLoanTxnEntity c WHERE c.cboId = :cboId ")
    List<VoGroupLoanTxnEntity> fetchByCboId(@Param("cboId") final BigInteger cboId);
}
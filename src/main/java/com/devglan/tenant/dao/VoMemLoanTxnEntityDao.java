package com.devglan.tenant.dao;

import com.devglan.model.VoMemLoanTxnEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.math.BigInteger;
import java.util.List;

public interface VoMemLoanTxnEntityDao extends JpaRepository<VoMemLoanTxnEntity, BigInteger>, JpaSpecificationExecutor<VoMemLoanTxnEntity> {
    @Query("FROM VoMemLoanTxnEntity c WHERE c.voMtgDetUid = :voMtgDetUid ")
    List<VoMemLoanTxnEntity> fetchByVoMtgDetUid(@Param("voMtgDetUid") final BigInteger voMtgDetUid);
}
package com.devglan.tenant.dao;

import com.devglan.model.VoFinTxnEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigInteger;
import java.util.List;

public interface VoFinTxnEntityDao extends JpaRepository<VoFinTxnEntity, BigInteger>, JpaSpecificationExecutor<VoFinTxnEntity> {
    @Transactional
    @Query("FROM VoFinTxnEntity c WHERE c.voMtgUid = :voMtgUid ")
     List<VoFinTxnEntity> fetchByVoMtgUid(@Param("voMtgUid") final BigInteger voMtgUid);
}

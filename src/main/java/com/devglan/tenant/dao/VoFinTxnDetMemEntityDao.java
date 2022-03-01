package com.devglan.tenant.dao;

import com.devglan.model.VoFinTxnDetMemEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.math.BigInteger;
import java.util.List;

public interface VoFinTxnDetMemEntityDao extends JpaRepository<VoFinTxnDetMemEntity, BigInteger>, JpaSpecificationExecutor<VoFinTxnDetMemEntity> {
    @Query("FROM VoFinTxnDetMemEntity c WHERE c.voMtgDetUid = :voMtgDetUid ")
    List<VoFinTxnDetMemEntity> fetchByVoMtgMemUid(@Param("voMtgDetUid") BigInteger voMtgDetUid);
}
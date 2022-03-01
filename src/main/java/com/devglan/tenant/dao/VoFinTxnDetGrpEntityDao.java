package com.devglan.tenant.dao;

import com.devglan.model.VoFinTxnDetGrpEntity;
import com.devglan.model.VoFinTxnDetMemEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.math.BigInteger;
import java.util.List;

public interface VoFinTxnDetGrpEntityDao extends JpaRepository<VoFinTxnDetGrpEntity, BigInteger>, JpaSpecificationExecutor<VoFinTxnDetGrpEntity> {
    @Query("FROM VoFinTxnDetGrpEntity c WHERE c.voMtgUid = :voMtgUid ")
    List<VoFinTxnDetGrpEntity> fetchByVoMtgUid(@Param("voMtgUid") final BigInteger voMtgUid);
}
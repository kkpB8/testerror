package com.devglan.tenant.dao;

import com.devglan.model.VoMtgDetEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.math.BigInteger;
import java.util.List;

public interface VoMtgDetEntityDao extends JpaRepository<VoMtgDetEntity, BigInteger>, JpaSpecificationExecutor<VoMtgDetEntity> {

    @Query("FROM VoMtgDetEntity c WHERE c.voMtgUid = :voMtgUid ")
    List<VoMtgDetEntity>  fetchByVoMtgUid(@Param("voMtgUid") final BigInteger voMtgUid);

    @Query("FROM VoMtgDetEntity c WHERE c.cboId = :cboId ")
    List<VoMtgDetEntity>  fetchByCboId(@Param("cboId") final Long cboId);


    @Query("SELECT COUNT(c) FROM VoMtgDetEntity c WHERE c.voMtgUid = :voMtgUid ")
    Long getMemberCount(@Param("voMtgUid") final BigInteger voMtgUid);
}
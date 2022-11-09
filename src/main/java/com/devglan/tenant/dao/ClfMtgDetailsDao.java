package com.devglan.tenant.dao;

import java.math.BigInteger;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.devglan.model.ClfMtgDetailsEntity;

public interface ClfMtgDetailsDao extends JpaRepository<ClfMtgDetailsEntity, Long>{
    

    @Query(nativeQuery = true,
        value = "select cm.* from clf_mtg cm where cm.cbo_id = ?1 and mtg_no = ?2"
    )
    ClfMtgDetailsEntity findMtgDetailsByCboIdAndMtgNo(BigInteger cboId, Integer mtgNo);
}

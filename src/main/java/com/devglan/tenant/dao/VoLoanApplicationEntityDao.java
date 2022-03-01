package com.devglan.tenant.dao;

import com.devglan.model.VoLoanApplicationEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.math.BigInteger;
import java.util.List;

public interface VoLoanApplicationEntityDao extends JpaRepository<VoLoanApplicationEntity, BigInteger>, JpaSpecificationExecutor<VoLoanApplicationEntity> {
    @Query("FROM VoLoanApplicationEntity c WHERE c.voMtgUid = :voMtgUid ")
    List<VoLoanApplicationEntity> fetchByVoMtgUid(@Param("voMtgUid") final BigInteger voMtgUid);

    @Query(nativeQuery = true,value="SELECT * FROM vo_loan_application a " +
            "INNER JOIN (SELECT uid,mtg_date FROM shg_mtg WHERE cbo_id=?1 AND mtg_no=?2) " +
            "b ON  a.request_date BETWEEN b.mtg_date+INTERVAL '-180 day' AND b.mtg_date;")
    List<VoLoanApplicationEntity> fetchLoanApplicationByMtgDate(BigInteger cboId,
                                                                Integer mtgNo);
}
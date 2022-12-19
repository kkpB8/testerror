package com.devglan.tenant.dao;

import com.devglan.model.ProfileMasterDataEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.math.BigInteger;
import java.util.List;

@Repository
public interface ProfileMasterDataDao extends JpaRepository<ProfileMasterDataEntity, BigInteger> {

    @Query(nativeQuery = true,value = "Select * FROM profile_master_data c WHERE c.cbo_id = ?1 and cbo_type=?2")
    ProfileMasterDataEntity findByCboIdType(BigInteger cboId,Short cboType);
}

package com.devglan.tenant.dao;

import com.devglan.model.MemberProfileMasterDataEntity;
import com.devglan.model.ProfileMasterDataEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.math.BigInteger;
import java.util.List;

@Repository
public interface MemberProfileMasterDataDao extends JpaRepository<MemberProfileMasterDataEntity, BigInteger> {

    @Query(nativeQuery = true,value = "Select * FROM member_profile_master_data c WHERE c.cbo_id = ?1 and member_id=?2")
    MemberProfileMasterDataEntity findByCboIdMemberId(BigInteger cboId,BigInteger memberId);
}

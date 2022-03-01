
package com.devglan.tenant.dao;

        import org.springframework.data.jpa.repository.JpaRepository;
        import org.springframework.data.jpa.repository.Query;
        import org.springframework.data.repository.query.Param;
        import org.springframework.stereotype.Repository;

import com.devglan.model.MemberSystemTagsEntity;

import java.math.BigInteger;
        import java.util.List;


@Repository
public interface MemberSystemTagsDao extends JpaRepository<MemberSystemTagsEntity, BigInteger> {
   /* @Query("FROM MemberSystemTagsEntity c WHERE c.memberCode = :memberCode and c.cboGUID = :cboGUID")
    MemberSystemTagsEntity findByMemberCode(@Param("memberCode") final BigInteger memberCode, @Param("cboGUID") final String cboGUID);
    */@Query("FROM MemberSystemTagsEntity c WHERE c.memberCode = :memberCode and c.cboId = :cboId")
    MemberSystemTagsEntity findByMemberCodeCboId(@Param("memberCode") final BigInteger memberCode, @Param("cboId") final BigInteger cboId);

  /*  @Query("FROM MemberSystemTagsEntity c WHERE c.memberCode = :memberCode and c.cboGUID = :cboGUID")
    List<MemberSystemTagsEntity> findListByMemberCode(@Param("memberCode") final BigInteger memberCode, @Param("cboGUID") final String cboGUID);
 */@Query("FROM MemberSystemTagsEntity c WHERE c.memberCode = :memberCode and c.cboId = :cboId")
    List<MemberSystemTagsEntity> findListByMemberCodeCboId(@Param("memberCode") final BigInteger memberCode, @Param("cboId") final BigInteger cboId);


/*

    @Query("select case when count(c)> 0 then true else false end from MemberAddressesDetailsEntity c where c.memberCode = :memberCode and c.cboGUID = :cboGUID")
    boolean existsByCustomKeys(@Param("memberCode") final BigInteger memberCode, @Param("cboGUID") final String cboGUID);
*/

    @Query("FROM MemberSystemTagsEntity c WHERE c.cboId = :cboId AND c.isActive= :isActive")
    List<MemberSystemTagsEntity> fetchByCboId(@Param("cboId") final BigInteger cboId,@Param("isActive") final Boolean isActive);

    @Query("FROM MemberSystemTagsEntity c WHERE c.systemTagGUID = :systemTagGUID AND c.isActive= :isActive")
    MemberSystemTagsEntity fetchByGUID(@Param("systemTagGUID") final String systemTagGUID,@Param("isActive") final Boolean isActive);

}

package com.devglan.tenant.dao;

import org.springframework.data.jpa.repository.*;
import org.springframework.data.repository.query.*;
import org.springframework.stereotype.*;

import com.devglan.model.SystemTagsEntity;

import java.math.*;
import java.util.*;


@Repository
public interface SystemTagsDao extends JpaRepository<SystemTagsEntity, BigInteger> {

    @Query("FROM SystemTagsEntity c WHERE c.systemTagGUID = :systemTagGUID AND c.isActive= :isActive")
    SystemTagsEntity fetchByGUID(@Param("systemTagGUID") final String systemTagGUID,
                                        @Param("isActive") final Boolean isActive);

    @Query("FROM SystemTagsEntity c WHERE c.cboCode = :cboCode AND c.isActive= :isActive")
    List<SystemTagsEntity> fetchByCboId(@Param("cboCode") final BigInteger cboCode,
                                        @Param("isActive") final Boolean isActive);



}
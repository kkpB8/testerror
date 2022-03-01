package com.devglan.tenant.dao;

import org.springframework.data.jpa.repository.*;
import org.springframework.data.repository.query.*;
import org.springframework.stereotype.*;

import com.devglan.model.SHGDesignationEntity;

import java.math.*;
import java.util.*;


@Repository
public interface SHGDesignationDao extends JpaRepository<SHGDesignationEntity, BigInteger> {

    @Query("FROM SHGDesignationEntity c WHERE c.cboGUID = :cboGUID")
    SHGDesignationEntity fetchByCboGUID(@Param("cboGUID") final String cboGUID);

    @Query("FROM SHGDesignationEntity c WHERE c.memberDesignationGUID = :memberDesignationGUID AND c.isActive= :isActive")
    SHGDesignationEntity fetchByGUID(@Param("memberDesignationGUID") final String memberDesignationGUID,
                                 @Param("isActive") final Boolean isActive);


    @Query("FROM SHGDesignationEntity c WHERE c.cboCode = :cboCode AND c.isActive= :isActive")
    List<SHGDesignationEntity> fetchByCboId(@Param("cboCode") final BigInteger cboCode,
                                        @Param("isActive") final Boolean isActive);
}

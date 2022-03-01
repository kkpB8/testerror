package com.devglan.tenant.dao;

import java.math.BigInteger;
import java.util.List;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import com.devglan.model.Processing_JsonEntity;

public interface ProcessingJsonDao extends CrudRepository<Processing_JsonEntity, BigInteger> {
	
	@Query(nativeQuery = true, value = " Select * FROM processing_json c WHERE c.flag = ?1 order by c.id ASC")
	List<Processing_JsonEntity> findByFlag(Short flag);
	
	/*
	 * @Modifying
	 * 
	 * @Transactional
	 * 
	 * @Query("update ShgProfileEntity u set u.deduplicationStatus = :deduplicationStatus where u.shgId =:shgId"
	 * ) void updateFlag(@Param("flag") final Short flag);
	 */
}

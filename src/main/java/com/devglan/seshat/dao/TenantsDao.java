package com.devglan.seshat.dao;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.devglan.model.TenantsEntity;

public interface TenantsDao extends CrudRepository<TenantsEntity, String> {

	 @Query("FROM TenantsEntity c WHERE c.identifier = :identifier")
	TenantsEntity findByIdentifier(@Param("identifier") final String identifier);
	
	

}

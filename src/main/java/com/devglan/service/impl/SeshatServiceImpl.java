/**
 * 
 */
package com.devglan.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.devglan.model.Processing_JsonEntity;
import com.devglan.model.TenantsEntity;
import com.devglan.service.SeshatService;
import com.devglan.seshat.dao.TenantsDao;
import com.devglan.tenant.dao.ProcessingJsonDao;

@Service
public class SeshatServiceImpl implements SeshatService {
	
	@Autowired
	private ProcessingJsonDao processingJsonDao;
	
	@Autowired
	private TenantsDao tenantsDao;
	
	
	public TenantsEntity findByIdentifier(String identifier) {
		TenantsEntity tenants = tenantsDao.findByIdentifier(identifier);
		
		return tenants;
	}
	
	public Boolean saveProcessingJson() {
		Processing_JsonEntity processingJson = new Processing_JsonEntity();
		processingJson.setJson("{\"gg\",\"gg\"}");
		processingJsonDao.save(processingJson);
		return true;
	}
}

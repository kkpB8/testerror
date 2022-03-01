/**
 * 
 */
package com.devglan.service;

import com.devglan.model.TenantsEntity;

public interface SeshatService {

	
	public TenantsEntity findByIdentifier(String identifier);
	
	public Boolean saveProcessingJson();
}

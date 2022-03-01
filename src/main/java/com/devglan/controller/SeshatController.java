package com.devglan.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.devglan.model.TenantsEntity;
import com.devglan.service.SeshatService;


@Controller
@RequestMapping("/seshat")
public class SeshatController {
	
	@Autowired
	private SeshatService seshatService;


	@RequestMapping(value = "/getByIdentifier", method = RequestMethod.GET)
	public ResponseEntity<TenantsEntity> findTenants(@RequestParam("identifier") String identifier) {

		TenantsEntity tenants = seshatService.findByIdentifier(identifier);
		return new ResponseEntity<TenantsEntity>(tenants, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public ResponseEntity<Boolean> save() {


		Boolean response = seshatService.saveProcessingJson();
		return new ResponseEntity<Boolean>(response, HttpStatus.OK);
	}


}

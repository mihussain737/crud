package com.crud.entity.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.crud.entity.dto.LeadDto;
import com.crud.service.LeadService;

@RestController
@RequestMapping("api/leads")
public class LeadController {	
	
	@Autowired
	private LeadService leadService;

	@PostMapping
	public ResponseEntity<LeadDto> saveLead(@RequestBody LeadDto leadDto){
		LeadDto savedLead=leadService.saveLead(leadDto);
		return new ResponseEntity<>(savedLead,HttpStatus.CREATED);
	}
}

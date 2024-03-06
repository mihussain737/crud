package com.crud.controller;

import com.crud.entity.Lead;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.crud.entity.dto.LeadDto;
import com.crud.service.LeadService;

import java.util.List;

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

	@GetMapping("/{id}")
	public ResponseEntity<LeadDto> getLeadById(@PathVariable Long id){
		LeadDto leadById = leadService.getLeadById(id);
		return new ResponseEntity<>(leadById,HttpStatus.OK);
	}

	@GetMapping()
	public ResponseEntity<List<LeadDto>> getAllLeads(){
		List<LeadDto> allLeads = leadService.getAllLeads();
		return new ResponseEntity<>(allLeads,HttpStatus.OK);
	}
	@DeleteMapping("/{id}")
	public ResponseEntity<String> deleteLeadById(@PathVariable Long id){
		leadService.deleteById(id);
		return new ResponseEntity<>("Lead is deleted with id:-"+id,HttpStatus.OK);
	}
	@PutMapping("/{id}")
	public ResponseEntity<LeadDto>updateLeadById(@PathVariable Long id,@RequestBody LeadDto leadDto){
		LeadDto leadDto1 = leadService.updateLeadById(id, leadDto);
		return new ResponseEntity<>(leadDto1,HttpStatus.OK);
	}
}

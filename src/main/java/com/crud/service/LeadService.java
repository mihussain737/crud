package com.crud.service;

import com.crud.entity.Lead;
import com.crud.entity.Lead;
import com.crud.dto.LeadDto;

import java.util.List;

public interface LeadService {

	LeadDto saveLead(LeadDto leadDto);
	LeadDto getLeadById(Long id);
	List<LeadDto> getAllLeads();

	void deleteById(Long id);
	LeadDto updateLeadById(Long id,LeadDto leadDto);
}

package com.crud.service;

import com.crud.entity.Lead;
import com.crud.entity.dto.LeadDto;

import java.util.List;

public interface LeadService {

	LeadDto saveLead(LeadDto leadDto);
	LeadDto getLeadById(Long id);
	List<LeadDto> getAllLeads();

}

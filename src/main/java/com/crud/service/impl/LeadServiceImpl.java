package com.crud.service.impl;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.crud.entity.Lead;
import com.crud.entity.dto.LeadDto;
import com.crud.repository.LeadRepository;
import com.crud.service.LeadService;

@Service
public class LeadServiceImpl implements LeadService{
	
	@Autowired
	private LeadRepository leadRepo;
	
	@Autowired
	private ModelMapper modelMapper;

	@Override
	public LeadDto saveLead(LeadDto leadDto) {
		
		//converting dto to entity
		Lead lead = modelMapper.map(leadDto, Lead.class);
		Lead savedLead = leadRepo.save(lead);
		//converting entity to dto
		return modelMapper.map(savedLead, LeadDto.class);
	}

}

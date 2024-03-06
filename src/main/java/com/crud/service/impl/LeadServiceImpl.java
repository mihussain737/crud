package com.crud.service.impl;

import com.crud.exception.LeadNotFoundException;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.crud.entity.Lead;
import com.crud.entity.dto.LeadDto;
import com.crud.repository.LeadRepository;
import com.crud.service.LeadService;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

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

	@Override
	public LeadDto getLeadById(Long id) {
		Lead lead = leadRepo.findById(id).orElseThrow(
				()-> new LeadNotFoundException("Lead is not found with id :-"+id)
		);
		return modelMapper.map(lead,LeadDto.class);
	}

	@Override
	public List<LeadDto> getAllLeads() {
		List<Lead> leads = leadRepo.findAll();
		List<LeadDto> dtos = leads.stream().map(lead -> modelMapper.map(leads, LeadDto.class)).collect(Collectors.toList());
		return dtos;
	}

	@Override
	public void deleteById(Long id) {
		leadRepo.findById(id).orElseThrow(
				()-> new LeadNotFoundException("Lead Not found")
		);
		leadRepo.deleteById(id);
	}

	@Override
	public LeadDto updateLeadById(Long id,LeadDto leadDto) {
		Lead lead = leadRepo.findById(id).orElseThrow(
				() -> new LeadNotFoundException("Lead is not found with id:-" + id)
		);
		lead.setId(id);
		lead.setFirstName(leadDto.getFirstName());
		lead.setLastName(leadDto.getLastName());
		lead.setEmail(leadDto.getEmail());
		lead.setMobile(leadDto.getMobile());
		Lead savedLead = leadRepo.save(lead);
		return modelMapper.map(savedLead,LeadDto.class);
	}

}

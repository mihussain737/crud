package com.crud.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.crud.entity.Lead;

public interface LeadRepository extends JpaRepository<Lead, Long>{

}

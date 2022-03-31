package com.company.candidatesearch.dao;

import java.util.List;


import org.springframework.data.repository.CrudRepository;

import com.company.candidatesearch.model.Candidate;


public interface CandidateRepo extends CrudRepository<Candidate, Integer> {
	
	
	List<Candidate> findAll();
	
	

}

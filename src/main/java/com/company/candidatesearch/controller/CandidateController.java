package com.company.candidatesearch.controller;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.company.candidatesearch.dao.CandidateRepo;
import com.company.candidatesearch.model.Candidate;





@Controller
public class CandidateController {
	
	@Autowired
	CandidateRepo repository;

	@GetMapping({"/","/home"})
	public ModelAndView home() {
		ModelAndView modelAndView = new ModelAndView("candidatedetails");
		
	   
	   List<Candidate> candidateList = repository.findAll();
	   
	   modelAndView.addObject("candidatelist", candidateList);
	   return modelAndView;
	   
	   
	
	}
	
	@GetMapping({"/addPage"})
	public String addPage() {
		return "add";
	}
	
	@PostMapping({"/addCandidateDetails"})
	public ModelAndView addCandidateDetails(@RequestParam(name = "txt_name") String name,@RequestParam(name = "txt_skills") String skills ) {
		
		ModelAndView modelAndView = new ModelAndView("add");
		
		modelAndView.addObject("name",name);
		modelAndView.addObject("skills",skills);
		
		String message = "Add record successful!!!";
		try {
			
			Candidate candidate = new Candidate(); 
			candidate.setName(name); 
			candidate.setSkills(skills);
			repository.save(candidate);
		}catch(Exception ex) {
			message = "Add record failed!" + ex.getMessage();
			
		}
		modelAndView.addObject("message", message);
		return modelAndView;
	}
	
	
	@GetMapping({"/updatePage"})
	public ModelAndView updatePage(@RequestParam(name = "id") String id, @RequestParam(name = "name") String name,@RequestParam(name = "skills") String skills ) {
		
		ModelAndView modelAndView = new ModelAndView("update");
		
		
		
		modelAndView.addObject("id",id);
		modelAndView.addObject("name",name);
		modelAndView.addObject("skills",skills);
		modelAndView.addObject("message", "");

		
		return modelAndView;
	}
	
	
	@PostMapping({"/updateCandidateDetails"})
	public ModelAndView updateCandidateDetails(@RequestParam(name = "id") int id, @RequestParam(name = "txt_name") String name,@RequestParam(name = "txt_skills") String skills ) {
		
		ModelAndView modelAndView = new ModelAndView("update");
		modelAndView.addObject("id",id);
		modelAndView.addObject("name",name);
		modelAndView.addObject("skills",skills);
		
		String message = "Update successful!!!";
		try {
			
			Candidate candidate = repository.findById(id).get(); 
			candidate.setName(name); 
			candidate.setSkills(skills);
			repository.save(candidate);
		}catch(Exception ex) {
			message = "Update failed!" + ex.getMessage();
			
		}
		
			
		modelAndView.addObject("message", message);
		
		return modelAndView;
	}
	
	
	@GetMapping({"/delete"})
	public ModelAndView delete(@RequestParam(name = "id") int id) {
		
		
		ModelAndView modelAndView = new ModelAndView("candidatedetails");
	try {
			
		   repository.deleteById(id);
		}catch(Exception ex) {
			
			
		}
	 List<Candidate> candidateList = repository.findAll();
	   
	   modelAndView.addObject("candidatelist", candidateList);
	   return modelAndView;
		
		
	}
	
	
	}
	


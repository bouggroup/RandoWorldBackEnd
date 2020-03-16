package com.heducap.RandoWorldBackEndFinal.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.heducap.RandoWorldBackEndFinal.metier.Localisation;
import com.heducap.RandoWorldBackEndFinal.repositories.LocalisationRepository;

@RestController
@RequestMapping(value="/localisation")
@CrossOrigin
public class LocalisationController {
	
	@Autowired
	private LocalisationRepository localisationRepository;
	
//	@GetMapping
//	public Iterable<Localisation> findByAllLocalisation(){
//		return this.localisationRepository.findAll();
//	}
	
	@GetMapping("/page")
	public Page<Localisation> findByAll(@PageableDefault(size = 10, page = 0) Pageable page){
		return this.localisationRepository.findAll(page);
	}
	
	@PostMapping(value="/insert",consumes="application/json")
	public ResponseEntity<Localisation> createLocalisation(@RequestBody Localisation localisation){
		
		localisation = localisationRepository.save(localisation);
		
		return new ResponseEntity<Localisation>(localisation,HttpStatus.CREATED);
		
	}

}

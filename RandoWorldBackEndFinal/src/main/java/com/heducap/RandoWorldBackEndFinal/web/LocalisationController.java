package com.heducap.RandoWorldBackEndFinal.web;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.heducap.RandoWorldBackEndFinal.metier.Localisation;
import com.heducap.RandoWorldBackEndFinal.repositories.LocalisationRepository;

@RestController
@RequestMapping(value="/localisation")
@CrossOrigin
public class LocalisationController {


	@Autowired
	private LocalisationRepository localisationRepository;
	
	@GetMapping
	public Iterable<Localisation> findAll(){
		return this.localisationRepository.findAll();
	}
	
	
	@PostMapping
	public ResponseEntity<Localisation> createLocalisation(@RequestBody Localisation localisation) {
		localisation = this.localisationRepository.save(localisation);
		return new ResponseEntity<Localisation>(localisation, HttpStatus.CREATED);

	}

}

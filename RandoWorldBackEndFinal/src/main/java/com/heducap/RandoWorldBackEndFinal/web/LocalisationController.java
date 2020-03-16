package com.heducap.RandoWorldBackEndFinal.web;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.heducap.RandoWorldBackEndFinal.metier.Itineraire;
import com.heducap.RandoWorldBackEndFinal.metier.Localisation;
import com.heducap.RandoWorldBackEndFinal.repositories.ItineraireRepository;
import com.heducap.RandoWorldBackEndFinal.repositories.LocalisationRepository;

@RestController
@RequestMapping(value="/localisation")
@CrossOrigin
public class LocalisationController {


	@Autowired
	private LocalisationRepository localisationRepository;
	
	@Autowired
	private ItineraireRepository itineraireRepository;
	
	@GetMapping
	public Iterable<Localisation> findAll(){
		return this.localisationRepository.findAll();
	}
	
	
	@PostMapping
	public ResponseEntity<Localisation> createLocalisation(@RequestBody Localisation localisation,
														   @RequestParam("itineraireId")  int itineraireId) {
		
		Optional<Itineraire> itineraireOpt =  this.itineraireRepository.findById(itineraireId);
		if(! itineraireOpt.isPresent())
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		
		
		localisation.setItineraire(itineraireOpt.get());
		localisation = this.localisationRepository.save(localisation);
		return new ResponseEntity<Localisation>(localisation, HttpStatus.CREATED);

	}

}

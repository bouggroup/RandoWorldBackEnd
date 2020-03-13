package com.heducap.RandoWorldBackEndFinal.web;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.projection.ProjectionFactory;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.heducap.RandoWorldBackEndFinal.metier.Randonnee;
import com.heducap.RandoWorldBackEndFinal.metier.projections.RandonneeComplet;
import com.heducap.RandoWorldBackEndFinal.repositories.RandonneeRepository;

@RestController
@RequestMapping(value="/randonnees")
@CrossOrigin
public class RandonneeController {

	@Autowired
	private RandonneeRepository randonneeRepository;
	
	private final ProjectionFactory projectionFactory;

	@Autowired
	public RandonneeController(ProjectionFactory projectionFactory) {
		this.projectionFactory = projectionFactory;
	}


	@GetMapping
	public Page<Randonnee> findAllRando(@PageableDefault(size = 10, page = 0) Pageable page){
		return this.randonneeRepository.findAll(page);
	}


	@GetMapping("/detail/{id:[0-9]+}")
	public ResponseEntity<Randonnee> findRandoById(@PathVariable("id") int id){
		Optional<Randonnee> randoOpt =  this.randonneeRepository.findById(id);
		if(!randoOpt.isPresent())
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		else
			return new ResponseEntity<>(randoOpt.get(), HttpStatus.OK);
	}


	@PostMapping
	public ResponseEntity<Randonnee> createRando(@RequestBody Randonnee randonnee){
		/**
		 * Check Request Param if necessary (ex: Image , ...) 
		 */

		return new ResponseEntity<>(this.randonneeRepository.save(randonnee), HttpStatus.CREATED);	
	}

	@PutMapping
	public ResponseEntity<Randonnee> updateRando(@RequestBody Randonnee randonnee){
		if(!this.randonneeRepository.existsById(randonnee.getId()) )
			return new ResponseEntity<Randonnee>(HttpStatus.NOT_FOUND);
		Randonnee rando =  randonnee;
		return new ResponseEntity<Randonnee>(rando, HttpStatus.ACCEPTED);

	}

	@GetMapping("/allData")
	public ResponseEntity<Page<RandonneeComplet>> findAllRandoComplet(@PageableDefault(size = 10, page = 0) Pageable page){

		return new ResponseEntity<Page<RandonneeComplet>>(randonneeRepository.findAll(page).map(
				jv -> projectionFactory.createProjection(RandonneeComplet.class, jv)), HttpStatus.OK);
	}
}

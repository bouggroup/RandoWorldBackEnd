package com.heducap.RandoWorldBackEndFinal.metier;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.vividsolutions.jts.geom.Geometry;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter @Setter @AllArgsConstructor @NoArgsConstructor
@Entity
public class Localisation {
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)private int id;

	private Geometry dataGps;
	@OneToOne @JsonIgnore private Itineraire itineraire;
	

	public Localisation(int id, Geometry dataGps) {
		super();
		this.id = id;
		this.dataGps = dataGps;
	}
	
	

}

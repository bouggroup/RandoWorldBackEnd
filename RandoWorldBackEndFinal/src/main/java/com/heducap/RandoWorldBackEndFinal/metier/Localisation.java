package com.heducap.RandoWorldBackEndFinal.metier;


import java.time.LocalDateTime;
import java.util.Set;

import javax.persistence.Column;

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

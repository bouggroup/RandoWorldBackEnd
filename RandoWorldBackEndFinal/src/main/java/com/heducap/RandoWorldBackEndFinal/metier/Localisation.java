package com.heducap.RandoWorldBackEndFinal.metier;

import java.time.LocalDateTime;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

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
	@OneToOne private Itineraire itineraire;

}

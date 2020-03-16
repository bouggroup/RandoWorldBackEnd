package com.heducap.RandoWorldBackEndFinal.metier;

import java.time.LocalDateTime;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import com.bedatadriven.jackson.datatype.jts.serialization.GeometryDeserializer;
import com.bedatadriven.jackson.datatype.jts.serialization.GeometrySerializer;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.vividsolutions.jts.geom.Geometry;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter @AllArgsConstructor @NoArgsConstructor
@Entity
public class Localisation {
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)private int id;

	private  Geometry dataGps;
	@OneToOne @JsonIgnore private Itineraire itineraire;
	
	
//		@JsonSerialize(using = GeometrySerializer.class)
//		    @JsonDeserialize(using = GeometryDeserializer.class)
//		    @Column(name = "dataGps", columnDefinition = "Geometry")
//		    public Geometry getDataGps() {
//		        return dataGps;
//		    } 
		 


}

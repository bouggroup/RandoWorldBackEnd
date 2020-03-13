package com.heducap.RandoWorldBackEndFinal.metier;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter @NoArgsConstructor
@Entity
public class Image {
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)private int id;

	private String nom;
	private String fileName;
	private String contentType;
	private String storageId;
	private String thumbStorageId;
	@OneToOne @JsonIgnore private Itineraire itineraire;
	
	public Image(int id, String nom, String fileName, String contentType, String storageId, String thumbStorageId) {
		super();
		this.id = id;
		this.nom = nom;
		this.fileName = fileName;
		this.contentType = contentType;
		this.storageId = storageId;
		this.thumbStorageId = thumbStorageId;
	}
	
	

}

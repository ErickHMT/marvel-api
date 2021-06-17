package com.api.marvel.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;

import lombok.Data;

@Entity
@Data
@Table(name = "TEXT_OBJECT")
public class TextObject {

	@Id 
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String type;
	private String language;
	private String text;
	
	@ManyToOne
	@JoinColumn(name = "ID_COMIC")
    @JsonBackReference
    private Comic comic;
	
}

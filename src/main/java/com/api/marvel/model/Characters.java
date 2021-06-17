package com.api.marvel.model;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Data
@Table(name = "CHARACTERS")
public class Characters {

	@Id 
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String name;
	private String description;
	private LocalDateTime modified;
	private String resourceURI;
	
    @ManyToOne
    @JoinColumn(name = "ID_THUMBNAIL")
	private Thumbnail thumbnail;
    
    @ManyToOne
    @JoinColumn(name = "ID_COMIC")
	private Comic comics;
    
    @ManyToOne
    @JoinColumn(name = "ID_SERIE")
	private Serie series;
    
    @ManyToOne
    @JoinColumn(name = "ID_STORY")
	private Story stories;
	
	
}

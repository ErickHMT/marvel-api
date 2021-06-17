package com.api.marvel.model;

import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

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
	private ComicList comics;
    
    @ManyToOne
    @JoinColumn(name = "ID_SERIE")
	private Serie series;
    
    @ManyToOne
    @JoinColumn(name = "ID_STORY")
	private Story stories;
	
    @ManyToOne
    @JoinColumn(name = "ID_EVENT")
	private Event events;
    
    @OneToMany(fetch = FetchType.EAGER, mappedBy = "characters")
    @Fetch(FetchMode.SUBSELECT)
    private List<Url> urls;
    
}

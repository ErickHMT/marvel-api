package com.api.marvel.model;

import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import lombok.Data;

@Entity
@Data
@Table(name = "COMIC")
public class Comic {

	@Id 
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private Integer digitalId;
	private String title;
	private Double issueNumber;
	private String variantDescription;
	private String description;
	private LocalDateTime modified;
	private String isbn;
	private String upc;
	private String diamondCode;
	private String ean;
	private String issn;
	private String format;
	private Integer pageCount;
	private String resourceURI;
	
    @OneToMany(fetch = FetchType.EAGER, mappedBy = "comic")
    @Fetch(FetchMode.SUBSELECT)
    private List<TextObject> textObjects;
    
    @OneToMany(fetch = FetchType.EAGER, mappedBy = "characters")
    @Fetch(FetchMode.SUBSELECT)
    private List<Url> urls;
    
    @OneToMany(fetch = FetchType.EAGER, mappedBy = "comic")
    @Fetch(FetchMode.SUBSELECT)
    private List<ComicSummary> items;
	
}

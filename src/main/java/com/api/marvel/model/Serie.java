package com.api.marvel.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import com.fasterxml.jackson.annotation.JsonInclude;

import lombok.Data;

@Entity
@Data
@Table(name = "SERIE")
public class Serie{

	@Id 
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private int available;
	
	@JsonInclude()
	@Transient
	private int returned;
	
	@Column(name = "collection_uri")
	private String collectionURI;
	
    @OneToMany(fetch = FetchType.EAGER, mappedBy = "serie")
    @Fetch(FetchMode.SUBSELECT)
    private List<SerieSummary> items;
}

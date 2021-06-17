package com.api.marvel.service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.Collections;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import com.api.marvel.repository.CharactersRepository;
import com.api.marvel.specification.SpecificationCharacters;
import com.api.marvel.util.MarvelAPIConstantes;
import com.api.marvel.controller.dto.DataContainer;
import com.api.marvel.model.Characters;

@Service
public class CharactersService {
	
	private final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
	
	@Autowired
	CharactersRepository charactersrepository;

	public DataContainer<Characters> findByFilter(Map<String,String> params) {
		
		Integer limit;
		Integer offset;
		
		String name = params.get("name");
		String startsWith = params.get("startsWith");
		String modifiedSince = params.get("modifiedSince");
		String limitParam = params.get("limit");
		String offsetParam = params.get("offset");
		
		LocalDateTime modifiendSinceDate = null;
		if(modifiedSince != null) {
			modifiendSinceDate = LocalDate.parse(modifiedSince, formatter).atStartOfDay();
		}
		
		if(limitParam == null) {
			limit = MarvelAPIConstantes.DEFAULT_PAGINATION_LIMIT;
		} else {
			limit = Integer.parseInt(limitParam);
		}
		
		if(offsetParam == null) {
			offset = MarvelAPIConstantes.DEFAULT_PAGINATION_OFFSET;
		} else {
			offset = Integer.parseInt(offsetParam);
		}
		
		Pageable pageable = PageRequest.of(offset, limit);
		Page<Characters> rawData;
		
		// TODO: Corrigir consulta para não ser necessário validar parametros novamente
		if(name == null && startsWith == null && modifiedSince == null) {
			rawData = charactersrepository.findAll(pageable);
		} else {
			rawData = charactersrepository.findAll(Specification
					.where(SpecificationCharacters.name(name))
					.or(SpecificationCharacters.startsWith(startsWith))
					.or(SpecificationCharacters.modifiedSince(modifiendSinceDate)),
					pageable
					);
		}
		
		return new DataContainer<Characters>(offset, limit, rawData.getTotalElements(), rawData.getNumberOfElements(), rawData.getContent());
	}

	public DataContainer<Characters> findOne(Long characterId) {

		Optional<Characters> rawData = charactersrepository.findById(characterId);		
		
		if(rawData.isPresent()) {
			return new DataContainer<Characters>(null, null, 1, 1, Arrays.asList(rawData.get()));			
		}
		
		return new DataContainer<Characters>(null, null, 0, 0, Collections.emptyList());
	}
	
}

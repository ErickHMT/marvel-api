package com.api.marvel.service;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.api.marvel.model.DataContainer;
import com.api.marvel.repository.CharactersRepository;
import com.api.marvel.model.Characters;

@Service
public class CharactersService {
	
	@Autowired
	CharactersRepository Charactersrepository;

	public DataContainer<Characters> findByFilter(Map<String,String> params) {
		
		System.out.println("dentro do service");
		
		List<Characters> rawData = Charactersrepository.findAll();
		
		return new DataContainer<Characters>(0, 0, 0, 0, rawData);
	}

	public DataContainer<Characters> findOne(Long characterId) {

		Optional<Characters> rawData = Charactersrepository.findById(characterId);
		
		if(rawData.isPresent()) {
			return new DataContainer<Characters>(null, null, 1, 1, Arrays.asList(rawData.get()));			
		}
		
		return new DataContainer<Characters>(null, null, 0, 0, Collections.emptyList());
	}
	
}

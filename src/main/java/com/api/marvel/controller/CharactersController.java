package com.api.marvel.controller;

import java.util.Collections;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.api.marvel.model.CharacterDataContainer;
import com.api.marvel.model.CharacterDataWrapper;
import com.api.marvel.service.CharactersService;

@RestController
@RequestMapping("/characters")
public class CharactersController {
	
    @Autowired
    CharactersService charactersService;

	@GetMapping
	public ResponseEntity<?> characters(@RequestParam Map<String,String> params) {
		
		params.entrySet().forEach(entry -> {
		    System.out.println(entry.getKey() + " -> " + entry.getValue());
		});

		CharacterDataWrapper response = new CharacterDataWrapper(200, "OK", new CharacterDataContainer<com.api.marvel.model.Character>(0, 0, 0, 0, Collections.emptyList()));
		return new ResponseEntity<>(response, HttpStatus.OK);
	}
	
}

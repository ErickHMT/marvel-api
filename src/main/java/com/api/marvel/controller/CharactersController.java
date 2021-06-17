package com.api.marvel.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.api.marvel.model.DataContainer;
import com.api.marvel.model.DataWrapper;
import com.api.marvel.controller.dto.ResponseErrorDTO;
import com.api.marvel.model.Characters;
import com.api.marvel.service.CharactersService;
import com.api.marvel.util.ErrorMessage;

@RestController
@RequestMapping("/characters")
public class CharactersController {
	
    @Autowired
    CharactersService charactersService;

	@GetMapping
	public ResponseEntity<?> findByFilter(@RequestParam Map<String,String> params) {
		
		params.entrySet().forEach(entry -> {
		    System.out.println(entry.getKey() + " -> " + entry.getValue());
		});

		DataContainer<Characters> data = charactersService.findByFilter(params);

		DataWrapper response = new DataWrapper(200, "OK", data);
		return new ResponseEntity<>(response, HttpStatus.OK);
	}
	
	@GetMapping("/{characterId}")
	@ResponseBody
	public ResponseEntity<?> findOne(@PathVariable Long characterId) {

		DataContainer<Characters> data = charactersService.findOne(characterId);
		
		if(data.getResults().size() == 0) {
			ResponseErrorDTO error = new ResponseErrorDTO(404, ErrorMessage.CHARACTER_NOT_FOUND.getMessage());
			return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
		}
		
		DataWrapper response = new DataWrapper(200, "OK", data);
		return new ResponseEntity<>(response, HttpStatus.OK);
	}
	
}

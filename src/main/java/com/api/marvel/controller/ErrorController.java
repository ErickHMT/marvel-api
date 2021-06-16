package com.api.marvel.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.api.marvel.controller.dto.ResponseErrorDTO;
import com.api.marvel.util.ErrorMessage;

@RestController
@RequestMapping("/error/validation")
public class ErrorController {

	@GetMapping
	public ResponseEntity<?> getError(@RequestParam("errorCode") int errorCode, @RequestParam("errorMessage") String errorMessage) {

		ResponseErrorDTO error = new ResponseErrorDTO(errorCode, ErrorMessage.valueOf(errorMessage).getMessage());
		return new ResponseEntity<>(error, HttpStatus.valueOf(errorCode));
	}
	
}

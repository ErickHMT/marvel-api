package com.api.marvel.controller.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ResponseErrorDTO {

	private int code;
	private String status;
}

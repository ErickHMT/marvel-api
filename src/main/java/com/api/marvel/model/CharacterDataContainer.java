package com.api.marvel.model;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class CharacterDataContainer<T> {

	private int offset;
	private int limit;
	private int total;
	private int count;
	private List<T> results;
}

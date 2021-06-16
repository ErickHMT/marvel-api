package com.api.marvel.model;

import java.util.List;

import com.api.marvel.util.MarvelAPIConstantes;

import lombok.Data;

@Data
public class DataContainer<T> {

	private int offset;
	private int limit;
	private int total;
	private int count;
	private List<T> results;

	public DataContainer(Integer offset, Integer limit, int total, int count, List<T> results) {
		this.offset = offset == null ? MarvelAPIConstantes.DEFAULT_PAGINATION_OFFSET : offset;
		this.limit = limit == null ? MarvelAPIConstantes.DEFAULT_PAGINATION_LIMIT : limit;
		this.total = total;
		this.count = count;
		this.results = results;
	}
	
	
}

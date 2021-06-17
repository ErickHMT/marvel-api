package com.api.marvel.specification;

import java.time.LocalDateTime;

import org.springframework.data.jpa.domain.Specification;

import com.api.marvel.model.Characters;

public class SpecificationCharacters {
	
	public static Specification<Characters> name(String name) {
		return (root, criteriaQuery, criteriaBuilder) -> 
			criteriaBuilder.equal(root.get("name"), name);
	}
	
	public static Specification<Characters> startsWith(String name) {
		return (root, criteriaQuery, criteriaBuilder) -> 
			criteriaBuilder.like(root.get("name"), name + "%");
	}
	
	public static Specification<Characters> modifiedSince(LocalDateTime modifiedSince) {
		return (root, criteriaQuery, criteriaBuilder) -> 
			criteriaBuilder.equal(root.get("modified"), modifiedSince);
	}
	
}

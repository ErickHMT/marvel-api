package com.api.marvel.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.api.marvel.model.Characters;

@Repository
public interface CharactersRepository extends PagingAndSortingRepository<Characters, Long>, JpaSpecificationExecutor<Characters> {

	List<Characters> findAll();
	
}

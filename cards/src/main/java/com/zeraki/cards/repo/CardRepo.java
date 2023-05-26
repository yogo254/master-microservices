package com.zeraki.cards.repo;

import java.util.List;

import org.springframework.data.repository.ListCrudRepository;

import com.zeraki.cards.model.Cards;

public interface CardRepo extends ListCrudRepository<Cards,Long> {
	List<Cards> findByCustomerId(Long customerId);
	
}

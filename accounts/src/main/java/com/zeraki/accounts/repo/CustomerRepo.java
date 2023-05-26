package com.zeraki.accounts.repo;

import org.springframework.data.repository.ListCrudRepository;

import com.zeraki.accounts.model.Customer;

public interface CustomerRepo extends ListCrudRepository<Customer,Long> {
	
}

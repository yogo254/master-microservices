package com.zeraki.accounts.repo;

import java.util.Optional;

import org.springframework.data.repository.ListCrudRepository;

import com.zeraki.accounts.model.Accounts;

public interface AccountsRepo extends ListCrudRepository<Accounts,Long> {
	Optional<Accounts> findOneByCustomerId(Long customerId);
	
}

package com.zeraki.loan.repo;

import java.util.List;

import org.springframework.data.repository.ListCrudRepository;

import com.zeraki.loan.model.Loans;

public interface LoanRepo extends ListCrudRepository<Loans,Long> {
	List<Loans> findByCustomerId(Long customerId);
	
}

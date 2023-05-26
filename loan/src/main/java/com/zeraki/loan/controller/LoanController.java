package com.zeraki.loan.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.zeraki.loan.model.Loans;
import com.zeraki.loan.repo.LoanRepo;

@RestController
@RequestMapping("/loan")
public class LoanController {
	@Autowired
	private LoanRepo loanRepo;

	@GetMapping
	public List<Loans> getCustomerLoans(@RequestParam Long customerId) {
		return loanRepo.findByCustomerId(customerId);

	}

}

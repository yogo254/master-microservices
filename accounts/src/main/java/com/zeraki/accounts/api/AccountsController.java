package com.zeraki.accounts.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.zeraki.accounts.model.Accounts;
import com.zeraki.accounts.repo.AccountsRepo;

@RestController

public class AccountsController {
	@Autowired
	private AccountsRepo accountsRepo;
	@GetMapping("/account")
	public Accounts getAccountDetails(@RequestParam Long customerId) {
		return accountsRepo.findOneByCustomerId(customerId).orElse(null);
	}
	
}

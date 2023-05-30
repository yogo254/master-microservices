package com.zeraki.accounts.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.zeraki.accounts.client.CardsFeignClient;
import com.zeraki.accounts.client.LoansFeignClient;
import com.zeraki.accounts.config.AccountsConfig;
import com.zeraki.accounts.dto.AccountConfigDto;
import com.zeraki.accounts.dto.Cards;
import com.zeraki.accounts.dto.CustomerDetails;
import com.zeraki.accounts.dto.Loans;
import com.zeraki.accounts.model.Accounts;
import com.zeraki.accounts.repo.AccountsRepo;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;

@RestController
@RequestMapping("/account")
public class AccountsController {
	@Autowired
	private AccountsRepo accountsRepo;
	@Autowired
	private AccountsConfig accountsConfig;

	@Autowired
	private LoansFeignClient loansFeignClient;
	@Autowired
	private CardsFeignClient cardsFeignClient;

	@GetMapping
	public Accounts getAccountDetails(@RequestParam Long customerId) {
		return accountsRepo.findOneByCustomerId(customerId).orElse(null);
	}

	@GetMapping("/config")
	public AccountConfigDto getAccountsConfig() {
		AccountConfigDto dto = new AccountConfigDto();
		dto.setActiveBranches(accountsConfig.getActiveBranches());
		dto.setBuildVersion(accountsConfig.getBuildVersion());
		dto.setMailDetails(accountsConfig.getMailDetails());
		dto.setMsg(accountsConfig.getMsg());
		return dto;
	}

	@GetMapping("/customerDetails")
	@CircuitBreaker(name = "customerDetails", fallbackMethod = "getCustomerDetailsFallback")
	public CustomerDetails getCustomerDetails(@RequestParam Long customerId) {
		Accounts accounts = accountsRepo.findOneByCustomerId(customerId).orElse(null);
		List<Loans> loans = loansFeignClient.getLoansDetails(customerId);
		List<Cards> cards = cardsFeignClient.getCardDetails(customerId);

		CustomerDetails customerDetails = new CustomerDetails();
		customerDetails.setAccounts(accounts);
		customerDetails.setLoans(loans);
		customerDetails.setCards(cards);

		return customerDetails;

	}

	public CustomerDetails getCustomerDetailsFallback(Long customerId, Throwable t) {
		String message = t.getMessage();
		CustomerDetails customerDetails = new CustomerDetails();
		Accounts accounts = accountsRepo.findOneByCustomerId(customerId).orElse(null);
		if (!message.contains("loans/")) {
			List<Loans> loans = loansFeignClient.getLoansDetails(customerId);
			customerDetails.setLoans(loans);

		}
		if (!message.contains("cards/")) {
			List<Cards> cards = cardsFeignClient.getCardDetails(customerId);
			customerDetails.setCards(cards);
		}

		customerDetails.setAccounts(accounts);

		return customerDetails;

	}
}

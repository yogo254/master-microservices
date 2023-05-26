package com.zeraki.accounts.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.zeraki.accounts.config.AccountsConfig;
import com.zeraki.accounts.dto.AccountConfigDto;
import com.zeraki.accounts.model.Accounts;
import com.zeraki.accounts.repo.AccountsRepo;

@RestController
@RequestMapping("/account")
public class AccountsController {
	@Autowired
	private AccountsRepo accountsRepo;
	@Autowired
	private AccountsConfig accountsConfig;

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
}

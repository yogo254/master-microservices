package com.zeraki.accounts.client;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.zeraki.accounts.dto.Loans;



@FeignClient("loans")
public interface LoansFeignClient {

	@GetMapping("/loan")
	List<Loans> getLoansDetails(@RequestParam Long customerId);
}

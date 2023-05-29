package com.zeraki.accounts.client;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.zeraki.accounts.dto.Cards;



@FeignClient("cards")
public interface CardsFeignClient {

	@GetMapping("/card")
	List<Cards> getCardDetails(@RequestParam Long customerId);
}

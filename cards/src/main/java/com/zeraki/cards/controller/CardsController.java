package com.zeraki.cards.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.zeraki.cards.config.CardsConfig;
import com.zeraki.cards.dto.CardsConfigDto;
import com.zeraki.cards.model.Cards;
import com.zeraki.cards.repo.CardRepo;

@RestController
@RequestMapping("/card")
public class CardsController {
	@Autowired
	private CardRepo cardRepo;
	@Autowired
	private CardsConfig cardsConfig;

	@GetMapping
	public List<Cards> getCustomerCards(@RequestParam Long customerId) {
		return cardRepo.findByCustomerId(customerId);
	}

	@GetMapping("/config")
	public CardsConfigDto getAccountsConfig() {
		CardsConfigDto dto = new CardsConfigDto();
		dto.setActiveBranches(cardsConfig.getActiveBranches());
		dto.setBuildVersion(cardsConfig.getBuildVersion());
		dto.setMailDetails(cardsConfig.getMailDetails());
		dto.setMsg(cardsConfig.getMsg());
		return dto;
	}

}

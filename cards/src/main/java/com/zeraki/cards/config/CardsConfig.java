package com.zeraki.cards.config;

import java.util.List;
import java.util.Map;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Service;

import lombok.Data;

@Data
@Service
@ConfigurationProperties("cards")
public class CardsConfig {
	private String msg;
	private String buildVersion;
	private Map<String,String>mailDetails;
	private List<String>activeBranches;

	
}

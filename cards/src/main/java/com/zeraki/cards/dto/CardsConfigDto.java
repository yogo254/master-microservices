package com.zeraki.cards.dto;

import java.util.List;
import java.util.Map;

import lombok.Data;

@Data
public class CardsConfigDto {
	private String msg;
	private String buildVersion;
	private Map<String,String>mailDetails;
	private List<String>activeBranches;
	
}

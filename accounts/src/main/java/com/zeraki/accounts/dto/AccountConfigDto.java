package com.zeraki.accounts.dto;

import java.util.List;
import java.util.Map;

import lombok.Data;

@Data
public class AccountConfigDto {
	private String msg;
	private String buildVersion;
	private Map<String,String>mailDetails;
	private List<String>activeBranches;
	
}

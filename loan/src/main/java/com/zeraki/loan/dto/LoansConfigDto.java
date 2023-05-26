package com.zeraki.loan.dto;

import java.util.List;
import java.util.Map;

import lombok.Data;

@Data
public class LoansConfigDto {
	private String msg;
	private String buildVersion;
	private Map<String,String>mailDetails;
	private List<String>activeBranches;
	
}

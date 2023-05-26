package com.zeraki.loan.config;

import java.util.List;
import java.util.Map;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Service;

import lombok.Data;

@Data
@Service
@ConfigurationProperties("loans")
public class LoansConfig {
	private String msg;
	private String buildVersion;
	private Map<String,String>mailDetails;
	private List<String>activeBranches;

	
}

package com.wadia.service;

import com.wadia.metier.SalaryHrMetier;

public interface SalaryPerDateService {

	public SalaryHrMetier salaryPerDate(String username, Integer month, Integer year);
	
}

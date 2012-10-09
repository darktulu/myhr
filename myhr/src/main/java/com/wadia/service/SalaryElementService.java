package com.wadia.service;

import com.wadia.beans.ESalaryData;

public interface SalaryElementService {
	
	public ESalaryData findMargeSalary(String username, Integer month, Integer year);

}

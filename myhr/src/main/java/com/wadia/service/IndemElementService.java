package com.wadia.service;

import java.util.List;

import com.wadia.beans.EIndemnite;
import com.wadia.beans.ESalaryData;

public interface IndemElementService {
	
	public List<EIndemnite>  findMargeIndem(String username, Integer month, Integer year);

}

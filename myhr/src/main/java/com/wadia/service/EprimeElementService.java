package com.wadia.service;

import java.util.List;

import com.wadia.beans.EIndemnite;
import com.wadia.beans.EPrime;

public interface EprimeElementService {

	
	public List<EPrime> findMargePrime(String username, Integer month, Integer year);
}

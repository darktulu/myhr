package com.wadia.service;

import java.util.List;

import com.wadia.beans.EIndemnite;
import com.wadia.beans.Echarge;

public interface EchargeElementService {
	
	public List<Echarge>  findMargeCharge(String username, Integer month, Integer year);

}

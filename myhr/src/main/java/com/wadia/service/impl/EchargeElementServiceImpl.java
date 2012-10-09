package com.wadia.service.impl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.wadia.beans.EIndemnite;
import com.wadia.beans.Echarge;
import com.wadia.repos.EIndemniteRepos;
import com.wadia.repos.EchargeRepos;
import com.wadia.service.EchargeElementService;

@Service("echargeElementService")
@Transactional
public class EchargeElementServiceImpl implements EchargeElementService {
	
	@Inject
	private EchargeRepos echargeRepos;
	
	@Override
	public List<Echarge> findMargeCharge(String username, Integer month,
			Integer year) {
		
		List<Echarge> echargeList = new ArrayList<Echarge>();
		List<Echarge> echargeListToReturn = new ArrayList<Echarge>();
		
		int maxMonth = 0, maxYear = 0;
		
		echargeList = echargeRepos.findSameYearCharge(username, month, year);
		
		if (echargeList.size() == 0) { // if there is not same year
			echargeList = echargeRepos.findMargeYearCharge(username, year);
		}
		
            if(echargeList.size()!=0){
			
			maxYear = findYearMax(echargeList); // l'ans max
			maxMonth = findMonthMax(echargeRepos.findByYear(username, maxYear)); // les mois max des salaires qui ont le mois max
			echargeListToReturn = echargeRepos.findByYearAndMonth(username, maxMonth, maxYear);
										}
		
		return echargeListToReturn;
		
	}

	public Integer findYearMax(List<Echarge> echargeList) {

		List<Integer> years = new ArrayList<Integer>();

		for (Echarge charge : echargeList) {

			years.add(charge.getAns());
		}

		Integer max = Collections.max(years);
		return max;

	}

	public Integer findMonthMax(List<Echarge> echargeList) {

		List<Integer> years = new ArrayList<Integer>();

		for (Echarge charge : echargeList) {

			years.add(charge.getMois());
		}

		Integer max = Collections.max(years);
		return max;

	}

}


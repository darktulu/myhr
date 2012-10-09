package com.wadia.service.impl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.wadia.beans.EIndemnite;
import com.wadia.beans.ESalaryData;
import com.wadia.repos.EIndemniteRepos;
import com.wadia.service.IndemElementService;

@Service("indemElementService")
@Transactional
public class IndemElementServiceImpl implements IndemElementService {
    
	@Inject
	private EIndemniteRepos eIndemniteRepos;
	
	@Override
	public List<EIndemnite> findMargeIndem(String username, Integer month,
			Integer year) {
		
		
		List<EIndemnite> eIndemList = new ArrayList<EIndemnite>();
		List<EIndemnite> eIndemListToReturn = new ArrayList<EIndemnite>();
		
		int maxMonth = 0, maxYear = 0;
		
		eIndemList = eIndemniteRepos.findSameYearIndem(username, month, year);
		
		if (eIndemList.size() == 0) { // if there is not same year
			eIndemList = eIndemniteRepos.findMargeYearIndem(username, year);
		}
		
            if(eIndemList.size()!=0){
			
			maxYear = findYearMax(eIndemList); // l'ans max
			maxMonth = findMonthMax(eIndemniteRepos.findByYear(username, maxYear)); // les mois max des salaires qui ont le mois max
			eIndemListToReturn = eIndemniteRepos.findByYearAndMonth(username, maxMonth, maxYear);
										}
		
		return eIndemListToReturn;
	}
	
	
	public Integer findYearMax(List<EIndemnite> eIndemList) {

		List<Integer> years = new ArrayList<Integer>();

		for (EIndemnite indem : eIndemList) {

			years.add(indem.getAns());
		}

		Integer max = Collections.max(years);
		return max;

	}

	public Integer findMonthMax(List<EIndemnite> eIndemList) {

		List<Integer> years = new ArrayList<Integer>();

		for (EIndemnite indem : eIndemList) {

			years.add(indem.getMois());
		}

		Integer max = Collections.max(years);
		return max;

	}

}

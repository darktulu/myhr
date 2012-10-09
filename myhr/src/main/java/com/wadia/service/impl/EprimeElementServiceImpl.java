package com.wadia.service.impl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.wadia.beans.EIndemnite;
import com.wadia.beans.EPrime;
import com.wadia.repos.EIndemniteRepos;
import com.wadia.repos.EPrimeRepos;
import com.wadia.service.EprimeElementService;

@Service("eprimeElementService")
@Transactional
public class EprimeElementServiceImpl implements EprimeElementService {
    
	@Inject
	private EPrimeRepos ePrimeRepos;
	
	@Override
	public List<EPrime> findMargePrime(String username, Integer month,
			Integer year) {
		
		List<EPrime> eprimeList = new ArrayList<EPrime>();
		List<EPrime> eprimeListToReturn = new ArrayList<EPrime>();
		
		int maxMonth = 0, maxYear = 0;
		
		eprimeList = ePrimeRepos.findSameYearPrime(username, month, year);
		
		if (eprimeList.size() == 0) { // if there is not same year
			eprimeList = ePrimeRepos.findMargeYearPrime(username, year);
		}
		
            if(eprimeList.size()!=0){
			
			maxYear = findYearMax(eprimeList); // l'ans max
			maxMonth = findMonthMax(ePrimeRepos.findByYear(username, maxYear)); // les mois max des salaires qui ont le mois max
			eprimeListToReturn = ePrimeRepos.findByYearAndMonth(username, maxMonth, maxYear);
										}
		
		return eprimeListToReturn;
		
	}
	
	
	public Integer findYearMax(List<EPrime> ePrimeList) {

		List<Integer> years = new ArrayList<Integer>();

		for (EPrime eprime : ePrimeList) {

			years.add(eprime.getAns());
		}

		Integer max = Collections.max(years);
		return max;

	}

	public Integer findMonthMax(List<EPrime> ePrimeList) {

		List<Integer> years = new ArrayList<Integer>();

		for (EPrime eprime : ePrimeList) {

			years.add(eprime.getMois());
		}

		Integer max = Collections.max(years);
		return max;

	}
	

}

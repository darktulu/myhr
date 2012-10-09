package com.wadia.service.impl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.wadia.beans.ESalaryData;
import com.wadia.repos.ESalaryDataRepos;
import com.wadia.service.SalaryElementService;

@Service("salaryElementService")
@Transactional
public class SalaryElementServiceImpl implements SalaryElementService {

	@Inject
	private ESalaryDataRepos eSalaryDataRepos;

	@Override
	public ESalaryData findMargeSalary(String username, Integer month,
			Integer year) {

		List<ESalaryData> eSalaryList = new ArrayList<ESalaryData>();
		ESalaryData salaryToReturn = new ESalaryData();
        
		int maxMonth = 0, maxYear = 0;
		
		eSalaryList = eSalaryDataRepos.findSameYearSalary(username, month, year);

		if (eSalaryList.size() == 0) { // if there is not same year
			eSalaryList = eSalaryDataRepos.findMargeYearSalary(username, year);
		}
		
		// dans la list on cherche le plus grand salaire
		if(eSalaryList.size()!=0){
			
			maxYear = findYearMax(eSalaryList); // l'ans max
			maxMonth = findMonthMax(eSalaryDataRepos.findByYear(username, maxYear)); // les mois max des salaires qui ont le mois max
			salaryToReturn = eSalaryDataRepos.findByYearAndMonth(username, maxMonth, maxYear);
										}
		
		return salaryToReturn;
	}
	
	
	
	/******* Les methodes internes **************/
	

	public Integer findYearMax(List<ESalaryData> eSalaryList) {

		List<Integer> years = new ArrayList<Integer>();

		for (ESalaryData salary : eSalaryList) {

			years.add(salary.getAns());
		}

		Integer max = Collections.max(years);
		return max;

	}

	public Integer findMonthMax(List<ESalaryData> listSalary) {

		List<Integer> years = new ArrayList<Integer>();

		for (ESalaryData salary : listSalary) {

			years.add(salary.getMois());
		}

		Integer max = Collections.max(years);
		return max;

	}

}

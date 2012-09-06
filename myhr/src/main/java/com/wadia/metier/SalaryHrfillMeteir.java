/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wadia.metier;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.wadia.beans.EContractData;
import com.wadia.beans.EGeneralData;
import com.wadia.beans.ESalaryData;
import com.wadia.repos.EGeneralDataRepos;
import com.wadia.repos.ESalaryDataRepos;

/**
 * 
 * @author massin
 */
@Service
@Transactional
public class SalaryHrfillMeteir {

    @Inject
    private EGeneralDataRepos eGeneralDataRepos;   
    @Inject
    private ESalaryDataRepos eSalaryDataRepos;
    @Inject
    private SalaryMetier salaryMetier;
    @Inject
    private ChargeMetier chargeMetier;
    @Inject
    private SalaryListMetier salaryListMetier;
    @Inject
    private ContrathrfillMetier contrathrfillMetier = new ContrathrfillMetier();

    public List<SalaryHrMetier> listSalary() {

	List<ESalaryData> salaryDataList = new ArrayList();
	List<EGeneralData> eGenList = new ArrayList<EGeneralData>();
	List<SalaryHrMetier> hrMetiers = new ArrayList<SalaryHrMetier>();
	ESalaryData eSalaryData = new ESalaryData();
	

	eGenList = eGeneralDataRepos.findAll();

	for (EGeneralData employ : eGenList) {
	    SalaryHrMetier salaryHrMetier = new SalaryHrMetier();

	    salaryHrMetier.setName(employ.getName());
	    salaryHrMetier.setSurname(employ.getSurname());
	    salaryHrMetier.setUsername(employ.getResurceId());
	    salaryHrMetier.setEmployStatut(employ.getStatus());
	    salaryHrMetier.setJobeTitle(employ.getJobeTitle());
	    salaryHrMetier.setLadder(employ.getLadder());

	    EContractData contr = new EContractData();

	    contr = contrathrfillMetier.getLastContract(employ.getResurceId());

	    if (contr != null) {
		salaryHrMetier.setContractStartDate(contr.getContractStartDate());
		salaryHrMetier.setContractType(contr.getContractType());
		salaryHrMetier.setContractStatus(contr.getContractStatus());
	    }

	    salaryDataList = eSalaryDataRepos.findByUsername(employ.getResurceId());

	    eSalaryData = salaryMetier.getSalaireMoisCourant(salaryDataList, employ.getResurceId());
	    salaryHrMetier.setMonthlyBaeSalary(eSalaryData.getBaseSalary());
	    salaryHrMetier.setTotalAllowance(salaryMetier.getTotalAllowance(employ.getResurceId()));
	    salaryHrMetier.setTotalDeduction(chargeMetier.calculeCharge(employ.getResurceId()));
	    salaryHrMetier.setMonthlyNetSalary(salaryListMetier.calculeSalireNet(employ.getResurceId()));
	    salaryHrMetier.setSalaireImposable(salaryListMetier.calculeSalaireImposable(employ.getResurceId()));

	    /*
	     * 
	     * 
	     * 
	     * private Double salaireImposable;
	     */

	    hrMetiers.add(salaryHrMetier);
	}

	return hrMetiers;
    }

}

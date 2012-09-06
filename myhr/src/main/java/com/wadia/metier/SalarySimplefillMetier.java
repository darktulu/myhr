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
 * @author ITR2012
 */
@Service
@Transactional
public class SalarySimplefillMetier {

    @Inject
    private EGeneralDataRepos eGeneralDataRepos;
    @Inject
    private SalaryListMetier salaryListMetier;
    @Inject
    private ESalaryDataRepos eSalaryDataRepos;
    @Inject
    private ChargeMetier chargeMetier;
    @Inject
    private ContratMetier contratMetier;
    @Inject
    private SalaryMetier salaryMetier;

    public SalarySimpleMetier listSalary(String Username) {
	float anciente = 0;
	float totalAllowance = 0;
	Double totalDeduction = 0.0;
	Double salaireImposable;
	Double Ir;
	Double salaireNet = 0.0;

	EGeneralData eGeneralData = new EGeneralData();
	EContractData econtratData = new EContractData();
	ESalaryData eSalaryData = new ESalaryData();

	List<ESalaryData> eSalaryDatas = new ArrayList<ESalaryData>();
	SalarySimpleMetier SimpleSalaire = new SalarySimpleMetier();

	salaireImposable = salaryListMetier.calculeSalaireImposable(Username);
	totalAllowance = salaryMetier.getTotalAllowance(Username);
	totalDeduction = chargeMetier.calculeCharge(Username);
	Ir = salaryListMetier.calculeIrNet(Username);
	salaireNet = salaryListMetier.calculeSalireNet(Username);
	anciente = salaryMetier.anciente(Username);
	eSalaryDatas = eSalaryDataRepos.findByUsername(Username);
	eSalaryData = salaryMetier.getSalaireMoisCourant(eSalaryDatas, Username);

	eGeneralData = eGeneralDataRepos.findOne(Username);
	econtratData = contratMetier.getLastContrat(Username);
	SimpleSalaire.setMonthlyNetSalary((Math.floor(salaireNet * 100.0)) / 100);
	SimpleSalaire.setiR((Math.floor(Ir * 100.0)) / 100);
	SimpleSalaire.setName(eGeneralData.getName());
	SimpleSalaire.setSurname(eGeneralData.getSurname());
	SimpleSalaire.setContractStartDate(econtratData.getContractStartDate());
	SimpleSalaire.setContractStatus(econtratData.getContractStatus());
	SimpleSalaire.setGrade(eGeneralData.getGrade());
	SimpleSalaire.setJobeTitle(eGeneralData.getJobeTitle());
	SimpleSalaire.setSeniority(anciente);
	SimpleSalaire.setContractType(econtratData.getContractType());
	SimpleSalaire.setMonthlyBaeSalary(eSalaryData.getBaseSalary());
	SimpleSalaire.setTotalAllowance(totalAllowance);
	SimpleSalaire.setTotalDeduction((Math.floor(totalDeduction * 100.0)) / 100);
	SimpleSalaire.setSalaireImposable((Math.floor(salaireImposable * 100.0)) / 100);
	return SimpleSalaire;
    }

}

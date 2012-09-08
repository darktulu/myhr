/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wadia.metier;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.wadia.beans.EContractData;
import com.wadia.beans.EIndemnite;
import com.wadia.beans.EPrime;
import com.wadia.beans.ESalaryData;
import com.wadia.beans.Echarge;
import com.wadia.repos.EContractDataRepos;
import com.wadia.repos.EIndemniteRepos;
import com.wadia.repos.EPrimeRepos;
import com.wadia.repos.ESalaryDataRepos;
import com.wadia.repos.EchargeRepos;

/**
 * 
 * @author toshiba
 */
@Service
@Transactional
public class SalaryMetier {

    @Inject
    private EchargeRepos echargeRepos;

    @Inject
    private EIndemniteRepos eIndemniteRepos;

    @Inject
    private EPrimeRepos ePrimeRepos;

    @Inject
    private ESalaryDataRepos eSalaryDataRepos;

    @Inject
    private ContratMetier contratMetier;
    @Inject
    private EindemMetier eindemMetier;
    @Inject
    private EPrimeMetier ePrimeMetier;
    @Inject
    private ChildMetier childMetier;
    @Inject
    private EContractDataRepos eContractDataRepos;
    @Inject
    private SpouseListMetier spouseListMetier;

    public int personnesPrisEnCharge(String username) {

	int nbPersonnes;

	nbPersonnes = childMetier.countChilds(username).size() + spouseListMetier.findSpouseByUsername(username).size();

	if (nbPersonnes <= 5) {
	    return nbPersonnes;
	} else {
	    return 5;
	}

    }

    public int countPersonnesPrisEnCharge(String username) {
	
	int nbPersonnes = childMetier.countPersonnePrisEnCharge(username);
	return (nbPersonnes <= 5) ? nbPersonnes : 5;
    }

    public float anciente(String username) {

	Date start;
	int years;
	float anciente = 0;
	Calendar rightNow = Calendar.getInstance();
	EContractData contrat = eContractDataRepos.findLastOngoingCDI(username);
	if (contrat == null)
	    return 0;
	start = contrat.getContractStartDate();
	if (start != null) {
	    years = (int) (dateDifferencePerDay(start, rightNow) / 365);

	    if (years < 2) {
		anciente = 0;
	    } else if (years >= 2 && years < 5) {
		anciente = 5;
	    } else if (years >= 5 && years < 12) {
		anciente = 10;
	    } else if (years >= 12 && years < 20) {
		anciente = 15;
	    } else if (years >= 20 && years < 25) {
		anciente = 20;
	    } else if (years >= 25) {
		anciente = 25;
	    }
	} else {
	    anciente = 0;
	}
	return anciente;
    }

    public long dateDifferencePerDay(Date start, Calendar end) {

	long CONST_DURATION_OF_DAY = 1000l * 60 * 60 * 24;
	long diff = Math.abs(start.getTime() - end.getTimeInMillis());

	long numberOfDay = (long) diff / CONST_DURATION_OF_DAY;

	return numberOfDay;

    }

    /*
     * public List<ESalaryData> findByUsername(String Username) {
     * 
     * List<ESalaryData> salaryDataList = new ArrayList(); List<ESalaryData>
     * esalaryList = new ArrayList(); ESalaryDataDao salaryDataDaoS = new
     * ESalaryDataDao(); esalaryList = salaryDataDaoS.findAll();
     * 
     * for (ESalaryData sala : esalaryList) { if
     * (sala.getResurceId().equals(Username)) { salaryDataList.add(sala); } }
     * return salaryDataList; }
     */

    public ESalaryData getSalaireMoisCourant(List<ESalaryData> listSalaire, String username) {
	int mois = 0;
	int ans = 0;
	ESalaryData eSalaryDatas = new ESalaryData();
	for (ESalaryData salar : listSalaire) {
	    if (eSalaryDataRepos.findByMoisMax(username) != null) {
		mois = eSalaryDataRepos.findByMoisMax(username).intValue();
	    }
	    if (eSalaryDataRepos.findByAnsMax(username) != null) {
		ans = eSalaryDataRepos.findByAnsMax(username).intValue();
	    }

	    if ((salar.getMois() == mois) && (salar.getAns() == ans)) {
		eSalaryDatas = salar;
	    }

	}
	return eSalaryDatas;
    }

    public float getTotalAllowance(String username) {
	float totalAllowance = 0;
	float totalIndem = 0;
	float totalPrim = 0;

	List<EIndemnite> listIndem = new ArrayList<EIndemnite>();
	List<EPrime> listPrime = new ArrayList<EPrime>();
	listIndem = eIndemniteRepos.findLastEIndemnite(username);
	totalIndem = eindemMetier.getTotalIndem(listIndem);
	listPrime = ePrimeRepos.findLastEPrime(username);
	totalPrim = ePrimeMetier.getTotalPrim(listPrime);
	totalAllowance = totalPrim + totalIndem;
	return totalAllowance;
    }

    public void saveSalary(ESalaryData salaryData, List<EIndemnite> eIndemnites, List<EPrime> ePrimes,
	    List<Echarge> charges) {
	for (EIndemnite indem : eIndemnites) {
	    if (indem != null)
		eIndemniteRepos.save(indem);
	}
	for (EPrime prime : ePrimes) {
	    if (prime != null)
		ePrimeRepos.save(prime);
	}
	for (Echarge charge : charges) {
	    if (charge != null)
		echargeRepos.save(charge);
	}
	if (salaryData != null)
	    eSalaryDataRepos.save(salaryData);
    }
}

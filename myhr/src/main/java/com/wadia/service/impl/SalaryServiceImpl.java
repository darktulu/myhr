package com.wadia.service.impl;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.inject.Inject;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.wadia.beans.Child;
import com.wadia.beans.EContractData;
import com.wadia.beans.EGeneralData;
import com.wadia.beans.EIndemnite;
import com.wadia.beans.EPrime;
import com.wadia.beans.ESalaryData;
import com.wadia.beans.ESpouse;
import com.wadia.beans.Echarge;
import com.wadia.beans.SalaryCharge;
import com.wadia.metier.ChargeMetier;
import com.wadia.metier.ContrathrfillMetier;
import com.wadia.metier.SalaryHrMetier;
import com.wadia.metier.SalaryListMetier;
import com.wadia.metier.SalaryMetier;
import com.wadia.repos.ChargeRepos;
import com.wadia.repos.ChildRepos;
import com.wadia.repos.EContractDataRepos;
import com.wadia.repos.EGeneralDataRepos;
import com.wadia.repos.EIndemniteRepos;
import com.wadia.repos.EPrimeRepos;
import com.wadia.repos.ESalaryDataRepos;
import com.wadia.repos.ESpouseRepos;
import com.wadia.repos.EchargeRepos;
import com.wadia.service.SalaryService;

@Service("salaryService")
@Transactional
public class SalaryServiceImpl implements SalaryService {

    @Inject
    private EGeneralDataRepos eGeneralDataRepos;
    @Inject
    private ESalaryDataRepos eSalaryDataRepos;
    @Inject
    private EContractDataRepos contractDataRepos;
    @Inject
    private ChargeRepos chargeRepos;
    @Inject
    private EchargeRepos echargeRepos;
    @Inject
    private EPrimeRepos ePrimeRepos;
    @Inject
    private EIndemniteRepos eIndemniteRepos;
    @Inject
    private ChildRepos childRepos;
    @Inject
    private ESpouseRepos espouseRepos;

    @Override
    @Cacheable("salaryHR")
    public List<SalaryHrMetier> listSalary() {

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

	    EContractData contr = contractDataRepos.findLastContract(employ.getResurceId());

	    if (contr != null) {
		salaryHrMetier.setContractStartDate(contr.getContractStartDate());
		salaryHrMetier.setContractType(contr.getContractType());
		salaryHrMetier.setContractStatus(contr.getContractStatus());
	    }

	    eSalaryData = eSalaryDataRepos.findLastSalary(employ.getResurceId());
	    if (eSalaryData == null)
		continue;
	    salaryHrMetier.setMonthlyBaeSalary(eSalaryData.getBaseSalary());
	    salaryHrMetier.setTotalAllowance(getTotalAllowance(employ.getResurceId()));
	    salaryHrMetier.setTotalDeduction(calculeCharge(employ.getResurceId()));
	    salaryHrMetier.setMonthlyNetSalary(calculeSalaireNet(employ.getResurceId()));
	    salaryHrMetier.setSalaireImposable(calculeSalaireImposable(employ.getResurceId()));

	    hrMetiers.add(salaryHrMetier);
	}

	return hrMetiers;
    }

    public void calculateIndemnite() {

    }

    public float getTotalAllowance(String username) {
	float totalAllowance = 0;
	float totalIndem = 0;
	float totalPrim = 0;

	List<EIndemnite> listIndem = new ArrayList<EIndemnite>();
	List<EPrime> listPrime = new ArrayList<EPrime>();
	listIndem = eIndemniteRepos.findLastEIndemnite(username);
	totalIndem = getTotalIndem(listIndem);
	listPrime = ePrimeRepos.findLastEPrime(username);
	totalPrim = getTotalPrim(listPrime);
	totalAllowance = totalPrim + totalIndem;
	return totalAllowance;
    }

    public Double calculeCharge(String username) {
	Double totalCharge = 0.0;
	Double SalaireBase = 0.0;

	SalaireBase = calculeSalaireImposable(username);

	SalaryCharge charges = new SalaryCharge();
	List<Echarge> listCharge = new ArrayList<Echarge>();
	listCharge = echargeRepos.findLastEcharge(username);//TODO a voir
	for (Echarge charge : listCharge) {
	    charges = chargeRepos.findByNomCharge(charge.getNom());
	    if (SalaireBase <= 6000) {
		totalCharge += (charges.getTax() * SalaireBase) / 100;
	    }
	    if (SalaireBase > 6000) {// TODO BUG
		totalCharge = 257.40 + (2 * SalaireBase) / 100;
	    }
	}
	return totalCharge;
    }

    public float getTotalPrim(List<EPrime> listPrim) {
	float totalPrim = 0;
	if (listPrim != null) {
	    for (EPrime prim : listPrim) {
		totalPrim += prim.getMontant();
	    }
	}
	return totalPrim;
    }

    public float getTotalIndem(List<EIndemnite> listIndem) {
	float totalIndem = 0;
	if (listIndem != null) {
	    for (EIndemnite idem : listIndem) {
		totalIndem += idem.getMontant();
	    }
	}
	return totalIndem;
    }

    public Double calculeSalaireNet(String username) {
	double salaireNet = 0.0;
	double salaireBase = 0.0;

	salaireBase = calculeSalaireImposable(username);
	salaireNet = getTotalAllowance(username) + salaireBase - calculeCharge(username) - calculeIrNet(username);
	return salaireNet;
    }

    public Double calculeSalaireImposable(String username) {
	double sailreImposable = 0.0;
	double SalaireBase = 0.0;
	float anciente = 0;

	ESalaryData eSalaryData = eSalaryDataRepos.findLastSalary(username);
	anciente = anciente(username);

	if (eSalaryData == null)
	    return 0.0;
	SalaireBase = eSalaryData.getBaseSalary();

	sailreImposable = SalaireBase + (anciente * SalaireBase / 100);

	return sailreImposable;
    }

    public Double CalculeBaseIR(String Username) {
	Double baseIr = 0.0;
	Double sailreImposable = 0.0;
	sailreImposable = calculeSalaireImposable(Username);
	baseIr = sailreImposable - (calculeCharge(Username)) - Math.min(0.2 * sailreImposable, 2500);

	return baseIr;
    }

    public Double calculeIr(String Username) {
	Double retenuIr = 0.0;
	Double baseIr;
	Double iR;
	baseIr = CalculeBaseIR(Username);
	if (baseIr <= 2500) {
	    iR = 0.0;
	    retenuIr = 0.0;
	}
	if ((baseIr >= 2500) && (baseIr <= 4166.66)) {
	    iR = 250.00;
	    retenuIr = (baseIr * 10 / 100) - iR;
	}
	if ((baseIr >= 4166.67) && (baseIr <= 5000.00)) {
	    iR = 666.66;
	    retenuIr = (baseIr * 20 / 100) - iR;
	}
	if ((baseIr >= 5000.08) && (baseIr <= 6666.66)) {
	    iR = 1166.66;
	    retenuIr = (baseIr * 30 / 100) - iR;
	}
	if ((baseIr >= 6666.75) && (baseIr <= 15000.00)) {
	    iR = 1433.33;
	    retenuIr = (baseIr * 34 / 100) - iR;
	}
	if (baseIr >= 15000.00) {
	    iR = 2033.33;
	    retenuIr = (baseIr * 38 / 100) - iR;
	}

	return (retenuIr);
    }

    public Double calculeIrNet(String Username) {

	int nbPersonnes = countPersonnesPrisEnCharge(Username);
	double retenuIrNet = calculeIr(Username) - nbPersonnes * 30;

	return (retenuIrNet > 0) ? retenuIrNet : 0.0;
    }

    public int countPersonnesPrisEnCharge(String username) {

	int nbPersonnes = countPersonnePrisEnCharge(username);
	return (nbPersonnes <= 5) ? nbPersonnes : 5;
    }

    public int countPersonnePrisEnCharge(String username) {
	int result = 0;
	List<Child> listChild;

	List<ESpouse> listSpouse = espouseRepos.findByResurceId(username);
	if (listSpouse == null)
	    return 0;
	for (ESpouse spouse : listSpouse) {
	    listChild = childRepos.findBySpouseId(spouse.getSpouseId());
	    if (listChild != null)
		result += listChild.size();
	}
	return listSpouse.size() + result;
    }

    public float anciente(String username) {

	Date start;
	int years;
	float anciente = 0;
	Calendar rightNow = Calendar.getInstance();
	EContractData contrat = contractDataRepos.findLastOngoingCDI(username);
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
}

package com.wadia.service.impl;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.inject.Inject;

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
import com.wadia.metier.SalaryHrMetier;
import com.wadia.repos.ChargeRepos;
import com.wadia.repos.ChildRepos;
import com.wadia.repos.EContractDataRepos;
import com.wadia.repos.EGeneralDataRepos;
import com.wadia.repos.ESpouseRepos;
import com.wadia.service.EchargeElementService;
import com.wadia.service.EprimeElementService;
import com.wadia.service.IndemElementService;
import com.wadia.service.SalaryElementService;
import com.wadia.service.SalaryPerDateService;

@Service("salaryPerDateService")
@Transactional
public class SalaryPerDateServiceImpl implements SalaryPerDateService {

	@Inject
	private EGeneralDataRepos eGeneralDataRepos;
	@Inject
	private EContractDataRepos contractDataRepos;
	@Inject
	private ChargeRepos chargeRepos;
	@Inject
	private ChildRepos childRepos;
	@Inject
	private ESpouseRepos espouseRepos;
	@Inject
	private EchargeElementService echargeElementService;
	@Inject
	private EprimeElementService eprimeElementService;
	@Inject
	private IndemElementService indemElementService;
	@Inject
	private SalaryElementService salaryElementService;

	@Override
	public SalaryHrMetier salaryPerDate(String username, Integer month,
			Integer year) {

		SalaryHrMetier salaryHrMetier = new SalaryHrMetier();
		ESalaryData eSalaryData = new ESalaryData();

		EGeneralData employ = new EGeneralData();
		employ = eGeneralDataRepos.findOne(username);
		salaryHrMetier.setName(employ.getName());
		salaryHrMetier.setSurname(employ.getSurname());
		salaryHrMetier.setUsername(employ.getResurceId());
		salaryHrMetier.setEmployStatut(employ.getStatus());
		salaryHrMetier.setJobeTitle(employ.getJobeTitle());
		salaryHrMetier.setLadder(employ.getLadder());

		eSalaryData = salaryElementService.findMargeSalary(username, month, year);

		if (eSalaryData.getAns() != 0) {

			salaryHrMetier.setMonthlyBaeSalary(eSalaryData.getBaseSalary());
			salaryHrMetier.setTotalAllowance(getTotalAllowance(username, month,
					year));
			salaryHrMetier.setTotalDeduction(calculeCharge(username, month,
					year));
			salaryHrMetier.setMonthlyNetSalary(calculeSalaireNet(username,
					month, year));
			salaryHrMetier.setSalaireImposable(calculeSalaireImposable(
					username, month, year));

		}

		return salaryHrMetier;
	}

	/************************************************************************************************************************/
	/********************************************** Other Elements of Calcul **************************************************/
	/************************************************************************************************************************/

	public float getTotalAllowance(String username, Integer month, Integer year) {
		float totalAllowance = 0;
		float totalIndem = 0;
		float totalPrim = 0;

		List<EIndemnite> listIndem = new ArrayList<EIndemnite>();
		List<EPrime> listPrime = new ArrayList<EPrime>();

		listIndem = indemElementService.findMargeIndem(username, month, year); // TODO
		totalIndem = getTotalIndem(listIndem);

		listPrime = eprimeElementService.findMargePrime(username, month, year);
		totalPrim = getTotalPrim(listPrime);

		totalAllowance = totalPrim + totalIndem;

		return totalAllowance;
	}

	public Double calculeCharge(String username, Integer month, Integer year) {
		Double totalCharge = 0.0;
		Double SalaireBase = 0.0;

		SalaireBase = calculeSalaireImposable(username, month, year);

		SalaryCharge charges = new SalaryCharge();
		List<Echarge> listCharge = new ArrayList<Echarge>();
		listCharge = echargeElementService.findMargeCharge(username, month,
				year); // TODO a voir
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

	public Double calculeSalaireNet(String username, Integer month, Integer year) {
		double salaireNet = 0.0;
		double salaireBase = 0.0;

		salaireBase = calculeSalaireImposable(username, month, year);
		salaireNet = getTotalAllowance(username, month, year) + salaireBase
				- calculeCharge(username, month, year)
				- calculeIrNet(username, month, year);
		return salaireNet;
	}

	public Double calculeSalaireImposable(String username, Integer month,
			Integer year) {
		double sailreImposable = 0.0;
		double SalaireBase = 0.0;
		float anciente = 0;

		ESalaryData eSalaryData = salaryElementService.findMargeSalary(
				username, month, year);
		anciente = anciente(username);

		if (eSalaryData == null)
			return 0.0;
		SalaireBase = eSalaryData.getBaseSalary();

		sailreImposable = SalaireBase + (anciente * SalaireBase / 100);

		return sailreImposable;
	}

	public Double CalculeBaseIR(String username, Integer month, Integer year) {
		Double baseIr = 0.0;
		Double sailreImposable = 0.0;
		sailreImposable = calculeSalaireImposable(username, month, year);
		baseIr = sailreImposable - (calculeCharge(username, month, year))
				- Math.min(0.2 * sailreImposable, 2500);

		return baseIr;
	}

	public Double calculeIrNet(String username, Integer month, Integer year) {

		int nbPersonnes = countPersonnesPrisEnCharge(username);
		double retenuIrNet = calculeIr(username, month, year) - nbPersonnes
				* 30;

		return (retenuIrNet > 0) ? retenuIrNet : 0.0;
	}

	public int countPersonnesPrisEnCharge(String username) {

		int nbPersonnes = countPersonnePrisEnCharge(username);
		return (nbPersonnes <= 5) ? nbPersonnes : 5;
	}

	public Double calculeIr(String username, Integer month, Integer year) {
		Double retenuIr = 0.0;
		Double baseIr;
		Double iR;
		baseIr = CalculeBaseIR(username, month, year);

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

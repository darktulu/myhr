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

import com.wadia.beans.Echarge;
import com.wadia.beans.SalaryCharge;
import com.wadia.repos.ChargeRepos;
import com.wadia.repos.EchargeRepos;

/**
 * 
 * @author wadi3
 */
@Service
@Transactional
public class ChargeMetier {

    @Inject
    private ChargeRepos chargeRepos;

    @Inject
    private EchargeRepos echargeRepos;

    @Inject
    SalaryListMetier salaryListMetier;

    public SalaryCharge findByName(String name) {

	List<SalaryCharge> list = new ArrayList<SalaryCharge>();
	SalaryCharge chargeToReturn = new SalaryCharge();
	list = chargeRepos.findAll();

	for (SalaryCharge charge : list) {

	    if (charge.getNomCharge().equals(name)) {
		chargeToReturn = charge;
	    }
	}

	return chargeToReturn;

    }

    public boolean ChargeKO(SalaryCharge Scharge) {

	boolean x = false;
	List<SalaryCharge> list = new ArrayList<SalaryCharge>();
	list = chargeRepos.findAll();

	for (SalaryCharge charge : list) {

	    if (charge.getNomCharge().equals(Scharge.getNomCharge())) {
		x = false;
	    } else {
		x = true;
	    }

	}
	return x;

    }

    public List<Echarge> getChargeByUsername(String Username, int mois, int ans) {
	List<Echarge> listCharge = new ArrayList<Echarge>();
	List<Echarge> listToReturn = new ArrayList<Echarge>();
	listCharge = echargeRepos.findAll();
	for (Echarge charg : listCharge) {
	    if ((charg.getResourceId().equals(Username)) && (charg.getMois() == mois) && (charg.getAns() == ans)) {
		listToReturn.add(charg);
	    }
	}

	return listToReturn;

    }

    public List<Echarge> getChargeByUsername(String Username) {
	List<Echarge> listCharge = new ArrayList<Echarge>();
	List<Echarge> listToReturn = new ArrayList<Echarge>();
	listCharge = echargeRepos.findAll();
	for (Echarge charg : listCharge) {
	    if ((charg.getResourceId().equals(Username))) {
		listToReturn.add(charg);
	    }
	}

	return listToReturn;

    }

    public Double calculeCharge(String username) {
	Double totalCharge = 0.0;
	Double SalaireBase = 0.0;

	SalaireBase = salaryListMetier.calculeSalaireImposable(username);
	
	SalaryCharge charges = new SalaryCharge();
	List<Echarge> listCharge = new ArrayList<Echarge>();
	listCharge = echargeRepos.findLastEcharge(username);
	for (Echarge charge : listCharge) {
	    charges = chargeRepos.findByNomCharge(charge.getNom());
	    if (SalaireBase <= 6000) {
		totalCharge += (charges.getTax() * SalaireBase) / 100;
	    }
	    if (SalaireBase > 6000) {//TODO BUG
		totalCharge = 257.40 + (2 * SalaireBase) / 100;
	    }
	}
	return totalCharge;
    }

}

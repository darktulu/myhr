/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wadia.metier;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.wadia.beans.EContractData;
import com.wadia.repos.EContractDataRepos;

/**
 * 
 * @author toshiba
 */
@Service
@Transactional
public class ContratMetier {

    @Inject
    private EContractDataRepos eContractDataRepos;

    public Date lastContract(String username) {

	List<EContractData> listContrat = new ArrayList<EContractData>();
	Date lastDate = null;
	// HashSet<Date> listDates = new HashSet<Date>();
	listContrat = eContractDataRepos.findByResurceId(username);

	for (EContractData contrat : listContrat) {

	    if (contrat.getContractType().equals("CDI") && contrat.getContractStatus().equals("Ongoing")) {
		lastDate = contrat.getContractStartDate();
	    }

	}
	return lastDate;
    }

    public List<EContractData> findByUsername(String username) {
	List<EContractData> listContrat = new ArrayList<EContractData>();
	List<EContractData> listContratToReturn = new ArrayList<EContractData>();
	listContrat = eContractDataRepos.findAll();
	for (EContractData con : listContrat) {

	    if (con.getResurceId().equals(username)) {

		listContratToReturn.add(con);
	    }

	}

	return listContratToReturn;
    }

    public String embauche(String username) {
	String embauche;
	List<EContractData> listContrat = new ArrayList<EContractData>();
	Date lastDate = null;
	// HashSet<Date> listDates = new HashSet<Date>();
	listContrat = eContractDataRepos.findAll();

	for (EContractData contrat : listContrat) {

	    if (contrat.getContractStatus() != null) {
		if (contrat.getContractStatus().equals("Ongoing") && contrat.getResurceId().equals(username)) {
		    lastDate = contrat.getContractStartDate();
		}
	    }

	}
	if (lastDate != null) {
	    embauche = "" + lastDate;
	} else {

	    embauche = "0000-00-00";

	}

	return embauche;
    }

    public EContractData getLastContrat(String username) {

	List<EContractData> listContrat = new ArrayList<EContractData>();
	listContrat = eContractDataRepos.findAll();
	EContractData contratToReturn = new EContractData();

	for (EContractData contrat : listContrat) {

	    if (contrat.getContractStatus().equals("Ongoing") && contrat.getResurceId().equals(username)) {
		contratToReturn = contrat;
	    }

	}
	return contratToReturn;
    }

    public List<EContractData> contratHistory(String username) {

	List<EContractData> listContrat = new ArrayList<EContractData>();
	List<EContractData> listContratToReturn = new ArrayList<EContractData>();

	listContrat = eContractDataRepos.findAll();

	for (EContractData contrat : listContrat) {

	    if (contrat.getResurceId().equals(username)) {

		listContratToReturn.add(contrat);

	    }
	}

	return listContratToReturn;

    }

}

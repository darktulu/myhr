/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wadia.metier;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.wadia.beans.EContractData;
import com.wadia.beans.EGeneralData;
import com.wadia.repos.EContractDataRepos;
import com.wadia.repos.EGeneralDataRepos;

/**
 * 
 * @author ITR2012
 */
@Service
@Transactional
public class ContrathrfillMetier {

    @Inject
    private EGeneralDataRepos eGeneralDataRepos;

    @Inject
    private EContractDataRepos eContractDataRepos;

    public List<ContrathrMetier> listContr() {

	List<EGeneralData> eGenList = new ArrayList<EGeneralData>();
	List<ContrathrMetier> ContratHr = new ArrayList<ContrathrMetier>();
	List<EContractData> econtratData = new ArrayList<EContractData>();
	List<EContractData> econtrat = new ArrayList<EContractData>();

	eGenList = eGeneralDataRepos.findAll();
	econtratData = eContractDataRepos.findAll();
	econtrat = getContrEncour(econtratData);

	for (EGeneralData employ : eGenList) {

	    ContrathrMetier cont = new ContrathrMetier();
	    cont.setName(employ.getName());
	    cont.setSurname(employ.getSurname());
	    cont.setUsername(employ.getResurceId());
	    cont.setEmployStatut(employ.getStatus());

	    EContractData contr = new EContractData();

	    contr = getLastContract(employ.getResurceId());
	    cont.setContractId(contr.getContratId());
	    cont.setContratStratDate(contr.getContractStartDate());
	    cont.setContratEndDate(contr.getContractEndDate());
	    cont.setContratType(contr.getContractType());
	    cont.setContratStatut(contr.getContractStatus());

	    ContratHr.add(cont);
	}
	return ContratHr;
    }

    public List<EContractData> getContrEncour(List<EContractData> list) {
	List<EContractData> ListToReutrn = new ArrayList<EContractData>();

	for (EContractData contra : list) {
	    if ("Ongoing".equals(contra.getContractStatus())) {
		ListToReutrn.add(contra);
	    }

	}

	return ListToReutrn;
    }

    public EContractData getLastContract(String username) {

	List<EContractData> listContract = new ArrayList<EContractData>();
	List<EContractData> listTranscientContract = new ArrayList<EContractData>();
	EContractData contractReutrn = new EContractData();

	listContract = eContractDataRepos.findByResurceId(username);
	boolean var = true;
	for (EContractData contract : listContract) {
	    if (contract.getContractStatus().equals("Ongoing")) {
		contractReutrn = contract;
		var = false;
	    } else if (contract.getContractStatus().equals("EXPIRED") || contract.getContractStatus().equals("ENDED")) {
		listTranscientContract.add(contract);
	    }
	}

	if (listTranscientContract.size() != 0 && var) {

	    boolean lock;
	    // System.out.print(listTranscientContract.size());
	    for (EContractData contract : listTranscientContract) {
		// System.out.println("ddd");
		lock = true;
		// System.out.println("o" + listTranscientContract.size());

		for (EContractData contract2 : listTranscientContract) {

		    if (contract.getContractEndDate() != null && contract2.getContractEndDate() != null) {

			if (contract.getContractEndDate().before(contract2.getContractEndDate())) {
			    lock = false;
			}
		    }
		}

		if (lock) {
		    contractReutrn = contract;
		}
	    }
	}

	return contractReutrn;

    }

    public void updateStatus(List<ContrathrMetier> list) {

	for (ContrathrMetier contrat : list) {

	    if (contrat.getContratEndDate() != null) {

		Calendar rightNow = Calendar.getInstance();
		long now;
		now = rightNow.getTimeInMillis();
		// System.out.println("date" + now);

		if (contrat.getContratEndDate().getTime() < now) {

		    EGeneralData egd = new EGeneralData();
		    egd = eGeneralDataRepos.findOne(contrat.getUsername());
		    egd.setStatus("ENDED");
		    eGeneralDataRepos.save(egd);
		    EContractData eContractData = new EContractData();

		    if (contrat.getContratType().equals("CDD")) {
			// eContractDataRepos.setStatus("EXPIRED",
			// contrat.getContractId());
			eContractData = eContractDataRepos.findOne(contrat.getContractId());
			eContractData.setContractStatus("EXPIRED");
			eContractDataRepos.save(eContractData);

		    }

		    if (contrat.getContratType().equals("CDI")) {
			eContractData = eContractDataRepos.findOne(contrat.getContractId());
			eContractData.setContractStatus("ENDED");
			eContractDataRepos.save(eContractData);
		    }

		}

		if (contrat.getContratEndDate().getTime() > now) {

		    EGeneralData egd = new EGeneralData();
		    egd = eGeneralDataRepos.findOne(contrat.getUsername());
		    egd.setStatus("ACTIVE");
		    eGeneralDataRepos.save(egd);

		    EContractData eContractData = new EContractData();
		    eContractData = eContractDataRepos.findOne(contrat.getContractId());
		    eContractData.setContractStatus("Ongoing");
		    eContractDataRepos.save(eContractData);
		}

	    }

	    if (contrat.getContratEndDate() == null && contrat.getContratType() != null) {

		if (!contrat.getContratType().equals("CDI")) {

		    EGeneralData egd = new EGeneralData();
		    egd = eGeneralDataRepos.findOne(contrat.getUsername());
		    egd.setStatus("ENDED");
		    eGeneralDataRepos.save(egd);

		    EContractData eContractData = new EContractData();
		    eContractData = eContractDataRepos.findOne(contrat.getContractId());
		    eContractData.setContractStatus("wrong data");
		    eContractDataRepos.save(eContractData);

		}

		if (contrat.getContratType().equals("CDI")) {

		    EGeneralData egd = new EGeneralData();
		    egd = eGeneralDataRepos.findOne(contrat.getUsername());
		    egd.setStatus("ACTIVE");
		    eGeneralDataRepos.save(egd);

		    EContractData eContractData = new EContractData();
		    eContractData = eContractDataRepos.findOne(contrat.getContractId());
		    eContractData.setContractStatus("Ongoing");
		    eContractDataRepos.save(eContractData);
		}

	    }

	    if (contrat.getContratType() == null) {

		EGeneralData egd = new EGeneralData();
		egd = eGeneralDataRepos.findOne(contrat.getUsername());
		egd.setStatus("ENDED");
		eGeneralDataRepos.save(egd);

	    }

	}

    }
}

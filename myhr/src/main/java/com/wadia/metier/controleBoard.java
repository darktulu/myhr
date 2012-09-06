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
import com.wadia.repos.EContractDataRepos;
import com.wadia.repos.EGeneralDataRepos;

/**
 * 
 * @author toshiba
 */
@Service
@Transactional
public class controleBoard {
    @Inject
    private EGeneralDataRepos eGeneralDataRepos;
    @Inject
    private EContractDataRepos eContractDataRepos;

    public void updateStatus() {

	List<EGeneralData> list = new ArrayList<EGeneralData>();
	list = eGeneralDataRepos.findAll();

	for (EGeneralData egen : list) {

	    if (egen.getStatus().equals("Active")) {

		egen.setStatus("ACTIVE");
		eGeneralDataRepos.save(egen);

	    }

	    if (egen.getStatus().equals("Desactived")) {

		egen.setStatus("ENDED");
		eGeneralDataRepos.save(egen);

	    }

	}

    }

    public void updateContracts() {

	List<EContractData> list = new ArrayList<EContractData>();
	list = eContractDataRepos.findAll();

	for (EContractData contract : list) {

	    if (contract.getContractType().equals("CDI")) {

		if (contract.getContractStatus().equals("ENCOUR")) {

		    contract.setContractStatus("Ongoing");
		    eContractDataRepos.save(contract);

		}

		if (contract.getContractStatus().equals("EXPIRED")) {

		    contract.setContractStatus("ENDED");
		    eContractDataRepos.save(contract);

		}

	    }

	    if (contract.getContractType().equals("CDD")) {

		if (contract.getContractStatus().equals("ENCOUR")) {

		    contract.setContractStatus("Ongoing");
		    eContractDataRepos.save(contract);

		}

		if (contract.getContractStatus().equals("EXPIRED")) {

		    contract.setContractStatus("Expired");
		    eContractDataRepos.save(contract);

		}

	    }

	}

    }

}

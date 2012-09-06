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

import com.wadia.beans.EFunctionalData;
import com.wadia.beans.EGeneralData;
import com.wadia.beans.ELData;
import com.wadia.repos.EFunctionalDataRepos;
import com.wadia.repos.EGeneralDataRepos;
import com.wadia.repos.ELDataRepos;

/**
 * 
 * @author toshiba
 */
@Service
@Transactional
public class myTeamMetier {
    @Inject
    private EGeneralDataRepos eGeneralDataRepos;
    @Inject
    private EFunctionalDataRepos dataDao;

    @Inject
    private ELDataRepos elDataRepos;

    private List<EGeneralData> listEg = new ArrayList<EGeneralData>();
    private List<EFunctionalData> listEF = new ArrayList<EFunctionalData>();
    private List<ELData> listLeaves = new ArrayList<ELData>();

    public List<EGeneralData> getMyTeam(String username) {

	listEg = eGeneralDataRepos.findAll();
	// listEF = dataDao.findAll();
	List<EGeneralData> listEgToRetun = new ArrayList<EGeneralData>();

	for (EGeneralData eGeneralData : listEg) {

	    EFunctionalData data = new EFunctionalData();
	    data = dataDao.findOne(eGeneralData.getEfId());
	    EGeneralData dataG = new EGeneralData();
	    dataG = eGeneralDataRepos.findOne(username);
	    if (data.getFunctionalLm().equals(dataG.getName() + " " + dataG.getSurname())) {

		listEgToRetun.add(eGeneralData);

	    }

	}

	return listEgToRetun;
    }

    public List<ELData> myTeamLeavesWaiting(String username) {

	List<ELData> toReturn = new ArrayList<ELData>();
	List<ELData> list = new ArrayList<ELData>();
	list = elDataRepos.findAll();
	for (ELData em : list) {

	    if (em.getResurceId().equals(username) && em.getStatus().equals("waiting")) {
		toReturn.add(em);

	    }

	}

	return toReturn;
    }

}

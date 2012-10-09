/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wadia.metier;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sun.xml.internal.bind.v2.runtime.Name;
import com.wadia.beans.EGeneralData;
import com.wadia.beans.EWarningData;
import com.wadia.repos.EGeneralDataRepos;
import com.wadia.repos.EWarningDataRepos;

/**
 * 
 * @author ITR2012
 */
@Service ("waringnfillMetier")
@Transactional
public class WaringnfillMetier implements Serializable {

    @Inject
    private EWarningDataRepos eWarningDataRepos;
    @Inject
    private EGeneralDataRepos eGeneralDataRepos;

    public List<WarningHrMetier> listwarning() {

	List<EGeneralData> eGenList = new ArrayList<EGeneralData>();
	List<WarningHrMetier> eWarningHrMetiers = new ArrayList<WarningHrMetier>();
	
	// List<EWarningData> eWarningDatas = new ArrayList<EWarningData>();

	eGenList = eGeneralDataRepos.findAll();
	// eWarningDatas=eWarningDataDao.findAll();
	// EWarningData eWarningData = new EWarningData();

	for (EGeneralData employ : eGenList) {
	    WarningHrMetier warning = new WarningHrMetier();
	    warning.setName(employ.getName());
	    warning.setSurname(employ.getSurname());
	    warning.setUsername(employ.getResurceId());
	    warning.setEmployStatut(employ.getStatus());
	   
	    List<EWarningData> eWarnList = new ArrayList<EWarningData>();
	   
	    eWarnList = findByUsername(employ.getResurceId());
	    warning.setTotalWarning(eWarnList.size());
	   
	    for (EWarningData warn : eWarnList) {

		warning.setRaison(warn.getRaison());
		warning.setDate(warn.getDate());
		warning.setWarningId(warn.getWarningId());
		warning.setWarningType(warn.getWarningType());
		warning.setSevirity(warn.getSevirity());
	    }
	    eWarningHrMetiers.add(warning);
	}

	return eWarningHrMetiers;
    }

    public List<EWarningData> findByUsername(String Username) {
	List<EWarningData> eWarningDataList = new ArrayList<EWarningData>();
	List<EWarningData> eWarnList = new ArrayList<EWarningData>();
	eWarnList = eWarningDataRepos.findAll();
	for (EWarningData warn : eWarnList) {
	    if (warn.getResurceId().equals(Username)) {
		eWarningDataList.add(warn);
	    }
	}
	return eWarningDataList;
    }
}

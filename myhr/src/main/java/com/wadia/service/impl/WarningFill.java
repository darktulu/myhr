package com.wadia.service.impl;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.wadia.beans.EGeneralData;
import com.wadia.beans.EWarningData;
import com.wadia.metier.WarningHrMetier;
import com.wadia.repos.EGeneralDataRepos;
import com.wadia.repos.EWarningDataRepos;

@Service
@Transactional
public class WarningFill{
	
	@Inject
    private EWarningDataRepos eWarningDataRepos;
    @Inject
    private EGeneralDataRepos eGeneralDataRepos;
    
    public List<WarningHrMetier> listwarning() {

	List<EGeneralData> eGenList = new ArrayList<EGeneralData>();
	List<WarningHrMetier> eWarningHrMetiers = new ArrayList<WarningHrMetier>();
	
	eGenList = eGeneralDataRepos.findAll();
	

	for (EGeneralData employ : eGenList) {
	    WarningHrMetier warning = new WarningHrMetier();
	    warning.setName(employ.getName());
	    warning.setSurname(employ.getSurname());
	    warning.setUsername(employ.getResurceId());
	    warning.setEmployStatut(employ.getStatus());
	   
	    List<EWarningData> eWarnList = new ArrayList<EWarningData>();
	   
	    eWarnList = eWarningDataRepos.findByResurceId(employ.getResurceId());
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

}
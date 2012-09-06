/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wadia.metier;

import javax.inject.Inject;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.wadia.beans.Affectation;
import com.wadia.beans.EGeneralData;
import com.wadia.local.organizational;
import com.wadia.repos.EFunctionalDataRepos;
import com.wadia.repos.EGeneralDataRepos;

/**
 * 
 * @author toshiba
 */
@Service
@Transactional
public class orgHrMetier {


    @Inject
    private EGeneralDataRepos eGeneralDataRepos;
    @Inject
    private AffectationMetier affectationMetier;

    public organizational getbyusername(String username) {

	EGeneralData eGeneralData = new EGeneralData();

	// eFunctional = new EFunctionalData();

	organizational org = new organizational();

	eGeneralData = eGeneralDataRepos.findOne(username);
	
	Affectation affectation = new Affectation();
	affectation = affectationMetier.getbyusername(username);

	// eFunctional = dataDao.findById(eGeneralData.getEfId());

	org.setCountry(eGeneralData.getCountry());
	// org.setFlm(eFunctional.getFunctionalLm());
	org.setGrade(eGeneralData.getGrade());
	// org.setHlineManager(eFunctional.getFunctionalLm());
	org.setJob_Title(eGeneralData.getJobeTitle());
	// org.setLob(eFunctional.getLob());
	org.setRegion(eGeneralData.getRegion());
	org.setStatus(eGeneralData.getIesourcing());
	org.setName(eGeneralData.getName());
	org.setSurname(eGeneralData.getSurname());
	org.setUsername(eGeneralData.getResurceId());
	org.setTerce(eGeneralData.getTercel());
	org.setLadder(eGeneralData.getLadder());
	org.setLob(affectation.getLob().getName());
	org.setFlm(affectation.getUsersByUsersLm().getFullName());
	org.setHlineManager(affectation.getUsersByUsersHr().getFullName());

	return org;
    }

}

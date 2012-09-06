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

import com.wadia.beans.Abscence;
import com.wadia.beans.EGeneralData;
import com.wadia.repos.AbscenceRepos;
import com.wadia.repos.EGeneralDataRepos;

/**
 * 
 * @author ITR2012
 */
@Service
@Transactional
public class AbsencefillMetier {
    private int totalAbsence = 0;
    @Inject
    private AbscenceRepos eAbscenceRepos;
    
    @Inject
    private EGeneralDataRepos eGeneralDataRepos;

    public List<AbsencehrMetier> listAbsence() {
	List<EGeneralData> eGenList = new ArrayList<EGeneralData>();
	List<AbsencehrMetier> eAbsencehrMetiers = new ArrayList<AbsencehrMetier>();

	eGenList = eGeneralDataRepos.findAll();

	for (EGeneralData employ : eGenList) {
	    totalAbsence = 0;
	    AbsencehrMetier absent = new AbsencehrMetier();
	    absent.setName(employ.getName());
	    absent.setSurname(employ.getSurname());
	    absent.setUsername(employ.getResurceId());
	    absent.setEmployStatut(employ.getStatus());
	    List<Abscence> absetList = new ArrayList<Abscence>();
	    absetList = findByUsername(employ.getResurceId());
	    totalAbsence = CalculeTatalAbsence(absetList);
	    for (Abscence warn : absetList) {

		absent.setNbDays(warn.getNbDays());
		absent.setId(warn.getId());
		absent.setStartDay(warn.getStartDay());
		absent.setEndDay(warn.getEndDay());
		absent.setJustified(warn.getJustified());
		absent.setPayed(warn.getPayed());
		absent.setType(warn.getType());

		absent.setTotalAbsence(totalAbsence);
	    }
	    eAbsencehrMetiers.add(absent);
	}

	return eAbsencehrMetiers;
    }

    public List<Abscence> findByUsername(String Username) {
	List<Abscence> absenceDataList = new ArrayList<Abscence>();
	List<Abscence> eWarnList = new ArrayList<Abscence>();
	eWarnList = eAbscenceRepos.findAll();
	for (Abscence abse : eWarnList) {
	    if (abse.getRessourceId().equals(Username))
		absenceDataList.add(abse);
	}
	return absenceDataList;
    }

    public int CalculeTatalAbsence(List<Abscence> listAbs) {

	for (Abscence abs : listAbs) {

	    totalAbsence = totalAbsence + abs.getNbDays();
	}
	return totalAbsence;
    }

    /**
     * @return the totalAbsence
     */
    public int getTotalAbsence() {
	return totalAbsence;
    }

    /**
     * @param totalAbsence
     *            the totalAbsence to set
     */
    public void setTotalAbsence(int totalAbsence) {
	this.totalAbsence = totalAbsence;
    }

    public AbscenceRepos geteAbscenceRepos() {
        return eAbscenceRepos;
    }

    public void seteAbscenceRepos(AbscenceRepos eAbscenceRepos) {
        this.eAbscenceRepos = eAbscenceRepos;
    }

    public EGeneralDataRepos geteGeneralDataRepos() {
        return eGeneralDataRepos;
    }

    public void seteGeneralDataRepos(EGeneralDataRepos eGeneralDataRepos) {
        this.eGeneralDataRepos = eGeneralDataRepos;
    }

}

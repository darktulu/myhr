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

import com.wadia.beans.EGeneralData;
import com.wadia.local.family;
import com.wadia.repos.EGeneralDataRepos;

/**
 * 
 * @author toshiba
 */
@Service
@Transactional
public class famillyMetier {

    @Inject
    private EGeneralDataRepos eGeneralDataRepos;
    @Inject
    private ChildMetier childMetier;
    @Inject
    private SpouseListMetier spouseListMetier;

    public List<family> family() {

	List<family> listFam = new ArrayList<family>();
	List<EGeneralData> listEmploys = new ArrayList<EGeneralData>();
	listEmploys = eGeneralDataRepos.findAll();
	

	for (EGeneralData employ : listEmploys) {

	    family famely = new family();
	    famely.setName(employ.getName());
	    famely.setSurname(employ.getSurname());
	    famely.setUsername(employ.getResurceId());
	    famely.setStatus(employ.getStatus());
	    famely.setGender(employ.getGender());
	    famely.setMaritalStatus(employ.getMartialStatus());
	    famely.setCIN(employ.getCin());
	    famely.setBirthday(employ.getBirthday());
	    famely.setNb_children(childMetier.countChilds(employ.getResurceId()).size());
	    famely.setNb_spouse(spouseListMetier.findSpouseByUsername(employ.getResurceId()).size());

	    listFam.add(famely);

	}

	return listFam;

    }

    public family getByUsername(String username) {

	family fam = new family();
	List<family> list = new ArrayList<family>();
	list = family();

	for (family fami : list) {

	    if (fami.getUsername().equals(username)) {

		fam = fami;
	    }

	}

	return fam;

    }

}

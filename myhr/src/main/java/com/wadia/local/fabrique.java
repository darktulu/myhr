/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wadia.local;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.wadia.beans.EGeneralData;
import com.wadia.metier.ContrathrMetier;
import com.wadia.repos.EGeneralDataRepos;

/**
 * 
 * @author toshiba
 */
@Service
public class fabrique {

    @Inject
    private EGeneralDataRepos eGeneralDataRepos;
    
    public List<ContrathrMetier> toArray(HashSet<ContrathrMetier> list) {

	List<ContrathrMetier> listToReturn = new ArrayList<ContrathrMetier>();

	for (ContrathrMetier contrathrMetier : list) {

	    listToReturn.add(contrathrMetier);

	}

	return listToReturn;

    }

    public List<EGeneralData> toArrays(HashSet<EGeneralData> list) {

	List<EGeneralData> listToReturn = new ArrayList<EGeneralData>();

	for (EGeneralData obj : list) {

	    listToReturn.add(obj);

	}

	return listToReturn;

    }

    public List<user> getUsernameList() {
	List<EGeneralData> eGenList = new ArrayList<EGeneralData>();
	List<user> ulist = new ArrayList<user>();
	eGenList = eGeneralDataRepos.findAll();
	for (EGeneralData gen : eGenList) {

	    user u = new user();
	    u.setName(gen.getName() + " " + gen.getSurname());
	    u.setUsername(gen.getResurceId());
	    ulist.add(u);

	}
	return ulist;
    }

}

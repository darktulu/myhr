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

import com.wadia.beans.ESpouse;
import com.wadia.repos.ESpouseRepos;

/**
 * 
 * @author toshiba
 */
@Service
@Transactional
public class SpouseListMetier {

    @Inject
    private ESpouseRepos espouseRepos;

    public List<ESpouse> findSpouseByUsername(String username) {

	List<ESpouse> eSpouseList = new ArrayList<ESpouse>();
	List<ESpouse> eSpouseListToReturn = new ArrayList<ESpouse>();
	eSpouseList = espouseRepos.findAll();

	for (int i = 0; i < eSpouseList.size(); i++) {

	    if (eSpouseList.get(i).getResurceId().equals(username)) {
		eSpouseListToReturn.add(eSpouseList.get(i));
	    }

	}

	return eSpouseListToReturn;

    }

}

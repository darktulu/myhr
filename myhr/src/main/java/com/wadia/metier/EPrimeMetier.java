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

import com.wadia.beans.EPrime;
import com.wadia.repos.EPrimeRepos;

/**
 * 
 * @author toshiba
 */
@Service
@Transactional
public class EPrimeMetier {

    @Inject
    private EPrimeRepos ePrimeRepos;

    public List<EPrime> getByusername(String username) {

	List<EPrime> list;
	List<EPrime> listToreturn = new ArrayList<EPrime>();

	list = ePrimeRepos.findAll();

	for (EPrime prime : list) {
	    if (prime.getResourceId().equals(username))
		listToreturn.add(prime);
	}

	return listToreturn;
    }

    public List<EPrime> getByDate(String username) {
	int mois;
	int ans;
	List<EPrime> list = new ArrayList<EPrime>();
	List<EPrime> listToReturn = new ArrayList<EPrime>();
	list = getByusername(username);
	
	if (ePrimeRepos.findByAnsMax(username) != null) {
	    ans = ePrimeRepos.findByAnsMax(username).intValue();
	} else {
	    ans = 0;
	}

	if (ePrimeRepos.findByAnsMax(username) != null) {
	    mois = ePrimeRepos.findByMoisMax(username).intValue();
	} else {
	    mois = 0;
	}
	for (EPrime prime : list) {

	    if (prime.getMois() == mois && prime.getAns() == ans)

		listToReturn.add(prime);

	}

	return listToReturn;

    }

    public float getTotalPrim(List<EPrime> listPrim) {
	float totalPrim = 0;
	if (listPrim != null) {
	    for (EPrime prim : listPrim) {
		totalPrim += prim.getMontant();
	    }
	}
	return totalPrim;
    }

}

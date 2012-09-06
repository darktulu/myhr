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

import com.wadia.beans.EIndemnite;
import com.wadia.repos.EIndemniteRepos;

/**
 * 
 * @author toshiba
 */
@Service
@Transactional
public class EindemMetier {

    @Inject
    private EIndemniteRepos eIndemniteRepos;

    public List<EIndemnite> getByusername(String username) {

	List<EIndemnite> list;
	List<EIndemnite> listToreturn = new ArrayList<EIndemnite>();

	list = eIndemniteRepos.findAll();

	for (EIndemnite idem : list) {
	    if (idem.getResureceId().equals(username)) {
		listToreturn.add(idem);
	    }
	}

	return listToreturn;
    }

    public List<EIndemnite> getByDate(String username) {
	int mois = 0;
	int ans = 0;
	List<EIndemnite> list = new ArrayList<EIndemnite>();
	List<EIndemnite> listToReturn = new ArrayList<EIndemnite>();
	list = getByusername(username);
	if (eIndemniteRepos.findByMoisMax(username) != null) {
	    mois = eIndemniteRepos.findByMoisMax(username);
	}
	if (eIndemniteRepos.findByAnsMax(username) != null) {
	    ans = eIndemniteRepos.findByAnsMax(username);
	}
	for (EIndemnite indem : list) {

	    if (indem.getMois() == mois && indem.getAns() == ans) {
		listToReturn.add(indem);
	    }

	}

	return listToReturn;

    }

    public float getTotalIndem(List<EIndemnite> listIndem) {
	float totalIndem = 0;
	if (listIndem != null) {
	    for (EIndemnite idem : listIndem) {
		totalIndem = totalIndem + idem.getMontant();
	    }
	}
	return totalIndem;
    }

    public void saveIndem(List<EIndemnite> eIndemnites) {
	for (EIndemnite indem : eIndemnites) {
	    eIndemniteRepos.save(indem);
	}

    }
}

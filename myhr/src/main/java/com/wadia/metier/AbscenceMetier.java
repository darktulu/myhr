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
import com.wadia.repos.AbscenceRepos;

/**
 * 
 * @author toshiba
 */
@Service
@Transactional
public class AbscenceMetier {

    @Inject
    private AbscenceRepos abscenceDao;

    public List<Abscence> findByUsername(String username) {

	List<Abscence> list = new ArrayList<Abscence>();
	List<Abscence> listToReturn = new ArrayList<Abscence>();
	list = abscenceDao.findAll();

	for (Abscence abscence : list) {

	    if (abscence.getRessourceId().equals(username)) {
		listToReturn.add(abscence);
	    }
	}
	return listToReturn;
    }
}

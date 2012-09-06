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

import com.wadia.beans.EEducationData;
import com.wadia.repos.EEducationDataRepos;

/**
 * 
 * @author massin
 */
@Service
@Transactional
public class EEducationDataMetier {

    @Inject
    private EEducationDataRepos eEducationDataRepos;

    public List<EEducationData> findByUsername(String username) {
	List<EEducationData> educationdatas  = new ArrayList<EEducationData>();
	List<EEducationData> educToReturn = new ArrayList<EEducationData>();
	educationdatas = eEducationDataRepos.findAll();
	for (EEducationData educ : educationdatas) {
	    if (educ.getResurceId().equals(username)) {
		educToReturn.add(educ);
	    }
	}
	return educToReturn;
    }

}

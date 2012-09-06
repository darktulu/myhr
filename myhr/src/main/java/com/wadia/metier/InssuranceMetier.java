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

import com.wadia.beans.Child;
import com.wadia.beans.EInsurranceData;
import com.wadia.beans.ESpouse;
import com.wadia.repos.EInsurranceDataRepos;

/**
 * 
 * @author toshiba
 */
@Service
@Transactional
public class InssuranceMetier {

    @Inject
    private EInsurranceDataRepos eInsurranceDataRepos;
    @Inject
    private ChildMetier childMetier;
    @Inject
    private SpouseListMetier spouseListMetier;

    public List<EInsurranceData> findByUsername(String username) {

	List<EInsurranceData> list = new ArrayList<EInsurranceData>();
	List<EInsurranceData> listToReturn = new ArrayList<EInsurranceData>();

	list = eInsurranceDataRepos.findAll();

	for (EInsurranceData eInsurranceData : list) {

	    if (eInsurranceData.getResurceId().equals(username)) {
		listToReturn.add(eInsurranceData);
	    }

	}

	return listToReturn;

    }

    public int personnePrisEnCharge(String username) {
	int number = 0;
	List<Child> listchild = new ArrayList<Child>();
	List<ESpouse> listspouse = new ArrayList<ESpouse>();
	listchild = childMetier.countChilds(username);
	listspouse = spouseListMetier.findSpouseByUsername(username);

	for (Child child : listchild) {

	    if (child.getStatus().equals("yes")) {
		number++;
	    }

	}

	for (ESpouse spouse : listspouse) {

	    if (spouse.getSpouseStatus().equals("yes")) {
		number++;
	    }

	}

	return number;

    }

    public List<String> ListPrisEnC(String username) {

	List<String> list = new ArrayList<String>();
	
	List<Child> listchild = new ArrayList<Child>();
	List<ESpouse> listspouse = new ArrayList<ESpouse>();
	listchild = childMetier.countChilds(username);
	listspouse = spouseListMetier.findSpouseByUsername(username);

	for (Child child : listchild) {

	    if (child.getStatus().equals("yes")) {
		list.add(child.getChildName());
	    }

	}

	for (ESpouse spouse : listspouse) {

	    if (spouse.getSpouseStatus().equals("yes")) {
		list.add(spouse.getSpouseName());
	    }

	}

	return list;

    }

}

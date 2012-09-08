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
import com.wadia.beans.ESpouse;
import com.wadia.repos.ChildRepos;
import com.wadia.repos.ESpouseRepos;

/**
 * 
 * @author toshiba
 */
@Service
@Transactional
public class ChildMetier {

    @Inject
    private ChildRepos childRepos;

    @Inject
    private ESpouseRepos espouseRepos;

    public int countPersonnePrisEnCharge(String username) {
	int result = 0;
	List<Child> listChild;

	List<ESpouse> listSpouse = espouseRepos.findByResurceId(username);
	if (listSpouse == null)
	    return 0;
	for (ESpouse spouse : listSpouse) {
	    listChild = childRepos.findBySpouseId(spouse.getSpouseId());
	    if (listChild != null)
		result += listChild.size();
	}
	return listSpouse.size() + result;
    }

    public List<Child> countChilds(String username) {

	List<Child> ListToReturn = new ArrayList<Child>();

	List<Child> listChilds = new ArrayList<Child>();
	List<ESpouse> list = new ArrayList<ESpouse>();
	List<ESpouse> listByUsername = new ArrayList<ESpouse>();

	list = espouseRepos.findAll();
	listChilds = childRepos.findAll();

	for (ESpouse spouse : list) {
	    if (spouse.getResurceId().equals(username)) {
		listByUsername.add(spouse);
	    }
	}

	for (Child child : listChilds) {

	    for (ESpouse spouse : listByUsername) {

		if (child.getSpouseId().equals(spouse.getSpouseId()))
		    ListToReturn.add(child);

	    }

	}

	return ListToReturn;
    }

}

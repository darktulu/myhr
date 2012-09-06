/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wadia.view;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;

import com.wadia.beans.TypeAbsence;
import com.wadia.repos.TypeAbsenceRepos;

/**
 * 
 * @author toshiba
 */
@ManagedBean
@RequestScoped
public class TypeAbsenceList {

    private List<TypeAbsence> list = new ArrayList<TypeAbsence>();
    private String search;

    @ManagedProperty(value = "#{typeAbsenceRepos}")
    private TypeAbsenceRepos typeAbsenceRepos;

    public TypeAbsenceList() {

	list = typeAbsenceRepos.findAll();
    }

    public void update() {
	list = typeAbsenceRepos.findAll();
    }

    public List<TypeAbsence> getList() {
	return list;
    }

    public void setList(List<TypeAbsence> list) {
	this.list = list;
    }

    public String getSearch() {
	return search;
    }

    public void setSearch(String search) {
	this.search = search;

	if (search != null) {
	    list = typeAbsenceRepos.findAll();
	    List<TypeAbsence> lisToAffect = new ArrayList<TypeAbsence>();
	    for (TypeAbsence abs : list) {

		if (abs.getName().toLowerCase().equals(search.toLowerCase())
			|| abs.getPayed().toLowerCase().equals(search.toLowerCase())) {

		    lisToAffect.add(abs);
		}

	    }

	    list = lisToAffect;

	}
    }
}

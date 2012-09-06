/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wadia.view;

import com.wadia.metier.WaringnfillMetier;
import com.wadia.metier.WarningHrMetier;
import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

/**
 * 
 * @author ITR2012
 */
@ManagedBean
@RequestScoped
public class WarningHrCtl {
    private List<WarningHrMetier> eWarning = new ArrayList<WarningHrMetier>();
    private WaringnfillMetier eMetier = new WaringnfillMetier();
    private int totalWarning;
    private String search;

    public WarningHrCtl() {
	eWarning = eMetier.listwarning();

    }

    /**
     * @return the eWarning
     */
    public List<WarningHrMetier> geteWarning() {
	return eWarning;
    }

    /**
     * @param eWarning
     *            the eWarning to set
     */
    public void seteWarning(List<WarningHrMetier> eWarning) {
	this.eWarning = eWarning;
    }

    /**
     * @return the eMetier
     */
    public WaringnfillMetier geteMetier() {
	return eMetier;
    }

    /**
     * @param eMetier
     *            the eMetier to set
     */
    public void seteMetier(WaringnfillMetier eMetier) {
	this.eMetier = eMetier;
    }

    /**
     * @return the totalWarning
     */
    public int getTotalWarning() {
	return totalWarning;
    }

    /**
     * @param totalWarning
     *            the totalWarning to set
     */
    public void setTotalWarning(int totalWarning) {
	this.totalWarning = totalWarning;
    }

    public String getSearch() {
	return search;
    }

    public void setSearch(String search) {
	this.search = search;

	if (search != null) {
	    List<WarningHrMetier> warningListSearch = new ArrayList<WarningHrMetier>();
	    System.out.println("filtering wrnings... " + search);
	    eWarning = eMetier.listwarning();
	    for (WarningHrMetier war : eWarning) {
		if (war.getName().toLowerCase().contains(search.toLowerCase())
			|| war.getSurname().toLowerCase().contains(search.toLowerCase())
			|| war.getUsername().toLowerCase().contains(search.toLowerCase())
			|| war.getEmployStatut().toLowerCase().contains(search.toLowerCase())) {
		    warningListSearch.add(war);
		}
	    }
	    System.out.println("pchakh : " + warningListSearch.size());
	    eWarning = warningListSearch;

	}
    }

}

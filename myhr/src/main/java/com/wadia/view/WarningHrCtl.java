/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wadia.view;

import com.wadia.metier.DirectoryMetier;
import com.wadia.metier.WaringnfillMetier;
import com.wadia.metier.WarningHrMetier;
import com.wadia.service.impl.WarningFill;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.ViewScoped;

/**
 * 
 * @author ITR2012
 */
@ManagedBean (name="WarningHrCtl")
@ViewScoped
public class WarningHrCtl implements Serializable {
   
	private List<WarningHrMetier> eWarning = new ArrayList<WarningHrMetier>();
   

	
	 private WarningFill warningFill() {
	        return SpringJSFUtil.getBean("warningFill");
	    }
   
    private int totalWarning;
    private String search;
    
    @PostConstruct
    public void init() {
	eWarning = warningFill().listwarning();

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
	    eWarning = warningFill().listwarning();
	    for (WarningHrMetier war : eWarning) {
		if (war.getName().toLowerCase().contains(search.toLowerCase())
			|| war.getSurname().toLowerCase().contains(search.toLowerCase())
			|| war.getUsername().toLowerCase().contains(search.toLowerCase())
			|| war.getEmployStatut().toLowerCase().contains(search.toLowerCase())) {
		    warningListSearch.add(war);
		}
	    }
	    System.out.println("pchakh : " + warningListSearch.size());
	    eWarning.clear();
	    eWarning.addAll(warningListSearch);
	  

	}
    }

	

	

}

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wadia.view;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;

import com.wadia.beans.ESpouse;
import com.wadia.repos.ESpouseRepos;

/**
 * 
 * @author toshiba
 */
@ManagedBean (name="SpouseCtl")
@RequestScoped
public class SpouseCtl {

    private String idSpouseToEdit;
    @ManagedProperty(value = "#{eSpouseRepos}")
    private ESpouseRepos eSpouseRepos;
    private static ESpouse spouse = new ESpouse();

    /**
     * @return the idSpouseToEdit
     */

    public String updateSpouse() {
	if (spouse.getSpouseId() == null) {
	    return null;
	} else {

	    eSpouseRepos.save(spouse);
	    return "ok";

	}
    }

    public String getIdSpouseToEdit() {
	return idSpouseToEdit;
    }

    public void setIdSpouseToEdit(String idSpouseToEdit) {
	this.idSpouseToEdit = idSpouseToEdit;
	if (idSpouseToEdit != null) {
	    spouse = eSpouseRepos.findOne(idSpouseToEdit);
	}
    }



    public ESpouseRepos geteSpouseRepos() {
        return eSpouseRepos;
    }

    public void seteSpouseRepos(ESpouseRepos eSpouseRepos) {
        this.eSpouseRepos = eSpouseRepos;
    }

    public ESpouse getSpouse() {
	return spouse;
    }

    public void setSpouse(ESpouse spouse) {
	this.spouse = spouse;
    }

}

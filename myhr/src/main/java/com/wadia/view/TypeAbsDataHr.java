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
@ManagedBean (name="TypeAbsDataHr")
@RequestScoped
public class TypeAbsDataHr {

    private String name;
    private String payed;
    private Integer nombreDays;
    private String commantaire;
    private static TypeAbsence data;
    private int idToDelete;

    @ManagedProperty(value = "#{typeAbsenceRepos}")
    private TypeAbsenceRepos typeAbsenceRepos;



    public TypeAbsenceRepos getTypeAbsenceRepos() {
        return typeAbsenceRepos;
    }

    public void setTypeAbsenceRepos(TypeAbsenceRepos typeAbsenceRepos) {
        this.typeAbsenceRepos = typeAbsenceRepos;
    }

    public String getName() {
	return name;
    }

    public void setName(String name) {
	this.name = name;
    }

    public String getPayed() {
	return payed;
    }

    public void setPayed(String payed) {
	this.payed = payed;
    }

    public Integer getNombreDays() {
	return nombreDays;
    }

    public void setNombreDays(Integer nombreDays) {
	this.nombreDays = nombreDays;
    }

    public String getCommantaire() {
	return commantaire;
    }

    public void setCommantaire(String commantaire) {
	this.commantaire = commantaire;
    }

    public int getIdToDelete() {
	return idToDelete;
    }

    public void setIdToDelete(int idToDelete) {
	this.idToDelete = idToDelete;

	if (idToDelete != 0) {
	    data = typeAbsenceRepos.findOne(idToDelete);
	}
    }

    public TypeAbsence getData() {
	return data;
    }

    public void setData(TypeAbsence data) {
	this.data = data;
    }

    public boolean TyeBKO(TypeAbsence abs) {
	boolean var = true;
	List<TypeAbsence> listabsence = new ArrayList<TypeAbsence>();
	listabsence = typeAbsenceRepos.findAll();

	for (TypeAbsence abse : listabsence) {

	    if (abs.getName().equals(abse.getName())) {
		var = false;
	    }

	}

	return var;

    }

    public String saveTYpeAbs() {

	TypeAbsence absence = new TypeAbsence(name, payed, nombreDays, commantaire);
	System.out.println("hereeee");
	if (TyeBKO(absence)) {
	    typeAbsenceRepos.save(absence);
	}

	return "ok";

    }

    public String deleteType() {

	if (data != null) {

	    typeAbsenceRepos.delete(data);
	}
	return "ok";

    }

}

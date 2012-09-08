/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wadia.view;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;

import com.wadia.beans.TypeAbsence;
import com.wadia.service.TypeAbsenceService;

/**
 * 
 * @author toshiba
 */
@ManagedBean(name = "TypeAbsDataHr")
@RequestScoped
public class TypeAbsDataHr {

    private String name;
    private String payed;
    private Integer nombreDays;
    private String commantaire;
    private TypeAbsence data;
    private int idToDelete;

    @ManagedProperty(value = "#{typeAbsenceRepos}")
    private TypeAbsenceService typeAbsenceService;

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
	    data = typeAbsenceService.findOne(idToDelete);
	}
    }

    public TypeAbsence getData() {
	return data;
    }

    public void setData(TypeAbsence data) {
	this.data = data;
    }

    public String saveTYpeAbs() {
	TypeAbsence absence = new TypeAbsence(name, payed, nombreDays, commantaire);
	if (!typeAbsenceService.existTypeAbsence(absence)) {
	    typeAbsenceService.addTypeAbsence(absence);
	}
	return "ok";
    }

    public String deleteType() {
	if (data != null) {
	    typeAbsenceService.deleteTypeAbsence(data);
	}
	return "ok";
    }

}

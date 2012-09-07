/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wadia.view;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;

import com.wadia.beans.Abscence;
import com.wadia.local.fabrique;
import com.wadia.local.user;
import com.wadia.repos.AbscenceRepos;

/**
 * 
 * @author toshiba
 */
@ManagedBean (name="AbsenceDataHr")
@RequestScoped
public class AbsenceDataHr {

    private String ressourceId;
    private Date startDay;
    private Date endDay;
    private int nbDays;
    private String justified;
    private String type;
    private String payed;

    @ManagedProperty(value = "#{abscenceRepos}")
    private AbscenceRepos abscenceRepos;
    @ManagedProperty(value = "#{fabrique}")
    fabrique fabrique;


    public boolean absenceKO(Abscence absence) {

	List<Abscence> list = new ArrayList<Abscence>();
	list = abscenceRepos.findAll();
	boolean var = true;
	for (Abscence abs : list) {

	    if (absence.getRessourceId().equals(abs.getRessourceId())
		    && absence.getStartDay().compareTo(abs.getStartDay()) == 0) {

		var = false;
	    }

	}
	return var;

    }

    public String saveAbsence() {

	Abscence absn = new Abscence(ressourceId, startDay, endDay, nbDays, justified, type, payed);
	if (absenceKO(absn)) {
	    abscenceRepos.save(absn);
	}

	return "ok";

    }

    public List<user> getusernames() {

	return fabrique.getUsernameList();

    }

    public String getRessourceId() {
	return ressourceId;
    }

    public void setRessourceId(String ressourceId) {
	this.ressourceId = ressourceId;
    }

    public Date getStartDay() {
	return startDay;
    }

    public void setStartDay(Date startDay) {
	this.startDay = startDay;
    }

    public Date getEndDay() {
	return endDay;
    }

    public void setEndDay(Date endDay) {
	this.endDay = endDay;
    }

    public int getNbDays() {
	return nbDays;
    }

    public void setNbDays(int nbDays) {
	this.nbDays = nbDays;
    }

    public String getJustified() {
	return justified;
    }

    public void setJustified(String justified) {
	this.justified = justified;
    }

    public String getType() {
	return type;
    }

    public void setType(String type) {
	this.type = type;
    }

    public String getPayed() {
	return payed;
    }

    public void setPayed(String payed) {
	this.payed = payed;
    }

    public AbscenceRepos getAbscenceRepos() {
        return abscenceRepos;
    }

    public void setAbscenceRepos(AbscenceRepos abscenceRepos) {
        this.abscenceRepos = abscenceRepos;
    }

    public fabrique getFabrique() {
        return fabrique;
    }

    public void setFabrique(fabrique fabrique) {
        this.fabrique = fabrique;
    }


}

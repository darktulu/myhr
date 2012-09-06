/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wadia.view;

import java.util.Date;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;

import com.wadia.beans.Abscence;
import com.wadia.repos.AbscenceRepos;

/**
 * 
 * @author ITR2012
 */
@ManagedBean (name="AbsenceEditCtl")
@RequestScoped
public class AbsenceEditCtl {

    private static Integer id;
    private static String ressourceId;
    private static Date startDay;
    private static Date endDay;
    private static int nbDays;
    private static String justified;
    private static String type;
    private static String payed;
    private Integer IdToEdit;
    private Integer idToDelete;
    private static Abscence data;
    @ManagedProperty(value = "#{abscenceRepos}")
    private AbscenceRepos abscenceRepos;



    public String saveEdit() {
	Abscence absen = new Abscence();
	System.out.println("this is the id " + id);
	absen.setEndDay(endDay);
	absen.setId(id);
	absen.setJustified(justified);
	absen.setNbDays(nbDays);
	absen.setPayed(payed);
	absen.setRessourceId(ressourceId);
	absen.setStartDay(startDay);
	absen.setType(type);
	abscenceRepos.save(absen);

	return "ok";
    }

    /**
     * @return the id
     */
    public Integer getId() {
	return id;
    }

    /**
     * @param id
     *            the id to set
     */
    public void setId(Integer id) {
	this.id = id;
    }

    /**
     * @return the ressourceId
     */
    public String getRessourceId() {
	return ressourceId;
    }

    /**
     * @param ressourceId
     *            the ressourceId to set
     */
    public void setRessourceId(String ressourceId) {
	this.ressourceId = ressourceId;
    }

    /**
     * @return the startDay
     */
    public Date getStartDay() {
	return startDay;
    }

    /**
     * @param startDay
     *            the startDay to set
     */
    public void setStartDay(Date startDay) {
	this.startDay = startDay;
    }

    /**
     * @return the endDay
     */
    public Date getEndDay() {
	return endDay;
    }

    /**
     * @param endDay
     *            the endDay to set
     */
    public void setEndDay(Date endDay) {
	this.endDay = endDay;
    }

    /**
     * @return the nbDays
     */
    public int getNbDays() {
	return nbDays;
    }

    /**
     * @param nbDays
     *            the nbDays to set
     */
    public void setNbDays(int nbDays) {
	this.nbDays = nbDays;
    }

    /**
     * @return the justified
     */
    public String getJustified() {
	return justified;
    }

    /**
     * @param justified
     *            the justified to set
     */
    public void setJustified(String justified) {
	this.justified = justified;
    }

    /**
     * @return the type
     */
    public String getType() {
	return type;
    }

    /**
     * @param type
     *            the type to set
     */
    public void setType(String type) {
	this.type = type;
    }

    /**
     * @return the payed
     */
    public String getPayed() {
	return payed;
    }

    /**
     * @param payed
     *            the payed to set
     */
    public void setPayed(String payed) {
	this.payed = payed;
    }

    /**
     * @return the IdToEdit
     */
    public Integer getIdToEdit() {
	return IdToEdit;
    }

    /**
     * @param IdToEdit
     *            the IdToEdit to set
     */
    public void setIdToEdit(Integer IdToEdit) {
	this.IdToEdit = IdToEdit;
	if (IdToEdit != null) {
	    Abscence abscences = new Abscence();

	    abscences = abscenceRepos.findOne(IdToEdit);
	    id = abscences.getId();
	    ressourceId = abscences.getRessourceId();
	    startDay = abscences.getStartDay();
	    endDay = abscences.getEndDay();
	    nbDays = abscences.getNbDays();
	    justified = abscences.getJustified();
	    type = abscences.getType();
	    payed = abscences.getPayed();

	}
    }

    public Integer getIdToDelete() {
	return idToDelete;
    }

    public void setIdToDelete(Integer idToDelete) {
	this.idToDelete = idToDelete;

	if (idToDelete != 0) {
	    System.out.println("id" + idToDelete);
	    data = abscenceRepos.findOne(idToDelete);

	}

    }

    public Abscence getData() {
	return data;
    }

    public void setData(Abscence data) {
	this.data = data;
    }

    public String deleteAbs() {

	System.out.println("here");
	if (data != null) {
	    System.out.println("and Here");
	    abscenceRepos.delete(data);
	}
	return "ok";
    }

    public AbscenceRepos getAbscenceRepos() {
        return abscenceRepos;
    }

    public void setAbscenceRepos(AbscenceRepos abscenceRepos) {
        this.abscenceRepos = abscenceRepos;
    }

}

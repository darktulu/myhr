/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wadia.view;

import java.util.Date;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;

import com.wadia.beans.EInsurranceData;
import com.wadia.repos.EInsurranceDataRepos;

/**
 * 
 * @author toshiba
 */
@ManagedBean (name="InssuanceEditCtl")
@RequestScoped
public class InssuanceEditCtl {

    private int idToEdit;
    private static Integer inssuranceId;
    private static String resurceId;
    private static String matricule;
    private static Date date;
    private static String type;
    private static Date dateSoins;
    private static String dossier;
    private static String personName;
    private static String totalAmount;
    private static String status;
    private static String statusDescription;

    @ManagedProperty(value = "#{eInsurranceDataRepos}")
    private EInsurranceDataRepos eInsurranceDataRepos;



    public int getIdToEdit() {
	return idToEdit;
    }

    public void setIdToEdit(int idToEdit) {
	this.idToEdit = idToEdit;

	if (idToEdit != 0) {

	    EInsurranceData data = new EInsurranceData();
	    data = eInsurranceDataRepos.findOne(idToEdit);
	    resurceId = data.getResurceId();
	    matricule = data.getMatricule();
	    date = data.getDate();
	    type = data.getType();
	    dateSoins = data.getDateSoins();
	    dossier = data.getDossier();
	    personName = data.getPersonName();
	    totalAmount = data.getTotalAmount();
	    status = data.getStatus();
	    statusDescription = data.getStatusDescription();
	    inssuranceId = data.getInssuranceId();

	}

    }

    public String save() {

	EInsurranceData eid = new EInsurranceData(resurceId, matricule, date, type, dateSoins, dossier, personName,
		totalAmount, status, statusDescription);
	eid.setInssuranceId(inssuranceId);
	eInsurranceDataRepos.save(eid);
	return "ok";

    }

    public Integer getInssuranceId() {
	return inssuranceId;
    }

    public void setInssuranceId(Integer inssuranceId) {
	this.inssuranceId = inssuranceId;
    }

    public String getResurceId() {
	return resurceId;
    }

    public void setResurceId(String resurceId) {
	this.resurceId = resurceId;
    }

    public String getMatricule() {
	return matricule;
    }

    public void setMatricule(String matricule) {
	this.matricule = matricule;
    }

    public Date getDate() {
	return date;
    }

    public void setDate(Date date) {
	this.date = date;
    }

    public String getType() {
	return type;
    }

    public void setType(String type) {
	this.type = type;
    }

    public Date getDateSoins() {
	return dateSoins;
    }

    public void setDateSoins(Date dateSoins) {
	this.dateSoins = dateSoins;
    }

    public String getDossier() {
	return dossier;
    }

    public void setDossier(String dossier) {
	this.dossier = dossier;
    }

    public String getPersonName() {
	return personName;
    }

    public void setPersonName(String personName) {
	this.personName = personName;
    }

    public String getTotalAmount() {
	return totalAmount;
    }

    public void setTotalAmount(String totalAmount) {
	this.totalAmount = totalAmount;
    }

    public String getStatus() {
	return status;
    }

    public void setStatus(String status) {
	this.status = status;
    }

    public String getStatusDescription() {
	return statusDescription;
    }

    public void setStatusDescription(String statusDescription) {
	this.statusDescription = statusDescription;
    }
}

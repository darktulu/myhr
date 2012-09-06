/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wadia.view;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;

import com.wadia.beans.EInsurranceData;
import com.wadia.metier.InssuranceMetier;
import com.wadia.repos.EInsurranceDataRepos;

/**
 * 
 * @author toshiba
 */
@ManagedBean (name="InssuranceCtl")
@RequestScoped
public class InssuranceCtl {

    private String matricule;
    private Date date;
    private Date soin;
    private String type;
    private String personName;
    private String totalAmount;
    private String status;
    private String statusDescription;
    private String dossier;
    
    private userController user = new userController();
    
    private List<String> prisEnCharge;
    
    @ManagedProperty(value = "#{eInsurranceDataRepos}")
    private EInsurranceDataRepos eInsurranceDataRepos;
    @ManagedProperty(value = "#{inssuranceMetier}")
    private InssuranceMetier inssuranceMetier;
    
    @PostConstruct
    public void init() {

	prisEnCharge = inssuranceMetier.ListPrisEnC(user.getUsername());
	prisEnCharge.add(user.getUsername());
    }

    public boolean inssuranceKO(EInsurranceData inssurance) {

	boolean var = true;
	List<EInsurranceData> listE = new ArrayList<EInsurranceData>();
	listE = inssuranceMetier.findByUsername(user.getUsername());
	for (EInsurranceData inssurances : listE) {

	    if (inssurances.getMatricule().equals(inssurance.getMatricule())
		    && inssurances.getStatus().equals(inssurance.getStatus())) {

		var = false;
	    } else {
		var = true;
	    }

	}

	return var;

    }

    public String save() {

	matricule = user.getUsername() + "-" + matricul(user.getUsername());

	// EInsurranceData insssurece = new EInsurranceData(user.getUsername(),
	// matricule, date, type, personName, totalAmount, "waiting",
	// statusDescription);
	EInsurranceData insssurece = new EInsurranceData(user.getUsername(), matricule, date, type, soin, dossier,
		personName, totalAmount, "Edited", statusDescription);
	if (inssuranceKO(insssurece)) {
	    eInsurranceDataRepos.save(insssurece);
	}
	return "ok";
    }

    public int matricul(String username) {

	int number;
	List<EInsurranceData> list = new ArrayList<EInsurranceData>();
	list = inssuranceMetier.findByUsername(username);
	number = list.size() + 1;

	return number;

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

    public List<String> getPrisEnCharge() {
	return prisEnCharge;
    }

    public void setPrisEnCharge(List<String> prisEnCharge) {
	this.prisEnCharge = prisEnCharge;
    }

    public Date getSoin() {
	return soin;
    }

    public void setSoin(Date soin) {
	this.soin = soin;
    }

    public String getDossier() {
	return dossier;
    }

    public void setDossier(String dossier) {
	this.dossier = dossier;
    }

    public userController getUser() {
	return user;
    }

    public void setUser(userController user) {
	this.user = user;
    }

    public EInsurranceDataRepos geteInsurranceDataRepos() {
	return eInsurranceDataRepos;
    }

    public void seteInsurranceDataRepos(EInsurranceDataRepos eInsurranceDataRepos) {
	this.eInsurranceDataRepos = eInsurranceDataRepos;
    }

    public InssuranceMetier getInssuranceMetier() {
        return inssuranceMetier;
    }

    public void setInssuranceMetier(InssuranceMetier inssuranceMetier) {
        this.inssuranceMetier = inssuranceMetier;
    }



}

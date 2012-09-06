/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wadia.view;

import java.util.Calendar;
import java.util.GregorianCalendar;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;

import com.wadia.beans.EGeneralData;
import com.wadia.fileUpload.attestationTravail;
import com.wadia.metier.ContratMetier;
import com.wadia.metier.PathProvider;
import com.wadia.repos.EGeneralDataRepos;

/**
 * 
 * @author toshiba
 */
@ManagedBean (name="attestationTravailCtl")
@RequestScoped
public class attestationTravailCtl {

    private userController user = new userController();
    private attestationTravail travail = new attestationTravail();
    
    private String pdf;
    private String date_embauche;
    
    private PathProvider pathProvider = new PathProvider();
    
    @ManagedProperty(value = "#{eGeneralDataRepos}")
    private EGeneralDataRepos eGeneralDataRepos;
    @ManagedProperty(value = "#{contratMetier}")
    private ContratMetier contratMetier;

    @PostConstruct
    public void init() {

	pdf = "documents/" + user.getUsername() + ".pdf";
	date_embauche = contratMetier.embauche(user.getUsername());

    }

    public boolean generate() throws Exception {

	String name;
	EGeneralData eGeneralData = new EGeneralData();

	boolean var = false;
	eGeneralData = eGeneralDataRepos.findOne(user.getUsername());
	name = eGeneralData.getSurname() + " " + eGeneralData.getName();
	Calendar cal = new GregorianCalendar();
	int mount = cal.get(Calendar.MONTH) + 1;
	String lien;

	// Resource titlesResource = new
	// ClassPathResource("classpath:/WEB-INF/classes/links.properties");

	lien = pathProvider.path() + "documents/" + user.getUsername() + ".pdf";
	String now = "" + cal.get(Calendar.DAY_OF_MONTH) + "-" + mount + "-" + cal.get(Calendar.YEAR);
	setDate_embauche(contratMetier.embauche(user.getUsername()));
	if (name != null && eGeneralData.getCin() != null && eGeneralData.getJobeTitle() != null && now != null
		&& lien != null) {
	    travail.generate(name, eGeneralData.getCin(), eGeneralData.getJobeTitle(), getDate_embauche(), now, lien);
	    var = true;

	}
	return var;

    }

    public String getPdf() {
	return pdf;
    }

    public void setPdf(String pdf) {
	this.pdf = pdf;
    }

    public String getDate_embauche() {
	return date_embauche;
    }

    public void setDate_embauche(String date_embauche) {
	this.date_embauche = date_embauche;
    }
    
    public EGeneralDataRepos geteGeneralDataRepos() {
	return eGeneralDataRepos;
    }

    public void seteGeneralDataRepos(EGeneralDataRepos eGeneralDataRepos) {
	this.eGeneralDataRepos = eGeneralDataRepos;
    }

    public userController getUser() {
        return user;
    }

    public void setUser(userController user) {
        this.user = user;
    }

    public attestationTravail getTravail() {
        return travail;
    }

    public void setTravail(attestationTravail travail) {
        this.travail = travail;
    }

    public PathProvider getPathProvider() {
        return pathProvider;
    }

    public void setPathProvider(PathProvider pathProvider) {
        this.pathProvider = pathProvider;
    }

    public ContratMetier getContratMetier() {
        return contratMetier;
    }

    public void setContratMetier(ContratMetier contratMetier) {
        this.contratMetier = contratMetier;
    }

}

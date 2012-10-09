/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wadia.view;

import java.text.DateFormatSymbols;
import java.util.Calendar;
import java.util.GregorianCalendar;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;

import com.wadia.beans.EGeneralData;
import com.wadia.fileUpload.attestationSalaire;
import com.wadia.local.DateProvider;
import com.wadia.metier.ContratMetier;
import com.wadia.metier.PathProvider;
import com.wadia.metier.SalarySimpleMetier;
import com.wadia.metier.SalarySimplefillMetier;
import com.wadia.repos.EGeneralDataRepos;

/**
 *
 * @author toshiba
 */
@ManagedBean (name="attestationSalaireCtl")
@RequestScoped
public class attestationSalaireCtl {

    private userController user = new userController();
    private attestationSalaire salaire = new attestationSalaire();
    private String pdf;
    private String date_embauche;    
    private String salaireNet;  
    private PathProvider pathProvider = new PathProvider();
    private String month;
    private DateProvider dateProvider = new DateProvider();     
     
     @ManagedProperty(value="#{eGeneralDataRepos}")
     private EGeneralDataRepos eGeneralDataRepos; 
     @ManagedProperty(value="#{contratMetier}")
     private ContratMetier contratMetier;
     @ManagedProperty(value = "#{salarySimplefillMetier}")
     private SalarySimplefillMetier salarySimplefillMetier;

    @PostConstruct
    public void init() {
    	
        pdf = "documents/" + user.getUsername() +"_salary_"+dateProvider.getLastMonth()+".pdf";
        date_embauche = contratMetier.embauche(user.getUsername());
        salaireNet = ""+salarySimplefillMetier.listSalary(user.getUsername()).getMonthlyNetSalary();
        month = dateProvider.getLastMonth();

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
         
        lien =  pathProvider.path()+"documents/"+ user.getUsername()+"_salary_"+dateProvider.getLastMonth()+".pdf";
        String now = "" + cal.get(Calendar.DAY_OF_MONTH) + "-" + mount + "-" + cal.get(Calendar.YEAR);
        setDate_embauche(contratMetier.embauche(user.getUsername()));
        if (name != null && eGeneralData.getCin() != null && eGeneralData.getJobeTitle() != null && now != null && lien != null && salaireNet != null) {
            salaire.generate(name, eGeneralData.getCin(), eGeneralData.getJobeTitle(), getDate_embauche(), now, lien, salaireNet);

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

    public String getSalaireNet() {
        return salaireNet;
    }

    public void setSalaireNet(String salaireNet) {
        this.salaireNet = salaireNet;
    }

    public ContratMetier getContratMetier() {
        return contratMetier;
    }

    public void setContratMetier(ContratMetier contratMetier) {
        this.contratMetier = contratMetier;
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

    public attestationSalaire getSalaire() {
        return salaire;
    }

    public void setSalaire(attestationSalaire salaire) {
        this.salaire = salaire;
    }

    public PathProvider getPathProvider() {
        return pathProvider;
    }

    public void setPathProvider(PathProvider pathProvider) {
        this.pathProvider = pathProvider;
    }

	public String getMonth() {
		return month;
	}

	public void setMonth(String month) {
		this.month = month;
	}

	public DateProvider getDateProvider() {
		return dateProvider;
	}

	public void setDateProvider(DateProvider dateProvider) {
		this.dateProvider = dateProvider;
	}

	public SalarySimplefillMetier getSalarySimplefillMetier() {
		return salarySimplefillMetier;
	}

	public void setSalarySimplefillMetier(
			SalarySimplefillMetier salarySimplefillMetier) {
		this.salarySimplefillMetier = salarySimplefillMetier;
	}
}

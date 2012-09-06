/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wadia.view;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;

import com.wadia.beans.EGeneralData;
import com.wadia.local.fabrique;
import com.wadia.local.organizational;
import com.wadia.local.user;
import com.wadia.metier.orgHrMetier;
import com.wadia.repos.EGeneralDataRepos;

/**
 * 
 * @author toshiba
 */
@ManagedBean (name="editOrganizational")
@RequestScoped
public class editOrganizational {

    private String idToEdit;
    private organizational org = new organizational();
   
    private static String username;
    private static String country;
    private static String region;
    private static String lob;
    private static String Job_Title;
    private static String Status;
    private static String Grade;
    private static String Ladder;
    private static String flm;
    private static String HlineManager;
    private static String Terce;
   
    @ManagedProperty(value = "#{orgHrMetier}")
    private orgHrMetier orgHrMetier;
    @ManagedProperty(value = "#{eGeneralDataRepos}")
    private EGeneralDataRepos eGeneralDataRepos;

    public editOrganizational() {
    }

    public String getIdToEdit() {
	return idToEdit;
    }

    public String save() {

	EGeneralData egd = new EGeneralData();
	egd = eGeneralDataRepos.findOne(username);
	System.out.println("in avant " + egd.getIesourcing());
	egd.setGrade(Grade);
	egd.setLadder(Ladder);
	egd.setCountry(country);
	egd.setRegion(region);
	egd.setJobeTitle(Job_Title);
	egd.setTercel(Terce);
	egd.setIesourcing(Status);
	eGeneralDataRepos.save(egd);
	return "EmpOraganizational?faces-redirect=true";

    }

    public void setIdToEdit(String idToEdit) {
	this.idToEdit = idToEdit;

	if (idToEdit != null) {

	    org = orgHrMetier.getbyusername(idToEdit);
	    System.out.println("username est : " + org.getUsername());
	    username = org.getUsername();
	    country = org.getCountry();
	    region = org.getRegion();
	    lob = org.getLob();
	    Job_Title = org.getJob_Title();
	    Status = org.getStatus();
	    Grade = org.getGrade();
	    Ladder = org.getLadder();
	    flm = org.getFlm();
	    HlineManager = org.getHlineManager();
	    Terce = org.getTerce();
	}
    }

    public organizational getOrg() {
	return org;
    }

    public void setOrg(organizational org) {
	this.org = org;
    }

    public String getCountry() {
	return country;
    }

    public void setCountry(String country) {
	this.country = country;
    }

    public String getRegion() {
	return region;
    }

    public void setRegion(String region) {
	this.region = region;
    }

    public String getLob() {
	return lob;
    }

    public void setLob(String lob) {
	this.lob = lob;
    }

    public String getJob_Title() {
	return Job_Title;
    }

    public void setJob_Title(String Job_Title) {
	this.Job_Title = Job_Title;
    }

    public String getStatus() {
	return Status;
    }

    public void setStatus(String Status) {
	this.Status = Status;
    }

    public String getGrade() {
	return Grade;
    }

    public void setGrade(String Grade) {
	this.Grade = Grade;
    }

    public String getLadder() {
	return Ladder;
    }

    public void setLadder(String Ladder) {
	this.Ladder = Ladder;
    }

    public String getFlm() {
	return flm;
    }

    public void setFlm(String flm) {
	this.flm = flm;
    }

    public String getHlineManager() {
	return HlineManager;
    }

    public void setHlineManager(String HlineManager) {
	this.HlineManager = HlineManager;
    }

    public String getTerce() {
	return Terce;
    }

    public void setTerce(String Terce) {
	this.Terce = Terce;
    }

    public String getUsername() {
	return username;
    }

    public void setUsername(String username) {
	this.username = username;
    }

    public List<user> getusernames() {

	fabrique fab = new fabrique();

	return fab.getUsernameList();

    }
    
    public EGeneralDataRepos geteGeneralDataRepos() {
	return eGeneralDataRepos;
    }

    public void seteGeneralDataRepos(EGeneralDataRepos eGeneralDataRepos) {
	this.eGeneralDataRepos = eGeneralDataRepos;
    }

    public orgHrMetier getOrgHrMetier() {
        return orgHrMetier;
    }

    public void setOrgHrMetier(orgHrMetier orgHrMetier) {
        this.orgHrMetier = orgHrMetier;
    }

}

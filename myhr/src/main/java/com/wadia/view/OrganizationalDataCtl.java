/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wadia.view;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.ViewScoped;

import com.wadia.beans.EGeneralData;
import com.wadia.repos.EGeneralDataRepos;

/**
 * 
 * @author wadi3
 */
@ManagedBean
@RequestScoped
public class OrganizationalDataCtl extends BaseBean implements Serializable{


    private static final long serialVersionUID = 1L;
    private String Country;
    private String Region;
    private String IEsourcing;
    private String jobe_title;
    private String Grade;
    private String Ladder;

    private userController user = new userController();
   
    @ManagedProperty(value = "#{eGeneralDataRepos}")
    private EGeneralDataRepos eGeneralDataRepos;

    private EGeneralData eGeneralData;

    @PostConstruct
    public void init() {

	eGeneralData = eGeneralDataRepos.findOne(user.getUsername());
	Country = eGeneralData.getCountry();
	Region = eGeneralData.getRegion();
	IEsourcing = eGeneralData.getIesourcing();
	jobe_title = eGeneralData.getJobeTitle();
	Grade = eGeneralData.getGrade();
	Ladder = eGeneralData.getLadder();

    }

    public String getCountry() {
	return Country;
    }

    public void setCountry(String Country) {
	this.Country = Country;
    }

    public String getRegion() {
	return Region;
    }

    public void setRegion(String Region) {
	this.Region = Region;
    }

    public String getIEsourcing() {
	return IEsourcing;
    }

    public void setIEsourcing(String IEsourcing) {
	this.IEsourcing = IEsourcing;
    }

    public String getJobe_title() {
	return jobe_title;
    }

    public void setJobe_title(String jobe_title) {
	this.jobe_title = jobe_title;
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
    

    public EGeneralData geteGeneralData() {
        return eGeneralData;
    }

    public void seteGeneralData(EGeneralData eGeneralData) {
        this.eGeneralData = eGeneralData;
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
    
    

}

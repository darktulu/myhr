/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wadia.view;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;

import com.wadia.beans.EGeneralData;
import com.wadia.beans.ELData;
import com.wadia.metier.AffectationMetier;
import com.wadia.metier.TeamCalendarMetier;
import com.wadia.repos.AffectationRepos;

/**
 * 
 * @author toshiba
 */
@ManagedBean (name="MyReportsCalendar")
@RequestScoped
public class MyReportsCalendar {

   
    private List<EGeneralData> listReports = new ArrayList<EGeneralData>();
    private userController user = new userController();
    private List<ELData> list = new ArrayList<ELData>();
    private List<String> myReportsUsernames;
    
    @ManagedProperty(value = "#{affectationMetier}")
    private AffectationMetier affectationMetier;
    @ManagedProperty(value = "#{affectationRepos}")
    private AffectationRepos affectationRepos;
    @ManagedProperty(value = "#{teamCalendarMetier}")
    private TeamCalendarMetier teamCalendarMetier;
    
    @PostConstruct
    public void init() {

	// here we get the list of my reports
	myReportsUsernames = affectationRepos.MyReportsList(user.getUsername());
	list  = teamCalendarMetier.MyReports(myReportsUsernames);

    }

    public List<EGeneralData> getListReports() {
	return listReports;
    }

    public void setListReports(List<EGeneralData> listReports) {
	this.listReports = listReports;
    }

    public List<ELData> getList() {

	return list;
    }

    public void setList(List<ELData> list) {
	this.list = list;
    }

    public AffectationMetier getAffectationMetier() {
	return affectationMetier;
    }

    public void setAffectationMetier(AffectationMetier affectationMetier) {
	this.affectationMetier = affectationMetier;
    }

    public userController getUser() {
	return user;
    }

    public void setUser(userController user) {
	this.user = user;
    }

    public List<String> getMyReportsUsernames() {
	return myReportsUsernames;
    }

    public void setMyReportsUsernames(List<String> myReportsUsernames) {
	this.myReportsUsernames = myReportsUsernames;
    }

    public AffectationRepos getAffectationRepos() {
	return affectationRepos;
    }

    public void setAffectationRepos(AffectationRepos affectationRepos) {
	this.affectationRepos = affectationRepos;
    }

    public TeamCalendarMetier getTeamCalendarMetier() {
        return teamCalendarMetier;
    }

    public void setTeamCalendarMetier(TeamCalendarMetier teamCalendarMetier) {
        this.teamCalendarMetier = teamCalendarMetier;
    }

}

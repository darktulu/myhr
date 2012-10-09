package com.wadia.view;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.faces.event.ActionEvent;

import org.primefaces.event.DateSelectEvent;
import org.primefaces.event.ScheduleEntryMoveEvent;
import org.primefaces.event.ScheduleEntrySelectEvent;
import org.primefaces.model.DefaultScheduleEvent;
import org.primefaces.model.DefaultScheduleModel;
import org.primefaces.model.LazyScheduleModel;
import org.primefaces.model.ScheduleEvent;
import org.primefaces.model.ScheduleModel;

import com.wadia.beans.EGeneralData;
import com.wadia.beans.ELData;
import com.wadia.metier.AffectationMetier;
import com.wadia.metier.TeamCalendarMetier;
import com.wadia.repos.AffectationRepos;

@ManagedBean (name="ScheduleController")
@ViewScoped
public class ScheduleController implements Serializable{

    private ScheduleModel eventModel;
	
	private LazyScheduleModel lazyEventModel;

	private ScheduleEvent event = new DefaultScheduleEvent();
	
	private String theme;
	
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
		eventModel = new DefaultScheduleModel();
		myReportsUsernames = affectationRepos.MyReportsList(user.getUsername());
		list  = teamCalendarMetier.MyReports(myReportsUsernames);
		for(ELData leave : list){
		
			eventModel.addEvent(new DefaultScheduleEvent("Leave for "+leave.getResurceId()+" Status : "+leave.getStatus(), leave.getLeaveStartDate(), leave.getLeaveEndDate()));
		    System.out.println("Date :"+leave.getLeaveStartDate());
		}
		};
	


	public ScheduleModel getLazyEventModel() {
		return lazyEventModel;
	}


	public ScheduleModel getEventModel() {
		return eventModel;
	}


	public void setEventModel(ScheduleModel eventModel) {
		this.eventModel = eventModel;
	}


	public ScheduleEvent getEvent() {
		return event;
	}


	public void setEvent(ScheduleEvent event) {
		this.event = event;
	}


	public String getTheme() {
		return theme;
	}


	public void setTheme(String theme) {
		this.theme = theme;
	}


	public void setLazyEventModel(LazyScheduleModel lazyEventModel) {
		this.lazyEventModel = lazyEventModel;
	}


	public List<EGeneralData> getListReports() {
		return listReports;
	}


	public void setListReports(List<EGeneralData> listReports) {
		this.listReports = listReports;
	}


	public userController getUser() {
		return user;
	}


	public void setUser(userController user) {
		this.user = user;
	}


	public List<ELData> getList() {
		return list;
	}


	public void setList(List<ELData> list) {
		this.list = list;
	}


	public List<String> getMyReportsUsernames() {
		return myReportsUsernames;
	}


	public void setMyReportsUsernames(List<String> myReportsUsernames) {
		this.myReportsUsernames = myReportsUsernames;
	}


	public AffectationMetier getAffectationMetier() {
		return affectationMetier;
	}


	public void setAffectationMetier(AffectationMetier affectationMetier) {
		this.affectationMetier = affectationMetier;
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

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wadia.view;

import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.ViewScoped;

import com.wadia.beans.EGeneralData;
import com.wadia.beans.ELData;
import com.wadia.metier.AffectationMetier;
import com.wadia.metier.TeamCalendarMetier;
import com.wadia.repos.AffectationRepos;
import com.wadia.repos.EGeneralDataRepos;
import com.wadia.service.impl.MyReportClendarService;

/**
 * 
 * @author toshiba
 */
@ManagedBean (name="MyReportsCalendar")
@ViewScoped
public class MyReportsCalendar implements Serializable {

   
    private AffectationMetier affectationMetier() {
        return SpringJSFUtil.getBean("affectationMetier");
    }
    
    private AffectationRepos affectationRepos() {
        return SpringJSFUtil.getBean("affectationRepos");
    }
    
    private TeamCalendarMetier teamCalendarMetier() {
        return SpringJSFUtil.getBean("teamCalendarMetier");
    }
    
    private MyReportClendarService myReportClendarService() {
        return SpringJSFUtil.getBean("myReportClendarService");
    }
    
    private EGeneralDataRepos eGeneralDataRepos() {
        return SpringJSFUtil.getBean("eGeneralDataRepos");
    }
	
	
	private List<EGeneralData> listReports = new ArrayList<EGeneralData>();
    private userController user = new userController();
    private List<ELData> list = new ArrayList<ELData>();
    private List<String> myReportsUsernames;
    private Integer Month = 0;
    private Integer Year = 2012;
    private List<Integer> listDays = new ArrayList<Integer>();
    


  
    
    @PostConstruct
    public void init() {

	 // here we get the list of my reports
	 myReportsUsernames = affectationRepos().MyReportsList(user.getUsername());
	

    }
    
    
    public String ColorProvider(String username, int day) throws ParseException{
    	
    	String type = "W";
    	
        Calendar calendar = new GregorianCalendar();
        //calendar.set(Year, Month, day);
        calendar.set(Year, Month, day, 0, 0, 0);
        
        Date date = calendar.getTime();
       
        SimpleDateFormat format = new SimpleDateFormat("yyyy/MM/dd");
        String dateF = format.format(date);
        Date date2 = format.parse(dateF);
        
       // System.out.println("date "+date2);
    	
    	if(myReportClendarService().isJustifiedAbsence(username,date2)) type = "AJ"; //TODO
    	if(myReportClendarService().isNonJustifiedAbsence(username,date2)) type = "ANJ"; //TODO
    	if(myReportClendarService().isPlanned(username, date2)) type = "P"; //TODO
    	if(myReportClendarService().isTaken(username, date2)) type = "T"; //TODO
    	//if(myReportClendarService().isOngoing(username)) type = "O"; //TODO
    	
    	
    	return type;
    	
    }
    
    public void generatedays(){
    	//System.out.println("month : "+Month );
    	listDays.clear();
    	for(int i=1 ; i<=myReportClendarService().monthprovider(Month) ; i++)	{
    		listDays.add(i);
        }
    	
    }
    
    public String fullNameProvider(String username){
    	
    	return eGeneralDataRepos().findOne(username).getSurname()+" "+eGeneralDataRepos().findOne(username).getName();
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

	public Integer getMonth() {
		return Month;
	}

	public void setMonth(Integer month) {
		Month = month;
	}

	public Integer getYear() {
		return Year;
	}

	public void setYear(Integer year) {
		Year = year;
	}

	public List<Integer> getListDays() {
		return listDays;
	}

	public void setListDays(List<Integer> listDays) {
		this.listDays = listDays;
	}



}

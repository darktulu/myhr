/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wadia.view;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;

import com.wadia.beans.EGeneralData;
import com.wadia.beans.ELData;
import com.wadia.metier.LeavesMetier;
import com.wadia.repos.EGeneralDataRepos;
import com.wadia.repos.ELDataRepos;

/**
 * 
 * @author toshiba
 */

@ManagedBean
@RequestScoped
public class LeaveControlCtl {

    @ManagedProperty(value = "elDataRepos")
    private ELDataRepos elDataRepos;

    private static String name;
    private static String surname;
    private static String username;
    private static ELData data = new ELData();
    private static List<ELData> dataList = new ArrayList<ELData>();
    private String toEdit = null;
    
    @ManagedProperty(value = "#{leavesMetier}")
    private LeavesMetier leavesMetier;
    private String userToApprove;
    private int leveToApprove;
   
    @ManagedProperty(value = "#{eGeneralDataRepos}")
    private EGeneralDataRepos eGeneralDataRepos;
    @ManagedProperty(value = "#{eLDataRepos}")
    private ELDataRepos eLDataRepos;

    
    public void update() {

	String value = null;

	for (ELData el : dataList) {
	    value = el.getResurceId();
	}

	dataList = leavesMetier.findByUsername(value);

    }

    public ELData getData() {
	return data;
    }

    public void setData(ELData data) {
	this.data = data;
    }

    public String getToEdit() {
	return toEdit;
    }

    public void setToEdit(String toEdit) {
	this.toEdit = toEdit;

	if (toEdit != null) {
	    dataList = null;
	    dataList = leavesMetier.findByApprovedPM(toEdit);
	    EGeneralData eGeneralData = new EGeneralData();
	    eGeneralData = eGeneralDataRepos.findOne(toEdit);
	    name = eGeneralData.getName();
	    surname = eGeneralData.getSurname();
	    username = eGeneralData.getResurceId();
	    if (dataList == null) {
		List<ELData> transcient = new ArrayList<ELData>();
		dataList = transcient;
	    }

	}
    }

    public String getName() {
	return name;
    }

    public void setName(String name) {
	this.name = name;
    }

    public String getSurname() {
	return surname;
    }

    public void setSurname(String surname) {
	this.surname = surname;
    }

    public String getUsername() {
	return username;
    }

    public void setUsername(String username) {
	this.username = username;
    }

    public List<ELData> getDataList() {
	return dataList;
    }

    public void setDataList(List<ELData> dataList) {
	this.dataList = dataList;
    }

    public String getUserToApprove() {
	return userToApprove;
    }

    public void setUserToApprove(String userToApprove) {
	this.userToApprove = userToApprove;
    }

    public int getLeveToApprove() {
	return leveToApprove;
    }

    public void setLeveToApprove(int leveToApprove) {
	this.leveToApprove = leveToApprove;
	if (leveToApprove != 0) {

	    data = elDataRepos.findOne(leveToApprove);
	    System.out.println("" + data.toString());

	}
    }

    public void approuve() {

	
	ELData eld = new ELData();
	    eld = eLDataRepos.findOne(leveToApprove);
	    eld.setStatus("Approved By HR");
	    eLDataRepos.save(eld);
	System.out.println("i try to approuve !!");
    }

    public ELDataRepos getElDataRepos() {
	return elDataRepos;
    }

    public void setElDataRepos(ELDataRepos elDataRepos) {
	this.elDataRepos = elDataRepos;
    }
    
    public EGeneralDataRepos geteGeneralDataRepos() {
	return eGeneralDataRepos;
    }

    public void seteGeneralDataRepos(EGeneralDataRepos eGeneralDataRepos) {
	this.eGeneralDataRepos = eGeneralDataRepos;
    }

    public LeavesMetier getLeavesMetier() {
        return leavesMetier;
    }

    public void setLeavesMetier(LeavesMetier leavesMetier) {
        this.leavesMetier = leavesMetier;
    }

    public ELDataRepos geteLDataRepos() {
        return eLDataRepos;
    }

    public void seteLDataRepos(ELDataRepos eLDataRepos) {
        this.eLDataRepos = eLDataRepos;
    }

}

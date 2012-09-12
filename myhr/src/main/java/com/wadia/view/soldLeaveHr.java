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
import com.wadia.beans.Soldleave;
import com.wadia.repos.EGeneralDataRepos;
import com.wadia.repos.SoldleaveRepos;

/**
 * 
 * @author toshiba
 */
@ManagedBean (name="soldLeaveHr")
@RequestScoped
public class soldLeaveHr {

    private static List<Soldleave> listSold = new ArrayList<Soldleave>();
    @ManagedProperty(value = "#{soldleaveRepos}")
    private SoldleaveRepos soldleaveRepos;
    private static String name;
    private static String surname;
    private static String username;
    private String toEdit;
    @ManagedProperty(value = "#{eGeneralDataRepos}")
    private EGeneralDataRepos eGeneralDataRepos;

    public EGeneralDataRepos geteGeneralDataRepos() {
	return eGeneralDataRepos;
    }

    public void seteGeneralDataRepos(EGeneralDataRepos eGeneralDataRepos) {
	this.eGeneralDataRepos = eGeneralDataRepos;
    }

    public soldLeaveHr() {
    }

    public void update() {
	listSold = soldleaveRepos.findByUsername(username);
    }

    public List<Soldleave> getListSold() {
	return listSold;
    }

    public void setListSold(List<Soldleave> listSold) {
	this.listSold = listSold;
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

    public String getToEdit() {
	return toEdit;
    }

    public void setToEdit(String toEdit) {
	this.toEdit = toEdit;
	if (toEdit != null) {

	    listSold = soldleaveRepos.findByUsername(toEdit);
	    EGeneralData eGeneralData = new EGeneralData();
	    eGeneralData = eGeneralDataRepos.findOne(toEdit);
	    name = eGeneralData.getName();
	    surname = eGeneralData.getSurname();
	    username = eGeneralData.getResurceId();

	}
    }

	public SoldleaveRepos getSoldleaveRepos() {
		return soldleaveRepos;
	}

	public void setSoldleaveRepos(SoldleaveRepos soldleaveRepos) {
		this.soldleaveRepos = soldleaveRepos;
	}

}

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wadia.view;

import java.util.Date;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;

import com.wadia.beans.EEducationData;
import com.wadia.repos.EEducationDataRepos;

/**
 * 
 * @author wadi3
 */
@ManagedBean (name="EEducationNewCtl")
@RequestScoped
public class EEducationNewCtl {
    
    private EEducationData eEducationData = new EEducationData();

    @ManagedProperty(value = "#{eEducationDataRepos}")
    private EEducationDataRepos eEducationDataRepos;
    private userController user = new userController();


    public String Save() {
	eEducationData.setResurceId(user.getUsername());
	eEducationDataRepos.save(eEducationData);
	return "ok";
    }


    /**
     * @return the eEducationData
     */
    public EEducationData geteEducationData() {
	return eEducationData;
    }

    /**
     * @param eEducationData
     *            the eEducationData to set
     */
    public void seteEducationData(EEducationData eEducationData) {
	this.eEducationData = eEducationData;
    }

    public EEducationDataRepos geteEducationDataRepos() {
	return eEducationDataRepos;
    }

    public void seteEducationDataRepos(EEducationDataRepos eEducationDataRepos) {
	this.eEducationDataRepos = eEducationDataRepos;
    }

    public userController getUser() {
	return user;
    }

    public void setUser(userController user) {
	this.user = user;
    }

}

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

import com.wadia.beans.ELData;
import com.wadia.metier.LeavesMetier;
import com.wadia.repos.ELDataRepos;

/**
 * 
 * @author toshiba
 */
@ManagedBean (name="viewLeaveCtl")
@RequestScoped
public class viewLeaveCtl {

    private List<ELData> eLData = new ArrayList<ELData>();
    private static ELData lData = new ELData();
    private int idToEdit = 0;
   
    private userController usercontroller = new userController();
    @ManagedProperty(value = "#{leavesMetier}")
    private LeavesMetier leavesMetier;
    @ManagedProperty(value = "#{eLDataRepos}")
    private ELDataRepos eLDataRepos;


    public void update() {
	eLData = leavesMetier.findByUsername(usercontroller.getUsername());
    }

    public List<ELData> geteLData() {
	return eLData;
    }

    public void seteLData(List<ELData> eLData) {
	this.eLData = eLData;
    }

    public ELData getlData() {
	return lData;
    }

    public void setlData(ELData lData) {
	this.lData = lData;
    }

    public int getIdToEdit() {
	return idToEdit;
    }

    public void setIdToEdit(int idToEdit) {
	this.idToEdit = idToEdit;

	if (idToEdit != 0) {
	    lData = eLDataRepos.findOne(idToEdit);

	}
    }

    public userController getUsercontroller() {
	return usercontroller;
    }

    public void setUsercontroller(userController usercontroller) {
	this.usercontroller = usercontroller;
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

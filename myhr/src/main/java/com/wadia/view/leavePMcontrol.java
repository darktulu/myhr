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
import com.wadia.metier.myTeamMetier;
import com.wadia.repos.EGeneralDataRepos;
import com.wadia.repos.ELDataRepos;

/**
 * 
 * @author toshiba
 */
@ManagedBean (name="leavePMcontrol")
@RequestScoped
public class leavePMcontrol {

    private static String name;
    private static String surname;
    private static String username;
    private static String idphoto;
    private static ELData data = new ELData();
    private static List<ELData> dataList = new ArrayList<ELData>();
   
    @ManagedProperty(value = "#{myTeamMetier}")
    private  myTeamMetier myTeamMetier; 
    @ManagedProperty(value = "#{eGeneralDataRepos}")
    private EGeneralDataRepos eGeneralDataRepos;


    private String toEdit = null;
    private String userToApprove;
    private int leveToApprove;

    public String getUserToApprove() {
	return userToApprove;
    }

    public void setUserToApprove(String userToApprove) {
	this.userToApprove = userToApprove;

	if (userToApprove != null) {
	    EGeneralData eg = new EGeneralData();
	    eg = eGeneralDataRepos.findOne(userToApprove);
	    name = eg.getName();
	    surname = eg.getSurname();
	    username = eg.getResurceId();
	    idphoto = eg.getIdPhoto();
	   
	    dataList = myTeamMetier.myTeamLeavesWaiting(userToApprove);

	}

    }

    public int getLeveToApprove() {
	return leveToApprove;
    }

    public void setLeveToApprove(int leveToApprove) {
	this.leveToApprove = leveToApprove;
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
    
    public EGeneralDataRepos geteGeneralDataRepos() {
	return eGeneralDataRepos;
    }

    public void seteGeneralDataRepos(EGeneralDataRepos eGeneralDataRepos) {
	this.eGeneralDataRepos = eGeneralDataRepos;
    }

    public static ELData getData() {
        return data;
    }

    public static void setData(ELData data) {
        leavePMcontrol.data = data;
    }

    public myTeamMetier getMyTeamMetier() {
        return myTeamMetier;
    }

    public void setMyTeamMetier(myTeamMetier myTeamMetier) {
        this.myTeamMetier = myTeamMetier;
    }

    public String getToEdit() {
        return toEdit;
    }

    public void setToEdit(String toEdit) {
        this.toEdit = toEdit;
    }

	public String getIdphoto() {
		return idphoto;
	}

	public void setIdphoto(String idphoto) {
		this.idphoto = idphoto;
	}

}

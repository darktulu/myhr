/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wadia.view;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;

import com.wadia.beans.EGeneralData;
import com.wadia.beans.ELData;
import com.wadia.local.sold;
import com.wadia.metier.LeavesMetier;
import com.wadia.metier.SoldleaveMetier;
import com.wadia.repos.EGeneralDataRepos;
import com.wadia.repos.ELDataRepos;

/**
 * 
 * @author toshiba
 */
@ManagedBean (name="LeaveSummCtl")
@RequestScoped
public class LeaveSummCtl {

    private static int consom = 0;
    private static List<ELData> leavesListsolde = new ArrayList<ELData>();
    private static List<ELData> eLData = new ArrayList<ELData>();
    private static String name;
    private static String surname;
    private static String username;
    private static String idphoto;
   
   
    private static List<sold> list = new ArrayList<sold>();
    private String toEdit;
    private List<ELData> leavesListsoldes = new ArrayList<ELData>();
    private HashSet<Integer> years = new HashSet<Integer>();
    
    @ManagedProperty(value = "#{leavesMetier}")
    private LeavesMetier leavesMetier;
    @ManagedProperty(value = "#{eLDataRepos}")
    private ELDataRepos eLDataRepos;
    @ManagedProperty(value = "#{eGeneralDataRepos}")
    private EGeneralDataRepos eGeneralDataRepos;
    @ManagedProperty(value = "#{soldleaveMetier}")
    private SoldleaveMetier soldleaveMetier;




    public void upListSold() {

	 soldleaveMetier.updateListSold();

    }

    /**
     * @return the leavesListsolde
     */
    public List<ELData> getLeavesListsolde() {
	return leavesListsolde;
    }

    /**
     * @param leavesListsolde
     *            the leavesListsolde to set
     */
    public void setLeavesListsolde(List<ELData> leavesListsolde) {
	this.leavesListsolde = leavesListsolde;
    }

    /**
     * @return the solde
     */
    /**
     * @return the leavesListsoldes
     */
    public List<ELData> getLeavesListsoldes() {
	return leavesListsoldes;
    }

    /**
     * @param leavesListsoldes
     *            the leavesListsoldes to set
     */
    public void setLeavesListsoldes(List<ELData> leavesListsoldes) {
	this.leavesListsoldes = leavesListsoldes;
    }

    /**
     * @return the consom
     */
    public int getConsom() {
	return consom;
    }

    /**
     * @param consom
     *            the consom to set
     */
    public void setConsom(int consom) {
	this.consom = consom;
    }

    public String getToEdit() {
	return toEdit;
    }

    public void setToEdit(String toEdit) {
	this.toEdit = toEdit;
	eLData.clear();
	list.clear();
	if (toEdit != null) {
	    EGeneralData eGeneralData = new EGeneralData();
	    eGeneralData = eGeneralDataRepos.findOne(toEdit);
	    name = eGeneralData.getName();
	    surname = eGeneralData.getSurname();
	    username = eGeneralData.getResurceId();
	    idphoto = eGeneralData.getIdPhoto();
	    soldleaveMetier.updateSoldProvider(username);
	    list = soldleaveMetier.findbyusername(toEdit);
	    eLData = eLDataRepos.findByUsername(username);
	    

	}

    }

    public SoldleaveMetier getSoldleaveMetier() {
	return soldleaveMetier;
    }

    public void setSoldleaveMetier(SoldleaveMetier soldleaveMetier) {
	this.soldleaveMetier = soldleaveMetier;
    }

    public LeavesMetier getLeavesMetier() {
	return leavesMetier;
    }

    public void setLeavesMetier(LeavesMetier leavesMetier) {
	this.leavesMetier = leavesMetier;
    }

    public HashSet<Integer> getYears() {
	return years;
    }

    public void setYears(HashSet<Integer> years) {
	this.years = years;
    }


    public List<ELData> geteLData() {
	return eLData;
    }

    public void seteLData(List<ELData> eLData) {
	this.eLData = eLData;
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

    public List<sold> getList() {
	return list;
    }

    public void setList(List<sold> list) {
	this.list = list;
    }
    

    public EGeneralDataRepos geteGeneralDataRepos() {
	return eGeneralDataRepos;
    }

    public void seteGeneralDataRepos(EGeneralDataRepos eGeneralDataRepos) {
	this.eGeneralDataRepos = eGeneralDataRepos;
    }

    public ELDataRepos geteLDataRepos() {
        return eLDataRepos;
    }

    public void seteLDataRepos(ELDataRepos eLDataRepos) {
        this.eLDataRepos = eLDataRepos;
    }

	public String getIdphoto() {
		return idphoto;
	}

	public void setIdphoto(String idphoto) {
		this.idphoto = idphoto;
	}
}

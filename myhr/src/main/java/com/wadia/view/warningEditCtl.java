/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wadia.view;

import java.util.Date;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;

import com.wadia.beans.EWarningData;
import com.wadia.repos.EWarningDataRepos;

/**
 * 
 * @author ITR2012
 */
@ManagedBean (name="warningEditCtl")
@RequestScoped
public class warningEditCtl {
    private static Integer warningId;
    private static Date date;
    private static String username;
    private static String warningType;
    private static String sevirity;
    private static String raison;
    private static Integer IdToEdit;
    private Integer idToDelete;
    private static EWarningData data = new EWarningData();
   
    @ManagedProperty(value = "#{eWarningDataRepos}")
    private EWarningDataRepos eWarningDataRepos;

    public warningEditCtl() {
    }

    /**
     * @return the warningId
     */
    public Integer getWarningId() {
	return warningId;
    }

    public String saveEdit() {
	EWarningData warning = new EWarningData();
	warning.setDate(date);
	warning.setRaison(raison);
	warning.setResurceId(username);
	warning.setSevirity(sevirity);
	warning.setWarningId(warningId);
	warning.setWarningType(warningType);
	eWarningDataRepos.save(warning);

	return "ok";
    }

    public String deleteWarning() {

	if (data != null) {

	    eWarningDataRepos.delete(data);
	}

	return "ok";

    }

    /**
     * @param warningId
     *            the warningId to set
     */
    public void setWarningId(Integer warningId) {
	this.warningId = warningId;
    }

    /**
     * @return the date
     */
    public Date getDate() {
	return date;
    }

    /**
     * @param date
     *            the date to set
     */
    public void setDate(Date date) {
	this.date = date;
    }

    /**
     * @return the warningType
     */
    public String getWarningType() {
	return warningType;
    }

    /**
     * @param warningType
     *            the warningType to set
     */
    public void setWarningType(String warningType) {
	this.warningType = warningType;
    }

    /**
     * @return the sevirity
     */
    public String getSevirity() {
	return sevirity;
    }

    /**
     * @param sevirity
     *            the sevirity to set
     */
    public void setSevirity(String sevirity) {
	this.sevirity = sevirity;
    }

    /**
     * @return the raison
     */
    public String getRaison() {
	return raison;
    }

    /**
     * @param raison
     *            the raison to set
     */
    public void setRaison(String raison) {
	this.raison = raison;
    }

    /**
     * @return the IdToEdit
     */
    public Integer getIdToEdit() {
	return IdToEdit;
    }

    /**
     * @param IdToEdit
     *            the IdToEdit to set
     */
    public void setIdToEdit(Integer IdToEdit) {
	this.IdToEdit = IdToEdit;
	if (IdToEdit != null) {
	    EWarningData eWarningData = new EWarningData();

	    eWarningData = eWarningDataRepos.findOne(IdToEdit);
	    warningId = eWarningData.getWarningId();
	    date = eWarningData.getDate();
	    username = eWarningData.getResurceId();
	    warningType = eWarningData.getWarningType();
	    sevirity = eWarningData.getSevirity();
	    raison = eWarningData.getRaison();

	}
    }

    /**
     * @return the username
     */
    public String getUsername() {
	return username;
    }

    /**
     * @param username
     *            the username to set
     */
    public void setUsername(String username) {
	this.username = username;
    }

    public Integer getIdToDelete() {
	return idToDelete;
    }

    public void setIdToDelete(Integer idToDelete) {
	this.idToDelete = idToDelete;

	if (idToDelete != null) {

	    data = eWarningDataRepos.findOne(idToDelete);

	}

    }

    public static EWarningData getData() {
        return data;
    }

    public static void setData(EWarningData data) {
        warningEditCtl.data = data;
    }

    public EWarningDataRepos geteWarningDataRepos() {
        return eWarningDataRepos;
    }

    public void seteWarningDataRepos(EWarningDataRepos eWarningDataRepos) {
        this.eWarningDataRepos = eWarningDataRepos;
    }

}

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wadia.view;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;

import com.wadia.beans.EGeneralData;
import com.wadia.beans.EWarningData;
import com.wadia.repos.EGeneralDataRepos;
import com.wadia.repos.EWarningDataRepos;

/**
 * 
 * @author ITR2012
 */
@ManagedBean
@RequestScoped
public class WarningDataHrCtl {

    private String resurceId;
    private Date date;
    private String warningType;
    private String sevirity;
    private String raison;
    private EWarningData eWarningData;
    @ManagedProperty(value = "#{eWarningDataRepos}")
    private EWarningDataRepos eWarningDataRepos;
    private List<String> usernames = new ArrayList();
    @ManagedProperty(value = "#{eGeneralDataRepos}")
    private EGeneralDataRepos eGeneralDataRepos;

    public EGeneralDataRepos geteGeneralDataRepos() {
	return eGeneralDataRepos;
    }

    public void seteGeneralDataRepos(EGeneralDataRepos eGeneralDataRepos) {
	this.eGeneralDataRepos = eGeneralDataRepos;
    }

    public String SaveWarn() {
	eWarningData = new EWarningData(resurceId, date, warningType, sevirity, raison);
	eWarningDataRepos.save(eWarningData);

	return "ok";
    }

    public List<String> usernameList() {
	List<EGeneralData> eGenList = new ArrayList<EGeneralData>();
	eGenList = eGeneralDataRepos.findAll();
	for (EGeneralData gen : eGenList) {
	    usernames.add(gen.getResurceId());
	}
	return usernames;
    }

    /**
     * @return the resurceId
     */
    public String getResurceId() {
	return resurceId;
    }

    /**
     * @param resurceId
     *            the resurceId to set
     */
    public void setResurceId(String resurceId) {
	this.resurceId = resurceId;
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
     * @return the eWarningData
     */
    public EWarningData geteWarningData() {
	return eWarningData;
    }

    /**
     * @param eWarningData
     *            the eWarningData to set
     */
    public void seteWarningData(EWarningData eWarningData) {
	this.eWarningData = eWarningData;
    }

    public List<String> getUsernames() {
	return usernames;
    }

    public void setUsernames(List<String> usernames) {
	this.usernames = usernames;
    }

    public EWarningDataRepos geteWarningDataRepos() {
	return eWarningDataRepos;
    }

    public void seteWarningDataRepos(EWarningDataRepos eWarningDataRepos) {
	this.eWarningDataRepos = eWarningDataRepos;
    }
}

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

import com.wadia.beans.EContractData;
import com.wadia.beans.EGeneralData;
import com.wadia.repos.EContractDataRepos;
import com.wadia.repos.EGeneralDataRepos;

/**
 * 
 * @author wadi3
 */
@ManagedBean (name="ContratDataHrCtl")
@RequestScoped
public class ContratDataHrCtl {

    private Integer ContractID;
    private String username;
    private String ContractType;
    private Date HireDate;
    private Date StratDate;
    private Date EndDate;
    private String Stratut;
    private String Desciption;
    private EContractData eContractData;
    private List<String> usernames = new ArrayList();
   
    @ManagedProperty(value = "#{eContractDataRepos}")
    private EContractDataRepos eContractDataRepos;

    public EContractDataRepos geteContractDataRepos() {
	return eContractDataRepos;
    }

    public void seteContractDataRepos(EContractDataRepos eContractDataRepos) {
	this.eContractDataRepos = eContractDataRepos;
    }

    @ManagedProperty(value = "#{eGeneralDataRepos}")
    private EGeneralDataRepos eGeneralDataRepos;

    public EGeneralDataRepos geteGeneralDataRepos() {
	return eGeneralDataRepos;
    }

    public void seteGeneralDataRepos(EGeneralDataRepos eGeneralDataRepos) {
	this.eGeneralDataRepos = eGeneralDataRepos;
    }

    public String saveContrat() {
	// eContractData = new EContractData(ContractID, username, ContractType,
	// HireDate, StratDate, EndDate, Stratut, Desciption);
	eContractData = new EContractData(username, ContractType, HireDate, StratDate, EndDate, Stratut, Desciption);
	if (KO(eContractData)) {
	    eContractDataRepos.save(eContractData);
	}

	return "OK";
    }

    public boolean KO(EContractData contact) {

	boolean locker = true;

	List<EContractData> datas = new ArrayList<EContractData>();
	datas = eContractDataRepos.findAll();
	for (EContractData cont : datas) {

	    if (cont.getResurceId().equals(contact.getResurceId())
		    && cont.getContractStartDate().equals(contact.getContractStartDate())
		    && cont.getContractType().equals(contact.getContractType())
		    && cont.getContractStatus().equals(contact.getContractStatus())) {

		locker = false;
	    }

	}

	return locker;

    }

    /**
     * @return the ContractID
     */
    public Integer getContractID() {
	return ContractID;
    }

    public List<String> getUsernameList() {
	List<EGeneralData> eGenList = new ArrayList<EGeneralData>();
	eGenList = eGeneralDataRepos.findAll();
	for (EGeneralData gen : eGenList) {
	    usernames.add(gen.getResurceId());
	}
	return usernames;
    }

    /**
     * @param ContractID
     *            the ContractID to set
     */
    public void setContractID(Integer ContractID) {
	this.ContractID = ContractID;
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

    /**
     * @return the ContractType
     */
    public String getContractType() {
	return ContractType;
    }

    /**
     * @param ContractType
     *            the ContractType to set
     */
    public void setContractType(String ContractType) {
	this.ContractType = ContractType;
    }

    /**
     * @return the HireDate
     */
    public Date getHireDate() {
	return HireDate;
    }

    /**
     * @param HireDate
     *            the HireDate to set
     */
    public void setHireDate(Date HireDate) {
	this.HireDate = HireDate;
    }

    /**
     * @return the StratDate
     */
    public Date getStratDate() {
	return StratDate;
    }

    /**
     * @param StratDate
     *            the StratDate to set
     */
    public void setStratDate(Date StratDate) {
	this.StratDate = StratDate;
    }

    /**
     * @return the EndDate
     */
    public Date getEndDate() {
	return EndDate;
    }

    /**
     * @param EndDate
     *            the EndDate to set
     */
    public void setEndDate(Date EndDate) {
	this.EndDate = EndDate;
    }

    /**
     * @return the Stratut
     */
    public String getStratut() {
	return Stratut;
    }

    /**
     * @param Stratut
     *            the Stratut to set
     */
    public void setStratut(String Stratut) {
	this.Stratut = Stratut;
    }

    /**
     * @return the eContractData
     */
    public EContractData geteContractData() {
	return eContractData;
    }

    /**
     * @param eContractData
     *            the eContractData to set
     */
    public void seteContractData(EContractData eContractData) {
	this.eContractData = eContractData;
    }

    /**
     * @return the Desciption
     */
    public String getDesciption() {
	return Desciption;
    }

    /**
     * @param Desciption
     *            the Desciption to set
     */
    public void setDesciption(String Desciption) {
	this.Desciption = Desciption;
    }

    /**
     * @return the usernames
     */
    public List<String> getUsernames() {
	return usernames;
    }

    /**
     * @param usernames
     *            the usernames to set
     */
    public void setUsernames(List<String> usernames) {
	this.usernames = usernames;
    }
}

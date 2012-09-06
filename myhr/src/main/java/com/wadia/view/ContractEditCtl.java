/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wadia.view;

import java.util.Date;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;

import com.wadia.beans.EContractData;
import com.wadia.repos.EContractDataRepos;

/**
 * 
 * @author ITR2012
 */
@ManagedBean (name="ContractEditCtl")
@RequestScoped
public class ContractEditCtl {

    /**
     * @return the eContractData
     */
    private static Date ContratStratDate;
    private static Date contratEndDate;
    private static Date HireDate;
    private static String username;
    private static Integer ContractId;
    private static String ContratType;
    private static String ContratStatut;
    private static String description;
    private Integer toEditId = 0;
    @ManagedProperty(value = "#{eContractDataRepos}")
    private EContractDataRepos eContractDataRepos;

    public EContractDataRepos geteContractDataRepos() {
	return eContractDataRepos;
    }

    public void seteContractDataRepos(EContractDataRepos eContractDataRepos) {
	this.eContractDataRepos = eContractDataRepos;
    }

    private EContractData eContractData = new EContractData();

    // private EContractDataDao eContractDataDao = new EContractDataDao();
    public ContractEditCtl() {
	// System.out.println("here in Controller" + ContractId);
    }

    public String saveEdit() {

	EContractData contract = new EContractData();
	System.out.println("" + username + " " + ContractId + " " + ContratStratDate);
	if (username != null && ContractId != null && ContratStratDate != null) {
	    contract.setResurceId(username);
	    contract.setContractStartDate(ContratStratDate);
	    contract.setContractEndDate(contratEndDate);
	    contract.setContractType(ContratType);
	    contract.setContractStatus(ContratStatut);
	    contract.setHireDate(HireDate);
	    contract.setDescription(description);
	    contract.setContratId(ContractId);

	    eContractDataRepos.save(contract);
	}
	return "ok";
    }

    /**
     * @return the ContratStratDate
     */
    public Date getContratStratDate() {
	return ContratStratDate;
    }

    /**
     * @param ContratStratDate
     *            the ContratStratDate to set
     */
    public void setContratStratDate(Date ContratStratDate) {
	this.ContratStratDate = ContratStratDate;
    }

    /**
     * @return the contratEndDate
     */
    public Date getContratEndDate() {
	return contratEndDate;
    }

    /**
     * @param contratEndDate
     *            the contratEndDate to set
     */
    public void setContratEndDate(Date contratEndDate) {
	this.contratEndDate = contratEndDate;
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
     * @return the ContractId
     */
    /**
     * @return the ContratType
     */
    public String getContratType() {
	return ContratType;
    }

    /**
     * @param ContratType
     *            the ContratType to set
     */
    public void setContratType(String ContratType) {
	this.ContratType = ContratType;
    }

    /**
     * @return the ContratStatut
     */
    public String getContratStatut() {
	return ContratStatut;
    }

    /**
     * @param ContratStatut
     *            the ContratStatut to set
     */
    public void setContratStatut(String ContratStatut) {
	this.ContratStatut = ContratStatut;
    }

    /**
     * @return the IdToEdit
     */
    public Integer getToEditId() {
	return toEditId;
    }

    /**
     * @param IdToEdit
     *            the IdToEdit to set
     */
    public void setToEditId(Integer IdToEdit) {
	this.toEditId = IdToEdit;
	if (IdToEdit != 0) {

	    eContractData = eContractDataRepos.findOne(IdToEdit);
	    ContractId = eContractData.getContratId();
	    ContratStratDate = eContractData.getContractStartDate();
	    contratEndDate = eContractData.getContractEndDate();
	    HireDate = eContractData.getHireDate();
	    username = eContractData.getResurceId();
	    ContratType = eContractData.getContractType();
	    ContratStatut = eContractData.getContractStatus();
	    description = eContractData.getDescription();
	    System.out.println("here in the setter !! " + ContractId);
	    System.out.println(" sd :" + ContratStratDate);
	}

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

    public String getDescription() {
	return description;
    }

    public void setDescription(String description) {
	this.description = description;
    }

    public Integer getContractId() {
	return ContractId;
    }

    public void setContractId(Integer ContractId) {
	this.ContractId = ContractId;
    }
}

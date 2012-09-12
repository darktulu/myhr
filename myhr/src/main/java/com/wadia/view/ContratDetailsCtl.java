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

import com.wadia.beans.EContractData;
import com.wadia.metier.ContratMetier;
import com.wadia.repos.EContractDataRepos;

/**
 * 
 * @author wadi3
 */
@ManagedBean (name="ContratDetailsCtl")
@RequestScoped
public class ContratDetailsCtl {

    private static String IdToView;
    private static EContractData eContractData = new EContractData();
    @ManagedProperty(value = "#{eContractDataRepos}")
    private EContractDataRepos eContractDataRepos;
    @ManagedProperty(value = "#{contratMetier}")
    private ContratMetier contratMetier;


    private static List<EContractData> eContractDatas = new ArrayList<EContractData>();
   
    private Integer toEdit;
    private static EContractData contraToDelete = new EContractData();


    public void update() {
	if (IdToView != null) {
	    eContractData = contratMetier.getLastContrat(IdToView);
	    eContractDatas = contratMetier.contratHistory(IdToView);
	}

    }

    /**
     * @return the IdToView
     */
    public String getIdToView() {
	return IdToView;
    }

    /**
     * @param IdToView
     *            the IdToView to set
     */
    public void setIdToView(String IdToView) {
	this.IdToView = IdToView;
	if (IdToView != null) {
	    eContractData = contratMetier.getLastContrat(IdToView);
	    eContractDatas = contratMetier.contratHistory(IdToView);
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

    /**
     * @return the eContractDatas
     */
    public List<EContractData> geteContractDatas() {
	return eContractDatas;
    }

    /**
     * @param eContractDatas
     *            the eContractDatas to set
     */
    public void seteContractDatas(List<EContractData> eContractDatas) {
	this.eContractDatas = eContractDatas;
    }

    public Integer getToEdit() {
	return toEdit;
    }

    public void setToEdit(Integer toEdit) {
	this.toEdit = toEdit;
	if (toEdit != null) {

	    contraToDelete = eContractDataRepos.findOne(toEdit);

	}
    }

    public EContractData getContraToDelete() {
	return contraToDelete;
    }

    public void setContraToDelete(EContractData contraToDelete) {
	this.contraToDelete = contraToDelete;
    }

    public String delete() {

	if (contraToDelete != null) {

	    eContractDataRepos.delete(contraToDelete);

	}
	
	return "ContratHr?faces-redirect=true";

    }
    public EContractDataRepos geteContractDataRepos() {
	return eContractDataRepos;
    }

    public void seteContractDataRepos(EContractDataRepos eContractDataRepos) {
	this.eContractDataRepos = eContractDataRepos;
    }

    public ContratMetier getContratMetier() {
        return contratMetier;
    }

    public void setContratMetier(ContratMetier contratMetier) {
        this.contratMetier = contratMetier;
    }
}

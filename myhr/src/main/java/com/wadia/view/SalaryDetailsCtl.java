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

import com.wadia.beans.ESalaryData;
import com.wadia.metier.HistoSalaryMetier;
import com.wadia.metier.HistoSalaryfillMetier;
import com.wadia.metier.SalaryMetier;
import com.wadia.metier.SalarySimpleMetier;
import com.wadia.metier.SalarySimplefillMetier;
import com.wadia.repos.ESalaryDataRepos;

/**
 *
 * @author wadi3
 */
@ManagedBean(name="SalaryDetailsCtl")
@RequestScoped
public class SalaryDetailsCtl {

    private static String IdToView;
    @ManagedProperty(value="#{salarySimpleMetier}")
    private static SalarySimpleMetier salarySimpleMetier;
    @ManagedProperty(value="#{salarySimplefillMetier}")
    private SalarySimplefillMetier salarySimplefillMetier;
    @ManagedProperty(value="#{histoSalaryfillMetier}")
    private HistoSalaryfillMetier histoSalaryfillMetier;
   
    private static List<ESalaryData> esalaeyData = new ArrayList<ESalaryData>();
    private static List<HistoSalaryMetier> histoSalaryMetierListIndem = new ArrayList<HistoSalaryMetier>();
    private static List<HistoSalaryMetier> histoSalaryMetierListPrime = new ArrayList<HistoSalaryMetier>();
    private static List<HistoSalaryMetier> histoSalaryMetierListcharge = new ArrayList<HistoSalaryMetier>();
    
    @ManagedProperty(value="#{eSalaryDataRepos}")
    private ESalaryDataRepos eSalaryDataRepos;

    /**
     * @return the IdToView
     */
    public String getIdToView() {
        return IdToView;
    }

    /**
     * @param IdToView the IdToView to set
     */
    public void setIdToView(String IdToView) {
        this.IdToView = IdToView;
        if (IdToView != null) {
            salarySimpleMetier = salarySimplefillMetier.listSalary(IdToView);
            histoSalaryMetierListIndem = histoSalaryfillMetier.listHistoIndemnite(IdToView);
            histoSalaryMetierListPrime = histoSalaryfillMetier.listHistoPrime(IdToView);
            histoSalaryMetierListcharge = histoSalaryfillMetier.listHistoCharge(IdToView);
            esalaeyData = eSalaryDataRepos.findByUsername(IdToView);

        }
    }

    /**
     * @return the salarySimpleMetier
     */
    public SalarySimpleMetier getSalarySimpleMetier() {
        return salarySimpleMetier;
    }

    /**
     * @param salarySimpleMetier the salarySimpleMetier to set
     */
    public void setSalarySimpleMetier(SalarySimpleMetier salarySimpleMetier) {
        this.salarySimpleMetier = salarySimpleMetier;
    }

    /**
     * @return the salarySimplefillMetier
     */
    public SalarySimplefillMetier getSalarySimplefillMetier() {
        return salarySimplefillMetier;
    }

    /**
     * @param salarySimplefillMetier the salarySimplefillMetier to set
     */
    public void setSalarySimplefillMetier(SalarySimplefillMetier salarySimplefillMetier) {
        this.salarySimplefillMetier = salarySimplefillMetier;
    }

    /**
     * @return the histoSalaryMetierListIndem
     */
    public List<HistoSalaryMetier> getHistoSalaryMetierListIndem() {
        return histoSalaryMetierListIndem;
    }

    /**
     * @param histoSalaryMetierListIndem the histoSalaryMetierListIndem to set
     */
    public void setHistoSalaryMetierListIndem(List<HistoSalaryMetier> histoSalaryMetierListIndem) {
        this.histoSalaryMetierListIndem = histoSalaryMetierListIndem;
    }

    /**
     * @return the histoSalaryMetierListPrime
     */
    public List<HistoSalaryMetier> getHistoSalaryMetierListPrime() {
        return histoSalaryMetierListPrime;
    }

    /**
     * @param histoSalaryMetierListPrime the histoSalaryMetierListPrime to set
     */
    public void setHistoSalaryMetierListPrime(List<HistoSalaryMetier> histoSalaryMetierListPrime) {
        this.histoSalaryMetierListPrime = histoSalaryMetierListPrime;
    }

    /**
     * @return the histoSalaryMetierListcharge
     */
    public List<HistoSalaryMetier> getHistoSalaryMetierListcharge() {
        return histoSalaryMetierListcharge;
    }

    /**
     * @param histoSalaryMetierListcharge the histoSalaryMetierListcharge to set
     */
    public void setHistoSalaryMetierListcharge(List<HistoSalaryMetier> histoSalaryMetierListcharge) {
        this.histoSalaryMetierListcharge = histoSalaryMetierListcharge;
    }

    /**
     * @return the histoSalaryfillMetier
     */
    public HistoSalaryfillMetier getHistoSalaryfillMetier() {
        return histoSalaryfillMetier;
    }

    /**
     * @param histoSalaryfillMetier the histoSalaryfillMetier to set
     */
    public void setHistoSalaryfillMetier(HistoSalaryfillMetier histoSalaryfillMetier) {
        this.histoSalaryfillMetier = histoSalaryfillMetier;
    }


    /**
     * @return the esalaeyData
     */
    public List<ESalaryData> getEsalaeyData() {
        return esalaeyData;
    }

    /**
     * @param esalaeyData the esalaeyData to set
     */
    public void setEsalaeyData(List<ESalaryData> esalaeyData) {
        this.esalaeyData = esalaeyData;
    }
    
    
    public ESalaryDataRepos geteSalaryDataRepos() {
        return eSalaryDataRepos;
    }

    public void seteSalaryDataRepos(ESalaryDataRepos eSalaryDataRepos) {
        this.eSalaryDataRepos = eSalaryDataRepos;
    }
}

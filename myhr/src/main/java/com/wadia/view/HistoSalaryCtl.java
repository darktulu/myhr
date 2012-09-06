/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wadia.view;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;

import com.wadia.beans.ESalaryData;
import com.wadia.metier.HistoSalaryMetier;
import com.wadia.metier.HistoSalaryfillMetier;
import com.wadia.metier.SalaryMetier;
import com.wadia.repos.ESalaryDataRepos;

/**
 *
 * @author massin
 */
@ManagedBean (name="HistoSalaryCtl")
@RequestScoped 
public class HistoSalaryCtl {

    private List<HistoSalaryMetier> histoSalaryMetierListIndem = new ArrayList<HistoSalaryMetier>();
    private List<HistoSalaryMetier> histoSalaryMetierListPrime = new ArrayList<HistoSalaryMetier>();
    private List<HistoSalaryMetier> histoSalaryMetierListcharge = new ArrayList<HistoSalaryMetier>();
    private List<ESalaryData> eSalaryDatas = new ArrayList<ESalaryData>();
    private userController usercontroller = new userController();
   
    @ManagedProperty(value="#{salaryMetier}")
    private SalaryMetier salaryMetier;
    @ManagedProperty(value="#{histoSalaryfillMetier}")
    private HistoSalaryfillMetier histoSalaryfillMetier;
    @ManagedProperty(value="#{eSalaryDataRepos}")
    private ESalaryDataRepos eSalaryDataRepos;
   

   
    @PostConstruct
    public void init() {
        
        histoSalaryMetierListIndem = histoSalaryfillMetier.listHistoIndemnite(usercontroller.getUsername());
        histoSalaryMetierListPrime = histoSalaryfillMetier.listHistoPrime(usercontroller.getUsername());
        histoSalaryMetierListcharge = histoSalaryfillMetier.listHistoCharge(usercontroller.getUsername());
        eSalaryDatas = eSalaryDataRepos.findByUsername(usercontroller.getUsername());

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
     * @return the eSalaryDatas
     */
    public List<ESalaryData> geteSalaryDatas() {
        return eSalaryDatas;
    }

    /**
     * @param eSalaryDatas the eSalaryDatas to set
     */
    public void seteSalaryDatas(List<ESalaryData> eSalaryDatas) {
        this.eSalaryDatas = eSalaryDatas;
    }

    /**
     * @return the salaryMetier
     */
    public SalaryMetier getSalaryMetier() {
        return salaryMetier;
    }

    /**
     * @param salaryMetier the salaryMetier to set
     */
    public void setSalaryMetier(SalaryMetier salaryMetier) {
        this.salaryMetier = salaryMetier;
    }
    
    public ESalaryDataRepos geteSalaryDataRepos() {
        return eSalaryDataRepos;
    }

    public void seteSalaryDataRepos(ESalaryDataRepos eSalaryDataRepos) {
        this.eSalaryDataRepos = eSalaryDataRepos;
    }

    public userController getUsercontroller() {
        return usercontroller;
    }

    public void setUsercontroller(userController usercontroller) {
        this.usercontroller = usercontroller;
    }
}

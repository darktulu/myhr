/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wadia.view;

import com.wadia.beans.EIndemnite;
import com.wadia.beans.Echarge;
import com.wadia.beans.EPrime;
import com.wadia.beans.ESalaryData;
import com.wadia.metier.SalaryMetier;
import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

/**
 *
 * @author massin
 */
@ManagedBean
@RequestScoped
public class EsalaeyDataCtl {

    private static String IdToViewSalary;
    private List<EIndemnite> eIndemnites = new ArrayList<EIndemnite>();
    private List<EPrime> ePrimes = new ArrayList<EPrime>();
    private List<Echarge> echarges = new ArrayList<Echarge>();
    private ESalaryData eSalaryData = new ESalaryData();
    private SalaryMetier salaryMetier = new SalaryMetier();
    private int rowId;
    private int ans;
    private int mois;
    private Double baseSalary;
    private String description;

    public String saveSalary() {
        
        eSalaryData.setAns(ans);
        eSalaryData.setMois(mois);
        eSalaryData.setBaseSalary(baseSalary);
        eSalaryData.setDescription(description);
        if (eSalaryData != null) {
            eSalaryData.setResurceId(IdToViewSalary);
        }

        for (EIndemnite eIndemnite : eIndemnites) {
            eIndemnite.setResureceId(IdToViewSalary);
        }
        for (EPrime ePrime : ePrimes) {
            ePrime.setResourceId(IdToViewSalary);
        }
        for (Echarge echarge : echarges) {
            echarge.setResourceId(IdToViewSalary);
        }
        salaryMetier.saveSalary(eSalaryData, eIndemnites, ePrimes, echarges);
        return "ok";
    }

    public void removeRowIndem() {
        geteIndemnites().remove(rowId);

    }

    public void removeRowCharge() {

        getEcharges().remove(rowId);
    }

    public void removeRowPrime() {

        getePrimes().remove(rowId);

    }

    public void addIndeminte() {
        System.out.println("addIndemnite...");
        geteIndemnites().add(new EIndemnite());
    }

    public void addcharge() {
        System.out.println("addIndemnite...");
        getEcharges().add(new Echarge());
    }

    public void addPrime() {
        System.out.println("addIndemnite...");
        getePrimes().add(new EPrime());
    }

    /**
     * @return the eIndemnites
     */
    public List<EIndemnite> geteIndemnites() {
        return eIndemnites;
    }

    /**
     * @param eIndemnites the eIndemnites to set
     */
    public void seteIndemnites(List<EIndemnite> eIndemnites) {
        this.eIndemnites = eIndemnites;
    }

    /**
     * @return the ePrimes
     */
    public List<EPrime> getePrimes() {
        return ePrimes;
    }

    /**
     * @param ePrimes the ePrimes to set
     */
    public void setePrimes(List<EPrime> ePrimes) {
        this.ePrimes = ePrimes;
    }

    /**
     * @return the echarges
     */
    public List<Echarge> getEcharges() {
        return echarges;
    }

    /**
     * @param echarges the echarges to set
     */
    public void setEcharges(List<Echarge> echarges) {
        this.echarges = echarges;
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

    /**
     * @return the rowId
     */
    public int getRowId() {
        return rowId;
    }

    /**
     * @param rowId the rowId to set
     */
    public void setRowId(int rowId) {
        this.rowId = rowId;
    }

    /**
     * @return the IdToViewSalary
     */
    public String getIdToViewSalary() {
        return IdToViewSalary;
    }

    /**
     * @param IdToViewSalary the IdToViewSalary to set
     */
    public void setIdToViewSalary(String IdToViewSalary) {
        this.IdToViewSalary = IdToViewSalary;
    }

    public ESalaryData geteSalaryData() {
        return eSalaryData;
    }

    public void seteSalaryData(ESalaryData eSalaryData) {
        this.eSalaryData = eSalaryData;
    }

    public int getAns() {
        return ans;
    }

    public void setAns(int ans) {
        this.ans = ans;
    }

    public int getMois() {
        return mois;
    }

    public void setMois(int mois) {
        this.mois = mois;
    }

    public Double getBaseSalary() {
        return baseSalary;
    }

    public void setBaseSalary(Double baseSalary) {
        this.baseSalary = baseSalary;
    }

    /**
     * @return the description
     */
    public String getDescription() {
        return description;
    }

    /**
     * @param description the description to set
     */
    public void setDescription(String description) {
        this.description = description;
    }
}

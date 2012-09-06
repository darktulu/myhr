/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wadia.metier;

import java.util.Date;

/**
 *
 * @author massin
 */
public class HistoSalaryMetier {

    private int ans;
    private int mois;
    private String typeIndemPrem;
    private String typeSalaireDeBase;
    private float totalAmount;
    private Double totalCharge;
    private String taxable;
    private String description;
    private int id;

    /**
     * @return the typeIndemPrem
     */
    public String getTypeIndemPrem() {
        return typeIndemPrem;
    }

    /**
     * @param typeIndemPrem the typeIndemPrem to set
     */
    public void setTypeIndemPrem(String typeIndemPrem) {
        this.typeIndemPrem = typeIndemPrem;
    }

    /**
     * @return the typeSalaireDeBase
     */
    public String getTypeSalaireDeBase() {
        return typeSalaireDeBase;
    }

    /**
     * @param typeSalaireDeBase the typeSalaireDeBase to set
     */
    public void setTypeSalaireDeBase(String typeSalaireDeBase) {
        this.typeSalaireDeBase = typeSalaireDeBase;
    }

    /**
     * @return the totalAmount
     */
    public float getTotalAmount() {
        return totalAmount;
    }

    /**
     * @param totalAmount the totalAmount to set
     */
    public void setTotalAmount(float totalAmount) {
        this.totalAmount = totalAmount;
    }

    /**
     * @return the taxable
     */
    public String getTaxable() {
        return taxable;
    }

    /**
     * @param taxable the taxable to set
     */
    public void setTaxable(String taxable) {
        this.taxable = taxable;
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

    /**
     * @return the ans
     */
    public int getAns() {
        return ans;
    }

    /**
     * @param ans the ans to set
     */
    public void setAns(int ans) {
        this.ans = ans;
    }

    /**
     * @return the mois
     */
    public int getMois() {
        return mois;
    }

    /**
     * @param mois the mois to set
     */
    public void setMois(int mois) {
        this.mois = mois;
    }

    /**
     * @return the totalCharge
     */
    public Double getTotalCharge() {
        return totalCharge;
    }

    /**
     * @param totalCharge the totalCharge to set
     */
    public void setTotalCharge(Double totalCharge) {
        this.totalCharge = totalCharge;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}

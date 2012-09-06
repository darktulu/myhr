/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wadia.view;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;

import com.wadia.beans.SalaryCharge;
import com.wadia.metier.ChargeMetier;
import com.wadia.repos.ChargeRepos;

/**
 * 
 * @author toshiba
 */
@ManagedBean
@RequestScoped
public class ChargeCtl {

    @ManagedProperty(value = "#{chargeRepos}")
    private ChargeRepos chargeRepos;

    private String nomCharge;
    private String type;
    private float tax;
    private float plafond;
    private String ChargeToEdit;
    private static SalaryCharge Charge;
    private ChargeMetier chargeMetier = new ChargeMetier();

    public String save() {

	SalaryCharge salarycharge = new SalaryCharge(nomCharge, type, (float) tax, (float) plafond);
	if (chargeMetier.ChargeKO(salarycharge)) {
	    System.out.println("\n" + salarycharge.toString());
	    chargeRepos.save(salarycharge);
	}
	return "ok";

    }

    public void delete() {

	System.out.println("" + Charge.toString());
	if (Charge != null) {

	    chargeRepos.delete(Charge);
	}

    }

    public String getNomCharge() {
	return nomCharge;
    }

    public void setNomCharge(String nomCharge) {
	this.nomCharge = nomCharge;
    }

    public String getType() {
	return type;
    }

    public void setType(String type) {
	this.type = type;
    }

    public float getTax() {
	return tax;
    }

    public void setTax(float tax) {
	this.tax = tax;
    }

    public float getPlafond() {
	return plafond;
    }

    public void setPlafond(float plafond) {
	this.plafond = plafond;
    }

    @Override
    public String toString() {

	return "nom " + nomCharge + " tax " + tax + " pla " + plafond;
    }

    public String getChargeToEdit() {
	return ChargeToEdit;
    }

    public void setChargeToEdit(String aChargeToEdit) {
	ChargeToEdit = aChargeToEdit;
	System.out.println("charge name" + ChargeToEdit);
	if (ChargeToEdit != null) {

	    Charge = chargeMetier.findByName(ChargeToEdit);

	}

    }

}

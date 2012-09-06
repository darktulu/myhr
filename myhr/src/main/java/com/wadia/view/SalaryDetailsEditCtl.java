/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wadia.view;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;

import com.wadia.beans.EIndemnite;
import com.wadia.beans.EPrime;
import com.wadia.beans.ESalaryData;
import com.wadia.repos.EIndemniteRepos;
import com.wadia.repos.EPrimeRepos;
import com.wadia.repos.ESalaryDataRepos;

/**
 * 
 * @author toshiba
 */
@ManagedBean
@RequestScoped
public class SalaryDetailsEditCtl {
    @ManagedProperty(value = "#{eIndemniteRepos}")
    private EIndemniteRepos eIndemniteRepos;
    @ManagedProperty(value = "#{ePrimeRepos}")
    private EPrimeRepos ePrimeRepos;
    @ManagedProperty(value = "#{eSalaryDataRepos}")
    private ESalaryDataRepos eSalaryDataRepos;

    public ESalaryDataRepos geteSalaryDataRepos() {
	return eSalaryDataRepos;
    }

    public void seteSalaryDataRepos(ESalaryDataRepos eSalaryDataRepos) {
	this.eSalaryDataRepos = eSalaryDataRepos;
    }

    public EPrimeRepos getePrimeRepos() {
	return ePrimeRepos;
    }

    public void setePrimeRepos(EPrimeRepos ePrimeRepos) {
	this.ePrimeRepos = ePrimeRepos;
    }

    public EIndemniteRepos geteIndemniteRepos() {
	return eIndemniteRepos;
    }

    public void seteIndemniteRepos(EIndemniteRepos eIndemniteRepos) {
	this.eIndemniteRepos = eIndemniteRepos;
    }

    private int idPrime = 0;
    private int idIndem = 0;
    private int idSalary = 0;
    private static EPrime ePrime = new EPrime();
    private static EIndemnite eIndemnite = new EIndemnite();
    private static ESalaryData eSalaryData = new ESalaryData();

    public void SalaryDetailsEditCtl() {
    }

    public int getIdPrime() {
	return idPrime;
    }

    public void setIdPrime(int idPrime) {
	this.idPrime = idPrime;
	if (idPrime != 0) {

	    ePrime = ePrimeRepos.findOne(idPrime);

	}
    }

    public int getIdIndem() {
	return idIndem;
    }

    public void setIdIndem(int idIndem) {
	this.idIndem = idIndem;

	if (idIndem != 0) {

	    eIndemnite = eIndemniteRepos.findOne(idIndem);
	}

    }

    public int getIdSalary() {
	return idSalary;
    }

    public void setIdSalary(int idSalary) {
	this.idSalary = idSalary;

	if (idSalary != 0) {

	    eSalaryData = eSalaryDataRepos.findOne(idSalary);

	}

    }

    public EPrime getePrime() {
	return ePrime;
    }

    public void setePrime(EPrime ePrime) {
	this.ePrime = ePrime;
    }

    public EIndemnite geteIndemnite() {
	return eIndemnite;
    }

    public void seteIndemnite(EIndemnite eIndemnite) {
	this.eIndemnite = eIndemnite;
    }

    public ESalaryData geteSalaryData() {
	return eSalaryData;
    }

    public void seteSalaryData(ESalaryData eSalaryData) {
	this.eSalaryData = eSalaryData;
    }

    public String deletePrime() {
	if (ePrime != null) {

	    System.out.println("here in Prime :" + ePrime.getResourceId());

	    ePrimeRepos.delete(ePrime);
	}
	return "ok";

    }

    public String deleteIndem() {
	if (eIndemnite != null) {
	    eIndemniteRepos.delete(eIndemnite);
	}
	return "ok";

    }

    public String deleteSalary() {
	if (eSalaryData != null) {
	    eSalaryDataRepos.delete(eSalaryData);
	}
	return "ok";

    }

}

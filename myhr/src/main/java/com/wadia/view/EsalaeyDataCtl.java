/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wadia.view;

import com.wadia.beans.EIndemnite;
import com.wadia.beans.Echarge;
import com.wadia.beans.EPrime;
import com.wadia.beans.ESalaryData;
import com.wadia.local.Recipients;
import com.wadia.metier.AffectationMetier;
import com.wadia.metier.DirectoryMetier;
import com.wadia.metier.MailForm;
import com.wadia.metier.SalaryMetier;
import com.wadia.repos.EGeneralDataRepos;
import com.wadia.repos.ESalaryDataRepos;
import com.wadia.service.impl.SalaryServiceImpl;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.ViewScoped;

/**
 * 
 * @author wadi3
 */
@ManagedBean(name = "EsalaeyDataCtl")
@ViewScoped
public class EsalaeyDataCtl implements Serializable {

	private static String IdToViewSalary;
	private List<EIndemnite> eIndemnites = new ArrayList<EIndemnite>();
	private List<EPrime> ePrimes = new ArrayList<EPrime>();
	private List<Echarge> echarges = new ArrayList<Echarge>();
	

	private ESalaryData eSalaryData = new ESalaryData();

	private SalaryMetier salaryMetier() {
		return SpringJSFUtil.getBean("salaryMetier");
	}

	private MailForm mailForm() {
		return SpringJSFUtil.getBean("mailForm");
	}
    
	private EGeneralDataRepos eGeneralDataRepos() {
		return SpringJSFUtil.getBean("eGeneralDataRepos");
	}
	
	private AffectationMetier affectationMetier() {
		return SpringJSFUtil.getBean("affectationMetier");
	}


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
		
		
	    List<Recipients> mailList = new ArrayList<Recipients>();

		if (eSalaryData != null) {

			eSalaryData.setResurceId(IdToViewSalary);
			// TODO
           
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
		salaryMetier().saveSalary(eSalaryData, eIndemnites, ePrimes, echarges);
		
		if (eSalaryData != null) {			
			

			
			Recipients HrManager = new Recipients();
			HrManager.setMail(affectationMetier().findMyHrManager(IdToViewSalary).getInfo());
			HrManager.setType("Cc");
			mailList.add(HrManager);//ADD HR
			
			Recipients Me = new Recipients();
			Me.setMail(affectationMetier().findMe(IdToViewSalary).getInfo());
			Me.setType("To");
			mailList.add(Me);// ADD ME
			
			String fullname = eGeneralDataRepos().findOne(IdToViewSalary).getName()+" "+eGeneralDataRepos().findOne(IdToViewSalary).getSurname();
			
		    mailForm().SalaryAward(mailList, fullname, IdToViewSalary, ""+eSalaryData.getBaseSalary());
		}

		return "SalaryHr?faces-redirect=true";
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
		eIndemnites.add(new EIndemnite());
	}

	public void addcharge() {
		System.out.println("addcharge...");
		echarges.add(new Echarge());
	}

	public void addPrime() {
		System.out.println("addPrime...");
		ePrimes.add(new EPrime());
	}

	/**
	 * @return the eIndemnites
	 */
	public List<EIndemnite> geteIndemnites() {
		return eIndemnites;
	}

	/**
	 * @param eIndemnites
	 *            the eIndemnites to set
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
	 * @param ePrimes
	 *            the ePrimes to set
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
	 * @param echarges
	 *            the echarges to set
	 */
	public void setEcharges(List<Echarge> echarges) {
		this.echarges = echarges;
	}

	/**
	 * @return the rowId
	 */
	public int getRowId() {
		return rowId;
	}

	/**
	 * @param rowId
	 *            the rowId to set
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
	 * @param IdToViewSalary
	 *            the IdToViewSalary to set
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
	 * @param description
	 *            the description to set
	 */
	public void setDescription(String description) {
		this.description = description;
	}
}

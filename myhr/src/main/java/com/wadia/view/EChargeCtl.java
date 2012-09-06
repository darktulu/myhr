/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wadia.view;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;

import com.wadia.beans.Echarge;
import com.wadia.repos.EchargeRepos;

/**
 * 
 * @author toshiba
 */
@ManagedBean
@RequestScoped
public class EChargeCtl {
    @ManagedProperty(value = "#{echargeRepos}")
    private EchargeRepos echargeRepos;

    public EchargeRepos getEchargeRepos() {
	return echargeRepos;
    }

    public void setEchargeRepos(EchargeRepos echargeRepos) {
	this.echargeRepos = echargeRepos;
    }

    private Integer id;
    private String nom;
    private String resourceId;
    private int mois;
    private int ans;
    private userController user = new userController();

    public String save() {

	Echarge echarge = new Echarge(nom, user.getUsername(), mois, ans);

	if (echarge != null) {
	    echargeRepos.save(echarge);
	}
	return "ok";
    }

    public Integer getId() {
	return id;
    }

    public void setId(Integer id) {
	this.id = id;
    }

    public String getNom() {
	return nom;
    }

    public void setNom(String nom) {
	this.nom = nom;
    }

    public String getResourceId() {
	return resourceId;
    }

    public void setResourceId(String resourceId) {
	this.resourceId = resourceId;
    }

    public int getMois() {
	return mois;
    }

    public void setMois(int mois) {
	this.mois = mois;
    }

    public int getAns() {
	return ans;
    }

    public void setAns(int ans) {
	this.ans = ans;
    }

}

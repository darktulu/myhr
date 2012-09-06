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

import com.wadia.beans.EInsurranceData;
import com.wadia.metier.InssuranceMetier;
import com.wadia.repos.EInsurranceDataRepos;

/**
 * 
 * @author toshiba
 */
@ManagedBean (name="InssuranceListCtl")
@RequestScoped
public class InssuranceListCtl {

    private userController user = new userController();
    private List<EInsurranceData> listInssurance = new ArrayList<EInsurranceData>();
    private Integer number;
    private String search;

    @ManagedProperty(value = "#{eInsurranceDataRepos}")
    private EInsurranceDataRepos eInsurranceDataRepos;
    @ManagedProperty(value = "#{inssuranceMetier}")
    private InssuranceMetier inssuranceMetier;
    
    @PostConstruct
    public void init() {

	listInssurance = inssuranceMetier.findByUsername(user.getUsername());
	number = inssuranceMetier.personnePrisEnCharge(user.getUsername());

    }

    public void delete(Integer id) {

	EInsurranceData insssurece = new EInsurranceData();
	insssurece = eInsurranceDataRepos.findOne(id);
	eInsurranceDataRepos.delete(insssurece);

    }

    public void update() {
	listInssurance = inssuranceMetier.findByUsername(user.getUsername());
	number = inssuranceMetier.personnePrisEnCharge(user.getUsername());
	System.out.println("" + listInssurance.size());
    }

    public List<EInsurranceData> getListInssurance() {
	return listInssurance;
    }

    public void setListInssurance(List<EInsurranceData> listInssurance) {
	this.listInssurance = listInssurance;
    }

    public Integer getNumber() {
	return number;
    }

    public void setNumber(Integer number) {
	this.number = number;
    }

    public String getSearch() {
	return search;
    }

    public void setSearch(String search) {
	this.search = search;
	if (search != null) {

	    List<EInsurranceData> insuuranceListSearchs = new ArrayList<EInsurranceData>();
	    listInssurance = inssuranceMetier.findByUsername(user.getUsername());
	    // System.out.println("filtering employs... " + search);

	    for (EInsurranceData inssurance : listInssurance) {

		if (inssurance.getDossier().toLowerCase().contains(search.toLowerCase())
			|| inssurance.getMatricule().toLowerCase().contains(search.toLowerCase())
			|| inssurance.getPersonName().toLowerCase().contains(search.toLowerCase())
			|| inssurance.getStatus().toLowerCase().contains(search.toLowerCase())
			|| inssurance.getTotalAmount().toLowerCase().contains(search.toLowerCase())
			|| inssurance.getType().toLowerCase().contains(search.toLowerCase())) {

		    insuuranceListSearchs.add(inssurance);
		}
	    }
	    // System.out.println("filtering employs... " +
	    // leaveListSearchs.size());
	    listInssurance = insuuranceListSearchs;
	}
    }

    public userController getUser() {
        return user;
    }

    public void setUser(userController user) {
        this.user = user;
    }

    public EInsurranceDataRepos geteInsurranceDataRepos() {
        return eInsurranceDataRepos;
    }

    public void seteInsurranceDataRepos(EInsurranceDataRepos eInsurranceDataRepos) {
        this.eInsurranceDataRepos = eInsurranceDataRepos;
    }

    public InssuranceMetier getInssuranceMetier() {
        return inssuranceMetier;
    }

    public void setInssuranceMetier(InssuranceMetier inssuranceMetier) {
        this.inssuranceMetier = inssuranceMetier;
    }
}

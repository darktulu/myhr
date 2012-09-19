/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wadia.view;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.ViewScoped;

import com.wadia.beans.Soldleave;
import com.wadia.metier.DirectoryMetier;
import com.wadia.repos.SoldleaveRepos;

/**
 * 
 * @author toshiba
 */
@ManagedBean(name = "SoldCtl")
@ViewScoped
public class SoldCtl implements Serializable {

	private int toEdit;
	private static Soldleave soldLeave = new Soldleave();

	private SoldleaveRepos soldleaveRepos() {
		return SpringJSFUtil.getBean("soldleaveRepos");
	}

	public String delete() {
		System.out.println("on delete method");
		soldleaveRepos().delete(soldLeave);
		System.out.println("on delete method");
		return "LeaveSummaryList?faces-redirect=true";
	}

	public int getToEdit() {
		return toEdit;

	}

	public void setToEdit(int toEdit) {
		this.toEdit = toEdit;
		if (toEdit != 0) {
			soldLeave = soldleaveRepos().findOne(toEdit);
		}
	}

	public Soldleave getSoldLeave() {
		return soldLeave;
	}

	public void setSoldLeave(Soldleave soldLeave) {
		this.soldLeave = soldLeave;
	}



}

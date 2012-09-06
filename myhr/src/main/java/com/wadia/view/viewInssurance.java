/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wadia.view;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;

import com.wadia.beans.EInsurranceData;
import com.wadia.repos.EInsurranceDataRepos;

/**
 * 
 * @author toshiba
 */
@ManagedBean (name="viewInssurance")
@RequestScoped
public class viewInssurance {

    private int idToEdit = 0;
    private static EInsurranceData data = new EInsurranceData();
   
    @ManagedProperty(value = "#{eInsurranceDataRepos}")
    private EInsurranceDataRepos eInsurranceDataRepos;

    public int getIdToEdit() {
	return idToEdit;
    }

    public void setIdToEdit(int idToEdit) {
	this.idToEdit = idToEdit;
	if (idToEdit != 0) {

	    data = eInsurranceDataRepos.findOne(idToEdit);
	}
    }

    public EInsurranceData getData() {
	return data;
    }

    public void setData(EInsurranceData data) {
	this.data = data;
    }

    public EInsurranceDataRepos geteInsurranceDataRepos() {
        return eInsurranceDataRepos;
    }

    public void seteInsurranceDataRepos(EInsurranceDataRepos eInsurranceDataRepos) {
        this.eInsurranceDataRepos = eInsurranceDataRepos;
    }

}

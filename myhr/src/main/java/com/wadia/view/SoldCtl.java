/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wadia.view;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;

import com.wadia.beans.Soldleave;
import com.wadia.repos.SoldleaveRepos;

/**
 *
 * @author toshiba
 */
@ManagedBean (name="SoldCtl")
@RequestScoped
public class SoldCtl {
    
    private int toEdit;
    private static Soldleave soldLeave = new Soldleave();
    @ManagedProperty(value = "#{soldleaveRepos}")
    private SoldleaveRepos soldleaveRepos;
    
    public String delete(){
    	System.out.println("on delete method");
	soldleaveRepos.delete(soldLeave);
	System.out.println("on delete method");
	return "LeaveSummaryList?faces-redirect=true";
    }
    
    

    public int getToEdit() {
        return toEdit;
        
        
    }

    public void setToEdit(int toEdit) {
        this.toEdit = toEdit;
        if(toEdit!=0){
        soldLeave = soldleaveRepos.findOne(toEdit);
        }
    }

    public Soldleave getSoldLeave() {
        return soldLeave;
    }

    public void setSoldLeave(Soldleave soldLeave) {
        this.soldLeave = soldLeave;
    }



	public SoldleaveRepos getSoldleaveRepos() {
		return soldleaveRepos;
	}



	public void setSoldleaveRepos(SoldleaveRepos soldleaveRepos) {
		this.soldleaveRepos = soldleaveRepos;
	}
    
}

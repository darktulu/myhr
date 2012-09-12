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
@ManagedBean (name="SoldEditCtl")
@RequestScoped
public class SoldEditCtl {

    private int toEdit;
    private static Integer year;
    private static Integer sold;
    private static Integer consumed;
    private static Integer planned;
    private static Soldleave soldleave = new Soldleave();
    @ManagedProperty(value = "#{soldleaveRepos}")
    private SoldleaveRepos soldleaveRepos;

    public SoldEditCtl() {
    }

    public int getToEdit() {
	return toEdit;
    }

    public String save() {

	soldleave.setConsumed(consumed);
	soldleave.setPlanned(planned);
	soldleave.setSold(sold);
	soldleaveRepos.save(soldleave);
	System.out.println("hiya hadi " + soldleave.getResourceId());
	return "ok";
    }

    public void setToEdit(int toEdit) {
	this.toEdit = toEdit;
	if (toEdit != 0) {

	    soldleave = soldleaveRepos.findOne(toEdit);
	    year = soldleave.getYear();
	    sold = soldleave.getSold();
	    planned = soldleave.getPlanned();
	    consumed = soldleave.getConsumed();
	}
    }

    public Integer getYear() {
	return year;
    }

    public void setYear(Integer year) {
	this.year = year;
    }

    public Integer getSold() {
	return sold;
    }

    public void setSold(Integer sold) {
	this.sold = sold;
    }

    public Integer getConsumed() {
	return consumed;
    }

    public void setConsumed(Integer consumed) {
	this.consumed = consumed;
    }

    public Integer getPlanned() {
	return planned;
    }

    public void setPlanned(Integer planned) {
	this.planned = planned;
    }

    public Soldleave getSoldleave() {
	return soldleave;
    }

    public void setSoldleave(Soldleave soldleave) {
	this.soldleave = soldleave;
    }

	public SoldleaveRepos getSoldleaveRepos() {
		return soldleaveRepos;
	}

	public void setSoldleaveRepos(SoldleaveRepos soldleaveRepos) {
		this.soldleaveRepos = soldleaveRepos;
	}

}

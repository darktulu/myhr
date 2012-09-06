/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wadia.view;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;

import com.wadia.beans.SalaryCharge;
import com.wadia.repos.ChargeRepos;

/**
 * 
 * @author toshiba
 */
@ManagedBean
@RequestScoped
public class ChargeListCtl {
    @ManagedProperty(value = "#{chargeRepos}")
    private ChargeRepos chargeRepos;

    private List<SalaryCharge> list = new ArrayList<SalaryCharge>();

    public ChargeListCtl() {
	list = chargeRepos.findAll();
    }

    public List<SalaryCharge> getList() {
	return list;
    }

    public void setList(List<SalaryCharge> list) {
	this.list = list;
    }

}

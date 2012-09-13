/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wadia.view;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;

import com.wadia.beans.ELData;
import com.wadia.metier.LeavesMetier;

/**
 * 
 * @author ITR2012
 */
@ManagedBean(name = "LeavesListCtl")
@RequestScoped
public class LeavesListCtl {

    private List<ELData> eLData = new ArrayList<ELData>();

    @ManagedProperty(value = "#{leavesMetier}")
    private LeavesMetier leavesMetier;

    private userController usercontroller = new userController();
    private Date searchByDate;
    private String search;

    /**
     * @return the eLData
     */
    @PostConstruct
    public void init() {

	if (usercontroller.getUsername() != null) {
	    eLData = leavesMetier.findByUsername(usercontroller.getUsername());
	}
    }

    public List<ELData> geteLData() {
	return eLData;
    }

    public void seteLData(List<ELData> eLData) {
	this.eLData = eLData;
    }

    public Date getSearchByDate() {
	return searchByDate;
    }

    public void setSearchByDate(Date searchByDate) {
	this.searchByDate = searchByDate;

	if (searchByDate != null) {

	    List<ELData> leaveListSearch = new ArrayList<ELData>();
	    eLData = leavesMetier.findByUsername(usercontroller.getUsername());
	    // System.out.println("filtering employs... " + search);

	    for (ELData elData : eLData) {

		if (elData.getLeaveEndDate().compareTo(searchByDate) == 0
			|| elData.getLeaveEndDate().compareTo(searchByDate) == 0) {
		    leaveListSearch.add(elData);
		}
	    }

	    eLData = leaveListSearch;
	}
	if (searchByDate == null) {
	    eLData = leavesMetier.findByUsername(usercontroller.getUsername());
	}

    }

    public String getSearch() {
	return search;
    }

    public void setSearch(String search) {
	this.search = search;
	if (search != null) {

	    List<ELData> leaveListSearchs = new ArrayList<ELData>();
	    eLData = leavesMetier.findByUsername(usercontroller.getUsername());
	    // System.out.println("filtering employs... " + search);

	    for (ELData elData : eLData) {

		if (elData.getStatus().toLowerCase().contains(search.toLowerCase())
			|| elData.getLeaveType().toLowerCase().contains(search.toLowerCase())
			|| elData.getLeaveType().toLowerCase().contains(search.toLowerCase())) {

		    leaveListSearchs.add(elData);
		}
	    }
	    eLData = leaveListSearchs;
	}

    }

    public LeavesMetier getLeavesMetier() {
        return leavesMetier;
    }

    public void setLeavesMetier(LeavesMetier leavesMetier) {
        this.leavesMetier = leavesMetier;
    }

    public userController getUsercontroller() {
        return usercontroller;
    }

    public void setUsercontroller(userController usercontroller) {
        this.usercontroller = usercontroller;
    }

}

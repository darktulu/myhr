/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wadia.metier;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.wadia.beans.ELData;
import com.wadia.repos.ELDataRepos;

/**
 * 
 * @author ITR2012
 */
@Service
@Transactional
public class LeavesMetier {

    @Inject
    private ELDataRepos eLDataRepos;
    private List<ELData> eLdatas;

    public List<ELData> geteLdatas() {
	return eLdatas;
    }

    public void seteLdatas(List<ELData> eLdatas) {
	this.eLdatas = eLdatas;
    }

    public List<ELData> findByUsername(String username) {
	ArrayList<ELData> leavessToReturn = new ArrayList<ELData>();
	eLdatas = eLDataRepos.findAll();
	for (ELData cont : eLdatas) {
	    if (cont.getResurceId().equals(username)) {
		leavessToReturn.add(cont);
	    }
	}
	return (leavessToReturn);
    }

    public List<ELData> findByApprovedPM(String username) {

	ArrayList<ELData> leavessToReturn = new ArrayList<ELData>();
	ArrayList<ELData> list = new ArrayList<ELData>();
	list = (ArrayList<ELData>) findByUsername(username);

	for (ELData leave : eLdatas) {

	    if (leave.getStatus().equals("Approved By PM") && leave.getResurceId().equals(username)) {

		leavessToReturn.add(leave);

	    }
	}

	return leavessToReturn;
    }

    public List<ELData> calculeSolde(String Username) {
	ArrayList<ELData> leavessToReturn = new ArrayList<ELData>();
	eLdatas = eLDataRepos.findAll();
	for (ELData cont : eLdatas) {
	    if ((cont.getResurceId().equals(Username)) && ("taken".equals(cont.getStatus()))) {
		leavessToReturn.add(cont);
	    }
	}
	return leavessToReturn;
    }

    // methode qui return la liste de ldata de mm annee

    public List<ELData> calculByYear(int annee, String username) {
	ArrayList<ELData> mylist = new ArrayList<ELData>();
	eLdatas = calculeSolde(username);
	for (ELData co : eLdatas) {

	    if (annee == co.getYear(co.getLeaveStartDate())) {
		mylist.add(co);
	    }
	}
	return mylist;
    }

    public HashSet<Integer> getyears(List<ELData> list) {

	HashSet<Integer> years = new HashSet<Integer>();

	for (ELData leave : list) {

	    years.add(leave.getYear(leave.getLeaveStartDate()));

	}

	return years;

    }

}

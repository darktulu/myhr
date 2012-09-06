/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wadia.metier;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.wadia.beans.EFunctionalData;
import com.wadia.beans.EGeneralData;
import com.wadia.beans.ELData;
import com.wadia.repos.AffectationRepos;
import com.wadia.repos.EFunctionalDataRepos;
import com.wadia.repos.EGeneralDataRepos;
import com.wadia.repos.ELDataRepos;

/**
 * 
 * @author ITR2012
 */
@Service
@Transactional
public class TeamCalendarMetier {

    @Inject
    private ELDataRepos elDataRepos;
    @Inject
    private AffectationMetier affectationMetier;
    @Inject
    private AffectationRepos affectationRepos;
   
    private List<ELData> eLdatas;
    private List<EGeneralData> egen;
    @Inject
    private EGeneralDataRepos eGeneralDataRepos;
    private String Username;
    Calendar rightNow = Calendar.getInstance();

   public List<ELData> myTeamLeaves(String username){
	List<ELData> eLdatas = new ArrayList<ELData>();
	eLdatas = MyReports(affectationRepos.MyReportsList(affectationMetier.findMyManager(username).getUsername()));
	return eLdatas;
    }

    public List<ELData> calculeSolde(List<EGeneralData> eGeneralDatas) {
	ArrayList<ELData> leavessToReturn = new ArrayList<ELData>();
	eLdatas = elDataRepos.findAll();
	egen = eGeneralDataRepos.findAll();
	for (ELData cont : eLdatas) {
	    for (EGeneralData gen : egen) {
		Username = gen.getResurceId();

		if ((cont.getResurceId().equals(Username)) && ("taken".equals(cont.getStatus()))
			&& (cont.getYear(cont.getLeaveStartDate()) == (rightNow.getTime().getYear() + 1900))) {
		    leavessToReturn.add(cont);
		}
	    }
	}
	return leavessToReturn;
    }

    public List<ELData> MyReports(List<String> listUsernames) {

	List<ELData> reports = new ArrayList<ELData>();
	
	List<ELData> listLeaves = new ArrayList<ELData>();

	for (String username : listUsernames) {

	    listLeaves = elDataRepos.findByUsername(username);
	    // System.out.println("List leaves "+username+" "+listLeaves.size());
	    reports.addAll(listLeaves);
	}

	return reports;
    }

    public List<ELData> concatain(List<ELData> toretrun, List<ELData> toadd) {

	for (ELData leave : toadd) {

	    toretrun.add(leave);

	}

	return toretrun;
    }

}

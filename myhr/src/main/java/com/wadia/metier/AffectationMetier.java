package com.wadia.metier;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.wadia.beans.Affectation;
import com.wadia.beans.EGeneralData;
import com.wadia.beans.Users;
import com.wadia.repos.AffectationRepos;
import com.wadia.repos.EGeneralDataRepos;

/**
 * 
 * @author toshiba
 */
@Service
@Transactional
public class AffectationMetier {

    @Inject
    private AffectationRepos affectationRepos;

    @Inject
    private EGeneralDataRepos eGeneralDataRepos;

    public Affectation getbyusername(String username) {

	Affectation affectation = new Affectation();
	List<Affectation> list = new ArrayList<Affectation>();
	list = affectationRepos.findAll();

	for (Affectation affect : list) {

	    if (affect.getUsersByUsersUsername().getUsername().equals(username)) {
		affectation = affect;
	    }

	}

	return affectation;

    }

    public List<EGeneralData> getbyManager(String username) {

	List<Affectation> affectationlist = new ArrayList<Affectation>();
	List<EGeneralData> affectToReturn = new ArrayList<EGeneralData>();
	affectationlist = affectationRepos.findAll();

	for (Affectation affect : affectationlist) {

	    if (affect.getUsersByUsersLm().getUsername().equals(username)) {
		affectToReturn.add(eGeneralDataRepos.findOne(affect.getUsersByUsersUsername().getUsername()));
	    }

	}
	return affectToReturn;
    }

    public Users findMyManager(String username) {

	String mail;
	Affectation affectation = new Affectation();
	affectation = affectationRepos.findMyManager(username);

	return affectation.getUsersByUsersLm();
    }

    public Users findMyHrManager(String username) {

	String mail;
	Affectation affectation = new Affectation();
	affectation = affectationRepos.findMyManager(username);

	return affectation.getUsersByUsersHr();
    }

    public Users findMe(String username) {

	String mail;
	Affectation affectation = new Affectation();
	affectation = affectationRepos.findMyManager(username);

	return affectation.getUsersByUsersUsername();
    }

    public String findMyRHMail(String username) {

	String mail;
	Affectation affectation = new Affectation();

	affectation = affectationRepos.findMyManager(username);
	mail = affectation.getUsersByUsersHr().getInfo();
	return mail;
    }

}

package com.wadia.metier;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.wadia.beans.EGeneralData;
import com.wadia.beans.Users;
import com.wadia.repos.EGeneralDataRepos;
import com.wadia.repos.UsersRepos;

@Service
@Transactional
public class FillUsersMetier {
	
	 @Inject
	    private UsersRepos usersRepos;
	    @Inject
	    private EGeneralDataRepos eGeneralDataRepos;

	    public void fill() {
		boolean locker;

		List<Users> listUsers = new ArrayList<Users>();
		List<EGeneralData> listEmploys = new ArrayList<EGeneralData>();

		listUsers = usersRepos.findAll();
		listEmploys = eGeneralDataRepos.findAll();
	     System.out.println("here in fill before fill");
		for (Users users : listUsers) {
	           System.out.println("user"+users.getFirstname());
		    locker = true;

		    for (EGeneralData employ : listEmploys) {

			if (users.getUsername().equals(employ.getResurceId())) {

			    locker = false;

			}

		    }

		    if (locker) {

			EGeneralData userToSave = new EGeneralData(users.getUsername(), "toto");
			userToSave.setName(users.getFirstname());
			userToSave.setSurname(users.getLastname());
			userToSave.setEmail(users.getInfo());
			userToSave.setStatus("ENDED");

			eGeneralDataRepos.save(userToSave);

			System.out.println("saved with success :" + users.getUsername());

		    }

		}

	    }

}

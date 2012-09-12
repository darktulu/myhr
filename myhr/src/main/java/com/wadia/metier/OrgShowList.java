package com.wadia.metier;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;



import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.wadia.beans.Affectation;
import com.wadia.beans.EGeneralData;
import com.wadia.repos.EGeneralDataRepos;

@Service
@Transactional
public class OrgShowList implements Serializable {

	@Inject
	private EGeneralDataRepos eGeneralDataRepos;
	@Inject
	private AffectationMetier affectationMetier;

	public List<OrganizationaMetier> listOrg() {

		List<EGeneralData> eGenList = new ArrayList<EGeneralData>();
		List<OrganizationaMetier> orgList = new ArrayList<OrganizationaMetier>();

		eGenList = eGeneralDataRepos.findAll();

		for (EGeneralData employ : eGenList) {

			OrganizationaMetier org = new OrganizationaMetier();
			org.setName(employ.getName());
			org.setSurname(employ.getSurname());
			org.setStatus(employ.getStatus());
			org.setCountry(employ.getCountry());
			org.setRegion(employ.getRegion());
			org.setGrade(employ.getGrade());
			org.setIEsourcing(employ.getIesourcing());
			org.setJobe_title(employ.getJobeTitle());
			org.setRessoureceID(employ.getResurceId());
			org.setLadder(employ.getLadder());

			Affectation affectation = new Affectation();
			affectation = affectationMetier
					.getbyusername(employ.getResurceId());

			// System.out.println("affec : "+affectation.getIdaffectation());
			if (affectation.getIdaffectation() != null) {
				org.setLob(affectation.getLob().getName());
				org.setLineM(affectation.getUsersByUsersLm().getFullName());
				org.setHR(affectation.getUsersByUsersHr().getFullName());
			}

			orgList.add(org);

		}

		return orgList;
	}

}

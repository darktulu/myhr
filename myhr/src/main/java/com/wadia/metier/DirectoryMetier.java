/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wadia.metier;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.wadia.beans.Affectation;
import com.wadia.beans.EGeneralData;
import com.wadia.local.Directory;
import com.wadia.repos.EGeneralDataRepos;

/**
 *
 * @author toshiba
 */
@Service ("directoryMetier")
@Transactional
public class DirectoryMetier {

    @Inject
    private EGeneralDataRepos eGeneralDataRepos;
    @Inject
    private AffectationMetier affectationMetier;

    public List<Directory> findAll() {

        List<EGeneralData> listeEG = new ArrayList<EGeneralData>();
        List<Directory> listeD = new ArrayList<Directory>();

        listeEG = eGeneralDataRepos.findAll();

        for (EGeneralData employ : listeEG) {

            if (employ.getStatus().equals("ACTIVE")) {

                Affectation affectation = new Affectation();
                //affectation.setIdaffectation(0);
                Directory directory = new Directory();

                affectation = affectationMetier.getbyusername(employ.getResurceId());

                directory.setRessourceId(employ.getResurceId());
                directory.setRegion(employ.getRegion());
                directory.setMobileNumber(employ.getPMobile());
                directory.setLastname(employ.getSurname());
                directory.setFirstname(employ.getName());
                directory.setLandLineNumber(employ.getHmePhoneNumber());
                directory.setJobTitle(employ.getJobeTitle());
                directory.setIntExt(employ.getIesourcing());
                directory.setIdPhoto(employ.getIdPhoto());
                directory.setFaxNumber(employ.getBusinessFax());
                directory.setEmail(employ.getEmail());
                directory.setCountry(employ.getCountry());



                if (affectation.getIdaffectation() != null) {
                    directory.setLineManager(affectation.getUsersByUsersLm().getFullName());
                    directory.setDeparment(affectation.getLob().getName());
                }


                listeD.add(directory);

            }
        }
        return listeD;



    }
}

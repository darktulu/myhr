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

import com.wadia.beans.EEducationData;
import com.wadia.beans.EGeneralData;
import com.wadia.repos.EEducationDataRepos;
import com.wadia.repos.EGeneralDataRepos;

/**
 *
 * @author massin
 */
@Service
@Transactional
public class EducationfillMetier {
    
    @Inject
    private EEducationDataRepos eEducationDataRepos;
    @Inject
    private EGeneralDataRepos eGeneralDataRepos;
    
    public List<EducationHrMetier> listDiplome(){
        List<EGeneralData> eGenList = new ArrayList<EGeneralData>();
        List<EducationHrMetier> educationHrMetiers = new ArrayList<EducationHrMetier>();
        
        eGenList = eGeneralDataRepos.findAll();
       
        for (EGeneralData employ : eGenList) {
        EducationHrMetier educationHrMetier = new EducationHrMetier();
        educationHrMetier.setName(employ.getName());
        educationHrMetier.setUsername(employ.getResurceId());
        educationHrMetier.setEmployStatut(employ.getStatus());
        educationHrMetier.setSurname(employ.getSurname());
        List<EEducationData> eEducationDatas = new ArrayList<EEducationData>();
        eEducationDatas =findByUsername(employ.getResurceId());
        for (EEducationData educ :eEducationDatas){
        educationHrMetier.setAddressInstitut(educ.getAddressInstitut());
        educationHrMetier.setCourseStudy(educ.getCourseStudy());
        educationHrMetier.setDateFrom(educ.getDateFrom());
        educationHrMetier.setDateTo(educ.getDateTo());
        educationHrMetier.setIdEducation(educ.getIdEducation());
        educationHrMetier.setNameInstitut(educ.getNameInstitut());
        educationHrMetier.setType(educ.getType());
        
        }
        educationHrMetiers.add(educationHrMetier);
        }
        
        
        return educationHrMetiers;}
    
     public List<EEducationData> findByUsername(String username) {
         List<EEducationData> educationdatas;
        ArrayList<EEducationData> educToReturn = new ArrayList<EEducationData>();
        educationdatas = eEducationDataRepos.findAll();
        for (EEducationData educ : educationdatas) {
            if (educ.getResurceId().equals(username)) {
                educToReturn.add(educ);
            }
        }
        return (educToReturn);
    }
    
}

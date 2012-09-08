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
import com.wadia.repos.EEducationDataRepos;

/**
 * 
 * @author wadi3
 */
@Service("eEducationDataMetier")
@Transactional
public class EEducationDataMetier {

    @Inject
    private EEducationDataRepos eEducationDataRepos;

    public List<EEducationData> findByUsername(String username) {	
	return eEducationDataRepos.findByResurceId(username);
    }
    
    public List<EEducationData> findMyProfessionalTrain(String username) {	
	return eEducationDataRepos.findByResurceIdAndType(username,"Professional Training");
    }
    
    public List<EEducationData> findMyAcademincDeg(String username) {	
   	return eEducationDataRepos.findByResurceIdAndType(username,"Academic Degree");
       }

}

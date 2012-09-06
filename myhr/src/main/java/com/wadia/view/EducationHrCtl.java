/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wadia.view;

import com.wadia.metier.EducationHrMetier;
import com.wadia.metier.EducationfillMetier;
import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

/**
 *
 * @author massin
 */
@ManagedBean
@RequestScoped
public class EducationHrCtl {
    private List<EducationHrMetier> educationHrMetiers = new ArrayList<EducationHrMetier>();
    private EducationfillMetier educationfillMetier = new EducationfillMetier();
    
    public EducationHrCtl(){
    educationHrMetiers = educationfillMetier.listDiplome();
    }

    /**
     * @return the educationHrMetiers
     */
    public List<EducationHrMetier> getEducationHrMetiers() {
        return educationHrMetiers;
    }

    /**
     * @param educationHrMetiers the educationHrMetiers to set
     */
    public void setEducationHrMetiers(List<EducationHrMetier> educationHrMetiers) {
        this.educationHrMetiers = educationHrMetiers;
    }

    /**
     * @return the educationfillMetier
     */
    public EducationfillMetier getEducationfillMetier() {
        return educationfillMetier;
    }

    /**
     * @param educationfillMetier the educationfillMetier to set
     */
    public void setEducationfillMetier(EducationfillMetier educationfillMetier) {
        this.educationfillMetier = educationfillMetier;
    }
    
}

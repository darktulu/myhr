/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wadia.view;

import com.wadia.beans.EEducationData;
import com.wadia.metier.EEducationDataMetier;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;

/**
 *
 * @author massin
 */
@ManagedBean (name="EEducationCtl")
@RequestScoped
public class EEducationCtl {

    private List<EEducationData> educationList = new ArrayList<EEducationData>();
    private List<EEducationData> academicDeg = new ArrayList<EEducationData>();
    private List<EEducationData> professinalTr = new ArrayList<EEducationData>();
    
    @ManagedProperty(value="#{eEducationDataMetier}")
    private EEducationDataMetier eEducationDataMetier;
   
    private userController usercontroller = new userController();
   
    @PostConstruct
    public void init() {
        educationList = eEducationDataMetier.findByUsername(usercontroller.getUsername());
        for (EEducationData educ : educationList) {
            if (educ.getType().equals("Professional Training")) {
                professinalTr.add(educ);
            } else {
                academicDeg.add(educ);
            }
        }
    }

    public void update() {
        educationList = eEducationDataMetier.findByUsername(usercontroller.getUsername());
        for (EEducationData educ : educationList) {
            if (educ.getType().equals("Professional Training")) {
                professinalTr.add(educ);
            } else {
                academicDeg.add(educ);
            }
        }

    }

    /**
     * @return the educationList
     */
    public List<EEducationData> getEducationList() {
        return educationList;
    }

    /**
     * @param educationList the educationList to set
     */
    public void setEducationList(List<EEducationData> educationList) {
        this.educationList = educationList;
    }



    public List<EEducationData> getAcademicDeg() {
        return academicDeg;
    }

    public void setAcademicDeg(List<EEducationData> academicDeg) {
        this.academicDeg = academicDeg;
    }

    public List<EEducationData> getProfessinalTr() {
        return professinalTr;
    }

    public void setProfessinalTr(List<EEducationData> professinalTr) {
        this.professinalTr = professinalTr;
    }

    public EEducationDataMetier geteEducationDataMetier() {
        return eEducationDataMetier;
    }

    public void seteEducationDataMetier(EEducationDataMetier eEducationDataMetier) {
        this.eEducationDataMetier = eEducationDataMetier;
    }

    public userController getUsercontroller() {
        return usercontroller;
    }

    public void setUsercontroller(userController usercontroller) {
        this.usercontroller = usercontroller;
    }
    
}

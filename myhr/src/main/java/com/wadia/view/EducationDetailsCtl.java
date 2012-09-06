/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wadia.view;

import com.wadia.beans.EEducationData;
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
public class EducationDetailsCtl {
    private   static String IdToView;
    private static List<EEducationData> eDucationData = new ArrayList();
    private EducationfillMetier educationfillMetier = new EducationfillMetier();
    
    public EducationDetailsCtl(){
    }

    /**
     * @return the IdToView
     */
    public String getIdToView() {
        return IdToView;
    }

    /**
     * @param IdToView the IdToView to set
     */
    public void setIdToView(String IdToView) {
        this.IdToView = IdToView;
        if (IdToView != null) { 
            eDucationData = educationfillMetier.findByUsername(IdToView);
            
        }
    }

    /**
     * @return the eDucationData
     */
    public List<EEducationData> geteDucationData() {
        return eDucationData;
    }

    /**
     * @param eDucationData the eDucationData to set
     */
    public void seteDucationData(List<EEducationData> eDucationData) {
        this.eDucationData = eDucationData;
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

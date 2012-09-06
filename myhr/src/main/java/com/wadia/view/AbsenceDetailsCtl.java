/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wadia.view;
import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;

import com.wadia.beans.Abscence;
import com.wadia.metier.AbsencefillMetier;
import com.wadia.repos.AbscenceRepos;

/**
 *
 * @author ITR2012
 */
@ManagedBean (name="AbsenceDetailsCtl")
@RequestScoped
public class AbsenceDetailsCtl {
     private static String IdToView;
     private  static List<Abscence> abscence = new ArrayList();
    
     @ManagedProperty(value="#{abscenceRepos}")
     private AbscenceRepos abscenceRepos;
     @ManagedProperty(value="#{absencefillMetier}")
     private AbsencefillMetier absencefillMetier;

    public AbsenceDetailsCtl(){
    }
    /**
     * @return the IdToView
     */
    
    public void update(){
    if (IdToView != null) { 
            abscence = absencefillMetier.findByUsername(IdToView);
            
        }
    }
    
    public String getIdToView() {
        return IdToView;
    }

    /**
     * @param IdToView the IdToView to set
     */
    public void setIdToView(String IdToView) {
        this.IdToView = IdToView;
         if (IdToView != null) { 
            abscence = absencefillMetier.findByUsername(IdToView);
            
        }
    }

    /**
     * @return the abscence
     */
    public List<Abscence> getAbscence() {
        return abscence;
    }

    /**
     * @param abscence the abscence to set
     */
    public void setAbscence(List<Abscence> abscence) {
        this.abscence = abscence;
    }
    public AbscenceRepos getAbscenceRepos() {
        return abscenceRepos;
    }
    public void setAbscenceRepos(AbscenceRepos abscenceRepos) {
        this.abscenceRepos = abscenceRepos;
    }
    public AbsencefillMetier getAbsencefillMetier() {
        return absencefillMetier;
    }
    public void setAbsencefillMetier(AbsencefillMetier absencefillMetier) {
        this.absencefillMetier = absencefillMetier;
    }


    
    
}

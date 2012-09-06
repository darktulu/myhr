/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wadia.view;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;

import com.wadia.metier.AbsencefillMetier;
import com.wadia.metier.AbsencehrMetier;

/**
 *
 * @author ITR2012
 */
@ManagedBean (name="AbseenceHrCtl")
@RequestScoped
public class AbseenceHrCtl {
    @ManagedProperty(value="#{absencefillMetier}")
    private AbsencefillMetier absencefillMetier;
    private List<AbsencehrMetier>  absencehrMetier = new ArrayList<AbsencehrMetier>();
    private int totalAbscence; 
    private String search;
    
    @PostConstruct
    public void init()
    {
    absencehrMetier =absencefillMetier.listAbsence();
    
    }

    /**
     * @return the absencefillMetier
     */
    public AbsencefillMetier getAbsencefillMetier() {
        return absencefillMetier;
    }

    /**
     * @param absencefillMetier the absencefillMetier to set
     */
    public void setAbsencefillMetier(AbsencefillMetier absencefillMetier) {
        this.absencefillMetier = absencefillMetier;
    }

   
    public int getTotalAbscence() {
        return totalAbscence;
    }

    /**
     * @param totalAbscence the totalAbscence to set
     */
    public void setTotalAbscence(int totalAbscence) {
        this.totalAbscence = totalAbscence;
    }

    /**
     * @return the absencehrMetier
     */
    public List<AbsencehrMetier> getAbsencehrMetier() {
        return absencehrMetier;
    }

    /**
     * @param absencehrMetier the absencehrMetier to set
     */
    public void setAbsencehrMetier(List<AbsencehrMetier> absencehrMetier) {
        this.absencehrMetier = absencehrMetier;
    }

    public String getSearch() {
        return search;
    }

    public void setSearch(String search) {
        this.search = search;
        
        if (search != null) {


            List<AbsencehrMetier> leaveListSearchs = new ArrayList<AbsencehrMetier>();
             absencehrMetier =absencefillMetier.listAbsence();
            System.out.println("filtering employs... " + search);

            for (AbsencehrMetier absence : absencehrMetier) {

                if (absence.getUsername().toLowerCase().contains(search.toLowerCase())) {

                    leaveListSearchs.add(absence);
                }
            }
           // System.out.println("filtering employs... " + leaveListSearchs.size());
            absencehrMetier = leaveListSearchs;
        }
        
    }
    
}

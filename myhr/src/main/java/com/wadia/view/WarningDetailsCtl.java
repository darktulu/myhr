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

import com.wadia.beans.EWarningData;
import com.wadia.metier.WaringnfillMetier;
import com.wadia.repos.EWarningDataRepos;

/**
 *
 * @author ITR2012
 */
@ManagedBean
@RequestScoped
public class WarningDetailsCtl {
    private  static String IdToView;
    private static List<EWarningData> eWarningList = new ArrayList();

    @ManagedProperty(value = "#{eWarningDataRepos}")
    private EWarningDataRepos eWarningDataRepos;
    private WaringnfillMetier eMetier = new WaringnfillMetier();

    public EWarningDataRepos geteWarningDataRepos() {
        return eWarningDataRepos;
    }
    public void seteWarningDataRepos(EWarningDataRepos eWarningDataRepos) {
        this.eWarningDataRepos = eWarningDataRepos;
    }
    public WarningDetailsCtl(){
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
            eWarningList = eMetier.findByUsername(IdToView);
            
        }
    }

    /**
     * @return the eWarningList
     */
    public List<EWarningData> geteWarningList() {
        return eWarningList;
    }

    /**
     * @param eWarningList the eWarningList to set
     */
    public void seteWarningList(List<EWarningData> eWarningList) {
        this.eWarningList = eWarningList;
    }

    /**
     * @return the eMetier
     */
    public WaringnfillMetier geteMetier() {
        return eMetier;
    }

    /**
     * @param eMetier the eMetier to set
     */
    public void seteMetier(WaringnfillMetier eMetier) {
        this.eMetier = eMetier;
    }
    
    
}

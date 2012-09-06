/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wadia.view;

import com.wadia.beans.EContractData;
import com.wadia.local.fabrique;
import com.wadia.metier.ContratMetier;
import com.wadia.metier.ContrathrMetier;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import javax.faces.model.SelectItem;

/**
 *
 * @author toshiba
 */
@ManagedBean (name="ContratCtl")
@RequestScoped
public class ContratCtl implements Serializable {
    
    /**
     * 
     */
    private static final long serialVersionUID = 1L;

    @ManagedProperty(value = "#{contratMetier}")
    private ContratMetier contratMetier;

    private List<EContractData> eContractData = new ArrayList<EContractData>();
    private EContractData contratCourant = new EContractData();
    private userController usercontroller = new userController();
    private String search;

    /**
     * @return the eContractDataDao
     */
    @PostConstruct
    public void init() {

        contratCourant = contratMetier.getLastContrat(usercontroller.getUsername());
        eContractData =  contratMetier.contratHistory(usercontroller.getUsername());
    }

    public boolean contientS(List<SelectItem> list, SelectItem s) {
        for (SelectItem x : list) {
            if ((x.getValue()).equals(s.getValue())) {
                return true;
            }
        }
        return false;
    }

    /**
     * @return the eContractData
     */
    public List<EContractData> geteContractData() {
        return eContractData;
    }

    /**
     * @param eContractData the eContractData to set
     */
    public void seteContractData(List<EContractData> eContractData) {
        this.eContractData = eContractData;
    }

    public EContractData getContratCourant() {
        return contratCourant;
    }

    public void setContratCourant(EContractData contratCourant) {
        this.contratCourant = contratCourant;
    }

    public String getSearch() {
        return search;
    }

    public void setSearch(String search) {
        this.search = search;
        if (search != null) {
           // List<ContrathrMetier> contratListSearch = new ArrayList<ContrathrMetier>();
            fabrique fab = new fabrique();        
            List<EContractData> contratListSearch = new ArrayList<EContractData>();
             eContractData = contratMetier.contratHistory(usercontroller.getUsername());
           // System.out.println("filtering employs... " + search);
            
            for (EContractData contrat : eContractData) {
                
                if (contrat.getContractType().toLowerCase().contains(search.toLowerCase())
                    ||contrat.getContractStatus().toLowerCase().contains(search.toLowerCase())
                    ||contrat.getDescription().toLowerCase().contains(search.toLowerCase())
                    ||contrat.getResurceId().toLowerCase().contains(search.toLowerCase())  ) {
                    contratListSearch.add(contrat);
                }
                
               
            
            }
             
             eContractData = contratListSearch;
             
        }
        
        if(search==null){
            
             eContractData = contratMetier.contratHistory(usercontroller.getUsername());
        
        }
        
        
    }


    public ContratMetier getContratMetier() {
        return contratMetier;
    }

    public void setContratMetier(ContratMetier contratMetier) {
        this.contratMetier = contratMetier;
    }

    public userController getUsercontroller() {
        return usercontroller;
    }

    public void setUsercontroller(userController usercontroller) {
        this.usercontroller = usercontroller;
    }
   
    
    
}

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wadia.view;


import com.wadia.local.fabrique;
import com.wadia.metier.ContrathrMetier;
import com.wadia.metier.ContrathrfillMetier;
import com.wadia.metier.DirectoryMetier;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.ViewScoped;

/**
 *
 * @author Wadi3
 */
@ManagedBean (name="ContratHrCtl")
@ViewScoped
public class ContratHrCtl implements Serializable {
   
    private List<ContrathrMetier> listContr = new ArrayList<ContrathrMetier>();
   
    
    private ContrathrfillMetier contrathrfillMetier() {
        return SpringJSFUtil.getBean("contrathrfillMetier");
    }
    
    private String search;
    
    
    @PostConstruct
    public void init(){
         listContr = contrathrfillMetier().listContr();
         contrathrfillMetier().updateStatus(listContr);
         listContr = contrathrfillMetier().listContr();
    }

    /**
     * @return the listContr
     */
    public List<ContrathrMetier> getListContr() {
        return listContr;
    }

    /**
     * @param listContr the listContr to set
     */
    public void setListContr(List<ContrathrMetier> listContr) {
        this.listContr = listContr;
    }


    public String getSearch() {
        return search;
    }

    public void setSearch(String search) {
        this.search = search;
        
                if (search != null) {
            fabrique fab = new fabrique();        
            HashSet<ContrathrMetier> contratListSearch = new HashSet<ContrathrMetier>();
            //System.out.println("filtering employs... " + search);
            listContr = contrathrfillMetier().listContr();
            for (ContrathrMetier contrat : listContr) {
                
                if (contrat.getName().toLowerCase().contains(search.toLowerCase())
                    ||contrat.getSurname().toLowerCase().contains(search.toLowerCase())
                    ||contrat.getUsername().toLowerCase().contains(search.toLowerCase())
                    ||contrat.getEmployStatut().toLowerCase().contains(search.toLowerCase())  ) {
                    contratListSearch.add(contrat);
                }
                
                if(contrat.getContratStatut()!=null){
                
                    if(contrat.getContratStatut().toLowerCase().contains(search.toLowerCase())){
                    contratListSearch.add(contrat);
                    }
                }
                
                if(contrat.getContratType()!=null){
                
                    if(contrat.getContratType().toLowerCase().contains(search.toLowerCase())){
                    contratListSearch.add(contrat);
                    }
                }
            
            }
             //System.out.println("pchakh : " + contratListSearch.size());
             listContr.clear();
             listContr.addAll(fab.toArray(contratListSearch));
             
             //System.out.println("pchakh 2 : " + listContr.size());
        }
    }


    }


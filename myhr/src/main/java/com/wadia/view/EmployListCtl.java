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

import com.wadia.beans.EGeneralData;
import com.wadia.local.fabrique;
import com.wadia.local.user;
import com.wadia.metier.fillMetier;
import com.wadia.repos.EGeneralDataRepos;

/**
 *
 * @author toshiba
 */

@ManagedBean (name="EmployListCtl")
@RequestScoped
public class EmployListCtl implements Cloneable {

    @ManagedProperty(value = "#{eGeneralDataRepos}")
    private EGeneralDataRepos eGeneralDataRepos;
    @ManagedProperty(value = "#{fillMetier}")
    private fillMetier fillMetier;

    
    private List<EGeneralData> listEmploys = new ArrayList<EGeneralData>();
   
    private int total;
    private int total_active;
    private static String search;
    
    @PostConstruct
    public void init() {

        listEmploys = eGeneralDataRepos.findAll();
        total = listEmploys.size();
        total_active = eGeneralDataRepos.findByStatus("ACTIVE").size();
    }

    public void update() {

	fillMetier.fill();


    }

    public void recherger() {

        listEmploys = eGeneralDataRepos.findAll();
    }

    public List<EGeneralData> getListEmploys() {
        return listEmploys;
    }

    public void setListEmploys(List<EGeneralData> listEmploys) {
        this.listEmploys = listEmploys;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public String getSearch() {
        return search;
    }

    public void setSearch(String search) {
        this.search = search;
         if (search != null) {
            System.out.println("filtering employs... " + search);
            listEmploys = eGeneralDataRepos.findAll();
            List<EGeneralData> EmploysListSearch = new ArrayList<EGeneralData>();
            for (EGeneralData employ : listEmploys) {
                if (employ.getResurceId().toLowerCase().contains(search.toLowerCase())
                    ||employ.getStatus().toLowerCase().contains(search.toLowerCase())
                    ||employ.getName().toLowerCase().contains(search.toLowerCase())
                    ||employ.getSurname().toLowerCase().contains(search.toLowerCase())) {
                    EmploysListSearch.add(employ);
                }
            }
            listEmploys = EmploysListSearch;
            System.out.println("taille... " + EmploysListSearch.size());

        }

    }


    public List<user> getusernames() {

        fabrique fab = new fabrique();

        return fab.getUsernameList();

    }

    public int getTotal_active() {
        return total_active;
    }

    public void setTotal_active(int total_active) {
        this.total_active = total_active;
    }
    
    public EGeneralDataRepos geteGeneralDataRepos() {
	return eGeneralDataRepos;
    }

    public void seteGeneralDataRepos(EGeneralDataRepos eGeneralDataRepos) {
	this.eGeneralDataRepos = eGeneralDataRepos;
    }

    public fillMetier getFillMetier() {
        return fillMetier;
    }

    public void setFillMetier(fillMetier fillMetier) {
        this.fillMetier = fillMetier;
    }
}

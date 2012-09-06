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

import com.wadia.beans.Abscence;
import com.wadia.metier.AbscenceMetier;

/**
 *
 * @author toshiba
 */
@ManagedBean (name="AbscenceListCtl")
@RequestScoped
public class AbscenceListCtl {

    private List<Abscence> listAbscences = new ArrayList<Abscence>();
    private userController user = new userController();
   
    @ManagedProperty(value="#{abscenceMetier}")
    private AbscenceMetier abscenceMetier;
    
    private String search;
    
    @PostConstruct
    public void init() {
        listAbscences = abscenceMetier.findByUsername(user.getUsername());
    }

    public List<Abscence> getListAbscences() {
        return listAbscences;
    }

    public void setListAbscences(List<Abscence> listAbscences) {
        this.listAbscences = listAbscences;
    }

    public String getSearch() {
        return search;
    }

    public void setSearch(String search) {
        this.search = search;

        if (search != null) {


            List<Abscence> leaveListSearchs = new ArrayList<Abscence>();
            listAbscences = abscenceMetier.findByUsername(user.getUsername());
            System.out.println("filtering employs... " + search);

            for (Abscence absence : listAbscences) {

                if (absence.getJustified().toLowerCase().contains(search.toLowerCase())
                        || absence.getPayed().toLowerCase().contains(search.toLowerCase())
                        || absence.getRessourceId().toLowerCase().contains(search.toLowerCase())
                        || absence.getType().toLowerCase().contains(search.toLowerCase())) {

                    leaveListSearchs.add(absence);
                }
            }
            System.out.println("filtering employs... " + leaveListSearchs.size());
            listAbscences = leaveListSearchs;
        }
    }

    public userController getUser() {
        return user;
    }

    public void setUser(userController user) {
        this.user = user;
    }

    public AbscenceMetier getAbscenceMetier() {
        return abscenceMetier;
    }

    public void setAbscenceMetier(AbscenceMetier abscenceMetier) {
        this.abscenceMetier = abscenceMetier;
    }
}

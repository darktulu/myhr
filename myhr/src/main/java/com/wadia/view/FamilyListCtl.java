/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wadia.view;

import com.wadia.local.family;
import com.wadia.metier.famillyMetier;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;

/**
 *
 * @author toshiba
 */
@ManagedBean (name="FamilyListCtl")
@RequestScoped
public class FamilyListCtl {
    @ManagedProperty(value="#{famillyMetier}")
    private famillyMetier famillyMetier;
    private List<family> listFamily = new ArrayList<family>();
    private String search;
    @PostConstruct
    public void init() {

        listFamily = famillyMetier.family();
    }

    public List<family> getListFamily() {
        return listFamily;
    }

    public void setListFamily(List<family> listFamily) {
        this.listFamily = listFamily;
    }

    public String getSearch() {
        return search;
    }

    public void setSearch(String search) {
        this.search = search;
        if (search != null) {
            List<family> employsListSearch = new ArrayList<family>();
            //System.out.println("filtering employs... " + search);
            listFamily = famillyMetier.family();
            for (family fam : listFamily) {
                if (fam.getName().toLowerCase().contains(search.toLowerCase())
                        || fam.getUsername().toLowerCase().contains(search.toLowerCase())) {
                    employsListSearch.add(fam);
                }
            }
            listFamily = employsListSearch;
        }
    }

    public famillyMetier getFamillyMetier() {
        return famillyMetier;
    }

    public void setFamillyMetier(famillyMetier famillyMetier) {
        this.famillyMetier = famillyMetier;
    }
}

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wadia.view;

import com.wadia.local.family;
import com.wadia.metier.famillyMetier;
import com.wadia.service.FamilyService;
import com.wadia.service.OrganizationalService;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.ViewScoped;

/**
 *
 * @author toshiba
 */
@ManagedBean (name="FamilyListCtl")
@ViewScoped
public class FamilyListCtl implements Serializable {

    private List<family> listFamily = new ArrayList<family>();
    private String search;
    
    private FamilyService familyService() {
        return SpringJSFUtil.getBean("familyService");
    }
    
    @PostConstruct
    public void init() {

        listFamily = familyService().myFamily();
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
            listFamily = familyService().myFamily();
            for (family fam : listFamily) {
                if (fam.getName().toLowerCase().contains(search.toLowerCase())
                        || fam.getUsername().toLowerCase().contains(search.toLowerCase())) {
                    employsListSearch.add(fam);
                }
            }
            listFamily.clear();
            listFamily.addAll(employsListSearch);
            
        }
    }

}

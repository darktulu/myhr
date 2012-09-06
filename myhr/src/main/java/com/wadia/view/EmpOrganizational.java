/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wadia.view;

import com.wadia.beans.EGeneralData;
import com.wadia.metier.OrgFillMetier;
import com.wadia.metier.OrganizationaMetier;
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
@ManagedBean(name="EmpOrganizational")
@RequestScoped
public class EmpOrganizational {

    private List<OrganizationaMetier> listOrganiz = new ArrayList<OrganizationaMetier>();
    private static OrganizationaMetier orgToview = new OrganizationaMetier();
    private String OrgToEdit;
    private String search;
    @ManagedProperty("#{orgFillMetier}")
    private OrgFillMetier orgFillMetier;
    
    @PostConstruct
    public void init(){
    
        listOrganiz = orgFillMetier.listOrg();
     
    
    }
    
    
    public static OrganizationaMetier getOrgToview() {
        return orgToview;
    }

    public static void setOrgToview(OrganizationaMetier aOrgToview) {
        orgToview = aOrgToview;
    }

    public List<OrganizationaMetier> getListOrganiz() {
        return listOrganiz;
    }

    public void setListOrganiz(List<OrganizationaMetier> listOrganiz) {
        this.listOrganiz = listOrganiz;
    }


    public String getOrgToEdit() {
        return OrgToEdit;
    }
    
    public void setOrgToEdit(String OrgToEdit) {
        this.OrgToEdit = OrgToEdit;
        
       /* if(OrgToEdit!=null){
            
            System.out.println(""+OrgToEdit);
            orgToview = orgfill.getByUsername(OrgToEdit);
            System.out.println("howa hada : "+orgToview.toString());
        
        }*/
        
    }

    public String getSearch() {
        return search;
    }

    public void setSearch(String search) {
        this.search = search;
        if(search!=null){
        listOrganiz = orgFillMetier.listOrg();
        List<OrganizationaMetier> listSearch = new ArrayList<OrganizationaMetier>();    
        
        for(OrganizationaMetier org : listOrganiz){
        
            if(org.getName().toLowerCase().contains(search.toLowerCase())
               ||org.getSurname().toLowerCase().contains(search.toLowerCase())){
            
                listSearch.add(org);
            }
        }
        listOrganiz = listSearch;
        
        }
    }


    public OrgFillMetier getOrgFillMetier() {
        return orgFillMetier;
    }


    public void setOrgFillMetier(OrgFillMetier orgFillMetier) {
        this.orgFillMetier = orgFillMetier;
    }
}

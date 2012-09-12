/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wadia.view;

import com.wadia.beans.EGeneralData;
import com.wadia.metier.OrgFillMetier;
import com.wadia.metier.OrganizationaMetier;
import com.wadia.repos.EGeneralDataRepos;
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
 * @author wadi3
 */
@ManagedBean(name="EmpOrganizational")
@ViewScoped
public class EmpOrganizational implements Serializable {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private List<OrganizationaMetier> listOrganiz = new ArrayList<OrganizationaMetier>();
    private String OrgToEdit;
    private String search;

    
    private OrganizationalService organizationalService() {
        return SpringJSFUtil.getBean("organizationalService");
    }
    
    @PostConstruct
    public void init(){
    
        listOrganiz = organizationalService().listOrg();
     
    
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
        listOrganiz = organizationalService().listOrg();
        List<OrganizationaMetier> listSearch = new ArrayList<OrganizationaMetier>();    
        
        for(OrganizationaMetier org : listOrganiz){
        
            if(org.getName().toLowerCase().contains(search.toLowerCase())
               ||org.getSurname().toLowerCase().contains(search.toLowerCase())
               ||org.getRessoureceID().toLowerCase().contains(search.toLowerCase())){
            
                listSearch.add(org);
            }
        }
        listOrganiz.clear();
        listOrganiz.addAll(listSearch);
        
        }
    }


   
}

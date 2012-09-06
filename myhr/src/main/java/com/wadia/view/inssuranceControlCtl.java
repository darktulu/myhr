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

import com.wadia.beans.EGeneralData;
import com.wadia.beans.EInsurranceData;
import com.wadia.metier.InssuranceMetier;
import com.wadia.repos.EGeneralDataRepos;

/**
 *
 * @author toshiba
 */
@ManagedBean (name="inssuranceControlCtl")
@RequestScoped
public class inssuranceControlCtl {
  private static List<EInsurranceData> listInssurance = new ArrayList<EInsurranceData>();
   
    private static Integer number;
    private static String name;
    private static String surname;
    private static String username;
    private static String CIN;
    private static String CNSS;
    private static String inssuranceid;
    private  String idToEdit;
    
    @ManagedProperty(value = "#{eGeneralDataRepos}")
    private EGeneralDataRepos eGeneralDataRepos;
    @ManagedProperty(value = "#{inssuranceMetier}")
    private InssuranceMetier inssuranceMetier;
   
    public EGeneralDataRepos geteGeneralDataRepos() {
	return eGeneralDataRepos;
    }

    public void seteGeneralDataRepos(EGeneralDataRepos eGeneralDataRepos) {
	this.eGeneralDataRepos = eGeneralDataRepos;
    }
    public inssuranceControlCtl(){}

    public List<EInsurranceData> getListInssurance() {
        return listInssurance;
    }

    public void setListInssurance(List<EInsurranceData> listInssurance) {
        this.listInssurance = listInssurance;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getCIN() {
        return CIN;
    }

    public void setCIN(String CIN) {
        this.CIN = CIN;
    }

    public String getCNSS() {
        return CNSS;
    }

    public void setCNSS(String CNSS) {
        this.CNSS = CNSS;
    }

    public String getIdToEdit() {
        return idToEdit;
    }

    public void setIdToEdit(String idToEdit) {
        this.idToEdit = idToEdit;
        if(idToEdit!=null){
        
            listInssurance = inssuranceMetier.findByUsername(idToEdit);
            number = inssuranceMetier.personnePrisEnCharge(idToEdit);
            EGeneralData data = new EGeneralData();
            data = eGeneralDataRepos.findOne(idToEdit);
            name = data.getName();
            surname = data.getSurname();
            username = data.getResurceId();
            CIN     =  data.getCin();
            CNSS    =  data.getCnss();
            inssuranceid = idToEdit;        
            
            
        }
    }
    
    public void update(){
    
        if(inssuranceid!=null){
            
            listInssurance = inssuranceMetier.findByUsername(inssuranceid);
            number = inssuranceMetier.personnePrisEnCharge(inssuranceid);
        
        }
    
    }

    public String getInssuranceid() {
        return inssuranceid;
    }

    public void setInssuranceid(String inssuranceid) {
        this.inssuranceid = inssuranceid;
    }

    public InssuranceMetier getInssuranceMetier() {
        return inssuranceMetier;
    }

    public void setInssuranceMetier(InssuranceMetier inssuranceMetier) {
        this.inssuranceMetier = inssuranceMetier;
    }
    
    
    
}

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wadia.view;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;

import com.wadia.beans.EInsurranceData;
import com.wadia.repos.EInsurranceDataRepos;

/**
 *
 * @author toshiba
 */
@ManagedBean (name="InssuranceStatusCtl")
@RequestScoped
public class InssuranceStatusCtl {
    
    private int idToEdit = 0;
    private String description;
    private static EInsurranceData data = new EInsurranceData(); 
    
    @ManagedProperty(value = "#{eInsurranceDataRepos}")
    private EInsurranceDataRepos eInsurranceDataRepos;
    

            

    public int getIdToEdit() {
        return idToEdit;
    }

    public void setIdToEdit(int idToEdit) {
        this.idToEdit = idToEdit;
        
        if(idToEdit!=0){
            
            data = eInsurranceDataRepos.findOne(idToEdit);
        
        }
    }
    
    public void sendToHr(){
    
        if(data.getMatricule()!=null){
        
            data.setStatus("Submited To HR");
            eInsurranceDataRepos.save(data);
        
        }
    
    }
    
    public void sendToInssurance(){
    
        if(data.getMatricule()!=null){
        
            data.setStatus("Submited to Insurance");
            eInsurranceDataRepos.save(data);
        
        }
    
    }
    
    public void inprogress(){
    
        if(data.getMatricule()!=null){
        
            data.setStatus("In progess with Insurance");
            eInsurranceDataRepos.save(data);
        
        }
    
    }
    
    public void accepted(){
    
        if(data.getMatricule()!=null){
        
            data.setStatus("Accepted by insurrance");
            eInsurranceDataRepos.save(data);
        
        }
    
    }
    
    public void refused(){
    
        if(data.getMatricule()!=null){
        
            data.setStatus("Rejected by insurrance");
            data.setStatusDescription(description);
            eInsurranceDataRepos.save(data);
        
        }
    
    }
    
     public void reedit(){
    
        if(data.getMatricule()!=null){
        
            data.setStatus("Edited");
            data.setStatusDescription(" ");
            eInsurranceDataRepos.save(data);
        
        }
    
    }
    
      public void acknowlege(){
    
        if(data.getMatricule()!=null){
        
            data.setStatus("HR Acknoledge receiving");
            eInsurranceDataRepos.save(data);
        
        }
    
    }
    
    public void pr(){
    
        if(data.getMatricule()!=null){
            EInsurranceData datas = new EInsurranceData(data.getResurceId(), data.getMatricule(), data.getDate(), data.getType(), data.getDateSoins(), data.getDossier(), data.getPersonName(), data.getTotalAmount(),"Payement received", data.getStatusDescription());
            datas.setInssuranceId(data.getInssuranceId());
            eInsurranceDataRepos.save(datas);
        
        }
    
    }

    public EInsurranceData getData() {
        return data;
    }

    public void setData(EInsurranceData data) {
        this.data = data;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public EInsurranceDataRepos geteInsurranceDataRepos() {
        return eInsurranceDataRepos;
    }

    public void seteInsurranceDataRepos(EInsurranceDataRepos eInsurranceDataRepos) {
        this.eInsurranceDataRepos = eInsurranceDataRepos;
    }
    
}

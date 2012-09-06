/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wadia.view;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;

import com.wadia.beans.Echarge;
import com.wadia.repos.EchargeRepos;

/**
 *
 * @author toshiba
 */
@ManagedBean
@RequestScoped
public class ChargeEditCtl {
    @ManagedProperty(value="#{echargeRepos}")
    private EchargeRepos echargeRepos;
    
    
    public EchargeRepos getEchargeRepos() {
        return echargeRepos;
    }

    public void setEchargeRepos(EchargeRepos echargeRepos) {
        this.echargeRepos = echargeRepos;
    }

    private static Echarge data = new Echarge();
    private int idToDelete = 0;
    
    public void ChargeEditCtl(){}
    
    public String delete(){
    
      if(data!=null){
      
	  echargeRepos.delete(data);
          
      }  
      return "ok";
    
    }

    public Echarge getData() {
        return data;
    }

    public void setData(Echarge data) {
        this.data = data;
    }

    public int getIdToDelete() {
        return idToDelete;
    }

    public void setIdToDelete(int idToDelete) {
        this.idToDelete = idToDelete;
        if(idToDelete!=0){
        
            data = echargeRepos.findOne(idToDelete);
        
        }
    }
    
    
    
}

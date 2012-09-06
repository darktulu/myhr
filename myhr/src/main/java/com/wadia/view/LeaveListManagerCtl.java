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
import com.wadia.beans.ELData;
import com.wadia.metier.AffectationMetier;
import com.wadia.metier.myTeamMetier;

/**
 *
 * @author toshiba
 */
@ManagedBean (name="LeaveListManagerCtl")
@RequestScoped
public class LeaveListManagerCtl {
    
   private userController user = new userController();
   private List<ELData> teamLeaves = new ArrayList<ELData>();
   @ManagedProperty(value="#{affectationMetier}")
   private AffectationMetier affectationMetier;
   private List<EGeneralData> team = new ArrayList<EGeneralData>();
  
   @PostConstruct
   public void init(){
   
       team = affectationMetier.getbyManager(user.getUsername());
               
   }

    public List<ELData> getTeamLeaves() {
        return teamLeaves;
    }

    public void setTeamLeaves(List<ELData> teamLeaves) {
        this.teamLeaves = teamLeaves;
    }

    public List<EGeneralData> getTeam() {
        return team;
    }

    public void setTeam(List<EGeneralData> team) {
        this.team = team;
    }

    public userController getUser() {
        return user;
    }

    public void setUser(userController user) {
        this.user = user;
    }

    public AffectationMetier getAffectationMetier() {
        return affectationMetier;
    }

    public void setAffectationMetier(AffectationMetier affectationMetier) {
        this.affectationMetier = affectationMetier;
    }
    
}

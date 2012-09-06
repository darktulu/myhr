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

import com.wadia.beans.EFunctionalData;
import com.wadia.beans.EGeneralData;
import com.wadia.beans.ELData;
import com.wadia.metier.AffectationMetier;
import com.wadia.metier.TeamCalendarMetier;
import com.wadia.repos.AffectationRepos;
import com.wadia.repos.EFunctionalDataRepos;
import com.wadia.repos.EGeneralDataRepos;

/**
 * 
 * @author ITR2012
 */
@ManagedBean
@RequestScoped
public class teamCalendarCtl {

    @ManagedProperty(value = "#{teamCalendarMetier}")
    private TeamCalendarMetier teamCalendarMetier;

    private userController usercontroller = new userController();
    private List<ELData> list = new ArrayList<ELData>();

    @PostConstruct
    public void init() {

    list = teamCalendarMetier.myTeamLeaves(usercontroller.getUsername());
    }

    public TeamCalendarMetier getTeamCalendarMetier() {
        return teamCalendarMetier;
    }

    public void setTeamCalendarMetier(TeamCalendarMetier teamCalendarMetier) {
        this.teamCalendarMetier = teamCalendarMetier;
    }

    public userController getUsercontroller() {
        return usercontroller;
    }

    public void setUsercontroller(userController usercontroller) {
        this.usercontroller = usercontroller;
    }

    public List<ELData> getList() {
        return list;
    }

    public void setList(List<ELData> list) {
        this.list = list;
    }

    

}

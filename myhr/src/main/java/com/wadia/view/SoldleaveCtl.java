/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wadia.view;

import com.wadia.beans.Soldleave;
import com.wadia.local.sold;
import com.wadia.metier.SoldleaveMetier;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import javax.faces.event.ValueChangeEvent;

/**
 *
 * @author wadi3
 */
@ManagedBean (name="SoldleaveCtl")
@RequestScoped
public class SoldleaveCtl {
    @ManagedProperty(value="#{soldleaveMetier}")
    private SoldleaveMetier soldleaveMetier;
   
    private userController user = new userController();
    private List<sold> list = new ArrayList<sold>();
    private int day;
    private List<Integer> listDays = new ArrayList<Integer>();
    
    
   
   @PostConstruct
    public void init() {
        soldleaveMetier.updateSoldProvider(user.getUsername());
        list = soldleaveMetier.findbyusername(user.getUsername());
    }
    
    public void days(ValueChangeEvent event){
        int year = (Integer)event.getNewValue();
        List<Integer> listofDays = new ArrayList<Integer>();
        listofDays.add(year);    
        
    }

    public void update() {
        list = soldleaveMetier.findbyusername(user.getUsername());
    }

    public List<sold> getList() {
        return list;
    }

    public void setList(List<sold> list) {
        this.list = list;
    }

    public ArrayList<Integer> years() {

        ArrayList<Integer> years = new ArrayList<Integer>();
        List<sold> soldlist = new ArrayList<sold>();
        soldlist = soldleaveMetier.findbyusername(user.getUsername());
        for (sold sol : soldlist) {

            if (sol.getDelta() > 0) {

                years.add(sol.getYear());
            }
        }

        return years;

    }

    public int getDay() {
        return day;
    }

    public void setDay(int day) {
        this.day = day;
    }

    public List<Integer> getListDays() {
        return listDays;
    }

    public void setListDays(List<Integer> listDays) {
        this.listDays = listDays;
    }

    public SoldleaveMetier getSoldleaveMetier() {
        return soldleaveMetier;
    }

    public void setSoldleaveMetier(SoldleaveMetier soldleaveMetier) {
        this.soldleaveMetier = soldleaveMetier;
    }

    public userController getUser() {
        return user;
    }

    public void setUser(userController user) {
        this.user = user;
    }
}

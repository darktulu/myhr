/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wadia.view;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;

import com.wadia.metier.SalarySimpleMetier;
import com.wadia.metier.SalarySimplefillMetier;

/**
 *
 * @author ITR2012
 */
@ManagedBean (name="SalarySimpleCtl")
@RequestScoped
public class SalarySimpleCtl {
    
    @ManagedProperty(value = "#{salarySimplefillMetier}")
    private SalarySimplefillMetier salarySimplefillMetier;
    
    private SalarySimpleMetier salarySimpleMetier = new SalarySimpleMetier();  
    private userController usercontroller = new userController();
    
    @PostConstruct
    public void init(){
    salarySimpleMetier =salarySimplefillMetier.listSalary(usercontroller.getUsername());
    }

 

    public userController getUsercontroller() {
        return usercontroller;
    }



    public void setUsercontroller(userController usercontroller) {
        this.usercontroller = usercontroller;
    }



    /**
     * @return the salarySimplefillMetier
     */
    public SalarySimplefillMetier getSalarySimplefillMetier() {
        return salarySimplefillMetier;
    }

    /**
     * @param salarySimplefillMetier the salarySimplefillMetier to set
     */
    public void setSalarySimplefillMetier(SalarySimplefillMetier salarySimplefillMetier) {
        this.salarySimplefillMetier = salarySimplefillMetier;
    }

    /**
     * @return the salarySimpleMetier
     */
    public SalarySimpleMetier getSalarySimpleMetier() {
        return salarySimpleMetier;
    }

    /**
     * @param salarySimpleMetier the salarySimpleMetier to set
     */
    public void setSalarySimpleMetier(SalarySimpleMetier salarySimpleMetier) {
        this.salarySimpleMetier = salarySimpleMetier;
    }

    
    
}

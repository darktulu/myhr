/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wadia.view;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.ViewScoped;

import com.wadia.beans.Affectation;
import com.wadia.metier.AffectationMetier;

/**
 * 
 * @author toshiba
 */
@ManagedBean
@RequestScoped
public class affectationCtl extends BaseBean implements Serializable {

    private static final long serialVersionUID = 1L;
    private Affectation affectation = new Affectation();
    private userController user = new userController();
    
    @ManagedProperty(value = "#{affectationMetier}")
    private AffectationMetier affectationMetier;

    @PostConstruct
    public void init() {
	affectation = affectationMetier.getbyusername(user.getUsername());
    }

    public Affectation getAffectation() {
	return affectation;
    }

    public void setAffectation(Affectation affectation) {
	this.affectation = affectation;
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

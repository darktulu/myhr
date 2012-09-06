/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wadia.view;

import java.util.List;
import java.util.Set;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;

import org.springframework.security.core.GrantedAuthority;

import com.wadia.beans.Authorities;
import com.wadia.repos.UsersRepos;

/**
 * 
 * @author toshiba
 */
@ManagedBean
@RequestScoped
public class authByRoleCtl {

    private userController user = new userController();
    @ManagedProperty(value = "#{usersRepos}")
    private UsersRepos usersRepos;
    private boolean RH = false;
    private boolean PM = false;
   
    @PostConstruct
    public void init(){
	RH = ressourcRH();
	PM = ressourcPM();		
    }
    
    public boolean ressourcRH() {
	Set<Authorities> authoritieses;
	boolean var = false;
	authoritieses = usersRepos.findOne(user.getUsername()).getAuthoritieses();
	
	for (Authorities aut : authoritieses) {
	   
	    if (aut.getId().getAuthority().equals("ROLE_RH")) {
		var = true;

	    }

	}

	return var;
    }

    public boolean ressourcPM() {
	Set<Authorities> authoritieses;
	boolean var = false;
	authoritieses = usersRepos.findOne(user.getUsername()).getAuthoritieses();
	for (Authorities aut : authoritieses) {
	    if (aut.getId().getAuthority().equals("ROLE_PM")) {
		var = true;

	    }

	}
	return var;
    }

    public userController getUser() {
	return user;
    }

    public void setUser(userController user) {
	this.user = user;
    }

    public UsersRepos getUsersRepos() {
	return usersRepos;
    }

    public void setUsersRepos(UsersRepos usersRepos) {
	this.usersRepos = usersRepos;
    }


    public boolean isPM() {
        return PM;
    }

    public void setPM(boolean pM) {
        PM = pM;
    }

    public boolean isRH() {
        return RH;
    }

    public void setRH(boolean rH) {
        RH = rH;
    }
}

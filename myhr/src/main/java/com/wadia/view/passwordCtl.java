/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wadia.view;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;

import com.wadia.beans.Users;
import com.wadia.metier.PasswordMetier;
import com.wadia.repos.UsersRepos;

/**
 * 
 * @author toshiba
 */

@ManagedBean
@RequestScoped
public class passwordCtl {

    private String oldPassword;
    private String newPassword;
    private String again;
    private userController userc = new userController();
    private PasswordMetier passwordMetier = new PasswordMetier();

    @ManagedProperty(value = "#{usersRepos}")
    private UsersRepos usersRepos;

    public UsersRepos getUsersRepos() {
	return usersRepos;
    }

    public void setUsersRepos(UsersRepos usersRepos) {
	this.usersRepos = usersRepos;
    }

    public passwordCtl() {
    }

    public void save() {

	Users user = new Users();
	user = usersRepos.findByUsername(userc.getUsername());
	if (user.getPassword().equals(passwordMetier.stringToMD5(oldPassword)) && newPassword.equals(again)) {

	    passwordMetier.save(newPassword, userc.getUsername());
	}

    }

    public String getOldPassword() {
	return oldPassword;
    }

    public void setOldPassword(String oldPassword) {
	this.oldPassword = oldPassword;
    }

    public String getNewPassword() {
	return newPassword;
    }

    public void setNewPassword(String newPassword) {
	this.newPassword = newPassword;
    }

    public String getAgain() {
	return again;
    }

    public void setAgain(String again) {
	this.again = again;
    }
}

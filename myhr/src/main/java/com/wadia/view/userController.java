/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wadia.view;

import java.io.Serializable;
import java.util.Calendar;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;

import org.springframework.security.core.context.SecurityContextHolder;

import com.wadia.authentification.Users;
import com.wadia.repos.UsersRepos;


/**
 *
 * @author toshiba
 */
@ManagedBean
@SessionScoped
public class userController implements Serializable{

    private static final long serialVersionUID = 1L;
    private Users user = new Users();
    private String username;
    
    @ManagedProperty(value="#{usersRepos}")
    private UsersRepos usersRepos;
    
    private String fullname;

    
    /**
     * @return the user
     */
    @PostConstruct
    public  void init(){
	
	fullname = usersRepos.findByUsername(SecurityContextHolder.getContext().getAuthentication().getName()).getFullName();
	
    }
    
    public Users getUser() {
	user.setUsername(SecurityContextHolder.getContext().getAuthentication().getName());
        return user;
    }

    /**
     * @param user the user to set
     */
    public void setUser(Users user) {
        this.user = user;
    }

    /**
     * @return the username
     */
    public String getUsername() {
        username = SecurityContextHolder.getContext().getAuthentication().getName();
        return username;
    }

    /**
     * @param username the username to set
     */
    public void setUsername(String username) {
        this.username = username;
    }

    public String logDate() {
        Calendar rightNow = Calendar.getInstance();
        rightNow.toString();
        return " "+rightNow.getTime();
     }
    
    public UsersRepos getUsersRepos() {
        return usersRepos;
    }

    public void setUsersRepos(UsersRepos usersRepos) {
        this.usersRepos = usersRepos;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }
    
}

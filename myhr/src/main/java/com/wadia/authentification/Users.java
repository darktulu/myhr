package com.wadia.authentification;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.GrantedAuthorityImpl;
import org.springframework.security.core.userdetails.UserDetails;

import com.wadia.beans.Authorities;

public class Users implements java.io.Serializable, UserDetails {

    private String username;
    private String password;
    private String info;
    private String firstname;
    private String lastname;
    private String info2;
    private List<GrantedAuthority> authoritieses;

    public Users() {
    }

    public Users(String username) {
	this.username = username;
    }

    public Users(String username, String password, boolean enabled, boolean accountNonExpired,
	    boolean credentialsNonExpired, boolean accountNonLocked, List<GrantedAuthority> list) {
	this.username = username;
	this.password = password;
	this.authoritieses = list ;
    }

    public String getFullName() {
	return firstname + " " + lastname;
    }

    @Override
    public String getUsername() {
	return this.username;
    }

    public void setUsername(String username) {
	this.username = username;
    }

    @Override
    public String getPassword() {
	return this.password;
    }

    public void setPassword(String password) {
	this.password = password;
    }

    public String getInfo() {
	return this.info;
    }

    public void setInfo(String info) {
	this.info = info;
    }

    public String getInfo2() {
	return this.info2;
    }

    public void setInfo2(String info2) {
	this.info2 = info2;
    }

    public List getAuthoritieses() {
	return authoritieses;
    }

    public void setAuthoritieses(List authoritieses) {
	this.authoritieses = authoritieses;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
	return authoritieses;
    }

    @Override
    public boolean isAccountNonExpired() {
	return true;
    }

    @Override
    public boolean isAccountNonLocked() {
	return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
	return true;
    }

    @Override
    public boolean isEnabled() {
	return true;
    }

    public String getFirstname() {
	return firstname;
    }

    public void setFirstname(String firstname) {
	this.firstname = firstname;
    }

    public String getLastname() {
	return lastname;
    }

    public void setLastname(String lastname) {
	this.lastname = lastname;
    }

    @Override
    public String toString() {
	return "username : " + username + " password : " + password + " authorities :" + authoritieses;
    }
}

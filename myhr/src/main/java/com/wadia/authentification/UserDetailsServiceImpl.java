/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wadia.authentification;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.wadia.beans.Authorities;
import com.wadia.beans.Users;
import com.wadia.repos.UsersRepos;



/**
 *
 * @author hatim
 */
@Service("userDetailsService")
@Transactional
public class UserDetailsServiceImpl implements UserDetailsService {

    protected static Logger logger = Logger.getLogger("UserDetailsService");

    @Autowired
    private UsersRepos usersRepos;

    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
	try {
	    Users users = usersRepos.findByUsername(username);

	    boolean enabled = true;
	    boolean accountNonExpired = true;
	    boolean credentialsNonExpired = true;
	    boolean accountNonLocked = true;
	    return new com.wadia.authentification.Users(users.getUsername(), users.getPassword(), enabled, accountNonExpired,
		    credentialsNonExpired, accountNonLocked, getGrantedAuthorities(users.getAuthoritieses()));
	} catch (Exception e) {
	    throw new RuntimeException(e);
	}
    }

    public static List<GrantedAuthority> getGrantedAuthorities(Set<Authorities> roles) {
	List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
	if(roles == null) return authorities;
	for (Authorities role : roles) {
	    authorities.add(new SimpleGrantedAuthority(role.getId().getAuthority()));
	}
	return authorities;
    }
}
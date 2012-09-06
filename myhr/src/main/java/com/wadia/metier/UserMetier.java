/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wadia.metier;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.inject.Inject;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.wadia.beans.Authorities;
import com.wadia.beans.AuthoritiesId;
import com.wadia.beans.Users;
import com.wadia.repos.UsersRepos;

/**
 *
 * @author toshiba
 */
@Service
@Transactional
public class UserMetier {

    @Inject
    private UsersRepos usersRepos;

    public void saveUser(Users user, List<String> roles) {
        Set<Authorities> auths = new HashSet<Authorities>();

        if (roles.contains("admin")) {
            auths.add(new Authorities(new AuthoritiesId("ROLE_ADMIN", user.getUsername()), user));
        }
        if (roles.contains("invoice")) {
            auths.add(new Authorities(new AuthoritiesId("ROLE_USER", user.getUsername()), user));
        }
        if (roles.contains("buy")) {
            auths.add(new Authorities(new AuthoritiesId("ROLE_BUY", user.getUsername()), user));
        }
        if (roles.contains("ome")) {
            auths.add(new Authorities(new AuthoritiesId("ROLE_OME", user.getUsername()), user));
        }
        if (roles.contains("wtr")) {
            auths.add(new Authorities(new AuthoritiesId("ROLE_WTR", user.getUsername()), user));
        }
        
        user.setAuthoritieses(auths);
        usersRepos.save(user);
    }
    
}

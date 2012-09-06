/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wadia.metier;

import java.security.MessageDigest;

import javax.inject.Inject;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.wadia.beans.Users;
import com.wadia.repos.UsersRepos;

/**
 *
 * @author toshiba
 */
@Service
@Transactional
public class PasswordMetier {
    
    @Inject
    private UsersRepos usersRepos;
    
    public void save(String password, String username){
    
        Users user = new Users();
        user = usersRepos.findByUsername(username);

        user.setPassword(stringToMD5(password));
        usersRepos.save(user);
    }
    
    public String stringToMD5(String password){
    String passwordMD5 = "";
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            byte[] md5 = md.digest(password.getBytes());
            StringBuffer sb = new StringBuffer();
            for (int i = 0; i < md5.length; i++) {
                sb.append(Integer.toString((md5[i] & 0xff) + 0x100, 16).substring(1));
            }
            passwordMD5 = sb.toString();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return passwordMD5;
    
    }
    
}

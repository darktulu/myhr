/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wadia.view;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import com.wadia.beans.Users;
import com.wadia.metier.UserMetier;

/**
 *
 * @author hatim
 */
@ManagedBean
@RequestScoped
public class userCtl {
    //<>

    private String username;
    private String firstname;
    private String lastname;
    private String password;
    private String info1;
    private List<String> roles;
    private UserMetier userMetier = new UserMetier();
    private String oldpass;
    private String newpass1;
    private String newpass;

    public userCtl() {
    }

    public String saveUser() {
        Users u = new Users(username, password, info1, "", firstname, lastname, null, null, null, null, null);
        userMetier.saveUser(u, roles);
        return "ok";
    }

   /* public String savePassword() {
        System.out.println("savePassword: [" + newpass + "|" + newpass1 + "] " + newpass.equals(newpass1));
        if (!newpass.equals(newpass1)) {
            return null;
        }
        System.out.println("...");
        String passwordMD5 = "";
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            byte[] md5 = md.digest(newpass.getBytes());
            StringBuffer sb = new StringBuffer();
            for (int i = 0; i < md5.length; i++) {
                sb.append(Integer.toString((md5[i] & 0xff) + 0x100, 16).substring(1));
            }
            passwordMD5 = sb.toString();
            UserDao dao = new UserDao();
            String id = SecurityContextHolder.getContext().getAuthentication().getName();
            dao.update(id, passwordMD5);
            newpass = newpass1 = oldpass = "";
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "ok";
    }*/

    public String getPassword() {
        return password;
    }

    public String getInfo1() {
        return info1;
    }

    public void setInfo1(String info1) {
        this.info1 = info1;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public String getNewpass1() {
        return newpass1;
    }

    public void setNewpass1(String newpass1) {
        this.newpass1 = newpass1;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setUserMetier(UserMetier userMetier) {
        this.userMetier = userMetier;
    }

    public List<String> getRoles() {
        return roles;
    }

    public void setRoles(List<String> roles) {
        this.roles = roles;
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

    public String getNewpass() {
        return newpass;
    }

    public void setNewpass(String newpass) {
        this.newpass = newpass;
    }

    public String getOldpass() {
        return oldpass;
    }

    public void setOldpass(String oldpass) {
        this.oldpass = oldpass;
    }
}

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wadia.metier;

import java.io.Serializable;
import java.util.Date;

/**
 *
 * @author ITR2012
 */
public class WarningHrMetier implements Serializable {
     private String name;
     private String surname;
     private String username;
     private String EmployStatut;
     private int totalWarning;
     private Integer warningId;
     private Date date;
     private String warningType;
     private String sevirity;
     private String raison;

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return the surname
     */
    public String getSurname() {
        return surname;
    }

    /**
     * @param surname the surname to set
     */
    public void setSurname(String surname) {
        this.surname = surname;
    }

    /**
     * @return the username
     */
    public String getUsername() {
        return username;
    }

    /**
     * @param username the username to set
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * @return the EmployStatut
     */
    public String getEmployStatut() {
        return EmployStatut;
    }

    /**
     * @param EmployStatut the EmployStatut to set
     */
    public void setEmployStatut(String EmployStatut) {
        this.EmployStatut = EmployStatut;
    }

   
    /**
     * @return the warningId
     */
    public Integer getWarningId() {
        return warningId;
    }

    /**
     * @param warningId the warningId to set
     */
    public void setWarningId(Integer warningId) {
        this.warningId = warningId;
    }

    /**
     * @return the date
     */
    public Date getDate() {
        return date;
    }

    /**
     * @param date the date to set
     */
    public void setDate(Date date) {
        this.date = date;
    }

    /**
     * @return the warningType
     */
    public String getWarningType() {
        return warningType;
    }

    /**
     * @param warningType the warningType to set
     */
    public void setWarningType(String warningType) {
        this.warningType = warningType;
    }

    /**
     * @return the sevirity
     */
    public String getSevirity() {
        return sevirity;
    }

    /**
     * @param sevirity the sevirity to set
     */
    public void setSevirity(String sevirity) {
        this.sevirity = sevirity;
    }

    /**
     * @return the raison
     */
    public String getRaison() {
        return raison;
    }

    /**
     * @param raison the raison to set
     */
    public void setRaison(String raison) {
        this.raison = raison;
    }

    /**
     * @return the totalWarning
     */
    public int getTotalWarning() {
        return totalWarning;
    }

    /**
     * @param totalWarning the totalWarning to set
     */
    public void setTotalWarning(int totalWarning) {
        this.totalWarning = totalWarning;
    }
     
}

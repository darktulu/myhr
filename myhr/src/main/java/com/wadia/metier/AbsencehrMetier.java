/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wadia.metier;

import java.util.Date;

/**
 *
 * @author ITR2012
 */
public class AbsencehrMetier {
    private String name;
     private String surname;
     private String username;
     private String EmployStatut;
      private Integer id;
      private int totalAbsence;
     private Date startDay;
     private Date endDay;
     private int nbDays;
     private String justified;
     private String type;
     private String payed;

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
     * @return the id
     */
    public Integer getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * @return the startDay
     */
    public Date getStartDay() {
        return startDay;
    }

    /**
     * @param startDay the startDay to set
     */
    public void setStartDay(Date startDay) {
        this.startDay = startDay;
    }

    /**
     * @return the endDay
     */
    public Date getEndDay() {
        return endDay;
    }

    /**
     * @param endDay the endDay to set
     */
    public void setEndDay(Date endDay) {
        this.endDay = endDay;
    }

    /**
     * @return the nbDays
     */
    public int getNbDays() {
        return nbDays;
    }

    /**
     * @param nbDays the nbDays to set
     */
    public void setNbDays(int nbDays) {
        this.nbDays = nbDays;
    }

    /**
     * @return the justified
     */
    public String getJustified() {
        return justified;
    }

    /**
     * @param justified the justified to set
     */
    public void setJustified(String justified) {
        this.justified = justified;
    }

    /**
     * @return the type
     */
    public String getType() {
        return type;
    }

    /**
     * @param type the type to set
     */
    public void setType(String type) {
        this.type = type;
    }

    /**
     * @return the payed
     */
    public String getPayed() {
        return payed;
    }

    /**
     * @param payed the payed to set
     */
    public void setPayed(String payed) {
        this.payed = payed;
    }

    /**
     * @return the totalAbsence
     */
    public int getTotalAbsence() {
        return totalAbsence;
    }

    /**
     * @param totalAbsence the totalAbsence to set
     */
    public void setTotalAbsence(int totalAbsence) {
        this.totalAbsence = totalAbsence;
    }
    
}

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
public class ContrathrMetier implements Serializable {
     private String name;
     private String surname;
     private String username;
     private String EmployStatut;
     private Integer contractId;
     private Date ContratStratDate;
     private Date contratEndDate;
     private String ContratType;
     private String ContratStatut;

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
     * @return the ContratStratDate
     */
    public Date getContratStratDate() {
        return ContratStratDate;
    }

    /**
     * @param ContratStratDate the ContratStratDate to set
     */
    public void setContratStratDate(Date ContratStratDate) {
        this.ContratStratDate = ContratStratDate;
    }

    /**
     * @return the contratEndDate
     */
    public Date getContratEndDate() {
        return contratEndDate;
    }

    /**
     * @param contratEndDate the contratEndDate to set
     */
    public void setContratEndDate(Date contratEndDate) {
        this.contratEndDate = contratEndDate;
    }

    /**
     * @return the ContratType
     */
    public String getContratType() {
        return ContratType;
    }

    /**
     * @param ContratType the ContratType to set
     */
    public void setContratType(String ContratType) {
        this.ContratType = ContratType;
    }

    /**
     * @return the ContratStatut
     */
    public String getContratStatut() {
        return ContratStatut;
    }

    /**
     * @param ContratStatut the ContratStatut to set
     */
    public void setContratStatut(String ContratStatut) {
        this.ContratStatut = ContratStatut;
    }

    public Integer getContractId() {
        return contractId;
    }

    public void setContractId(Integer contractId) {
        this.contractId = contractId;
    }

    /**
     * @return the contractId
     */

     
    
}

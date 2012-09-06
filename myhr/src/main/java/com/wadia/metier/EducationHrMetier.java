/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wadia.metier;

import java.util.Date;

/**
 *
 * @author massin
 */
public class EducationHrMetier {
     private String name;
     private String surname;
     private String username;
     private String EmployStatut;
     private Integer idEducation;
     private String type;
     private String nameInstitut;
     private String addressInstitut;
     private String courseStudy;
     private Date dateFrom;
     private Date dateTo;
     private boolean certification;

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
     * @return the idEducation
     */
    public Integer getIdEducation() {
        return idEducation;
    }

    /**
     * @param idEducation the idEducation to set
     */
    public void setIdEducation(Integer idEducation) {
        this.idEducation = idEducation;
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
     * @return the nameInstitut
     */
    public String getNameInstitut() {
        return nameInstitut;
    }

    /**
     * @param nameInstitut the nameInstitut to set
     */
    public void setNameInstitut(String nameInstitut) {
        this.nameInstitut = nameInstitut;
    }

    /**
     * @return the addressInstitut
     */
    public String getAddressInstitut() {
        return addressInstitut;
    }

    /**
     * @param addressInstitut the addressInstitut to set
     */
    public void setAddressInstitut(String addressInstitut) {
        this.addressInstitut = addressInstitut;
    }

    /**
     * @return the courseStudy
     */
    public String getCourseStudy() {
        return courseStudy;
    }

    /**
     * @param courseStudy the courseStudy to set
     */
    public void setCourseStudy(String courseStudy) {
        this.courseStudy = courseStudy;
    }

    /**
     * @return the dateFrom
     */
    public Date getDateFrom() {
        return dateFrom;
    }

    /**
     * @param dateFrom the dateFrom to set
     */
    public void setDateFrom(Date dateFrom) {
        this.dateFrom = dateFrom;
    }

    /**
     * @return the dateTo
     */
    public Date getDateTo() {
        return dateTo;
    }

    /**
     * @param dateTo the dateTo to set
     */
    public void setDateTo(Date dateTo) {
        this.dateTo = dateTo;
    }

    /**
     * @return the certification
     */
    public boolean isCertification() {
        return certification;
    }

    /**
     * @param certification the certification to set
     */
    public void setCertification(boolean certification) {
        this.certification = certification;
    }
     
    
}
